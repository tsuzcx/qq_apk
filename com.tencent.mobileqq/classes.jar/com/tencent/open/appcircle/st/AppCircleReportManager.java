package com.tencent.open.appcircle.st;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.common.NetworkState.NetworkStateListener;
import com.tencent.open.agent.report.ReportDatabaseHelper;
import com.tencent.open.appcircle.module.StatReportHttpEngine;
import com.tencent.open.appcircle.module.StatReportHttpEngine.IStatReportListener;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.common.jce.StatItem;
import com.tencent.tmassistant.common.jce.StatReportRequest;
import com.tencent.tmassistant.common.jce.StatReportResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppCircleReportManager
  implements NetworkState.NetworkStateListener, StatReportHttpEngine.IStatReportListener
{
  private static AppCircleReportManager a;
  private StatReportHttpEngine b = new StatReportHttpEngine();
  private Handler c;
  private SparseArray<ArrayList<StatItem>> d = new SparseArray();
  private SparseArray<ArrayList<StatItem>> e = new SparseArray();
  private Map<Integer, ArrayList<String>> f = new ConcurrentHashMap();
  private long g = 1800000L;
  
  private AppCircleReportManager()
  {
    this.b.a(this);
    b();
  }
  
  public static AppCircleReportManager a()
  {
    try
    {
      if (a == null) {
        a = new AppCircleReportManager();
      }
      AppCircleReportManager localAppCircleReportManager = a;
      return localAppCircleReportManager;
    }
    finally {}
  }
  
  private void b()
  {
    HandlerThread localHandlerThread = new HandlerThread("thread_report");
    localHandlerThread.start();
    this.c = new AppCircleReportManager.1(this, localHandlerThread.getLooper());
    this.c.sendEmptyMessage(2);
  }
  
  public void a(int paramInt, DownloadInfo paramDownloadInfo)
  {
    int i;
    if (BaseApplicationImpl.sProcessId == 7) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramDownloadInfo != null)
    {
      if (i == 0) {
        return;
      }
      long l = System.currentTimeMillis() / 1000L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDownloadInfo.c);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDownloadInfo.n);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDownloadInfo.e);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDownloadInfo.o);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDownloadInfo.E);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDownloadInfo.h);
      a(9, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt1, StatReportRequest paramStatReportRequest, StatReportResponse paramStatReportResponse, int paramInt2)
  {
    paramStatReportRequest = new StringBuilder();
    paramStatReportRequest.append("circleTest reportLog onReportFinish errorCode = ");
    paramStatReportRequest.append(paramInt2);
    Log.i("selfupdeReport", paramStatReportRequest.toString());
    paramStatReportRequest = (ArrayList)this.d.get(paramInt1);
    int j = 0;
    int i;
    if (paramStatReportRequest == null)
    {
      paramStatReportRequest = (ArrayList)this.e.get(paramInt1);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (paramInt2 != 0)
    {
      if ((paramStatReportRequest != null) && (paramStatReportRequest.size() > 0) && (i == 0))
      {
        SparseArray localSparseArray = new SparseArray();
        Iterator localIterator = paramStatReportRequest.iterator();
        while (localIterator.hasNext())
        {
          StatItem localStatItem = (StatItem)localIterator.next();
          paramStatReportResponse = (List)localSparseArray.get(localStatItem.type);
          paramStatReportRequest = paramStatReportResponse;
          if (paramStatReportResponse == null)
          {
            paramStatReportRequest = new ArrayList();
            localSparseArray.put(localStatItem.type, paramStatReportRequest);
          }
          paramStatReportRequest.addAll(localStatItem.records);
        }
        i = localSparseArray.size();
        paramInt2 = j;
        while (paramInt2 < i)
        {
          j = localSparseArray.keyAt(paramInt2);
          paramStatReportResponse = (List)localSparseArray.get(j);
          paramStatReportRequest = new ArrayList();
          paramStatReportResponse = paramStatReportResponse.iterator();
          while (paramStatReportResponse.hasNext()) {
            paramStatReportRequest.add((String)paramStatReportResponse.next());
          }
          paramStatReportResponse = ReportDatabaseHelper.a().a(String.valueOf(j));
          if (paramStatReportResponse != null) {
            paramStatReportRequest.addAll(paramStatReportResponse);
          }
          ReportDatabaseHelper.a().a(String.valueOf(j), paramStatReportRequest);
          paramInt2 += 1;
        }
      }
    }
    else if ((i != 0) && (paramStatReportRequest != null) && (paramStatReportRequest.size() > 0))
    {
      paramStatReportRequest = paramStatReportRequest.iterator();
      while (paramStatReportRequest.hasNext())
      {
        paramStatReportResponse = (StatItem)paramStatReportRequest.next();
        ReportDatabaseHelper.a().c(String.valueOf(paramStatReportResponse.type));
      }
    }
    this.d.delete(paramInt1);
    this.e.delete(paramInt1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (!TextUtils.isEmpty(paramString)))
    {
      ArrayList localArrayList2 = (ArrayList)this.f.get(Integer.valueOf(paramInt));
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.f.put(Integer.valueOf(paramInt), localArrayList1);
      }
      localArrayList1.add(paramString);
      this.c.removeMessages(1);
      this.c.sendEmptyMessageDelayed(1, 500L);
    }
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.c.hasMessages(2)) {
        this.c.sendEmptyMessage(2);
      }
    }
    else if (this.c.hasMessages(2)) {
      this.c.removeMessages(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcircle.st.AppCircleReportManager
 * JD-Core Version:    0.7.0.1
 */