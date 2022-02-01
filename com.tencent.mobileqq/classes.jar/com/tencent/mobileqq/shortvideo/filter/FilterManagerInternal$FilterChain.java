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
    int[] arrayOfInt = this.mFilters;
    if (arrayOfInt != null)
    {
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
    Object[] arrayOfObject = this.mParams;
    if (arrayOfObject != null) {
      paramArrayList.addAll(Arrays.asList(arrayOfObject));
    }
  }
  
  void getFilterTypes(ArrayList<Integer> paramArrayList)
  {
    int[] arrayOfInt = this.mFilters;
    if (arrayOfInt != null)
    {
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
    Object[] arrayOfObject = this.mParams;
    if ((arrayOfObject != null) && (paramInt >= 0) && (paramInt < arrayOfObject.length)) {
      return arrayOfObject[paramInt];
    }
    return null;
  }
  
  boolean hasFilterType(int paramInt)
  {
    int[] arrayOfInt = this.mFilters;
    if (arrayOfInt != null)
    {
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterManagerInternal.FilterChain
 * JD-Core Version:    0.7.0.1
 */