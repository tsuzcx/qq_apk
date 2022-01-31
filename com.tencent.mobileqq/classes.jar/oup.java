import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class oup
  implements rtt
{
  public oup(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = old.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      olf localolf = new olf(paramBaseArticleInfo);
      localolf.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localolf.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localolf.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localolf.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localolf.b = "0X8009A79";
      localolf.c = "0X8009A79";
      old.a(localolf);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", onh.d);
      localJSONObject.put("kandian_mode", onh.e());
      localJSONObject.put("feeds_type", "" + onh.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", shu.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      nol.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", ajya.a(2131713146), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oup
 * JD-Core Version:    0.7.0.1
 */