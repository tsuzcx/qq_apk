import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import org.json.JSONObject;

public class pkf
{
  public static JSONObject a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    if ((paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() != 0))
    {
      localObject1 = (qno)paramBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0);
      localObject2 = BaseApplicationImpl.getApplication().getResources();
      str = ((qno)localObject1).d;
    }
    for (Object localObject1 = String.format(((Resources)localObject2).getString(2131719051), new Object[] { bjxj.a(((qno)localObject1).b) });; localObject1 = null)
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("participant_title_text", localObject1);
      localJSONObject.put("id_participant_title", localObject2);
      pkm.a(paramBaseArticleInfo, localJSONObject, false);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("participant_pic_url", str);
      localJSONObject.put("id_participant_imge", localObject1);
      localJSONObject.put("id_view_cover", new JSONObject());
      pkm.b(paramBaseArticleInfo, localJSONObject);
      pkm.l(paramBaseArticleInfo, localJSONObject);
      localJSONObject.put("style_ID", "ReadInjoy_single_topic_cell");
      pkm.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkf
 * JD-Core Version:    0.7.0.1
 */