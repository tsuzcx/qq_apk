import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class qyc
  implements View.OnClickListener
{
  public qyc(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    ube.a(false);
    phi localphi = new phi();
    localphi.h().b().e().a(this.a.a.jdField_a_of_type_Pxk.e()).f().g().d();
    if (this.a.a.jdField_a_of_type_Pxk.e() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = rcx.b(this.a.getContext(), 0);
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
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
      if (this.a.a.jdField_a_of_type_Qrb != null) {
        this.a.a.jdField_a_of_type_Qrb.a(this.a, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyc
 * JD-Core Version:    0.7.0.1
 */