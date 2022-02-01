import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class qqq
  implements View.OnClickListener
{
  public qqq(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    ubg.a(false);
    paa localpaa = new paa();
    localpaa.h().b().e().a(this.a.a.jdField_a_of_type_Ppu.e()).f().g().d();
    if (this.a.a.jdField_a_of_type_Ppu.e() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = qtq.b(this.a.getContext(), 0);
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
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
      if (this.a.a.jdField_a_of_type_Qjp != null) {
        this.a.a.jdField_a_of_type_Qjp.a(this.a, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqq
 * JD-Core Version:    0.7.0.1
 */