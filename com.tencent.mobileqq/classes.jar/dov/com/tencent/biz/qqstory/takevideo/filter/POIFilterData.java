package dov.com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;

public class POIFilterData
  extends FilterData
{
  public final int c;
  @NonNull
  public final String c;
  public final int d;
  @NonNull
  public final String d;
  public final int e;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  
  @NonNull
  public FilterData.FilterPageItem a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new POIFilterData.POIFilterPageItem(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends FilterData.FilterPageItem> a()
  {
    return POIFilterData.POIFilterPageItem.class;
  }
  
  public String a()
  {
    if ((TextUtils.isEmpty(this.c)) && (TextUtils.isEmpty(this.d)) && (TextUtils.isEmpty(this.e))) {
      return "";
    }
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d))) {
      return this.c + "，" + this.d;
    }
    if (!TextUtils.isEmpty(this.c)) {
      return this.c;
    }
    if (!TextUtils.isEmpty(this.d)) {
      return this.d;
    }
    return this.e;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.filter.POIFilterData
 * JD-Core Version:    0.7.0.1
 */