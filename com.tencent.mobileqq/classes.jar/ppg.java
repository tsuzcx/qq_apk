import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class ppg
  implements tix
{
  public ppg(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = pfe.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      pfg localpfg = new pfg(paramBaseArticleInfo);
      localpfg.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localpfg.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localpfg.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localpfg.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localpfg.b = "0X8009A79";
      localpfg.c = "0X8009A79";
      pfe.a(localpfg);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", pha.d);
      localJSONObject.put("kandian_mode", pha.e());
      localJSONObject.put("feeds_type", "" + pha.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", ube.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      oat.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", anni.a(2131711909), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppg
 * JD-Core Version:    0.7.0.1
 */