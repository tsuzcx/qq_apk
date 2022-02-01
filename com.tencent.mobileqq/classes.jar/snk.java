import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class snk
  implements View.OnClickListener
{
  snk(snh paramsnh, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    pha.d(this.jdField_a_of_type_Snh.a, this.jdField_a_of_type_JavaLangString);
    puf.b(this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snk
 * JD-Core Version:    0.7.0.1
 */