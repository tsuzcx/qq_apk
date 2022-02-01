package cooperation.vip.ad;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;

class TianshuBigInsertPage$2
  implements View.OnClickListener
{
  TianshuBigInsertPage$2(TianshuBigInsertPage paramTianshuBigInsertPage) {}
  
  public void onClick(View paramView)
  {
    TianshuBigInsertPage.a(this.a);
    if ((TianshuBigInsertPage.a(this.a) != null) && (TianshuBigInsertPage.a(this.a).a() != null) && (((BaseActivity)TianshuBigInsertPage.a(this.a).a()).app != null) && (TianshuBigInsertPage.a(this.a) != null)) {
      TianshuAdUtils.a(((BaseActivity)TianshuBigInsertPage.a(this.a).a()).app, 122, String.valueOf(TianshuBigInsertPage.a(this.a).iAdId.get()), TianshuBigInsertPage.a(this.a).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.2
 * JD-Core Version:    0.7.0.1
 */