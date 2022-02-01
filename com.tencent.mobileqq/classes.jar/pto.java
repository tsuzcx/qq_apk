import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pto
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = localJSONObject2;
    if (paramBaseArticleInfo != null)
    {
      localJSONObject1 = localJSONObject2;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData)) {
        localJSONObject1 = new JSONObject(paramBaseArticleInfo.smallGameData);
      }
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pto
 * JD-Core Version:    0.7.0.1
 */