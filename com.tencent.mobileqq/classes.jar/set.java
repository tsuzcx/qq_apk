import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class set
  implements sga
{
  set(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    ArticleInfo localArticleInfo1;
    String str;
    ArticleInfo localArticleInfo2;
    sel localsel;
    if (paramView.getId() == 2131369862)
    {
      localArticleInfo1 = (ArticleInfo)((pmy)paramView.getTag()).a;
      str = ((pmy)paramView.getTag()).b.innerUniqueID;
      localArticleInfo2 = localArticleInfo1;
      localsel = this.a;
      if (paramView.getId() != 2131369862) {
        break label124;
      }
    }
    for (;;)
    {
      localsel.a(bool, localArticleInfo2, localArticleInfo1, str);
      return;
      localArticleInfo2 = (ArticleInfo)((pmy)paramView.getTag()).b;
      str = ((pmy)paramView.getTag()).a.innerUniqueID;
      localArticleInfo1 = (ArticleInfo)((pmy)paramView.getTag()).a;
      localArticleInfo2.isTwoItem = true;
      break;
      label124:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     set
 * JD-Core Version:    0.7.0.1
 */