import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import java.util.List;

public class mme
  extends BaseAdapter
{
  protected LayoutInflater a;
  
  public mme(PoiMapActivity paramPoiMapActivity, Context paramContext)
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
      paramViewGroup = new mlz(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131494190, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304994));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296588));
      paramViewGroup.c = paramView.findViewById(2131310033);
      paramViewGroup.c.setVisibility(4);
      paramViewGroup.d = paramView.findViewById(2131304762);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299498);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131310235);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (paramInt != this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size()) {
        break label164;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label164:
    mlx localmlx;
    do
    {
      return paramView;
      paramViewGroup = (mlz)paramView.getTag();
      break;
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localmlx = (mlx)getItem(paramInt);
    } while (localmlx == null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localmlx.a);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localmlx.b);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mme
 * JD-Core Version:    0.7.0.1
 */