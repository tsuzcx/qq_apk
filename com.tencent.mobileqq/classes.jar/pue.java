import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class pue
  implements View.OnClickListener
{
  pue(pud parampud) {}
  
  public void onClick(View paramView)
  {
    int i = ((puf)paramView.getTag()).getAdapterPosition() - pud.a(this.a).c();
    int j = this.a.getItemViewType(i);
    ArticleInfo localArticleInfo = (ArticleInfo)pud.a(this.a, i);
    if (localArticleInfo == null) {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick onClick articleInfo is null.");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onItemClick, position = ", Integer.valueOf(i), ", itemViewType = ", Integer.valueOf(j) });
      this.a.a(i, paramView);
      localArticleInfo.invalidateProteusTemplateBean();
      pqx.a = localArticleInfo;
      pvj.a().a(localArticleInfo.mArticleID, System.currentTimeMillis());
      this.a.notifyItemChanged(i);
      pqb.a(pud.a(this.a), localArticleInfo, (int)localArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pue
 * JD-Core Version:    0.7.0.1
 */