import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask;
import com.tencent.qphone.base.util.QLog;

public class qum
  implements ooa
{
  public qum(VideoPreloadMgr.PreloadTask paramPreloadTask, qub paramqub) {}
  
  public void a(ood paramood)
  {
    if ((TextUtils.isEmpty(paramood.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Qub == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoPreloadMgr.a(), 2, "Q.readinjoy.video.TAGUUIDToUrlCallback Callback vid:" + paramood.b + " url:" + paramood.jdField_a_of_type_JavaLangString);
    }
    if (paramood.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Qub.a(paramood.b, paramood.jdField_a_of_type_JavaLangString, 1, 0L, 0L, 0, paramood.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Qub.a(paramood.b, paramood.jdField_a_of_type_JavaLangString, 2, 0L, 0L, 0, paramood.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qum
 * JD-Core Version:    0.7.0.1
 */