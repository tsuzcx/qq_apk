package com.tencent.mobileqq.weather;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

final class WeatherServlet$2
  extends LbsManagerServiceOnLocationChangeListener
{
  WeatherServlet$2(String paramString, boolean paramBoolean, NewIntent paramNewIntent, AppInterface paramAppInterface)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherServlet", 2, "startLocation onLocationFinish");
    }
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errCode ：");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" info is null ---> ");
      if (paramSosoLbsInfo == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("WeatherServlet", 2, localStringBuilder.toString());
    }
    int i = j;
    if (paramInt == 0)
    {
      i = j;
      if (paramSosoLbsInfo != null)
      {
        i = j;
        if (paramSosoLbsInfo.mLocation != null) {
          try
          {
            i = Integer.parseInt(paramSosoLbsInfo.mLocation.cityCode);
          }
          catch (Throwable paramSosoLbsInfo)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.e("WeatherServlet", 2, paramSosoLbsInfo, new Object[0]);
              i = j;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("LocalInfo");
      paramSosoLbsInfo.append(i);
      QLog.d("WeatherServlet", 2, paramSosoLbsInfo.toString());
    }
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("adcode", i);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.WeatherServlet.2
 * JD-Core Version:    0.7.0.1
 */