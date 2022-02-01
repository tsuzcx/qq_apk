package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleJumpCameraPageEvent;

class PhotoGridAdapter$7
  implements View.OnClickListener
{
  PhotoGridAdapter$7(PhotoGridAdapter paramPhotoGridAdapter) {}
  
  public void onClick(View paramView)
  {
    SimpleEventBus.getInstance().dispatchEvent(new AECircleJumpCameraPageEvent());
    AEReportUtils.a(7, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter.7
 * JD-Core Version:    0.7.0.1
 */