import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pte
  implements View.OnClickListener
{
  pte(psx parampsx, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    psx.a(2, this.jdField_a_of_type_JavaLangString);
    ozs.a(psx.a(this.jdField_a_of_type_Psx), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pte
 * JD-Core Version:    0.7.0.1
 */