package dov.com.qq.im.aeeditor.view.reorder;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "dov/com/qq/im/aeeditor/view/reorder/ThumbClipView$onThumbGenerated$1$1"}, k=3, mv={1, 1, 16})
final class ThumbClipView$onThumbGenerated$$inlined$forEach$lambda$1
  implements Runnable
{
  ThumbClipView$onThumbGenerated$$inlined$forEach$lambda$1(ImageView paramImageView, ThumbClipView paramThumbClipView, Bitmap paramBitmap, Object paramObject) {}
  
  public final void run()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      Resources localResources = this.this$0.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localResources, "resources");
      localImageView.setImageDrawable((Drawable)new SafeBitmapDrawable(localResources, this.jdField_a_of_type_AndroidGraphicsBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.reorder.ThumbClipView.onThumbGenerated..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */