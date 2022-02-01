import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.8.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;

public class phw
  implements pen
{
  phw(phl paramphl) {}
  
  public void onClick(View paramView)
  {
    sjy localsjy = (sjy)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = phl.a(this.a).a(localsjy.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (!rwv.a(localBaseArticleInfo, phl.a(this.a).a().a()))
    {
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        uhs.a(phl.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, phl.a(this.a).a().a(), 56);
        uhs.a((Activity)phl.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, phl.a(this.a).a().a(), 56, true, null);
        return;
      }
      phl.a(this.a).a().a().a(localsjy.jdField_a_of_type_Sdg, localBaseArticleInfo, false, true);
    }
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.8.1(this, localBaseArticleInfo));
    psf.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phw
 * JD-Core Version:    0.7.0.1
 */