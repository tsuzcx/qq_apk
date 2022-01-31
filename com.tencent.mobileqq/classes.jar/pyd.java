import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import org.json.JSONException;

public class pyd
  implements View.OnClickListener
{
  public pyd(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    shx.a(false);
    paramView = new onr();
    paramView.h().b().e().a(this.a.a.jdField_a_of_type_Pax.e()).f().g().d();
    if (this.a.a.jdField_a_of_type_Pax.e() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = pzc.b(this.a.getContext(), 0);
        if ((localRefreshData == null) || (!localRefreshData.isAD)) {
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
      if (this.a.a.jdField_a_of_type_Prb != null) {
        this.a.a.jdField_a_of_type_Prb.a(this.a, null);
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyd
 * JD-Core Version:    0.7.0.1
 */