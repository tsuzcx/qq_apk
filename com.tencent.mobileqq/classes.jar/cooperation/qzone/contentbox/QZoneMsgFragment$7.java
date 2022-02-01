package cooperation.qzone.contentbox;

import com.tencent.qzonehub.api.contentbox.IFeedViewHolderInterface;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class QZoneMsgFragment$7
  implements AbsListView.OnScrollListener
{
  QZoneMsgFragment$7(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QZoneMsgFragment.access$1300(this.this$0) != null) {
      QZoneMsgFragment.access$1300(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {}
    }
    else
    {
      QZoneMsgFragment.access$300(this.this$0);
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) {
        QZoneMsgFragment.access$1200(this.this$0);
      }
    }
    if (QZoneMsgFragment.access$1300(this.this$0) != null) {
      QZoneMsgFragment.access$1300(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.7
 * JD-Core Version:    0.7.0.1
 */