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
  INearbyAppInterface a;
  LongSparseArray<ReportRecord> b = new LongSparseArray();
  public boolean c;
  
  public NearbyReportManager(INearbyAppInterface paramINearbyAppInterface)
  {
    this.a = paramINearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    LongSparseArray localLongSparseArray = this.b.a();
    NearbyHandler localNearbyHandler = (NearbyHandler)this.a.getBusinessHandler(NearbyConstants.a);
    boolean bool = this.c;
    this.b.c();
    ThreadManager.post(new NearbyReportManager.1(this, localLongSparseArray, localNearbyHandler, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (ReportRecord)this.b.a(paramLong);
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
    ((ReportRecord)localObject).d += 1;
    ((ReportRecord)localObject).e += paramInt1;
    if (paramInt2 > ((ReportRecord)localObject).f) {
      ((ReportRecord)localObject).f = paramInt2;
    }
    ((ReportRecord)localObject).g |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyReportManager
 * JD-Core Version:    0.7.0.1
 */