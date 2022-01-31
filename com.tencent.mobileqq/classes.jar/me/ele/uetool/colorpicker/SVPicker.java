package me.ele.uetool.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import me.ele.uetool.colorpicker.listener.OnSVChangedListener;
import me.ele.uetool.util.ViewKnife;

public class SVPicker
  extends ImageView
{
  private int baseColor = -16711936;
  ColorPaint colorPaint = ColorPaint.getInstance();
  private int curColor = 0;
  private int curColorX = (int)this.markPoint;
  private int curColorY = (int)this.markPoint;
  private ArrayList<OnSVChangedListener> listeners = new ArrayList();
  private float markPoint = ViewKnife.dip2px(35.0F) / 2;
  private int panelHeight = 1;
  private int panelWidth = 1;
  private Shader shaderValue;
  private Bitmap svBitmap;
  private Bitmap svBitmapCopy;
  private Paint svPaint = new Paint();
  
  public SVPicker(Context paramContext)
  {
    super(paramContext);
  }
  
  public SVPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void callListener(boolean paramBoolean)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((OnSVChangedListener)localIterator.next()).onSVChanged(this.curColor, paramBoolean);
    }
  }
  
  private void changeBaseColor(int paramInt)
  {
    this.baseColor = getBaseColor(paramInt);
    makeSVPanelBitmap();
  }
  
  private void changeColor(int paramInt1, int paramInt2)
  {
    this.curColor = this.svBitmap.getPixel(paramInt1, paramInt2);
    this.curColorX = paramInt1;
    this.curColorY = paramInt2;
    makeMarkerOnSVBitmap();
    callListener(true);
  }
  
  private int getBaseColor(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    arrayOfFloat[1] = 1.0F;
    arrayOfFloat[2] = 1.0F;
    return Color.HSVToColor(arrayOfFloat);
  }
  
  private void initPosition(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    this.curColorX = ((int)((int)(arrayOfFloat[1] * (this.panelWidth - this.markPoint * 2.0F - 1.0F)) + this.markPoint));
    this.curColorY = ((int)(this.panelHeight - this.markPoint * 2.0F - 1.0F - arrayOfFloat[2] * (this.panelHeight - this.markPoint * 2.0F - 1.0F) + this.markPoint));
  }
  
  private void makeMarkerOnSVBitmap()
  {
    this.svBitmapCopy = Bitmap.createBitmap(this.svBitmap);
    Canvas localCanvas = new Canvas(this.svBitmapCopy);
    this.colorPaint.paintSelectedColorForMarker.setColor(this.curColor);
    localCanvas.drawCircle(this.curColorX, this.curColorY, this.markPoint - 10.0F, this.colorPaint.paintWhite);
    localCanvas.drawCircle(this.curColorX, this.curColorY, this.markPoint - 10.0F, this.colorPaint.paintSelectedColorForMarker);
  }
  
  private Bitmap makeSVPanelBitmap()
  {
    Canvas localCanvas = new Canvas();
    this.svBitmap = Bitmap.createBitmap(this.panelWidth, this.panelHeight, Bitmap.Config.ARGB_8888);
    localCanvas.setBitmap(this.svBitmap);
    ComposeShader localComposeShader = new ComposeShader(new LinearGradient(this.markPoint, 0.0F, this.panelWidth - this.markPoint, 0.0F, -1, this.baseColor, Shader.TileMode.CLAMP), this.shaderValue, PorterDuff.Mode.DARKEN);
    this.svPaint.setShader(localComposeShader);
    localCanvas.drawRect(this.markPoint, this.markPoint, this.panelWidth - this.markPoint, this.panelHeight - this.markPoint, this.svPaint);
    return this.svBitmap;
  }
  
  public void addListener(OnSVChangedListener paramOnSVChangedListener)
  {
    this.listeners.add(paramOnSVChangedListener);
  }
  
  public void deal(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = j;
    if (j < this.markPoint) {
      i = (int)this.markPoint;
    }
    j = i;
    if (i > this.panelWidth - this.markPoint) {
      j = (int)(this.panelWidth - this.markPoint - 1.0F);
    }
    i = k;
    if (k < this.markPoint) {
      i = (int)this.markPoint;
    }
    k = i;
    if (i > this.panelHeight - this.markPoint) {
      k = (int)(this.panelHeight - this.markPoint - 1.0F);
    }
    changeColor(j, k);
  }
  
  public void initColor(int paramInt)
  {
    this.curColor = paramInt;
    changeBaseColor(paramInt);
    initPosition(paramInt);
    makeMarkerOnSVBitmap();
    callListener(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    setImageBitmap(this.svBitmapCopy);
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
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.panelWidth = getMeasuredWidth();
    this.panelHeight = getMeasuredHeight();
    this.shaderValue = new LinearGradient(0.0F, this.markPoint, 0.0F, this.panelHeight - this.markPoint, 0, -16777216, Shader.TileMode.CLAMP);
    this.svPaint.setAntiAlias(true);
    changeBaseColor(this.curColor);
    initPosition(this.curColor);
    makeMarkerOnSVBitmap();
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
  
  public void setColorByHUE(int paramInt, boolean paramBoolean)
  {
    this.curColor = paramInt;
    changeBaseColor(paramInt);
    if (paramBoolean)
    {
      changeColor(this.curColorX, this.curColorY);
      makeMarkerOnSVBitmap();
      callListener(true);
      return;
    }
    initPosition(paramInt);
    makeMarkerOnSVBitmap();
    callListener(false);
  }
  
  public void setCurColor(int paramInt)
  {
    this.curColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.colorpicker.SVPicker
 * JD-Core Version:    0.7.0.1
 */