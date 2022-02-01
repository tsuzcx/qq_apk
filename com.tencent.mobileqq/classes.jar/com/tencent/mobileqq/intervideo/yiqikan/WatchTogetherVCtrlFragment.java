package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import awfh;
import bhlq;
import bhme;
import bhpc;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class WatchTogetherVCtrlFragment
  extends PublicBaseFragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getActivity();
    if (paramViewGroup == null) {
      QLog.e("WatchTogetherVCtrlFragment", 1, "activity is null");
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramBundle = bhlq.a(paramViewGroup, "请下载QQ新版本查看");
      paramBundle.setPositiveButton(2131694098, new bhme());
      paramBundle.show();
      paramBundle.setOnDismissListener(new awfh(this, paramViewGroup));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherVCtrlFragment
 * JD-Core Version:    0.7.0.1
 */