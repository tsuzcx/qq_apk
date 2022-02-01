import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ppn
  implements pnq
{
  ppn(ppk paramppk) {}
  
  public void onClick(View paramView)
  {
    ppk.a(this.a).a().a().a(ppk.a(this.a).a().a());
    ppk.a(this.a).a().a().a(ppk.a(this.a).a().a());
    sxl localsxl = (sxl)paramView.getTag();
    if (localsxl == null) {}
    for (;;)
    {
      return;
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)ppk.a(this.a).a().get(localsxl.a);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("time", System.currentTimeMillis() / 1000L);
        localJSONObject.put("channel_id", ppk.a(this.a).a().b());
        if ((ppk.a(this.a).a().a() instanceof BaseActivity))
        {
          localJSONObject.put("folder_status", prp.a);
          localJSONObject.put("kandian_mode", pqu.a());
          localJSONObject.put("feeds_type", "" + pqw.a(localBaseArticleInfo));
          localJSONObject.put("rowkey", uvs.a(localBaseArticleInfo));
          olh.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
        }
        while (localBaseArticleInfo != null)
        {
          ppk.a(this.a).a().a().a(paramView, localsxl, localBaseArticleInfo, ppk.a(this.a));
          if ((ppk.a(this.a).a().a() != null) && (ppk.a(this.a).a().a().b()))
          {
            ppk.a(this.a).a().a().a();
            ppk.a(this.a).a().f(true);
          }
          qdc.a(paramView);
          return;
          if ((ppk.a(this.a).a().a() instanceof PluginBaseActivity))
          {
            localJSONObject.put("folder_status", 1);
            bdla.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppn
 * JD-Core Version:    0.7.0.1
 */