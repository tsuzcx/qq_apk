import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qex
  implements View.OnClickListener
{
  qex(qet paramqet, pxk parampxk, snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Pxk.a();
    spb localspb = this.jdField_a_of_type_Snh.a();
    if (localspb != null) {
      localspb.a(paramView, this.jdField_a_of_type_Pxk.a(), 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qex
 * JD-Core Version:    0.7.0.1
 */