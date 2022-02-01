import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ogu
  implements View.OnClickListener
{
  ogu(ogs paramogs, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((ogs.a(this.jdField_a_of_type_Ogs) != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      ozs.a(ogs.a(this.jdField_a_of_type_Ogs).getContext(), this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogu
 * JD-Core Version:    0.7.0.1
 */