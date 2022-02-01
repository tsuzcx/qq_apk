package com.tencent.mobileqq.qwallet.impl;

import android.content.Context;
import android.os.ResultReceiver;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class QWalletApiImpl
  implements IQWalletApi
{
  public void GrapHbWithParam(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, ResultReceiver paramResultReceiver)
  {
    QWalletTools.a(paramAppInterface, paramString1, paramString2, paramString3, paramResultReceiver);
  }
  
  public void addUploadData(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    QWalletTools.a(paramAppRuntime, paramString1, paramInt1, paramString2, paramLong, paramInt2, paramString3, paramString4, paramString5);
  }
  
  public long convertStringToTime(String paramString)
  {
    return QWalletTools.f(paramString);
  }
  
  public String cutTextByPix(Context paramContext, String paramString, float paramFloat, TextPaint paramTextPaint)
  {
    return QWalletTools.a(paramContext, paramString, paramFloat, paramTextPaint);
  }
  
  public View.OnTouchListener getAlphaChangeListener(float paramFloat)
  {
    return QWalletTools.a(paramFloat);
  }
  
  public String getEncodeUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public BaseQQAppInterface getQQAppInterface()
  {
    return QWalletTools.b();
  }
  
  public QIPCModule getQWalletIPCModule()
  {
    return QWalletIPCModule.a();
  }
  
  public AbsDownloader getQWalletPicDownloader()
  {
    return new QWalletPicDownloader();
  }
  
  public String getQWalletTmpPath()
  {
    return QWalletTools.a();
  }
  
  public boolean isOnView(View paramView, float paramFloat1, float paramFloat2)
  {
    return QWalletTools.a(paramView, paramFloat1, paramFloat2);
  }
  
  public String md5Encode(String paramString)
  {
    return QWalletTools.a(paramString);
  }
  
  public Object readObject(String paramString)
  {
    return QWalletTools.e(paramString);
  }
  
  public void reportTenpay(int paramInt, String paramString)
  {
    QWalletTools.a(paramInt, paramString);
  }
  
  public void reqReportHBGame(String paramString1, long paramLong, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    QWalletTools.a(paramString1, paramLong, paramString2, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void saveObject(Object paramObject, String paramString)
  {
    QWalletTools.a(paramObject, paramString);
  }
  
  public void servletSendRequest(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver)
  {
    QWalletCommonServlet.a(paramJceStruct, paramBusinessObserver);
  }
  
  public void setAlphaChangeListener(View paramView, float paramFloat)
  {
    if (paramView != null) {
      paramView.setOnTouchListener(getAlphaChangeListener(paramFloat));
    }
  }
  
  public void sortByFileNameNum(File[] paramArrayOfFile)
  {
    QWalletTools.a(paramArrayOfFile);
  }
  
  public boolean unzipAtomically(String paramString1, String paramString2)
  {
    return QWalletTools.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletApiImpl
 * JD-Core Version:    0.7.0.1
 */