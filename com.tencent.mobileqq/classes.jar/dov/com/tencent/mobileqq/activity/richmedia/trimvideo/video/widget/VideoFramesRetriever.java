package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import bpks;
import bpkw;
import bpky;
import bpld;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(10)
public class VideoFramesRetriever
  implements bpky
{
  private static long jdField_a_of_type_Long;
  private float jdField_a_of_type_Float;
  private volatile int jdField_a_of_type_Int;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever;
  private bpks jdField_a_of_type_Bpks;
  private BlockingQueue<bpld> jdField_a_of_type_JavaUtilConcurrentBlockingQueue;
  private ConcurrentHashMap<Integer, bpld> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private bpkw b(int paramInt)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesRetriever", 2, "FetchFrameAtTime fail, status=" + this.jdField_a_of_type_Int);
      }
    }
    bpld localbpld2;
    do
    {
      return null;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
        {
          bpld localbpld1 = (bpld)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
          l = jdField_a_of_type_Long;
          jdField_a_of_type_Long = 1L + l;
          localbpld1.jdField_a_of_type_Long = l;
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
      localbpld2 = new bpld(this, l, paramInt, paramInt + this.b);
    } while (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null);
    this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localbpld2);
    return null;
  }
  
  public bpkw a(int paramInt)
  {
    if ((!a()) || (paramInt < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesRetriever", 2, "fetchFrameByIndex1 fail, status=" + this.jdField_a_of_type_Int);
      }
      return null;
    }
    if (this.jdField_a_of_type_Bpks.a(paramInt)) {
      return this.jdField_a_of_type_Bpks.a(paramInt);
    }
    return b(this.b * paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((!a()) || (paramInt1 < 0) || (paramInt2 < 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesRetriever", 2, "fetchFrameByIndex2 fail, status=" + this.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever
 * JD-Core Version:    0.7.0.1
 */