import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.9.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;

public class pst
  implements pnq
{
  pst(psf parampsf) {}
  
  public void onClick(View paramView)
  {
    sxh localsxh = (sxh)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = psf.a(this.a).a(localsxh.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (!six.a(localBaseArticleInfo, psf.a(this.a).a().a()))
    {
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        uvp.a(psf.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, psf.a(this.a).a().a(), 56);
        uvp.a((Activity)psf.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, psf.a(this.a).a().a(), 56, true, null);
        return;
      }
      psf.a(this.a).a().a().a(localsxh.jdField_a_of_type_Spk, localBaseArticleInfo, false, true);
    }
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.9.1(this, localBaseArticleInfo));
    qdc.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pst
 * JD-Core Version:    0.7.0.1
 */