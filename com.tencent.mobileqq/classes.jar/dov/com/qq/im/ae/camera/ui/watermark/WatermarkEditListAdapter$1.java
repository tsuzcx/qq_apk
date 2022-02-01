package dov.com.qq.im.ae.camera.ui.watermark;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$1
  implements View.OnClickListener
{
  WatermarkEditListAdapter$1(WatermarkEditListAdapter paramWatermarkEditListAdapter, WMElement paramWMElement, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder) {}
  
  public void onClick(View paramView)
  {
    if ("CHECK_IN".equals(this.jdField_a_of_type_OrgLightBeanWMElement.type)) {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.a.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.1
 * JD-Core Version:    0.7.0.1
 */