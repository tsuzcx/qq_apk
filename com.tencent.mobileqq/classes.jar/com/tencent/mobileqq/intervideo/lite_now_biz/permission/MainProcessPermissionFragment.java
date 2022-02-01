package com.tencent.mobileqq.intervideo.lite_now_biz.permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

public class MainProcessPermissionFragment
  extends ReportFragment
{
  private PermissionListener a;
  
  public static MainProcessPermissionFragment a(String[] paramArrayOfString)
  {
    MainProcessPermissionFragment localMainProcessPermissionFragment = new MainProcessPermissionFragment();
    Bundle localBundle = new Bundle();
    localBundle.putStringArray("permission_list", paramArrayOfString);
    localMainProcessPermissionFragment.setArguments(localBundle);
    return localMainProcessPermissionFragment;
  }
  
  private void a()
  {
    this.a = null;
    if ((getActivity() != null) && (isAdded())) {
      getActivity().getFragmentManager().beginTransaction().remove(this);
    }
  }
  
  public void a(PermissionListener paramPermissionListener)
  {
    this.a = paramPermissionListener;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() == null)
    {
      a();
      return;
    }
    paramBundle = getArguments().getStringArray("permission_list");
    if ((paramBundle == null) || (Build.VERSION.SDK_INT < 23))
    {
      a();
      return;
    }
    requestPermissions(paramBundle, 1);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.a != null) {
      this.a.a(paramArrayOfString, paramArrayOfInt);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.permission.MainProcessPermissionFragment
 * JD-Core Version:    0.7.0.1
 */