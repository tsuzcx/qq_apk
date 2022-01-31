import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class rfp
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  rfp(rfo paramrfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rfo.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a) + rfo.a(this.jdField_a_of_type_Rfo));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rfo.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rfo.a) + rfo.b(this.jdField_a_of_type_Rfo));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a, this.jdField_a_of_type_Rfo.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rfo.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rfp
 * JD-Core Version:    0.7.0.1
 */