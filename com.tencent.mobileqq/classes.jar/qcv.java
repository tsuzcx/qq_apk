import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qcv
  implements View.OnClickListener
{
  qcv(qco paramqco, snh paramsnh, pxk parampxk) {}
  
  public void onClick(View paramView)
  {
    spb localspb = this.jdField_a_of_type_Snh.a();
    if (localspb != null) {
      localspb.a(null, this.jdField_a_of_type_Pxk.a(), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcv
 * JD-Core Version:    0.7.0.1
 */