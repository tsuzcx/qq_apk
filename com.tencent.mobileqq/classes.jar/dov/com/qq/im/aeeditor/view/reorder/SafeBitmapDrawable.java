package dov.com.qq.im.aeeditor.view.reorder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/view/reorder/SafeBitmapDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "res", "Landroid/content/res/Resources;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SafeBitmapDrawable
  extends BitmapDrawable
{
  public SafeBitmapDrawable(@NotNull Resources paramResources, @Nullable Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (getBitmap() != null)
    {
      Bitmap localBitmap = getBitmap();
      Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bitmap");
      if (!localBitmap.isRecycled()) {
        super.draw(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.reorder.SafeBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */