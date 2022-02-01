import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class phj
  implements View.OnClickListener
{
  phj(Context paramContext, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    pay.d(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    psf.b(this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phj
 * JD-Core Version:    0.7.0.1
 */