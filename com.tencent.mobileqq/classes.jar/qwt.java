import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class qwt
  implements View.OnClickListener
{
  public qwt(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    uhv.a(false);
    pbg localpbg = new pbg();
    localpbg.h().b().e().a(this.a.a.jdField_a_of_type_Pvc.e()).f().g().d();
    if (this.a.a.jdField_a_of_type_Pvc.e() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = rao.b(this.a.getContext(), 0);
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
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
      if (this.a.a.jdField_a_of_type_Qps != null) {
        this.a.a.jdField_a_of_type_Qps.a(this.a, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwt
 * JD-Core Version:    0.7.0.1
 */