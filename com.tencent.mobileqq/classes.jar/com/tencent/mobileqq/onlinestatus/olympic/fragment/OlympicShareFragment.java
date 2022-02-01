package com.tencent.mobileqq.onlinestatus.olympic.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareHelper;

public class OlympicShareFragment
  extends QPublicBaseFragment
{
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    paramIntent.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(paramActivity, paramIntent, QPublicTransFragmentActivity.class, OlympicShareFragment.class);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if (((paramInt2 == -1) || (paramInt2 == 0)) && (getActivity() != null) && (!getActivity().isFinishing())) {
      getActivity().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    long l = getActivity().getIntent().getLongExtra("KEY_OLYMPIC_RANK", 0L);
    paramBundle = (AppInterface)getQBaseActivity().getAppRuntime();
    OlympicShareHelper.a(l, getActivity(), paramBundle, new OlympicShareFragment.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.fragment.OlympicShareFragment
 * JD-Core Version:    0.7.0.1
 */