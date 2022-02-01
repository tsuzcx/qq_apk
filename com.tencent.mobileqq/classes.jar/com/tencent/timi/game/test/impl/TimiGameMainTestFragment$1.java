package com.tencent.timi.game.test.impl;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.CustomToastView;

class TimiGameMainTestFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  TimiGameMainTestFragment$1(TimiGameMainTestFragment paramTimiGameMainTestFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "Yes_Http";
    } else {
      str = "MSF";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("网络底层切换(当前：");
    localStringBuilder.append(str);
    localStringBuilder.append(")   ");
    paramCompoundButton.setText(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TODO 网络底层已切换至 ");
    localStringBuilder.append(str);
    CustomToastView.a(localStringBuilder.toString());
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.test.impl.TimiGameMainTestFragment.1
 * JD-Core Version:    0.7.0.1
 */