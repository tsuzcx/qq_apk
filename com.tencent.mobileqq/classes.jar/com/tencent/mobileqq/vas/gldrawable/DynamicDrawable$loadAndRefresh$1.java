package com.tencent.mobileqq.vas.gldrawable;

import bhqs;
import bhqt;
import bhrg;
import bhrh;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class DynamicDrawable$loadAndRefresh$1
  implements Runnable
{
  public DynamicDrawable$loadAndRefresh$1(bhqs parambhqs, bhrg parambhrg) {}
  
  public final void run()
  {
    bhqt localbhqt = new bhqt(new WeakReference(this.this$0));
    if (!this.a.a())
    {
      this.a.a((bhrh)localbhqt);
      return;
    }
    localbhqt.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.loadAndRefresh.1
 * JD-Core Version:    0.7.0.1
 */