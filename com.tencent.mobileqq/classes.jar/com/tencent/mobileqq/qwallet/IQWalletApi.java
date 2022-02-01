package com.tencent.mobileqq.qwallet;

import android.content.Context;
import android.os.ResultReceiver;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnTouchListener;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

@QAPI(process={"all"})
public abstract interface IQWalletApi
  extends QRouteApi
{
  public abstract void GrapHbWithParam(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, ResultReceiver paramResultReceiver);
  
  public abstract void addUploadData(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, long paramLong, int paramInt2, String paramString3, String paramString4, String paramString5);
  
  public abstract long convertStringToTime(String paramString);
  
  public abstract String cutTextByPix(Context paramContext, String paramString, float paramFloat, TextPaint paramTextPaint);
  
  public abstract View.OnTouchListener getAlphaChangeListener(float paramFloat);
  
  public abstract String getEncodeUrl(String paramString);
  
  public abstract BaseQQAppInterface getQQAppInterface();
  
  public abstract QIPCModule getQWalletIPCModule();
  
  public abstract AbsDownloader getQWalletPicDownloader();
  
  public abstract String getQWalletTmpPath();
  
  public abstract boolean isOnView(View paramView, float paramFloat1, float paramFloat2);
  
  public abstract String md5Encode(String paramString);
  
  public abstract Object readObject(String paramString);
  
  public abstract void reportTenpay(int paramInt, String paramString);
  
  public abstract void reqReportHBGame(String paramString1, long paramLong, String paramString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2);
  
  public abstract void saveObject(Object paramObject, String paramString);
  
  public abstract void servletSendRequest(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver);
  
  public abstract void setAlphaChangeListener(View paramView, float paramFloat);
  
  public abstract void sortByFileNameNum(File[] paramArrayOfFile);
  
  public abstract boolean unzipAtomically(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.IQWalletApi
 * JD-Core Version:    0.7.0.1
 */