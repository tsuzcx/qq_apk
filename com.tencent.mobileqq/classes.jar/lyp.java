import android.view.View;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class lyp
  implements QQPermissionCallback
{
  public lyp(VideoControlUI paramVideoControlUI, String paramString, long paramLong, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c, 1, "onClick_Camera, deny, i[" + paramInt + "], mRequestPermissionIng[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p = false;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c, 1, "onClick_Camera, grant, i[" + paramInt + "], mRequestPermissionIng[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p = false;
    if ("android.permission.CAMERA".equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
    }
    while (!"android.permission.RECORD_AUDIO".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyp
 * JD-Core Version:    0.7.0.1
 */