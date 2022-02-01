package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoGridAdapter$6
  implements View.OnClickListener
{
  PhotoGridAdapter$6(PhotoGridAdapter paramPhotoGridAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!PhotoGridAdapter.a(this.b.b(this.a)).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914004), 0).show();
    }
    else if (!PhotoGridAdapter.b(this.b.b(this.a)).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914005), 0).show();
    }
    else if (!PhotoGridAdapter.c(this.b.b(this.a)).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914006), 0).show();
    }
    else
    {
      PhotoGridAdapter localPhotoGridAdapter = this.b;
      PhotoGridAdapter.a(localPhotoGridAdapter, localPhotoGridAdapter.a, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter.6
 * JD-Core Version:    0.7.0.1
 */