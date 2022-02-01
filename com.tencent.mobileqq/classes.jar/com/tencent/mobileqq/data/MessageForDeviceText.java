package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import bhca;
import com.tencent.mobileqq.text.QQText;

public class MessageForDeviceText
  extends ChatMessage
{
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForDeviceText";
  public String action;
  public int msgVia;
  public CharSequence sb;
  
  protected void doParse()
  {
    doParse(false);
  }
  
  protected void doParse(boolean paramBoolean)
  {
    Object localObject2 = this.msg;
    Object localObject1 = localObject2;
    if (this.msgtype == -1003)
    {
      localObject1 = bhca.a((String)localObject2);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    this.sb = new QQText((CharSequence)localObject2, 13, 32, this.istroop);
  }
  
  public void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeviceText
 * JD-Core Version:    0.7.0.1
 */