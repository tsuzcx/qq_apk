package com.tencent.qqlive.module.videoreport.report.element;

import android.os.SystemClock;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import com.tencent.qqlive.module.videoreport.reportdata.PathData;
import java.util.WeakHashMap;

public class ElementClickReporter
  extends DefaultEventListener
{
  private static final String TAG = "ElementClickReporter";
  private WeakHashMap<View, Long> mClickTimeMap = new WeakHashMap();
  
  private ElementClickReporter()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ElementClickReporter", "init ");
    }
  }
  
  public static ElementClickReporter getInstance()
  {
    return ElementClickReporter.InstanceHolder.access$000();
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private boolean isValidClick(DataEntity paramDataEntity, View paramView)
  {
    Long localLong = (Long)this.mClickTimeMap.get(paramView);
    boolean bool = true;
    if (localLong != null)
    {
      long l = SystemClock.uptimeMillis();
      paramView = (Long)DataEntityOperator.getInnerParam(paramDataEntity, "click_interval");
      paramDataEntity = paramView;
      if (paramView == null) {
        paramDataEntity = Long.valueOf(VideoReportInner.getInstance().getConfiguration().getClickReportInterval());
      }
      if (l > localLong.longValue() + paramDataEntity.longValue()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void onViewClick(View paramView)
  {
    Object localObject = DataBinder.getDataEntity(paramView);
    if ((localObject != null) && (ReportHelper.reportClick((DataEntity)localObject)))
    {
      if (!isValidClick((DataEntity)localObject, paramView))
      {
        if (VideoReportInner.getInstance().isDebugMode()) {
          Log.d("ElementClickReporter", "onViewClick: not valid click ");
        }
        return;
      }
      this.mClickTimeMap.put(paramView, Long.valueOf(SystemClock.uptimeMillis()));
      if (VideoReportInner.getInstance().isDebugMode())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onViewClick: view=");
        ((StringBuilder)localObject).append(paramView);
        Log.d("ElementClickReporter", ((StringBuilder)localObject).toString());
      }
      localObject = ReversedDataCollector.collect(paramView);
      if (localObject == null) {
        return;
      }
      localObject = DataBuilderFactory.obtain().build("clck", (PathData)localObject);
      if (localObject == null) {
        return;
      }
      ((FinalData)localObject).setEventKey("clck");
      IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
      if (localIEventDynamicParams != null) {
        localIEventDynamicParams.setEventDynamicParams("clck", ((FinalData)localObject).getEventParams());
      }
      FinalDataTarget.handle(paramView, (FinalData)localObject);
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramView = new StringBuilder();
      paramView.append("onViewClick: dataEntity=");
      paramView.append(localObject);
      Log.d("ElementClickReporter", paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementClickReporter
 * JD-Core Version:    0.7.0.1
 */