package com.tencent.mobileqq.winkpublish.util;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.widget.QQToast;

public class FSToastUtil
{
  public static int a = -1;
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    QQToast.makeText(RFApplication.getApplication(), paramInt1, paramString, paramInt2).show();
  }
  
  public static void a(String paramString, int paramInt)
  {
    QQToast.makeText(RFApplication.getApplication(), b, paramString, paramInt).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.FSToastUtil
 * JD-Core Version:    0.7.0.1
 */