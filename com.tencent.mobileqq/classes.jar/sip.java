import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class sip
  implements ViewTreeObserver.OnPreDrawListener
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  sip(sio paramsio, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean onPreDraw()
  {
    this.jdField_a_of_type_Sio.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a) + sio.a(this.jdField_a_of_type_Sio));
    ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Sio.a, ReadInJoyDynamicGridView.b(this.jdField_a_of_type_Sio.a) + sio.b(this.jdField_a_of_type_Sio));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a).setVisibility(0);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a, this.jdField_a_of_type_Sio.a.a(ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a)));
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a).setVisibility(4);
    }
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_Sio.a, this.jdField_a_of_type_Int, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sip
 * JD-Core Version:    0.7.0.1
 */