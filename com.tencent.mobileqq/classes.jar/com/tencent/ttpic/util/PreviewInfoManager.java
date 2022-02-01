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
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = this.mAllPreviewSize;
    if (localObject == null) {
      return "";
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[");
      localStringBuilder2.append(localSize.width);
      localStringBuilder2.append(", ");
      localStringBuilder2.append(localSize.height);
      localStringBuilder2.append("], ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.PreviewInfoManager
 * JD-Core Version:    0.7.0.1
 */