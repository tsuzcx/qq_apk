package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter
{
  public static int DAY_COUNT = 5;
  private android.webkit.DateSorter a;
  private IX5DateSorter b;
  
  static
  {
    a();
  }
  
  public DateSorter(Context paramContext)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      this.b = localx.c().h(paramContext);
      return;
    }
    this.a = new android.webkit.DateSorter(paramContext);
  }
  
  private static boolean a()
  {
    x localx = x.a();
    return (localx != null) && (localx.b());
  }
  
  public long getBoundary(int paramInt)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return this.b.getBoundary(paramInt);
    }
    return this.a.getBoundary(paramInt);
  }
  
  public int getIndex(long paramLong)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return this.b.getIndex(paramLong);
    }
    return this.a.getIndex(paramLong);
  }
  
  public String getLabel(int paramInt)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      return this.b.getLabel(paramInt);
    }
    return this.a.getLabel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.DateSorter
 * JD-Core Version:    0.7.0.1
 */