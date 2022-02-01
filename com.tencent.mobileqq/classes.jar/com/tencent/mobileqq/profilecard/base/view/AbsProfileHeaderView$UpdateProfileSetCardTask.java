package com.tencent.mobileqq.profilecard.base.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsProfileHeaderView$UpdateProfileSetCardTask
  implements Runnable
{
  private WeakReference<AbsProfileHeaderView> mHeaderViewRef;
  
  AbsProfileHeaderView$UpdateProfileSetCardTask(AbsProfileHeaderView paramAbsProfileHeaderView)
  {
    this.mHeaderViewRef = new WeakReference(paramAbsProfileHeaderView);
  }
  
  public void run()
  {
    try
    {
      AbsProfileHeaderView localAbsProfileHeaderView = (AbsProfileHeaderView)this.mHeaderViewRef.get();
      if (localAbsProfileHeaderView != null)
      {
        QQAppInterface localQQAppInterface = localAbsProfileHeaderView.mApp;
        Object localObject2 = localAbsProfileHeaderView.mCardInfo;
        long l3 = ((ProfileCardInfo)localObject2).card.lCurrentStyleId;
        long l2 = ((ProfileCardInfo)localObject2).card.lCurrentBgId;
        int i = ((ProfileCardInfo)localObject2).card.templateRet;
        Object localObject3 = ((ProfileCardInfo)localObject2).allInOne.uin;
        Object localObject4 = ((ProfileCardInfo)localObject2).card.getBgTypeArray();
        Object localObject1 = localQQAppInterface.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ProfileCardTips");
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localObject1 = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder.toString(), 0);
        if ((!ProfileCardUtil.d((ArrayList)localObject4)) && (((ProfileCardInfo)localObject2).card.lCurrentBgId != 160L))
        {
          if (localObject3 != null)
          {
            long l1 = 0L;
            if ((l2 > 0L) && (l3 > 0L) && (i == 0))
            {
              localObject2 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
              localObject3 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(localQQAppInterface.getCurrentAccountUin());
              if (localObject3 != null) {
                l1 = ((Card)localObject3).lCurrentBgId;
              }
              localObject3 = ((SharedPreferences)localObject1).getString(String.valueOf(l2), "");
              if (QLog.isColorLevel())
              {
                localObject4 = AbsProfileHeaderView.TAG;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("updateSetCardBar today=");
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(",userLastAccessDay=");
                localStringBuilder.append((String)localObject3);
                localStringBuilder.append(",friendBackgroundId=");
                localStringBuilder.append(l2);
                localStringBuilder.append(",myBackgroundId=");
                localStringBuilder.append(l1);
                QLog.d((String)localObject4, 2, localStringBuilder.toString());
              }
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(localObject3)) && (l1 != l2))
              {
                ((SharedPreferences)localObject1).edit().putString(String.valueOf(l2), (String)localObject2).commit();
                AbsProfileHeaderView.access$302(localAbsProfileHeaderView, AbsProfileHeaderView.access$300(localAbsProfileHeaderView) | 0x2);
                localQQAppInterface.runOnUiThread(new AbsProfileHeaderView.UpdateProfileSetCardTask.1(this, localAbsProfileHeaderView));
                break label473;
              }
              AbsProfileHeaderView.access$000(localAbsProfileHeaderView).set(true);
              break label473;
            }
          }
          AbsProfileHeaderView.access$000(localAbsProfileHeaderView).set(true);
        }
        else
        {
          AbsProfileHeaderView.access$302(localAbsProfileHeaderView, AbsProfileHeaderView.access$300(localAbsProfileHeaderView) & 0xFFFFFFFD);
          AbsProfileHeaderView.access$000(localAbsProfileHeaderView).set(true);
        }
        label473:
        if (AbsProfileHeaderView.access$000(localAbsProfileHeaderView).get())
        {
          AbsProfileHeaderView.access$400(localAbsProfileHeaderView);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.UpdateProfileSetCardTask
 * JD-Core Version:    0.7.0.1
 */