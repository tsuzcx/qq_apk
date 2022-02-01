package com.tencent.mobileqq.winkpublish.part;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.winkpublish.adapter.PublishPoiAdapter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.List;

class PublishLbsPart$4
  implements Observer<List<LbsDataV2.PoiInfo>>
{
  PublishLbsPart$4(PublishLbsPart paramPublishLbsPart) {}
  
  public void a(@Nullable List<LbsDataV2.PoiInfo> paramList)
  {
    QLog.d(PublishLbsPart.a, 1, "onChanged... mPoiLiveData:");
    PublishLbsPart.c(this.a).setVisibility(0);
    PublishLbsPart.a(this.a).a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.4
 * JD-Core Version:    0.7.0.1
 */