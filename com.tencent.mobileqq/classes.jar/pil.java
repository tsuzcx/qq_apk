import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class pil
  extends BaseAdapter
{
  private pil(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public pik a(int paramInt)
  {
    return (pik)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131562789, paramViewGroup, false);
      paramView.setOnClickListener(new pim(this));
    }
    for (;;)
    {
      pik localpik = (pik)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(localpik.a());
      this.a.jdField_a_of_type_Oxt.a("exp_subchannel", localpik);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pil
 * JD-Core Version:    0.7.0.1
 */