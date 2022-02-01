import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class odz
  implements View.OnClickListener
{
  odz(ody paramody, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ody.jdField_a_of_type_Odq != null) {
      this.jdField_a_of_type_Ody.jdField_a_of_type_Odq.b(this.jdField_a_of_type_Ody.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odz
 * JD-Core Version:    0.7.0.1
 */