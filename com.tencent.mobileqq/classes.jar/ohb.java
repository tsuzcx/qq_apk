import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ohb
  implements QQPermissionCallback
{
  ohb(ogs paramogs, Runnable paramRunnable) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[deny] ACCESS_FINE_LOCATION");
    ogs.a(this.jdField_a_of_type_Ogs, 3);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[grant] ACCESS_FINE_LOCATION");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohb
 * JD-Core Version:    0.7.0.1
 */