package com.tencent.util;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class QQToastUtil
{
  public static void a(int paramInt1, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt1, paramInt2, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131299168));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.QQToastUtil
 * JD-Core Version:    0.7.0.1
 */