package com.tencent.mobileqq.flashshow.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSMainFragment$1
  implements View.OnClickListener
{
  FSMainFragment$1(FSMainFragment paramFSMainFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null) {
      this.a.getActivity().onBackPressed();
    }
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(null, null).a(136).b(2));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSMainFragment.1
 * JD-Core Version:    0.7.0.1
 */