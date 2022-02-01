package com.tencent.mobileqq.guild.message;

import android.text.TextUtils;
import com.tencent.imcore.message.MsgProxyUtils.Callback;
import com.tencent.imcore.message.msgproxy.MsgProxyUtilsDummyCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildMsgProxyUtils
{
  public static MsgProxyUtils.Callback a = new MsgProxyUtilsDummyCallback();
  public static final int[] b = { -4028, -4009 };
  
  private static int a()
  {
    return a.a();
  }
  
  public static void a(MsgProxyUtils.Callback paramCallback)
  {
    a = paramCallback;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    int[] arrayOfInt = b;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramMessageRecord.msgtype) {
        return true;
      }
      i += 1;
    }
    return b(paramMessageRecord);
  }
  
  private static boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.msgtype != paramMessageRecord2.msgtype) {
      return false;
    }
    String str1 = paramMessageRecord1.msg;
    String str2 = paramMessageRecord2.msg;
    if (paramMessageRecord2.msgtype == -1000) {
      return TextUtils.equals(str1, str2);
    }
    return a.a(paramMessageRecord1, paramMessageRecord2, str1, str2);
  }
  
  private static boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.senderuin != null)
    {
      if (paramMessageRecord2.senderuin == null) {
        return false;
      }
      String str = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
      if (paramMessageRecord1.senderuin.equals(paramMessageRecord2.senderuin)) {
        return true;
      }
      if ((paramMessageRecord1.senderuin.equals(paramAppRuntime.getCurrentUin())) && (paramMessageRecord2.senderuin.equals(str))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramMessageRecord1.frienduin;
    boolean bool2 = false;
    boolean bool1 = false;
    if ((str != null) && (paramMessageRecord1.frienduin.equals(paramMessageRecord2.frienduin)))
    {
      if (!paramBoolean1)
      {
        if (!paramBoolean2)
        {
          paramBoolean1 = bool1;
          if (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) < 30L)
          {
            paramBoolean1 = bool1;
            if (a(paramMessageRecord1, paramMessageRecord2)) {
              paramBoolean1 = true;
            }
          }
          return paramBoolean1;
        }
        if (paramMessageRecord1.shmsgseq == paramMessageRecord2.shmsgseq)
        {
          if (paramMessageRecord1.msgtype == paramMessageRecord2.msgtype) {
            return true;
          }
          if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2007)) {
            return true;
          }
          if (paramMessageRecord1.msgtype != -2006)
          {
            if (paramMessageRecord2.msgtype == -2006) {
              return true;
            }
            if ((paramMessageRecord1.msgtype == -1000) && (paramMessageRecord2.msgtype == -2011)) {
              return true;
            }
            if (c(paramMessageRecord1)) {
              return true;
            }
            if ((paramMessageRecord2.msgtype == -1051) && ((paramMessageRecord1.msgtype == -1000) || (paramMessageRecord1.msgtype == -2011))) {
              return true;
            }
            if ((paramMessageRecord1.msgtype == -2011) && (paramMessageRecord2.msgtype == -1000)) {
              return true;
            }
            if ((paramMessageRecord2.msgtype == -1051) && (paramMessageRecord1.msgtype == -1035)) {
              return true;
            }
            return (paramMessageRecord1.msgtype == -1051) && (paramMessageRecord2.msgtype == -1035);
          }
          return true;
        }
        return false;
      }
      if (!paramMessageRecord1.isSendFromLocal())
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. isSendFromLocal == false.");
        }
        return false;
      }
      if ((paramMessageRecord1.extraflag != 32772) && (paramMessageRecord1.extraflag != 32768)) {
        if (paramMessageRecord1.msgtype == -1035)
        {
          if (paramMessageRecord1.extraflag != 32770)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. mixMsg cachRecord extraflag doesn't equal to SEND.");
            }
            return false;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. nomalMsg cachRecord extraflag doesn't equal to SEND.");
          }
          return false;
        }
      }
      if (paramMessageRecord1.msgtype == -2006)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. msgType == 0x7F.");
        }
        return false;
      }
      if (!a(paramAppRuntime, paramMessageRecord1, paramMessageRecord2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. compSenderUin == false.");
        }
        return false;
      }
      if ((paramMessageRecord2.msgUid != 0L) && (paramMessageRecord1.msgUid == paramMessageRecord2.msgUid))
      {
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("compTroopMsgContent RewriteSeq: find msg by uid=");
          paramAppRuntime.append(paramMessageRecord1.msgUid);
          QLog.d("GuildMsgProxyUtils", 2, paramAppRuntime.toString());
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuildMsgProxyUtils", 2, "compTroopMsgContent RewriteSeq: find msg by time");
      }
      if (Math.abs(paramMessageRecord1.time - paramMessageRecord2.time) >= a() + 30)
      {
        paramBoolean1 = bool2;
        if (Math.abs(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) >= 2L) {}
      }
      else
      {
        paramBoolean1 = bool2;
        if (a(paramMessageRecord1, paramMessageRecord2)) {
          paramBoolean1 = true;
        }
      }
      return paramBoolean1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent FAILED. frienduin doesn't equal.");
    }
    return false;
  }
  
  private static boolean b(MessageRecord paramMessageRecord)
  {
    return a.c(paramMessageRecord);
  }
  
  private static boolean c(MessageRecord paramMessageRecord)
  {
    return a.d(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildMsgProxyUtils
 * JD-Core Version:    0.7.0.1
 */