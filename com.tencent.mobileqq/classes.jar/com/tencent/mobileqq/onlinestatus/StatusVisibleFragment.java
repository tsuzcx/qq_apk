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
  private Activity a;
  private AppRuntime b;
  private View c;
  private View d;
  private TextView e;
  private View f;
  private TextView g;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem w;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem x;
  private int y;
  private boolean z = false;
  
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
    this.c = this.t.findViewById(2131445890);
    this.d = this.t.findViewById(2131445905);
    this.e = ((TextView)this.t.findViewById(2131427472));
    this.f = this.t.findViewById(2131445906);
    this.g = ((TextView)this.t.findViewById(2131427473));
    this.t.findViewById(2131427474).setOnClickListener(this);
    this.t.findViewById(2131436056).setOnClickListener(this);
    a(this.b.getApp().getString(2131910346));
    a(2131887648, null);
    c(2131889474, this);
    b();
    this.y = getQBaseActivity().getIntent().getIntExtra("key_launch_scene", -1);
  }
  
  private void d()
  {
    if (this.c.getVisibility() != 0)
    {
      OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = this.x;
      if ((localOnlineStatusPermissionItem != null) && (!localOnlineStatusPermissionItem.isAllHasPermission()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("StatusVisibleFragment", 2, "account_online_status_show_all! mOnlinePermission is part");
        }
        this.w = this.x;
      }
      this.x = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
      b();
    }
  }
  
  private void e()
  {
    if (this.d.getVisibility() != 0)
    {
      if (QLog.isColorLevel())
      {
        if (this.w == null) {
          localObject = "null";
        } else {
          localObject = " not null";
        }
        QLog.d("StatusVisibleFragment", 2, new Object[] { "account_online_status_show_part! mLastPartPermission:", localObject });
      }
      Object localObject = this.w;
      if (localObject == null)
      {
        OnlineStatusPermissionChecker.a(this.b, this.a, this.x, false);
        return;
      }
      this.x = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
      b();
      return;
    }
    OnlineStatusPermissionChecker.a(this.b, this.a, this.x, false);
  }
  
  private void f()
  {
    if (this.x == null)
    {
      this.x = ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)getQBaseActivity().getIntent().getSerializableExtra("online_status_permission_item"));
      if (this.x == null)
      {
        localObject = ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(40001L, true, this);
        if (localObject != null)
        {
          this.z = false;
          this.x = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, ((OnlineStatusFriendsPermissionItem)localObject).allHasPermission, ((OnlineStatusFriendsPermissionItem)localObject).permissionUins);
        }
        else
        {
          this.z = true;
          this.x = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
        }
      }
      else
      {
        this.z = false;
      }
    }
    else
    {
      this.z = false;
    }
    Object localObject = this.x;
    if (localObject != null) {
      ((OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject).filterNotFriend();
    }
  }
  
  private void g()
  {
    Object localObject1 = new SpannableStringBuilder();
    int i = 0;
    Object localObject2;
    while (i < this.x.getPermissionUins().size())
    {
      localObject2 = (Long)this.x.getPermissionUins().get(i);
      ((SpannableStringBuilder)localObject1).append(((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendShowName(String.valueOf(localObject2)));
      if (i != this.x.getPermissionUins().size() - 1) {
        ((SpannableStringBuilder)localObject1).append("、");
      }
      i += 1;
    }
    this.e.setText(((SpannableStringBuilder)localObject1).toString());
    localObject1 = getResources().getDrawable(2130839446);
    ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    this.g.setCompoundDrawables(null, null, (Drawable)localObject1, null);
    if (this.x.getPermissionUins().size() > 0)
    {
      localObject1 = this.g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("（");
      ((StringBuilder)localObject2).append(this.x.getPermissionUins().size());
      ((StringBuilder)localObject2).append("人）");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      return;
    }
    this.g.setText("");
  }
  
  protected int a()
  {
    return 2131624030;
  }
  
  public void a(OnlineStatusFriendsPermissionItem paramOnlineStatusFriendsPermissionItem, List<Integer> paramList)
  {
    if (this.z)
    {
      this.x = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, paramOnlineStatusFriendsPermissionItem.allHasPermission, paramOnlineStatusFriendsPermissionItem.permissionUins);
      b();
    }
  }
  
  public void b()
  {
    f();
    boolean bool = this.x.isAllHasPermission();
    int i = 0;
    if (bool)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      this.f.setVisibility(8);
    }
    else
    {
      this.c.setVisibility(8);
      this.d.setVisibility(0);
      this.f.setVisibility(0);
      if (this.x.getPermissionUins() == null) {
        return;
      }
      g();
    }
    View localView = this.d;
    if (this.x.isAllHasPermission()) {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100)
    {
      paramIntent = OnlineStatusPermissionChecker.a(paramIntent, paramInt2, this.a, this.b, false);
      if (paramIntent != null)
      {
        this.x = paramIntent;
        b();
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
    int i = this.y;
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
    if (i == 2131427474)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusVisibleFragment", 2, "account_online_status_show_all!");
      }
      d();
    }
    else if (i == 2131436056)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusVisibleFragment", 2, "account_online_status_show_part!");
      }
      e();
    }
    else if (i == 2131436211)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("online_status_permission_item", this.x);
      this.a.setResult(-1, localIntent);
      this.a.finish();
      i = this.y;
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
    this.b = MobileQQ.getMobileQQ().waitAppRuntime(null);
    this.a = getQBaseActivity();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.StatusVisibleFragment
 * JD-Core Version:    0.7.0.1
 */