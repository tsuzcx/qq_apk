import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;

class rwz
  implements rvw
{
  rwz(rwy paramrwy, FrameLayout paramFrameLayout) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (rwy.a(this.jdField_a_of_type_Rwy) != null) {
      rwy.a(this.jdField_a_of_type_Rwy).a(paramInt);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 5)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("float_layer_finsh_action");
      rwy.a(this.jdField_a_of_type_Rwy).getActivity().sendBroadcast(localIntent);
    }
    rwy.a(this.jdField_a_of_type_Rwy).getActivity().doOnBackPressed();
    rwy.a(this.jdField_a_of_type_Rwy).getActivity().overridePendingTransition(0, 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt == 2) && (rwy.a(this.jdField_a_of_type_Rwy).b()) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwz
 * JD-Core Version:    0.7.0.1
 */