import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class peb
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    pek.a(paramBaseArticleInfo, localJSONObject, true);
    pek.a(paramBaseArticleInfo, localJSONObject);
    pek.b(paramBaseArticleInfo, localJSONObject);
    pek.e(paramBaseArticleInfo, localJSONObject);
    pek.m(paramBaseArticleInfo, localJSONObject);
    pek.g(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    pek.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peb
 * JD-Core Version:    0.7.0.1
 */