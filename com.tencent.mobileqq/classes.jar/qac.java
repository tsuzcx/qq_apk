import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qac
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    qai.a(paramBaseArticleInfo, localJSONObject, true);
    qai.a(paramBaseArticleInfo, localJSONObject);
    qai.d(paramBaseArticleInfo, localJSONObject);
    qai.g(paramBaseArticleInfo, localJSONObject);
    qai.n(paramBaseArticleInfo, localJSONObject);
    qai.i(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    qai.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qac
 * JD-Core Version:    0.7.0.1
 */