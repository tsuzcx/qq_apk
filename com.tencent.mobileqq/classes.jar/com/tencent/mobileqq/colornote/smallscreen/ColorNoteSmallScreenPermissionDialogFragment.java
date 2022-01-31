package com.tencent.mobileqq.colornote.smallscreen;

import amjo;
import amjp;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import axqy;
import bbdj;
import bbgu;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class ColorNoteSmallScreenPermissionDialogFragment
  extends PublicBaseFragment
{
  public static boolean a;
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenPermissionDialogFragment", 2, "showPermissionDialog in");
    }
    bbgu localbbgu = bbdj.a(getActivity(), 230).setMessage(2131690858).setNegativeButton(2131690596, new amjp(this)).setPositiveButton(2131690859, new amjo(this));
    localbbgu.setTitle(2131690860);
    localbbgu.setCancelable(false);
    localbbgu.setCanceledOnTouchOutside(false);
    localbbgu.show();
    a = true;
    axqy.b(null, "dc00898", "", "", "0X800AB3A", "0X800AB3A", 0, 0, "", "", "", "");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment
 * JD-Core Version:    0.7.0.1
 */