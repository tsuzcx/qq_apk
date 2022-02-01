import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sdo
  implements View.OnClickListener
{
  sdo(sdn paramsdn, ohz paramohz) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ohz.j();
    this.jdField_a_of_type_Sdn.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdo
 * JD-Core Version:    0.7.0.1
 */