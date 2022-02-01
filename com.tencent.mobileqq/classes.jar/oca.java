import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oca
  implements View.OnClickListener
{
  oca(obm paramobm, String paramString, oji paramoji) {}
  
  public void onClick(View paramView)
  {
    obm.b(this.jdField_a_of_type_Obm, this.jdField_a_of_type_JavaLangString);
    obm.a(this.jdField_a_of_type_Obm, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oca
 * JD-Core Version:    0.7.0.1
 */