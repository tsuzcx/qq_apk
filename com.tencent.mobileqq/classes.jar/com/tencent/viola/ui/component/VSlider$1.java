package com.tencent.viola.ui.component;

import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VSliderView.VSliderListener;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;

class VSlider$1
  implements VSliderView.VSliderListener
{
  VSlider$1(VSlider paramVSlider) {}
  
  public void change(int paramInt)
  {
    this.this$0.mDomObj.saveState("index", Integer.valueOf(paramInt));
    VSlider.access$000(this.this$0, paramInt);
    if (!this.this$0.mAppendEvents.contains("change")) {
      return;
    }
    VSlider.access$100(this.this$0, paramInt);
    ViolaLogUtils.d("VSlider", "change: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSlider.1
 * JD-Core Version:    0.7.0.1
 */