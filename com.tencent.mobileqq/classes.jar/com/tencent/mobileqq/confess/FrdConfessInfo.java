package com.tencent.mobileqq.confess;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import tencent.im.confess.common.RedpointInfo;

public class FrdConfessInfo
{
  public boolean a = false;
  public int b = 0;
  public long c = 0L;
  public int d = 0;
  public String e = "";
  public String f = "";
  public String g = "";
  private String h = null;
  private String i;
  
  public FrdConfessInfo(String paramString)
  {
    this.i = paramString;
  }
  
  public void a()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.h = SharedPreUtils.a(this.i, "confess_config_sp").getString("key_frd_rec_confess_info", "");
    if (!TextUtils.isEmpty(this.h)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.h);
      if (localJSONObject.has("nUnReadCnt")) {
        this.b = localJSONObject.getInt("nUnReadCnt");
      }
      if (localJSONObject.has("lLastMsgTime")) {
        this.c = localJSONObject.getLong("lLastMsgTime");
      }
      if (localJSONObject.has("nTopicId")) {
        this.d = localJSONObject.getInt("nTopicId");
      }
      if (localJSONObject.has("strTopicDesc")) {
        this.g = localJSONObject.getString("strTopicDesc");
      }
      if (localJSONObject.has("strFrdUin")) {
        this.e = localJSONObject.getString("strFrdUin");
      }
      if (localJSONObject.has("strFrdNick")) {
        this.f = localJSONObject.getString("strFrdNick");
      }
    }
    catch (Exception localException)
    {
      label174:
      break label174;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("FrdConfessInfo", 4, String.format(Locale.getDefault(), "init strJsonStr: %s", new Object[] { this.h }));
    }
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    int j;
    if (paramRedTouchItem.unReadFlag) {
      j = paramRedTouchItem.count;
    } else {
      j = 0;
    }
    this.b = j;
    this.c = paramRedTouchItem.lastRecvTime;
    if ((paramRedTouchItem.extMsgs != null) && (paramRedTouchItem.extMsgs.size() > 0))
    {
      Iterator localIterator = paramRedTouchItem.extMsgs.iterator();
      paramRedTouchItem = null;
      j = 0;
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (RedTouchItemExtMsg)localIterator.next();
        if (((RedTouchItemExtMsg)localObject).time > j)
        {
          j = ((RedTouchItemExtMsg)localObject).time;
          paramRedTouchItem = (RedTouchItem)localObject;
        }
      }
      try
      {
        localObject = new RedpointInfo();
        ((RedpointInfo)localObject).mergeFrom(paramRedTouchItem.bytesData);
        if (((RedpointInfo)localObject).data.has())
        {
          paramRedTouchItem = new JSONObject(((RedpointInfo)localObject).data.get());
          if (paramRedTouchItem.has("topicId")) {
            this.d = paramRedTouchItem.getInt("topicId");
          }
          if (paramRedTouchItem.has("topicDesc")) {
            this.g = paramRedTouchItem.getString("topicDesc");
          }
          if (paramRedTouchItem.has("frdUin")) {
            this.e = String.valueOf(paramRedTouchItem.getLong("frdUin"));
          }
          if (paramRedTouchItem.has("frdNick")) {
            this.f = paramRedTouchItem.getString("frdNick");
          }
        }
      }
      catch (Exception paramRedTouchItem)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FrdConfessInfo", 2, paramRedTouchItem, new Object[0]);
        }
      }
    }
    b();
  }
  
  public void b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("nUnReadCnt", this.b);
      localJSONObject.put("lLastMsgTime", this.c);
      localJSONObject.put("nTopicId", this.d);
      localJSONObject.put("strTopicDesc", this.g);
      localJSONObject.put("strFrdUin", this.e);
      localJSONObject.put("strFrdNick", this.f);
      this.h = localJSONObject.toString();
      SharedPreUtils.a(this.i, "confess_config_sp").edit().putString("key_frd_rec_confess_info", this.h).apply();
      label112:
      if (QLog.isColorLevel()) {
        QLog.e("FrdConfessInfo", 2, String.format(Locale.getDefault(), "updateJsonStr str: %s", new Object[] { this.h }));
      }
      return;
    }
    catch (Exception localException)
    {
      break label112;
    }
  }
  
  public boolean c()
  {
    return (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.g));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("{isInit = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", nUnReadCnt = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", lLastMsgTime = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", nTopicId = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", strTopicDesc = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", strFrdUin = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", strFrdNick = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.FrdConfessInfo
 * JD-Core Version:    0.7.0.1
 */