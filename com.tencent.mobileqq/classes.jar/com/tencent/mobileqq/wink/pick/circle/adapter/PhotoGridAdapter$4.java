package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoGridAdapter$4
  implements View.OnClickListener
{
  PhotoGridAdapter$4(PhotoGridAdapter paramPhotoGridAdapter, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.d.d(this.a))
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131886369), 0).show();
      this.b.d.setChecked(false);
    }
    else if (!PhotoGridAdapter.a(this.a).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914004), 0).show();
      this.b.d.setChecked(false);
    }
    else
    {
      PhotoGridAdapter.a(this.d, this.c, this.b);
      SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter.4
 * JD-Core Version:    0.7.0.1
 */