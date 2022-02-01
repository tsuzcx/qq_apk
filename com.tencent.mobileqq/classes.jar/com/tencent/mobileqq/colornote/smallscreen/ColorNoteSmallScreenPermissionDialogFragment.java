package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class ColorNoteSmallScreenPermissionDialogFragment
  extends QPublicBaseFragment
{
  public static boolean a = false;
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenPermissionDialogFragment", 2, "showPermissionDialog in");
    }
    Object localObject = getQBaseActivity().getIntent();
    int i;
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("key_permission_from", 1);
    } else {
      i = 1;
    }
    int k = 2131690898;
    int j;
    if (i == 2)
    {
      j = 2131690899;
    }
    else
    {
      j = k;
      if (i == 3)
      {
        ColorNoteRecentView.b(getQBaseActivity().getAppRuntime(), true);
        j = k;
      }
    }
    localObject = DialogUtil.a(getQBaseActivity(), 230).setMessage(j).setPositiveButton(2131690900, new ColorNoteSmallScreenPermissionDialogFragment.1(this));
    ((QQCustomDialog)localObject).setTitle(2131690901);
    ((QQCustomDialog)localObject).setCancelable(true);
    ((QQCustomDialog)localObject).setOnCancelListener(new ColorNoteSmallScreenPermissionDialogFragment.2(this));
    ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
    ((QQCustomDialog)localObject).show();
    a = true;
    if (i == 2) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AB3A", "0X800AB3A", i, 0, "", "", "", "");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment
 * JD-Core Version:    0.7.0.1
 */