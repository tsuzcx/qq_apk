package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoGridAdapter$5
  implements View.OnClickListener
{
  PhotoGridAdapter$5(PhotoGridAdapter paramPhotoGridAdapter, int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH) {}
  
  public void onClick(View paramView)
  {
    if (!PhotoGridAdapter.a(this.c.b(this.a)).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914004), 0).show();
      this.b.d.setChecked(false);
    }
    else if (!PhotoGridAdapter.b(this.c.b(this.a)).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914005), 0).show();
      this.b.d.setChecked(false);
    }
    else if (!PhotoGridAdapter.c(this.c.b(this.a)).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914006), 0).show();
      this.b.d.setChecked(false);
    }
    else
    {
      PhotoGridAdapter.b(this.c, this.a, this.b);
      SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter.5
 * JD-Core Version:    0.7.0.1
 */