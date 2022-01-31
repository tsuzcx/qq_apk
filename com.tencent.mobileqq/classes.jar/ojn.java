import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import java.util.ArrayList;

public class ojn
  extends BaseAdapter
{
  private ojn(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public ojm a(int paramInt)
  {
    return (ojm)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131496702, paramViewGroup, false);
      paramView.setOnClickListener(new ojo(this));
    }
    for (;;)
    {
      paramViewGroup = (ojm)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(paramViewGroup.a());
      this.a.jdField_a_of_type_Nzs.a("exp_subchannel", paramViewGroup);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojn
 * JD-Core Version:    0.7.0.1
 */