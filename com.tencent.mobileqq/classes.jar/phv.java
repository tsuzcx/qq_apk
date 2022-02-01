import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;

class phv
  implements pen
{
  phv(phl paramphl) {}
  
  public void onClick(View paramView)
  {
    sjy localsjy = (sjy)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = phl.a(this.a).a(localsjy.a());
    if ((phl.a(this.a).a().a().a() != null) && (phl.a(this.a).a().a().a().a() != null) && (phl.a(this.a).a().a().a().a().a())) {
      phl.a(this.a).a().a().a().a().a(5);
    }
    int i;
    do
    {
      return;
      if (rwv.a(localBaseArticleInfo, phl.a(this.a).a().a())) {
        break;
      }
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        uhs.a(phl.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, phl.a(this.a).a().a(), 56);
        uhs.a((Activity)phl.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, phl.a(this.a).a().a(), 56, true, null);
        return;
      }
      if ((!rwv.d()) || (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        break label385;
      }
      i = 1;
      if (((phl.a(this.a).a().a().a()) || (bkwm.a(pem.a()) <= 0)) && (i == 0)) {
        break label390;
      }
    } while (localBaseArticleInfo == null);
    if (i != 0) {
      odq.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new sie(null, null, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a((int)localBaseArticleInfo.mChannelID).N((int)phl.a(this.a).a().a()).Q(1).a().a(), false);
    }
    phl.a(this.a).a().a().a(localsjy.a(), localBaseArticleInfo, false, true);
    for (;;)
    {
      psf.a(paramView);
      return;
      label385:
      i = 0;
      break;
      label390:
      phl.a(this.a).a().a().a().c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phv
 * JD-Core Version:    0.7.0.1
 */