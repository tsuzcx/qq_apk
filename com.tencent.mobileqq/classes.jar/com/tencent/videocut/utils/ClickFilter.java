package com.tencent.videocut.utils;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/ClickFilter;", "Landroid/view/View$OnClickListener;", "intervalMs", "", "listener", "Lkotlin/Function1;", "Landroid/view/View;", "", "(JLkotlin/jvm/functions/Function1;)V", "lastClickTime", "onClick", "v", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class ClickFilter
  implements View.OnClickListener
{
  private long a;
  private final long b;
  private final Function1<View, Unit> c;
  
  public void onClick(@Nullable View paramView)
  {
    if (SystemClock.elapsedRealtime() - this.a >= this.b)
    {
      this.a = SystemClock.elapsedRealtime();
      this.c.invoke(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.ClickFilter
 * JD-Core Version:    0.7.0.1
 */