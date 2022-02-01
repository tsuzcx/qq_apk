import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pjo
  implements View.OnClickListener
{
  pjo(pjn parampjn, pjq parampjq, qhc paramqhc, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Pjn.a = new tox((Activity)pjn.a(this.jdField_a_of_type_Pjn), new pjp(this), this.jdField_a_of_type_Qhc.b, this.jdField_a_of_type_Qhc.a);
    this.jdField_a_of_type_Pjn.a.b(this.jdField_a_of_type_Pjq.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjo
 * JD-Core Version:    0.7.0.1
 */