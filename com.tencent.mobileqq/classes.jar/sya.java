import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class sya
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  sya(sxz paramsxz, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Sxz.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a) + sxz.a(this.jdField_a_of_type_Sxz));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Sxz.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Sxz.a) + sxz.b(this.jdField_a_of_type_Sxz));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a, this.jdField_a_of_type_Sxz.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxz.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sya
 * JD-Core Version:    0.7.0.1
 */