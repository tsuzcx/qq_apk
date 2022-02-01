package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class ProfileViewOnClickListener
  implements View.OnClickListener
{
  private final WeakReference<ProfileCardMoreInfoView> a;
  
  public ProfileViewOnClickListener(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this.a = new WeakReference(paramProfileCardMoreInfoView);
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    Object localObject1 = (ProfileCardMoreInfoView)this.a.get();
    if (localObject1 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseActivity localBaseActivity = ((ProfileCardMoreInfoView)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      QQAppInterface localQQAppInterface = ((ProfileCardMoreInfoView)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = ((ProfileCardMoreInfoView)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
      if ((localBaseActivity == null) || (localQQAppInterface == null) || (localObject1 != null))
      {
        Object localObject2 = paramView.getTag();
        if ((localObject2 instanceof DataTag)) {
          switch (((DataTag)localObject2).a)
          {
          default: 
            break;
          case 66: 
            ProfileCardUtil.a((ProfileCardInfo)localObject1, localQQAppInterface, localBaseActivity);
            int i = j;
            if (((ProfileCardInfo)localObject1).a != null)
            {
              i = j;
              if (((ProfileCardInfo)localObject1).a.a == 0) {
                i = 1;
              }
            }
            ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileViewOnClickListener
 * JD-Core Version:    0.7.0.1
 */