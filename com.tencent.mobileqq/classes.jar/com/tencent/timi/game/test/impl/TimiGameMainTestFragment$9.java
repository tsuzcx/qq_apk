package com.tencent.timi.game.test.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.CustomToastView;

class TimiGameMainTestFragment$9
  implements View.OnClickListener
{
  TimiGameMainTestFragment$9(TimiGameMainTestFragment paramTimiGameMainTestFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      Class localClass = Class.forName("hexin.ui.QImageCheckerFragment");
      QPublicFragmentActivity.start(this.a.getActivity(), localClass);
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    CustomToastView.a("启动失败");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameMainTestFragment.9
 * JD-Core Version:    0.7.0.1
 */