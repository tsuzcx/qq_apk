import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ofm
  implements View.OnClickListener
{
  ofm(ofk paramofk, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((ofk.a(this.jdField_a_of_type_Ofk) != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      pha.a(ofk.a(this.jdField_a_of_type_Ofk).getContext(), this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofm
 * JD-Core Version:    0.7.0.1
 */