import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sli
  implements View.OnClickListener
{
  public sli(KandianProgressView paramKandianProgressView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Slj == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365396: 
      case 2131365411: 
        this.a.jdField_a_of_type_Slj.a(this.a.jdField_a_of_type_AndroidOsBundle);
        break;
      case 2131376360: 
      case 2131376368: 
        this.a.jdField_a_of_type_Slj.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sli
 * JD-Core Version:    0.7.0.1
 */