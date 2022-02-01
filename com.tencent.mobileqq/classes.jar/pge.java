import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pge
  implements View.OnClickListener
{
  pge(pgd parampgd, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    pgd.a(this.jdField_a_of_type_Pgd).a(this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pge
 * JD-Core Version:    0.7.0.1
 */