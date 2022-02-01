package me.ele.uetool.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ColorPickerFloatView$2
  implements View.OnClickListener
{
  ColorPickerFloatView$2(ColorPickerFloatView paramColorPickerFloatView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.removeFromWindow();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.ColorPickerFloatView.2
 * JD-Core Version:    0.7.0.1
 */