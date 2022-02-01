import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qba
  implements View.OnClickListener
{
  qba(qat paramqat, slt paramslt, pvc parampvc) {}
  
  public void onClick(View paramView)
  {
    pet localpet = this.jdField_a_of_type_Slt.a().a();
    if (localpet != null) {
      localpet.a(null, this.jdField_a_of_type_Pvc.a(), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qba
 * JD-Core Version:    0.7.0.1
 */