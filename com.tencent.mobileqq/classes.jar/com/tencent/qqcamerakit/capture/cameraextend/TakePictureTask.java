package com.tencent.qqcamerakit.capture.cameraextend;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.qqcamerakit.capture.CameraHandler.TakePictureData;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.capture.camera.CameraControl;
import com.tencent.qqcamerakit.capture.camera2.Camera2Control;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraAPIStrategy;
import com.tencent.qqcamerakit.common.QLog;
import java.io.File;
import java.io.IOException;

public class TakePictureTask
  extends AsyncTask<Void, Void, String>
{
  private CameraHandler.TakePictureData a;
  
  public TakePictureTask(CameraHandler.TakePictureData paramTakePictureData)
  {
    this.a = paramTakePictureData;
  }
  
  public int a()
  {
    if (!CameraAPIStrategy.a) {
      return CameraControl.a().b();
    }
    return Camera2Control.a().a();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = 0;
    }
    paramInt2 = (i + 45) / 90 * 90;
    if (paramInt1 == 1) {
      return (a() - paramInt2 + 360) % 360;
    }
    return (a() + paramInt2) % 360;
  }
  
  public Bitmap a(byte[] paramArrayOfByte, CameraSize paramCameraSize, boolean paramBoolean, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    int j = localOptions.outHeight;
    int k = localOptions.outWidth;
    int i;
    if (k > j) {
      i = 1;
    } else {
      i = 0;
    }
    double d1 = Math.max(j, k);
    Double.isNaN(d1);
    double d2 = Math.min(j, k);
    Double.isNaN(d2);
    double d6 = d1 * 1.0D / d2;
    d1 = paramCameraSize.b;
    Double.isNaN(d1);
    d2 = paramCameraSize.jdField_a_of_type_Int;
    Double.isNaN(d2);
    double d7 = d1 * 1.0D / d2;
    double d4 = k;
    d2 = j;
    if (d6 > d7) {
      if (i != 0) {
        Double.isNaN(d2);
      }
    }
    for (d1 = d7 * d2;; d1 *= d2)
    {
      d5 = d2;
      d3 = d1;
      d1 = d5;
      break label273;
      Double.isNaN(d4);
      for (d1 = d7 * d4;; d1 *= d4)
      {
        d3 = d4;
        break label273;
        if (d6 >= d7) {
          break label265;
        }
        if (i == 0) {
          break;
        }
        d1 = 1.0D / d7;
        Double.isNaN(d4);
      }
      d1 = 1.0D / d7;
      Double.isNaN(d2);
    }
    label265:
    d1 = d2;
    double d3 = d4;
    label273:
    if (QLog.a())
    {
      paramCameraSize = new StringBuilder();
      paramCameraSize.append("clipJpegToBitmap tw=");
      paramCameraSize.append(d3);
      paramCameraSize.append(" th=");
      paramCameraSize.append(d1);
      paramCameraSize.append(" bw=");
      paramCameraSize.append(k);
      paramCameraSize.append(" bh=");
      paramCameraSize.append(j);
      paramCameraSize.append(" br=");
      paramCameraSize.append(d6);
      paramCameraSize.append(" sr=");
      paramCameraSize.append(d7);
      QLog.c("TakePictureTask", 2, new Object[] { paramCameraSize.toString() });
    }
    localOptions.inJustDecodeBounds = false;
    Double.isNaN(d4);
    double d5 = (d4 - d3) / 2.0D;
    Double.isNaN(d4);
    d4 = (d4 + d3) / 2.0D;
    Double.isNaN(d2);
    d6 = (d2 - d1) / 2.0D;
    Double.isNaN(d2);
    d2 = (d2 + d1) / 2.0D;
    if (Build.VERSION.SDK_INT >= 10)
    {
      paramCameraSize = new Rect((int)d5, (int)d6, (int)d4, (int)d2);
      paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, true);
      paramCameraSize = paramArrayOfByte.decodeRegion(paramCameraSize, localOptions);
      paramArrayOfByte.recycle();
      paramArrayOfByte = new Matrix();
      paramArrayOfByte.setRotate(paramInt, paramCameraSize.getWidth() / 2.0F, paramCameraSize.getHeight() / 2.0F);
      if (paramBoolean) {
        paramArrayOfByte.postScale(-1.0F, 1.0F);
      }
      return Bitmap.createBitmap(paramCameraSize, 0, 0, paramCameraSize.getWidth(), paramCameraSize.getHeight(), paramArrayOfByte, false);
    }
    try
    {
      localOptions.inSampleSize = 2;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      paramCameraSize = new Matrix();
      paramCameraSize.setRotate(paramInt, paramArrayOfByte.getWidth() / 2.0F, paramArrayOfByte.getHeight() / 2.0F);
      if (paramBoolean) {
        paramCameraSize.postScale(-1.0F, 1.0F);
      }
      paramCameraSize = Bitmap.createBitmap(paramArrayOfByte, (int)(d5 / 2.0D), (int)(d6 / 2.0D), (int)(d3 / 2.0D), (int)(d1 / 2.0D), paramCameraSize, false);
      paramArrayOfByte.recycle();
      return paramCameraSize;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  protected String a(Void... paramVarArgs)
  {
    byte[] arrayOfByte = this.a.jdField_a_of_type_ArrayOfByte;
    paramVarArgs = new File(this.a.jdField_a_of_type_JavaLangString);
    if (arrayOfByte != null) {}
    for (;;)
    {
      try
      {
        int i = this.a.b;
        bool = true;
        if (i != 1) {
          break label185;
        }
        i = a(this.a.b, this.a.jdField_a_of_type_Int);
        a(a(arrayOfByte, this.a.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize, bool, i), this.a.c, paramVarArgs);
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onPictureTaken] createBitmap failed orientation:");
        localStringBuilder.append(this.a.jdField_a_of_type_Int);
        localStringBuilder.append(", ");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.a("TakePictureTask", 2, localStringBuilder.toString(), localOutOfMemoryError);
      }
      if (paramVarArgs.exists()) {
        return paramVarArgs.getAbsolutePath();
      }
      return null;
      label185:
      boolean bool = false;
    }
  }
  
  protected void a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$PictureCallback != null)
    {
      this.a.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy$PictureCallback.a(paramString);
      if ((paramString == null) && (QLog.a())) {
        QLog.c("TakePictureTask", 2, new Object[] { "Picture bitmap data error or output file not exist" });
      }
    }
  }
  
  /* Error */
  public boolean a(Bitmap paramBitmap, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 188	java/io/File
    //   3: dup
    //   4: aload_3
    //   5: invokevirtual 237	java/io/File:getParent	()Ljava/lang/String;
    //   8: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 222	java/io/File:exists	()Z
    //   18: ifeq +11 -> 29
    //   21: aload 4
    //   23: invokevirtual 240	java/io/File:isDirectory	()Z
    //   26: ifne +9 -> 35
    //   29: aload 4
    //   31: invokevirtual 243	java/io/File:mkdirs	()Z
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 222	java/io/File:exists	()Z
    //   39: ifeq +10 -> 49
    //   42: aload_3
    //   43: invokevirtual 246	java/io/File:isFile	()Z
    //   46: ifne +8 -> 54
    //   49: aload_3
    //   50: invokevirtual 249	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: aconst_null
    //   55: astore 5
    //   57: aconst_null
    //   58: astore 4
    //   60: new 251	java/io/BufferedOutputStream
    //   63: dup
    //   64: new 253	java/io/FileOutputStream
    //   67: dup
    //   68: aload_3
    //   69: invokespecial 256	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 259	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   75: astore_3
    //   76: aload_1
    //   77: getstatic 265	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   80: iload_2
    //   81: aload_3
    //   82: invokevirtual 269	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   85: pop
    //   86: aload_3
    //   87: invokevirtual 272	java/io/BufferedOutputStream:flush	()V
    //   90: aload_3
    //   91: invokevirtual 275	java/io/BufferedOutputStream:close	()V
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_1
    //   97: aload_3
    //   98: astore 4
    //   100: goto +21 -> 121
    //   103: astore_1
    //   104: aload_3
    //   105: astore 4
    //   107: goto +12 -> 119
    //   110: astore_1
    //   111: goto +10 -> 121
    //   114: astore_1
    //   115: aload 5
    //   117: astore 4
    //   119: aload_1
    //   120: athrow
    //   121: aload 4
    //   123: ifnull +8 -> 131
    //   126: aload 4
    //   128: invokevirtual 275	java/io/BufferedOutputStream:close	()V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	TakePictureTask
    //   0	133	1	paramBitmap	Bitmap
    //   0	133	2	paramInt	int
    //   0	133	3	paramFile	File
    //   11	116	4	localObject1	Object
    //   55	61	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   76	90	96	finally
    //   76	90	103	java/io/IOException
    //   60	76	110	finally
    //   119	121	110	finally
    //   60	76	114	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.cameraextend.TakePictureTask
 * JD-Core Version:    0.7.0.1
 */