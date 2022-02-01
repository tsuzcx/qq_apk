import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qrl
  implements View.OnClickListener
{
  qrl(qrf paramqrf) {}
  
  public void onClick(View paramView)
  {
    spb localspb = this.a.jdField_a_of_type_Snh.a();
    if (localspb != null) {
      localspb.a(null, ((pxk)this.a.jdField_a_of_type_JavaLangObject).a(), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrl
 * JD-Core Version:    0.7.0.1
 */