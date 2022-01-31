package com.tencent.mobileqq.utils;

import ajpm;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
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
    return (int)(0x3 & paramLong);
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    long l1 = 0L;
    paramBundle = paramBundle.getString("uin");
    paramQQAppInterface = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramBundle);
    int i = -1;
    long l2;
    if (paramQQAppInterface != null)
    {
      l2 = paramQQAppInterface.mOrigin;
      l1 = paramQQAppInterface.mOriginExtra;
      if (b(l2)) {
        i = paramQQAppInterface.mSelfRight;
      }
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putLong("Origin", l2);
      paramQQAppInterface.putLong("OriginExtra", l1);
      paramQQAppInterface.putInt("SelfRight", i);
      if (AudioHelper.e()) {
        QLog.w("QAVHrMeeting", 1, "GetDiscussOrigin, uin[" + paramBundle + "], Origin[" + l2 + "], OriginExtra[" + l1 + "], mSelfRight[" + i + "]");
      }
      return paramQQAppInterface;
      i = 0;
      continue;
      l2 = 0L;
    }
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getResources().getString(2131438785);
  }
  
  public static String a(DiscussionManager paramDiscussionManager, String paramString1, String paramString2)
  {
    paramDiscussionManager = paramDiscussionManager.a(paramString1);
    if (paramDiscussionManager != null)
    {
      paramDiscussionManager = (DiscussionMemberInfo)paramDiscussionManager.get(paramString2);
      if (paramDiscussionManager != null) {
        if (!TextUtils.isEmpty(paramDiscussionManager.inteRemark)) {
          paramDiscussionManager = paramDiscussionManager.inteRemark;
        }
      }
    }
    for (;;)
    {
      paramString1 = paramDiscussionManager;
      if (TextUtils.isEmpty(paramDiscussionManager)) {
        paramString1 = a();
      }
      return paramString1;
      if (!TextUtils.isEmpty(paramDiscussionManager.memberName)) {
        paramDiscussionManager = paramDiscussionManager.memberName;
      } else {
        paramDiscussionManager = "";
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = (DiscussionManager)paramQQAppInterface.getManager(52);
    Object localObject2 = (DiscussionHandler)paramQQAppInterface.a(6);
    QLog.d("QAVHrMeeting", 1, "HR_meeting Finish quit DiscussionId[" + paramLong + "]");
    ((DiscussionHandler)localObject2).c(paramLong);
    ((DiscussionManager)localObject1).c(String.valueOf(paramLong));
    localObject1 = paramQQAppInterface.a().a();
    localObject2 = ((RecentUserProxy)localObject1).b(String.valueOf(paramLong), 3000);
    if (localObject2 != null) {
      ((RecentUserProxy)localObject1).b((RecentUser)localObject2);
    }
    ((DiscussionHandler)paramQQAppInterface.a(6)).b();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, DiscussionInfo paramDiscussionInfo)
  {
    DiscussionInfo localDiscussionInfo = paramDiscussionInfo;
    if (paramDiscussionInfo == null) {
      localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(String.valueOf(paramLong));
    }
    if (localDiscussionInfo == null) {}
    while (((localDiscussionInfo.mOrigin & 0x2) == 2L) || ((localDiscussionInfo.mOrigin & 0x4) != 4L)) {
      return;
    }
    a(paramQQAppInterface, paramLong);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt, long paramLong)
  {
    if (paramInt != 2) {}
    DiscussionInfo localDiscussionInfo;
    do
    {
      return;
      localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(String.valueOf(paramLong));
    } while ((localDiscussionInfo == null) || (!localDiscussionInfo.isDiscussHrMeeting()));
    paramInt = paramIntent.getIntExtra("quitReson", -1);
    if ((paramInt != 20) && (paramInt != 7)) {
      a(paramQQAppInterface, paramLong, localDiscussionInfo);
    }
    if (a(localDiscussionInfo.mSelfRight)) {
      ((DiscussionHandler)paramQQAppInterface.a(6)).a(paramLong);
    }
    QLog.e("QAVHrMeeting", 1, "do Report, lFlag=" + localDiscussionInfo.mOrigin);
    paramLong = paramQQAppInterface.a().a();
    long l = System.currentTimeMillis();
    QQConfMeetingLogReportHelper.a(paramQQAppInterface).a(paramLong, l);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    ((DiscussionHandler)paramQQAppInterface.a(6)).a(Long.valueOf(paramBundle).longValue(), 1);
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
    if ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008) || (paramMessageRecord.istroop != 3000)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.w("QAVHrMeeting", 1, "onMsgUpdae, curFriendUin[" + paramMessageRecord.frienduin + "], senderuin[" + paramMessageRecord.senderuin + "], isSendFromLocal[" + paramMessageRecord.isSendFromLocal() + "], isSend[" + paramMessageRecord.isSend() + "], msgtype[" + paramMessageRecord.msgtype + "], isread[" + paramMessageRecord.isread + "], msgseq[" + paramMessageRecord.msgseq + "], uniseq[" + paramMessageRecord.uniseq + "], msg[" + AudioHelper.a(paramMessageRecord.msg) + "]");
            }
            if (!paramMessageRecord.isSend()) {
              break;
            }
          } while (!paramMessageRecord.isSendFromLocal());
          localObject = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramMessageRecord.frienduin);
        } while ((localObject == null) || (!((DiscussionInfo)localObject).isDiscussHrMeeting()) || (a(((DiscussionInfo)localObject).mSelfRight)) || (((DiscussionInfo)localObject).getHrExtra() != 1));
        ((DiscussionHandler)paramQQAppInterface.a(6)).a(Long.valueOf(paramMessageRecord.frienduin).longValue(), 2);
        return;
      } while (paramMessageRecord.msgtype != -1000);
      localObject = (DiscussionManager)paramQQAppInterface.getManager(52);
      paramMessageRecord = ((DiscussionManager)localObject).a(paramMessageRecord.frienduin);
    } while ((paramMessageRecord == null) || (!paramMessageRecord.isHidden()) || (paramMessageRecord.getHrExtra() != 1));
    paramMessageRecord.mOriginExtra = 2L;
    ((DiscussionManager)localObject).a(paramMessageRecord);
    a("onMsgUpdae", paramQQAppInterface, paramMessageRecord);
    a(paramQQAppInterface, paramMessageRecord.uin);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.a(6);
    paramQQAppInterface.a(1000, true, null);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(paramString);
    localArrayList.add(1, Boolean.valueOf(true));
    paramQQAppInterface.a(1001, true, localArrayList);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, QAVHrMeeting.OnGetNickNameOfMaskDisc paramOnGetNickNameOfMaskDisc)
  {
    AudioHelper.b("获取hr信息_delay_" + paramString2);
    String str = "http://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_nickname_video_meeting_for_hr?uin=" + paramString2 + "&discid=" + paramString1;
    ThreadManager.post(new ajpm("QAVHrMeeting_" + AudioHelper.a(), str, paramString2, paramQQAppInterface, paramString1, paramOnGetNickNameOfMaskDisc), 5, null, false);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    if ((paramDiscussionInfo.mOrigin & 0x2) != 2L) {
      return;
    }
    boolean bool = a(paramDiscussionInfo.mSelfRight);
    long l = paramDiscussionInfo.uiControlFlag;
    DiscussionManager localDiscussionManager;
    if (bool)
    {
      localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(52);
      paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.a(6);
      if (paramDiscussionInfo.getHrExtra() != 1) {
        break label176;
      }
      localDiscussionManager.a(paramDiscussionInfo.uin);
      paramQQAppInterface.a(1004, true, paramDiscussionInfo.uin);
    }
    for (;;)
    {
      QLog.w("QAVHrMeeting", 1, "checkHrConfHidden[" + paramString + "], mSelfRight[" + paramDiscussionInfo.mSelfRight + "][" + bool + "], uiControlFlag[" + l + "->" + paramDiscussionInfo.uiControlFlag + "], getHrExtra[" + paramDiscussionInfo.getHrExtra() + "]");
      return;
      label176:
      localDiscussionManager.b(paramDiscussionInfo.uin);
      Long.parseLong(paramDiscussionInfo.uin);
      paramQQAppInterface = paramDiscussionInfo.discussionName;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -1) || ((paramInt & 0x8) == 8);
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong & 1L) == 1L;
  }
  
  public static int b(long paramLong)
  {
    long l2 = 0L;
    boolean bool = false;
    Object localObject1 = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("uin", String.valueOf(paramLong));
    localObject1 = ((VideoAppInterface)localObject1).a(5, 0, 0, (Bundle)localObject2, null);
    int i = -1;
    long l1;
    if (localObject1 != null)
    {
      l2 = ((Bundle)localObject1).getLong("Origin", 0L);
      l1 = ((Bundle)localObject1).getLong("OriginExtra", 0L);
      i = ((Bundle)localObject1).getInt("SelfRight", 0);
    }
    for (;;)
    {
      localObject2 = new StringBuilder().append("getStasks, relationId[").append(paramLong).append("], mOrigin[").append(l2).append("], mOriginExtra[").append(l1).append("], mSelfRight[").append(i).append("], rsp[");
      if (localObject1 != null) {
        bool = true;
      }
      QLog.w("QAVHrMeeting", 1, bool + "]");
      return i;
      l1 = 0L;
    }
  }
  
  public static boolean b(long paramLong)
  {
    return (0x6 & paramLong) != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVHrMeeting
 * JD-Core Version:    0.7.0.1
 */