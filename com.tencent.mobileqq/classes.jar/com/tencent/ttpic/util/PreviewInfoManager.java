package com.tencent.ttpic.util;

import android.hardware.Camera.Size;
import com.tencent.ttpic.model.SizeI;
import java.util.Iterator;
import java.util.List;

public enum PreviewInfoManager
{
  INSTANCE;
  
  private List<Camera.Size> mAllPreviewSize;
  private SizeI mCameraPreviewSize;
  private SizeI mRecordSize;
  private SizeI mUISize;
  
  private PreviewInfoManager() {}
  
  public static PreviewInfoManager getInstance()
  {
    return INSTANCE;
  }
  
  public String getAllPreviewSizeString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.mAllPreviewSize == null) {
      return "";
    }
    Iterator localIterator = this.mAllPreviewSize.iterator();
    while (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      localStringBuilder.append("[" + localSize.width + ", " + localSize.height + "], ");
    }
    return localStringBuilder.toString();
  }
  
  public SizeI getCameraPreviewSize()
  {
    return this.mCameraPreviewSize;
  }
  
  public SizeI getRecordSize()
  {
    return this.mRecordSize;
  }
  
  public SizeI getUISize()
  {
    return this.mUISize;
  }
  
  public void setAllPreviewSize(List<Camera.Size> paramList)
  {
    this.mAllPreviewSize = paramList;
  }
  
  public void setCameraPreviewSize(SizeI paramSizeI)
  {
    this.mCameraPreviewSize = paramSizeI;
  }
  
  public void setRecordSize(SizeI paramSizeI)
  {
    this.mRecordSize = paramSizeI;
  }
  
  public void setUISize(SizeI paramSizeI)
  {
    this.mUISize = paramSizeI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.PreviewInfoManager
 * JD-Core Version:    0.7.0.1
 */