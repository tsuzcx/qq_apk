import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pmk
  implements View.OnClickListener
{
  pmk(pmj parampmj, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    pmj.a(this.jdField_a_of_type_Pmj).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pmj.a(this.jdField_a_of_type_Pmj));
    pmj.a(this.jdField_a_of_type_Pmj, null);
    if (261 == this.jdField_a_of_type_Int) {
      bfyz.s(pmj.a(this.jdField_a_of_type_Pmj), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmk
 * JD-Core Version:    0.7.0.1
 */