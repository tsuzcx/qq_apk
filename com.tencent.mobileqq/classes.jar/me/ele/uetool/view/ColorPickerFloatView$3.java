package me.ele.uetool.view;

import android.support.annotation.RequiresApi;
import android.view.View;
import me.ele.uetool.util.ImageCapture;

class ColorPickerFloatView$3
  implements Runnable
{
  ColorPickerFloatView$3(ColorPickerFloatView paramColorPickerFloatView) {}
  
  @RequiresApi(api=21)
  public void run()
  {
    ColorPickerFloatView.access$900(this.this$0).capture();
    this.this$0.getRootView().setVisibility(0);
    ColorPickerFloatView.access$800(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.ColorPickerFloatView.3
 * JD-Core Version:    0.7.0.1
 */