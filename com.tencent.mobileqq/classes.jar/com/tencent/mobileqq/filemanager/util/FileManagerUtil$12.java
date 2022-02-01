package com.tencent.mobileqq.filemanager.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import auea;
import auem;
import com.tencent.qphone.base.util.QLog;

public final class FileManagerUtil$12
  implements Runnable
{
  public FileManagerUtil$12(String paramString, int paramInt1, boolean paramBoolean, auem paramauem, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    MediaMetadataRetriever localMediaMetadataRetriever;
    if (Build.VERSION.SDK_INT >= 10) {
      localMediaMetadataRetriever = new MediaMetadataRetriever();
    }
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(this.jdField_a_of_type_JavaLangString);
        long l = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Int <= 0) {
          l = 5000000L;
        }
        localBitmap1 = localMediaMetadataRetriever.getFrameAtTime(l, 2);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Bitmap localBitmap1;
        localIllegalArgumentException = localIllegalArgumentException;
        try
        {
          localException5.release();
          localObject1 = null;
        }
        catch (Exception localException1)
        {
          localObject2 = null;
        }
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException = localRuntimeException;
        try
        {
          localException5.release();
          localObject3 = null;
        }
        catch (Exception localException2)
        {
          localObject4 = null;
        }
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError = localOutOfMemoryError;
        try
        {
          localException5.release();
          localObject5 = null;
        }
        catch (Exception localException3)
        {
          localObject6 = null;
        }
        continue;
      }
      finally {}
      try
      {
        localMediaMetadataRetriever.release();
        if (localBitmap1 == null) {
          return;
        }
      }
      catch (Exception localException5)
      {
        continue;
      }
      try
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        localException5.release();
        label138:
        throw localBitmap2;
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Auem != null))
        {
          this.jdField_a_of_type_Auem.a(localBitmap2);
          return;
        }
        float f;
        label193:
        Matrix localMatrix;
        if (localBitmap2.getWidth() < localBitmap2.getHeight())
        {
          f = this.b / localBitmap2.getWidth();
          localMatrix = new Matrix();
          localMatrix.setScale(f, f);
        }
        for (;;)
        {
          try
          {
            localBitmap3 = auea.a(localMatrix, localBitmap2, this.b, this.c);
            if (this.jdField_a_of_type_Auem == null) {
              break;
            }
            this.jdField_a_of_type_Auem.a(localBitmap3);
            return;
          }
          catch (Exception localException4)
          {
            Bitmap localBitmap3;
            QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception:" + localException4.toString());
          }
          f = this.c / localBitmap3.getHeight();
          break label193;
          Object localObject7 = null;
        }
      }
      catch (Exception localException6)
      {
        break label138;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.12
 * JD-Core Version:    0.7.0.1
 */