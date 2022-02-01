import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class pxi
  implements View.OnClickListener
{
  pxi(pxg parampxg, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, GuideData paramGuideData) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (rmu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    if (((rmu)localObject).a() == 1)
    {
      ((rmu)localObject).a(false);
      localObject = ((rmu)localObject).a(pxg.a(this.jdField_a_of_type_Pxg), 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        bhhr.f(pxg.a(this.jdField_a_of_type_Pxg), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    pxg.a(this.jdField_a_of_type_Pxg).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pxg.a(this.jdField_a_of_type_Pxg));
    pxg.a(this.jdField_a_of_type_Pxg, null);
    bhhr.s(pxg.a(this.jdField_a_of_type_Pxg), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("RIJSkinOperationPopupStep", 2, "set skin: id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxi
 * JD-Core Version:    0.7.0.1
 */