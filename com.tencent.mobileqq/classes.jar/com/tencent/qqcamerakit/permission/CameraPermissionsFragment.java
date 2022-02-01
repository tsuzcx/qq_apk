package com.tencent.qqcamerakit.permission;

import android.app.Fragment;
import android.os.Bundle;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

public class CameraPermissionsFragment
  extends ReportFragment
{
  CameraPermission a;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.a.a(paramInt, paramArrayOfString, paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.permission.CameraPermissionsFragment
 * JD-Core Version:    0.7.0.1
 */