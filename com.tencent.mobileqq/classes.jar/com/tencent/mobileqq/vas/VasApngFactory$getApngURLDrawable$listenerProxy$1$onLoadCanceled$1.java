package com.tencent.mobileqq.vas;

import bgfu;
import bgfv;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class VasApngFactory$getApngURLDrawable$listenerProxy$1$onLoadCanceled$1
  extends Lambda
  implements Function0<Unit>
{
  public VasApngFactory$getApngURLDrawable$listenerProxy$1$onLoadCanceled$1(bgfv parambgfv, URLDrawable paramURLDrawable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.a.a().onLoadCanceled(this.$d);
    if (QLog.isColorLevel()) {
      QLog.d("VasApngFactory", 2, "onLoadCanceled: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngFactory.getApngURLDrawable.listenerProxy.1.onLoadCanceled.1
 * JD-Core Version:    0.7.0.1
 */