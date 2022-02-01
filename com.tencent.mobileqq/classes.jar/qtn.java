import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qtn
  implements View.OnClickListener
{
  qtn(qtm paramqtm) {}
  
  public void onClick(View paramView)
  {
    pet localpet = this.a.jdField_a_of_type_Slt.a().a();
    if (localpet != null) {
      localpet.a(paramView, ((pvc)this.a.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtn
 * JD-Core Version:    0.7.0.1
 */