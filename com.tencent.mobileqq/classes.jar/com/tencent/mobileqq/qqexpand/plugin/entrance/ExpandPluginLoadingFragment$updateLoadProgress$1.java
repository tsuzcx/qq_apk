package com.tencent.mobileqq.qqexpand.plugin.entrance;

import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandPluginLoadingFragment$updateLoadProgress$1
  implements Runnable
{
  ExpandPluginLoadingFragment$updateLoadProgress$1(ExpandPluginLoadingFragment paramExpandPluginLoadingFragment, int paramInt) {}
  
  public final void run()
  {
    int j = this.a;
    if (j > 100) {
      return;
    }
    int i = j;
    if (j == 0) {
      if (ExpandPluginLoadingFragment.j(this.this$0)) {
        i = (int)60.0D;
      } else {
        i = RangesKt.random(new IntRange(ExpandPluginLoadingFragment.k(this.this$0), ExpandPluginLoadingFragment.k(this.this$0) + 5), (Random)Random.Default);
      }
    }
    ExpandPluginLoadingFragment.b(this.this$0, i);
    if (ExpandPluginLoadingFragment.j(this.this$0)) {
      j = RangesKt.random(new IntRange(ExpandPluginLoadingFragment.l(this.this$0), ExpandPluginLoadingFragment.l(this.this$0) + 2), (Random)Random.Default);
    } else {
      j = RangesKt.random(new IntRange(ExpandPluginLoadingFragment.k(this.this$0), ExpandPluginLoadingFragment.k(this.this$0) + 5), (Random)Random.Default);
    }
    this.this$0.b(i + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment.updateLoadProgress.1
 * JD-Core Version:    0.7.0.1
 */