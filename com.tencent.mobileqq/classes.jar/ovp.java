import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ovp
  extends ovu
{
  ovp(ovk paramovk, long paramLong, VideoCombineHelper.Callback paramCallback, File paramFile)
  {
    super(paramovk.a);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovp
 * JD-Core Version:    0.7.0.1
 */