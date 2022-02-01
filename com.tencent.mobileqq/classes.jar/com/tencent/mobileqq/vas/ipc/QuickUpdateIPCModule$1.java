package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import eipc.EIPCResult;

class QuickUpdateIPCModule$1
  implements QueryItemCallback
{
  QuickUpdateIPCModule$1(QuickUpdateIPCModule paramQuickUpdateIPCModule, int paramInt) {}
  
  public void onQueryItemVer(int paramInt, String paramString1, String paramString2)
  {
    QuickUpdateIPCModule.Params localParams = new QuickUpdateIPCModule.Params(null);
    localParams.intVal = paramInt;
    localParams.strVal1 = paramString1;
    localParams.strVal2 = paramString2;
    paramString1 = new Bundle();
    paramString1.putSerializable("params", localParams);
    paramString1 = EIPCResult.createResult(0, paramString1);
    this.this$0.callbackResult(this.val$callbackId, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule.1
 * JD-Core Version:    0.7.0.1
 */