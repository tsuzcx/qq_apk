import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.widget.AbsListView;

public class ome
  implements bhtv
{
  public ome(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ((ReadInJoyCommentListView)paramAbsListView).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    ((ReadInJoyCommentListView)paramAbsListView).a(paramAbsListView, paramInt);
    if ((ReadInJoySecondCommentListFragment.a(this.a) != null) && (ReadInJoySecondCommentListFragment.a(this.a).a() != null)) {
      ReadInJoySecondCommentListFragment.a(this.a).a().a(ReadInJoySecondCommentListFragment.a(this.a).getFirstVisiblePosition(), ReadInJoySecondCommentListFragment.a(this.a).getLastVisiblePosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ome
 * JD-Core Version:    0.7.0.1
 */