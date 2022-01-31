package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.TreeSet;

public class DanceBaseFilter
  extends QQBaseFilter
{
  protected DanceManagerFilter mDanceManager = null;
  
  public DanceBaseFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  public TreeSet<GLLittleBoy> getCurrentVisible()
  {
    return null;
  }
  
  public boolean getFilterParam()
  {
    return false;
  }
  
  public void onCloseClicked() {}
  
  public void rollbackStatusCallOnInitFilter() {}
  
  final void setDanceManager(DanceManagerFilter paramDanceManagerFilter)
  {
    this.mDanceManager = paramDanceManagerFilter;
  }
  
  public void setViewportSize(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceBaseFilter
 * JD-Core Version:    0.7.0.1
 */