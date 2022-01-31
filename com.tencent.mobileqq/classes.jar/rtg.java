import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class rtg
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  rtg(rtf paramrtf, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rtf.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a) + rtf.a(this.jdField_a_of_type_Rtf));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rtf.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rtf.a) + rtf.b(this.jdField_a_of_type_Rtf));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a, this.jdField_a_of_type_Rtf.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtf.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtg
 * JD-Core Version:    0.7.0.1
 */