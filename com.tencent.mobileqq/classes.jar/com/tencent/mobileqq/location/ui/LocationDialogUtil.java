package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class LocationDialogUtil
{
  private static String a = "";
  
  public static QQCustomDialog a(int paramInt, String paramString)
  {
    QQCustomDialog localQQCustomDialog = null;
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, "showFloatExitConfirmDialog: invoked. ");
    }
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity != null)
    {
      localQQCustomDialog = DialogUtil.a(localQBaseActivity, 230, null, BaseApplication.getContext().getString(2131719404), 2131690946, 2131691327, new LocationDialogUtil.10(), new LocationDialogUtil.11(paramInt, paramString));
      paramString = new LocationDialogUtil.12(localQBaseActivity, localQQCustomDialog);
      ThreadManager.getUIHandlerV2().postDelayed(paramString, 500L);
    }
    return localQQCustomDialog;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity = new LocationDialogUtil.7(paramActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramActivity, 500L);
  }
  
  static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString)
  {
    paramActivity = new LocationDialogUtil.4(paramActivity);
    ThreadManager.getUIHandlerV2().post(paramActivity);
    LocationHandler.a().a(paramInt2, paramString, paramInt1, 2);
  }
  
  static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "showStartShareLocationDialog: invoked. ", "context = [" + paramActivity + "], uinType = [" + paramInt1 + "], frienduin = [" + paramString + "]" });
    }
    paramActivity = new LocationDialogUtil.5(paramActivity, paramInt1, paramString, paramInt2);
    ThreadManager.getUIHandlerV2().post(paramActivity);
  }
  
  static void a(Activity paramActivity, LocationShareController paramLocationShareController)
  {
    paramActivity = new LocationDialogUtil.3(paramActivity, paramLocationShareController);
    ThreadManager.getUIHandlerV2().post(paramActivity);
  }
  
  public static void a(Activity paramActivity, QQCustomDialog paramQQCustomDialog)
  {
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        paramQQCustomDialog.show();
        a = String.valueOf(paramActivity.hashCode());
        if (QLog.isColorLevel()) {
          QLog.d("LocationDialogUtil", 2, new Object[] { "showSafely: invoked. ", " currentDialogActivityHash: ", a });
        }
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("LocationDialogUtil", 1, "showSafely: failed. ", paramActivity);
    }
  }
  
  static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    a(paramActivity, DialogUtil.a(paramActivity, 230, null, paramActivity.getResources().getString(2131693853), 2131690800, 2131694615, new LocationDialogUtil.1(paramActivity, paramString1, paramString2, paramString3, paramLatLng1, paramLatLng2), new LocationDialogUtil.2()));
  }
  
  public static boolean a(Activity paramActivity)
  {
    if ((paramActivity instanceof QPublicFragmentActivity))
    {
      paramActivity = paramActivity.getIntent().getStringExtra("FRAGMENT_KEY");
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "activityIsShareOrPickFragment: invoked. ", " key: ", paramActivity });
      }
      if (("LocationShareFragment".equals(paramActivity)) || ("LocationPickFragment".equals(paramActivity))) {
        return true;
      }
    }
    return false;
  }
  
  private static void b(int paramInt, String paramString)
  {
    int i = 2;
    if (paramInt == 3) {
      i = 1;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", paramString, paramString, i, 0, "", "0", "0", "");
      return;
      if (paramInt != 2) {
        i = 0;
      }
    }
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity = new LocationDialogUtil.8(paramActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramActivity, 500L);
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog: invoked. showRoomJoinLimitedDialog#post ", " runnable: ", paramActivity });
    }
  }
  
  public static void b(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "showEnterOtherRoomExitDialog: invoked. ", "activity = [" + paramActivity + "], uinType = [" + paramInt1 + "], uin = [" + paramString + "], entryType = [" + paramInt2 + "]" });
    }
    if (paramInt2 == 1) {}
    for (String str = paramActivity.getResources().getString(2131719402);; str = paramActivity.getResources().getString(2131719401))
    {
      paramActivity = new LocationDialogUtil.9(paramActivity, str, paramInt1, paramString, paramInt2);
      ThreadManager.getUIHandlerV2().postDelayed(paramActivity, 500L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil
 * JD-Core Version:    0.7.0.1
 */