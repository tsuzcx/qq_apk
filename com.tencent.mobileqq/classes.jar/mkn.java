import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Calendar;

public class mkn
  implements Runnable
{
  public mkn(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, AbsListView paramAbsListView) {}
  
  public void run()
  {
    int i;
    int j;
    long l1;
    long l2;
    if ((ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter) == 0) && (ReadInJoyHelper.i(ReadInJoyBaseAdapter.a()) > 0) && (this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition() >= ReadInJoyHelper.i(ReadInJoyBaseAdapter.a())) && (ReadInJoyHelper.h(ReadInJoyBaseAdapter.a()) > 0))
    {
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentWidgetAbsListView.getLastVisiblePosition());
      i = ReadInJoyHelper.h(ReadInJoyBaseAdapter.a());
      j = ReadInJoyHelper.j(ReadInJoyBaseAdapter.a());
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(10, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l1 = localCalendar.getTimeInMillis();
      l2 = ReadInJoyHelper.a(ReadInJoyBaseAdapter.a());
      if (l1 <= l2) {
        break label161;
      }
      ReadInJoyHelper.j(ReadInJoyBaseAdapter.a(), 1);
      ReadInJoyHelper.a(ReadInJoyBaseAdapter.a(), l1);
      ((KandianMergeManager)ReadInJoyBaseAdapter.a().getManager(161)).o();
    }
    label161:
    while ((l1 != l2) || (j >= i)) {
      return;
    }
    ReadInJoyHelper.j(ReadInJoyBaseAdapter.a(), j + 1);
    ((KandianMergeManager)ReadInJoyBaseAdapter.a().getManager(161)).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkn
 * JD-Core Version:    0.7.0.1
 */