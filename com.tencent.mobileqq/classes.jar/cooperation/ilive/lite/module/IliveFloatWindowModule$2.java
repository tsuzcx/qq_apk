package cooperation.ilive.lite.module;

import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class IliveFloatWindowModule$2
  implements IModule.FocusChangeListener
{
  IliveFloatWindowModule$2(IliveFloatWindowModule paramIliveFloatWindowModule) {}
  
  public void onFocusGain() {}
  
  public void onFocusLoss()
  {
    QLog.e("IliveFloatWindowModule", 1, "mFocusChangeListener onFocusLoss");
    ThreadManager.getUIHandler().post(new IliveFloatWindowModule.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveFloatWindowModule.2
 * JD-Core Version:    0.7.0.1
 */