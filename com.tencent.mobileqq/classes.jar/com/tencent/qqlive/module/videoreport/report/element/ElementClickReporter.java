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
    if (localLong != null)
    {
      long l1 = SystemClock.uptimeMillis();
      paramView = (Long)DataEntityOperator.getInnerParam(paramDataEntity, "click_interval");
      paramDataEntity = paramView;
      if (paramView == null) {
        paramDataEntity = Long.valueOf(VideoReportInner.getInstance().getConfiguration().getClickReportInterval());
      }
      long l2 = localLong.longValue();
      return l1 > paramDataEntity.longValue() + l2;
    }
    return true;
  }
  
  public void onViewClick(View paramView)
  {
    Object localObject = DataBinder.getDataEntity(paramView);
    if ((localObject == null) || (!ReportHelper.reportClick((DataEntity)localObject))) {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("ElementClickReporter", "onViewClick: dataEntity=" + localObject);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (isValidClick((DataEntity)localObject, paramView)) {
            break;
          }
        } while (!VideoReportInner.getInstance().isDebugMode());
        Log.d("ElementClickReporter", "onViewClick: not valid click ");
        return;
        this.mClickTimeMap.put(paramView, Long.valueOf(SystemClock.uptimeMillis()));
        if (VideoReportInner.getInstance().isDebugMode()) {
          Log.d("ElementClickReporter", "onViewClick: view=" + paramView);
        }
        localObject = ReversedDataCollector.collect(paramView);
      } while (localObject == null);
      localObject = DataBuilderFactory.obtain().build((PathData)localObject);
    } while (localObject == null);
    ((FinalData)localObject).setEventKey("clck");
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("clck", ((FinalData)localObject).getEventParams());
    }
    FinalDataTarget.handle(paramView, (FinalData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementClickReporter
 * JD-Core Version:    0.7.0.1
 */