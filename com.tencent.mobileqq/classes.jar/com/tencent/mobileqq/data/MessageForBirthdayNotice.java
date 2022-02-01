package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.MonitorManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForBirthdayNotice
  extends ChatMessage
{
  public static final String MSG_BIRTHDAY_NOTICE_BACKGROUND = "background";
  public static final String MSG_BIRTHDAY_NOTICE_BLESSING = "blessing";
  public static final String MSG_BIRTHDAY_NOTICE_FRIEND_UIN = "friendUin";
  public static final String MSG_BIRTHDAY_NOTICE_ICON = "icon";
  public static final String MSG_BIRTHDAY_NOTICE_LINK = "link";
  public static final String MSG_BIRTHDAY_NOTICE_TIME = "time";
  private static final String TAG = "MessageForBirthdayNotice";
  public String background = "";
  public String birthday = "";
  public String blessing = "";
  public String doufu_link = "";
  public JSONObject feedMsg;
  public String friendUin = "";
  public String icon = "";
  
  public MessageForBirthdayNotice()
  {
    this.msgtype = -7007;
  }
  
  protected void doParse()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("MessageForBirthdayNotice doParse feedMsg:");
        ((StringBuilder)localObject1).append(this.msg);
        QLog.i("MessageForBirthdayNotice", 2, ((StringBuilder)localObject1).toString());
      }
      this.feedMsg = new JSONObject(this.msg);
      this.friendUin = this.feedMsg.optString("friendUin");
      Object localObject1 = this.feedMsg.optString("time");
      try
      {
        long l = Long.parseLong((String)localObject1);
        Date localDate = new SimpleDateFormat("yyyyMMdd").parse((String)localObject1);
        Calendar.getInstance().setTimeInMillis(l * 24L * 60L * 60L * 1000L);
        this.birthday = new SimpleDateFormat("M月d日").format(localDate);
      }
      catch (Exception localException)
      {
        QLog.e("MessageForBirthdayNotice", 1, "exception getting time");
        localObject3 = MonitorManager.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("解析日期错误 ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(localException);
        ((MonitorManager)localObject3).a(19, 9, localStringBuilder.toString(), false);
      }
      this.icon = this.feedMsg.optString("icon");
      this.blessing = this.feedMsg.optString("blessing");
      this.doufu_link = this.feedMsg.optString("link");
      this.background = this.feedMsg.optString("background");
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("convert msg to json failed,error msg is:");
        ((StringBuilder)localObject2).append(localJSONException.getMessage());
        QLog.d("MessageForBirthdayNotice", 2, ((StringBuilder)localObject2).toString(), localJSONException);
      }
      Object localObject2 = MonitorManager.a();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" json 解析异常 ");
      ((StringBuilder)localObject3).append(localJSONException);
      ((MonitorManager)localObject2).a(19, 4, ((StringBuilder)localObject3).toString(), false);
      this.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForBirthdayNotice
 * JD-Core Version:    0.7.0.1
 */