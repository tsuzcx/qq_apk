package cooperation.vip.ad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class TianshuBigInsertPage$3
  implements View.OnClickListener
{
  TianshuBigInsertPage$3(TianshuBigInsertPage paramTianshuBigInsertPage, String paramString) {}
  
  public void onClick(View paramView)
  {
    TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage);
    if ((TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage) != null) && (TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage).a() != null) && (((BaseActivity)TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage).a()).app != null) && (TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage) != null))
    {
      TianshuAdUtils.a(((BaseActivity)TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage).a()).app, TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage).a(), this.jdField_a_of_type_JavaLangString, 4005);
      TianshuAdUtils.a(((BaseActivity)TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage).a()).app, 102, String.valueOf(TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage).iAdId.get()), TianshuBigInsertPage.a(this.jdField_a_of_type_CooperationVipAdTianshuBigInsertPage).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.3
 * JD-Core Version:    0.7.0.1
 */