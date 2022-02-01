package com.tencent.mobileqq.winkpublish.part;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;

class PublishLbsPart$6
  implements Observer<LbsDataV2.PoiInfo>
{
  PublishLbsPart$6(PublishLbsPart paramPublishLbsPart) {}
  
  public void a(@Nullable LbsDataV2.PoiInfo paramPoiInfo)
  {
    String str2 = PublishLbsPart.a;
    String str1;
    if (paramPoiInfo == null) {
      str1 = "null";
    } else {
      str1 = paramPoiInfo.poiId;
    }
    QLog.d(str2, 1, new Object[] { "[onChanged] mDefSelectPoiDataLiveData poiInfo: ", str1 });
    if ((paramPoiInfo != null) && (paramPoiInfo.poiId != null) && (!paramPoiInfo.poiId.equals("invalide_poi_id")) && (PublishLbsPart.h(this.a)) && (PublishLbsPart.a(this.a, paramPoiInfo))) {
      PublishLbsPart.i(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.6
 * JD-Core Version:    0.7.0.1
 */