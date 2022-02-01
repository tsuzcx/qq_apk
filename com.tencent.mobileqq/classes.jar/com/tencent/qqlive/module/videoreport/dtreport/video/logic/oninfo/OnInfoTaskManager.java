package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils;

public class OnInfoTaskManager
{
  private static final String TAG = "OnInfoTaskManager";
  private SparseArray<IOnInfoTask> onInfoTaskMap = new SparseArray();
  
  public OnInfoTaskManager()
  {
    Log.i("OnInfoTaskManager", "create OnInfoTaskManager!");
    init();
  }
  
  private int getKey(int paramInt)
  {
    return VideoReportPlayerUtils.convertEventIdToPlayer(paramInt);
  }
  
  private void init()
  {
    this.onInfoTaskMap.put(getKey(1), new BufferStartTask());
    this.onInfoTaskMap.put(getKey(2), new BufferEndTask());
    this.onInfoTaskMap.put(getKey(5), new LoopStartTask());
    this.onInfoTaskMap.put(getKey(6), new LoopEndTask());
  }
  
  public void doTask(int paramInt1, Object paramObject, int paramInt2, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doTask playerState=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" ,playerObject");
    ((StringBuilder)localObject).append(paramObject);
    ((StringBuilder)localObject).append(" ,what");
    ((StringBuilder)localObject).append(paramInt2);
    Log.i("OnInfoTaskManager", ((StringBuilder)localObject).toString());
    localObject = VideoReportManager.getInstance().getVideoReportFlowInfo(Integer.valueOf(paramObject.hashCode()));
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnInfoTaskManager doTask flowInfo is null, ptr=");
      ((StringBuilder)localObject).append(paramObject);
      Log.w("OnInfoTaskManager", ((StringBuilder)localObject).toString());
      return;
    }
    IOnInfoTask localIOnInfoTask = (IOnInfoTask)this.onInfoTaskMap.get(paramInt2);
    if (localIOnInfoTask != null)
    {
      localIOnInfoTask.setExtraParams(paramInt1, (VideoReportFlowInfo)localObject);
      localIOnInfoTask.doTask(paramObject, paramInt2, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.OnInfoTaskManager
 * JD-Core Version:    0.7.0.1
 */