import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class ozt
  implements skg
{
  public ozt(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = opn.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      opp localopp = new opp(paramBaseArticleInfo);
      localopp.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localopp.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localopp.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localopp.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localopp.b = "0X8009A79";
      localopp.c = "0X8009A79";
      opn.a(localopp);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", ors.d);
      localJSONObject.put("kandian_mode", ors.e());
      localJSONObject.put("feeds_type", "" + ors.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", szp.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      nrt.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", alpo.a(2131713518), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ozt
 * JD-Core Version:    0.7.0.1
 */