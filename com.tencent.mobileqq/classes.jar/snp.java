import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class snp
  implements sow
{
  snp(snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    ArticleInfo localArticleInfo1;
    String str;
    ArticleInfo localArticleInfo2;
    snh localsnh;
    if (paramView.getId() == 2131369765)
    {
      localArticleInfo1 = (ArticleInfo)((pul)paramView.getTag()).a;
      str = ((pul)paramView.getTag()).b.innerUniqueID;
      localArticleInfo2 = localArticleInfo1;
      localsnh = this.a;
      if (paramView.getId() != 2131369765) {
        break label124;
      }
    }
    for (;;)
    {
      localsnh.a(bool, localArticleInfo2, localArticleInfo1, str);
      return;
      localArticleInfo2 = (ArticleInfo)((pul)paramView.getTag()).b;
      str = ((pul)paramView.getTag()).a.innerUniqueID;
      localArticleInfo1 = (ArticleInfo)((pul)paramView.getTag()).a;
      localArticleInfo2.isTwoItem = true;
      break;
      label124:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     snp
 * JD-Core Version:    0.7.0.1
 */