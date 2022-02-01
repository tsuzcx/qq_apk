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
    if (Build.VERSION.SDK_INT < 23) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback.onGetLocation();
      }
    }
    label119:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidAppActivity == null);
        if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label119;
          }
          if (!(this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity)) {
            break;
          }
          ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
      } while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity));
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback.onGetLocation();
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilLocationPermissionHelper$LocationPermissionCallback.onGetLocation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper
 * JD-Core Version:    0.7.0.1
 */