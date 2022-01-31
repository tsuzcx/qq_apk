import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import org.json.JSONException;

public class pmi
  implements View.OnClickListener
{
  public pmi(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    rvf.a(false);
    paramView = new ocg();
    paramView.h().b().e().a(this.a.a.jdField_a_of_type_Opw.e()).f().g().d();
    if (this.a.a.jdField_a_of_type_Opw.e() == 0) {}
    for (;;)
    {
      try
      {
        RefreshData localRefreshData = pnh.b(this.a.getContext(), 0);
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
      ndn.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, bgmq.a("default_feeds_proteus_offline_bid"), "", "", paramView.a(), false);
      if (this.a.a.jdField_a_of_type_Pfh != null) {
        this.a.a.jdField_a_of_type_Pfh.a(this.a, null);
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pmi
 * JD-Core Version:    0.7.0.1
 */