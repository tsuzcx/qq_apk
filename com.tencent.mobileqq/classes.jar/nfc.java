import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nfc
  implements View.OnClickListener
{
  nfc(nfb paramnfb, myi parammyi) {}
  
  public void onClick(View paramView)
  {
    new.a(this.jdField_a_of_type_Nfb.a, this.jdField_a_of_type_Myi.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfc
 * JD-Core Version:    0.7.0.1
 */