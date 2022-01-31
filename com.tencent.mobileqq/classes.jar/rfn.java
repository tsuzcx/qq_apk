import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class rfn
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  rfn(rfm paramrfm, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rfm.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfm.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfm.a) + rfm.a(this.jdField_a_of_type_Rfm));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rfm.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rfm.a) + rfm.b(this.jdField_a_of_type_Rfm));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfm.a, this.jdField_a_of_type_Rfm.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfm.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfm.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfm.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfm.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfn
 * JD-Core Version:    0.7.0.1
 */