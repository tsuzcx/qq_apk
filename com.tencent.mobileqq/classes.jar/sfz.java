import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;

public class sfz
  extends PopupWindow
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout.LayoutParams jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private sga jdField_a_of_type_Sga;
  private int b;
  private int c = 80;
  private int d = 49;
  
  public sfz(Context paramContext)
  {
    super(-2, -2);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    sga localsga = new sga(this, this.jdField_a_of_type_AndroidContentContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_Sga = localsga;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams = localLayoutParams;
    setBackgroundDrawable(new ColorDrawable(0));
    setTouchable(true);
    setFocusable(false);
    setSoftInputMode(1);
    setInputMethodMode(2);
    a(24, 12);
    a(12);
    c(6);
    b(-1);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.gravity = this.d;
    sga.a(this.jdField_a_of_type_Sga).setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Sga, this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = this.c;
    switch (this.c)
    {
    }
    for (;;)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(this.jdField_a_of_type_Int);
      localGradientDrawable.setCornerRadius(this.b);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localGradientDrawable);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      super.setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      return;
      localLayoutParams.rightMargin = sga.a(this.jdField_a_of_type_Sga);
      this.jdField_a_of_type_Sga.setRotation(90.0F);
      continue;
      localLayoutParams.bottomMargin = sga.a(this.jdField_a_of_type_Sga);
      this.jdField_a_of_type_Sga.setRotation(180.0F);
      continue;
      localLayoutParams.leftMargin = sga.a(this.jdField_a_of_type_Sga);
      this.jdField_a_of_type_Sga.setRotation(270.0F);
      continue;
      localLayoutParams.topMargin = sga.a(this.jdField_a_of_type_Sga);
      this.jdField_a_of_type_Sga.setRotation(0.0F);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public void a(int paramInt)
  {
    sga.c(this.jdField_a_of_type_Sga, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    sga.a(this.jdField_a_of_type_Sga, paramInt1);
    sga.b(this.jdField_a_of_type_Sga, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.leftMargin = paramInt1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.rightMargin = paramInt2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.topMargin = paramInt3;
    this.jdField_a_of_type_AndroidWidgetFrameLayout$LayoutParams.bottomMargin = paramInt4;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 49;
    if (!isShowing())
    {
      int i = j;
      switch (paramInt1)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        this.c = paramInt1;
        d(i);
        showAtLocation(paramView, 0, paramInt2, paramInt3);
        return;
        i = 81;
        continue;
        i = 19;
        continue;
        i = 21;
      }
    }
    dismiss();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    this.jdField_a_of_type_AndroidViewView.measure(0, 0);
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return sga.a(this.jdField_a_of_type_Sga);
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setContentView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt3;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      b();
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      b();
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfz
 * JD-Core Version:    0.7.0.1
 */