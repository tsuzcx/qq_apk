package cooperation.qzone.util;

import android.app.Activity;
import bfur;
import mqq.app.QQPermissionCallback;

final class QZonePermission$1
  implements QQPermissionCallback
{
  QZonePermission$1(Activity paramActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(QZonePermission.access$000(this.val$activity));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QZonePermission.1
 * JD-Core Version:    0.7.0.1
 */