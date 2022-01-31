import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import org.json.JSONException;
import org.json.JSONObject;

public class oag
{
  public static JSONObject a(JSONObject paramJSONObject, AdData paramAdData)
  {
    try
    {
      if (paramAdData.a == null) {
        return paramJSONObject;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_video_game_cell");
      if (!TextUtils.isEmpty(paramAdData.J)) {
        paramJSONObject.put("id_game_small_img", new JSONObject());
      }
      if (!TextUtils.isEmpty(paramAdData.q))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("text", paramAdData.q);
        paramJSONObject.put("id_tv_author", localJSONObject);
      }
      if (!TextUtils.isEmpty(paramAdData.k))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("text", paramAdData.k);
        paramJSONObject.put("id_tv_title", localJSONObject);
      }
      paramJSONObject.put("id_ad_banner_bottom_video", new JSONObject());
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramAdData.L))
      {
        localJSONObject.put("text", paramAdData.L);
        paramJSONObject.put("id_ad_dislike_button", localJSONObject);
      }
      paramJSONObject.put("id_game_operate_area", new JSONObject());
      paramJSONObject.put("id_separator", new JSONObject());
      paramJSONObject.put("id_ad_title", new JSONObject());
      paramJSONObject.put("id_ad_title_rl", new JSONObject());
      localJSONObject = new JSONObject();
      localJSONObject.put("innerGameModel", paramAdData);
      paramJSONObject.put("id_view_AdDownloadView", localJSONObject);
      return paramJSONObject;
    }
    catch (JSONException paramAdData)
    {
      paramAdData.printStackTrace();
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oag
 * JD-Core Version:    0.7.0.1
 */