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
    Log.i("OnInfoTaskManager", "doTask playerState=" + paramInt1 + " ,playerObject" + paramObject + " ,what" + paramInt2);
    VideoReportFlowInfo localVideoReportFlowInfo = VideoReportManager.getInstance().getVideoReportFlowInfo(Integer.valueOf(paramObject.hashCode()));
    if (localVideoReportFlowInfo == null) {
      Log.w("OnInfoTaskManager", "OnInfoTaskManager doTask flowInfo is null, ptr=" + paramObject);
    }
    IOnInfoTask localIOnInfoTask;
    do
    {
      return;
      localIOnInfoTask = (IOnInfoTask)this.onInfoTaskMap.get(paramInt2);
    } while (localIOnInfoTask == null);
    localIOnInfoTask.setExtraParams(paramInt1, localVideoReportFlowInfo);
    localIOnInfoTask.doTask(paramObject, paramInt2, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.OnInfoTaskManager
 * JD-Core Version:    0.7.0.1
 */