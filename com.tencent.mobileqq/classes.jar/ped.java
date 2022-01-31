import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import org.json.JSONObject;

public class ped
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    if ((paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() != 0))
    {
      localObject1 = (qds)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0);
      localObject2 = BaseApplicationImpl.getApplication().getResources();
      str = ((qds)localObject1).d;
    }
    for (Object localObject1 = String.format(((Resources)localObject2).getString(2131718591), new Object[] { bhvy.a(((qds)localObject1).b) });; localObject1 = null)
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("participant_title_text", localObject1);
      localJSONObject.put("id_participant_title", localObject2);
      pek.a(paramBaseArticleInfo, localJSONObject, false);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("participant_pic_url", str);
      localJSONObject.put("id_participant_imge", localObject1);
      localJSONObject.put("id_view_cover", new JSONObject());
      pek.b(paramBaseArticleInfo, localJSONObject);
      pek.m(paramBaseArticleInfo, localJSONObject);
      localJSONObject.put("style_ID", "ReadInjoy_single_topic_cell");
      pek.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ped
 * JD-Core Version:    0.7.0.1
 */