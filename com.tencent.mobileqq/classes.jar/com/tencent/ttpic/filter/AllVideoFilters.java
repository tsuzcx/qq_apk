package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.filter.RenderItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllVideoFilters
{
  private List<VideoFilterBase> mFilters = new ArrayList();
  private List<RenderItem> mRenderItems = new ArrayList();
  
  public void add(VideoFilterBase paramVideoFilterBase)
  {
    if (checkIsNull(paramVideoFilterBase))
    {
      reportNullFilter(paramVideoFilterBase);
      return;
    }
    this.mFilters.add(paramVideoFilterBase);
  }
  
  public void add(RenderItem paramRenderItem)
  {
    if (checkIsNull(paramRenderItem))
    {
      reportNullFilter(paramRenderItem);
      return;
    }
    this.mRenderItems.add(paramRenderItem);
  }
  
  public void addAll(List<? extends VideoFilterBase> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)paramList.next();
      if (localVideoFilterBase == null) {
        reportNullFilter(localVideoFilterBase);
      } else {
        this.mFilters.add(localVideoFilterBase);
      }
    }
  }
  
  public void addRenderItems(List<RenderItem> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RenderItem localRenderItem = (RenderItem)paramList.next();
      if (checkIsNull(localRenderItem)) {
        reportNullFilter(localRenderItem);
      } else {
        this.mRenderItems.add(localRenderItem);
      }
    }
  }
  
  public boolean checkIsNull(VideoFilterBase paramVideoFilterBase)
  {
    return paramVideoFilterBase == null;
  }
  
  public boolean checkIsNull(RenderItem paramRenderItem)
  {
    return (paramRenderItem == null) || (paramRenderItem.filter == null);
  }
  
  public List<RenderItem> getRenderItems()
  {
    return this.mRenderItems;
  }
  
  public List<VideoFilterBase> getmFilters()
  {
    return this.mFilters;
  }
  
  public void reportNullFilter(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    localStringBuffer.append("filter: ").append(paramVideoFilterBase.getClass());
    localStringBuffer.append("\nclass: ").append(arrayOfStackTraceElement[1].getClassName()).append("; method: ").append(arrayOfStackTraceElement[1].getMethodName()).append("; number: ").append(arrayOfStackTraceElement[1].getLineNumber());
    localStringBuffer.append(" \nclass: ").append(arrayOfStackTraceElement[2].getClassName()).append("; method: ").append(arrayOfStackTraceElement[2].getMethodName()).append("; number: ").append(arrayOfStackTraceElement[2].getLineNumber());
    LogUtils.d("filter is null:", localStringBuffer.toString());
  }
  
  public void reportNullFilter(RenderItem paramRenderItem)
  {
    if ((paramRenderItem == null) || (paramRenderItem.filter == null)) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    localStringBuffer.append("filter: ").append(paramRenderItem.filter.getClass());
    localStringBuffer.append("\nclass: ").append(arrayOfStackTraceElement[1].getClassName()).append("; method: ").append(arrayOfStackTraceElement[1].getMethodName()).append("; number: ").append(arrayOfStackTraceElement[1].getLineNumber());
    localStringBuffer.append(" \nclass: ").append(arrayOfStackTraceElement[2].getClassName()).append("; method: ").append(arrayOfStackTraceElement[2].getMethodName()).append("; number: ").append(arrayOfStackTraceElement[2].getLineNumber());
    LogUtils.d("filter is null:", localStringBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.AllVideoFilters
 * JD-Core Version:    0.7.0.1
 */