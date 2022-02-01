package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.utils.abtest.IOnlineExpProvider;
import com.tencent.qcircle.cooperation.config.QCircleABTestConstants;
import java.util.Arrays;
import java.util.List;

public class QCircleOnlineExpProviderImpl
  implements IOnlineExpProvider
{
  private static final String TAG = "QCircleOnlineExpProviderImpl";
  
  public List<String> getRegisterExpNameList()
  {
    return Arrays.asList(QCircleABTestConstants.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleOnlineExpProviderImpl
 * JD-Core Version:    0.7.0.1
 */