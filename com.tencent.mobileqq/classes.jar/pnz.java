import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pnz
  implements View.OnClickListener
{
  pnz(pny parampny, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    pny.a(this.jdField_a_of_type_Pny).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pny.a(this.jdField_a_of_type_Pny));
    pny.a(this.jdField_a_of_type_Pny, null);
    if (261 == this.jdField_a_of_type_Int) {
      bgsg.s(pny.a(this.jdField_a_of_type_Pny), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnz
 * JD-Core Version:    0.7.0.1
 */