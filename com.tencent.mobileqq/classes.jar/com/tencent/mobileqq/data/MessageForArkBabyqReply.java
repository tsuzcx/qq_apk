package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.service.message.MessageConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForArkBabyqReply
  extends ChatMessage
{
  public String arkMsgId;
  public int arkSearchType;
  public String babyqReplyText;
  public String compatibleMsg;
  public int forwardID;
  public boolean isFailed = false;
  public boolean isSingleApp = true;
  public ArrayList<ArkBabyqCardInfo> mArkBabyqReplyCardList;
  public boolean mHasReportRecv = false;
  public String resIDForLongMsg;
  public boolean showAsBabyq = true;
  
  public void doOnEvent(int paramInt)
  {
    Object localObject = this.mArkBabyqReplyCardList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
        if (localArkBabyqCardInfo != null) {
          localArkBabyqCardInfo.doOnEvent(paramInt);
        }
      }
    }
  }
  
  public void doParse()
  {
    if (this.mArkBabyqReplyCardList == null) {
      this.mArkBabyqReplyCardList = new ArrayList();
    }
    fromBytes(this.msgData);
    this.mHasReportRecv = "1".equals(getExtInfoFromExtStr(MessageConstants.g));
  }
  
  public boolean fromAppXml(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.babyqReplyText = paramString.optString("desc");
      this.arkMsgId = paramString.optString("msgId");
      this.arkSearchType = paramString.optInt("type", 1);
      this.showAsBabyq = paramString.optBoolean("showAsBabyq");
      this.isFailed = paramString.optBoolean("fail");
      paramString = paramString.optJSONArray("apps");
      int i = 0;
      while (i < paramString.length())
      {
        String str = paramString.optString(i);
        ArkBabyqCardInfo localArkBabyqCardInfo = new ArkBabyqCardInfo(this);
        localArkBabyqCardInfo.fromAppXml(str);
        if (this.mArkBabyqReplyCardList == null) {
          this.mArkBabyqReplyCardList = new ArrayList();
        }
        if (i < this.mArkBabyqReplyCardList.size()) {
          this.mArkBabyqReplyCardList.set(i, localArkBabyqCardInfo);
        } else {
          this.mArkBabyqReplyCardList.add(localArkBabyqCardInfo);
        }
        i += 1;
      }
      return true;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean fromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      boolean bool = fromAppXml((String)new ObjectInputStream(paramArrayOfByte).readObject());
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public int getArkBabyqCardCount()
  {
    Object localObject = this.mArkBabyqReplyCardList;
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
        if (localArkBabyqCardInfo != null) {
          i += localArkBabyqCardInfo.getArkBabyqCardCount();
        }
      }
    }
    return j;
  }
  
  public int getArkBabyqCardCountForApp(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 0;
    int i = 0;
    if (bool) {
      return 0;
    }
    Object localObject = this.mArkBabyqReplyCardList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)((Iterator)localObject).next();
        if (localArkBabyqCardInfo != null) {
          i += localArkBabyqCardInfo.getArkBabyqCardCountForApp(paramString);
        }
      }
    }
    return j;
  }
  
  public ArkBabyqCardInfo getArkCardByPosition(int paramInt)
  {
    int i = getArkBabyqCardCount();
    if ((i > 0) && (paramInt >= 0))
    {
      if (paramInt >= i) {
        return null;
      }
      int j = 0;
      i = paramInt;
      paramInt = j;
      while (paramInt < this.mArkBabyqReplyCardList.size())
      {
        ArkBabyqCardInfo localArkBabyqCardInfo = (ArkBabyqCardInfo)this.mArkBabyqReplyCardList.get(paramInt);
        j = localArkBabyqCardInfo.getArkBabyqCardCount();
        if (i < j)
        {
          if (i == 0) {
            return localArkBabyqCardInfo;
          }
          return (ArkBabyqCardInfo)localArkBabyqCardInfo.mExtendedArkBabyqCardList.get(i - 1);
        }
        i -= j;
        paramInt += 1;
      }
    }
    return null;
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.babyqReplyText)) {
      return this.babyqReplyText;
    }
    return BaseApplicationImpl.sApplication.getString(2131690162);
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    this.msgData = toBytes();
    this.msg = this.babyqReplyText;
  }
  
  public String toAppXml()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("desc", this.babyqReplyText);
      ((JSONObject)localObject).put("msgId", this.arkMsgId);
      ((JSONObject)localObject).put("type", this.arkSearchType);
      ((JSONObject)localObject).put("showAsBabyq", this.showAsBabyq);
      ((JSONObject)localObject).put("fail", this.isFailed);
      JSONArray localJSONArray = new JSONArray();
      if (this.mArkBabyqReplyCardList != null)
      {
        int i = 0;
        while (i < this.mArkBabyqReplyCardList.size())
        {
          localJSONArray.put(i, ((ArkBabyqCardInfo)this.mArkBabyqReplyCardList.get(i)).toAppXml());
          i += 1;
        }
      }
      ((JSONObject)localObject).put("apps", localJSONArray);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public byte[] toBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream((OutputStream)localObject).writeObject(toAppXml());
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public byte[] toPbData()
  {
    Object localObject = toAppXml();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((String)localObject).getBytes("utf-8");
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkBabyqReply
 * JD-Core Version:    0.7.0.1
 */