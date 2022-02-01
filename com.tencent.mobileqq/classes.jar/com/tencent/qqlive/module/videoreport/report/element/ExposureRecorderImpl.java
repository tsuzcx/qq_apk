package com.tencent.qqlive.module.videoreport.report.element;

import android.os.SystemClock;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.exposure.AreaInfo;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class ExposureRecorderImpl
  implements IExposureRecorder
{
  private static final String TAG = "ExposureRecorderImpl";
  private final Map<Long, IExposureRecorder.ExposureInfoWrapper> mExposedId = new HashMap();
  private ListenerMgr<IExposureRecorder.OnExposureStatusListener> mListenerMgr = new ListenerMgr();
  private final Map<Long, IExposureRecorder.ExposureInfoWrapper> mUnmodifiableExposedId = Collections.unmodifiableMap(this.mExposedId);
  
  public static ExposureRecorderImpl getInstance()
  {
    return ExposureRecorderImpl.InstanceHolder.access$000();
  }
  
  private void removeRecords(long paramLong)
  {
    IExposureRecorder.ExposureInfoWrapper localExposureInfoWrapper = (IExposureRecorder.ExposureInfoWrapper)this.mExposedId.remove(Long.valueOf(paramLong));
    if (localExposureInfoWrapper == null) {
      return;
    }
    paramLong = localExposureInfoWrapper.exposureTime;
    long l = SystemClock.elapsedRealtime();
    this.mListenerMgr.startNotify(new ExposureRecorderImpl.1(this, localExposureInfoWrapper, l - paramLong));
  }
  
  public void clearExposure()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ExposureRecorderImpl", "clearExposure: ");
    }
    markUnexposed(new HashSet(this.mExposedId.keySet()));
  }
  
  public Map<Long, IExposureRecorder.ExposureInfoWrapper> getExposedRecords()
  {
    return this.mUnmodifiableExposedId;
  }
  
  public boolean isExposed(long paramLong)
  {
    boolean bool = this.mExposedId.containsKey(Long.valueOf(paramLong));
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isExposed: uniqueId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", contains = ");
      localStringBuilder.append(bool);
      Log.d("ExposureRecorderImpl", localStringBuilder.toString());
    }
    return bool;
  }
  
  public void markExposed(ExposureElementInfo paramExposureElementInfo)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("markExposed: exposureElementInfo = ");
      ((StringBuilder)localObject).append(paramExposureElementInfo);
      Log.d("ExposureRecorderImpl", ((StringBuilder)localObject).toString());
    }
    if (paramExposureElementInfo == null) {
      return;
    }
    Object localObject = paramExposureElementInfo.getView();
    if (localObject == null) {
      return;
    }
    long l = ReportUtils.calcElementUniqueId((View)localObject);
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markExposed: identifier = ");
      localStringBuilder.append(DataRWProxy.getInnerParam(localObject, "element_identifier"));
      localStringBuilder.append("， uniqueId = ");
      localStringBuilder.append(l);
      Log.d("ExposureRecorderImpl", localStringBuilder.toString());
    }
    this.mExposedId.put(Long.valueOf(l), new IExposureRecorder.ExposureInfoWrapper(paramExposureElementInfo, SystemClock.elapsedRealtime()));
  }
  
  public void markUnexposed(long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("markUnexposed: target = ");
      localStringBuilder.append(paramLong);
      Log.d("ExposureRecorderImpl", localStringBuilder.toString());
    }
    removeRecords(paramLong);
  }
  
  public void markUnexposed(Collection<Long> paramCollection)
  {
    Object localObject;
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("markUnexposed: targets=");
      ((StringBuilder)localObject).append(paramCollection);
      Log.d("ExposureRecorderImpl", ((StringBuilder)localObject).toString());
    }
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        localObject = (Long)paramCollection.next();
        if (localObject != null) {
          removeRecords(((Long)localObject).longValue());
        }
      }
    }
  }
  
  public void registerOnExposureStatusListener(IExposureRecorder.OnExposureStatusListener paramOnExposureStatusListener)
  {
    this.mListenerMgr.register(paramOnExposureStatusListener);
  }
  
  public void updateAreaInfo(long paramLong, AreaInfo paramAreaInfo)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAreaInfo: uniqueId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", areaInfo = ");
      ((StringBuilder)localObject).append(paramAreaInfo);
      Log.d("ExposureRecorderImpl", ((StringBuilder)localObject).toString());
    }
    Object localObject = (IExposureRecorder.ExposureInfoWrapper)this.mExposedId.get(Long.valueOf(paramLong));
    if (localObject == null) {
      return;
    }
    AreaInfo localAreaInfo = ((IExposureRecorder.ExposureInfoWrapper)localObject).areaInfo;
    if ((localAreaInfo != null) && (localAreaInfo.exposureRate > paramAreaInfo.exposureRate)) {
      return;
    }
    ((IExposureRecorder.ExposureInfoWrapper)localObject).areaInfo = paramAreaInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ExposureRecorderImpl
 * JD-Core Version:    0.7.0.1
 */