package me.ele.uetool.colorpicker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DisplaySize
{
  private DisplayMetrics displayMetrics = new DisplayMetrics();
  
  public DisplaySize(Context paramContext)
  {
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.displayMetrics);
  }
  
  public int getDisplayHeightInPixel()
  {
    return this.displayMetrics.heightPixels;
  }
  
  public int getDisplayWidthInPixel()
  {
    return this.displayMetrics.widthPixels;
  }
  
  public int getPixel(int paramInt)
  {
    return (int)(paramInt * this.displayMetrics.densityDpi / 160.0F);
  }
  
  public int getWidgetHeightInPixel()
  {
    return getPixel(72);
  }
  
  public int getWidgetWidthInPixel()
  {
    return getPixel(294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.colorpicker.DisplaySize
 * JD-Core Version:    0.7.0.1
 */