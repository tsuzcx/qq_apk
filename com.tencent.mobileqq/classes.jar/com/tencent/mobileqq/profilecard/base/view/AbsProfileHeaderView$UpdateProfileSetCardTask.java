package com.tencent.mobileqq.profilecard.base.view;

import amsw;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import aymg;
import bfrj;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
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
  private WeakReference<AbsProfileHeaderView> a;
  
  AbsProfileHeaderView$UpdateProfileSetCardTask(AbsProfileHeaderView paramAbsProfileHeaderView)
  {
    this.a = new WeakReference(paramAbsProfileHeaderView);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        AbsProfileHeaderView localAbsProfileHeaderView = (AbsProfileHeaderView)this.a.get();
        if (localAbsProfileHeaderView == null) {
          break;
        }
        QQAppInterface localQQAppInterface = localAbsProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Object localObject1 = localAbsProfileHeaderView.jdField_a_of_type_Aymg;
        long l1 = ((aymg)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = ((aymg)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = ((aymg)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        Object localObject2 = ((aymg)localObject1).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        ArrayList localArrayList = ((aymg)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        SharedPreferences localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("ProfileCardTips" + localQQAppInterface.getCurrentAccountUin(), 0);
        if ((bfrj.d(localArrayList)) || (((aymg)localObject1).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId == 160L))
        {
          AbsProfileHeaderView.a(localAbsProfileHeaderView, AbsProfileHeaderView.a(localAbsProfileHeaderView) & 0xFFFFFFFD);
          AbsProfileHeaderView.a(localAbsProfileHeaderView).set(true);
          if (!AbsProfileHeaderView.a(localAbsProfileHeaderView).get()) {
            break;
          }
          AbsProfileHeaderView.a(localAbsProfileHeaderView);
          return;
        }
        if ((localObject2 == null) || (l2 <= 0L) || (l1 <= 0L) || (i != 0)) {
          break label437;
        }
        localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        localObject2 = ((amsw)localQQAppInterface.getManager(51)).b(localQQAppInterface.getCurrentAccountUin());
        if (localObject2 != null)
        {
          l1 = ((Card)localObject2).lCurrentBgId;
          localObject2 = localSharedPreferences.getString(String.valueOf(l2), "");
          if (QLog.isColorLevel()) {
            QLog.d(AbsProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "updateSetCardBar today=" + (String)localObject1 + ",userLastAccessDay=" + (String)localObject2 + ",friendBackgroundId=" + l2 + ",myBackgroundId=" + l1);
          }
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(localObject2)) || (l1 == l2)) {
            break label425;
          }
          localSharedPreferences.edit().putString(String.valueOf(l2), (String)localObject1).commit();
          AbsProfileHeaderView.a(localAbsProfileHeaderView, AbsProfileHeaderView.a(localAbsProfileHeaderView) | 0x2);
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
      label425:
      AbsProfileHeaderView.a(localException).set(true);
      continue;
      label437:
      AbsProfileHeaderView.a(localException).set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.UpdateProfileSetCardTask
 * JD-Core Version:    0.7.0.1
 */