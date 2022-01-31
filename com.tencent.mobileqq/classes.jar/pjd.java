import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import org.json.JSONException;

class pjd
  implements View.OnClickListener
{
  pjd(pja parampja) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = qiu.b(pja.a(this.a), 0);
    szp.a(false);
    paramView = new orz();
    paramView.h().b().e().a(pja.a(this.a).e()).f().g().d();
    if ((pja.a(this.a).e() != 0) || (localRefreshData != null)) {}
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
      nrt.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bjxj.a("default_feeds_proteus_offline_bid"), "", "", paramView.a(), false);
      if (pja.a(this.a) != null) {
        pja.a(this.a).c();
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pjd
 * JD-Core Version:    0.7.0.1
 */