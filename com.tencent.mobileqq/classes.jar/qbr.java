import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class qbr
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = localJSONObject2;
    if (paramBaseArticleInfo != null)
    {
      localJSONObject1 = localJSONObject2;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData))
      {
        localJSONObject1 = new JSONObject(paramBaseArticleInfo.smallGameData);
        a(localJSONObject1, paramBaseArticleInfo);
      }
    }
    return localJSONObject1;
  }
  
  private static JSONObject a(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    for (;;)
    {
      int j;
      try
      {
        paramBaseArticleInfo = new JSONArray();
        int k = paramJSONObject.optInt("card_size");
        int i = 1;
        if (i <= k)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("style_ID", "ReadInjoy_ad_small_game_collection_cell");
          localJSONObject.put("game_icon", paramJSONObject.optString("game_icon" + i));
          localJSONObject.put("game_title", paramJSONObject.optString("game_title" + i));
          localJSONObject.put("game_type_label", paramJSONObject.optString("game_type_label" + i));
          localJSONObject.put("game_type_label_color", paramJSONObject.optString("game_type_label" + i + "_color"));
          localJSONObject.put("game_gray_label", paramJSONObject.optString(new StringBuilder().append("game_blue_label").append(i).toString()) + paramJSONObject.optString(new StringBuilder().append("game_gray_label").append(i).toString()));
          localJSONObject.put("game_button_label", paramJSONObject.optString("game_button_label" + i));
          j = 1;
          if (j <= 3)
          {
            String str = paramJSONObject.optString("avator_icon" + i + "_" + j);
            if (!TextUtils.isEmpty(str)) {
              localJSONObject.put("avator_icon_" + j, str);
            }
          }
          else
          {
            paramBaseArticleInfo.put(localJSONObject);
            paramJSONObject.put("datas", paramBaseArticleInfo);
            i += 1;
          }
        }
        else
        {
          return paramJSONObject;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInjoyAdHorizSmallGameCell", 2, "ex.error" + paramBaseArticleInfo.getMessage());
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbr
 * JD-Core Version:    0.7.0.1
 */