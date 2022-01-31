import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class rsd
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  rsd(rsc paramrsc, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rsc.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsc.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsc.a) + rsc.a(this.jdField_a_of_type_Rsc));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rsc.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rsc.a) + rsc.b(this.jdField_a_of_type_Rsc));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsc.a, this.jdField_a_of_type_Rsc.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsc.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsc.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsc.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsc.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsd
 * JD-Core Version:    0.7.0.1
 */