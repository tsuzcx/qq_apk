import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class oqh
  implements QQPermissionCallback
{
  oqh(oqg paramoqg, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[deny] ACCESS_FINE_LOCATION");
    bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[grant] ACCESS_FINE_LOCATION");
    oqb.a(this.jdField_a_of_type_Oqg.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqh
 * JD-Core Version:    0.7.0.1
 */