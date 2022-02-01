package com.tencent.mobileqq.utils;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class QAVHrMeeting
{
  public static int a(long paramLong)
  {
    return (int)(paramLong & 0x3);
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramBundle);
    long l1 = 0L;
    long l2;
    int i;
    if (paramQQAppInterface != null)
    {
      l1 = paramQQAppInterface.mOrigin;
      l2 = paramQQAppInterface.mOriginExtra;
      if (b(l1)) {
        i = paramQQAppInterface.mSelfRight;
      } else {
        i = 0;
      }
    }
    else
    {
      i = -1;
      l2 = 0L;
    }
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putLong("Origin", l1);
    paramQQAppInterface.putLong("OriginExtra", l2);
    paramQQAppInterface.putInt("SelfRight", i);
    if (QQAudioHelper.c())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GetDiscussOrigin, uin[");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("], Origin[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], OriginExtra[");
      localStringBuilder.append(l2);
      localStringBuilder.append("], mSelfRight[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w("QAVHrMeeting", 1, localStringBuilder.toString());
    }
    return paramQQAppInterface;
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getResources().getString(2131693232);
  }
  
  public static String a(DiscussionManager paramDiscussionManager, String paramString1, String paramString2)
  {
    paramDiscussionManager = paramDiscussionManager.a(paramString1);
    if (paramDiscussionManager != null)
    {
      paramDiscussionManager = (DiscussionMemberInfo)paramDiscussionManager.get(paramString2);
      if (paramDiscussionManager != null)
      {
        if (!TextUtils.isEmpty(paramDiscussionManager.inteRemark))
        {
          paramDiscussionManager = paramDiscussionManager.inteRemark;
          break label64;
        }
        if (!TextUtils.isEmpty(paramDiscussionManager.memberName))
        {
          paramDiscussionManager = paramDiscussionManager.memberName;
          break label64;
        }
      }
    }
    paramDiscussionManager = "";
    label64:
    paramString1 = paramDiscussionManager;
    if (TextUtils.isEmpty(paramDiscussionManager)) {
      paramString1 = a();
    }
    return paramString1;
  }
  
  static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    Object localObject2 = (DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HR_meeting Finish quit DiscussionId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.d("QAVHrMeeting", 1, localStringBuilder.toString());
    ((DiscussionHandler)localObject2).c(paramLong);
    ((DiscussionManager)localObject1).c(String.valueOf(paramLong));
    localObject1 = paramQQAppInterface.getProxyManager().a();
    localObject2 = ((RecentUserProxy)localObject1).b(String.valueOf(paramLong), 3000);
    if (localObject2 != null) {
      ((RecentUserProxy)localObject1).a((RecentUser)localObject2);
    }
    ((DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, DiscussionInfo paramDiscussionInfo)
  {
    DiscussionInfo localDiscussionInfo = paramDiscussionInfo;
    if (paramDiscussionInfo == null) {
      localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(String.valueOf(paramLong));
    }
    if (localDiscussionInfo == null) {
      return;
    }
    if ((localDiscussionInfo.mOrigin & 0x2) == 2L) {
      return;
    }
    if ((localDiscussionInfo.mOrigin & 0x4) == 4L) {
      a(paramQQAppInterface, paramLong);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt, long paramLong)
  {
    if (paramInt != 2) {
      return;
    }
    DiscussionInfo localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(String.valueOf(paramLong));
    if ((localDiscussionInfo != null) && (localDiscussionInfo.isDiscussHrMeeting()))
    {
      paramInt = paramIntent.getIntExtra("quitReson", -1);
      if ((paramInt != 20) && (paramInt != 7)) {
        a(paramQQAppInterface, paramLong, localDiscussionInfo);
      }
      if (a(localDiscussionInfo.mSelfRight)) {
        ((DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(paramLong);
      }
      paramIntent = new StringBuilder();
      paramIntent.append("do Report, lFlag=");
      paramIntent.append(localDiscussionInfo.mOrigin);
      QLog.e("QAVHrMeeting", 1, paramIntent.toString());
      paramLong = paramQQAppInterface.getAVNotifyCenter().a();
      long l = System.currentTimeMillis();
      QQConfMeetingLogReportHelper.a(paramQQAppInterface).a(paramLong, l);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    ((DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(Long.valueOf(paramBundle).longValue(), 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    if (!paramDiscussionInfo.isDiscussHrMeeting()) {
      return;
    }
    paramDiscussionMemberInfo.memberName = a();
    paramDiscussionMemberInfo.inteRemark = paramDiscussionMemberInfo.memberName;
    a(paramQQAppInterface, paramDiscussionInfo.uin, paramDiscussionMemberInfo.memberUin, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008))
    {
      if (paramMessageRecord.istroop != 3000) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onMsgUpdae, curFriendUin[");
        ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
        ((StringBuilder)localObject).append("], senderuin[");
        ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
        ((StringBuilder)localObject).append("], isSendFromLocal[");
        ((StringBuilder)localObject).append(paramMessageRecord.isSendFromLocal());
        ((StringBuilder)localObject).append("], isSend[");
        ((StringBuilder)localObject).append(paramMessageRecord.isSend());
        ((StringBuilder)localObject).append("], msgtype[");
        ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
        ((StringBuilder)localObject).append("], isread[");
        ((StringBuilder)localObject).append(paramMessageRecord.isread);
        ((StringBuilder)localObject).append("], msgseq[");
        ((StringBuilder)localObject).append(paramMessageRecord.msgseq);
        ((StringBuilder)localObject).append("], uniseq[");
        ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
        ((StringBuilder)localObject).append("], msg[");
        ((StringBuilder)localObject).append(QQAudioHelper.a(paramMessageRecord.msg));
        ((StringBuilder)localObject).append("]");
        QLog.w("QAVHrMeeting", 1, ((StringBuilder)localObject).toString());
      }
      if (paramMessageRecord.isSend())
      {
        if (!paramMessageRecord.isSendFromLocal()) {
          return;
        }
        localObject = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramMessageRecord.frienduin);
        if ((localObject != null) && (((DiscussionInfo)localObject).isDiscussHrMeeting()))
        {
          if (a(((DiscussionInfo)localObject).mSelfRight)) {
            return;
          }
          if (((DiscussionInfo)localObject).getHrExtra() != 1) {
            return;
          }
          ((DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(Long.valueOf(paramMessageRecord.frienduin).longValue(), 2);
          return;
        }
        return;
      }
      if (paramMessageRecord.msgtype != -1000) {
        return;
      }
      Object localObject = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      paramMessageRecord = ((DiscussionManager)localObject).a(paramMessageRecord.frienduin);
      if ((paramMessageRecord != null) && (paramMessageRecord.isHidden()))
      {
        if (paramMessageRecord.getHrExtra() != 1) {
          return;
        }
        paramMessageRecord.mOriginExtra = 2L;
        ((DiscussionManager)localObject).a(paramMessageRecord);
        a("onMsgUpdae", paramQQAppInterface, paramMessageRecord);
        a(paramQQAppInterface, paramMessageRecord.uin);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    paramQQAppInterface.notifyUI(1000, true, null);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(paramString);
    localArrayList.add(1, Boolean.valueOf(true));
    paramQQAppInterface.notifyUI(1001, true, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, QAVHrMeeting.OnGetNickNameOfMaskDisc paramOnGetNickNameOfMaskDisc)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("获取hr信息_delay_");
    ((StringBuilder)localObject).append(paramString2);
    QQAudioHelper.b(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_nickname_video_meeting_for_hr?uin=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("&discid=");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QAVHrMeeting_");
    localStringBuilder.append(QQAudioHelper.b());
    ThreadManager.post(new QAVHrMeeting.1(localStringBuilder.toString(), (String)localObject, paramString2, paramQQAppInterface, paramString1, paramOnGetNickNameOfMaskDisc), 5, null, false);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    if ((paramDiscussionInfo.mOrigin & 0x2) != 2L) {
      return;
    }
    boolean bool = a(paramDiscussionInfo.mSelfRight);
    long l = paramDiscussionInfo.uiControlFlag;
    if (bool)
    {
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      if (paramDiscussionInfo.getHrExtra() == 1)
      {
        localDiscussionManager.a(paramDiscussionInfo.uin);
        paramQQAppInterface.notifyUI(1004, true, paramDiscussionInfo.uin);
      }
      else
      {
        localDiscussionManager.b(paramDiscussionInfo.uin);
        Long.parseLong(paramDiscussionInfo.uin);
        paramQQAppInterface = paramDiscussionInfo.discussionName;
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("checkHrConfHidden[");
    paramQQAppInterface.append(paramString);
    paramQQAppInterface.append("], mSelfRight[");
    paramQQAppInterface.append(paramDiscussionInfo.mSelfRight);
    paramQQAppInterface.append("][");
    paramQQAppInterface.append(bool);
    paramQQAppInterface.append("], uiControlFlag[");
    paramQQAppInterface.append(l);
    paramQQAppInterface.append("->");
    paramQQAppInterface.append(paramDiscussionInfo.uiControlFlag);
    paramQQAppInterface.append("], getHrExtra[");
    paramQQAppInterface.append(paramDiscussionInfo.getHrExtra());
    paramQQAppInterface.append("]");
    QLog.w("QAVHrMeeting", 1, paramQQAppInterface.toString());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -1) || ((paramInt & 0x8) == 8);
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong & 1L) == 1L;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.O == -1) {
      if (paramSessionInfo.E == 2) {
        paramSessionInfo.O = b(paramSessionInfo.f);
      } else {
        paramSessionInfo.O = 0;
      }
    }
    return a(paramSessionInfo.O);
  }
  
  public static int b(long paramLong)
  {
    Object localObject1 = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("uin", String.valueOf(paramLong));
    localObject1 = ((VideoAppInterface)localObject1).a(5, 0, 0, (Bundle)localObject2, null);
    boolean bool = false;
    long l1 = 0L;
    long l2;
    int i;
    if (localObject1 != null)
    {
      l1 = ((Bundle)localObject1).getLong("Origin", 0L);
      l2 = ((Bundle)localObject1).getLong("OriginExtra", 0L);
      i = ((Bundle)localObject1).getInt("SelfRight", 0);
    }
    else
    {
      i = -1;
      l2 = 0L;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getStasks, relationId[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], mOrigin[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("], mOriginExtra[");
    ((StringBuilder)localObject2).append(l2);
    ((StringBuilder)localObject2).append("], mSelfRight[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], rsp[");
    if (localObject1 != null) {
      bool = true;
    }
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("]");
    QLog.w("QAVHrMeeting", 1, ((StringBuilder)localObject2).toString());
    return i;
  }
  
  public static boolean b(long paramLong)
  {
    return (paramLong & 0x6) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVHrMeeting
 * JD-Core Version:    0.7.0.1
 */