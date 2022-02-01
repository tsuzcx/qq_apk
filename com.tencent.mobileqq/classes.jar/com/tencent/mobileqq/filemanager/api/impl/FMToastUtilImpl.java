package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IFMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFMToastUtil;

public class FMToastUtilImpl
  implements IFMToastUtil
{
  public void toast(int paramInt1, int paramInt2)
  {
    QQFMToastUtil.a(paramInt1, paramInt2);
  }
  
  public void toast(Context paramContext, int paramInt1, int paramInt2)
  {
    QQFMToastUtil.a(paramContext, paramInt1, paramInt2);
  }
  
  public void toastCommon(int paramInt1, String paramString, int paramInt2)
  {
    QQFMToastUtil.a(paramInt1, paramString, paramInt2);
  }
  
  public void toastDefault(int paramInt)
  {
    QQFMToastUtil.c(paramInt);
  }
  
  public void toastDefault(String paramString)
  {
    QQFMToastUtil.d(paramString);
  }
  
  public void toastError(int paramInt)
  {
    QQFMToastUtil.a(paramInt);
  }
  
  public void toastError(String paramString)
  {
    QQFMToastUtil.a(paramString);
  }
  
  public void toastNone(int paramInt)
  {
    QQFMToastUtil.d(paramInt);
  }
  
  public void toastSuc(int paramInt)
  {
    QQFMToastUtil.b(paramInt);
  }
  
  public void toastSuc(String paramString)
  {
    QQFMToastUtil.b(paramString);
  }
  
  public void toastSucLong(String paramString)
  {
    QQFMToastUtil.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FMToastUtilImpl
 * JD-Core Version:    0.7.0.1
 */