import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;

class nqe
  extends BaseAdapter
{
  nqe(nqb paramnqb) {}
  
  public int getCount()
  {
    return nqb.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return nqb.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494375, null);
      paramViewGroup = new nqf(this.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312545));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302905));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGiftServiceBean.t);
      if (nqb.a(this.a) != paramInt) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842251);
      return paramView;
      paramViewGroup = (nqf)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842252);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqe
 * JD-Core Version:    0.7.0.1
 */