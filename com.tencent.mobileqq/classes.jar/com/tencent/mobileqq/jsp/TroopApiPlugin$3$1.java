package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class TroopApiPlugin$3$1
  extends LbsManagerServiceOnLocationChangeListener
{
  TroopApiPlugin$3$1(TroopApiPlugin.3 param3, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.b.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish errCode = ");
      localStringBuilder.append(paramInt);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    TroopApiPlugin.a(this.a.b, paramSosoLbsInfo, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */