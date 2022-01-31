import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask;
import com.tencent.qphone.base.util.QLog;

public class qih
  implements ocp
{
  public qih(VideoPreloadMgr.PreloadTask paramPreloadTask, qhw paramqhw) {}
  
  public void a(ocs paramocs)
  {
    if ((TextUtils.isEmpty(paramocs.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Qhw == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoPreloadMgr.a(), 2, "Q.readinjoy.video.TAGUUIDToUrlCallback Callback vid:" + paramocs.b + " url:" + paramocs.jdField_a_of_type_JavaLangString);
    }
    if (paramocs.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Qhw.a(paramocs.b, paramocs.jdField_a_of_type_JavaLangString, 1, 0L, 0L, 0, paramocs.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Qhw.a(paramocs.b, paramocs.jdField_a_of_type_JavaLangString, 2, 0L, 0L, 0, paramocs.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qih
 * JD-Core Version:    0.7.0.1
 */