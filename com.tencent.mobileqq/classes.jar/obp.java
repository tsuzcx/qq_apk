import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;

class obp
  extends BaseAdapter
{
  obp(obm paramobm) {}
  
  public int getCount()
  {
    return obm.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return obm.a(this.a).get(paramInt);
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
      paramViewGroup = new obq(this.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378370));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368530));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGiftServiceBean.t);
      if (obm.a(this.a) != paramInt) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842334);
      return paramView;
      paramViewGroup = (obq)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842335);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obp
 * JD-Core Version:    0.7.0.1
 */