package com.tencent.superplayer.api;

import java.util.ArrayList;
import java.util.Iterator;

public class TVideoNetInfo
{
  private TVideoNetInfo.DefinitionInfo mCurrentDefinition;
  private ArrayList<TVideoNetInfo.DefinitionInfo> mDefinitionList;
  private boolean mHasWatermark = false;
  private long mVideoDurationMs;
  private long mVideoSize;
  
  public TVideoNetInfo.DefinitionInfo getCurrentDefinition()
  {
    return this.mCurrentDefinition;
  }
  
  public String getCurrentDefinitionStr()
  {
    if (this.mCurrentDefinition != null) {
      return this.mCurrentDefinition.getDefn();
    }
    return "";
  }
  
  public ArrayList<TVideoNetInfo.DefinitionInfo> getDefinitionList()
  {
    return this.mDefinitionList;
  }
  
  public ArrayList<String> getDefinitionStrList()
  {
    if (this.mDefinitionList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mDefinitionList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((TVideoNetInfo.DefinitionInfo)localIterator.next()).getDefn());
    }
    return localArrayList;
  }
  
  public long getVideoDuration()
  {
    return this.mVideoDurationMs;
  }
  
  public long getVideoSize()
  {
    return this.mVideoSize;
  }
  
  public boolean isHasWatermark()
  {
    return this.mHasWatermark;
  }
  
  public void setCurrentDefinition(TVideoNetInfo.DefinitionInfo paramDefinitionInfo)
  {
    this.mCurrentDefinition = paramDefinitionInfo;
  }
  
  public void setDefinitionList(ArrayList<TVideoNetInfo.DefinitionInfo> paramArrayList)
  {
    this.mDefinitionList = paramArrayList;
  }
  
  public void setHasWatermark(boolean paramBoolean)
  {
    this.mHasWatermark = paramBoolean;
  }
  
  public void setVideoDuration(long paramLong)
  {
    this.mVideoDurationMs = paramLong;
  }
  
  public void setVideoSize(long paramLong)
  {
    this.mVideoSize = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.api.TVideoNetInfo
 * JD-Core Version:    0.7.0.1
 */