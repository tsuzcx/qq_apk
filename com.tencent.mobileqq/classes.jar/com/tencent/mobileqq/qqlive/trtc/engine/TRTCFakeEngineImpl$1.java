package com.tencent.mobileqq.qqlive.trtc.engine;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class TRTCFakeEngineImpl$1
  implements OnLoadListener
{
  TRTCFakeEngineImpl$1(TRTCFakeEngineImpl paramTRTCFakeEngineImpl, TRTCInitCallback paramTRTCInitCallback, Context paramContext, ConfigData paramConfigData) {}
  
  private void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = Utils.o(paramLoadExtResult.getRelatedFilesFolder("trtc_entry"));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloaded trtc so: ");
    localStringBuilder.append(paramLoadExtResult);
    QLog.i("TRTCFakeEngineImpl", 1, localStringBuilder.toString());
    TRTCServerIPCModule.a().a(this.b, this.c, new TRTCFakeEngineImpl.1.1(this, paramInt));
  }
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      a(paramInt, paramLoadExtResult);
      return;
    }
    paramLoadExtResult = this.a;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.a(TRTCFakeEngineImpl.a(this.d), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.TRTCFakeEngineImpl.1
 * JD-Core Version:    0.7.0.1
 */