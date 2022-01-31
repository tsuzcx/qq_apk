import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class rsf
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  rsf(rse paramrse, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rse.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a) + rse.a(this.jdField_a_of_type_Rse));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rse.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rse.a) + rse.b(this.jdField_a_of_type_Rse));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a, this.jdField_a_of_type_Rse.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rse.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsf
 * JD-Core Version:    0.7.0.1
 */