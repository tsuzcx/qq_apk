package dov.com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import aokn;
import com.tencent.biz.qqstory.support.logging.SLog;

public class SpeedFilterData
  extends FilterData
{
  private final float a;
  private int c;
  
  public SpeedFilterData(int paramInt1, String paramString, int paramInt2, float paramFloat)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramFloat;
    this.c = a(this.a);
    SLog.a("SpeedFilterData", "create SpeedFilterData, meterSpeed : %s, kmSpeed : %s .", Float.valueOf(this.a), Integer.valueOf(this.c));
  }
  
  private int a(float paramFloat)
  {
    int i;
    if (paramFloat < 0.0F)
    {
      SLog.b("SpeedFilterData", "meterSpeed < 0. meterSpeed : " + paramFloat);
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramFloat *= 3.6F;
      j = (int)paramFloat;
      i = j;
    } while (paramFloat - j < 0.5F);
    return j + 1;
  }
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new aokn(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class a()
  {
    return aokn.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.filter.SpeedFilterData
 * JD-Core Version:    0.7.0.1
 */