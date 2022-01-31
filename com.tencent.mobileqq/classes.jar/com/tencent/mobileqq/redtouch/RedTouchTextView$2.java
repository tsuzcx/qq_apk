package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import bbdr;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

class RedTouchTextView$2
  implements Runnable
{
  public void run()
  {
    Object localObject = new File(this.this$0.getContext().getFilesDir(), this.this$0.jdField_a_of_type_JavaLangString);
    Bitmap localBitmap;
    if (((File)localObject).exists())
    {
      localBitmap = this.this$0.a((File)localObject);
      localObject = localBitmap;
      if (this.a == 1) {
        localObject = bbdr.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
      }
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable((Bitmap)localObject);
      this.this$0.a();
    }
    while (RedTouchTextView.a(this.this$0)) {
      return;
    }
    RedTouchTextView.a(this.this$0, true);
    if (HttpDownloadUtil.a(null, this.this$0.jdField_a_of_type_JavaLangString, (File)localObject))
    {
      localBitmap = this.this$0.a((File)localObject);
      localObject = localBitmap;
      if (this.a == 1) {
        localObject = bbdr.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
      }
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable((Bitmap)localObject);
      this.this$0.a();
    }
    RedTouchTextView.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView.2
 * JD-Core Version:    0.7.0.1
 */