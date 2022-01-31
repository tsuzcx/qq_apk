package dov.com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import aobv;

public class WeatherFilterData
  extends FilterData
{
  public int c;
  
  public WeatherFilterData(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new aobv(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class a()
  {
    return aobv.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.filter.WeatherFilterData
 * JD-Core Version:    0.7.0.1
 */