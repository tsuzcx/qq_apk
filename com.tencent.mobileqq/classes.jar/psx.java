import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;

public class psx
  extends ClickableSpan
  implements rvl, sha
{
  private int jdField_a_of_type_Int = -1;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  boolean jdField_a_of_type_Boolean;
  private int b = -1;
  private int c = -1;
  
  public psx(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidTextTextPaint != null) {
      updateDrawState(this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      return;
    }
    paramView.callOnClick();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.c);
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.b;; i = this.jdField_a_of_type_Int)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     psx
 * JD-Core Version:    0.7.0.1
 */