import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qphone.base.util.QLog;

public class jyi
  extends VideoObserver
{
  public jyi(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  protected void a(long paramLong)
  {
    super.a(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin:" + paramLong + ", mRelationId = " + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong != 0L) && (paramLong == this.a.jdField_a_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin matched");
      }
      MultiVideoEnterPageActivity.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyi
 * JD-Core Version:    0.7.0.1
 */