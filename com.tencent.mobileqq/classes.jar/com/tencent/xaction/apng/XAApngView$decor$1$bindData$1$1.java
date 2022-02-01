package com.tencent.xaction.apng;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.image.ApngImage;
import com.tencent.xaction.api.data.ViewData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAApngView$decor$1$bindData$1$1
  implements Runnable
{
  XAApngView$decor$1$bindData$1$1(XAApngView.decor.1.bindData.1 param1, ApngDrawable paramApngDrawable) {}
  
  public final void run()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.this$0.this$0.a.setBackground((Drawable)this.a);
    }
    ViewData localViewData = this.this$0.this$0.e();
    if (localViewData == null) {
      Intrinsics.throwNpe();
    }
    ApngImage.playByTag(localViewData.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.XAApngView.decor.1.bindData.1.1
 * JD-Core Version:    0.7.0.1
 */