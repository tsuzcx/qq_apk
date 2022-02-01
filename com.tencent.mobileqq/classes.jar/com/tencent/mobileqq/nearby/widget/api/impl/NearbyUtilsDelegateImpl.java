package com.tencent.mobileqq.nearby.widget.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtilsReal;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate;

public class NearbyUtilsDelegateImpl
  implements INearbyUtilsDelegate
{
  public String convertFrom4Report(int paramInt)
  {
    return NearbyUtilsReal.b(paramInt);
  }
  
  public void createTagView(TextView paramTextView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    NearbyUtilsReal.a(paramTextView, paramString, paramInt1, paramInt2, paramDrawable);
  }
  
  public boolean equalsWithNullCheck(Object paramObject1, Object paramObject2)
  {
    return NearbyUtilsReal.a(paramObject1, paramObject2);
  }
  
  public String filterBlankSpace(String paramString)
  {
    return NearbyUtilsReal.a(paramString);
  }
  
  public boolean isColorLevel()
  {
    return NearbyUtilsReal.b();
  }
  
  public boolean isDevelopLevel()
  {
    return NearbyUtilsReal.a();
  }
  
  public boolean isNearbyModule()
  {
    return NearbyUtilsReal.c();
  }
  
  public boolean isNetworkConnected(Context paramContext)
  {
    return NearbyUtilsReal.a(paramContext);
  }
  
  public boolean isSigError(int paramInt)
  {
    return NearbyUtilsReal.a(paramInt);
  }
  
  public String joinKey(StringBuilder paramStringBuilder, String paramString, Object... paramVarArgs)
  {
    return NearbyUtilsReal.a(paramStringBuilder, paramString, paramVarArgs);
  }
  
  public void log(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    NearbyUtilsReal.a(paramInt, paramString1, paramString2, paramVarArgs);
  }
  
  public void printColorLevelLog(String paramString, Object... paramVarArgs)
  {
    NearbyUtilsReal.a(paramString, paramVarArgs);
  }
  
  public void printLog(String paramString1, String paramString2, Object... paramVarArgs)
  {
    NearbyUtilsReal.a(paramString1, paramString2, paramVarArgs);
  }
  
  public void reportHomeEvent(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    NearbyUtilsReal.a((INearbyAppInterface)paramAppInterface, paramString, paramInt);
  }
  
  public void reportNearbySafetyCheck(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    NearbyUtilsReal.a((QQAppInterface)paramAppInterface, paramString1, paramString2);
  }
  
  public void requestSig(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    NearbyUtilsReal.a((QQAppInterface)paramAppInterface, paramString, paramInt);
  }
  
  public void startBindPhonePageForResult(Activity paramActivity, int paramInt)
  {
    NearbyUtilsReal.a(paramActivity, paramInt);
  }
  
  public void truncateEditText(EditText paramEditText, int paramInt)
  {
    NearbyUtilsReal.a(paramEditText, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.api.impl.NearbyUtilsDelegateImpl
 * JD-Core Version:    0.7.0.1
 */