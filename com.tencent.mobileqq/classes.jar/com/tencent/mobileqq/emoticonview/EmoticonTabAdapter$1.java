package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.qphone.base.util.QLog;

class EmoticonTabAdapter$1
  implements Runnable
{
  EmoticonTabAdapter$1(EmoticonTabAdapter paramEmoticonTabAdapter, EmoticonTabAdapter.EmoticonTabItem paramEmoticonTabItem) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.w("EmoticonTabAdapter", 2, "package lossY");
    }
    EmoticonManagerServiceProxy localEmoticonManagerServiceProxy = (EmoticonManagerServiceProxy)this.this$0.app.getRuntimeService(IEmoticonManagerService.class);
    EmoticonPackage localEmoticonPackage = localEmoticonManagerServiceProxy.syncFindEmoticonPackageById(this.val$item.epId);
    if (localEmoticonPackage != null)
    {
      localEmoticonPackage.status = 0;
      localEmoticonManagerServiceProxy.saveEmoticonPackage(localEmoticonPackage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonTabAdapter.1
 * JD-Core Version:    0.7.0.1
 */