package com.tencent.mobileqq.richmedia.capture.util;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class LocationPermissionHelper
  implements QQPermissionCallback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private LocationPermissionHelper.LocationPermissionCallback jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback;
  
  public LocationPermissionHelper(Activity paramActivity, LocationPermissionHelper.LocationPermissionCallback paramLocationPermissionCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback = paramLocationPermissionCallback;
  }
  
  public void a()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 23)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback;
      if (localObject != null) {
        ((LocationPermissionHelper.LocationPermissionCallback)localObject).onGetLocation();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject == null) {
        return;
      }
      int i;
      if (((Activity)localObject).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        if ((localObject instanceof AppActivity))
        {
          ((AppActivity)localObject).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
        if ((localObject instanceof BaseActivity)) {
          ((BaseActivity)localObject).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback;
        if (localObject != null) {
          ((LocationPermissionHelper.LocationPermissionCallback)localObject).onGetLocation();
        }
      }
    }
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback;
    if (paramArrayOfString != null) {
      paramArrayOfString.onGetLocation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper
 * JD-Core Version:    0.7.0.1
 */