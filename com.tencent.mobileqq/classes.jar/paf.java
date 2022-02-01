import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class paf
  implements View.OnClickListener
{
  paf(pae parampae, pah parampah, pvw parampvw, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Pae.a = new tbm((Activity)pae.a(this.jdField_a_of_type_Pae), new pag(this), this.jdField_a_of_type_Pvw.b, this.jdField_a_of_type_Pvw.a);
    this.jdField_a_of_type_Pae.a.b(this.jdField_a_of_type_Pah.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     paf
 * JD-Core Version:    0.7.0.1
 */