package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;

public class VasQuickUpdateManagerProxy
  extends AbsEmoRuntimeServiceProxy<IVasQuickUpdateService>
{
  private static final String TAG = "VasQuickUpdateManagerProxy";
  
  public VasQuickUpdateManagerProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IVasQuickUpdateService.class);
  }
  
  public void removeCallBacker(CallBacker paramCallBacker)
  {
    if (this.manager != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManagerProxy", 4, "do removeCallBacker.");
      }
      ((IVasQuickUpdateService)this.manager).removeCallBacker(paramCallBacker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.VasQuickUpdateManagerProxy
 * JD-Core Version:    0.7.0.1
 */