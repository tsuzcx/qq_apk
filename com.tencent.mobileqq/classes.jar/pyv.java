import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class pyv
  extends BaseAdapter
{
  private pyv(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public pyu a(int paramInt)
  {
    return (pyu)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131562736, paramViewGroup, false);
      paramView.setOnClickListener(new pyw(this));
    }
    for (;;)
    {
      pyu localpyu = (pyu)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(localpyu.a());
      this.a.jdField_a_of_type_Pie.a("exp_subchannel", localpyu);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyv
 * JD-Core Version:    0.7.0.1
 */