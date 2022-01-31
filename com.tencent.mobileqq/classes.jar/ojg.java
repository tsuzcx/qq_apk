import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class ojg
  implements rhg
{
  public ojg(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = nzv.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      nzx localnzx = new nzx(paramBaseArticleInfo);
      localnzx.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localnzx.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localnzx.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localnzx.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localnzx.b = "0X8009A79";
      localnzx.c = "0X8009A79";
      nzv.a(localnzx);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", obz.d);
      localJSONObject.put("kandian_mode", obz.e());
      localJSONObject.put("feeds_type", "" + obz.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", rvf.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      ndn.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", ajjy.a(2131647347), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojg
 * JD-Core Version:    0.7.0.1
 */