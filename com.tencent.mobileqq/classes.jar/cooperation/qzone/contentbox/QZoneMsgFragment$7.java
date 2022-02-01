package cooperation.qzone.contentbox;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import cooperation.qzone.api.FeedViewHolderInterface;

class QZoneMsgFragment$7
  implements AbsListView.OnScrollListener
{
  QZoneMsgFragment$7(QZoneMsgFragment paramQZoneMsgFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QZoneMsgFragment.access$1100(this.this$0) != null) {
      QZoneMsgFragment.access$1100(this.this$0).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QZoneMsgFragment.access$1100(this.this$0) != null) {
        QZoneMsgFragment.access$1100(this.this$0).onScrollStateChanged(paramAbsListView, paramInt);
      }
      return;
      QZoneMsgFragment.access$300(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.7
 * JD-Core Version:    0.7.0.1
 */