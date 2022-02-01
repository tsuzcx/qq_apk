import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class syg
  implements View.OnClickListener
{
  syg(syf paramsyf, orj paramorj) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Orj.j();
    this.jdField_a_of_type_Syf.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syg
 * JD-Core Version:    0.7.0.1
 */