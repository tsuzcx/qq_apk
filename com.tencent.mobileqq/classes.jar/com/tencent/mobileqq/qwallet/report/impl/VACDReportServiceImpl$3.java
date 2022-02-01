package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class VACDReportServiceImpl$3
  extends Handler
{
  VACDReportServiceImpl$3(VACDReportServiceImpl paramVACDReportServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    Object localObject1 = (Object[])???.obj;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("reportThread. handleMessage msg.arg1=");
      ((StringBuilder)???).append(???.arg1);
      QLog.i("VACDReport", 2, ((StringBuilder)???).toString());
    }
    int i = ???.arg1;
    long l;
    label359:
    Object localObject6;
    ReportInfo localReportInfo;
    Object localObject3;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            synchronized (VACDReportServiceImpl.access$000())
            {
              l = ((Long)localObject1[0]).longValue();
              ??? = (ReportItem)localObject1[1];
              localObject1 = (ReportInfo)VACDReportServiceImpl.access$100(this.a).get(Long.valueOf(l));
              if (localObject1 == null)
              {
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("send report. seqno=");
                  ((StringBuilder)localObject1).append(l);
                  ((StringBuilder)localObject1).append(" is illegal, step:");
                  if (??? == null) {
                    break label1693;
                  }
                  ??? = ???.step;
                  ((StringBuilder)localObject1).append(???);
                  QLog.d("VACDReport", 2, ((StringBuilder)localObject1).toString());
                }
                return;
              }
              if ((((ReportInfo)localObject1).header != null) && (((ReportInfo)localObject1).body != null))
              {
                if (((ReportInfo)localObject1).body.reportItems == null) {
                  ((ReportInfo)localObject1).body.reportItems = new ArrayList();
                }
                ((ReportInfo)localObject1).header.totalTime = Math.abs(???.createTime - ((ReportInfo)localObject1).header.createTime);
                ((ReportInfo)localObject1).body.totalTime = ((ReportInfo)localObject1).header.totalTime;
                VACDReportServiceImpl.access$300(this.a, 0);
                return;
              }
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("send report. seqno=");
                ((StringBuilder)localObject1).append(l);
                ((StringBuilder)localObject1).append(" is illegal, step:");
                if (??? == null) {
                  break label1699;
                }
                ??? = ???.step;
                ((StringBuilder)localObject1).append(???);
                QLog.d("VACDReport", 2, ((StringBuilder)localObject1).toString());
              }
              return;
            }
          }
          synchronized (VACDReportServiceImpl.access$000())
          {
            ??? = (ReportHeader)localObject1[1];
            if ((ReportInfo)VACDReportServiceImpl.access$100(this.a).get(Long.valueOf(((ReportHeader)???).seqno)) != null)
            {
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("single report seqno=");
                ((StringBuilder)localObject1).append(((ReportHeader)???).seqno);
                ((StringBuilder)localObject1).append(" is exist ignore...");
                QLog.d("VACDReport", 2, ((StringBuilder)localObject1).toString());
              }
              return;
            }
            localObject6 = (ReportItem)localObject1[2];
            localObject1 = (String)localObject1[0];
            localReportInfo = new ReportInfo();
            localReportInfo.header = ((ReportHeader)???);
            localReportInfo.header.sKey = ((String)localObject1);
            localReportInfo.header.totalTime = 0L;
            localReportInfo.body = new ReportBody();
            localReportInfo.body.reportItems = new ArrayList(16);
            localReportInfo.body.sKey = ((String)localObject1);
            localReportInfo.body.startTime = ((ReportHeader)???).startTime;
            localReportInfo.body.totalTime = localReportInfo.header.totalTime;
            ((ReportItem)localObject6).seqno = localReportInfo.header.seqno;
            ((ReportItem)localObject6).isNormalEnd = true;
            localReportInfo.body.reportItems.add(localObject6);
            VACDReportServiceImpl.access$100(this.a).put(Long.valueOf(((ReportHeader)???).seqno), localReportInfo);
            VACDReportServiceImpl.access$700(this.a).add(???);
            VACDReportServiceImpl.access$600(this.a).add(localObject6);
            VACDReportServiceImpl.access$300(this.a, 1);
            return;
          }
        }
        synchronized (VACDReportServiceImpl.access$000())
        {
          l = ((Long)localObject2[0]).longValue();
          ??? = (ReportItem)localObject2[1];
          localObject3 = (ReportInfo)VACDReportServiceImpl.access$100(this.a).get(Long.valueOf(l));
          if (localObject3 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("end report. seqno=");
              ((StringBuilder)localObject3).append(l);
              ((StringBuilder)localObject3).append(" is illegal, step:");
              if (??? == null) {
                break label1705;
              }
              ??? = ???.step;
              label808:
              ((StringBuilder)localObject3).append(???);
              QLog.d("VACDReport", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            if ((((ReportInfo)localObject3).header != null) && (((ReportInfo)localObject3).body != null))
            {
              if (((ReportInfo)localObject3).body.reportItems == null) {
                ((ReportInfo)localObject3).body.reportItems = new ArrayList();
              }
              ((ReportInfo)localObject3).body.reportItems.add(???);
              ???.seqno = ((ReportInfo)localObject3).header.seqno;
              ???.isNormalEnd = true;
              VACDReportServiceImpl.access$600(this.a).add(???);
              VACDReportServiceImpl.access$800(this.a, 5);
              localObject3 = VACDReportServiceImpl.access$900(this.a).obtainMessage();
              if (localObject3 != null)
              {
                ((Message)localObject3).arg1 = 5;
                ((Message)localObject3).obj = new Object[] { Long.valueOf(l), ??? };
                VACDReportServiceImpl.access$900(this.a).sendMessageDelayed((Message)localObject3, 10000L);
              }
              return;
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("end report. seqno=");
              ((StringBuilder)localObject3).append(l);
              ((StringBuilder)localObject3).append(" is illegal, step:");
              if (??? == null) {
                break label1711;
              }
              ??? = ???.step;
              label1038:
              ((StringBuilder)localObject3).append(???);
              QLog.d("VACDReport", 2, ((StringBuilder)localObject3).toString());
            }
            return;
          }
        }
      }
    }
    for (;;)
    {
      synchronized (VACDReportServiceImpl.access$000())
      {
        l = ((Long)localObject3[0]).longValue();
        ??? = (ReportItem)localObject3[2];
        localObject6 = (ReportInfo)VACDReportServiceImpl.access$100(this.a).get(Long.valueOf(l));
        if (localObject6 == null)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("addReportItem. seqno=");
            ((StringBuilder)localObject3).append(l);
            ((StringBuilder)localObject3).append(" is illegal, step:");
            if (??? == null) {
              break label1717;
            }
            ??? = ???.step;
            ((StringBuilder)localObject3).append(???);
            QLog.d("VACDReport", 2, ((StringBuilder)localObject3).toString());
          }
          return;
        }
        if ((((ReportInfo)localObject6).header != null) && (((ReportInfo)localObject6).body != null))
        {
          if (((ReportInfo)localObject6).body.reportItems == null) {
            ((ReportInfo)localObject6).body.reportItems = new ArrayList();
          }
          ((ReportInfo)localObject6).body.reportItems.add(???);
          localObject3 = (String)localObject3[1];
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            ((ReportInfo)localObject6).header.sKey = ((String)localObject3);
            ((ReportInfo)localObject6).body.sKey = ((String)localObject3);
          }
          ???.seqno = ((ReportInfo)localObject6).header.seqno;
          VACDReportServiceImpl.access$600(this.a).add(???);
          VACDReportServiceImpl.access$000().notifyAll();
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("addReportItem. seqno=");
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append(" is illegal, step:");
          if (??? == null) {
            break label1723;
          }
          ??? = ???.step;
          ((StringBuilder)localObject3).append(???);
          QLog.d("VACDReport", 2, ((StringBuilder)localObject3).toString());
        }
        return;
      }
      synchronized (VACDReportServiceImpl.access$000())
      {
        ??? = (ReportHeader)localObject3[1];
        if ((ReportInfo)VACDReportServiceImpl.access$100(this.a).get(Long.valueOf(((ReportHeader)???).seqno)) != null)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("start report. seqno=");
            ((StringBuilder)localObject3).append(((ReportHeader)???).seqno);
            ((StringBuilder)localObject3).append(" is exist ignore...");
            QLog.d("VACDReport", 2, ((StringBuilder)localObject3).toString());
          }
          return;
        }
        localObject6 = (ReportItem)localObject3[2];
        localObject3 = (String)localObject3[0];
        localReportInfo = new ReportInfo();
        localReportInfo.header = ((ReportHeader)???);
        localReportInfo.body = new ReportBody();
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localReportInfo.header.sKey = ((String)localObject3);
          localReportInfo.body.sKey = ((String)localObject3);
        }
        localReportInfo.body.reportItems = new ArrayList(16);
        localReportInfo.body.startTime = ((ReportHeader)???).startTime;
        if (localObject6 != null)
        {
          localReportInfo.body.reportItems.add(localObject6);
          ((ReportItem)localObject6).seqno = ((ReportHeader)???).seqno;
          VACDReportServiceImpl.access$600(this.a).add(localObject6);
        }
        VACDReportServiceImpl.access$100(this.a).put(Long.valueOf(((ReportHeader)???).seqno), localReportInfo);
        VACDReportServiceImpl.access$700(this.a).add(???);
        VACDReportServiceImpl.access$000().notifyAll();
        return;
      }
      label1693:
      ??? = ".";
      break;
      label1699:
      ??? = ".";
      break label359;
      label1705:
      ??? = ".";
      break label808;
      label1711:
      ??? = ".";
      break label1038;
      label1717:
      ??? = ".";
      continue;
      label1723:
      ??? = ".";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */