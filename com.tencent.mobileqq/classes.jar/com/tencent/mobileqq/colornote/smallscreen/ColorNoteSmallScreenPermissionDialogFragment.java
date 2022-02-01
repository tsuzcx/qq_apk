package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqci;
import aqff;
import aqfg;
import bcst;
import bglp;
import bgpa;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class ColorNoteSmallScreenPermissionDialogFragment
  extends PublicBaseFragment
{
  public static boolean a;
  
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
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenPermissionDialogFragment", 2, "showPermissionDialog in");
    }
    Object localObject = getActivity().getIntent();
    if (localObject != null) {}
    for (int i = ((Intent)localObject).getIntExtra("key_permission_from", 1);; i = 1)
    {
      int m = 2131690752;
      int j;
      if (i == 2)
      {
        j = 2131690753;
        localObject = bglp.a(getActivity(), 230).setMessage(j).setPositiveButton(2131690754, new aqff(this));
        ((bgpa)localObject).setTitle(2131690755);
        ((bgpa)localObject).setCancelable(true);
        ((bgpa)localObject).setOnCancelListener(new aqfg(this));
        ((bgpa)localObject).setCanceledOnTouchOutside(false);
        ((bgpa)localObject).show();
        a = true;
        if (i != 2) {
          break label197;
        }
      }
      label197:
      for (i = k;; i = 2)
      {
        bcst.b(null, "dc00898", "", "", "0X800AB3A", "0X800AB3A", i, 0, "", "", "", "");
        paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        j = m;
        if (i != 3) {
          break;
        }
        aqci.b(true);
        j = m;
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment
 * JD-Core Version:    0.7.0.1
 */