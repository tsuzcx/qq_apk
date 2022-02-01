package com.tencent.qqlive.module.videoreport.report.element;

import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import java.lang.ref.WeakReference;

public class ExposureElementInfo
{
  private boolean mCanReport = true;
  private FinalData mFinalData;
  private String mIdentifier;
  private WeakReference<Object> mPage;
  private long mUniqueId;
  private WeakReference<View> mView;
  
  public ExposureElementInfo() {}
  
  public ExposureElementInfo(View paramView, Object paramObject, FinalData paramFinalData)
  {
    setView(paramView);
    setPage(paramObject);
    setFinalData(paramFinalData);
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
    if (this.mPage != null) {
      return this.mPage.get();
    }
    return null;
  }
  
  public long getUniqueId()
  {
    return this.mUniqueId;
  }
  
  @Nullable
  public View getView()
  {
    if (this.mView != null) {
      return (View)this.mView.get();
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
    if (this.mView == null) {}
    for (View localView = null; localView == null; localView = (View)this.mView.get()) {
      return "_null_view_";
    }
    return "uniqueId = " + this.mUniqueId + ", identifier = " + this.mIdentifier + ", eid = " + DataRWProxy.getElementId(localView) + ", " + localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ExposureElementInfo
 * JD-Core Version:    0.7.0.1
 */