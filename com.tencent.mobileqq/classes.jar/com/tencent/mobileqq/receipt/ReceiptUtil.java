package com.tencent.mobileqq.receipt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import java.util.Calendar;
import java.util.Date;

public class ReceiptUtil
{
  private static String a = "ReceiptUtil";
  private static boolean b;
  private static LongSparseArray<Integer> c;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (!b) {
      d(paramQQAppInterface);
    }
    return AIOConfigManager.d;
  }
  
  private static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, QLog.getStackTraceString(paramString));
      }
    }
    return -1L;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSentNum: ");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    c.b(a(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(paramInt));
    paramQQAppInterface.getPreferences().edit().putInt("receipt_msg_sent_num", paramInt).apply();
  }
  
  public static boolean a()
  {
    return AIOConfigManager.c;
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(paramLong2);
    boolean bool = false;
    ((Calendar)localObject1).set(11, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    Object localObject2 = ((Calendar)localObject1).getTime();
    ((Calendar)localObject1).setTimeInMillis(paramLong1);
    ((Calendar)localObject1).set(11, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    if (((Date)localObject2).compareTo(((Calendar)localObject1).getTime()) == 0) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramLong1);
      ((StringBuilder)localObject2).append(" and ");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("isToday? ");
      ((StringBuilder)localObject2).append(bool);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107);
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    if (!b) {
      d(paramQQAppInterface);
    }
    Object localObject = paramQQAppInterface.getPreferences();
    long l1 = ((SharedPreferences)localObject).getLong("receipt_msg_store_time", 0L);
    long l2 = NetConnInfoCenter.getServerTime() * 1000L;
    if (!a(l1, l2))
    {
      a(paramQQAppInterface, 0);
      ((SharedPreferences)localObject).edit().putLong("receipt_msg_store_time", l2).apply();
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLeftNum max is ");
      localStringBuilder.append(a(paramQQAppInterface));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return a(paramQQAppInterface) - e(paramQQAppInterface);
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (!b) {
      d(paramQQAppInterface);
    }
    int i = e(paramQQAppInterface) + 1;
    a(paramQQAppInterface, i);
    if (!QLog.isColorLevel()) {
      return;
    }
    paramQQAppInterface = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("increaseSentNum with result:  ");
    localStringBuilder.append(Integer.toString(i));
    QLog.d(paramQQAppInterface, 2, localStringBuilder.toString());
  }
  
  private static void d(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    c = new LongSparseArray(1);
    int i = localSharedPreferences.getInt("receipt_msg_sent_num", 0);
    c.b(a(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(i));
    b = true;
  }
  
  private static int e(QQAppInterface paramQQAppInterface)
  {
    int i = ((Integer)c.a(a(paramQQAppInterface.getCurrentAccountUin()), Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSentNum is ");
      localStringBuilder.append(i);
      QLog.d(paramQQAppInterface, 2, localStringBuilder.toString());
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptUtil
 * JD-Core Version:    0.7.0.1
 */