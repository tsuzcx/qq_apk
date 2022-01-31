import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class ous
  implements rtw
{
  public ous(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = olg.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      oli localoli = new oli(paramBaseArticleInfo);
      localoli.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localoli.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localoli.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localoli.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localoli.b = "0X8009A79";
      localoli.c = "0X8009A79";
      olg.a(localoli);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", onk.d);
      localJSONObject.put("kandian_mode", onk.e());
      localJSONObject.put("feeds_type", "" + onk.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", shx.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      noo.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", ajyc.a(2131713135), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ous
 * JD-Core Version:    0.7.0.1
 */