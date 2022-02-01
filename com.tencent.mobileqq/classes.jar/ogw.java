import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ogw
  implements View.OnClickListener
{
  ogw(ogv paramogv, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ogv.jdField_a_of_type_Ogn != null) {
      this.jdField_a_of_type_Ogv.jdField_a_of_type_Ogn.b(this.jdField_a_of_type_Ogv.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogw
 * JD-Core Version:    0.7.0.1
 */