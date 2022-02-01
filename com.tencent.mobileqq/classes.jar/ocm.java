import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ocm
  implements View.OnClickListener
{
  ocm(obm paramobm, oji paramoji) {}
  
  public void onClick(View paramView)
  {
    obm.a(this.jdField_a_of_type_Obm);
    obm.a(this.jdField_a_of_type_Obm, this.jdField_a_of_type_Oji.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocm
 * JD-Core Version:    0.7.0.1
 */