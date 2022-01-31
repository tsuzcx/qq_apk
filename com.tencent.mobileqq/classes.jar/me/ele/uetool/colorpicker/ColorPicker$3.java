package me.ele.uetool.colorpicker;

import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import me.ele.uetool.colorpicker.listener.OnAlphaChangedListenter;

class ColorPicker$3
  implements OnAlphaChangedListenter
{
  ColorPicker$3(ColorPicker paramColorPicker) {}
  
  public void onAlphaChanged(int paramInt, boolean paramBoolean)
  {
    ColorPicker.access$202(this.this$0, paramInt);
    ColorPicker.access$300(this.this$0).setText("透明度: " + (int)(ColorPicker.access$100(this.this$0).getPes() * 100.0F) + "%");
    ((GradientDrawable)ColorPicker.access$400(this.this$0).getBackground()).setColor(paramInt);
    ColorPicker.access$400(this.this$0).setText(this.this$0.colorToString(paramInt));
    ColorPicker.access$500(this.this$0, paramInt, ColorPicker.access$400(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.colorpicker.ColorPicker.3
 * JD-Core Version:    0.7.0.1
 */