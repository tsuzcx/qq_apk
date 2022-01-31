import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import org.json.JSONException;

class pdb
  implements View.OnClickListener
{
  pdb(pcy parampcy) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = pyz.b(pcy.a(this.a), 0);
    shu.a(false);
    paramView = new ono();
    paramView.h().b().e().a(pcy.a(this.a).e()).f().g().d();
    if ((pcy.a(this.a).e() != 0) || (localRefreshData != null)) {}
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
      nol.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bhvy.a("default_feeds_proteus_offline_bid"), "", "", paramView.a(), false);
      if (pcy.a(this.a) != null) {
        pcy.a(this.a).c();
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdb
 * JD-Core Version:    0.7.0.1
 */