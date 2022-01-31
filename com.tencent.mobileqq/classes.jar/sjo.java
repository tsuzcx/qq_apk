import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class sjo
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  sjo(sjn paramsjn, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Sjn.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjn.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjn.a) + sjn.a(this.jdField_a_of_type_Sjn));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Sjn.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Sjn.a) + sjn.b(this.jdField_a_of_type_Sjn));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjn.a, this.jdField_a_of_type_Sjn.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjn.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjn.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjn.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjn.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sjo
 * JD-Core Version:    0.7.0.1
 */