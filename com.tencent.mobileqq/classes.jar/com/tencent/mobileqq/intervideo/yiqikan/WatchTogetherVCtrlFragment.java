package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import arlj;
import bbdj;
import bbdt;
import bbgu;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherVCtrlFragment
  extends PublicBaseFragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getActivity();
    if (paramViewGroup == null)
    {
      QLog.e("WatchTogetherVCtrlFragment", 1, "activity is null");
      return paramLayoutInflater;
    }
    paramBundle = bbdj.a(paramViewGroup, "请下载QQ新版本查看");
    paramBundle.setPositiveButton(2131694794, new bbdt());
    paramBundle.show();
    paramBundle.setOnDismissListener(new arlj(this, paramViewGroup));
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherVCtrlFragment
 * JD-Core Version:    0.7.0.1
 */