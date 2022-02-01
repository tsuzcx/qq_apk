package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.UserInfoCallback;
import com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.UserInfoEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class AuthorizationDialog
  extends ActionSheet
  implements View.OnClickListener
{
  private GdtUserInfoAuthorizationHelper.UserInfoCallback jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback;
  private final GdtUserInfoAuthorizationHelper.UserInfoEntity jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity;
  private final List<AuthorizationItem.ItemType> jdField_a_of_type_JavaUtilList;
  
  public AuthorizationDialog(Activity paramActivity, GdtUserInfoAuthorizationHelper.UserInfoEntity paramUserInfoEntity, GdtUserInfoAuthorizationHelper.UserInfoCallback paramUserInfoCallback, List<AuthorizationItem.ItemType> paramList)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity = paramUserInfoEntity;
    this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback = paramUserInfoCallback;
    a();
  }
  
  private AuthorizationItem a(AuthorizationItem.ItemType paramItemType, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, paramItemType, paramInt);
  }
  
  private void a()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559158, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131369280);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      if (j < k)
      {
        int i;
        if ((AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(j) != AuthorizationItem.d)
        {
          if (k != 1) {
            break label145;
          }
          i = 3;
        }
        for (;;)
        {
          localLinearLayout2.addView(a((AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(j), i, this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity.a(((AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(j)).b)));
          j += 1;
          break;
          label145:
          if (k == 2)
          {
            if (j == 0) {
              i = 0;
            } else {
              i = 2;
            }
          }
          else if (j == 0) {
            i = 0;
          } else if (j < k - 1) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
    }
    addView(localLinearLayout1);
    localLinearLayout1.findViewById(2131363941).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363967).setOnClickListener(this);
    localLinearLayout1.findViewById(2131369694).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      Object localObject1 = new AuthorizationDescriptionDialog(getContext());
      Object localObject2 = ((AuthorizationDescriptionDialog)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setWindowAnimations(2131755014);
      }
      ((AuthorizationDescriptionDialog)localObject1).show();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      if (this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback != null)
      {
        this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity.a = 2;
        this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback.a(this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity);
      }
      dismiss();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to confirm authorize user info");
      }
      localObject1 = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = (AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity.a(((AuthorizationItem.ItemType)localObject2).b)))
        {
          ((SharedPreferences)localObject1).edit().putBoolean(((AuthorizationItem.ItemType)localObject2).b, true).apply();
          if (QLog.isColorLevel()) {
            QLog.d("ActionSheet", 2, "record " + ((AuthorizationItem.ItemType)localObject2).b + " authorize");
          }
        }
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback != null)
      {
        this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity.a = 0;
        this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback.a(this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity);
      }
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.AuthorizationDialog
 * JD-Core Version:    0.7.0.1
 */