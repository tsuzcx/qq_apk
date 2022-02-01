package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import mqq.manager.Manager;

public class NearbyReportManager
  implements Manager
{
  INearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface;
  LongSparseArray<ReportRecord> jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
  public boolean a;
  
  public NearbyReportManager(INearbyAppInterface paramINearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface = paramINearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    LongSparseArray localLongSparseArray = this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    NearbyHandler localNearbyHandler = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyApiINearbyAppInterface.getBusinessHandler(NearbyConstants.a);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    ThreadManager.post(new NearbyReportManager.1(this, localLongSparseArray, localNearbyHandler, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (ReportRecord)this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(paramLong);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRecord ,not exist!! tinyID = ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("NearbyReportManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ((ReportRecord)localObject).c += 1;
    ((ReportRecord)localObject).d += paramInt1;
    if (paramInt2 > ((ReportRecord)localObject).e) {
      ((ReportRecord)localObject).e = paramInt2;
    }
    ((ReportRecord)localObject).f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager
 * JD-Core Version:    0.7.0.1
 */