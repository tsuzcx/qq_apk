package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager.IVersionGrayscaleCallback;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager;
import com.tencent.mobileqq.intervideo.lite_now_biz.report.DataReport;

class NowLiteStrategy$2
  implements VersionManager.IVersionGrayscaleCallback
{
  NowLiteStrategy$2(NowLiteStrategy paramNowLiteStrategy, IDoneCallback paramIDoneCallback, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean)
  {
    NowBizConfigManager.a(paramBoolean);
    IDoneCallback localIDoneCallback = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIDoneCallback;
    if (localIDoneCallback != null) {
      localIDoneCallback.a();
    }
    DataReport.a(this.jdField_a_of_type_AndroidOsBundle, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.NowLiteStrategy.2
 * JD-Core Version:    0.7.0.1
 */