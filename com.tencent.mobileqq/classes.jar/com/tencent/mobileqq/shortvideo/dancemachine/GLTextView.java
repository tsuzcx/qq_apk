package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import java.util.ArrayList;
import java.util.Iterator;

public class GLTextView
  extends GLImageView
{
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float b = 0.0F;
  
  public GLTextView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    f(4);
  }
  
  private void g()
  {
    float f1 = a();
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)f1, this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    float f2 = Math.abs(this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    GLTextView.StringItem localStringItem;
    for (f1 = 0.0F; localIterator.hasNext(); f1 = localStringItem.jdField_a_of_type_Float + f1)
    {
      localStringItem = (GLTextView.StringItem)localIterator.next();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(localStringItem.b);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawText(localStringItem.jdField_a_of_type_JavaLangString, f1, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public float a()
  {
    if (this.b == 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        GLTextView.StringItem localStringItem = (GLTextView.StringItem)localIterator.next();
        localStringItem.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(localStringItem.jdField_a_of_type_JavaLangString);
        float f = this.b;
        this.b = (localStringItem.jdField_a_of_type_Float + f);
      }
    }
    return this.b;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      g();
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    GLTextView.StringItem localStringItem = new GLTextView.StringItem(this);
    localStringItem.jdField_a_of_type_JavaLangString = paramString;
    localStringItem.jdField_a_of_type_Int = paramInt1;
    localStringItem.b = paramInt2;
    this.jdField_a_of_type_JavaUtilArrayList.add(localStringItem);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLTextView
 * JD-Core Version:    0.7.0.1
 */