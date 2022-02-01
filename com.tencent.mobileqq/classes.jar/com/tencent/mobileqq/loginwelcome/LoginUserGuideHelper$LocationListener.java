package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class LoginUserGuideHelper$LocationListener
  extends LbsManagerServiceOnLocationChangeListener
{
  public int a;
  public boolean a;
  public int b = 0;
  
  public LoginUserGuideHelper$LocationListener(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = ((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      this.b = ((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, String.format("onLocationFinish [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper.LocationListener
 * JD-Core Version:    0.7.0.1
 */