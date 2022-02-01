package com.tencent.mobileqq.vas.apng.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadSuccessed$1
  extends Lambda
  implements Function0<Unit>
{
  VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1$onLoadSuccessed$1(VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1 param1, URLDrawable paramURLDrawable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Drawable localDrawable = this.$d.getCurrDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof ApngDrawable)))
    {
      int i;
      if (this.this$0.b.b().length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0) {
        ApngImage.playByTag(this.this$0.b.b()[0]);
      } else {
        ((ApngDrawable)localDrawable).getImage().setSupportGlobalPasued(false);
      }
    }
    this.this$0.b.j().onLoadSuccessed(this.$d);
    if (QLog.isColorLevel()) {
      QLog.d("VasApngFactory", 2, "onLoadSuccessed: ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1.onLoadSuccessed.1
 * JD-Core Version:    0.7.0.1
 */