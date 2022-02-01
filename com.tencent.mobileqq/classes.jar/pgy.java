import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class pgy
  implements View.OnClickListener
{
  pgy(pgw parampgw, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, GuideData paramGuideData) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (qtq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
    if (((qtq)localObject).a() == 1)
    {
      ((qtq)localObject).a(false);
      localObject = ((qtq)localObject).a(pgw.a(this.jdField_a_of_type_Pgw), 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        bhsi.f(pgw.a(this.jdField_a_of_type_Pgw), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    pgw.a(this.jdField_a_of_type_Pgw).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pgw.a(this.jdField_a_of_type_Pgw));
    pgw.a(this.jdField_a_of_type_Pgw, null);
    bhsi.s(pgw.a(this.jdField_a_of_type_Pgw), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("RIJSkinOperationPopupStep", 2, "set skin: id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgy
 * JD-Core Version:    0.7.0.1
 */