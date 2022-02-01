package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;

class PhotoGridAdapter$5
  implements View.OnClickListener
{
  PhotoGridAdapter$5(PhotoGridAdapter paramPhotoGridAdapter, int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH) {}
  
  public void onClick(View paramView)
  {
    PhotoGridAdapter.b(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoVH);
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter.5
 * JD-Core Version:    0.7.0.1
 */