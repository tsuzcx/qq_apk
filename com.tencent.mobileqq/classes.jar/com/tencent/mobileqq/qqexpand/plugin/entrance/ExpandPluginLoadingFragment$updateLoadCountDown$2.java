package com.tencent.mobileqq.qqexpand.plugin.entrance;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateLoadCountDown$2
  implements Runnable
{
  ExpandPluginLoadingFragment$updateLoadCountDown$2(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, double paramDouble1, double paramDouble2) {}
  
  public final void run()
  {
    double d4 = this.a;
    double d3 = this.b;
    boolean bool = ExpandPluginLoadingFragment.m(this.this$0);
    double d2 = 0.0D;
    double d1;
    if (bool)
    {
      d1 = d3;
      if (this.a >= 1.0D)
      {
        d2 = d4 - 1.0D;
        d1 = d3;
      }
    }
    else if (this.b >= 2.0D)
    {
      d1 = d3 - 1.0D;
    }
    else
    {
      d1 = 1.0D;
    }
    this.this$0.a(d2, d1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.updateLoadCountDown.2
 * JD-Core Version:    0.7.0.1
 */