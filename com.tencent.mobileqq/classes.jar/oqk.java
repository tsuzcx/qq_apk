import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class oqk
  implements QQPermissionCallback
{
  oqk(oqb paramoqb, Runnable paramRunnable) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[deny] ACCESS_FINE_LOCATION");
    oqb.a(this.jdField_a_of_type_Oqb, 3);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("DailyHeaderViewController", 1, "[grant] ACCESS_FINE_LOCATION");
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqk
 * JD-Core Version:    0.7.0.1
 */