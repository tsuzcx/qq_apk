import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class sxy
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  sxy(sxx paramsxx, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Sxx.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxx.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxx.a) + sxx.a(this.jdField_a_of_type_Sxx));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Sxx.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Sxx.a) + sxx.b(this.jdField_a_of_type_Sxx));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxx.a, this.jdField_a_of_type_Sxx.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxx.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxx.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxx.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sxx.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxy
 * JD-Core Version:    0.7.0.1
 */