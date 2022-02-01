import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class pyu
  implements View.OnClickListener
{
  pyu(pyr parampyr) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = rao.b(pyr.a(this.a), 0);
    uhv.a(false);
    pbg localpbg = new pbg();
    localpbg.h().b().e().a(pyr.a(this.a).e()).f().g().d();
    if ((pyr.a(this.a).e() != 0) || (localRefreshData != null)) {}
    for (;;)
    {
      try
      {
        if (!localRefreshData.isAD) {
          continue;
        }
        i = 1;
        localpbg.a("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      odq.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bkwm.a("default_feeds_proteus_offline_bid"), "", "", localpbg.a(), false);
      if (pyr.a(this.a) != null) {
        pyr.a(this.a).c();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyu
 * JD-Core Version:    0.7.0.1
 */