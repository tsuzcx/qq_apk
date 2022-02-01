import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nto
  implements View.OnClickListener
{
  nto(ntc paramntc, String paramString, oag paramoag) {}
  
  public void onClick(View paramView)
  {
    ntc.c(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_JavaLangString);
    ntc.a(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_Oag.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nto
 * JD-Core Version:    0.7.0.1
 */