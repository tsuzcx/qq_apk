import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FollowingListFragment;
import java.util.List;

public class qhb
  extends osp
{
  public qhb(FollowingListFragment paramFollowingListFragment) {}
  
  public void b(boolean paramBoolean1, List<qbc> paramList, long paramLong, boolean paramBoolean2)
  {
    FollowingListFragment.a(this.a, paramList);
    if (FollowingListFragment.a(this.a) != null) {
      FollowingListFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhb
 * JD-Core Version:    0.7.0.1
 */