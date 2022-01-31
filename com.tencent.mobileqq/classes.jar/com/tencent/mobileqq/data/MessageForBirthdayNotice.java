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
      if (QLog.isColorLevel()) {
        QLog.i("MessageForBirthdayNotice", 2, "MessageForBirthdayNotice doParse feedMsg:" + this.msg);
      }
      this.feedMsg = new JSONObject(this.msg);
      this.friendUin = this.feedMsg.optString("friendUin");
      String str = this.feedMsg.optString("time");
      try
      {
        long l = Long.parseLong(str);
        Date localDate = new SimpleDateFormat("yyyyMMdd").parse(str);
        Calendar.getInstance().setTimeInMillis(l * 24L * 60L * 60L * 1000L);
        this.birthday = new SimpleDateFormat("M月d日").format(localDate);
        this.icon = this.feedMsg.optString("icon");
        this.blessing = this.feedMsg.optString("blessing");
        this.doufu_link = this.feedMsg.optString("link");
        this.background = this.feedMsg.optString("background");
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("MessageForBirthdayNotice", 1, "exception getting time");
          MonitorManager.a().a(19, 9, "解析日期错误 " + str + localException, false);
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForBirthdayNotice", 2, "convert msg to json failed,error msg is:" + localJSONException.getMessage(), localJSONException);
      }
      MonitorManager.a().a(19, 4, " json 解析异常 " + localJSONException, false);
      this.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForBirthdayNotice
 * JD-Core Version:    0.7.0.1
 */