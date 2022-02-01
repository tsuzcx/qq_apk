package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.MessageRecordUtil;

public class MessageForVideo
  extends ChatMessage
{
  private static final String TAG = "MessageForVideo";
  public long businessFlag;
  public long hungUpMs;
  public long hungUpReason;
  public boolean isVideo;
  public long roomId;
  public int switchFlag;
  public String text;
  public int type;
  
  private void doParseInternal()
  {
    Object localObject;
    if (this.msg != null) {
      localObject = this.msg.split("\\|");
    } else {
      localObject = null;
    }
    boolean bool2 = false;
    if ((localObject != null) && (localObject.length > 0)) {
      this.text = localObject[0].trim();
    } else {
      this.text = "";
    }
    if ((localObject != null) && (localObject.length > 1)) {}
    try
    {
      this.type = Integer.parseInt(localObject[1]);
    }
    catch (Exception localException1)
    {
      label75:
      StringBuilder localStringBuilder;
      break label75;
    }
    if ((this.msg != null) && (this.msg.length() > 0) && (this.msg.charAt(0) == '\026'))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java.lang.NumberFormatException: Invalid int: ");
      localStringBuilder.append(localObject[1]);
      localStringBuilder.append(" msg is ");
      localStringBuilder.append(this.msg);
      throw new RuntimeException(localStringBuilder.toString());
    }
    this.type = 5;
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java.lang.NumberFormatException: Invalid int: ");
      localStringBuilder.append(localObject[1]);
      localStringBuilder.append(" msg byte ");
      localStringBuilder.append(MessageRecordUtil.a(this.msg));
      com.tencent.qphone.base.util.QLog.d("MessageForVideo", 2, localStringBuilder.toString());
      break label242;
      this.type = 5;
    }
    label242:
    if ((localObject != null) && (localObject.length > 3))
    {
      if (localObject.length == 4)
      {
        this.isVideo = "1".equals(localObject[3]);
        break label326;
      }
      if (localObject.length <= 5) {}
    }
    try
    {
      bool1 = Boolean.parseBoolean(localObject[5]);
    }
    catch (Exception localException2)
    {
      boolean bool1;
      label289:
      break label289;
    }
    bool1 = false;
    if (!bool1)
    {
      bool1 = bool2;
      if (!localObject[0].contains(HardCodeUtil.a(2131706636))) {}
    }
    else
    {
      bool1 = true;
    }
    this.isVideo = bool1;
    break label326;
    this.isVideo = true;
    label326:
    if ((com.tencent.qphone.base.util.QLog.isColorLevel()) || (com.tencent.qphone.base.util.QLog.isDebugVersion()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("text:= ");
      ((StringBuilder)localObject).append(this.text);
      ((StringBuilder)localObject).append(" isVideo:=");
      ((StringBuilder)localObject).append(this.isVideo);
      ((StringBuilder)localObject).append("type:=");
      ((StringBuilder)localObject).append(this.type);
      com.tencent.qphone.base.util.QLog.d("MessageForVideo", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void doServerParse()
  {
    String str5 = getExtInfoFromExtStr("dav_bubble_room_id");
    String str4 = getExtInfoFromExtStr("dav_bubble_hung_up_reason");
    String str3 = getExtInfoFromExtStr("dav_bubble_hung_up_time");
    String str2 = getExtInfoFromExtStr("dav_bubble_business_flag");
    String str1 = getExtInfoFromExtStr("dav_bubble_switch_flag");
    try
    {
      this.roomId = Long.valueOf(str5).longValue();
    }
    catch (Exception localException5)
    {
      this.roomId = 0L;
      com.tencent.TMG.utils.QLog.e("MessageForVideo", 1, "[doParse] read from db, roomId parse error.", localException5);
    }
    try
    {
      this.hungUpReason = Long.valueOf(str4).longValue();
    }
    catch (Exception localException4)
    {
      this.hungUpReason = 0L;
      com.tencent.TMG.utils.QLog.e("MessageForVideo", 1, "[doParse] read from db, hungUpReasonStr parse error.", localException4);
    }
    try
    {
      this.hungUpMs = Long.valueOf(str3).longValue();
    }
    catch (Exception localException3)
    {
      this.hungUpMs = 0L;
      com.tencent.TMG.utils.QLog.e("MessageForVideo", 1, "[doParse] read from db, hungUpMsStr parse error.", localException3);
    }
    for (;;)
    {
      try
      {
        this.businessFlag = Long.valueOf(str2).longValue();
        if (this.businessFlag != 2L) {
          break label212;
        }
        bool = true;
        this.isVideo = bool;
      }
      catch (Exception localException2)
      {
        this.businessFlag = 0L;
        com.tencent.TMG.utils.QLog.e("MessageForVideo", 1, "[doParse] read from db, businessFlag parse error.", localException2);
      }
      try
      {
        this.switchFlag = Integer.valueOf(str1).intValue();
        return;
      }
      catch (Exception localException1)
      {
        this.switchFlag = 0;
        com.tencent.TMG.utils.QLog.e("MessageForVideo", 1, "[doParse] read from db, switchFlagStr parse error.", localException1);
        return;
      }
      label212:
      boolean bool = false;
    }
  }
  
  private void resetMessageType(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i;
      if (TextUtils.equals(this.selfuin, this.senderuin)) {
        i = 0;
      } else {
        i = 2;
      }
      this.type = i;
    }
  }
  
  protected void doParse()
  {
    boolean bool = isFromServer();
    if (bool) {
      doServerParse();
    }
    doParseInternal();
    resetMessageType(bool);
    if ((com.tencent.qphone.base.util.QLog.isColorLevel()) || (com.tencent.qphone.base.util.QLog.isDebugVersion()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doParse] content: ");
      localStringBuilder.append(getDebugInfo());
      com.tencent.TMG.utils.QLog.d("MessageForVideo", 0, localStringBuilder.toString());
    }
  }
  
  public String getDebugInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer("MessageForVideo{");
    localStringBuffer.append("type = '");
    localStringBuffer.append(this.type);
    localStringBuffer.append('\'');
    localStringBuffer.append(", isVideo = '");
    localStringBuffer.append(this.isVideo);
    localStringBuffer.append('\'');
    localStringBuffer.append(", roomId = '");
    localStringBuffer.append(this.roomId);
    localStringBuffer.append('\'');
    localStringBuffer.append(", hungUpReason = '");
    localStringBuffer.append(this.hungUpReason);
    localStringBuffer.append('\'');
    localStringBuffer.append(", hungUpMs = ");
    localStringBuffer.append(this.hungUpMs);
    localStringBuffer.append('\'');
    localStringBuffer.append(", businessFlag = ");
    localStringBuffer.append(this.businessFlag);
    localStringBuffer.append('\'');
    localStringBuffer.append(", switchFlag = ");
    localStringBuffer.append(this.switchFlag);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public boolean isFromServer()
  {
    long l;
    if (!TextUtils.isEmpty(getExtInfoFromExtStr("dav_bubble_room_id"))) {
      try
      {
        l = Long.valueOf(getExtInfoFromExtStr("dav_bubble_room_id")).longValue();
      }
      catch (Exception localException)
      {
        com.tencent.TMG.utils.QLog.e("MessageForVideo", 1, "[doParse] read from db, roomId parse error.", localException);
      }
    } else {
      l = 0L;
    }
    return l != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVideo
 * JD-Core Version:    0.7.0.1
 */