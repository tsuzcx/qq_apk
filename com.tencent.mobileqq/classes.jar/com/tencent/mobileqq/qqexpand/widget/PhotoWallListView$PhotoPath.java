package com.tencent.mobileqq.qqexpand.widget;

import android.text.TextUtils;
import java.util.ArrayList;

public class PhotoWallListView$PhotoPath
{
  public String a;
  public String b;
  
  public PhotoWallListView$PhotoPath(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static ArrayList<String> a(ArrayList<PhotoPath> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(((PhotoPath)paramArrayList.get(i)).a());
      if (localArrayList.size() >= 4) {
        return localArrayList;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.b)) {
      return this.b;
    }
    return this.a;
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.PhotoWallListView.PhotoPath
 * JD-Core Version:    0.7.0.1
 */