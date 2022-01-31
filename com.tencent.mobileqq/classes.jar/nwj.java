import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import java.util.List;

public class nwj
  implements nyh
{
  public nwj(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<nwx> paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void onCommentStateError(int paramInt)
  {
    if (paramInt == 1002) {
      ReadInJoySecondCommentListFragment.a(this.a, true);
    }
    if (paramInt == 1003) {
      vvp.a(1, 2131652539);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nwj
 * JD-Core Version:    0.7.0.1
 */