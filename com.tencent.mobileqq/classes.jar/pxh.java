import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pxh
  implements View.OnClickListener
{
  pxh(pxg parampxg, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    pxg.a(this.jdField_a_of_type_Pxg).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pxg.a(this.jdField_a_of_type_Pxg));
    pxg.a(this.jdField_a_of_type_Pxg, null);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == this.jdField_a_of_type_Int) {
      bhhr.s(pxg.a(this.jdField_a_of_type_Pxg), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxh
 * JD-Core Version:    0.7.0.1
 */