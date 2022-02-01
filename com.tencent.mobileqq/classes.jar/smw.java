import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class smw
  implements View.OnClickListener
{
  public smw(KandianProgressView paramKandianProgressView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Smx == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365319: 
      case 2131365335: 
        this.a.jdField_a_of_type_Smx.a(this.a.jdField_a_of_type_AndroidOsBundle);
        break;
      case 2131376462: 
      case 2131376470: 
        this.a.jdField_a_of_type_Smx.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smw
 * JD-Core Version:    0.7.0.1
 */