import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentHeaderData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendTitleData;

class spv
  extends spi
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View b;
  private View c;
  
  public spv(spr paramspr, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
    this.b = paramView.findViewById(2131365642);
    this.c = paramView.findViewById(2131377875);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = "";
    if (paramBaseData2.r == 7)
    {
      paramBaseData1 = ((RecommendTitleData)paramBaseData2).jdField_a_of_type_JavaLangString;
      this.b.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramBaseData2.r != 7) || (!((RecommendTitleData)paramBaseData2).jdField_a_of_type_Boolean)) {
        break;
      }
      this.c.setVisibility(8);
      return;
      if (paramBaseData2.r == 13)
      {
        paramBaseData1 = ((CommentHeaderData)paramBaseData2).jdField_a_of_type_JavaLangString;
        this.b.setVisibility(8);
      }
    }
    this.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spv
 * JD-Core Version:    0.7.0.1
 */