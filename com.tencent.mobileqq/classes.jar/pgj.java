import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class pgj
  implements pen
{
  pgj(pgg parampgg) {}
  
  public void onClick(View paramView)
  {
    pgg.a(this.a).a().a().a(pgg.a(this.a).a().a());
    pgg.a(this.a).a().a().a(pgg.a(this.a).a().a());
    skb localskb = (skb)paramView.getTag();
    if (localskb == null) {}
    for (;;)
    {
      return;
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)pgg.a(this.a).a().get(localskb.a);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("time", System.currentTimeMillis() / 1000L);
        localJSONObject.put("channel_id", pgg.a(this.a).a().b());
        if ((pgg.a(this.a).a().a() instanceof BaseActivity))
        {
          localJSONObject.put("folder_status", pay.d);
          localJSONObject.put("kandian_mode", pay.e());
          localJSONObject.put("feeds_type", "" + pay.a(localBaseArticleInfo));
          localJSONObject.put("rowkey", uhv.a(localBaseArticleInfo));
          odq.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
        }
        while (localBaseArticleInfo != null)
        {
          pgg.a(this.a).a().a().a(paramView, localskb, localBaseArticleInfo, pgg.a(this.a));
          if ((pgg.a(this.a).a().a() != null) && (pgg.a(this.a).a().a().b()))
          {
            pgg.a(this.a).a().a().a();
            pgg.a(this.a).a().f(true);
          }
          psf.a(paramView);
          return;
          if ((pgg.a(this.a).a().a() instanceof PluginBaseActivity))
          {
            localJSONObject.put("folder_status", 1);
            bcef.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
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
 * Qualified Name:     pgj
 * JD-Core Version:    0.7.0.1
 */