package com.tencent.mobileqq.shortvideo.filter;

import java.util.ArrayList;
import java.util.Arrays;

class FilterManagerInternal$FilterChain
{
  String info;
  boolean mCreateResume = true;
  int[] mFilters;
  ArrayList<QQBaseFilter> mHighCache = new ArrayList();
  String mId;
  Object[] mParams;
  FilterChain oldTopChain = null;
  
  FilterManagerInternal$FilterChain(FilterManagerInternal paramFilterManagerInternal, int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    this.mFilters = paramArrayOfInt;
    this.mParams = paramArrayOfObject;
    generateID();
    this.info = FilterCreateFactory.getLogInfo(this.mFilters);
  }
  
  void generateID()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.mFilters != null)
    {
      int[] arrayOfInt = this.mFilters;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfInt[i]);
        localStringBuilder.append("_");
        i += 1;
      }
    }
    this.mId = localStringBuilder.toString();
  }
  
  void getFilterParams(ArrayList<Object> paramArrayList)
  {
    if (this.mParams != null) {
      paramArrayList.addAll(Arrays.asList(this.mParams));
    }
  }
  
  void getFilterTypes(ArrayList<Integer> paramArrayList)
  {
    if (this.mFilters != null)
    {
      int[] arrayOfInt = this.mFilters;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        paramArrayList.add(Integer.valueOf(arrayOfInt[i]));
        i += 1;
      }
    }
  }
  
  String getId()
  {
    return this.mId;
  }
  
  Object getParam(int paramInt)
  {
    if ((this.mParams != null) && (paramInt >= 0) && (paramInt < this.mParams.length)) {
      return this.mParams[paramInt];
    }
    return null;
  }
  
  boolean hasFilterType(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int[] arrayOfInt;
    int j;
    int i;
    if (this.mFilters != null)
    {
      arrayOfInt = this.mFilters;
      j = arrayOfInt.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterManagerInternal.FilterChain
 * JD-Core Version:    0.7.0.1
 */