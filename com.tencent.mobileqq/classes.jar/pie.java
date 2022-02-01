import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class pie
  implements szr
{
  public pie(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = oxw.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      oxy localoxy = new oxy(paramBaseArticleInfo);
      localoxy.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localoxy.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localoxy.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localoxy.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localoxy.b = "0X8009A79";
      localoxy.c = "0X8009A79";
      oxw.a(localoxy);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", ozs.d);
      localJSONObject.put("kandian_mode", ozs.e());
      localJSONObject.put("feeds_type", "" + ozs.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", ubg.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      ocd.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", anzj.a(2131712018), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pie
 * JD-Core Version:    0.7.0.1
 */