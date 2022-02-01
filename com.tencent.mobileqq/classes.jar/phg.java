import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class phg
  implements View.OnClickListener
{
  phg(String paramString, sjv paramsjv) {}
  
  public void onClick(View paramView)
  {
    odq.a(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    psf.b(this.jdField_a_of_type_Sjv.g);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phg
 * JD-Core Version:    0.7.0.1
 */