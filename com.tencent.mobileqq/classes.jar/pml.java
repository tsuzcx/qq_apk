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

class pml
  implements View.OnClickListener
{
  pml(pmj parampmj, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, GuideData paramGuideData) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (rao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(270);
    if (((rao)localObject).a() == 1)
    {
      ((rao)localObject).a(false);
      localObject = ((rao)localObject).a(pmj.a(this.jdField_a_of_type_Pmj), 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        bfyz.f(pmj.a(this.jdField_a_of_type_Pmj), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    pmj.a(this.jdField_a_of_type_Pmj).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(pmj.a(this.jdField_a_of_type_Pmj));
    pmj.a(this.jdField_a_of_type_Pmj, null);
    bfyz.s(pmj.a(this.jdField_a_of_type_Pmj), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("RIJSkinOperationPopupStep", 2, "set skin: id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pml
 * JD-Core Version:    0.7.0.1
 */