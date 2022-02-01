package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.widget.Toast;
import com.tencent.mobileqq.kandian.base.imagecrop.callback.CropCallback;
import org.jetbrains.annotations.NotNull;

class GalleryFragment$3
  implements CropCallback
{
  GalleryFragment$3(GalleryFragment paramGalleryFragment, OutputPicListener paramOutputPicListener) {}
  
  public void a()
  {
    Toast.makeText(this.b.a, 2131915538, 1).show();
  }
  
  public void a(@NotNull String paramString)
  {
    OutputPicListener localOutputPicListener = this.a;
    if (localOutputPicListener != null) {
      localOutputPicListener.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.GalleryFragment.3
 * JD-Core Version:    0.7.0.1
 */