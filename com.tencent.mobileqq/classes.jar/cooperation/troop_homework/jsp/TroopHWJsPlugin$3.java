package cooperation.troop_homework.jsp;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class TroopHWJsPlugin$3
  implements QQPermissionCallback
{
  TroopHWJsPlugin$3(TroopHWJsPlugin paramTroopHWJsPlugin, Activity paramActivity, int paramInt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.c = TroopHWJsPlugin.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */