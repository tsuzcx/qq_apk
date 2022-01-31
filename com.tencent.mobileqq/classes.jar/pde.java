import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import org.json.JSONException;

class pde
  implements View.OnClickListener
{
  pde(pdb parampdb) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = pzc.b(pdb.a(this.a), 0);
    shx.a(false);
    paramView = new onr();
    paramView.h().b().e().a(pdb.a(this.a).e()).f().g().d();
    if ((pdb.a(this.a).e() != 0) || (localRefreshData != null)) {}
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
      noo.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bhvh.a("default_feeds_proteus_offline_bid"), "", "", paramView.a(), false);
      if (pdb.a(this.a) != null) {
        pdb.a(this.a).c();
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pde
 * JD-Core Version:    0.7.0.1
 */