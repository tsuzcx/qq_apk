import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.qphone.base.util.QLog;

public class ovh
  extends ovu
{
  public ovh(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.Callback paramCallback, String paramString)
  {
    super(paramVideoCombineHelper);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "mixAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "mixAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a));
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaLangString, false, "mixAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovh
 * JD-Core Version:    0.7.0.1
 */