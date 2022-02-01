package com.tencent.qqlive.module.videoreport.report.keyboard;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.element.ReportHelper;
import com.tencent.qqlive.module.videoreport.report.element.ReversedDataCollector;
import com.tencent.qqlive.module.videoreport.reportdata.DataBuilderFactory;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.reportdata.IDataBuilder;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class KeyBoardEditorActionReporter
  extends DefaultEventListener
{
  private static final String TAG = "KeyBoardClickReporter";
  private static final HashMap<Integer, String> VALID_ACTION_MAP = new HashMap();
  
  static
  {
    VALID_ACTION_MAP.put(Integer.valueOf(6), "DONE");
    VALID_ACTION_MAP.put(Integer.valueOf(2), "GO");
    VALID_ACTION_MAP.put(Integer.valueOf(3), "SEARCH");
    VALID_ACTION_MAP.put(Integer.valueOf(4), "SEND");
  }
  
  private KeyBoardEditorActionReporter()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("KeyBoardClickReporter", "init ");
    }
  }
  
  public static KeyBoardEditorActionReporter getInstance()
  {
    return KeyBoardEditorActionReporter.InstanceHolder.access$000();
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
  }
  
  private boolean isValidAction(int paramInt)
  {
    return VALID_ACTION_MAP.containsKey(Integer.valueOf(paramInt));
  }
  
  public void onEditorAction(TextView paramTextView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = DataBinder.getDataEntity(paramTextView);
    if (paramKeyEvent == null)
    {
      if (VideoReportInner.getInstance().isDebugMode())
      {
        paramTextView = new StringBuilder();
        paramTextView.append("onEditorAction: dataEntity=");
        paramTextView.append(paramKeyEvent);
        Log.d("KeyBoardClickReporter", paramTextView.toString());
      }
      return;
    }
    if (!isValidAction(paramInt1))
    {
      if (VideoReportInner.getInstance().isDebugMode())
      {
        paramTextView = new StringBuilder();
        paramTextView.append("onEditorAction: isValidAction ");
        paramTextView.append(paramInt1);
        Log.d("KeyBoardClickReporter", paramTextView.toString());
      }
      return;
    }
    paramKeyEvent = ReversedDataCollector.collect(paramTextView);
    paramKeyEvent = DataBuilderFactory.obtain().build("dt_submit", paramKeyEvent);
    if (paramKeyEvent == null) {
      return;
    }
    paramKeyEvent.setEventKey("dt_submit");
    paramKeyEvent.put("dt_submit_type", VALID_ACTION_MAP.get(Integer.valueOf(paramInt1)));
    paramKeyEvent.put("dt_submit_way", Integer.valueOf(paramInt2));
    IEventDynamicParams localIEventDynamicParams = VideoReportInner.getInstance().getEventDynamicParams();
    if (localIEventDynamicParams != null) {
      localIEventDynamicParams.setEventDynamicParams("dt_submit", paramKeyEvent.getEventParams());
    }
    FinalDataTarget.handle(paramTextView, paramKeyEvent);
  }
  
  public void onViewClick(View paramView)
  {
    DataEntity localDataEntity = DataBinder.getDataEntity(paramView);
    if ((localDataEntity != null) && (ReportHelper.reportClick(localDataEntity)))
    {
      paramView = DataRWProxy.getExtendParam(paramView, "submitTarget");
      if ((paramView instanceof WeakReference)) {
        paramView = ((WeakReference)paramView).get();
      } else {
        paramView = null;
      }
      if (!(paramView instanceof TextView)) {
        return;
      }
      paramView = (TextView)paramView;
      int j = paramView.getImeOptions();
      int i = j;
      if (j == 0) {
        i = 6;
      }
      onEditorAction(paramView, i, null, 2);
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramView = new StringBuilder();
      paramView.append("onViewClick: dataEntity=");
      paramView.append(localDataEntity);
      Log.d("KeyBoardClickReporter", paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.keyboard.KeyBoardEditorActionReporter
 * JD-Core Version:    0.7.0.1
 */