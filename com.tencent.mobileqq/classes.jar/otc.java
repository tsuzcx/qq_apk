import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class otc
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    otl.a(paramBaseArticleInfo, localJSONObject, true);
    otl.a(paramBaseArticleInfo, localJSONObject);
    otl.b(paramBaseArticleInfo, localJSONObject);
    otl.e(paramBaseArticleInfo, localJSONObject);
    otl.m(paramBaseArticleInfo, localJSONObject);
    otl.g(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    otl.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otc
 * JD-Core Version:    0.7.0.1
 */