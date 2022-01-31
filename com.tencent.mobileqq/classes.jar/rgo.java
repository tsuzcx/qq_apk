import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class rgo
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  rgo(rgn paramrgn, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rgn.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgn.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgn.a) + rgn.a(this.jdField_a_of_type_Rgn));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rgn.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rgn.a) + rgn.b(this.jdField_a_of_type_Rgn));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgn.a, this.jdField_a_of_type_Rgn.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgn.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgn.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgn.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgn.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgo
 * JD-Core Version:    0.7.0.1
 */