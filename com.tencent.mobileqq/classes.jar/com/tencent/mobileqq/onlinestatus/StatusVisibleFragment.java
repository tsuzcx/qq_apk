package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.ReceiveDataListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StatusVisibleFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, OnlineStatusPermissionManager.ReceiveDataListener
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem b;
  private View c;
  private View d;
  private View e;
  private TextView g;
  private TextView h;
  
  public static void a(Activity paramActivity, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, StatusVisibleFragment.class);
    if (paramOnlineStatusPermissionItem != null) {
      localIntent.putExtra("online_status_permission_item", paramOnlineStatusPermissionItem);
    }
    localIntent.putExtra("key_launch_scene", paramInt1);
    QPublicFragmentActivity.startForResult(paramActivity, localIntent, StatusVisibleFragment.class, paramInt2);
  }
  
  private void c()
  {
    this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131377491);
    this.d = this.jdField_b_of_type_AndroidViewView.findViewById(2131377503);
    this.g = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131361918));
    this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131377504);
    this.h = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131361919));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131361920).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131369092).setOnClickListener(this);
    a(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131712773));
    a(2131690728, null);
    c(2131692486, this);
    a();
    this.jdField_a_of_type_Int = getQBaseActivity().getIntent().getIntExtra("key_launch_scene", -1);
  }
  
  private void d()
  {
    if (this.c.getVisibility() != 0)
    {
      OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
      if ((localOnlineStatusPermissionItem != null) && (!localOnlineStatusPermissionItem.isAllHasPermission()))
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
  
  private void e()
  {
    if (this.d.getVisibility() != 0)
    {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null) {
          localObject = "null";
        } else {
          localObject = " not null";
        }
        QLog.d("StatusVisibleFragment", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", localObject });
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
      if (localObject == null)
      {
        OnlineStatusPermissionChecker.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
      a();
      return;
    }
    OnlineStatusPermissionChecker.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, false);
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)getQBaseActivity().getIntent().getSerializableExtra("online_status_permission_item"));
      if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null)
      {
        localObject = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, true, this);
        if (localObject != null)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, ((OnlineStatusFriendsPermissionItem)localObject).allHasPermission, ((OnlineStatusFriendsPermissionItem)localObject).permissionUins);
        }
        else
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    if (localObject != null) {
      ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).filterNotFriend();
    }
  }
  
  private void g()
  {
    Object localObject1 = new SpannableStringBuilder();
    int i = 0;
    Object localObject2;
    while (i < this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size())
    {
      localObject2 = (Long)this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().get(i);
      ((SpannableStringBuilder)localObject1).append(((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendShowName(String.valueOf(localObject2)));
      if (i != this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() - 1) {
        ((SpannableStringBuilder)localObject1).append("、");
      }
      i += 1;
    }
    this.g.setText(((SpannableStringBuilder)localObject1).toString());
    localObject1 = getResources().getDrawable(2130839270);
    ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.h.setCompoundDrawables(null, null, (Drawable)localObject1, null);
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() > 0)
    {
      localObject1 = this.h;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("（");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size());
      ((StringBuilder)localObject2).append("人）");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      return;
    }
    this.h.setText("");
  }
  
  protected int a()
  {
    return 2131558483;
  }
  
  public void a()
  {
    f();
    boolean bool = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission();
    int i = 0;
    if (bool)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.e.setVisibility(8);
    }
    else
    {
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.e.setVisibility(0);
      if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins() == null) {
        return;
      }
      g();
    }
    View localView = this.d;
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100)
    {
      paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime, false);
      if (paramIntent != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramIntent;
        a();
      }
      if (paramInt2 == 0)
      {
        ReportHelperKt.a("0X800AF4B", 1);
        return;
      }
      if (paramInt2 == -1) {
        ReportHelperKt.a("0X800AF4A", 1);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 2) {
      ReportHelperKt.a("0X800AF95", 2, "1");
    } else if (i == 1) {
      ReportHelperKt.a("0X800AF95", 1, "1");
    } else if (i == 3) {
      ReportHelperKt.a("0X800AF95", 1, "2");
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131361920)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusVisibleFragment", 2, "account_online_status_show_all!");
      }
      d();
    }
    else if (i == 2131369092)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusVisibleFragment", 2, "account_online_status_show_part!");
      }
      e();
    }
    else if (i == 2131369233)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("online_status_permission_item", this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      i = this.jdField_a_of_type_Int;
      if (i == 2) {
        ReportHelperKt.a("0X800AF96", 2, "1");
      } else if (i == 1) {
        ReportHelperKt.a("0X800AF96", 1, "1");
      } else if (i == 3) {
        ReportHelperKt.a("0X800AF96", 1, "2");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_MqqAppAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    this.jdField_a_of_type_AndroidAppActivity = getQBaseActivity();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.StatusVisibleFragment
 * JD-Core Version:    0.7.0.1
 */