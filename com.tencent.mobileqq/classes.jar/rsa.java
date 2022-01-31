import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class rsa
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  rsa(rrz paramrrz, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rrz.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rrz.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rrz.a) + rrz.a(this.jdField_a_of_type_Rrz));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rrz.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rrz.a) + rrz.b(this.jdField_a_of_type_Rrz));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rrz.a, this.jdField_a_of_type_Rrz.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rrz.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rrz.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rrz.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rrz.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsa
 * JD-Core Version:    0.7.0.1
 */