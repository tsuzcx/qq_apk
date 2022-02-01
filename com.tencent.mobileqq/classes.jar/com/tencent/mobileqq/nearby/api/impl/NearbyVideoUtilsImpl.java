package com.tencent.mobileqq.nearby.api.impl;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.api.NearbyVideoUtils;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class NearbyVideoUtilsImpl
  implements INearbyVideoUtils
{
  public void disableShowGuideDialog(Object paramObject)
  {
    NearbyVideoUtils.a((QQAppInterface)paramObject);
  }
  
  public String getVideoThumb(String paramString)
  {
    return NearbyVideoUtils.a(paramString);
  }
  
  public boolean isAuthVideoEnable()
  {
    return NearbyVideoUtils.a();
  }
  
  public boolean isNeedShowGuideDialog(Object paramObject)
  {
    return NearbyVideoUtils.a((QQAppInterface)paramObject);
  }
  
  public void report(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    NearbyVideoUtils.a(paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public void report(String paramString, String... paramVarArgs)
  {
    NearbyVideoUtils.a(paramString, paramVarArgs);
  }
  
  public void setAuthVideoConfig(String paramString)
  {
    NearbyVideoUtils.a(paramString);
  }
  
  public void showPtvPanel(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    NearbyVideoUtils.a(paramActivity, paramAppInterface, paramInt);
  }
  
  public boolean showTakeAuthVideoGuideDialog(Activity paramActivity, Object paramObject)
  {
    return NearbyVideoUtils.a(paramActivity, (QQAppInterface)paramObject);
  }
  
  public void startPlayerActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    NearbyVideoUtils.a(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt, paramBoolean);
  }
  
  public void upload640Video(Object paramObject, String paramString, TransProcessorHandler paramTransProcessorHandler)
  {
    NearbyVideoUtils.a((QQAppInterface)paramObject, paramString, paramTransProcessorHandler);
  }
  
  public void uploadThumbPhoto(Object paramObject, String paramString)
  {
    NearbyVideoUtils.a((QQAppInterface)paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyVideoUtilsImpl
 * JD-Core Version:    0.7.0.1
 */