package dov.com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.TakeVideoUtils;

public class FrameAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLoader jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader;
  private int b;
  
  public Bitmap a(int paramInt)
  {
    return null;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      int i = (int)(TakeVideoUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources()) * this.b);
      paramView = new ViewGroup.LayoutParams(this.b, i);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setLayoutParams(paramView);
      paramView = new FrameAdapter.Holder();
      paramView.a = ((ImageView)localObject);
      paramView.a.setImageDrawable(new ColorDrawable(-12303292));
      ((View)localObject).setTag(paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader.a(paramView.a, Integer.valueOf(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      FrameAdapter.Holder localHolder = (FrameAdapter.Holder)paramView.getTag();
      localObject = paramView;
      paramView = localHolder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameAdapter
 * JD-Core Version:    0.7.0.1
 */