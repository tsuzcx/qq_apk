import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr.PreloadTask;
import com.tencent.qphone.base.util.QLog;

public class quj
  implements onx
{
  public quj(VideoPreloadMgr.PreloadTask paramPreloadTask, qty paramqty) {}
  
  public void a(ooa paramooa)
  {
    if ((TextUtils.isEmpty(paramooa.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Qty == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoPreloadMgr.a(), 2, "Q.readinjoy.video.TAGUUIDToUrlCallback Callback vid:" + paramooa.b + " url:" + paramooa.jdField_a_of_type_JavaLangString);
    }
    if (paramooa.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Qty.a(paramooa.b, paramooa.jdField_a_of_type_JavaLangString, 1, 0L, 0L, 0, paramooa.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Qty.a(paramooa.b, paramooa.jdField_a_of_type_JavaLangString, 2, 0L, 0L, 0, paramooa.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     quj
 * JD-Core Version:    0.7.0.1
 */