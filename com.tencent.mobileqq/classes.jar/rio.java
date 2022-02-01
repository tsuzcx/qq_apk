import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.BaseSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectView$onScrollListener$1", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rio
  implements AbsListView.OnScrollListener
{
  public void onScroll(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(@Nullable AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((paramAbsListView != null) && (paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!BaseSelectView.a(this.a))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        BaseSelectView.a(this.a).c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rio
 * JD-Core Version:    0.7.0.1
 */