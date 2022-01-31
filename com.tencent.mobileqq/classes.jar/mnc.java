import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentHeaderData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendTitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.SimpleViewCreator;

public class mnc
  extends BaseItemViewHolder
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View b;
  private View c;
  
  public mnc(SimpleViewCreator paramSimpleViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361926));
    this.b = paramView.findViewById(2131363960);
    this.c = paramView.findViewById(2131367128);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = "";
    if (paramBaseData2.d == 7)
    {
      paramBaseData1 = ((RecommendTitleData)paramBaseData2).a;
      this.b.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.c.setVisibility(0);
      return;
      if (paramBaseData2.d == 13)
      {
        paramBaseData1 = ((CommentHeaderData)paramBaseData2).a;
        this.b.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnc
 * JD-Core Version:    0.7.0.1
 */