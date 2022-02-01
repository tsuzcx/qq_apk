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
  private int jdField_a_of_type_Int;
  private final InputStreamProvider jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider;
  private final File jdField_a_of_type_JavaIoFile;
  private final boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ImageEngine(@NotNull InputStreamProvider paramInputStreamProvider, @NotNull File paramFile, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider = paramInputStreamProvider;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramInputStreamProvider = new BitmapFactory.Options();
    paramInputStreamProvider.inJustDecodeBounds = true;
    paramInputStreamProvider.inSampleSize = 1;
    BitmapFactory.decodeStream(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider.a(), null, paramInputStreamProvider);
    this.jdField_a_of_type_Int = paramInputStreamProvider.outWidth;
    this.b = paramInputStreamProvider.outHeight;
  }
  
  private final int a()
  {
    if (this.jdField_a_of_type_Int % 2 == 1)
    {
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      if (this.b % 2 != 1) {
        break label105;
      }
    }
    float f;
    label105:
    for (int i = this.b + 1;; i = this.b)
    {
      this.b = i;
      i = RangesKt.coerceAtLeast(this.jdField_a_of_type_Int, this.b);
      f = RangesKt.coerceAtMost(this.jdField_a_of_type_Int, this.b) / i;
      if ((f > 1) || (f <= 0.5625D)) {
        break label144;
      }
      if (i >= 1664) {
        break label113;
      }
      return 1;
      i = this.jdField_a_of_type_Int;
      break;
    }
    label113:
    if (i < 4990) {
      return 2;
    }
    if (4991 > i) {}
    while (10239 < i) {
      return i / 1280;
    }
    return 4;
    label144:
    if ((f <= 0.5625D) && (f > 0.5D))
    {
      if (i / 1280 == 0) {
        return 1;
      }
      return i / 1280;
    }
    return (int)Math.ceil(i / (1280.0D / f));
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(paramInt);
    paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "Bitmap.createBitmap(\n   …           true\n        )");
    return paramBitmap;
  }
  
  @NotNull
  public File a()
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = a();
    localObject = BitmapFactory.decodeStream(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider.a(), null, (BitmapFactory.Options)localObject);
    ByteArrayOutputStream localByteArrayOutputStream;
    if (localObject != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      if (!Checker.SINGLE.isJPG(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider.a())) {
        break label170;
      }
      localObject = a((Bitmap)localObject, Checker.SINGLE.getOrientation(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider.a()));
    }
    label170:
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;; localCompressFormat = Bitmap.CompressFormat.JPEG)
      {
        ((Bitmap)localObject).compress(localCompressFormat, 60, (OutputStream)localByteArrayOutputStream);
        ((Bitmap)localObject).recycle();
        localObject = new FileOutputStream(this.jdField_a_of_type_JavaIoFile);
        ((FileOutputStream)localObject).write(localByteArrayOutputStream.toByteArray());
        ((FileOutputStream)localObject).flush();
        ((FileOutputStream)localObject).close();
        localByteArrayOutputStream.close();
        return this.jdField_a_of_type_JavaIoFile;
        return new File(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.ImageEngine
 * JD-Core Version:    0.7.0.1
 */