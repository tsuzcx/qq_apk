import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class rws
  implements View.OnClickListener
{
  rws(rwr paramrwr, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Rwr.a.a(this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rws
 * JD-Core Version:    0.7.0.1
 */