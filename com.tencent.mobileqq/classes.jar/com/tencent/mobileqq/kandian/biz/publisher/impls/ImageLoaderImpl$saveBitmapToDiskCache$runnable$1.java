package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ImageLoaderImpl$saveBitmapToDiskCache$runnable$1
  implements Runnable
{
  ImageLoaderImpl$saveBitmapToDiskCache$runnable$1(ImageLoaderImpl paramImageLoaderImpl, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    DiskLruCache.Editor localEditor = ImageLoaderImpl.b(this.this$0).edit(this.a);
    if (localEditor != null)
    {
      this.b.compress(Bitmap.CompressFormat.PNG, 100, localEditor.newOutputStream(0));
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ImageLoaderImpl.saveBitmapToDiskCache.runnable.1
 * JD-Core Version:    0.7.0.1
 */