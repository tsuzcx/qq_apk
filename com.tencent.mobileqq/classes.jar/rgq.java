import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class rgq
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  rgq(rgp paramrgp, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rgp.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a) + rgp.a(this.jdField_a_of_type_Rgp));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rgp.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rgp.a) + rgp.b(this.jdField_a_of_type_Rgp));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a, this.jdField_a_of_type_Rgp.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rgp.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgq
 * JD-Core Version:    0.7.0.1
 */