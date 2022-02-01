import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class phm
  implements pen
{
  phm(phl paramphl) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo2;
    String str;
    ArticleInfo localArticleInfo1;
    if (paramView.getId() == 2131369853)
    {
      localArticleInfo2 = (ArticleInfo)((sjx)paramView.getTag()).a;
      str = ((sjx)paramView.getTag()).b.innerUniqueID;
      localArticleInfo1 = localArticleInfo2;
      if (paramView.getId() != 2131369853) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      phy.a(bool, localArticleInfo2, localArticleInfo1, str, null, phl.a(this.a));
      return;
      localArticleInfo2 = (ArticleInfo)((sjx)paramView.getTag()).b;
      str = ((sjx)paramView.getTag()).a.innerUniqueID;
      localArticleInfo1 = (ArticleInfo)((sjx)paramView.getTag()).a;
      localArticleInfo2.isTwoItem = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phm
 * JD-Core Version:    0.7.0.1
 */