import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sov
  implements View.OnClickListener
{
  sov(snh paramsnh, String paramString, puh parampuh) {}
  
  public void onClick(View paramView)
  {
    oat.a(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    puf.b(this.jdField_a_of_type_Puh.f);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sov
 * JD-Core Version:    0.7.0.1
 */