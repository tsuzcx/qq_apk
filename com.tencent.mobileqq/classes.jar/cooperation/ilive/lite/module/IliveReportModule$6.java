package cooperation.ilive.lite.module;

import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.IPermissionCallback;

class IliveReportModule$6
  implements IliveFloatWindowHelper.IPermissionCallback
{
  IliveReportModule$6(IliveReportModule paramIliveReportModule) {}
  
  public void onFinish(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("float window PermissionCallback isAuth = ");
    localStringBuilder.append(paramBoolean);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    IliveReportModule.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.6
 * JD-Core Version:    0.7.0.1
 */