import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class soh
  implements sow
{
  soh(snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    pum localpum = (pum)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpum.a());
    if ((this.a.jdField_a_of_type_Seu.a() != null) && (this.a.jdField_a_of_type_Seu.a().a() != null) && (this.a.jdField_a_of_type_Seu.a().a().a())) {
      this.a.jdField_a_of_type_Seu.a().a().a(5);
    }
    int i;
    do
    {
      return;
      if (ryx.a(localBaseArticleInfo, this.a.a())) {
        break;
      }
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        ubb.a(this.a.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localBaseArticleInfo, this.a, 56);
        ubb.a(this.a.jdField_a_of_type_AndroidAppActivity, (ArticleInfo)localBaseArticleInfo, this.a, 56, true, null);
        return;
      }
      if ((!ryx.c()) || (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        break label297;
      }
      i = 1;
      if (((snh.a(this.a).a()) || (bmqa.a(snh.a()) <= 0)) && (i == 0)) {
        break label302;
      }
    } while (localBaseArticleInfo == null);
    if (i != 0) {
      oat.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new skc(null, null, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a((int)localBaseArticleInfo.mChannelID).O((int)snh.b(this.a)).R(1).a().a(), false);
    }
    this.a.a(localpum.a(), localBaseArticleInfo, false);
    for (;;)
    {
      puf.a(paramView);
      return;
      label297:
      i = 0;
      break;
      label302:
      this.a.jdField_a_of_type_Seu.a().c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     soh
 * JD-Core Version:    0.7.0.1
 */