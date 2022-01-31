package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;

public class TroopBindPublicAccountMgr
  implements Manager
{
  private static final ArrayList a;
  protected SharedPreferences a;
  protected LruCache a;
  protected QQAppInterface a;
  protected TroopManager a;
  protected String a;
  protected HashMap a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public TroopBindPublicAccountMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_troop_bind_pb", 0);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.msgtype == -3006)) {
      return true;
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.istroop == 1) && (localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 43)) {
        return true;
      }
      if ((localMessageForStructing.istroop == 1) && (localMessageForStructing.msgData != null) && (localMessageForStructing.structingMsg == null) && (StructMsgFactory.a(paramMessageRecord.msgData).mMsgServiceID == 43)) {
        return true;
      }
    }
    return false;
  }
  
  public int a(String paramString)
  {
    paramString = paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_temp_follow_state";
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, -1);
  }
  
  public Bundle a(String paramString)
  {
    return (Bundle)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public String a()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong)
  {
    if (!jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong))) {
      jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong));
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_temp_follow_state";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.remove(paramString);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, "deletePubAccTempFollowState:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_temp_follow_state";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        paramInt1 = paramInt1 << 4 | paramInt2;
        localEditor.putInt(paramString, paramInt1);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.tempFollow", 2, "saveTroopTempFollowState:" + paramString + ", " + paramInt1);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.tempFollow", 2, "saveTroopTempFollowState:" + paramString.toString());
          }
        }
      }
      return;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_btm_pbmsg_seq";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putLong(paramString, paramLong);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "setTroopLastPubAccountMsgUniseq:" + paramString + ", " + paramLong);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.bottom", 2, "setTroopLastPubAccountMsgUniseq:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramBundle);
  }
  
  public void a(String paramString, List arg2)
  {
    Object localObject2;
    boolean bool;
    try
    {
      localObject2 = paramString + "_btm_pbmsg_seq";
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong((String)localObject2, -1L);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("checkMovePubMsg2Bottom:").append(paramString).append(", hasPubMsg=");
          if (l <= 0L) {
            break label230;
          }
          bool = true;
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, bool);
        }
        if ((l >= 0L) && (??? != null))
        {
          i = ???.size();
          if (i != 0) {
            break label236;
          }
        }
        return;
      }
      ??? = paramString + "_unread_pbmsg_cnt";
    }
    catch (Exception ???)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBindPublicAccountMgr.bottom", 2, "checkMoveLastPubMsgToBottom:" + ???.toString());
      }
      b(paramString);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt((String)???, 0) == 1) {
          d(paramString);
        }
        return;
      }
      label230:
      bool = false;
      break;
      label236:
      j = ???.size();
      i = 0;
      label246:
      if (i >= j) {
        break label748;
      }
      if (((ChatMessage)???.get(i)).uniseq != l) {
        break label756;
      }
      label271:
      bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBindPublicAccountMgr.bottom", 2, "lastPubMsgIdxInList: lastPubMsgIdx=" + i + ", listSize=" + j + ", inBottomBefore=" + bool);
      }
      ??? = null;
      if (i < 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, 1, l);
        if ((localObject2 instanceof ChatMessage)) {
          ??? = (ChatMessage)localObject2;
        }
        if (!QLog.isColorLevel()) {
          break label753;
        }
        QLog.d("TroopBindPublicAccountMgr.bottom", 2, "queryMsgItemByseq:" + (localObject2 instanceof ChatMessage));
        break label753;
      }
      label410:
      while (??? == null)
      {
        b(paramString);
        return;
        ??? = (ChatMessage)???.remove(i);
      }
      if (bool) {
        break label539;
      }
      ???.add(???);
      i = ???.size();
      if (i > 1)
      {
        l = ((ChatMessage)???.get(i - 2)).shmsgseq;
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l));
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "put2InsertSeqMap:" + paramString + "," + l);
        }
      }
    }
    label539:
    long l = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
    int j = ???.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ChatMessage)???.get(i)).shmsgseq < l) {}
      }
      else
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBindPublicAccountMgr.bottom", 2, "inBottomBefore, lastSeq=" + l + ", insertIdx=" + i);
          }
          if (i < 0) {
            ???.add(???);
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "bottom_one", 0, 0, paramString, "", "", "");
            break;
            if (((ChatMessage)???.get(i)).shmsgseq > l) {
              ???.add(i, ???);
            } else if (((ChatMessage)???.get(i)).shmsgseq == l) {
              ???.add(i + 1, ???);
            }
          }
          i = -1;
        }
        label748:
        i = -1;
        break label271;
        label753:
        break label410;
        label756:
        i += 1;
        break label246;
      }
      i += 1;
    }
  }
  
  public boolean a(long paramLong)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong));
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +63 -> 69
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 30	com/tencent/mobileqq/troop/utils/TroopBindPublicAccountMgr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: invokevirtual 316	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +52 -> 69
    //   20: iconst_1
    //   21: istore_2
    //   22: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +40 -> 65
    //   28: ldc_w 318
    //   31: iconst_2
    //   32: new 60	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 320
    //   42: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 278
    //   52: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload_2
    //   56: invokevirtual 224	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: monitorexit
    //   67: iload_2
    //   68: ireturn
    //   69: iconst_0
    //   70: istore_2
    //   71: goto -49 -> 22
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	TroopBindPublicAccountMgr
    //   0	79	1	paramString	String
    //   21	50	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	74	finally
    //   22	65	74	finally
  }
  
  public boolean a(String arg1, long paramLong)
  {
    String str = ??? + "_btm_pbmsg_seq";
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
      {
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, -1L);
        if ((l > 0L) && (l == paramLong))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        String str = paramString + "_btm_pbmsg_seq";
        localEditor.remove(str);
        localEditor.commit();
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + str);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.bottom", 2, "removeTroopLastPubAccountMsgUniseq:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if (a(paramMessageRecord)) {
        return (a(paramMessageRecord.frienduin, paramMessageRecord.uniseq)) && (!a(paramMessageRecord.uniseq));
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(paramString) != null) {
      return false;
    }
    return true;
  }
  
  public void c(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_unread_pbmsg_cnt";
        int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0) + 1;
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.putInt(paramString, i);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "increaseTroopPubMsgUnreadCount:" + paramString + ", " + i);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "increaseTroopPubMsgUnreadCount:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    synchronized (this.jdField_a_of_type_AndroidContentSharedPreferences)
    {
      try
      {
        paramString = paramString + "_unread_pbmsg_cnt";
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localEditor.remove(paramString);
        localEditor.commit();
        if (QLog.isColorLevel()) {
          QLog.d("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + paramString);
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBindPublicAccountMgr.redDot", 2, "clearTroopPubMsgUnreadCount:" + paramString.toString());
          }
        }
      }
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBindPublicAccountMgr", 2, "setCurentAIOUin:" + paramString);
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr
 * JD-Core Version:    0.7.0.1
 */