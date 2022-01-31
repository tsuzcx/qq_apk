import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pee
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    pen.a(paramBaseArticleInfo, localJSONObject, true);
    pen.a(paramBaseArticleInfo, localJSONObject);
    pen.b(paramBaseArticleInfo, localJSONObject);
    pen.e(paramBaseArticleInfo, localJSONObject);
    pen.m(paramBaseArticleInfo, localJSONObject);
    pen.g(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    pen.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pee
 * JD-Core Version:    0.7.0.1
 */