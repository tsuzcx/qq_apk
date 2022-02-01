package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoGridAdapter$3
  implements View.OnClickListener
{
  PhotoGridAdapter$3(PhotoGridAdapter paramPhotoGridAdapter, LocalMediaInfo paramLocalMediaInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.c.d(this.a))
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131886369), 0).show();
    }
    else if (!PhotoGridAdapter.a(this.a).booleanValue())
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2131914004), 0).show();
    }
    else
    {
      PhotoGridAdapter localPhotoGridAdapter = this.c;
      PhotoGridAdapter.a(localPhotoGridAdapter, localPhotoGridAdapter.a, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter.3
 * JD-Core Version:    0.7.0.1
 */