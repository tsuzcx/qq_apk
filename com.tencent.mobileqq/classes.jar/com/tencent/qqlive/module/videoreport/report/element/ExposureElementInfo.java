package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import java.lang.ref.WeakReference;

public class ExposureElementInfo
{
  private boolean mCanReport = true;
  private FinalData mFinalData;
  private String mIdentifier;
  private WeakReference<Object> mPage;
  private PathData mPathData;
  private long mUniqueId;
  private WeakReference<View> mView;
  
  public ExposureElementInfo() {}
  
  public ExposureElementInfo(View paramView, Object paramObject, FinalData paramFinalData, PathData paramPathData)
  {
    setView(paramView);
    setPage(paramObject);
    setFinalData(paramFinalData);
    setPathData(paramPathData);
  }
  
  public boolean canReport()
  {
    return this.mCanReport;
  }
  
  public FinalData getFinalData()
  {
    return this.mFinalData;
  }
  
  public String getIdentifier()
  {
    return this.mIdentifier;
  }
  
  @Nullable
  public Object getPage()
  {
    WeakReference localWeakReference = this.mPage;
    if (localWeakReference != null) {
      return localWeakReference.get();
    }
    return null;
  }
  
  public PathData getPathData()
  {
    return this.mPathData;
  }
  
  public long getUniqueId()
  {
    return this.mUniqueId;
  }
  
  @Nullable
  public View getView()
  {
    WeakReference localWeakReference = this.mView;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public void setCanReport(boolean paramBoolean)
  {
    this.mCanReport = paramBoolean;
  }
  
  public void setFinalData(FinalData paramFinalData)
  {
    this.mFinalData = paramFinalData;
  }
  
  public void setIdentifier(String paramString)
  {
    this.mIdentifier = paramString;
  }
  
  public void setPage(Object paramObject)
  {
    this.mPage = new WeakReference(paramObject);
  }
  
  public void setPathData(PathData paramPathData)
  {
    this.mPathData = paramPathData;
  }
  
  public void setUniqueId(long paramLong)
  {
    this.mUniqueId = paramLong;
  }
  
  public void setView(View paramView)
  {
    this.mView = new WeakReference(paramView);
  }
  
  public String toString()
  {
    Object localObject = this.mView;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (View)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return "_null_view_";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniqueId = ");
    localStringBuilder.append(this.mUniqueId);
    localStringBuilder.append(", identifier = ");
    localStringBuilder.append(this.mIdentifier);
    localStringBuilder.append(", eid = ");
    localStringBuilder.append(DataRWProxy.getElementId(localObject));
    localStringBuilder.append(", ");
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ExposureElementInfo
 * JD-Core Version:    0.7.0.1
 */