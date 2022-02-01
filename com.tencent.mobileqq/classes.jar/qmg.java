import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qmg
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    qmm.a(paramBaseArticleInfo, localJSONObject, true);
    qmm.a(paramBaseArticleInfo, localJSONObject);
    qmm.d(paramBaseArticleInfo, localJSONObject);
    qmm.g(paramBaseArticleInfo, localJSONObject);
    qmm.n(paramBaseArticleInfo, localJSONObject);
    qmm.i(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    qmm.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmg
 * JD-Core Version:    0.7.0.1
 */