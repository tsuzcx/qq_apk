import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mxs
  implements View.OnClickListener
{
  public mxs(QGroupExpandableListAdapter paramQGroupExpandableListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.a[this.jdField_a_of_type_Int] = 2;
    this.jdField_a_of_type_ComTencentAvWtogetherAdapterQGroupExpandableListAdapter.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxs
 * JD-Core Version:    0.7.0.1
 */