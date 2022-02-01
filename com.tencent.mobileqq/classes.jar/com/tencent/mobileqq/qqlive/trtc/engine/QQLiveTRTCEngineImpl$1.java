package com.tencent.mobileqq.qqlive.trtc.engine;

import android.content.Context;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;

class QQLiveTRTCEngineImpl$1
  implements OnLoadListener
{
  QQLiveTRTCEngineImpl$1(QQLiveTRTCEngineImpl paramQQLiveTRTCEngineImpl, Context paramContext, ConfigData paramConfigData, TRTCInitCallback paramTRTCInitCallback) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadResult ");
    localStringBuilder.append(paramInt);
    QLog.d("QQLiveTRTCEngine", 1, localStringBuilder.toString());
    if (paramInt == 0)
    {
      TXLiveBase.setLibraryPath(Utils.o(paramLoadExtResult.getRelatedFilesFolder("trtc_entry")));
      QQLiveTRTCEngineImpl.a(this.d, this.a, this.b);
    }
    else
    {
      this.d.a(3);
      QLog.i("QQLiveTRTCEngine", 1, "SoLoadManager.onLoadResult TRTC failed! ");
    }
    paramLoadExtResult = this.c;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.a(this.d.b(), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.engine.QQLiveTRTCEngineImpl.1
 * JD-Core Version:    0.7.0.1
 */