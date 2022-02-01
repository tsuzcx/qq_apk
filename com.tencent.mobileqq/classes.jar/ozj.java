import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView;

public class ozj
  implements bkhe
{
  public ozj(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (!ReadInJoyCommentListFragment.a(this.a).a().a().a()) {
      ((ReadInJoyCommentListView)paramAbsListView).a(paramAbsListView, paramInt);
    }
    for (;;)
    {
      if ((ReadInJoyCommentListFragment.a(this.a) != null) && (ReadInJoyCommentListFragment.a(this.a).a() != null)) {
        ReadInJoyCommentListFragment.a(this.a).a().a(ReadInJoyCommentListFragment.a(this.a).getFirstVisiblePosition(), ReadInJoyCommentListFragment.a(this.a).getLastVisiblePosition());
      }
      return;
      ((ReadInJoyCommentListView)paramAbsListView).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozj
 * JD-Core Version:    0.7.0.1
 */