package com.tencent.mobileqq.vas.apng.api;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VasApngFactory$getApngURLDrawable$listenerProxy$1$onLoadProgressed$1
  extends Lambda
  implements Function0<Unit>
{
  VasApngFactory$getApngURLDrawable$listenerProxy$1$onLoadProgressed$1(VasApngFactory.getApngURLDrawable.listenerProxy.1 param1, URLDrawable paramURLDrawable, int paramInt)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.a.a().onLoadProgressed(this.$d, this.$progress);
    if (QLog.isColorLevel()) {
      QLog.d("VasApngFactory", 2, "onLoadProgressed: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.VasApngFactory.getApngURLDrawable.listenerProxy.1.onLoadProgressed.1
 * JD-Core Version:    0.7.0.1
 */