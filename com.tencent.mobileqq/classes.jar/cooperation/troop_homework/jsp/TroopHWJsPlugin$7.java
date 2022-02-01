package cooperation.troop_homework.jsp;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class TroopHWJsPlugin$7
  implements QQPermissionCallback
{
  TroopHWJsPlugin$7(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt, Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.b);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.c.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */