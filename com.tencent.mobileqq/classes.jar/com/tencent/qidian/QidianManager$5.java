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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLocationFinish(): BEGIN errCode=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QidianManager", 2, ((StringBuilder)localObject).toString());
    }
    double d1;
    double d2;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      if (paramSosoLbsInfo.mLocation.address != null) {
        localObject = paramSosoLbsInfo.mLocation.address;
      } else {
        localObject = "";
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLocationFinish() latitude=");
        localStringBuilder.append(paramSosoLbsInfo.mLocation.mLat02);
        localStringBuilder.append(", longitude=");
        localStringBuilder.append(paramSosoLbsInfo.mLocation.mLon02);
        localStringBuilder.append(", address=");
        localStringBuilder.append((String)localObject);
        QLog.d("QidianManager", 2, localStringBuilder.toString());
      }
      d1 = paramSosoLbsInfo.mLocation.mLat02;
      d2 = paramSosoLbsInfo.mLocation.mLon02;
    }
    else
    {
      d1 = 0.0D;
      d2 = d1;
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, d1, d2, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianManager.5
 * JD-Core Version:    0.7.0.1
 */