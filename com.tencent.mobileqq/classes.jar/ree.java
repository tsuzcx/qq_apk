import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ree
  implements View.OnClickListener
{
  ree(red paramred) {}
  
  public void onClick(View paramView)
  {
    pnw localpnw = this.a.jdField_a_of_type_Szd.a().a();
    if (localpnw != null) {
      localpnw.a(null, ((qfw)this.a.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ree
 * JD-Core Version:    0.7.0.1
 */