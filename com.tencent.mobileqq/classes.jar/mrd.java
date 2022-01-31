import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TextData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.OnItemClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class mrd
  extends BaseItemViewHolder
  implements View.OnLongClickListener
{
  private TextView a;
  
  public mrd(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367129));
    paramView.setOnLongClickListener(this);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.d)
    {
    default: 
      return;
    }
    paramBaseData1 = (TextData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.a);
  }
  
  public boolean onLongClick(View paramView)
  {
    new QQCustomMenu().a(0, "复制");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemOnItemClickListener.a(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrd
 * JD-Core Version:    0.7.0.1
 */