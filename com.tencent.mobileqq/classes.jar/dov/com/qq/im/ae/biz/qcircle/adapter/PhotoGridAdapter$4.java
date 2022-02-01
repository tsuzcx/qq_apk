package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;

class PhotoGridAdapter$4
  implements View.OnClickListener
{
  PhotoGridAdapter$4(PhotoGridAdapter paramPhotoGridAdapter, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))
    {
      QQToast.a(paramView.getContext(), HardCodeUtil.a(2131689796), 0).a();
      this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoVH.a.setChecked(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PhotoGridAdapter.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoVH);
      SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter.4
 * JD-Core Version:    0.7.0.1
 */