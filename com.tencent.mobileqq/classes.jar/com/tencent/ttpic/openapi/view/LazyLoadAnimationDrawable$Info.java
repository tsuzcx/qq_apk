package com.tencent.ttpic.openapi.view;

import android.content.res.Resources;
import java.io.File;
import java.util.ArrayList;

public class LazyLoadAnimationDrawable$Info
{
  public int[] durations = null;
  public String[] filenames = null;
  public Resources res;
  public int totalDuration = 0;
  
  public LazyLoadAnimationDrawable$Info(Resources paramResources, ArrayList<File> paramArrayList, int[] paramArrayOfInt, Integer[] paramArrayOfInteger)
  {
    this.res = paramResources;
    this.filenames = new String[paramArrayList.size()];
    this.durations = new int[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.filenames[i] = ((File)paramArrayList.get(paramArrayOfInteger[i].intValue())).getAbsolutePath();
      this.durations[i] = paramArrayOfInt[paramArrayOfInteger[i].intValue()];
      this.totalDuration += this.durations[i];
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable.Info
 * JD-Core Version:    0.7.0.1
 */