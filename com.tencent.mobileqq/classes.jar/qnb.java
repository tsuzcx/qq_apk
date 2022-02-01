import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qnb
  implements View.OnClickListener
{
  qnb(qmx paramqmx, szd paramszd, qfw paramqfw) {}
  
  public void onClick(View paramView)
  {
    pnw localpnw = this.jdField_a_of_type_Szd.a().a();
    if (localpnw != null) {
      localpnw.a(paramView, this.jdField_a_of_type_Qfw.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnb
 * JD-Core Version:    0.7.0.1
 */