package com.tencent.mobileqq.flashshow.report.dc;

import NS_COMM.COMM.Entry;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.request.report.FSClientReportRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.requests.CommandReportRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTask;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import cooperation.qqcircle.report.outbox.SimpleTaskQueue;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import qqcircle.QQCircleReport.SingleDcData;

public class FSReporter
{
  private static volatile FSReporter a;
  private static final long c = TimeUnit.SECONDS.toMillis(FSConfig.d());
  private static final int d = FSConfig.e();
  private static final long e = TimeUnit.SECONDS.toMillis(FSConfig.f());
  private static final int f = FSConfig.g();
  private FSReporter.QCircleReportListener b;
  private final List<QQCircleReport.SingleDcData> g = new ArrayList();
  private final List<QQCircleReport.SingleDcData> h = new ArrayList();
  private final List<QQCircleReport.SingleDcData> i = new ArrayList();
  private final List<APP_REPORT_TRANSFER.SingleDcData> j = new ArrayList();
  private long k = System.currentTimeMillis();
  private long l = System.currentTimeMillis();
  private long m = System.currentTimeMillis();
  private final Handler n;
  
  private FSReporter()
  {
    HandlerThread localHandlerThread = new HandlerThread("flash_show_report");
    localHandlerThread.setPriority(10);
    localHandlerThread.start();
    this.n = new FSReporter.1(this, localHandlerThread.getLooper());
    b();
  }
  
  public static FSReporter a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSReporter();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(List<QQCircleReport.SingleDcData> paramList)
  {
    b(paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleReport.SingleDcData localSingleDcData = (QQCircleReport.SingleDcData)paramList.next();
      if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("perform video Data:");
        localStringBuilder.append(b(localSingleDcData));
        QLog.d("FSReporter", 2, localStringBuilder.toString());
      }
    }
    QLog.d("FSReporter", 2, "performVideoDataListReportToServer called");
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.n.hasMessages(4097))
    {
      if ((!paramBoolean) && (System.currentTimeMillis() - this.k > c * 10L)) {
        return;
      }
      this.n.sendEmptyMessageDelayed(4097, c);
    }
  }
  
  private static String b(APP_REPORT_TRANSFER.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null)
    {
      localStringBuilder.append("dcid:");
      localStringBuilder.append(paramSingleDcData.dcid.get());
      localStringBuilder.append(",report_data:{");
      Iterator localIterator = paramSingleDcData.report_data.get().iterator();
      while (localIterator.hasNext())
      {
        COMM.Entry localEntry = (COMM.Entry)localIterator.next();
        localStringBuilder.append(localEntry.key.get());
        localStringBuilder.append("=");
        localStringBuilder.append(localEntry.value.get());
        localStringBuilder.append(", ");
      }
      if (paramSingleDcData.extinfo.has())
      {
        localStringBuilder.append("},byteExtInfo:{");
        paramSingleDcData = paramSingleDcData.extinfo.get().iterator();
        while (paramSingleDcData.hasNext())
        {
          localStringBuilder.append(((COMM.Entry)paramSingleDcData.next()).key.get());
          localStringBuilder.append(", ");
        }
      }
      localStringBuilder.append("}\n");
    }
    return localStringBuilder.toString();
  }
  
  private static String b(QQCircleReport.SingleDcData paramSingleDcData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramSingleDcData != null)
    {
      localStringBuilder.append("dcid:");
      localStringBuilder.append(paramSingleDcData.dcid.get());
      localStringBuilder.append(",report_data:{");
      Iterator localIterator = paramSingleDcData.report_data.get().iterator();
      while (localIterator.hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)localIterator.next();
        localStringBuilder.append(localEntry.key.get());
        localStringBuilder.append("=");
        localStringBuilder.append(localEntry.value.get());
        localStringBuilder.append(", ");
      }
      if (paramSingleDcData.byteExtinfo.has())
      {
        localStringBuilder.append("},byteExtInfo:{");
        paramSingleDcData = paramSingleDcData.byteExtinfo.get().iterator();
        while (paramSingleDcData.hasNext())
        {
          localStringBuilder.append(((FeedCloudCommon.BytesEntry)paramSingleDcData.next()).key.get());
          localStringBuilder.append(", ");
        }
      }
      localStringBuilder.append("}\n");
    }
    return localStringBuilder.toString();
  }
  
  private void b(List<QQCircleReport.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new FSClientReportRequest(new ArrayList(paramList));
      if (!NetworkUtil.isNetworkAvailable(RFApplication.getApplication().getApplicationContext()))
      {
        QLog.d("FSReporter", 2, "performClientReport fail! network is not available,save in cache first");
        QCircleReportOutboxTaskQueue.getInstance().addPausedTask(new QCircleReportOutboxTask(paramList));
        return;
      }
      VSNetworkHelper.getInstance().sendRequest(RFApplication.getApplication(), paramList, new FSReporter.3(this));
    }
  }
  
  private void c(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      VSNetworkHelper.getInstance().sendRequest(new CommandReportRequest(paramList), new FSReporter.4(this));
    }
  }
  
  private void e()
  {
    this.k = System.currentTimeMillis();
    b(this.g);
    this.g.clear();
    QLog.d("FSReporter", 2, "performNormalDataListReportToServer called");
  }
  
  private void f()
  {
    b(this.h);
    this.h.clear();
    QLog.d("FSReporter", 2, "performImmediateDataListReportToServer called");
  }
  
  private void g()
  {
    this.l = System.currentTimeMillis();
    b(this.i);
    this.i.clear();
    QLog.d("FSReporter", 2, "performQualityDataListReportToServer called");
  }
  
  private void h()
  {
    this.m = System.currentTimeMillis();
    c(this.j);
    this.j.clear();
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
      QLog.d("FSReporter", 2, "performQualityDataListReportToServer called");
    }
  }
  
  private void i()
  {
    boolean bool;
    if ((this.g.size() <= 0) && (this.i.size() <= 0) && (this.j.size() <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    if (bool)
    {
      l();
      k();
      j();
    }
    a(bool);
  }
  
  private void j()
  {
    if ((System.currentTimeMillis() - this.m > e) || (this.j.size() >= f)) {
      h();
    }
  }
  
  private void k()
  {
    if ((System.currentTimeMillis() - this.l > e) || (this.i.size() >= f)) {
      g();
    }
  }
  
  private void l()
  {
    if ((System.currentTimeMillis() - this.k > c) || (this.g.size() >= d)) {
      e();
    }
  }
  
  private void m()
  {
    if (!this.n.hasMessages(4098)) {
      this.n.sendEmptyMessageDelayed(4098, 1000L);
    }
  }
  
  public void a(QQCircleReport.SingleDcData paramSingleDcData, boolean paramBoolean)
  {
    this.n.post(new FSReporter.5(this, paramSingleDcData, paramBoolean));
  }
  
  public void b()
  {
    this.n.postDelayed(new FSReporter.2(this), 10000L);
  }
  
  public Handler c()
  {
    return this.n;
  }
  
  public void d()
  {
    this.n.post(new FSReporter.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReporter
 * JD-Core Version:    0.7.0.1
 */