package com.tencent.mobileqq.nearpeople.NearbyRecommender;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class NearbyRecommenderUtils
{
  public static void a(Context paramContext, String paramString, List<Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append("v5.8.nbr");
    FileUtils.writeObjectList(paramContext.toString(), new Object[] { paramList });
  }
  
  public static void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    SharedPreferences.Editor localEditor = paramAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).edit();
    int i = paramBundle.getInt("key_login_pull_interval", -1);
    if (i != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("key_login_pull_interval");
      localEditor.putInt(((StringBuilder)localObject).toString(), i);
    }
    int j = paramBundle.getInt("key_msgbox_pull_interval", -1);
    if (j != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("key_msgbox_pull_interval");
      localEditor.putInt(((StringBuilder)localObject).toString(), j);
    }
    int k = paramBundle.getInt("key_expiretime", -1);
    if (k != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("key_expiretime");
      localEditor.putInt(((StringBuilder)localObject).toString(), k);
    }
    long l1 = paramBundle.getLong("key_login_pull_time", 0L);
    if (l1 != 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("key_login_pull_time");
      localEditor.putLong(((StringBuilder)localObject).toString(), l1);
    }
    long l2 = paramBundle.getLong("key_msgbox_pull_time", 0L);
    if (l2 != 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("key_msgbox_pull_time");
      localEditor.putLong(((StringBuilder)localObject).toString(), l2);
    }
    Object localObject = paramBundle.getString("key_nearbyrecommender_title");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localEditor.putString("key_nearbyrecommender_title", (String)localObject);
    }
    int m = paramBundle.getInt("key_nearbyrecommender_reasontype", -1);
    if (m != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("key_nearbyrecommender_reasontype");
      localEditor.putInt(((StringBuilder)localObject).toString(), m);
    }
    paramBundle = paramBundle.getString("key_nearbyrecommender_uins");
    if (!"".equals(paramBundle))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("key_nearbyrecommender_uins");
      localEditor.putString(((StringBuilder)localObject).toString(), paramBundle);
    }
    localEditor.commit();
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("updateConfigs--->login_pull_interval=");
      paramAppInterface.append(i);
      paramAppInterface.append(",msgbox_pull_interval=");
      paramAppInterface.append(j);
      paramAppInterface.append(",expiretime=");
      paramAppInterface.append(k);
      paramAppInterface.append(",login_pull_time=");
      paramAppInterface.append(l1);
      paramAppInterface.append(",msgbox_pull_time=");
      paramAppInterface.append(l2);
      QLog.d("NearbyRecommenderUtils", 2, paramAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "addNearbyRecommenderMsg");
    }
    MessageForNearbyRecommenderTips localMessageForNearbyRecommenderTips = (MessageForNearbyRecommenderTips)MessageRecordFactory.a(-4011);
    long l = MessageCache.c();
    localMessageForNearbyRecommenderTips.init(paramQQAppInterface.getCurrentAccountUin(), AppConstants.LBS_NEARBY_RECOMMEND_UIN, AppConstants.LBS_NEARBY_RECOMMEND_UIN, "", l, -4011, 1001, l);
    localMessageForNearbyRecommenderTips.isread = true;
    MsgProxyUtils.a(localMessageForNearbyRecommenderTips, false);
    localMessageForNearbyRecommenderTips.readFlag = false;
    localMessageForNearbyRecommenderTips.strBrief = paramString;
    localMessageForNearbyRecommenderTips.uRecommendTime = paramLong;
    localMessageForNearbyRecommenderTips.serial();
    paramQQAppInterface.getMessageFacade().a(localMessageForNearbyRecommenderTips, localMessageForNearbyRecommenderTips.selfuin);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-----addGrayTipsMessage  frienduin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" istroop：");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" msg:");
      ((StringBuilder)localObject).append(MessageRecordUtil.a(paramString3));
      QLog.d("NearbyRecommenderUtils", 2, ((StringBuilder)localObject).toString());
    }
    long l = MessageCache.c();
    Object localObject = (MessageForGrayTips)MessageRecordFactory.a(-5007);
    ((MessageForGrayTips)localObject).init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, l, -5007, paramInt, l);
    ((MessageForGrayTips)localObject).isread = paramBoolean2;
    if (paramBoolean1) {
      if (MessageHandlerUtils.a(paramQQAppInterface, (MessageRecord)localObject, false)) {
        return;
      }
    }
    paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().h(AppConstants.LBS_HELLO_UIN, 1001);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.next();
        if ((localMessageRecord.msgtype == -4011) && (!((MessageForNearbyRecommenderTips)localMessageRecord).readFlag))
        {
          bool = true;
          break label83;
        }
      }
    }
    boolean bool = false;
    label83:
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkUnreadMsgForNearbyRecommender,resut=");
      paramQQAppInterface.append(bool);
      QLog.d("NearbyRecommenderUtils", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool3 = true;
    long l2 = 0L;
    int j = 0;
    int i = 0;
    boolean bool1;
    boolean bool2;
    long l1;
    if (paramInt == 1)
    {
      if (paramQQAppInterface.getMessageFacade().getLastMessage(AppConstants.LBS_HELLO_UIN, 1001).msgtype == -4011) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (!bool1) {
        bool2 = a(paramQQAppInterface);
      } else {
        bool2 = false;
      }
      if ((!bool1) && (!bool2)) {
        l1 = 0L;
      }
      for (;;)
      {
        bool3 = false;
        break;
        SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append("key_msgbox_pull_interval");
        i = localSharedPreferences.getInt(localStringBuilder.toString(), 180);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append("key_msgbox_pull_time");
        l2 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
        l1 = System.currentTimeMillis();
        if ((l2 == 0L) || (i <= Math.abs(l1 - l2) / 1000L)) {
          break;
        }
      }
    }
    else
    {
      l1 = 0L;
      bool3 = false;
      bool1 = false;
      bool2 = false;
      i = j;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isNeedPullNearbyRecommenderData changjing=");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append(",isLastMessage=");
      paramQQAppInterface.append(bool1);
      paramQQAppInterface.append(",hasUnreadMessage=");
      paramQQAppInterface.append(bool2);
      paramQQAppInterface.append(",pull_interval=");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(",pullTime=");
      paramQQAppInterface.append(l2);
      paramQQAppInterface.append(",currentTime=");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append(",result=");
      paramQQAppInterface.append(bool3);
      QLog.d("NearbyRecommenderUtils", 2, paramQQAppInterface.toString());
    }
    return bool3;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime");
    }
    if (a(paramQQAppInterface))
    {
      int i = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).getInt("key_expiretime", 172800);
      long l3 = System.currentTimeMillis();
      long l2 = 0L;
      Object localObject1 = paramQQAppInterface.getApplication();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("v5.8.nbr");
      localObject1 = ((MobileQQ)localObject1).getFileStreamPath(((StringBuilder)localObject2).toString());
      long l1 = l2;
      if (localObject1 != null)
      {
        l1 = l2;
        if (((File)localObject1).exists()) {
          l1 = ((File)localObject1).lastModified();
        }
      }
      if (i <= Math.abs(l3 - l1) / 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime-->expire true");
        }
        paramQQAppInterface = paramQQAppInterface.getMessageFacade();
        localObject1 = paramQQAppInterface.h(AppConstants.LBS_HELLO_UIN, 1001).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((MessageRecord)localObject2).msgtype == -4011) {
            paramQQAppInterface.a((MessageRecord)localObject2, true);
          }
        }
      }
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    int i = paramQQAppInterface.getMessageFacade().getLastMessage(AppConstants.LBS_HELLO_UIN, 1001).msgtype;
    boolean bool = true;
    if ((i != -4011) && (!a(paramQQAppInterface))) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("checkShowNearbyRecommender,result=");
      paramQQAppInterface.append(bool);
      QLog.d("NearbyRecommenderUtils", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "setNearbyRecommenderMsgRead");
    }
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    Message localMessage = paramQQAppInterface.getLastMessage(AppConstants.LBS_HELLO_UIN, 1001);
    if (localMessage.msgtype == -4011)
    {
      localObject1 = new MessageForNearbyRecommenderTips();
      try
      {
        ((MessageForNearbyRecommenderTips)localObject1).msgData = localMessage.msgData;
        ((MessageForNearbyRecommenderTips)localObject1).parse();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (((MessageForNearbyRecommenderTips)localObject1).readFlag) {
        return;
      }
    }
    Object localObject1 = paramQQAppInterface.h(AppConstants.LBS_HELLO_UIN, 1001);
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
  
  public static String[] e(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("key_nearbyrecommender_reasontype");
    int i = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append("key_nearbyrecommender_uins");
    paramQQAppInterface = localSharedPreferences.getString(localStringBuilder.toString(), "");
    return new String[] { Integer.toString(i), paramQQAppInterface };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils
 * JD-Core Version:    0.7.0.1
 */