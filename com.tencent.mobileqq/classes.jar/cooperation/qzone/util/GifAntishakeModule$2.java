package cooperation.qzone.util;

import android.graphics.Bitmap;
import bhnr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class GifAntishakeModule$2
  implements Runnable
{
  public GifAntishakeModule$2(bhnr parambhnr, ArrayList paramArrayList, int paramInt1, CountDownLatch paramCountDownLatch, Bitmap paramBitmap, int paramInt2, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    if (localBitmap == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      long l = System.currentTimeMillis();
      int i = bhnr.a(bhnr.a(this.jdField_a_of_type_AndroidGraphicsBitmap), bhnr.a(localBitmap));
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "DHash: 第一帧与第" + (this.jdField_a_of_type_Int + 1) + "帧的相似度为 dif=" + i + " now:" + (System.currentTimeMillis() - l));
      }
      if ((localBitmap.getWidth() == this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) && (localBitmap.getHeight() == this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) && (bhnr.a(this.this$0, this.b, i))) {
        this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = true;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule.2
 * JD-Core Version:    0.7.0.1
 */