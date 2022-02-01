import android.view.View;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ndz
  implements QQPermissionCallback
{
  ndz(ndy paramndy, String paramString, long paramLong, int paramInt, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.jdField_a_of_type_Ndy.jdField_a_of_type_JavaLangString, 1, "onClick_Camera, deny, i[" + paramInt + "], mRequestPermissionIng[" + this.jdField_a_of_type_Ndy.jdField_a_of_type_Boolean + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.jdField_a_of_type_Ndy.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ndy.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.jdField_a_of_type_Ndy.jdField_a_of_type_JavaLangString, 1, "onClick_Camera, grant, i[" + paramInt + "], mRequestPermissionIng[" + this.jdField_a_of_type_Ndy.jdField_a_of_type_Boolean + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.jdField_a_of_type_Ndy.jdField_a_of_type_Boolean = false;
    if ("android.permission.CAMERA".equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Ndy.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView);
    }
    while (!"android.permission.RECORD_AUDIO".equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_Ndy.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndz
 * JD-Core Version:    0.7.0.1
 */