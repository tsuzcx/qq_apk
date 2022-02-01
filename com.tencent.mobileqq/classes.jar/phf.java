import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class phf
  implements View.OnClickListener
{
  phf(String paramString, sjy paramsjy) {}
  
  public void onClick(View paramView)
  {
    odq.a(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    psf.b(this.jdField_a_of_type_Sjy.g);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phf
 * JD-Core Version:    0.7.0.1
 */