package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager.IVersionGrayscaleCallback;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager;
import com.tencent.mobileqq.intervideo.lite_now_biz.report.DataReport;

class NowLiteStrategy$1
  implements VersionManager.IVersionGrayscaleCallback
{
  NowLiteStrategy$1(NowLiteStrategy paramNowLiteStrategy, IDoneCallback paramIDoneCallback, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean)
  {
    NowBizConfigManager.a("multi_voice", paramBoolean);
    IDoneCallback localIDoneCallback = this.a;
    if (localIDoneCallback != null) {
      localIDoneCallback.a();
    }
    DataReport.a(this.b, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.NowLiteStrategy.1
 * JD-Core Version:    0.7.0.1
 */