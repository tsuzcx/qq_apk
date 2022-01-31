import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import java.util.ArrayList;

public class ouw
  extends BaseAdapter
{
  private ouw(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public ouv a(int paramInt)
  {
    return (ouv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131562302, paramViewGroup, false);
      paramView.setOnClickListener(new oux(this));
    }
    for (;;)
    {
      paramViewGroup = (ouv)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(paramViewGroup.a());
      this.a.jdField_a_of_type_Ola.a("exp_subchannel", paramViewGroup);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouw
 * JD-Core Version:    0.7.0.1
 */