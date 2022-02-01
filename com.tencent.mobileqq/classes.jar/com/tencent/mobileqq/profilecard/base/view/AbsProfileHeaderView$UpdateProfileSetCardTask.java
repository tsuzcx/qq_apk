package com.tencent.mobileqq.profilecard.base.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
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
    for (;;)
    {
      try
      {
        AbsProfileHeaderView localAbsProfileHeaderView = (AbsProfileHeaderView)this.mHeaderViewRef.get();
        if (localAbsProfileHeaderView == null) {
          break;
        }
        QQAppInterface localQQAppInterface = localAbsProfileHeaderView.mApp;
        Object localObject1 = localAbsProfileHeaderView.mCardInfo;
        long l1 = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        Object localObject2 = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a;
        ArrayList localArrayList = ((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        SharedPreferences localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("ProfileCardTips" + localQQAppInterface.getCurrentAccountUin(), 0);
        if ((ProfileCardUtil.d(localArrayList)) || (((ProfileCardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId == 160L))
        {
          AbsProfileHeaderView.access$302(localAbsProfileHeaderView, AbsProfileHeaderView.access$300(localAbsProfileHeaderView) & 0xFFFFFFFD);
          AbsProfileHeaderView.access$000(localAbsProfileHeaderView).set(true);
          if (!AbsProfileHeaderView.access$000(localAbsProfileHeaderView).get()) {
            break;
          }
          AbsProfileHeaderView.access$400(localAbsProfileHeaderView);
          return;
        }
        if ((localObject2 == null) || (l2 <= 0L) || (l1 <= 0L) || (i != 0)) {
          break label438;
        }
        localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        localObject2 = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(localQQAppInterface.getCurrentAccountUin());
        if (localObject2 != null)
        {
          l1 = ((Card)localObject2).lCurrentBgId;
          localObject2 = localSharedPreferences.getString(String.valueOf(l2), "");
          if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.TAG, 2, "updateSetCardBar today=" + (String)localObject1 + ",userLastAccessDay=" + (String)localObject2 + ",friendBackgroundId=" + l2 + ",myBackgroundId=" + l1);
          }
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(localObject2)) || (l1 == l2)) {
            break label426;
          }
          localSharedPreferences.edit().putString(String.valueOf(l2), (String)localObject1).commit();
          AbsProfileHeaderView.access$302(localAbsProfileHeaderView, AbsProfileHeaderView.access$300(localAbsProfileHeaderView) | 0x2);
          localQQAppInterface.runOnUiThread(new AbsProfileHeaderView.UpdateProfileSetCardTask.1(this, localAbsProfileHeaderView));
          continue;
        }
        l1 = 0L;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      continue;
      label426:
      AbsProfileHeaderView.access$000(localException).set(true);
      continue;
      label438:
      AbsProfileHeaderView.access$000(localException).set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.UpdateProfileSetCardTask
 * JD-Core Version:    0.7.0.1
 */