import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

final class nhy
  implements QQPermissionCallback
{
  nhy(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(nhv.a, 1, "checkQAVPermission, deny, i[" + paramInt + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.a.onClick(null, 0);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(nhv.a, 1, "checkQAVPermission, grant, i[" + paramInt + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.a.onClick(null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhy
 * JD-Core Version:    0.7.0.1
 */