import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pgx
  implements View.OnClickListener
{
  pgx(pgw parampgw, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    pgw.a(this.jdField_a_of_type_Pgw).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pgw.a(this.jdField_a_of_type_Pgw));
    pgw.a(this.jdField_a_of_type_Pgw, null);
    if (261 == this.jdField_a_of_type_Int) {
      bhsi.s(pgw.a(this.jdField_a_of_type_Pgw), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgx
 * JD-Core Version:    0.7.0.1
 */