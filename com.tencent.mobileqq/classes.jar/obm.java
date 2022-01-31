import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;

class obm
  extends BaseAdapter
{
  obm(obj paramobj) {}
  
  public int getCount()
  {
    return obj.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return obj.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559945, null);
      paramViewGroup = new obn(this.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378373));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368529));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGiftServiceBean.t);
      if (obj.a(this.a) != paramInt) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842335);
      return paramView;
      paramViewGroup = (obn)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842336);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obm
 * JD-Core Version:    0.7.0.1
 */