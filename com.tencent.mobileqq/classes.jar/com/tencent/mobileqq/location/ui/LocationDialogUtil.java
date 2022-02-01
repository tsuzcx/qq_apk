package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
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
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, "showFloatExitConfirmDialog: invoked. ");
    }
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject != null)
    {
      paramString = DialogUtil.a((Context)localObject, 230, null, BaseApplication.getContext().getString(2131719122), 2131690874, 2131691248, new LocationDialogUtil.10(), new LocationDialogUtil.11(paramInt, paramString));
      localObject = new LocationDialogUtil.12((QBaseActivity)localObject, paramString);
      ThreadManager.getUIHandlerV2().postDelayed((Runnable)localObject, 500L);
      return paramString;
    }
    return null;
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
    LocationShareRoomManager.a().a(paramInt2, paramString, paramInt1, 2);
  }
  
  static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("context = [");
      localStringBuilder.append(paramActivity);
      localStringBuilder.append("], uinType = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], frienduin = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("LocationDialogUtil", 2, new Object[] { "showStartShareLocationDialog: invoked. ", localStringBuilder.toString() });
    }
    paramActivity = new LocationDialogUtil.5(paramActivity, paramInt1, paramString, paramInt2);
    ThreadManager.getUIHandlerV2().post(paramActivity);
  }
  
  public static void a(Activity paramActivity, LocationShareController paramLocationShareController)
  {
    paramActivity = new LocationDialogUtil.3(paramActivity, paramLocationShareController);
    ThreadManager.getUIHandlerV2().post(paramActivity);
  }
  
  public static void a(Activity paramActivity, QQCustomDialog paramQQCustomDialog)
  {
    if (paramActivity != null) {
      try
      {
        if (!paramActivity.isFinishing())
        {
          paramQQCustomDialog.show();
          a = String.valueOf(paramActivity.hashCode());
          if (QLog.isColorLevel())
          {
            QLog.d("LocationDialogUtil", 2, new Object[] { "showSafely: invoked. ", " currentDialogActivityHash: ", a });
            return;
          }
        }
      }
      catch (Exception paramActivity)
      {
        QLog.e("LocationDialogUtil", 1, "showSafely: failed. ", paramActivity);
      }
    }
  }
  
  static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    a(paramActivity, DialogUtil.a(paramActivity, 230, null, paramActivity.getResources().getString(2131693807), 2131690728, 2131694583, new LocationDialogUtil.1(paramActivity, paramString1, paramString2, paramString3, paramLatLng1, paramLatLng2), new LocationDialogUtil.2()));
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
    if (paramInt == 3) {
      paramInt = 1;
    } else if (paramInt == 2) {
      paramInt = 2;
    } else {
      paramInt = 0;
    }
    ReportController.b(null, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("activity = [");
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append("], uinType = [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], uin = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], entryType = [");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      QLog.d("LocationDialogUtil", 2, new Object[] { "showEnterOtherRoomExitDialog: invoked. ", ((StringBuilder)localObject).toString() });
    }
    if (paramInt2 == 1) {
      localObject = paramActivity.getResources().getString(2131719120);
    } else {
      localObject = paramActivity.getResources().getString(2131719119);
    }
    paramActivity = new LocationDialogUtil.9(paramActivity, (String)localObject, paramInt1, paramString, paramInt2);
    ThreadManager.getUIHandlerV2().postDelayed(paramActivity, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil
 * JD-Core Version:    0.7.0.1
 */