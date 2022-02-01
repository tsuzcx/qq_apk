package com.tencent.mobileqq.intervideo.lite_now_biz.permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class MainProcessPermissionFragment
  extends Fragment
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
    if ((paramBundle != null) && (Build.VERSION.SDK_INT >= 23))
    {
      requestPermissions(paramBundle, 1);
      return;
    }
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PermissionListener localPermissionListener = this.a;
    if (localPermissionListener != null) {
      localPermissionListener.a(paramArrayOfString, paramArrayOfInt);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.permission.MainProcessPermissionFragment
 * JD-Core Version:    0.7.0.1
 */