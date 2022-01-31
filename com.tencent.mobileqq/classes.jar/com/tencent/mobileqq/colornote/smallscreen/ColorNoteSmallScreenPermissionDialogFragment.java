package com.tencent.mobileqq.colornote.smallscreen;

import amjp;
import amjq;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import axqw;
import bbcv;
import bbgg;
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
    bbgg localbbgg = bbcv.a(getActivity(), 230).setMessage(2131690858).setNegativeButton(2131690596, new amjq(this)).setPositiveButton(2131690859, new amjp(this));
    localbbgg.setTitle(2131690860);
    localbbgg.setCancelable(false);
    localbbgg.setCanceledOnTouchOutside(false);
    localbbgg.show();
    a = true;
    axqw.b(null, "dc00898", "", "", "0X800AB3A", "0X800AB3A", 0, 0, "", "", "", "");
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