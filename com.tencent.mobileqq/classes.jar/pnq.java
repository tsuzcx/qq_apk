import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class pnq
  implements tdr
{
  public pnq(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = ozb.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      ozd localozd = new ozd(paramBaseArticleInfo);
      localozd.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localozd.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localozd.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localozd.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localozd.b = "0X8009A79";
      localozd.c = "0X8009A79";
      ozb.a(localozd);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", pay.d);
      localJSONObject.put("kandian_mode", pay.e());
      localJSONObject.put("feeds_type", "" + pay.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", uhv.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      odq.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", amtj.a(2131712250), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnq
 * JD-Core Version:    0.7.0.1
 */