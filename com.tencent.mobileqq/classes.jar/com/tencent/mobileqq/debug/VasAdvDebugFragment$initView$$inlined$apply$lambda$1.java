package com.tencent.mobileqq.debug;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged", "com/tencent/mobileqq/debug/VasAdvDebugFragment$initView$1$1"}, k=3, mv={1, 1, 16})
final class VasAdvDebugFragment$initView$$inlined$apply$lambda$1
  implements CompoundButton.OnCheckedChangeListener
{
  VasAdvDebugFragment$initView$$inlined$apply$lambda$1(VasAdvDebugFragment paramVasAdvDebugFragment) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    VasAdvDebugFragment.a(this.a, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.VasAdvDebugFragment.initView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */