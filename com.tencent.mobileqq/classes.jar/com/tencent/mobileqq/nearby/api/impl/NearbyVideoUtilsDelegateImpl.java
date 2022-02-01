package com.tencent.mobileqq.nearby.api.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyVideoUtilsReal;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtilsDelegate;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class NearbyVideoUtilsDelegateImpl
  implements INearbyVideoUtilsDelegate
{
  public void disableShowGuideDialog(AppInterface paramAppInterface)
  {
    NearbyVideoUtilsReal.b((QQAppInterface)paramAppInterface);
  }
  
  public String getVideoThumb(String paramString)
  {
    return NearbyVideoUtilsReal.b(paramString);
  }
  
  public boolean isAuthVideoEnable()
  {
    return NearbyVideoUtilsReal.a();
  }
  
  public boolean isNeedShowGuideDialog(AppInterface paramAppInterface)
  {
    return NearbyVideoUtilsReal.a((QQAppInterface)paramAppInterface);
  }
  
  public void report(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    NearbyVideoUtilsReal.a(paramString2, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public void report(String paramString, String... paramVarArgs)
  {
    report("data_card", paramString, 0, 0, paramVarArgs);
  }
  
  public void setAuthVideoConfig(String paramString)
  {
    NearbyVideoUtilsReal.a(paramString);
  }
  
  public void showPtvPanel(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    NearbyVideoUtilsReal.a(paramActivity, paramAppInterface, paramInt);
  }
  
  public boolean showTakeAuthVideoGuideDialog(Activity paramActivity, AppInterface paramAppInterface)
  {
    return NearbyVideoUtilsReal.a(paramActivity, (QQAppInterface)paramAppInterface);
  }
  
  public void startPlayerActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    NearbyVideoUtilsReal.a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt, paramBoolean);
  }
  
  public void upload640Video(AppInterface paramAppInterface, String paramString, TransProcessorHandler paramTransProcessorHandler)
  {
    NearbyVideoUtilsReal.a((QQAppInterface)paramAppInterface, paramString, paramTransProcessorHandler);
  }
  
  public void uploadThumbPhoto(AppInterface paramAppInterface, String paramString)
  {
    NearbyVideoUtilsReal.a((QQAppInterface)paramAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyVideoUtilsDelegateImpl
 * JD-Core Version:    0.7.0.1
 */