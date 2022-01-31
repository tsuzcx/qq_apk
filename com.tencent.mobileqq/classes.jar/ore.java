import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class ore
  implements View.OnClickListener
{
  ore(ord paramord) {}
  
  public void onClick(View paramView)
  {
    int i = ((orf)paramView.getTag()).getAdapterPosition() - ord.a(this.a).c();
    int j = this.a.getItemViewType(i);
    ArticleInfo localArticleInfo = (ArticleInfo)ord.a(this.a, i);
    if (localArticleInfo == null)
    {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick onClick articleInfo is null.");
      return;
    }
    QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onItemClick, position = ", Integer.valueOf(i), ", itemViewType = ", Integer.valueOf(j) });
    this.a.a(i, paramView);
    localArticleInfo.invalidateProteusTemplateBean();
    onk.a = localArticleInfo;
    osj.a().a(localArticleInfo.mArticleID, System.currentTimeMillis());
    this.a.notifyItemChanged(i);
    onk.b(ord.a(this.a), localArticleInfo, (int)localArticleInfo.mChannelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ore
 * JD-Core Version:    0.7.0.1
 */