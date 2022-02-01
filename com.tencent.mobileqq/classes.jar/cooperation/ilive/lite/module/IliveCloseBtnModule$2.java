package cooperation.ilive.lite.module;

import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.IPermissionCallback;

class IliveCloseBtnModule$2
  implements IliveFloatWindowHelper.IPermissionCallback
{
  IliveCloseBtnModule$2(IliveCloseBtnModule paramIliveCloseBtnModule) {}
  
  public void onFinish(boolean paramBoolean)
  {
    String str = IliveCloseBtnModule.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("float window PermissionCallback isAuth = ");
    localStringBuilder.append(paramBoolean);
    QLog.e(str, 1, localStringBuilder.toString());
    this.a.getEvent().post(new RoomCloseEvent((short)1003));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveCloseBtnModule.2
 * JD-Core Version:    0.7.0.1
 */