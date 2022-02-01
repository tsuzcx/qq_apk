import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class psh
  implements pnq
{
  psh(psf parampsf) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo2;
    String str;
    ArticleInfo localArticleInfo1;
    if (paramView.getId() == 2131370023)
    {
      localArticleInfo2 = (ArticleInfo)((sxg)paramView.getTag()).a;
      str = ((sxg)paramView.getTag()).b.innerUniqueID;
      localArticleInfo1 = localArticleInfo2;
      if (paramView.getId() != 2131370023) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      psu.a(bool, localArticleInfo2, localArticleInfo1, str, null, psf.a(this.a));
      return;
      localArticleInfo2 = (ArticleInfo)((sxg)paramView.getTag()).b;
      str = ((sxg)paramView.getTag()).a.innerUniqueID;
      localArticleInfo1 = (ArticleInfo)((sxg)paramView.getTag()).a;
      localArticleInfo2.isTwoItem = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psh
 * JD-Core Version:    0.7.0.1
 */