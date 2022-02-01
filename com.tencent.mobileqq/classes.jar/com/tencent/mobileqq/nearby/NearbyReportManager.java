package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import mqq.manager.Manager;

public class NearbyReportManager
  implements Manager
{
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  LongSparseArray<NearbyReportManager.ReportRecord> jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
  public boolean a;
  
  public NearbyReportManager(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    LongSparseArray localLongSparseArray = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    NearbyHandler localNearbyHandler = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getBusinessHandler(NearbyConstants.a);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    ThreadManager.post(new NearbyReportManager.1(this, localLongSparseArray, localNearbyHandler, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    NearbyReportManager.ReportRecord localReportRecord = (NearbyReportManager.ReportRecord)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong);
    if (localReportRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localReportRecord.c += 1;
    localReportRecord.d += paramInt1;
    if (paramInt2 > localReportRecord.e) {
      localReportRecord.e = paramInt2;
    }
    localReportRecord.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager
 * JD-Core Version:    0.7.0.1
 */