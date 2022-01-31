import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.qphone.base.util.QLog;

class oxk
  extends ExecuteBinResponseCallback
{
  oxk(oxe paramoxe, oxo paramoxo) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      QLog.w(".troop.trace_video_combine", 2, "concatMediaByTs change ts onSuccess: " + paramString);
      QLog.d(".troop.trace_video_combine", 2, "convertToTsTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Oxe.a.a));
    }
    this.jdField_a_of_type_Oxe.a.a = System.currentTimeMillis();
  }
  
  public void b(String paramString)
  {
    QLog.w(".troop.VideoCombineHelper", 1, "concatMediaByTs change ts onSuccess: " + paramString);
    this.jdField_a_of_type_Oxo.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxk
 * JD-Core Version:    0.7.0.1
 */