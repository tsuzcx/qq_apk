package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import java.util.ArrayList;

class HorizontalSelectColorLayout$SelectColorAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<HorizontalStroke> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public HorizontalSelectColorLayout$SelectColorAdapter(HorizontalSelectColorLayout paramHorizontalSelectColorLayout, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ArrayList<HorizontalStroke> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    HorizontalStroke localHorizontalStroke = (HorizontalStroke)getItem(paramInt);
    HorizontalSelectColorLayout.SelectColorAdapter.ItemHold localItemHold;
    if (paramView == null)
    {
      localItemHold = new HorizontalSelectColorLayout.SelectColorAdapter.ItemHold(this);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559183, paramViewGroup, false);
        localItemHold.b = ((ImageView)paramView.findViewById(2131369424));
        localItemHold.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369274));
        localItemHold.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369273));
        paramView.setTag(localItemHold);
        label97:
        if (Build.VERSION.SDK_INT < 21) {
          localItemHold.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        localItemHold.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localHorizontalStroke.a);
        if (paramInt != this.jdField_a_of_type_Int) {
          break label240;
        }
        if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
          break label217;
        }
        localItemHold.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (localHorizontalStroke.b != null) {
        paramView.setContentDescription(localHorizontalStroke.b);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559182, paramViewGroup, false);
      break;
      localItemHold = (HorizontalSelectColorLayout.SelectColorAdapter.ItemHold)paramView.getTag();
      break label97;
      label217:
      localItemHold.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getResources().getDrawable(2130845206));
      continue;
      label240:
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.b) {
        localItemHold.b.setVisibility(4);
      } else {
        localItemHold.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.SelectColorAdapter
 * JD-Core Version:    0.7.0.1
 */