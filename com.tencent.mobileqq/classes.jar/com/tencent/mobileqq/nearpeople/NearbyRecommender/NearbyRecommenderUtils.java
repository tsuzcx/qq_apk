package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class NearbyRecommenderUtils
{
  public static List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Object.class;
    paramString = FileUtils.a(paramString + "v5.8.nbr", arrayOfClass);
    paramQQAppInterface = localObject;
    if (paramString != null)
    {
      paramQQAppInterface = localObject;
      if (paramString.length == arrayOfClass.length) {
        paramQQAppInterface = (List)paramString[0];
      }
    }
    return paramQQAppInterface;
  }
  
  public static void a(Context paramContext, String paramString, List paramList)
  {
    if (paramList == null) {
      return;
    }
    FileUtils.a(paramString + "v5.8.nbr", new Object[] { paramList });
  }
  
  public static void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return;
      SharedPreferences.Editor localEditor = paramAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).edit();
      i = paramBundle.getInt("key_login_pull_interval", -1);
      if (i != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_login_pull_interval", i);
      }
      j = paramBundle.getInt("key_msgbox_pull_interval", -1);
      if (j != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_msgbox_pull_interval", j);
      }
      k = paramBundle.getInt("key_expiretime", -1);
      if (k != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_expiretime", k);
      }
      l1 = paramBundle.getLong("key_login_pull_time", 0L);
      if (l1 != 0L) {
        localEditor.putLong(paramAppInterface.getCurrentAccountUin() + "_" + "key_login_pull_time", l1);
      }
      l2 = paramBundle.getLong("key_msgbox_pull_time", 0L);
      if (l2 != 0L) {
        localEditor.putLong(paramAppInterface.getCurrentAccountUin() + "_" + "key_msgbox_pull_time", l2);
      }
      String str = paramBundle.getString("key_nearbyrecommender_title");
      if (!TextUtils.isEmpty(str)) {
        localEditor.putString("key_nearbyrecommender_title", str);
      }
      int m = paramBundle.getInt("key_nearbyrecommender_reasontype", -1);
      if (m != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_reasontype", m);
      }
      paramBundle = paramBundle.getString("key_nearbyrecommender_uins");
      if (!"".equals(paramBundle)) {
        localEditor.putString(paramAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_uins", paramBundle);
      }
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.d("NearbyRecommenderUtils", 2, "updateConfigs--->login_pull_interval=" + i + ",msgbox_pull_interval=" + j + ",expiretime=" + k + ",login_pull_time=" + l1 + ",msgbox_pull_time=" + l2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime");
    }
    if (a(paramQQAppInterface))
    {
      int i = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).getInt("key_expiretime", 172800);
      long l3 = System.currentTimeMillis();
      long l2 = 0L;
      Object localObject = paramQQAppInterface.getApplication().getFileStreamPath(paramQQAppInterface.getCurrentAccountUin() + "v5.8.nbr");
      long l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (((File)localObject).exists()) {
          l1 = ((File)localObject).lastModified();
        }
      }
      if (i <= Math.abs(l3 - l1) / 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime-->expire true");
        }
        paramQQAppInterface = paramQQAppInterface.a();
        localObject = paramQQAppInterface.b(AppConstants.G, 1001).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord.msgtype == -4011) {
            paramQQAppInterface.a(localMessageRecord, true);
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "addNearbyRecommenderMsg");
    }
    MessageForNearbyRecommenderTips localMessageForNearbyRecommenderTips = (MessageForNearbyRecommenderTips)MessageRecordFactory.a(-4011);
    long l = MessageCache.a();
    localMessageForNearbyRecommenderTips.init(paramQQAppInterface.getCurrentAccountUin(), AppConstants.ak, AppConstants.ak, "", l, -4011, 1001, l);
    localMessageForNearbyRecommenderTips.isread = true;
    MsgProxyUtils.a(localMessageForNearbyRecommenderTips, false);
    localMessageForNearbyRecommenderTips.readFlag = false;
    localMessageForNearbyRecommenderTips.strBrief = paramString;
    localMessageForNearbyRecommenderTips.uRecommendTime = paramLong;
    localMessageForNearbyRecommenderTips.serial();
    paramQQAppInterface.a().a(localMessageForNearbyRecommenderTips, localMessageForNearbyRecommenderTips.selfuin);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "-----addGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + Utils.a(paramString3));
    }
    long l = MessageCache.a();
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-5007);
    localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, l, -5007, paramInt, l);
    localMessageForGrayTips.isread = paramBoolean2;
    if ((!paramBoolean1) || (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips, false))) {
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().b(AppConstants.G, 1001);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      MessageRecord localMessageRecord;
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)paramQQAppInterface.next();
      } while ((localMessageRecord.msgtype != -4011) || (((MessageForNearbyRecommenderTips)localMessageRecord).readFlag));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyRecommenderUtils", 2, "checkUnreadMsgForNearbyRecommender,resut=" + bool);
      }
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool6 = false;
    int j = 0;
    long l3 = 0L;
    long l4 = 0L;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    long l1 = l4;
    long l2 = l3;
    int i = j;
    boolean bool5 = bool6;
    if (paramInt == 1)
    {
      if (paramQQAppInterface.a().a(AppConstants.G, 1001).msgtype == -4011) {
        bool1 = true;
      }
      if (!bool1) {
        bool2 = a(paramQQAppInterface);
      }
      if (!bool1)
      {
        bool3 = bool2;
        bool4 = bool1;
        l1 = l4;
        l2 = l3;
        i = j;
        bool5 = bool6;
        if (!bool2) {}
      }
      else
      {
        SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
        j = localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_msgbox_pull_interval", 180);
        l3 = localSharedPreferences.getLong(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_msgbox_pull_time", 0L);
        l4 = System.currentTimeMillis();
        if (l3 != 0L)
        {
          bool3 = bool2;
          bool4 = bool1;
          l1 = l4;
          l2 = l3;
          i = j;
          bool5 = bool6;
          if (j > Math.abs(l4 - l3) / 1000L) {}
        }
        else
        {
          bool5 = true;
          i = j;
          l2 = l3;
          l1 = l4;
          bool4 = bool1;
          bool3 = bool2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "isNeedPullNearbyRecommenderData changjing=" + paramInt + ",isLastMessage=" + bool4 + ",hasUnreadMessage=" + bool3 + ",pull_interval=" + i + ",pullTime=" + l2 + ",currentTime=" + l1 + ",result=" + bool5);
    }
    return bool5;
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    int i = localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_reasontype", 0);
    paramQQAppInterface = localSharedPreferences.getString(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_uins", "");
    return new String[] { Integer.toString(i), paramQQAppInterface };
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "setNearbyRecommenderMsgRead");
    }
    paramQQAppInterface = paramQQAppInterface.a();
    QQMessageFacade.Message localMessage = paramQQAppInterface.a(AppConstants.G, 1001);
    Object localObject1;
    if (localMessage.msgtype == -4011) {
      localObject1 = new MessageForNearbyRecommenderTips();
    }
    for (;;)
    {
      try
      {
        ((MessageForNearbyRecommenderTips)localObject1).msgData = localMessage.msgData;
        ((MessageForNearbyRecommenderTips)localObject1).parse();
        if (((MessageForNearbyRecommenderTips)localObject1).readFlag) {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localObject1 = paramQQAppInterface.b(AppConstants.G, 1001);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((MessageRecord)localObject2).msgtype == -4011)
          {
            localObject2 = (MessageForNearbyRecommenderTips)localObject2;
            if (!((MessageForNearbyRecommenderTips)localObject2).readFlag)
            {
              ((MessageForNearbyRecommenderTips)localObject2).readFlag = true;
              ((MessageForNearbyRecommenderTips)localObject2).serial();
              paramQQAppInterface.a(((MessageForNearbyRecommenderTips)localObject2).frienduin, ((MessageForNearbyRecommenderTips)localObject2).istroop, ((MessageForNearbyRecommenderTips)localObject2).uniseq, ((MessageForNearbyRecommenderTips)localObject2).msgData);
            }
          }
        }
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (paramQQAppInterface.a().a(AppConstants.G, 1001).msgtype == -4011) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyRecommenderUtils", 2, "checkShowNearbyRecommender,result=" + bool);
      }
      return bool;
      if (!a(paramQQAppInterface)) {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils
 * JD-Core Version:    0.7.0.1
 */