package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import bksf;
import bksj;
import bksl;
import bksp;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class VideoFramesFetcher
  implements bksl
{
  private static long jdField_a_of_type_Long;
  private volatile int jdField_a_of_type_Int;
  private bksf jdField_a_of_type_Bksf;
  private BlockingQueue<bksp> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private ConcurrentHashMap<Integer, bksp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private bksj b(int paramInt)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "FetchFrameAtTime fail, status=" + this.jdField_a_of_type_Int);
      }
    }
    bksp localbksp2;
    do
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
        {
          bksp localbksp1 = (bksp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
          l = jdField_a_of_type_Long;
          jdField_a_of_type_Long = 1L + l;
          localbksp1.jdField_a_of_type_Long = l;
          return null;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      long l = jdField_a_of_type_Long;
      jdField_a_of_type_Long = 1L + l;
      localbksp2 = new bksp(this, l, paramInt, paramInt + this.b);
    } while (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null);
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localbksp2);
    return null;
  }
  
  public bksj a(int paramInt)
  {
    if ((!a()) || (paramInt < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex1 fail, status=" + this.jdField_a_of_type_Int);
      }
      return null;
    }
    if (this.jdField_a_of_type_Bksf.a(paramInt)) {
      return this.jdField_a_of_type_Bksf.a(paramInt);
    }
    return b(this.b * paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((!a()) || (paramInt1 < 0) || (paramInt2 < 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex2 fail, status=" + this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      return;
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        a(paramInt2);
        paramInt2 -= 1;
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher
 * JD-Core Version:    0.7.0.1
 */