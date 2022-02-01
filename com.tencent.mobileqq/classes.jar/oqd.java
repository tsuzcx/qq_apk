import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oqd
  implements View.OnClickListener
{
  oqd(oqb paramoqb, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((oqb.a(this.jdField_a_of_type_Oqb) != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      pkh.a(oqb.a(this.jdField_a_of_type_Oqb).getContext(), this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqd
 * JD-Core Version:    0.7.0.1
 */