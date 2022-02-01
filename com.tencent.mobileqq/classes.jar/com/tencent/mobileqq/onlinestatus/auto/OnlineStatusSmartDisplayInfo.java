package com.tencent.mobileqq.onlinestatus.auto;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo;
import com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo.UpdateUIListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionServlet;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;
import com.tencent.mobileqq.utils.DialogUtil;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class OnlineStatusSmartDisplayInfo
  extends BaseOnlineStatusDisplayInfo
{
  private AutoStatusManager k;
  
  public OnlineStatusSmartDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    super(paramLong, paramUpdateUIListener, paramAppRuntime, paramQBaseActivity);
    this.k = ((AutoStatusManager)((IOnlineStatusManagerService)paramAppRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoStatusManager.class));
    this.k.a(new OnlineStatusSmartDisplayInfo.1(this));
  }
  
  protected void a()
  {
    this.a = this.h.getString(2131896444);
    this.d = true;
    this.b = this.k.a(null);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    DialogUtil.a(paramQBaseActivity, 2131896425, 2131896426);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ArrayList localArrayList;
    if (this.f == null) {
      localArrayList = null;
    } else {
      localArrayList = this.f.b();
    }
    OnlineStatusPermissionServlet.a(this.i, paramOnlineStatusPermissionItem, localArrayList, paramBoolean ^ true);
  }
  
  public void b() {}
  
  public boolean c()
  {
    return false;
  }
  
  public void e()
  {
    super.e();
    if (Build.VERSION.SDK_INT >= 23) {
      this.h.requestPermissions(new OnlineStatusSmartDisplayInfo.2(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  public void f()
  {
    super.f();
    this.k.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.OnlineStatusSmartDisplayInfo
 * JD-Core Version:    0.7.0.1
 */