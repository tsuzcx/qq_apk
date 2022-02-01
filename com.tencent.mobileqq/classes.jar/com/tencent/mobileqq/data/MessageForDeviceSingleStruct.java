package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForDeviceSingleStruct
  extends ChatMessage
{
  public static final int DATATYPE_SINGLESTRUCT_PIC = 1;
  public static final int DATATYPE_SINGLESTRUCT_VIDEO = 2;
  private static final String TAG = "MessageForDeviceSingleStruct";
  public long entityID;
  public String ext = "";
  public String faceRect = "";
  public long nAppearTime = MessageCache.c();
  public int nCoverChannelType = 0;
  public long nCoverSessionID = 0L;
  public int nDataType = 1;
  public int nMediaChannelType = 0;
  public long nMediaFileSize = 0L;
  public int nMediaFileStatus = 1;
  public float nMediaProgress = 0.0F;
  public long nMediaSessionID = 0L;
  public String strCoverKey = "";
  public String strCoverKey2;
  public String strCoverMD5 = "";
  public String strCoverPath = "";
  public String strDigest = "";
  public String strFileKey2;
  public String strGuideWords = "";
  public String strMediaFileName = "";
  public String strMediaKey = "";
  public String strMediaPath = "";
  public String strTitle = "";
  public String url = "";
  
  protected void doParse()
  {
    Object localObject;
    try
    {
      MessageForDeviceSingleStruct.SingleStructMsgSerial localSingleStructMsgSerial = (MessageForDeviceSingleStruct.SingleStructMsgSerial)MessagePkgUtils.a(this.msgData);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null)
    {
      this.nDataType = localObject.nDataType;
      this.strTitle = localObject.strTitle;
      this.nAppearTime = localObject.nAppearTime;
      this.strDigest = localObject.strDigest;
      this.strGuideWords = localObject.strGuideWords;
      this.nCoverSessionID = localObject.nCoverSessionID;
      this.strCoverPath = localObject.strCoverPath;
      this.nMediaSessionID = localObject.nMediaSessionID;
      this.strMediaPath = localObject.strMediaPath;
      this.nMediaFileStatus = localObject.nMediaFileStatus;
      this.nMediaProgress = localObject.nMediaProgress;
      this.strMediaFileName = localObject.strMediaFileName;
      this.nMediaFileSize = localObject.nMediaFileSize;
      this.strCoverMD5 = localObject.strCoverMD5;
      this.nMediaChannelType = localObject.nMediaChannelType;
      this.nCoverChannelType = localObject.nCoverChannelType;
      this.strMediaKey = localObject.strMediaKey;
      this.strCoverKey = localObject.strCoverKey;
      this.strFileKey2 = localObject.strFileKey2;
      this.strCoverKey2 = localObject.strCoverKey2;
      this.ext = localObject.ext;
      this.msg = localObject.strRecentMsg;
      this.faceRect = localObject.faceRect;
      this.url = localObject.url;
    }
  }
  
  public boolean parseFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.time = paramString.optLong("msg_time", MessageCache.c());
      this.strTitle = paramString.optString("title", HardCodeUtil.a(2131904479));
      localObject = paramString.optString("data_type", "");
      this.nDataType = 1;
      if (((String)localObject).compareToIgnoreCase("PICTURE") == 0) {
        this.nDataType = 1;
      } else if (((String)localObject).compareToIgnoreCase("VIDEO") == 0) {
        this.nDataType = 2;
      }
      this.nAppearTime = paramString.optLong("appear_time", MessageCache.c());
      this.strDigest = paramString.optString("digest", "");
      this.strGuideWords = paramString.optString("guidewords", "");
      localObject = paramString.optString("cover_key", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.strCoverKey = ((String)localObject);
        this.nCoverChannelType = 1;
      }
      localObject = paramString.optString("media_key", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.strMediaKey = ((String)localObject);
        this.nMediaChannelType = 1;
      }
      localObject = paramString.optString("cover_url", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.strCoverKey = ((String)localObject);
        this.nCoverChannelType = 2;
      }
      localObject = paramString.optString("media_url", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.strMediaKey = ((String)localObject);
        this.nMediaChannelType = 2;
      }
      localObject = paramString.optString("cover_mini", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.strCoverKey = ((String)localObject);
        this.nCoverChannelType = 3;
        localObject = paramString.optString("ckey2", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.strCoverKey2 = ((String)localObject);
        }
      }
      localObject = paramString.optString("media_mini", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.strMediaKey = ((String)localObject);
        this.nMediaChannelType = 3;
        localObject = paramString.optString("fkey2", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.strFileKey2 = ((String)localObject);
        }
      }
      localObject = paramString.optJSONArray("face");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0) && (!((JSONArray)localObject).isNull(0)))
      {
        localObject = ((JSONArray)localObject).optJSONObject(0).toString();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.faceRect = ((String)localObject);
        }
      }
      this.url = paramString.optString("url", "");
      this.ext = paramString.optString("ext", "");
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getString from json Exception error:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("MessageForDeviceSingleStruct", 2, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    catch (JSONException paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getString from json JSONException error:");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("MessageForDeviceSingleStruct", 2, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    MessageForDeviceSingleStruct.SingleStructMsgSerial localSingleStructMsgSerial = new MessageForDeviceSingleStruct.SingleStructMsgSerial(null);
    localSingleStructMsgSerial.nDataType = this.nDataType;
    localSingleStructMsgSerial.strTitle = this.strTitle;
    localSingleStructMsgSerial.nAppearTime = this.nAppearTime;
    localSingleStructMsgSerial.strDigest = this.strDigest;
    localSingleStructMsgSerial.strGuideWords = this.strGuideWords;
    localSingleStructMsgSerial.nCoverSessionID = this.nCoverSessionID;
    localSingleStructMsgSerial.strMediaKey = this.strMediaKey;
    localSingleStructMsgSerial.strCoverPath = this.strCoverPath;
    localSingleStructMsgSerial.strFileKey2 = this.strFileKey2;
    localSingleStructMsgSerial.strCoverKey2 = this.strCoverKey2;
    localSingleStructMsgSerial.nMediaSessionID = this.nMediaSessionID;
    localSingleStructMsgSerial.strCoverKey = this.strCoverKey;
    localSingleStructMsgSerial.strMediaPath = this.strMediaPath;
    localSingleStructMsgSerial.nMediaFileStatus = this.nMediaFileStatus;
    localSingleStructMsgSerial.nMediaProgress = this.nMediaProgress;
    localSingleStructMsgSerial.strMediaFileName = this.strMediaFileName;
    localSingleStructMsgSerial.nMediaFileSize = this.nMediaFileSize;
    localSingleStructMsgSerial.strCoverMD5 = this.strCoverMD5;
    localSingleStructMsgSerial.nMediaChannelType = this.nMediaChannelType;
    localSingleStructMsgSerial.nCoverChannelType = this.nCoverChannelType;
    localSingleStructMsgSerial.strRecentMsg = this.msg;
    localSingleStructMsgSerial.faceRect = this.faceRect;
    localSingleStructMsgSerial.url = this.url;
    localSingleStructMsgSerial.ext = this.ext;
    try
    {
      this.msgData = MessagePkgUtils.a(localSingleStructMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeviceSingleStruct
 * JD-Core Version:    0.7.0.1
 */