package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class EntryDebugFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    PublicFragmentActivity.a(paramActivity, localIntent, EntryDebugFragment.class);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mContentView.setBackgroundColor(-1);
    paramLayoutInflater = new int[7];
    LayoutInflater tmp21_20 = paramLayoutInflater;
    tmp21_20[0] = 2131373355;
    LayoutInflater tmp26_21 = tmp21_20;
    tmp26_21[1] = 2131378244;
    LayoutInflater tmp31_26 = tmp26_21;
    tmp31_26[2] = 2131378242;
    LayoutInflater tmp36_31 = tmp31_26;
    tmp36_31[3] = 2131378245;
    LayoutInflater tmp41_36 = tmp36_31;
    tmp41_36[4] = 2131363483;
    LayoutInflater tmp46_41 = tmp41_36;
    tmp46_41[5] = 2131364112;
    LayoutInflater tmp51_46 = tmp46_41;
    tmp51_46[6] = 2131376640;
    tmp51_46;
    int j = paramLayoutInflater.length;
    int i = 0;
    while (i < j)
    {
      paramViewGroup = a(paramLayoutInflater[i]);
      if (paramViewGroup != null) {
        paramViewGroup.setOnClickListener(this);
      }
      i += 1;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560685;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublishHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), null);
      continue;
      BulkSendMessageFragment.a(getActivity(), getActivity().getIntent().getExtras());
      continue;
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416265328L);
      continue;
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416243152L);
      continue;
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416294178L);
      continue;
      continue;
      BeginnerGuideFragment.a(getActivity(), getActivity().getIntent().getExtras(), 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment
 * JD-Core Version:    0.7.0.1
 */