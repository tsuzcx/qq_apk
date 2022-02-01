package dov.com.qq.im.ae.biz.qcircle.adapter;

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
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo)) {
      QQToast.a(paramView.getContext(), HardCodeUtil.a(2131689796), 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PhotoGridAdapter.a(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter, this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter.a, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter.3
 * JD-Core Version:    0.7.0.1
 */