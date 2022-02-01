import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.30.1;
import com.tencent.mobileqq.app.ThreadManager;

public class sof
  implements sow
{
  sof(snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    pum localpum = (pum)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = this.a.b(localpum.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (!ryx.a(localBaseArticleInfo, this.a.a()))
    {
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        ubb.a(this.a.a, (ArticleInfo)localBaseArticleInfo, this.a, 56);
        ubb.a(this.a.a, (ArticleInfo)localBaseArticleInfo, this.a, 56, true, null);
        return;
      }
      this.a.a(localpum.jdField_a_of_type_Sey, localBaseArticleInfo);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyBaseAdapter.30.1(this, localBaseArticleInfo));
    puf.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sof
 * JD-Core Version:    0.7.0.1
 */