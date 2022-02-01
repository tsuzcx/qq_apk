import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sys
  implements View.OnClickListener
{
  public sys(KandianProgressView paramKandianProgressView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Syt == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365489: 
      case 2131365504: 
        this.a.jdField_a_of_type_Syt.a(this.a.jdField_a_of_type_AndroidOsBundle);
        break;
      case 2131376615: 
      case 2131376623: 
        this.a.jdField_a_of_type_Syt.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sys
 * JD-Core Version:    0.7.0.1
 */