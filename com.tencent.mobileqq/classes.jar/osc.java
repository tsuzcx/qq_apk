import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import org.json.JSONException;

class osc
  implements View.OnClickListener
{
  osc(orz paramorz) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = pnh.b(orz.a(this.a), 0);
    rvf.a(false);
    paramView = new ocg();
    paramView.h().b().e().a(orz.a(this.a).e()).f().g().d();
    if ((orz.a(this.a).e() != 0) || (localRefreshData != null)) {}
    for (;;)
    {
      try
      {
        if (!localRefreshData.isAD) {
          continue;
        }
        i = 1;
        paramView.a("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      ndn.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bgmq.a("default_feeds_proteus_offline_bid"), "", "", paramView.a(), false);
      if (orz.a(this.a) != null) {
        orz.a(this.a).c();
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osc
 * JD-Core Version:    0.7.0.1
 */