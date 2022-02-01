import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class pay
  implements AbsListView.OnScrollListener
{
  public pay(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null)
    {
      if (ReadInJoyCommentListFragment.a(this.a).a().a().a()) {
        break label95;
      }
      ((ReadInJoyCommentListView)paramAbsListView).a(paramAbsListView, paramInt);
    }
    for (;;)
    {
      if ((ReadInJoyCommentListFragment.a(this.a) != null) && (ReadInJoyCommentListFragment.a(this.a).a() != null)) {
        ReadInJoyCommentListFragment.a(this.a).a().a(ReadInJoyCommentListFragment.a(this.a).getFirstVisiblePosition(), ReadInJoyCommentListFragment.a(this.a).getLastVisiblePosition());
      }
      return;
      label95:
      ((ReadInJoyCommentListView)paramAbsListView).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pay
 * JD-Core Version:    0.7.0.1
 */