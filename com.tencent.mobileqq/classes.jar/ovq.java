import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.qphone.base.util.QLog;

class ovq
  extends ExecuteBinResponseCallback
{
  ovq(ovk paramovk, ovu paramovu) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      QLog.w(".troop.trace_video_combine", 2, "concatMediaByTs change ts onSuccess: " + paramString);
      QLog.d(".troop.trace_video_combine", 2, "convertToTsTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Ovk.a.a));
    }
    this.jdField_a_of_type_Ovk.a.a = System.currentTimeMillis();
  }
  
  public void b(String paramString)
  {
    QLog.w(".troop.VideoCombineHelper", 1, "concatMediaByTs change ts onSuccess: " + paramString);
    this.jdField_a_of_type_Ovu.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovq
 * JD-Core Version:    0.7.0.1
 */