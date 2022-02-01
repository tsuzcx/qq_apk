package cooperation.ilive.lite.floatwindow;

import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowPermissionListener;
import com.tencent.qphone.base.util.QLog;

class IliveFloatWindowHelper$1$1
  implements OnFloatWindowPermissionListener
{
  IliveFloatWindowHelper$1$1(IliveFloatWindowHelper.1 param1) {}
  
  public void permissionFinish(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("permissionFinish isAuth = ");
    localStringBuilder.append(paramBoolean);
    QLog.e("IliveFloatWindowHelper", 1, localStringBuilder.toString());
    if (this.a.a != null) {
      this.a.a.onFinish(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.1.1
 * JD-Core Version:    0.7.0.1
 */