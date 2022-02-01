import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class tca
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  tca(tbz paramtbz, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Tbz.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a) + tbz.a(this.jdField_a_of_type_Tbz));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Tbz.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Tbz.a) + tbz.b(this.jdField_a_of_type_Tbz));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a, this.jdField_a_of_type_Tbz.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Tbz.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tca
 * JD-Core Version:    0.7.0.1
 */