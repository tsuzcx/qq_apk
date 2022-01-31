import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.LinkData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;

public class mni
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private TextView a;
  
  public mni(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367129));
    paramView.setOnClickListener(this);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.d)
    {
    default: 
      return;
    }
    paramBaseData1 = (LinkData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(paramBaseData1.a));
  }
  
  public void onClick(View paramView)
  {
    paramView = (LinkData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData;
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), paramView.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mni
 * JD-Core Version:    0.7.0.1
 */