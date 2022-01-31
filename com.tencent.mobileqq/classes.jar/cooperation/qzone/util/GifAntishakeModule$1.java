package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import bacm;
import bgfc;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.pfc.opencv.QzoneVision;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class GifAntishakeModule$1
  implements Runnable
{
  public GifAntishakeModule$1(bgfc parambgfc, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, Bitmap paramBitmap, int paramInt4, int paramInt5, String[] paramArrayOfString, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "frame: " + this.jdField_a_of_type_Int + ", startAntishake at " + System.currentTimeMillis());
      }
      Bitmap localBitmap1 = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.RGB_565);
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (localBitmap2 != null) && (localBitmap1 != null))
      {
        QzoneVision.getAntiShakeBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localBitmap2, localBitmap1);
        localBitmap2 = Bitmap.createBitmap(localBitmap1, this.d, this.e, localBitmap1.getWidth() - this.d * 2, localBitmap1.getHeight() - this.e * 2);
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "frame: " + this.jdField_a_of_type_Int + ", endAntishake and startSave at " + System.currentTimeMillis());
        }
        String str = PhotoUtils.a(bgfc.a(this.this$0), ".IMG" + this.jdField_a_of_type_Int, ".jpg");
        bacm.a(localBitmap2, new File(str));
        if (!localBitmap1.isRecycled()) {
          localBitmap1.recycle();
        }
        if (!localBitmap2.isRecycled()) {
          localBitmap2.recycle();
        }
        this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int] = str;
        bgfc.b();
        bgfc.a(this.this$0, bgfc.c());
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "frame: " + this.jdField_a_of_type_Int + ", endSave at " + System.currentTimeMillis());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule.1
 * JD-Core Version:    0.7.0.1
 */