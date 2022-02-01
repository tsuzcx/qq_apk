package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.IToastUtil;
import cooperation.qqcircle.utils.ToastUtil;

public class ToastUtilImpl
  implements IToastUtil
{
  public void determineShowByCode(long paramLong, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    ToastUtil.determineShowByCode(paramLong, paramContext, paramInt1, paramString, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.ToastUtilImpl
 * JD-Core Version:    0.7.0.1
 */