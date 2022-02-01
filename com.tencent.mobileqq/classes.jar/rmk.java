import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rmk
  implements View.OnClickListener
{
  rmk(rmj paramrmj, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Rmj.a.a(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmk
 * JD-Core Version:    0.7.0.1
 */