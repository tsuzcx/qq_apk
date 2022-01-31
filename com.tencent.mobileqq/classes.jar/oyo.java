import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class oyo
  implements View.OnClickListener
{
  oyo(oym paramoym, QQAppInterface paramQQAppInterface, GuideData paramGuideData, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    paramView = (qiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
    if (paramView.a() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(oym.a(this.jdField_a_of_type_Oym), 0);
      if (paramView != null)
      {
        paramView.isShown = false;
        bdne.f(oym.a(this.jdField_a_of_type_Oym), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView.toJson().toString(), 0);
      }
    }
    ((qja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id, false);
    oym.a(this.jdField_a_of_type_Oym).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(oym.a(this.jdField_a_of_type_Oym));
    oym.a(this.jdField_a_of_type_Oym, null);
    bdne.s(oym.a(this.jdField_a_of_type_Oym), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("RIJSkinOperationPopupStep", 2, "set skin: id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oyo
 * JD-Core Version:    0.7.0.1
 */