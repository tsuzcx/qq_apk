import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ofj
  implements View.OnClickListener
{
  ofj(ofi paramofi, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ofi.jdField_a_of_type_Ofa != null) {
      this.jdField_a_of_type_Ofi.jdField_a_of_type_Ofa.b(this.jdField_a_of_type_Ofi.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofj
 * JD-Core Version:    0.7.0.1
 */