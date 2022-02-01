package com.tencent.mobileqq.onlinestatus.olympic.fragment;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareHelper.IShareFinishCallback;

class OlympicShareFragment$1
  implements OlympicShareHelper.IShareFinishCallback
{
  OlympicShareFragment$1(OlympicShareFragment paramOlympicShareFragment) {}
  
  public void a()
  {
    if ((this.a.getActivity() != null) && (!this.a.getActivity().isFinishing())) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.fragment.OlympicShareFragment.1
 * JD-Core Version:    0.7.0.1
 */