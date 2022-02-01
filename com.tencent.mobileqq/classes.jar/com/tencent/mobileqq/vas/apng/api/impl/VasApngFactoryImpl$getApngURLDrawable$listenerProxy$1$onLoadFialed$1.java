package com.tencent.mobileqq.vas.apng.api.impl;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadFialed$1
  extends Lambda
  implements Function0<Unit>
{
  VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadFialed$1(VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1 param1, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.a.a().onLoadFialed(this.$d, this.$t);
    if (QLog.isColorLevel()) {
      QLog.d("VasApngFactory", 2, "onLoadFialed: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1.onLoadFialed.1
 * JD-Core Version:    0.7.0.1
 */