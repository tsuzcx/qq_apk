import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ngw
  implements View.OnClickListener
{
  ngw(ngv paramngv, mzl parammzl) {}
  
  public void onClick(View paramView)
  {
    ngq.a(this.jdField_a_of_type_Ngv.a, this.jdField_a_of_type_Mzl.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngw
 * JD-Core Version:    0.7.0.1
 */