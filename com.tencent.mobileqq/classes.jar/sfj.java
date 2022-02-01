import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.30.1;
import com.tencent.mobileqq.app.ThreadManager;

public class sfj
  implements sga
{
  sfj(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    pmz localpmz = (pmz)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpmz.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (!rpt.a(localBaseArticleInfo, this.a.a()))
    {
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        ubd.a(this.a.a, (ArticleInfo)localBaseArticleInfo, this.a, 56);
        ubd.a(this.a.a, (ArticleInfo)localBaseArticleInfo, this.a, 56, true, null);
        return;
      }
      this.a.a(localpmz.jdField_a_of_type_Rwc, localBaseArticleInfo);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.30.1(this, localBaseArticleInfo));
    pms.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfj
 * JD-Core Version:    0.7.0.1
 */