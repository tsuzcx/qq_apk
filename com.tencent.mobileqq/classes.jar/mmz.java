import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import mqq.os.MqqHandler;

public class mmz
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  
  public mmz(ItemShowDispatcher paramItemShowDispatcher, AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    QLog.d(ItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher), 2, "  1秒到了 ");
    ItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_ComTencentWidgetAbsListView, this.jdField_a_of_type_Int);
    if (ItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher)) {
      ThreadManager.getUIHandler().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmz
 * JD-Core Version:    0.7.0.1
 */