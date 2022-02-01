import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class szb
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  szb(sza paramsza, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Sza.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a) + sza.a(this.jdField_a_of_type_Sza));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Sza.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Sza.a) + sza.b(this.jdField_a_of_type_Sza));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a, this.jdField_a_of_type_Sza.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Sza.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szb
 * JD-Core Version:    0.7.0.1
 */