import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import java.util.List;

public class mzt
  extends BaseAdapter
{
  protected LayoutInflater a;
  
  public mzt(PoiMapActivity paramPoiMapActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.d) {
      return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size() + 1;
    }
    return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new mzo(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131559822, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370990));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362135));
      paramViewGroup.c = paramView.findViewById(2131376350);
      paramViewGroup.c.setVisibility(4);
      paramViewGroup.d = paramView.findViewById(2131370746);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365152);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376557);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (paramInt != this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size()) {
        break label164;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label164:
    mzm localmzm;
    do
    {
      return paramView;
      paramViewGroup = (mzo)paramView.getTag();
      break;
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localmzm = (mzm)getItem(paramInt);
    } while (localmzm == null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localmzm.a);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localmzm.b);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mzt
 * JD-Core Version:    0.7.0.1
 */