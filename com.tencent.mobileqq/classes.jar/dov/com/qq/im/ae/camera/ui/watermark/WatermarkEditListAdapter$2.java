package dov.com.qq.im.ae.camera.ui.watermark;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.poi.AESelectLocationFragment;

class WatermarkEditListAdapter$2
  implements View.OnClickListener
{
  WatermarkEditListAdapter$2(WatermarkEditListAdapter paramWatermarkEditListAdapter) {}
  
  public void onClick(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)AEModule.getContext().getSystemService("input_method");
    if (WatermarkEditListAdapter.a(this.a) != null)
    {
      localInputMethodManager.hideSoftInputFromWindow(WatermarkEditListAdapter.a(this.a).getWindowToken(), 0);
      WatermarkEditListAdapter.a(this.a, WatermarkEditListAdapter.a(this.a));
      WatermarkEditListAdapter.a(this.a).setTextColor(-1);
    }
    if (WatermarkEditListAdapter.a(this.a) != null) {
      WatermarkEditListAdapter.a(this.a).b();
    }
    AESelectLocationFragment.a(WatermarkEditListAdapter.a(this.a), 203);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditListAdapter.2
 * JD-Core Version:    0.7.0.1
 */