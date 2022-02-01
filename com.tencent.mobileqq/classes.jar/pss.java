import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;

class pss
  implements pnq
{
  pss(psf parampsf) {}
  
  public void onClick(View paramView)
  {
    sxh localsxh = (sxh)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = psf.a(this.a).a(localsxh.a());
    if ((psf.a(this.a).a().a().a() != null) && (psf.a(this.a).a().a().a().a() != null) && (psf.a(this.a).a().a().a().a().a())) {
      psf.a(this.a).a().a().a().a().a(5);
    }
    int i;
    do
    {
      return;
      if (six.a(localBaseArticleInfo, psf.a(this.a).a().a())) {
        break;
      }
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        uvp.a(psf.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, psf.a(this.a).a().a(), 56);
        uvp.a((Activity)psf.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, psf.a(this.a).a().a(), 56, true, null);
        return;
      }
      if ((!six.d()) || (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        break label385;
      }
      i = 1;
      if (((psf.a(this.a).a().a().a()) || (bmhv.a(pnn.b()) <= 0)) && (i == 0)) {
        break label390;
      }
    } while (localBaseArticleInfo == null);
    if (i != 0) {
      olh.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new suu(null, null, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a((int)localBaseArticleInfo.mChannelID).N((int)psf.a(this.a).a().a()).Q(1).a().a(), false);
    }
    psf.a(this.a).a().a().a(localsxh.a(), localBaseArticleInfo, false, true);
    for (;;)
    {
      qdc.a(paramView);
      return;
      label385:
      i = 0;
      break;
      label390:
      psf.a(this.a).a().a().a().c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pss
 * JD-Core Version:    0.7.0.1
 */