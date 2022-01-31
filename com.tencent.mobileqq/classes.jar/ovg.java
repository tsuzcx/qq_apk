import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.qphone.base.util.QLog;

public class ovg
  extends ovu
{
  public ovg(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.Callback paramCallback, String paramString)
  {
    super(paramVideoCombineHelper);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "splitVideoUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a));
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaLangString, false, "splitVideo done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovg
 * JD-Core Version:    0.7.0.1
 */