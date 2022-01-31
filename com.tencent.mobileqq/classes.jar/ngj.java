import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemLongClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.biz.qqstory.common.recyclerview.HeaderAndFooterAdapter;

public class ngj
  implements View.OnLongClickListener
{
  public ngj(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewHeaderAndFooterAdapter.a.b(this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngj
 * JD-Core Version:    0.7.0.1
 */