package me.ele.uetool.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.uetool.colorpicker.listener.OnHUEChangedListener;

public class HUEPicker
  extends ImageView
{
  private Bitmap HUEBitmap;
  private Bitmap HUEBitmapCopy;
  ColorPaint colorPaint = ColorPaint.getInstance();
  private int curColorX = (int)this.markPoint;
  private ArrayList<OnHUEChangedListener> listeners = new ArrayList();
  private float markPoint = 10.0F;
  private int panelHeight = 1;
  private int panelWidth = 1;
  private int selectColor;
  
  public HUEPicker(Context paramContext)
  {
    super(paramContext);
  }
  
  public HUEPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HUEPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void callListener(boolean paramBoolean)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((OnHUEChangedListener)localIterator.next()).onHUEChange(this.selectColor, paramBoolean);
    }
  }
  
  private void deal(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = j;
    if (j < this.markPoint) {
      i = (int)this.markPoint;
    }
    j = i;
    if (i > this.panelWidth - this.markPoint) {
      j = (int)(this.panelWidth - this.markPoint - 1.0F);
    }
    getChange(j);
  }
  
  private void getChange(int paramInt)
  {
    this.selectColor = this.HUEBitmap.getPixel(paramInt, (int)this.markPoint);
    this.curColorX = paramInt;
    makeMarkedHUEBitmap();
    callListener(true);
  }
  
  @RequiresApi(api=21)
  private Bitmap makeHueBitmap()
  {
    Canvas localCanvas = new Canvas();
    this.HUEBitmap = Bitmap.createBitmap(this.panelWidth, this.panelHeight, Bitmap.Config.ARGB_8888);
    localCanvas.setBitmap(this.HUEBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    float f1 = this.markPoint;
    float f2 = this.panelHeight;
    float f3 = this.panelWidth;
    float f4 = this.markPoint;
    float f5 = this.panelHeight;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    localPaint.setShader(new LinearGradient(f1, f2 * 0.5F, f3 + f4, f5 * 0.5F, new int[] { -65536, -256, -16711936, -16711681, -16776961, -65281, -65536 }, new float[] { 0.0F, 0.17F, 0.34F, 0.51F, 0.68F, 0.85F, 1.0F }, localTileMode));
    localCanvas.drawRoundRect(this.markPoint, this.markPoint / 2.0F, this.panelWidth - this.markPoint, this.panelHeight - this.markPoint / 2.0F, 10.0F, 10.0F, localPaint);
    return this.HUEBitmap;
  }
  
  public void addListener(OnHUEChangedListener paramOnHUEChangedListener)
  {
    this.listeners.add(paramOnHUEChangedListener);
  }
  
  @RequiresApi(api=21)
  public void initColor(int paramInt)
  {
    this.selectColor = paramInt;
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    this.curColorX = ((int)(arrayOfFloat[0] * (this.panelWidth - 2.0F * this.markPoint) / 360.0F + this.markPoint));
    makeMarkedHUEBitmap();
    callListener(false);
  }
  
  public void makeMarkedHUEBitmap()
  {
    this.HUEBitmapCopy = Bitmap.createBitmap(this.HUEBitmap);
    Canvas localCanvas = new Canvas(this.HUEBitmapCopy);
    this.colorPaint.paintSelectedHueColorForHueMarker.setColor(this.selectColor);
    localCanvas.drawCircle(this.curColorX, this.markPoint, this.markPoint - 10.0F, this.colorPaint.paintWhite);
    localCanvas.drawCircle(this.curColorX, this.markPoint, this.markPoint - 10.0F, this.colorPaint.paintSelectedHueColorForHueMarker);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    setImageBitmap(this.HUEBitmapCopy);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = paramInt2;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = 0;
    case 0: 
      paramInt2 = paramInt1;
      switch (j)
      {
      default: 
        paramInt2 = 0;
      }
      break;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, i);
      return;
      i = this.panelHeight;
      break;
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      paramInt2 = this.panelWidth;
      continue;
      paramInt2 = View.MeasureSpec.getSize(paramInt1);
    }
  }
  
  @RequiresApi(api=21)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.panelWidth = getMeasuredWidth();
    this.panelHeight = getMeasuredHeight();
    this.markPoint = (this.panelHeight / 2);
    makeHueBitmap();
    this.curColorX = ((int)this.markPoint);
    makeMarkedHUEBitmap();
    initColor(this.selectColor);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      deal(paramMotionEvent);
      return true;
      deal(paramMotionEvent);
    }
  }
  
  @RequiresApi(api=21)
  public void setColor(int paramInt)
  {
    initColor(paramInt);
  }
  
  public void setInitColor(int paramInt)
  {
    this.selectColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.colorpicker.HUEPicker
 * JD-Core Version:    0.7.0.1
 */