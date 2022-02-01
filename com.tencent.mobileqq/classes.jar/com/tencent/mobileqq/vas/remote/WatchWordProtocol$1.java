package com.tencent.mobileqq.vas.remote;

import QC.GetItemWatchWordRsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import eipc.EIPCModule;
import eipc.EIPCResult;

class WatchWordProtocol$1
  implements BusinessObserver
{
  WatchWordProtocol$1(WatchWordProtocol paramWatchWordProtocol, EIPCModule paramEIPCModule, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetItemWatchWordRsp)))
    {
      paramObject = (GetItemWatchWordRsp)paramObject;
      EIPCResult localEIPCResult = new EIPCResult();
      localEIPCResult.data = new Bundle();
      localEIPCResult.data.putInt("ret", paramObject.ret);
      localEIPCResult.data.putString("sharemsg", paramObject.sharemsg);
      localEIPCResult.data.putString("errmsg", paramObject.errmsg);
      this.jdField_a_of_type_EipcEIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.remote.WatchWordProtocol.1
 * JD-Core Version:    0.7.0.1
 */