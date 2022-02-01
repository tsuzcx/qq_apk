package dov.com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

class TimeFilterData$TimeFilterPageItem
  extends FilterData.FilterPageItem<TimeFilterData>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368573);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368574);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371785);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371786);
  
  private TimeFilterData$TimeFilterPageItem(TimeFilterData paramTimeFilterData, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561944, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130847038);
      return;
    case '1': 
      paramImageView.setImageResource(2130847039);
      return;
    case '2': 
      paramImageView.setImageResource(2130847040);
      return;
    case '3': 
      paramImageView.setImageResource(2130847041);
      return;
    case '4': 
      paramImageView.setImageResource(2130847042);
      return;
    case '5': 
      paramImageView.setImageResource(2130847043);
      return;
    case '6': 
      paramImageView.setImageResource(2130847044);
      return;
    case '7': 
      paramImageView.setImageResource(2130847045);
      return;
    case '8': 
      paramImageView.setImageResource(2130847046);
      return;
    }
    paramImageView.setImageResource(2130847047);
  }
  
  public void a(TimeFilterData paramTimeFilterData, int paramInt)
  {
    super.a(paramTimeFilterData, paramInt);
    paramTimeFilterData = new SimpleDateFormat("HH:mm");
    ((TimeFilterData)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData).c = paramTimeFilterData.format(new Date());
    SLog.b("TimeFilterData", "TimeFilterData time:" + ((TimeFilterData)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((TimeFilterData)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(0));
    a(this.b, ((TimeFilterData)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(1));
    a(this.c, ((TimeFilterData)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(3));
    a(this.d, ((TimeFilterData)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoFilterFilterData).c.charAt(4));
    paramInt = UIUtils.d(this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.filter.TimeFilterData.TimeFilterPageItem
 * JD-Core Version:    0.7.0.1
 */