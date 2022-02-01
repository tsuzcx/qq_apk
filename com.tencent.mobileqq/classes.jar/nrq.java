import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nrq
  implements View.OnClickListener
{
  nrq(nre paramnre, String paramString, nyl paramnyl) {}
  
  public void onClick(View paramView)
  {
    nre.c(this.jdField_a_of_type_Nre, this.jdField_a_of_type_JavaLangString);
    nre.a(this.jdField_a_of_type_Nre, this.jdField_a_of_type_Nyl.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrq
 * JD-Core Version:    0.7.0.1
 */