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
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131559052, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131369009);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
    {
      int k = this.jdField_a_of_type_JavaUtilList.size();
      int j = 0;
      while (j < k)
      {
        if ((AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(j) != AuthorizationItem.d)
        {
          int i = 2;
          if (k == 1)
          {
            i = 3;
          }
          else
          {
            if (k == 2) {
              if (j != 0) {
                break label129;
              }
            } else {
              if (j != 0) {
                break label120;
              }
            }
            i = 0;
            break label129;
            label120:
            if (j < k - 1) {
              i = 1;
            }
          }
          label129:
          localLinearLayout2.addView(a((AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(j), i, this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity.a(((AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(j)).b)));
        }
        j += 1;
      }
    }
    addView(localLinearLayout1);
    localLinearLayout1.findViewById(2131363867).setOnClickListener(this);
    localLinearLayout1.findViewById(2131363894).setOnClickListener(this);
    localLinearLayout1.findViewById(2131369392).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    Object localObject2;
    if (i == 2131369392)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      localObject1 = new AuthorizationDescriptionDialog(getContext());
      localObject2 = ((AuthorizationDescriptionDialog)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setWindowAnimations(2131755012);
      }
      ((AuthorizationDescriptionDialog)localObject1).show();
    }
    else if (i == 2131363867)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      localObject1 = this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity;
        ((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2).a = 2;
        ((GdtUserInfoAuthorizationHelper.UserInfoCallback)localObject1).a((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2);
      }
      dismiss();
    }
    else if (i == 2131363894)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to confirm authorize user info");
      }
      localObject1 = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = (AuthorizationItem.ItemType)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity.a(((AuthorizationItem.ItemType)localObject2).b)))
        {
          ((SharedPreferences)localObject1).edit().putBoolean(((AuthorizationItem.ItemType)localObject2).b, true).apply();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("record ");
            localStringBuilder.append(((AuthorizationItem.ItemType)localObject2).b);
            localStringBuilder.append(" authorize");
            QLog.d("ActionSheet", 2, localStringBuilder.toString());
          }
        }
        i += 1;
      }
      localObject1 = this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoCallback;
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentGdtadUtilGdtUserInfoAuthorizationHelper$UserInfoEntity;
        ((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2).a = 0;
        ((GdtUserInfoAuthorizationHelper.UserInfoCallback)localObject1).a((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2);
      }
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AuthorizationDialog
 * JD-Core Version:    0.7.0.1
 */