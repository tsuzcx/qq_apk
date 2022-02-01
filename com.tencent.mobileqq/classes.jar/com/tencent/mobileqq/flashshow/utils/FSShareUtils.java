package com.tencent.mobileqq.flashshow.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActionSheetApi;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import com.tencent.mobileqq.share.api.ShareConfig;

public class FSShareUtils
{
  private IShareActionSheetApi a = (IShareActionSheetApi)QRoute.api(IShareActionSheetApi.class);
  
  public FSShareUtils(Context paramContext)
  {
    this.a.init(paramContext);
  }
  
  public void a()
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setRowVisibility(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setCancelListener(paramOnCancelListener);
    }
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setOnDismissListener(paramOnDismissListener);
    }
  }
  
  public void a(Intent paramIntent)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setIntentForStartForwardRecentActivity(paramIntent);
    }
  }
  
  public void a(ShareActionSheetClickListener paramShareActionSheetClickListener)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setActionSheetClickListener(paramShareActionSheetClickListener);
    }
  }
  
  public void a(ShareConfig paramShareConfig)
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      localIShareActionSheetApi.setActionSheetItems(paramShareConfig);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("is_force_night_theme", paramBoolean);
      this.a.setExtras(localBundle);
      this.a.show();
    }
  }
  
  public boolean b()
  {
    IShareActionSheetApi localIShareActionSheetApi = this.a;
    if (localIShareActionSheetApi != null) {
      return localIShareActionSheetApi.isShowing();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSShareUtils
 * JD-Core Version:    0.7.0.1
 */