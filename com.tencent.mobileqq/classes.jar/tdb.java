import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class tdb
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  tdb(tda paramtda, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Tda.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a) + tda.a(this.jdField_a_of_type_Tda));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tda.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tda.a) + tda.b(this.jdField_a_of_type_Tda));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a, this.jdField_a_of_type_Tda.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tda.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdb
 * JD-Core Version:    0.7.0.1
 */