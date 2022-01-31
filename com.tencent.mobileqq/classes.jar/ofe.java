import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;

class ofe
  extends BaseAdapter
{
  ofe(ofb paramofb) {}
  
  public int getCount()
  {
    return ofb.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ofb.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560042, null);
      paramViewGroup = new off(this.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379033));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368739));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGiftServiceBean.t);
      if (ofb.a(this.a) != paramInt) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842517);
      return paramView;
      paramViewGroup = (off)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842518);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofe
 * JD-Core Version:    0.7.0.1
 */