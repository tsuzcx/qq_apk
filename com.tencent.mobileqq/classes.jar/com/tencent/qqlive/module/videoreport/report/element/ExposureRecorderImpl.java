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
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ExposureRecorderImpl", "isExposed: uniqueId = " + paramLong + ", contains = " + bool);
    }
    return bool;
  }
  
  public void markExposed(ExposureElementInfo paramExposureElementInfo)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ExposureRecorderImpl", "markExposed: exposureElementInfo = " + paramExposureElementInfo);
    }
    if (paramExposureElementInfo == null) {}
    View localView;
    do
    {
      return;
      localView = paramExposureElementInfo.getView();
    } while (localView == null);
    long l = ReportUtils.calcElementUniqueId(localView);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ExposureRecorderImpl", "markExposed: identifier = " + DataRWProxy.getInnerParam(localView, "element_identifier") + "， uniqueId = " + l);
    }
    this.mExposedId.put(Long.valueOf(l), new IExposureRecorder.ExposureInfoWrapper(paramExposureElementInfo, SystemClock.elapsedRealtime()));
  }
  
  public void markUnexposed(long paramLong)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ExposureRecorderImpl", "markUnexposed: target = " + paramLong);
    }
    removeRecords(paramLong);
  }
  
  public void markUnexposed(Collection<Long> paramCollection)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ExposureRecorderImpl", "markUnexposed: targets=" + paramCollection);
    }
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Long localLong = (Long)paramCollection.next();
        if (localLong != null) {
          removeRecords(localLong.longValue());
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
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ExposureRecorderImpl", "updateAreaInfo: uniqueId = " + paramLong + ", areaInfo = " + paramAreaInfo);
    }
    IExposureRecorder.ExposureInfoWrapper localExposureInfoWrapper = (IExposureRecorder.ExposureInfoWrapper)this.mExposedId.get(Long.valueOf(paramLong));
    if (localExposureInfoWrapper == null) {}
    AreaInfo localAreaInfo;
    do
    {
      return;
      localAreaInfo = localExposureInfoWrapper.areaInfo;
    } while ((localAreaInfo != null) && (localAreaInfo.exposureRate > paramAreaInfo.exposureRate));
    localExposureInfoWrapper.areaInfo = paramAreaInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ExposureRecorderImpl
 * JD-Core Version:    0.7.0.1
 */