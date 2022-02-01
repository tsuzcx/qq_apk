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
    TianshuBigInsertPage.a(this.b);
    if ((TianshuBigInsertPage.b(this.b) != null) && (TianshuBigInsertPage.b(this.b).P() != null) && (((BaseActivity)TianshuBigInsertPage.b(this.b).P()).app != null) && (TianshuBigInsertPage.c(this.b) != null))
    {
      TianshuAdUtils.a(((BaseActivity)TianshuBigInsertPage.b(this.b).P()).app, TianshuBigInsertPage.b(this.b).P(), this.a, 4005);
      TianshuAdUtils.a(((BaseActivity)TianshuBigInsertPage.b(this.b).P()).app, 102, String.valueOf(TianshuBigInsertPage.c(this.b).iAdId.get()), TianshuBigInsertPage.c(this.b).traceinfo.get());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.3
 * JD-Core Version:    0.7.0.1
 */