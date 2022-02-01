package com.tencent.qidian;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class QidianManager$5
  extends SosoInterfaceOnLocationListener
{
  QidianManager$5(QidianManager paramQidianManager, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    double d2 = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "onLocationFinish(): BEGIN errCode=" + paramInt);
    }
    String str;
    double d1;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      if (paramSosoLbsInfo.mLocation.address != null)
      {
        str = paramSosoLbsInfo.mLocation.address;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "onLocationFinish() latitude=" + paramSosoLbsInfo.mLocation.mLat02 + ", longitude=" + paramSosoLbsInfo.mLocation.mLon02 + ", address=" + str);
        }
        d1 = paramSosoLbsInfo.mLocation.mLat02;
        d2 = paramSosoLbsInfo.mLocation.mLon02;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, d1, d2, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.c, this.d, this.e);
      return;
      str = "";
      break;
      d1 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianManager.5
 * JD-Core Version:    0.7.0.1
 */