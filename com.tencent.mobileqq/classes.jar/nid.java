import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nid
  implements View.OnClickListener
{
  nid(nic paramnic, nam paramnam) {}
  
  public void onClick(View paramView)
  {
    nhx.a(this.jdField_a_of_type_Nic.a, this.jdField_a_of_type_Nam.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nid
 * JD-Core Version:    0.7.0.1
 */