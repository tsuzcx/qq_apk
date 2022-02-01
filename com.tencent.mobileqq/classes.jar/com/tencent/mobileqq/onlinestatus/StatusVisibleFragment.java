package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class StatusVisibleFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, OnlineStatusPermissionManager.ReceiveDataListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private View c;
  
  public static void a(Activity paramActivity, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, StatusVisibleFragment.class);
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    localIntent.putExtra("key_launch_scene", paramInt1);
    PublicFragmentActivity.a(paramActivity, localIntent, StatusVisibleFragment.class, paramInt2);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131378063);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131378077);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131361912));
    this.c = this.mContentView.findViewById(2131378078);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131361913));
    this.mContentView.findViewById(2131361914).setOnClickListener(this);
    this.mContentView.findViewById(2131369363).setOnClickListener(this);
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131712798));
    setLeftButton(2131690800, null);
    setRightButton(2131692534, this);
    a();
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("key_launch_scene", -1);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) && (!this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StatusVisibleFragment", 2, "account_online_status_show_all! mOnlinePermission is part");
        }
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
      }
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
      a();
    }
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0)
    {
      if (QLog.isColorLevel()) {
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
          break label69;
        }
      }
      label69:
      for (String str = "null";; str = " not null")
      {
        QLog.d("StatusVisibleFragment", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", str });
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
          break;
        }
        OnlineStatusPermissionChecker.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
      a();
      return;
    }
    OnlineStatusPermissionChecker.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)getActivity().getIntent().getSerializableExtra("online_status_permission_item"));
      if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
      {
        OnlineStatusFriendsPermissionItem localOnlineStatusFriendsPermissionItem = ((OnlineStatusPermissionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a(40001L, true, this);
        if (localOnlineStatusFriendsPermissionItem != null)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, localOnlineStatusFriendsPermissionItem.allHasPermission, localOnlineStatusFriendsPermissionItem.permissionUins);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) {
        this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.filterNotFriend();
      }
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
      continue;
      this.jdField_a_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void f()
  {
    Object localObject = new SpannableStringBuilder();
    int i = 0;
    while (i < this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size())
    {
      Long localLong = (Long)this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().get(i);
      ((SpannableStringBuilder)localObject).append(ContactUtils.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localLong)));
      if (i != this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() - 1) {
        ((SpannableStringBuilder)localObject).append("、");
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((SpannableStringBuilder)localObject).toString());
    localObject = getResources().getDrawable(2130839414);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("（" + this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() + "人）");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a()
  {
    int i = 8;
    e();
    View localView;
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.c.setVisibility(8);
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {
        break label106;
      }
    }
    for (;;)
    {
      localView.setVisibility(i);
      do
      {
        return;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.c.setVisibility(0);
      } while (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins() == null);
      f();
      break;
      label106:
      i = 0;
    }
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      a();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558454;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100)
    {
      paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      if (paramIntent != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramIntent;
        a();
      }
      if (paramInt2 != 0) {
        break label53;
      }
      ReportHelperKt.a("0X800AF4B", 1);
    }
    label53:
    while (paramInt2 != -1) {
      return;
    }
    ReportHelperKt.a("0X800AF4A", 1);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Int == 2) {
      ReportHelperKt.a("0X800AF95", 2, "1");
    }
    for (;;)
    {
      return super.onBackEvent();
      if (this.jdField_a_of_type_Int == 1) {
        ReportHelperKt.a("0X800AF95", 1, "1");
      } else if (this.jdField_a_of_type_Int == 3) {
        ReportHelperKt.a("0X800AF95", 1, "2");
      }
    }
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
        QLog.d("StatusVisibleFragment", 2, "account_online_status_show_all!");
      }
      c();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("StatusVisibleFragment", 2, "account_online_status_show_part!");
      }
      d();
      continue;
      Intent localIntent = new Intent();
      localIntent.putExtra("online_status_permission_item", this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      if (this.jdField_a_of_type_Int == 2) {
        ReportHelperKt.a("0X800AF96", 2, "1");
      } else if (this.jdField_a_of_type_Int == 1) {
        ReportHelperKt.a("0X800AF96", 1, "1");
      } else if (this.jdField_a_of_type_Int == 3) {
        ReportHelperKt.a("0X800AF96", 1, "2");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.StatusVisibleFragment
 * JD-Core Version:    0.7.0.1
 */