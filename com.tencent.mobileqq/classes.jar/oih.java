import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oih
  implements View.OnClickListener
{
  oih(oif paramoif, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((oif.a(this.jdField_a_of_type_Oif) != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      pay.a(oif.a(this.jdField_a_of_type_Oif).getContext(), this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oih
 * JD-Core Version:    0.7.0.1
 */