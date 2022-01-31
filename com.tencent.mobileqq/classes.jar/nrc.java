import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.ChangeVideoSortEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter.YearCollectionViewHolder;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class nrc
  implements View.OnClickListener
{
  public nrc(ShareGroupsListAdapter.YearCollectionViewHolder paramYearCollectionViewHolder) {}
  
  public void onClick(View paramView)
  {
    paramView = new ShareGroupsListAdapter.ChangeVideoSortEvent();
    if (this.a.a.a) {
      this.a.a.a = false;
    }
    for (paramView.a = 0;; paramView.a = 1)
    {
      Dispatchers.get().dispatch(paramView);
      return;
      this.a.a.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrc
 * JD-Core Version:    0.7.0.1
 */