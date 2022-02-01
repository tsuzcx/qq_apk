package com.tencent.util;

import android.content.Intent;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.xtab.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class QQKRPUtil
{
  private static int a(int paramInt)
  {
    int i = 3;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return 0;
            }
            return 7;
          }
          return 6;
        }
        return 1;
      }
    }
    else {
      i = 2;
    }
    return i;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramInt == 7220) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramLong);
        a(paramQQAppInterface, "0X80098E4", localStringBuilder.toString(), "", "", "");
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FrameFragment paramFrameFragment, Frame paramFrame, int paramInt)
  {
    try
    {
      if (((((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isKandianTabFrame(paramFrame)) || (paramInt == FrameControllerUtil.g)) && (paramFrameFragment.a(((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).getTabFrame()) != null) && (paramInt == FrameControllerUtil.g) && (paramFrameFragment.C().getIntent().getIntExtra("launch_from", 5) == 6))
      {
        a(paramQQAppInterface, "0X80098E2", "", "", "", "");
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity)
  {
    try
    {
      if ((((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).isReadInJoyNewFeedsActivity(paramQBaseActivity)) && (paramQBaseActivity.getIntent().getIntExtra("launch_from", 5) == 6))
      {
        a(paramQQAppInterface, "0X80098E2", "", "", "", "");
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord.istroop != 7220) && ((paramMessageRecord.istroop != 1008) || (!AppConstants.NEW_KANDIAN_UIN.equals(paramMessageRecord.frienduin))))
      {
        if (paramMessageRecord.istroop == 10007) {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).report(paramQQAppInterface, paramMessageRecord.frienduin, 10006, 1);
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramMessageRecord.msgUid);
        a(paramQQAppInterface, "0X80098E5", localStringBuilder.toString(), "", "", "");
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser != null) {
      try
      {
        if (paramRecentUser.getType() == 7220)
        {
          a(paramQQAppInterface, "0X80098E3", "", "", "", "");
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    if (paramRecentUser != null) {
      try
      {
        int i = paramRecentUser.getType();
        Object localObject;
        if (i == 1008)
        {
          StringBuilder localStringBuilder;
          if ("2173223560".equals(paramRecentBaseData.getRecentUserUin()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("");
            ((StringBuilder)localObject).append(paramRecentBaseData.mUnreadFlag);
            localObject = ((StringBuilder)localObject).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramRecentBaseData.mUnreadNum);
            a(paramQQAppInterface, "0X80098E0", (String)localObject, localStringBuilder.toString(), "", "");
          }
          else if (AppConstants.KANDIAN_DAILY_UIN.equals(paramRecentBaseData.getRecentUserUin()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("");
            ((StringBuilder)localObject).append(paramRecentBaseData.mUnreadFlag);
            localObject = ((StringBuilder)localObject).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramRecentBaseData.mUnreadNum);
            a(paramQQAppInterface, "0X80098F2", (String)localObject, localStringBuilder.toString(), "", "");
          }
        }
        if (paramRecentUser.getType() == 7220)
        {
          paramRecentUser = new StringBuilder();
          paramRecentUser.append("");
          paramRecentUser.append(paramRecentBaseData.mUnreadFlag);
          paramRecentUser = paramRecentUser.toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramRecentBaseData.mUnreadNum);
          a(paramQQAppInterface, "0X80098DF", paramRecentUser, ((StringBuilder)localObject).toString(), "", "");
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, LebaViewItem paramLebaViewItem, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramLebaViewItem.b.strPkgName.equals("com.android.ReadInJoy"))
      {
        paramLebaViewItem = new StringBuilder();
        paramLebaViewItem.append("");
        paramLebaViewItem.append(a(paramInt1));
        paramLebaViewItem = paramLebaViewItem.toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt2);
        a(paramQQAppInterface, "0X80098E6", paramLebaViewItem, localStringBuilder.toString(), "", "");
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.QQKRPUtil
 * JD-Core Version:    0.7.0.1
 */