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
  private final List<AuthorizationItem.ItemType> a;
  private final GdtUserInfoAuthorizationHelper.UserInfoEntity b;
  private GdtUserInfoAuthorizationHelper.UserInfoCallback c;
  
  public AuthorizationDialog(Activity paramActivity, GdtUserInfoAuthorizationHelper.UserInfoEntity paramUserInfoEntity, GdtUserInfoAuthorizationHelper.UserInfoCallback paramUserInfoCallback, List<AuthorizationItem.ItemType> paramList)
  {
    super(paramActivity);
    this.a = paramList;
    this.b = paramUserInfoEntity;
    this.c = paramUserInfoCallback;
    a();
  }
  
  private AuthorizationItem a(AuthorizationItem.ItemType paramItemType, int paramInt, String paramString)
  {
    return new AuthorizationItem(getContext(), paramString, paramItemType, paramInt);
  }
  
  private void a()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131624704, null);
    LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131435969);
    List localList = this.a;
    if ((localList != null) && (localList.size() > 0))
    {
      int k = this.a.size();
      int j = 0;
      while (j < k)
      {
        if ((AuthorizationItem.ItemType)this.a.get(j) != AuthorizationItem.d)
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
          localLinearLayout2.addView(a((AuthorizationItem.ItemType)this.a.get(j), i, this.b.a(((AuthorizationItem.ItemType)this.a.get(j)).b)));
        }
        j += 1;
      }
    }
    addView(localLinearLayout1);
    localLinearLayout1.findViewById(2131429815).setOnClickListener(this);
    localLinearLayout1.findViewById(2131429844).setOnClickListener(this);
    localLinearLayout1.findViewById(2131436425).setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    Object localObject2;
    if (i == 2131436425)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to show authorize description");
      }
      localObject1 = new AuthorizationDescriptionDialog(getContext());
      localObject2 = ((AuthorizationDescriptionDialog)localObject1).getWindow();
      if (localObject2 != null) {
        ((Window)localObject2).setWindowAnimations(2131951622);
      }
      ((AuthorizationDescriptionDialog)localObject1).show();
    }
    else if (i == 2131429815)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to cancel authorize dialog");
      }
      localObject1 = this.c;
      if (localObject1 != null)
      {
        localObject2 = this.b;
        ((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2).d = 2;
        ((GdtUserInfoAuthorizationHelper.UserInfoCallback)localObject1).a((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2);
      }
      dismiss();
    }
    else if (i == 2131429844)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActionSheet", 2, "onClick to confirm authorize user info");
      }
      localObject1 = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
      i = 0;
      while (i < this.a.size())
      {
        localObject2 = (AuthorizationItem.ItemType)this.a.get(i);
        if (!TextUtils.isEmpty(this.b.a(((AuthorizationItem.ItemType)localObject2).b)))
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
      localObject1 = this.c;
      if (localObject1 != null)
      {
        localObject2 = this.b;
        ((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2).d = 0;
        ((GdtUserInfoAuthorizationHelper.UserInfoCallback)localObject1).a((GdtUserInfoAuthorizationHelper.UserInfoEntity)localObject2);
      }
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AuthorizationDialog
 * JD-Core Version:    0.7.0.1
 */