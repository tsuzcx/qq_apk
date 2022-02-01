package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class QuickUpdateIPCModule$2
  implements EIPCResultCallback
{
  QuickUpdateIPCModule$2(QueryItemCallback paramQueryItemCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code != 0)
    {
      this.val$callback.onQueryItemVer(2, "", "");
      return;
    }
    paramEIPCResult = (QuickUpdateIPCModule.Params)paramEIPCResult.data.getSerializable("params");
    this.val$callback.onQueryItemVer(paramEIPCResult.intVal, paramEIPCResult.strVal1, paramEIPCResult.strVal2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule.2
 * JD-Core Version:    0.7.0.1
 */