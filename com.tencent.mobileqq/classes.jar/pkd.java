import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class pkd
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    pkm.a(paramBaseArticleInfo, localJSONObject, true);
    pkm.a(paramBaseArticleInfo, localJSONObject);
    pkm.b(paramBaseArticleInfo, localJSONObject);
    pkm.e(paramBaseArticleInfo, localJSONObject);
    pkm.l(paramBaseArticleInfo, localJSONObject);
    pkm.g(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    pkm.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkd
 * JD-Core Version:    0.7.0.1
 */