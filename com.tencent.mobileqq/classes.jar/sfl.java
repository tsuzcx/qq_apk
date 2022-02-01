import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;

class sfl
  implements sga
{
  sfl(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    pmz localpmz = (pmz)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpmz.a());
    if ((this.a.jdField_a_of_type_Rvy.a() != null) && (this.a.jdField_a_of_type_Rvy.a().a() != null) && (this.a.jdField_a_of_type_Rvy.a().a().a())) {
      this.a.jdField_a_of_type_Rvy.a().a().a(5);
    }
    int i;
    do
    {
      return;
      if (rpt.a(localBaseArticleInfo, this.a.a())) {
        break;
      }
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        ubd.a(this.a.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localBaseArticleInfo, this.a, 56);
        ubd.a(this.a.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localBaseArticleInfo, this.a, 56, true, null);
        return;
      }
      if ((!rpt.d()) || (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        break label297;
      }
      i = 1;
      if (((sel.a(this.a).a()) || (bnrf.a(sel.a()) <= 0)) && (i == 0)) {
        break label302;
      }
    } while (localBaseArticleInfo == null);
    if (i != 0) {
      ocd.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new sbg(null, null, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a((int)localBaseArticleInfo.mChannelID).N((int)sel.b(this.a)).Q(1).a().a(), false);
    }
    this.a.a(localpmz.a(), localBaseArticleInfo, false);
    for (;;)
    {
      pms.a(paramView);
      return;
      label297:
      i = 0;
      break;
      label302:
      this.a.jdField_a_of_type_Rvy.a().c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfl
 * JD-Core Version:    0.7.0.1
 */