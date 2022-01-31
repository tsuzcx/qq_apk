package com.tencent.mobileqq.colornote.smallscreen;

import alue;
import aluf;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import babr;
import bafb;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class ColorNoteSmallScreenPermissionDialogFragment
  extends PublicBaseFragment
{
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
    bafb localbafb = babr.a(getActivity(), 230).setMessage(2131630460).setNegativeButton(2131625035, new aluf(this)).setPositiveButton(2131630464, new alue(this));
    localbafb.setTitle(2131630462);
    localbafb.setCancelable(false);
    localbafb.setCanceledOnTouchOutside(false);
    localbafb.show();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment
 * JD-Core Version:    0.7.0.1
 */