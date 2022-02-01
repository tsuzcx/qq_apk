import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class riy
  implements View.OnClickListener
{
  public riy(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    uvs.a(false);
    pqg localpqg = new pqg();
    localpqg.h().b().e().a(this.a.a.jdField_a_of_type_Qfw.e()).f().g().d();
    if (this.a.a.jdField_a_of_type_Qfw.e() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = rmu.b(this.a.getContext(), 0);
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
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
      if (this.a.a.jdField_a_of_type_Rbx != null) {
        this.a.a.jdField_a_of_type_Rbx.a(this.a, null);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     riy
 * JD-Core Version:    0.7.0.1
 */