package com.tencent.xaction.view;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.base.DecorDrawable.Companion;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEmptyView$Companion$setBgStyle$1$1
  implements Runnable
{
  XAEmptyView$Companion$setBgStyle$1$1(XAEmptyView.Companion.setBgStyle.1 param1, Bitmap paramBitmap) {}
  
  public final void run()
  {
    Object localObject = this.a.getNinePatchChunk();
    if ((localObject != null) && (NinePatch.isNinePatchChunk((byte[])localObject))) {
      localObject = (Drawable)new NinePatchDrawable(this.this$0.jdField_a_of_type_AndroidViewView.getResources(), new NinePatch(this.a, (byte[])localObject, null));
    } else {
      localObject = (Drawable)new BitmapDrawable(this.this$0.jdField_a_of_type_AndroidViewView.getResources(), this.a);
    }
    DecorDrawable.Companion.a(DecorDrawable.Companion, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_AndroidViewView, (Drawable)localObject, false, 8, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView.Companion.setBgStyle.1.1
 * JD-Core Version:    0.7.0.1
 */