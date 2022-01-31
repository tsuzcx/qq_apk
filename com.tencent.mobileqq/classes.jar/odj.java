import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class odj
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    try
    {
      if (paramAdData.a == null) {
        return paramJSONObject;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_game_cell");
      if (!TextUtils.isEmpty(paramAdData.J)) {
        paramJSONObject.put("id_game_small_img", new JSONObject());
      }
      if (!TextUtils.isEmpty(paramAdData.q))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.q);
        paramJSONObject.put("id_tv_author", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.k))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", paramAdData.k);
        paramJSONObject.put("id_tv_title", localObject);
      }
      if (!TextUtils.isEmpty(paramAdData.l))
      {
        localObject = swu.a(paramAdData.l, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_bottom_imge", localJSONObject);
      }
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.L))
      {
        ((JSONObject)localObject).put("text", paramAdData.L);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      paramJSONObject.put("id_game_operate_area", new JSONObject());
      paramJSONObject.put("id_separator", new JSONObject());
      paramJSONObject.put("id_ad_title", new JSONObject());
      paramJSONObject.put("id_ad_title_rl", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("innerGameModel", paramAdData);
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      return paramJSONObject;
    }
    catch (JSONException paramAdData)
    {
      paramAdData.printStackTrace();
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     odj
 * JD-Core Version:    0.7.0.1
 */