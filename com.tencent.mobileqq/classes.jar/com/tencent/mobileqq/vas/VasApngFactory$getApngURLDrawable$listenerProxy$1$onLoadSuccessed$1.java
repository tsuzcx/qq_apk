package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import bgfu;
import bgfv;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class VasApngFactory$getApngURLDrawable$listenerProxy$1$onLoadSuccessed$1
  extends Lambda
  implements Function0<Unit>
{
  public VasApngFactory$getApngURLDrawable$listenerProxy$1$onLoadSuccessed$1(bgfv parambgfv, URLDrawable paramURLDrawable)
  {
    super(0);
  }
  
  public final void invoke()
  {
    int j = 1;
    Drawable localDrawable = this.$d.getCurrDrawable();
    int i;
    if ((localDrawable != null) && ((localDrawable instanceof ApngDrawable)))
    {
      if (this.this$0.a.a().length != 0) {
        break label96;
      }
      i = 1;
      if (i != 0) {
        break label101;
      }
      i = j;
      label43:
      if (i == 0) {
        break label106;
      }
      ApngImage.playByTag(this.this$0.a.a()[0]);
    }
    for (;;)
    {
      this.this$0.a.a().onLoadSuccessed(this.$d);
      if (QLog.isColorLevel()) {
        QLog.d("VasApngFactory", 2, "onLoadSuccessed: ");
      }
      return;
      label96:
      i = 0;
      break;
      label101:
      i = 0;
      break label43;
      label106:
      ((ApngDrawable)localDrawable).getImage().setSupportGlobalPasued(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngFactory.getApngURLDrawable.listenerProxy.1.onLoadSuccessed.1
 * JD-Core Version:    0.7.0.1
 */