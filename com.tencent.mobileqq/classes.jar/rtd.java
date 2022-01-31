import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

class rtd
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  rtd(rtc paramrtc, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Rtc.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a) + rtc.a(this.jdField_a_of_type_Rtc));
    ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rtc.a, ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_Rtc.a) + rtc.b(this.jdField_a_of_type_Rtc));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a).setVisibility(0);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a, this.jdField_a_of_type_Rtc.a.a(ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a)));
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a).setVisibility(4);
    }
    ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_Rtc.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtd
 * JD-Core Version:    0.7.0.1
 */