package dov.com.qq.im.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.entry.AECameraEntry;
import java.util.Date;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$3
  implements View.OnClickListener
{
  WatermarkEditListAdapter$3(WatermarkEditListAdapter paramWatermarkEditListAdapter, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder, WMElement paramWMElement) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).getWindowToken(), 0);
    WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).setTextColor(-1);
    WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter, WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter));
    WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter$EditTextViewHolder.a);
    if (AECameraEntry.k(WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).getIntent())) {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).setTextColor(WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).getResources().getColor(2131165273));
    }
    for (;;)
    {
      WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_OrgLightBeanWMElement);
      if (WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter) != null)
      {
        Date localDate = WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter, this.jdField_a_of_type_OrgLightBeanWMElement.getInnerValue());
        WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).a(localDate);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).setTextColor(WatermarkEditListAdapter.a(this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditListAdapter).getResources().getColor(2131165274));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.3
 * JD-Core Version:    0.7.0.1
 */