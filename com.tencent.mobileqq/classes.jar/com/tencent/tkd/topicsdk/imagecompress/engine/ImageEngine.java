package com.tencent.tkd.topicsdk.imagecompress.engine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.tencent.tkd.topicsdk.imagecompress.Checker;
import com.tencent.tkd.topicsdk.imagecompress.InputStreamProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/imagecompress/engine/ImageEngine;", "Lcom/tencent/tkd/topicsdk/imagecompress/engine/IEngine;", "srcImg", "Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;", "tagImg", "Ljava/io/File;", "focusAlpha", "", "(Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;Ljava/io/File;Z)V", "srcHeight", "", "srcWidth", "compress", "computeSize", "rotatingImage", "Landroid/graphics/Bitmap;", "bitmap", "angle", "topicsdk_release"}, k=1, mv={1, 1, 16})
public class ImageEngine
  implements IEngine
{
  private int a;
  private int b;
  private final InputStreamProvider c;
  private final File d;
  private final boolean e;
  
  public ImageEngine(@NotNull InputStreamProvider paramInputStreamProvider, @NotNull File paramFile, boolean paramBoolean)
  {
    this.c = paramInputStreamProvider;
    this.d = paramFile;
    this.e = paramBoolean;
    paramInputStreamProvider = new BitmapFactory.Options();
    paramInputStreamProvider.inJustDecodeBounds = true;
    paramInputStreamProvider.inSampleSize = 1;
    BitmapFactory.decodeStream(this.c.a(), null, paramInputStreamProvider);
    this.a = paramInputStreamProvider.outWidth;
    this.b = paramInputStreamProvider.outHeight;
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "Bitmap.createBitmap(\n   …           true\n        )");
    return paramBitmap;
  }
  
  private final int b()
  {
    int j = this.a;
    int i = j;
    if (j % 2 == 1) {
      i = j + 1;
    }
    this.a = i;
    j = this.b;
    i = j;
    if (j % 2 == 1) {
      i = j + 1;
    }
    this.b = i;
    i = RangesKt.coerceAtLeast(this.a, this.b);
    float f = RangesKt.coerceAtMost(this.a, this.b) / i;
    if ((f <= 1) && (f > 0.5625D))
    {
      if (i < 1664) {
        return 1;
      }
      if (i < 4990) {
        return 2;
      }
      if ((4991 <= i) && (10239 >= i)) {
        return 4;
      }
      return i / 1280;
    }
    double d2 = f;
    if ((d2 <= 0.5625D) && (d2 > 0.5D))
    {
      i /= 1280;
      if (i == 0) {
        return 1;
      }
      return i;
    }
    double d1 = i;
    Double.isNaN(d2);
    d2 = 1280.0D / d2;
    Double.isNaN(d1);
    return (int)Math.ceil(d1 / d2);
  }
  
  @NotNull
  public File a()
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inSampleSize = b();
    Object localObject2 = BitmapFactory.decodeStream(this.c.a(), null, (BitmapFactory.Options)localObject1);
    if (localObject2 != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject1 = localObject2;
      if (Checker.SINGLE.isJPG(this.c.a())) {
        localObject1 = a((Bitmap)localObject2, Checker.SINGLE.getOrientation(this.c.a()));
      }
      if (this.e) {
        localObject2 = Bitmap.CompressFormat.PNG;
      } else {
        localObject2 = Bitmap.CompressFormat.JPEG;
      }
      ((Bitmap)localObject1).compress((Bitmap.CompressFormat)localObject2, 60, (OutputStream)localByteArrayOutputStream);
      ((Bitmap)localObject1).recycle();
      localObject1 = new FileOutputStream(this.d);
      ((FileOutputStream)localObject1).write(localByteArrayOutputStream.toByteArray());
      ((FileOutputStream)localObject1).flush();
      ((FileOutputStream)localObject1).close();
      localByteArrayOutputStream.close();
      return this.d;
    }
    return new File(this.c.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.ImageEngine
 * JD-Core Version:    0.7.0.1
 */