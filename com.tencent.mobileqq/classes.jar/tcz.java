import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class tcz
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final int b;
  
  tcz(tcy paramtcy, View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Tcy.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tcy.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tcy.a) + tcy.a(this.jdField_a_of_type_Tcy));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tcy.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Tcy.a) + tcy.b(this.jdField_a_of_type_Tcy));
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tcy.a, this.jdField_a_of_type_Tcy.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tcy.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tcy.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tcy.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Tcy.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcz
 * JD-Core Version:    0.7.0.1
 */