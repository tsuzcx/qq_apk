import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pui
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    puo.a(paramBaseArticleInfo, localJSONObject, true);
    puo.a(paramBaseArticleInfo, localJSONObject);
    puo.b(paramBaseArticleInfo, localJSONObject);
    puo.e(paramBaseArticleInfo, localJSONObject);
    puo.l(paramBaseArticleInfo, localJSONObject);
    puo.g(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    puo.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pui
 * JD-Core Version:    0.7.0.1
 */