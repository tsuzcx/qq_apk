import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class rtb
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  rtb(rta paramrta, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rta.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rta.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rta.a) + rta.a(this.jdField_a_of_type_Rta));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rta.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rta.a) + rta.b(this.jdField_a_of_type_Rta));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rta.a, this.jdField_a_of_type_Rta.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rta.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rta.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rta.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rta.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtb
 * JD-Core Version:    0.7.0.1
 */