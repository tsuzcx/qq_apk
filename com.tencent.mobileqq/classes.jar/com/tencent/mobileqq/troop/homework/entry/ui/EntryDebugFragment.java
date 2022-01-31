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
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;

public class EntryDebugFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private View a(int paramInt)
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
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mContentView.setBackgroundColor(-1);
    paramLayoutInflater = new int[7];
    LayoutInflater tmp21_20 = paramLayoutInflater;
    tmp21_20[0] = 2131368413;
    LayoutInflater tmp26_21 = tmp21_20;
    tmp26_21[1] = 2131368414;
    LayoutInflater tmp31_26 = tmp26_21;
    tmp31_26[2] = 2131368415;
    LayoutInflater tmp36_31 = tmp31_26;
    tmp36_31[3] = 2131368416;
    LayoutInflater tmp41_36 = tmp36_31;
    tmp41_36[4] = 2131368417;
    LayoutInflater tmp46_41 = tmp41_36;
    tmp46_41[5] = 2131368418;
    LayoutInflater tmp51_46 = tmp46_41;
    tmp51_46[6] = 2131368419;
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
  
  protected int getContentLayoutId()
  {
    return 2130969913;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368413: 
      PublishHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), null);
      return;
    case 2131368418: 
      BulkSendMessageFragment.a(getActivity(), getActivity().getIntent().getExtras());
      return;
    case 2131368414: 
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416265328L);
      return;
    case 2131368415: 
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416243152L);
      return;
    case 2131368416: 
      SubmitHomeWorkFragment.a(getActivity(), getActivity().getIntent().getExtras(), 681674162L, 1804117416294178L);
      return;
    case 2131368419: 
      CheckArithHWResultFragment.a(getActivity(), "http://omn550dan.bkt.clouddn.com/math_hw_1.jpg", "{\"errorcode\":0,\"errormsg\":\"OK\",\"session_id\":\"xxxxxx\",\"width\":3024,\"height\":4032,\"items\":[{\"itemstring\":\"4+12-3=2\",\"itemcoord\":{\"x\":474,\"y\":379,\"width\":783,\"height\":210},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"6+3-2=7\",\"itemcoord\":{\"x\":488,\"y\":591,\"width\":710,\"height\":197},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"3+3+12=8\",\"itemcoord\":{\"x\":1917,\"y\":595,\"width\":836,\"height\":199},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"1+14-3=17\",\"itemcoord\":{\"x\":532,\"y\":835,\"width\":713,\"height\":187},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"3+12-4=\",\"itemcoord\":{\"x\":1954,\"y\":837,\"width\":776,\"height\":153},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"13-11+2=4\",\"itemcoord\":{\"x\":1935,\"y\":1055,\"width\":846,\"height\":187},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"16-15+1=2\",\"itemcoord\":{\"x\":473,\"y\":1069,\"width\":746,\"height\":169},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"2+12+1=15\",\"itemcoord\":{\"x\":1926,\"y\":1292,\"width\":776,\"height\":191},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"18-16+2=1\",\"itemcoord\":{\"x\":523,\"y\":1294,\"width\":768,\"height\":191},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"13+4-3=<\",\"itemcoord\":{\"x\":1922,\"y\":1515,\"width\":782,\"height\":182},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"1+12+3=16\",\"itemcoord\":{\"x\":485,\"y\":1526,\"width\":760,\"height\":172},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"1+5+11=17\",\"itemcoord\":{\"x\":463,\"y\":1742,\"width\":795,\"height\":193},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"4+2+12=8\",\"itemcoord\":{\"x\":1900,\"y\":1743,\"width\":828,\"height\":206},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"14-11+2=5\",\"itemcoord\":{\"x\":1923,\"y\":1968,\"width\":808,\"height\":190},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"16-1-11=4\",\"itemcoord\":{\"x\":560,\"y\":1969,\"width\":826,\"height\":197},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"17-2-13=4\",\"itemcoord\":{\"x\":1894,\"y\":2197,\"width\":811,\"height\":214},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"15-12-2=\",\"itemcoord\":{\"x\":471,\"y\":2204,\"width\":755,\"height\":171},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"2+12-2=7\",\"itemcoord\":{\"x\":502,\"y\":2412,\"width\":755,\"height\":200},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"85.5≠114\",\"itemcoord\":{\"x\":1926,\"y\":2418,\"width\":762,\"height\":216},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"2+3+2=7\",\"itemcoord\":{\"x\":495,\"y\":2621,\"width\":802,\"height\":228},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"4-2+4=8\",\"itemcoord\":{\"x\":2000,\"y\":2670,\"width\":817,\"height\":222},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"17-15+3=5\",\"itemcoord\":{\"x\":560,\"y\":2873,\"width\":816,\"height\":184},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"12-1=4\",\"itemcoord\":{\"x\":2024,\"y\":2896,\"width\":857,\"height\":231},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"16-14+11=3\",\"itemcoord\":{\"x\":438,\"y\":3098,\"width\":927,\"height\":209},\"correct\":\"false\",\"confidence\":100.0},{\"itemstring\":\"4+11-13=2\",\"itemcoord\":{\"x\":2019,\"y\":3126,\"width\":868,\"height\":207},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"05+11-4=12\",\"itemcoord\":{\"x\":407,\"y\":3330,\"width\":906,\"height\":223},\"correct\":\"true\",\"confidence\":100.0},{\"itemstring\":\"16-12+3=7\",\"itemcoord\":{\"x\":2038,\"y\":3378,\"width\":832,\"height\":185},\"correct\":\"true\",\"confidence\":100.0}]}\n", "cb", "1803271450927064", "101239725");
      return;
    }
    BeginnerGuideFragment.a(getActivity(), getActivity().getIntent().getExtras(), 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment
 * JD-Core Version:    0.7.0.1
 */