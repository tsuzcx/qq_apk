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
    DialogUtil.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.c.e = TroopHWJsPlugin.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */