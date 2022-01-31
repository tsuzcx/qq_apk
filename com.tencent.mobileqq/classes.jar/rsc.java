import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class rsc
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  rsc(rsb paramrsb, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rsb.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a) + rsb.a(this.jdField_a_of_type_Rsb));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rsb.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Rsb.a) + rsb.b(this.jdField_a_of_type_Rsb));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a, this.jdField_a_of_type_Rsb.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Rsb.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsc
 * JD-Core Version:    0.7.0.1
 */