package dov.com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import anlp;

public class TimeFilterData
  extends FilterData
{
  public String c;
  
  public TimeFilterData(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new anlp(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class a()
  {
    return anlp.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.filter.TimeFilterData
 * JD-Core Version:    0.7.0.1
 */