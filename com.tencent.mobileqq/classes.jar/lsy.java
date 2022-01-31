import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnLastReadRefreshListener;
import java.util.Map;

public class lsy
  implements FeedItemCell.CellListener
{
  public lsy(FeedItemCell paramFeedItemCell) {}
  
  public void a(View paramView, Map paramMap)
  {
    if (paramView.getId() == 2131366836) {
      this.a.a(paramView);
    }
    do
    {
      return;
      if (paramView != this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead) {
        break;
      }
      paramView = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a();
    } while (paramView == null);
    paramView.a();
    return;
    this.a.a(paramView, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsy
 * JD-Core Version:    0.7.0.1
 */