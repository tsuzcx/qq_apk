import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import org.json.JSONObject;

public class pyo
  implements trc
{
  public pyo(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.a.a.a(paramBaseArticleInfo, paramInt);
    JSONObject localJSONObject = pih.a(this.a.getActivity(), this.a.a(), 3, paramInt, (ArticleInfo)paramBaseArticleInfo);
    try
    {
      localJSONObject.put("card_type", 8);
      pij localpij = new pij(paramBaseArticleInfo);
      localpij.e = String.valueOf(paramBaseArticleInfo.mArticleID);
      localpij.f = String.valueOf(paramBaseArticleInfo.mStrategyId);
      localpij.g = localJSONObject.toString();
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        localpij.a = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.a.a);
      }
      localpij.b = "0X8009A79";
      localpij.c = "0X8009A79";
      pih.a(localpij);
      localJSONObject = new JSONObject();
      localJSONObject.put("time", System.currentTimeMillis() / 1000L);
      localJSONObject.put("channel_id", this.a.a());
      localJSONObject.put("folder_status", prp.a);
      localJSONObject.put("kandian_mode", pqu.a());
      localJSONObject.put("feeds_type", "" + pqw.a(paramBaseArticleInfo));
      localJSONObject.put("rowkey", uvs.a(paramBaseArticleInfo));
      paramBaseArticleInfo = localJSONObject.toString();
      olh.a(null, "", "0X8009990", "0X8009990", 0, 0, "4", "", anvx.a(2131712597), paramBaseArticleInfo, false);
      return;
    }
    catch (Exception paramBaseArticleInfo) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyo
 * JD-Core Version:    0.7.0.1
 */