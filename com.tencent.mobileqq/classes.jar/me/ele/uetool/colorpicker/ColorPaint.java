package me.ele.uetool.colorpicker;

import android.graphics.Paint;
import android.graphics.Paint.Style;

public class ColorPaint
{
  public static ColorPaint instance;
  public Paint paintBlack = new Paint();
  public Paint paintBlackFill;
  public Paint paintSelectedColorForMarker;
  public Paint paintSelectedHueColorForHueMarker;
  public Paint paintWhite = new Paint();
  public Paint paintWhiteFill;
  
  private ColorPaint()
  {
    this.paintBlack.setColor(-16777216);
    this.paintBlack.setAntiAlias(true);
    this.paintBlack.setStrokeWidth(2.0F);
    this.paintBlack.setStyle(Paint.Style.STROKE);
    this.paintWhite.setColor(-1);
    this.paintWhite.setAntiAlias(true);
    this.paintWhite.setStrokeWidth(10.0F);
    this.paintWhite.setStyle(Paint.Style.STROKE);
    this.paintBlackFill = new Paint();
    this.paintBlackFill.setColor(-16777216);
    this.paintBlackFill.setAntiAlias(true);
    this.paintBlackFill.setStyle(Paint.Style.FILL);
    this.paintWhiteFill = new Paint();
    this.paintWhiteFill.setColor(-1);
    this.paintWhiteFill.setAntiAlias(true);
    this.paintWhiteFill.setStyle(Paint.Style.FILL);
    this.paintSelectedColorForMarker = new Paint();
    this.paintSelectedColorForMarker.setAntiAlias(true);
    this.paintSelectedColorForMarker.setStyle(Paint.Style.FILL);
    this.paintSelectedHueColorForHueMarker = new Paint();
    this.paintSelectedHueColorForHueMarker.setAntiAlias(true);
    this.paintSelectedHueColorForHueMarker.setStyle(Paint.Style.FILL);
  }
  
  public static ColorPaint getInstance()
  {
    if (instance == null) {
      instance = new ColorPaint();
    }
    return instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.colorpicker.ColorPaint
 * JD-Core Version:    0.7.0.1
 */