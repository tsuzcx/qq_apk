package dov.com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class TimeFilterData
  extends FilterData
{
  public String c;
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new TimeFilterData.TimeFilterPageItem(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends FilterData.FilterPageItem> a()
  {
    return TimeFilterData.TimeFilterPageItem.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.filter.TimeFilterData
 * JD-Core Version:    0.7.0.1
 */