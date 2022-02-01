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

class poa
  implements View.OnClickListener
{
  poa(pny parampny, QQAppInterface paramQQAppInterface, GuideData paramGuideData, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (rcx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
    if (((rcx)localObject).a() == 1)
    {
      ((rcx)localObject).a(false);
      localObject = ((rcx)localObject).a(pny.a(this.jdField_a_of_type_Pny), 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        bgsg.f(pny.a(this.jdField_a_of_type_Pny), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    ((rdd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id, false);
    pny.a(this.jdField_a_of_type_Pny).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pny.a(this.jdField_a_of_type_Pny));
    pny.a(this.jdField_a_of_type_Pny, null);
    bgsg.s(pny.a(this.jdField_a_of_type_Pny), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("RIJSkinOperationPopupStep", 2, "set skin: id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     poa
 * JD-Core Version:    0.7.0.1
 */