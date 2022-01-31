import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemLongClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.biz.qqstory.common.recyclerview.HeaderAndFooterAdapter;

public class nbd
  implements View.OnLongClickListener
{
  public nbd(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewHeaderAndFooterAdapter.a.b(this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.itemView, this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.getPosition());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbd
 * JD-Core Version:    0.7.0.1
 */