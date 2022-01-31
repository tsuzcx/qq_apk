import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseViewHolder;
import com.tencent.biz.qqstory.common.recyclerview.HeaderAndFooterAdapter;

public class ngi
  implements View.OnClickListener
{
  public ngi(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewHeaderAndFooterAdapter.a.a(this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.itemView, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngi
 * JD-Core Version:    0.7.0.1
 */