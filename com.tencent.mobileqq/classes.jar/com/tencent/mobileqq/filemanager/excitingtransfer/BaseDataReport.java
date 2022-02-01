package com.tencent.mobileqq.filemanager.excitingtransfer;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class BaseDataReport
{
  protected final QQAppInterface a;
  
  public BaseDataReport(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected abstract String a(boolean paramBoolean);
  
  protected abstract HashMap<String, String> a();
  
  public abstract void a();
  
  public void a(DataReportBasicInfo paramDataReportBasicInfo, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete, HashMap<String, String> paramHashMap)
  {
    paramDataReportBasicInfo = paramDataReportBasicInfo.a();
    if (paramExcitingTransferOneSlotComplete != null) {
      paramDataReportBasicInfo.putAll(paramExcitingTransferOneSlotComplete.getReportData());
    }
    if (paramHashMap != null) {
      paramDataReportBasicInfo.putAll(paramHashMap);
    }
    boolean bool = false;
    if (paramExcitingTransferOneSlotComplete != null)
    {
      if (paramExcitingTransferOneSlotComplete.mSubReason == 0) {
        bool = true;
      }
    }
    else {
      bool = false;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getCurrentAccountUin(), "actPDSlot", bool, 0L, 0L, paramDataReportBasicInfo, "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (a()) {
      b(paramBoolean);
    }
    HashMap localHashMap = a();
    if (localHashMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>> report: act=");
      localStringBuilder.append(a(false));
      localStringBuilder.append(localHashMap.toString());
      QLog.i("DataReport", 1, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getCurrentAccountUin(), a(false), paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  protected abstract boolean a();
  
  protected abstract HashMap<String, String> b();
  
  public abstract void b();
  
  public void b(boolean paramBoolean)
  {
    HashMap localHashMap = b();
    if (localHashMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>> reportOld: act=");
      localStringBuilder.append(a(true));
      localStringBuilder.append(localHashMap.toString());
      QLog.i("OldDataReport", 1, localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getCurrentAccountUin(), a(true), paramBoolean, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.BaseDataReport
 * JD-Core Version:    0.7.0.1
 */