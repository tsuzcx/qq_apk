import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class pta
  implements View.OnClickListener
{
  pta(psx parampsx) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = qtq.b(psx.a(this.a), 0);
    ubg.a(false);
    paa localpaa = new paa();
    localpaa.h().b().e().a(psx.a(this.a).e()).f().g().d();
    if ((psx.a(this.a).e() != 0) || (localRefreshData != null)) {}
    for (;;)
    {
      try
      {
        if (!localRefreshData.isAD) {
          continue;
        }
        i = 1;
        localpaa.a("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      ocd.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bnrf.a("default_feeds_proteus_offline_bid"), "", "", localpaa.a(), false);
      if (psx.a(this.a) != null) {
        psx.a(this.a).c();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pta
 * JD-Core Version:    0.7.0.1
 */