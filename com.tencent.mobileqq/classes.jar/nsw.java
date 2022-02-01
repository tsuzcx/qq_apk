import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class nsw
  extends BaseAdapter
{
  protected LayoutInflater a;
  
  public nsw(PoiMapActivity paramPoiMapActivity, Context paramContext)
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
    View localView;
    if (paramView == null)
    {
      paramView = new nsr(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131560013, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371815));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362211));
      paramView.c = localView.findViewById(2131377301);
      paramView.c.setVisibility(4);
      paramView.d = localView.findViewById(2131371562);
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365562);
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131377524);
      localView.setTag(paramView);
      paramView.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (paramInt != this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size()) {
        break label195;
      }
      paramView.d.setVisibility(0);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = (nsr)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label195:
      paramView.d.setVisibility(8);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject = (nsp)getItem(paramInt);
      if (localObject != null)
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((nsp)localObject).a);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((nsp)localObject).b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsw
 * JD-Core Version:    0.7.0.1
 */