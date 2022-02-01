package com.tencent.mobileqq.winkpublish.part;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;

class PublishLbsPart$5
  implements Observer<LbsDataV2.PoiInfo>
{
  PublishLbsPart$5(PublishLbsPart paramPublishLbsPart) {}
  
  public void a(@Nullable LbsDataV2.PoiInfo paramPoiInfo)
  {
    QLog.d(PublishLbsPart.a, 1, new Object[] { "onChanged... poiInfo:", paramPoiInfo.toString() });
    PublishLbsPart.a(this.a, paramPoiInfo, false);
    PublishLbsPart.c(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.5
 * JD-Core Version:    0.7.0.1
 */