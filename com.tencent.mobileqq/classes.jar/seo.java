import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class seo
  implements View.OnClickListener
{
  seo(sel paramsel, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    ozs.d(this.jdField_a_of_type_Sel.a, this.jdField_a_of_type_JavaLangString);
    pms.b(this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     seo
 * JD-Core Version:    0.7.0.1
 */