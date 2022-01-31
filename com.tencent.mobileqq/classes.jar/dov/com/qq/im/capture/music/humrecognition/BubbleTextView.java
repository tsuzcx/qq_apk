package dov.com.qq.im.capture.music.humrecognition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import vms;
import vrd;

public class BubbleTextView
  extends TextView
{
  public float a;
  public int a;
  private vrd a;
  public boolean a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d = 50.0F;
  
  public BubbleTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 11.0F);
    this.jdField_b_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 3.0F);
    this.jdField_c_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 5.0F);
    this.jdField_a_of_type_Int = Color.rgb(255, 189, 161);
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 11.0F);
    this.jdField_b_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 3.0F);
    this.jdField_c_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 5.0F);
    this.jdField_a_of_type_Int = Color.rgb(255, 189, 161);
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    a();
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 11.0F);
    this.jdField_b_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 3.0F);
    this.jdField_c_of_type_Float = vms.a(BaseApplicationImpl.getContext(), 5.0F);
    this.jdField_a_of_type_Int = Color.rgb(255, 189, 161);
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(0, paramInt1, 0, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Vrd = new vrd();
    this.jdField_a_of_type_Vrd.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramInt1, paramInt3, paramInt2, paramInt4);
    this.jdField_a_of_type_Vrd.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Vrd.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Vrd.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    this.jdField_a_of_type_Vrd.jdField_c_of_type_Float = this.jdField_c_of_type_Float;
    this.jdField_a_of_type_Vrd.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_Vrd.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Vrd.d = this.d;
    this.jdField_a_of_type_Vrd.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  private void c()
  {
    a(getWidth(), getHeight());
  }
  
  private void d()
  {
    int m = getPaddingLeft();
    int k = getPaddingRight();
    int j = getPaddingTop();
    int i = getPaddingBottom();
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      setPadding(m, j, k, i);
      return;
      m = (int)(m + this.jdField_a_of_type_Float);
      continue;
      k = (int)(k + this.jdField_a_of_type_Float);
      continue;
      j = (int)(j + this.jdField_c_of_type_Float);
      continue;
      i = (int)(i + this.jdField_c_of_type_Float);
    }
  }
  
  public void a()
  {
    b();
    d();
  }
  
  protected void b() {}
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Vrd != null) {
      this.jdField_a_of_type_Vrd.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.BubbleTextView
 * JD-Core Version:    0.7.0.1
 */