package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MicroPhoneClipImageView
  extends ImageView
{
  public static final int[] a;
  private ClipDrawable jdField_a_of_type_AndroidGraphicsDrawableClipDrawable;
  private boolean jdField_a_of_type_Boolean;
  private int[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 3658, 4390, 5182, 6036, 6829, 7621, 8536, 9207 };
  }
  
  public MicroPhoneClipImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MicroPhoneClipImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MicroPhoneClipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt)
  {
    int j = jdField_a_of_type_ArrayOfInt.length - 2;
    if (this.b == null)
    {
      this.b = new int[jdField_a_of_type_ArrayOfInt.length];
      i = 0;
      while (i < j)
      {
        this.b[(i + 1)] = (8000 - (j - i) * 7900 / j);
        i += 1;
      }
      this.b[0] = 0;
      this.b[(this.b.length - 1)] = 8000;
    }
    int i = this.b.length - 1;
    if (i >= 0) {
      if (paramInt < this.b[i]) {}
    }
    for (;;)
    {
      if (i == -1)
      {
        return 0;
        i -= 1;
        break;
      }
      return i;
      i = -1;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable = ((ClipDrawable)getDrawable());
  }
  
  public void setRecordState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSoundWave(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = a(paramInt);
      this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(jdField_a_of_type_ArrayOfInt[paramInt]);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableClipDrawable.setLevel(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MicroPhoneClipImageView
 * JD-Core Version:    0.7.0.1
 */