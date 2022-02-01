import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sfy
  implements View.OnClickListener
{
  sfy(sel paramsel, String paramString, pmv parampmv) {}
  
  public void onClick(View paramView)
  {
    ocd.a(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    pms.b(this.jdField_a_of_type_Pmv.f);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfy
 * JD-Core Version:    0.7.0.1
 */