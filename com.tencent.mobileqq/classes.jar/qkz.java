import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class qkz
  implements View.OnClickListener
{
  qkz(qkw paramqkw) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = rmu.b(qkw.a(this.a), 0);
    uvs.a(false);
    pqg localpqg = new pqg();
    localpqg.h().b().e().a(qkw.a(this.a).e()).f().g().d();
    if ((qkw.a(this.a).e() != 0) || (localRefreshData != null)) {}
    for (;;)
    {
      try
      {
        if (!localRefreshData.isAD) {
          continue;
        }
        i = 1;
        localpqg.a("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      olh.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bmhv.a("default_feeds_proteus_offline_bid"), "", "", localpqg.a(), false);
      if (qkw.a(this.a) != null) {
        qkw.a(this.a).c();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkz
 * JD-Core Version:    0.7.0.1
 */