package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import aoey;
import aoez;
import azqs;
import bdgm;
import bdjz;
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
    bdjz localbdjz = bdgm.a(getActivity(), 230).setMessage(2131690911).setPositiveButton(2131690912, new aoey(this));
    localbdjz.setTitle(2131690913);
    localbdjz.setCancelable(true);
    localbdjz.setOnCancelListener(new aoez(this));
    localbdjz.setCanceledOnTouchOutside(false);
    localbdjz.show();
    a = true;
    azqs.b(null, "dc00898", "", "", "0X800AB3A", "0X800AB3A", 0, 0, "", "", "", "");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment
 * JD-Core Version:    0.7.0.1
 */