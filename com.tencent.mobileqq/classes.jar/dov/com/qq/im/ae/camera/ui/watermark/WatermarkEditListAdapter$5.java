package dov.com.qq.im.ae.camera.ui.watermark;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$5
  implements View.OnClickListener
{
  WatermarkEditListAdapter$5(WatermarkEditListAdapter paramWatermarkEditListAdapter, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder, WMElement paramWMElement) {}
  
  public void onClick(View paramView)
  {
    WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.a, this.jdField_a_of_type_OrgLightBeanWMElement);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.5
 * JD-Core Version:    0.7.0.1
 */