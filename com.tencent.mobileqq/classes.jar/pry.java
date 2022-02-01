import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class pry
  implements View.OnClickListener
{
  pry(Context paramContext, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    pqx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    qdc.b(this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pry
 * JD-Core Version:    0.7.0.1
 */