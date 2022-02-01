package com.tencent.qqlive.module.videoreport.report;

import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ProcessUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EventStatisticsManager
{
  private static final String EVENT_GROUP_OF_APP = "app";
  private static final String KEY_SEQ_TIME = "key_seqtime";
  private static final long MAX_COUNT_VALUE = 300000L;
  private static final int MSG_SAVE_DATA = 1;
  private static final String SP_NAME = "SP_seq_";
  private static final String TAG = "EventStatisticsManager";
  private static Map<String, String> sEventIdGroup;
  private static volatile EventStatisticsManager sInstance;
  private static final Object sLockEventGroupCount = new Object();
  private Map<String, Long> mEventCountMap = new HashMap();
  private Handler mHandler = new EventStatisticsManager.1(this, Looper.getMainLooper());
  private long mSeqTime = 0L;
  private String mSpName = "";
  
  static
  {
    sEventIdGroup = new HashMap();
    sEventIdGroup.put("act", "app");
    sEventIdGroup.put("appin", "app");
    sEventIdGroup.put("appout", "app");
    sEventIdGroup.put("vst", "app");
    sEventIdGroup.put("origin_vst", "app");
  }
  
  private EventStatisticsManager()
  {
    init();
  }
  
  public static EventStatisticsManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new EventStatisticsManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private long getMaxCountValue()
  {
    return 300000L;
  }
  
  private void init()
  {
    String str = ProcessUtils.getProcessName(ReportUtils.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_seq_");
    localStringBuilder.append(str);
    this.mSpName = localStringBuilder.toString();
    this.mSeqTime = ((Integer)SPUtils.get(ReportUtils.getContext(), this.mSpName, "key_seqtime", Integer.valueOf(0))).intValue();
    if (this.mSeqTime == 0L) {
      this.mSeqTime = (System.currentTimeMillis() / 1000L);
    }
    this.mEventCountMap.put("key_seqtime", Long.valueOf(this.mSeqTime));
  }
  
  private void saveData()
  {
    synchronized (sLockEventGroupCount)
    {
      SharedPreferences.Editor localEditor = SPUtils.getEdit(ReportUtils.getContext(), this.mSpName);
      Iterator localIterator = this.mEventCountMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString(str, String.valueOf(this.mEventCountMap.get(str)));
      }
      localEditor.apply();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void addStatisticsInnerParam(String paramString1, String arg2, Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    String str1 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str1 = "";
    }
    String str2 = (String)BaseUtils.nullAs(sEventIdGroup.get(???), ???);
    try
    {
      synchronized (sLockEventGroupCount)
      {
        paramString1 = new StringBuilder();
        paramString1.append(str1);
        paramString1.append("_");
        paramString1.append(this.mSeqTime);
        paramString1.append("_");
        paramString1.append(str2);
        paramString1 = paramString1.toString();
        if (this.mEventCountMap.containsKey(paramString1)) {
          l1 = ((Long)this.mEventCountMap.get(paramString1)).longValue();
        } else {
          l1 = ((Long)SPUtils.get(ReportUtils.getContext(), this.mSpName, paramString1, Long.valueOf(0L))).longValue();
        }
        long l2 = l1 + 1L;
        long l1 = l2;
        if (l2 > getMaxCountValue())
        {
          this.mSeqTime = (System.currentTimeMillis() / 1000L);
          this.mEventCountMap.put("key_seqtime", Long.valueOf(this.mSeqTime));
          paramString1 = new StringBuilder();
          paramString1.append(str1);
          paramString1.append("_");
          paramString1.append(this.mSeqTime);
          paramString1.append("_");
          paramString1.append(str2);
          paramString1 = paramString1.toString();
          l1 = 1L;
        }
        this.mEventCountMap.put(paramString1, Long.valueOf(l1));
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 500L);
        paramMap.put("dt_seqid", Long.valueOf(l1));
        paramMap.put("dt_seqtime", Long.valueOf(this.mSeqTime));
      }
    }
    catch (Exception paramString1)
    {
      paramMap = new StringBuilder();
      paramMap.append("getEventCount error ");
      paramMap.append(paramString1);
      Log.e("EventStatisticsManager", paramMap.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.EventStatisticsManager
 * JD-Core Version:    0.7.0.1
 */