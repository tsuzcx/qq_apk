package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFMToastUtil
  extends QRouteApi
{
  public abstract void toast(int paramInt1, int paramInt2);
  
  public abstract void toast(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract void toastCommon(int paramInt1, String paramString, int paramInt2);
  
  public abstract void toastDefault(int paramInt);
  
  public abstract void toastDefault(String paramString);
  
  public abstract void toastError(int paramInt);
  
  public abstract void toastError(String paramString);
  
  public abstract void toastNone(int paramInt);
  
  public abstract void toastSuc(int paramInt);
  
  public abstract void toastSuc(String paramString);
  
  public abstract void toastSucLong(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFMToastUtil
 * JD-Core Version:    0.7.0.1
 */