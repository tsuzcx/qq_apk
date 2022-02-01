package com.tencent.mobileqq.vas.ipc.remote;

import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import eipc.EIPCModule;
import eipc.EIPCResultCallback;

public class EmoticonManagerIPC
  implements IEmoticonManager
{
  public void startTroopNickDownload(int paramInt1, EIPCModule paramEIPCModule, int paramInt2, EIPCResultCallback paramEIPCResultCallback)
  {
    ((TroopNickNameBusiness)QQVasUpdateBusinessUtil.a(TroopNickNameBusiness.class)).addUpdateListener(new EmoticonManagerIPC.1(this, paramEIPCModule, paramInt2));
    ((TroopNickNameBusiness)QQVasUpdateBusinessUtil.a(TroopNickNameBusiness.class)).a(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.EmoticonManagerIPC
 * JD-Core Version:    0.7.0.1
 */