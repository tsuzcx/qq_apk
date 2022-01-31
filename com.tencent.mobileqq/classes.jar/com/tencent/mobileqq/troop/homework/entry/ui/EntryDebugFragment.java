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
    tmp21_20[0] = 2131372465;
    LayoutInflater tmp26_21 = tmp21_20;
    tmp26_21[1] = 2131377220;
    LayoutInflater tmp31_26 = tmp26_21;
    tmp31_26[2] = 2131377218;
    LayoutInflater tmp36_31 = tmp31_26;
    tmp36_31[3] = 2131377221;
    LayoutInflater tmp41_36 = tmp36_31;
    tmp41_36[4] = 2131363176;
    LayoutInflater tmp46_41 = tmp41_36;
    tmp46_41[5] = 2131363781;
    LayoutInflater tmp51_46 = tmp46_41;
    tmp51_46[6] = 2131375760;
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
    return 2131560452;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372465: 
      PublishHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), null);
      return;
    case 2131363781: 
      BulkSendMessageFragment.a(getActivity(), getActivity().getIntent().getExtras());
      return;
    case 2131377220: 
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416265328L);
      return;
    case 2131377218: 
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416243152L);
      return;
    case 2131377221: 
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416294178L);
      return;
    case 2131375760: 
      return;
    }
    BeginnerGuideFragment.a(getActivity(), getActivity().getIntent().getExtras(), 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment
 * JD-Core Version:    0.7.0.1
 */