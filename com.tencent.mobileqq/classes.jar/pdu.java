import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class pdu
  implements View.OnClickListener
{
  pdu(pdt parampdt) {}
  
  public void onClick(View paramView)
  {
    int i = ((pdv)paramView.getTag()).getAdapterPosition() - pdt.a(this.a).c();
    int j = this.a.getItemViewType(i);
    ArticleInfo localArticleInfo = (ArticleInfo)pdt.a(this.a, i);
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
      ozs.a = localArticleInfo;
      pfa.a().a(localArticleInfo.mArticleID, System.currentTimeMillis());
      this.a.notifyItemChanged(i);
      ozs.b(pdt.a(this.a), localArticleInfo, (int)localArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdu
 * JD-Core Version:    0.7.0.1
 */