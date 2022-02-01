package dov.com.qq.im.capture.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class CaptureModeAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private CaptureModeAdapter.OnItemClickListener jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter$OnItemClickListener;
  private List<TextView> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.CaptureModeAdapter
 * JD-Core Version:    0.7.0.1
 */