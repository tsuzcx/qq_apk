import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

class qap
  implements View.OnClickListener
{
  qap(qam paramqam) {}
  
  public void onClick(View paramView)
  {
    RefreshData localRefreshData = rcx.b(qam.a(this.a), 0);
    ube.a(false);
    phi localphi = new phi();
    localphi.h().b().e().a(qam.a(this.a).e()).f().g().d();
    if ((qam.a(this.a).e() != 0) || (localRefreshData != null)) {}
    for (;;)
    {
      try
      {
        if (!localRefreshData.isAD) {
          continue;
        }
        i = 1;
        localphi.a("ad_page", i);
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      oat.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bmqa.a("default_feeds_proteus_offline_bid"), "", "", localphi.a(), false);
      if (qam.a(this.a) != null) {
        qam.a(this.a).c();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qap
 * JD-Core Version:    0.7.0.1
 */