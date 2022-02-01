import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qne
  implements View.OnClickListener
{
  qne(qmx paramqmx, szd paramszd, qfw paramqfw) {}
  
  public void onClick(View paramView)
  {
    pnw localpnw = this.jdField_a_of_type_Szd.a().a();
    if (localpnw != null) {
      localpnw.a(null, this.jdField_a_of_type_Qfw.a(), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qne
 * JD-Core Version:    0.7.0.1
 */