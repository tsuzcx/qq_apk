import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nse
  implements View.OnClickListener
{
  nse(nre paramnre, nyl paramnyl) {}
  
  public void onClick(View paramView)
  {
    nre.a(this.jdField_a_of_type_Nre);
    nre.a(this.jdField_a_of_type_Nre, this.jdField_a_of_type_Nyl.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nse
 * JD-Core Version:    0.7.0.1
 */