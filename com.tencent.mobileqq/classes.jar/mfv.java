import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Calendar;

public class mfv
  implements Runnable
{
  public mfv(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) == 0) && (ReadInJoyHelper.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a) > 0) && (this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition() >= ReadInJoyHelper.h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a)) && (ReadInJoyHelper.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a) > 0))
    {
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition());
      i = ReadInJoyHelper.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a);
      j = ReadInJoyHelper.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a);
      if (l1 <= l2) {
        break label197;
      }
      ReadInJoyHelper.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a, 1);
      ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a, l1);
      ((KandianMergeManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a.getManager(161)).n();
    }
    label197:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    ReadInJoyHelper.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a, j + 1);
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a.getManager(161)).n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfv
 * JD-Core Version:    0.7.0.1
 */