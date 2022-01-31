import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask;
import com.tencent.qphone.base.util.QLog;

public class rjy
  implements osi
{
  public rjy(VideoPreloadMgr.PreloadTask paramPreloadTask, rjn paramrjn) {}
  
  public void a(osl paramosl)
  {
    if ((TextUtils.isEmpty(paramosl.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Rjn == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoPreloadMgr.a(), 2, "Q.readinjoy.video.TAGUUIDToUrlCallback Callback vid:" + paramosl.b + " url:" + paramosl.jdField_a_of_type_JavaLangString);
    }
    if (paramosl.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Rjn.a(paramosl.b, paramosl.jdField_a_of_type_JavaLangString, 1, 0L, 0L, 0, paramosl.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Rjn.a(paramosl.b, paramosl.jdField_a_of_type_JavaLangString, 2, 0L, 0L, 0, paramosl.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rjy
 * JD-Core Version:    0.7.0.1
 */