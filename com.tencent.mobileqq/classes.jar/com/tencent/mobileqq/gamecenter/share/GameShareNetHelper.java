package com.tencent.mobileqq.gamecenter.share;

import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailReq;
import com.tencent.mobileqq.gamecenter.protocol.ReportTypeReq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.observer.BusinessObserver;

public class GameShareNetHelper
{
  private static volatile GameShareNetHelper jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareNetHelper;
  private Map<MessageRecord, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static GameShareNetHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareNetHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareNetHelper == null) {
        jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareNetHelper = new GameShareNetHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareNetHelper;
    }
    finally {}
  }
  
  public void a(long paramLong, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Object localObject = (Long)this.jdField_a_of_type_JavaUtilMap.get(paramMessageRecord);
    if (localObject == null) {}
    for (long l1 = 0L;; l1 = ((Long)localObject).longValue())
    {
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      if (l2 - Long.valueOf(l1).longValue() <= 30000L) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageRecord, Long.valueOf(l2));
      localObject = QWalletTools.a();
      if (localObject == null) {
        break;
      }
      GetArkTailReq localGetArkTailReq = new GetArkTailReq();
      localGetArkTailReq.appid = (paramLong + "");
      localGetArkTailReq.tt = 1;
      localGetArkTailReq.scene_id = 1;
      localGetArkTailReq.qq_version = DeviceInfoUtil.c();
      QWalletCommonServlet.a(localGetArkTailReq, new GameShareNetHelper.2(this, paramMessageRecord, new WeakReference(localObject)));
      return;
    }
  }
  
  public void a(long paramLong, BusinessObserver paramBusinessObserver)
  {
    GetArkTailReq localGetArkTailReq = new GetArkTailReq();
    localGetArkTailReq.appid = (paramLong + "");
    localGetArkTailReq.tt = 1;
    localGetArkTailReq.scene_id = 3;
    localGetArkTailReq.qq_version = DeviceInfoUtil.c();
    QWalletCommonServlet.a(localGetArkTailReq, paramBusinessObserver);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ReportTypeReq localReportTypeReq = new ReportTypeReq();
    localReportTypeReq.appid = paramString;
    localReportTypeReq.type = paramInt1;
    localReportTypeReq.sub_type = paramInt2;
    localReportTypeReq.tt = 1;
    QWalletCommonServlet.a(localReportTypeReq, new GameShareNetHelper.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareNetHelper
 * JD-Core Version:    0.7.0.1
 */