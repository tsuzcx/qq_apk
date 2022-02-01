import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qdc
  implements View.OnClickListener
{
  qdc(qcy paramqcy, pvc parampvc, slt paramslt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Pvc.a();
    pet localpet = this.jdField_a_of_type_Slt.a().a();
    if (localpet != null) {
      localpet.a(paramView, this.jdField_a_of_type_Pvc.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdc
 * JD-Core Version:    0.7.0.1
 */