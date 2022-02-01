import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;

public class sjn
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Object jdField_a_of_type_JavaLangObject;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public sjn(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.c != null)
    {
      this.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.c.setTag(this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131366068)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366069));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366063));
      this.c = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380731));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
    }
    c();
    ryx.a(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843115);
    int i = zby.b(this.jdField_a_of_type_AndroidContentContext, 18.6F);
    localDrawable.setBounds(0, 0, i, i);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
    if (paramInt == 1)
    {
      this.c.setVisibility(0);
      paramString1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841772);
      paramInt = zby.b(this.jdField_a_of_type_AndroidContentContext, 18.6F);
      paramString1.setBounds(0, 0, paramInt, paramInt);
      this.c.setCompoundDrawables(paramString1, null, null, null);
      this.c.setCompoundDrawablePadding(afur.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
    }
    this.c.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.requestLayout();
  }
  
  public void a(View.OnClickListener paramOnClickListener, Object paramObject)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    c();
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      ryx.a(this.jdField_b_of_type_AndroidViewView, 8, 300, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjn
 * JD-Core Version:    0.7.0.1
 */