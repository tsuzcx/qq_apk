import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qta
  implements View.OnClickListener
{
  qta(qsz paramqsz) {}
  
  public void onClick(View paramView)
  {
    pet localpet = this.a.jdField_a_of_type_Slt.a().a();
    if (localpet != null) {
      localpet.a(null, ((pvc)this.a.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qta
 * JD-Core Version:    0.7.0.1
 */