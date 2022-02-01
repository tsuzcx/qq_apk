import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.tencent.av.utils.QQFrameByFrameAnimation.1;

public class mtc
{
  public int a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new QQFrameByFrameAnimation.1(this);
  public mtb a;
  public int[] a;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  
  public mtc()
  {
    this.jdField_a_of_type_Mtb = null;
    this.jdField_a_of_type_Int = 300;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void a()
  {
    this.c += 1;
    int i;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      i = this.jdField_a_of_type_ArrayOfInt[(this.c % this.jdField_a_of_type_ArrayOfInt.length)];
      if (!(this.jdField_a_of_type_AndroidViewView instanceof ImageButton)) {
        break label67;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(i);
    }
    label67:
    while (!(this.jdField_a_of_type_AndroidViewView instanceof Button)) {
      return;
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(i);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    ((Button)this.jdField_a_of_type_AndroidViewView).setCompoundDrawables(null, localDrawable, null, null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(mtb parammtb)
  {
    this.jdField_a_of_type_Mtb = parammtb;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0))
    {
      this.c = 0;
      if ((this.jdField_a_of_type_AndroidViewView instanceof ImageButton)) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ArrayOfInt[0]);
      }
      if ((this.jdField_a_of_type_AndroidViewView instanceof Button))
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(this.jdField_a_of_type_ArrayOfInt[0]);
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        ((Button)this.jdField_a_of_type_AndroidViewView).setCompoundDrawables(null, localDrawable, null, null);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Mtb != null) {
        this.jdField_a_of_type_Mtb.d();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_Mtb != null) {
      this.jdField_a_of_type_Mtb.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtc
 * JD-Core Version:    0.7.0.1
 */