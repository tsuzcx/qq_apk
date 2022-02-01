package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.winkpublish.adapter.PublishPoiAdapter;
import com.tencent.mobileqq.winkpublish.adapter.PublishPoiAdapter.PoiItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishLbsPart$1
  implements AdapterView.OnItemClickListener
{
  PublishLbsPart$1(PublishLbsPart paramPublishLbsPart) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    PublishPoiAdapter.PoiItemInfo localPoiItemInfo = PublishLbsPart.a(this.a).a(paramInt);
    if (!localPoiItemInfo.c)
    {
      PublishLbsPart.a(this.a, localPoiItemInfo.a, false);
      PublishLbsPart.b(this.a).h = localPoiItemInfo.a;
      PublishLbsPart.b(this.a).m = true;
      PublishLbsPart.c(this.a).setVisibility(8);
    }
    else
    {
      PublishLbsPart.d(this.a);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.1
 * JD-Core Version:    0.7.0.1
 */