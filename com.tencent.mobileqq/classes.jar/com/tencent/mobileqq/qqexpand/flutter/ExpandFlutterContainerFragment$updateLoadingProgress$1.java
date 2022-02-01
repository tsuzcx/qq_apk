package com.tencent.mobileqq.qqexpand.flutter;

import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandFlutterContainerFragment$updateLoadingProgress$1
  implements Runnable
{
  ExpandFlutterContainerFragment$updateLoadingProgress$1(ExpandFlutterContainerFragment paramExpandFlutterContainerFragment, int paramInt) {}
  
  public final void run()
  {
    int j = this.a;
    ProgressBar localProgressBar = ExpandFlutterContainerFragment.e(this.this$0);
    if (localProgressBar != null) {
      i = localProgressBar.getProgress();
    } else {
      i = 0;
    }
    int i = j + i;
    if (i < 100)
    {
      localProgressBar = ExpandFlutterContainerFragment.e(this.this$0);
      if (localProgressBar != null) {
        localProgressBar.setProgress(i);
      }
      i = RangesKt.random(new IntRange(10, 15), (Random)Random.Default);
      ExpandFlutterContainerFragment.a(this.this$0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterContainerFragment.updateLoadingProgress.1
 * JD-Core Version:    0.7.0.1
 */