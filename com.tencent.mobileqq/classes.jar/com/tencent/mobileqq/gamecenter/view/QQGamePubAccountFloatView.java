package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class QQGamePubAccountFloatView
  extends RelativeLayout
  implements Handler.Callback
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public boolean a;
  public int b;
  private ImageView b;
  public boolean b;
  public int c;
  public int d;
  private int e = 3;
  
  public QQGamePubAccountFloatView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QQGamePubAccountFloatView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQGamePubAccountFloatView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = true;
      invalidate();
      return false;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    invalidate();
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_b_of_type_Boolean) {
      requestLayout();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = View.MeasureSpec.getSize(paramInt1);
      this.d = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int * 1.7D));
      this.c = this.d;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label116;
      }
      if (this.jdField_b_of_type_Int < this.c) {
        break label100;
      }
      this.c += this.e;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.c, View.MeasureSpec.getMode(paramInt2)));
      return;
      label100:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_Boolean = false;
      continue;
      label116:
      if (this.c >= this.d)
      {
        this.c -= this.e;
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.QQGamePubAccountFloatView
 * JD-Core Version:    0.7.0.1
 */