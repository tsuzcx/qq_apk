import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class prv
  implements View.OnClickListener
{
  prv(String paramString, sxe paramsxe) {}
  
  public void onClick(View paramView)
  {
    olh.a(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.jdField_a_of_type_JavaLangString, false);
    qdc.b(this.jdField_a_of_type_Sxe.g);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prv
 * JD-Core Version:    0.7.0.1
 */