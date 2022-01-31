import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class sjq
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  sjq(sjp paramsjp, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Sjp.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a) + sjp.a(this.jdField_a_of_type_Sjp));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Sjp.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Sjp.a) + sjp.b(this.jdField_a_of_type_Sjp));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a, this.jdField_a_of_type_Sjp.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sjp.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sjq
 * JD-Core Version:    0.7.0.1
 */