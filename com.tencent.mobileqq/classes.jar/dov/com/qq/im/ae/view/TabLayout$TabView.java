package dov.com.qq.im.ae.view;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

class TabLayout$TabView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int b;
  private int c;
  private int d;
  
  public TabLayout$TabView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    if (!paramBoolean)
    {
      i = AECircleCaptureStyle.a.t;
      this.jdField_a_of_type_Int = i;
      if (paramBoolean) {
        break label85;
      }
      i = AECircleCaptureStyle.a.s;
      label32:
      this.b = i;
      if (paramBoolean) {
        break label95;
      }
      i = AECircleCaptureStyle.b.t;
      label48:
      this.c = i;
      if (paramBoolean) {
        break label105;
      }
    }
    label85:
    label95:
    label105:
    for (int i = AECircleCaptureStyle.b.s;; i = AECircleCaptureStyle.f.s)
    {
      this.d = i;
      a(paramContext);
      return;
      i = AECircleCaptureStyle.e.t;
      break;
      i = AECircleCaptureStyle.e.s;
      break label32;
      i = AECircleCaptureStyle.f.t;
      break label48;
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 15.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean1) {}
      for (i = this.b;; i = this.jdField_a_of_type_Int)
      {
        localTextView.setTextColor(i);
        if (!paramBoolean2) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(1.0F, 0.0F, 0.0F, 2131165368);
        return;
      }
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean1) {}
    for (int i = this.d;; i = this.c)
    {
      localTextView.setTextColor(i);
      break;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.TabLayout.TabView
 * JD-Core Version:    0.7.0.1
 */