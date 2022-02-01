package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.report.IVACDReportService;
import com.tencent.mobileqq.qwallet.report.IVACDReportStaticApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VACDReportStaticApiImpl
  implements IVACDReportStaticApi
{
  private static ReportHeader createHeader(String paramString1, String paramString2)
  {
    ReportHeader localReportHeader = new ReportHeader();
    StringBuilder localStringBuilder = new StringBuilder("Android|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.MODEL);
    localReportHeader.platform = localStringBuilder.toString();
    localReportHeader.sModule = paramString1;
    localReportHeader.sAction = paramString2;
    localReportHeader.version = DeviceInfoUtil.a(MobileQQ.getContext());
    localReportHeader.imei = MobileInfoUtil.getImei();
    localReportHeader.guid = SecUtil.toHexString(NetConnInfoCenter.GUID);
    long l = NetConnInfoCenter.getServerTimeMillis();
    localReportHeader.seqno = l;
    try
    {
      paramString1 = MobileQQ.sMobileQQ.peekAppRuntime();
      if (paramString1 == null) {
        localReportHeader.uin = 10000L;
      } else {
        localReportHeader.uin = Long.parseLong(paramString1.getAccount());
      }
    }
    catch (Exception paramString1)
    {
      label145:
      break label145;
    }
    localReportHeader.uin = 10000L;
    localReportHeader.iNetType = NetworkUtil.getSystemNetwork(MobileQQ.sMobileQQ);
    localReportHeader.result = 0;
    localReportHeader.createTime = NetConnInfoCenter.getServerTimeMillis();
    localReportHeader.startTime = l;
    return localReportHeader;
  }
  
  public void addReportItem(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    ReportItem localReportItem = new ReportItem();
    localReportItem.step = paramString2;
    localReportItem.params = paramString3;
    localReportItem.result = paramInt;
    localReportItem.failReason = paramString4;
    localReportItem.createTime = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder(128);
      paramString2.append("addReportItem seqno=");
      paramString2.append(paramLong);
      paramString2.append(" ,item=");
      paramString2.append(localReportItem.toString());
      paramString2.append(" ,createTime=");
      paramString2.append(NetConnInfoCenter.getServerTimeMillis());
      QLog.d("VACDReport", 2, paramString2.toString());
    }
    paramString2 = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramString2 instanceof BaseQQAppInterface))
    {
      paramString2 = (IVACDReportService)((BaseQQAppInterface)paramString2).getRuntimeService(IVACDReportService.class, "");
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VACDReport", 2, "mgr is null");
        }
        return;
      }
      paramString2.addReportItem(paramLong, paramString1, localReportItem);
      return;
    }
    paramString2 = new Intent(MobileQQ.sMobileQQ, VACDReportReceiver.class);
    paramString2.putExtra("vacdReport_extra:step", "vacdReport_step:add");
    paramString2.putExtra("vacdReport_extra:seqno", paramLong);
    paramString2.putExtra("vacdReport_extra:sKey", paramString1);
    paramString2.putExtra("vacdReport_extra:item", localReportItem);
    MobileQQ.sMobileQQ.sendBroadcast(paramString2);
  }
  
  public void checkReportsTimeOut()
  {
    if (!VACDReportServiceImpl.isDoneCheckTimeout) {
      new VACDReportServiceImpl().init(true);
    }
  }
  
  public void endReport(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ReportItem localReportItem = new ReportItem();
      localReportItem.step = paramString1;
      localReportItem.params = paramString2;
      localReportItem.result = paramInt;
      localReportItem.failReason = paramString3;
      localReportItem.createTime = NetConnInfoCenter.getServerTimeMillis();
      paramString1 = localReportItem;
    }
    else
    {
      paramString1 = null;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder(128);
      paramString2.append("endReport seqno=");
      paramString2.append(paramLong);
      if (paramString1 != null)
      {
        paramString2.append(" ,item=");
        paramString2.append(paramString1.toString());
      }
      paramString2.append(" ,createTime=");
      paramString2.append(NetConnInfoCenter.getServerTimeMillis());
      QLog.d("VACDReport", 2, paramString2.toString());
    }
    paramString2 = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramString2 instanceof BaseQQAppInterface))
    {
      paramString2 = (IVACDReportService)((BaseQQAppInterface)paramString2).getRuntimeService(IVACDReportService.class, "");
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VACDReport", 2, "mgr is null");
        }
        return;
      }
      paramString2.endReport(paramLong, paramString1);
      return;
    }
    paramString2 = new Intent(MobileQQ.sMobileQQ, VACDReportReceiver.class);
    paramString2.putExtra("vacdReport_extra:step", "vacdReport_step:end");
    paramString2.putExtra("vacdReport_extra:seqno", paramLong);
    if (paramString1 != null) {
      paramString2.putExtra("vacdReport_extra:item", paramString1);
    }
    MobileQQ.sMobileQQ.sendBroadcast(paramString2);
  }
  
  public void singleReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    paramString2 = createHeader(paramString2, paramString3);
    paramString3 = new ReportItem();
    paramString3.step = paramString4;
    paramString3.params = paramString5;
    paramString3.result = paramInt;
    paramString3.failReason = paramString6;
    paramString3.createTime = paramString2.createTime;
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder(128);
      paramString5 = new StringBuilder();
      paramString5.append("singleReport header=");
      paramString5.append(paramString2.toString());
      paramString4.append(paramString5.toString());
      paramString5 = new StringBuilder();
      paramString5.append(" ,item=");
      paramString5.append(paramString3.toString());
      paramString4.append(paramString5.toString());
      paramString4.append(" ,createTime=");
      paramString4.append(paramString2.startTime);
      QLog.d("VACDReport", 2, paramString4.toString());
    }
    paramString4 = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramString4 instanceof BaseQQAppInterface))
    {
      paramString4 = (IVACDReportService)((BaseQQAppInterface)paramString4).getRuntimeService(IVACDReportService.class, "");
      if (paramString4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VACDReport", 2, "mgr is null");
        }
        return;
      }
      paramString4.singleReport(paramString1, paramString2, paramString3);
      return;
    }
    paramString4 = new Intent(MobileQQ.sMobileQQ, VACDReportReceiver.class);
    paramString4.putExtra("vacdReport_extra:header", paramString2);
    paramString4.putExtra("vacdReport_extra:seqno", paramString2.seqno);
    paramString4.putExtra("vacdReport_extra:sKey", paramString1);
    paramString4.putExtra("vacdReport_extra:step", "vacdReport_step:single");
    paramString4.putExtra("vacdReport_extra:item", paramString3);
    MobileQQ.sMobileQQ.sendBroadcast(paramString4);
  }
  
  public long startReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    return startReport(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt, paramString6, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public long startReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, long paramLong)
  {
    paramString3 = createHeader(paramString2, paramString3);
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2 = new ReportItem();
      paramString2.step = paramString4;
      paramString2.params = paramString5;
      paramString2.result = paramInt;
      paramString2.failReason = paramString6;
      paramString2.createTime = paramLong;
    }
    else
    {
      paramString2 = null;
    }
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder(128);
      paramString5 = new StringBuilder();
      paramString5.append("startReport header=");
      paramString5.append(paramString3.toString());
      paramString4.append(paramString5.toString());
      if (paramString2 != null)
      {
        paramString5 = new StringBuilder();
        paramString5.append(" ,item=");
        paramString5.append(paramString2.toString());
        paramString4.append(paramString5.toString());
      }
      paramString4.append(" ,createTime=");
      paramString4.append(paramString3.startTime);
      QLog.d("VACDReport", 2, paramString4.toString());
    }
    paramString4 = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramString4 instanceof BaseQQAppInterface))
    {
      paramString4 = (IVACDReportService)((BaseQQAppInterface)paramString4).getRuntimeService(IVACDReportService.class, "");
      if (paramString4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VACDReport", 2, "mgr is null");
        }
        return 0L;
      }
      paramString4.startReport(paramString1, paramString3, paramString2);
    }
    else
    {
      paramString4 = new Intent(MobileQQ.sMobileQQ, VACDReportReceiver.class);
      paramString4.putExtra("vacdReport_extra:header", paramString3);
      paramString4.putExtra("vacdReport_extra:seqno", paramString3.seqno);
      paramString4.putExtra("vacdReport_extra:sKey", paramString1);
      paramString4.putExtra("vacdReport_extra:step", "vacdReport_step:start");
      if (paramString2 != null) {
        paramString4.putExtra("vacdReport_extra:item", paramString2);
      }
      MobileQQ.sMobileQQ.sendBroadcast(paramString4);
    }
    return paramString3.seqno;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportStaticApiImpl
 * JD-Core Version:    0.7.0.1
 */