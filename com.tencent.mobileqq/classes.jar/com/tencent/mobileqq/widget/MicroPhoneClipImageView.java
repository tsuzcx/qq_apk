package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MicroPhoneClipImageView
  extends ImageView
{
  public static final int[] a = { 3658, 4390, 5182, 6036, 6829, 7621, 8536, 9207 };
  private int[] b = null;
  private boolean c;
  private ClipDrawable d;
  
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
    int[] arrayOfInt = a;
    int k = arrayOfInt.length - 2;
    if (this.b == null)
    {
      this.b = new int[arrayOfInt.length];
      int j;
      for (i = 0; i < k; i = j)
      {
        arrayOfInt = this.b;
        j = i + 1;
        arrayOfInt[j] = (8000 - 7900 * (k - i) / k);
      }
      arrayOfInt = this.b;
      arrayOfInt[0] = 0;
      arrayOfInt[(arrayOfInt.length - 1)] = 8000;
    }
    int i = this.b.length - 1;
    while (i >= 0)
    {
      if (paramInt >= this.b[i]) {
        break label126;
      }
      i -= 1;
    }
    i = -1;
    label126:
    paramInt = i;
    if (i == -1) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private void a()
  {
    this.d = ((ClipDrawable)getDrawable());
  }
  
  public void setRecordState(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setSoundWave(int paramInt)
  {
    if (this.c)
    {
      paramInt = a(paramInt);
      this.d.setLevel(a[paramInt]);
      return;
    }
    this.d.setLevel(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MicroPhoneClipImageView
 * JD-Core Version:    0.7.0.1
 */