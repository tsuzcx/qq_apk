package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import bndp;
import bndt;
import bndv;
import bndz;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class VideoFramesFetcher
  implements bndv
{
  private static long jdField_a_of_type_Long;
  private volatile int jdField_a_of_type_Int;
  private bndp jdField_a_of_type_Bndp;
  private BlockingQueue<bndz> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private ConcurrentHashMap<Integer, bndz> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private bndt b(int paramInt)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "FetchFrameAtTime fail, status=" + this.jdField_a_of_type_Int);
      }
    }
    bndz localbndz2;
    do
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
        {
          bndz localbndz1 = (bndz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
          l = jdField_a_of_type_Long;
          jdField_a_of_type_Long = 1L + l;
          localbndz1.jdField_a_of_type_Long = l;
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
      localbndz2 = new bndz(this, l, paramInt, paramInt + this.b);
    } while (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null);
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localbndz2);
    return null;
  }
  
  public bndt a(int paramInt)
  {
    if ((!a()) || (paramInt < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex1 fail, status=" + this.jdField_a_of_type_Int);
      }
      return null;
    }
    if (this.jdField_a_of_type_Bndp.a(paramInt)) {
      return this.jdField_a_of_type_Bndp.a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher
 * JD-Core Version:    0.7.0.1
 */