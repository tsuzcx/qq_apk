package dov.com.qq.im.ae.camera.ui.watermark;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$4
  implements View.OnFocusChangeListener
{
  WatermarkEditListAdapter$4(WatermarkEditListAdapter paramWatermarkEditListAdapter, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder, WMElement paramWMElement) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_OrgLightBeanWMElement);
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837718);
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.4
 * JD-Core Version:    0.7.0.1
 */