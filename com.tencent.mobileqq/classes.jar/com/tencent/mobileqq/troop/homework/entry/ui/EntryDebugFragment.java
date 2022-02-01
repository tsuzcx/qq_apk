package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class EntryDebugFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener
{
  private <T extends View> T a(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    QPublicFragmentActivity.start(paramActivity, localIntent, EntryDebugFragment.class);
  }
  
  protected int a()
  {
    return 2131560661;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b.setBackgroundColor(-1);
    paramLayoutInflater = new int[7];
    LayoutInflater tmp21_20 = paramLayoutInflater;
    tmp21_20[0] = 2131373246;
    LayoutInflater tmp26_21 = tmp21_20;
    tmp26_21[1] = 2131378065;
    LayoutInflater tmp31_26 = tmp26_21;
    tmp31_26[2] = 2131378063;
    LayoutInflater tmp36_31 = tmp31_26;
    tmp36_31[3] = 2131378066;
    LayoutInflater tmp41_36 = tmp36_31;
    tmp41_36[4] = 2131363492;
    LayoutInflater tmp46_41 = tmp41_36;
    tmp46_41[5] = 2131364132;
    LayoutInflater tmp51_46 = tmp46_41;
    tmp51_46[6] = 2131376515;
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
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131373246) {
      PublishHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), null);
    } else if (i == 2131364132) {
      ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).start_BulkSendMessageFragment(getActivity(), getActivity().getIntent().getExtras());
    } else if (i == 2131378065) {
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416265328L);
    } else if (i == 2131378063) {
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416243152L);
    } else if (i == 2131378066) {
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416294178L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment
 * JD-Core Version:    0.7.0.1
 */