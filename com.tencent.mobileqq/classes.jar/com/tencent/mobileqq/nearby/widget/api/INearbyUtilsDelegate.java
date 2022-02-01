package com.tencent.mobileqq.nearby.widget.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyUtilsDelegate
  extends QRouteApi
{
  public static final boolean DEBUG = true;
  public static final int SIG_TYPE_DEFAULT = -1;
  public static final int SIG_TYPE_NEARBY = 0;
  public static final int SIG_TYPE_TRIBE = 1;
  
  public abstract String convertFrom4Report(int paramInt);
  
  public abstract void createTagView(TextView paramTextView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable);
  
  public abstract boolean equalsWithNullCheck(Object paramObject1, Object paramObject2);
  
  public abstract String filterBlankSpace(String paramString);
  
  public abstract boolean isColorLevel();
  
  public abstract boolean isDevelopLevel();
  
  public abstract boolean isNearbyModule();
  
  public abstract boolean isNetworkConnected(Context paramContext);
  
  public abstract boolean isSigError(int paramInt);
  
  public abstract String joinKey(StringBuilder paramStringBuilder, String paramString, Object... paramVarArgs);
  
  public abstract void log(int paramInt, String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void printColorLevelLog(String paramString, Object... paramVarArgs);
  
  public abstract void printLog(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void reportHomeEvent(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void reportNearbySafetyCheck(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void requestSig(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void startBindPhonePageForResult(Activity paramActivity, int paramInt);
  
  public abstract void truncateEditText(EditText paramEditText, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate
 * JD-Core Version:    0.7.0.1
 */