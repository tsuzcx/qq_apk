import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class qbx
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    qcd.a(paramBaseArticleInfo, localJSONObject, true);
    qcd.a(paramBaseArticleInfo, localJSONObject);
    qcd.b(paramBaseArticleInfo, localJSONObject);
    qcd.e(paramBaseArticleInfo, localJSONObject);
    qcd.l(paramBaseArticleInfo, localJSONObject);
    qcd.g(paramBaseArticleInfo, localJSONObject);
    localJSONObject.put("style_ID", "ReadInjoy_none_img_cell");
    qcd.a(localJSONObject, paramBaseArticleInfo);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbx
 * JD-Core Version:    0.7.0.1
 */