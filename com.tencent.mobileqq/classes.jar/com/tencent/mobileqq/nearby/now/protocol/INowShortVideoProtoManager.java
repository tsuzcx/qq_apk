package com.tencent.mobileqq.nearby.now.protocol;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INowShortVideoProtoManager
  extends QRouteApi
{
  public abstract void feedsLike(String paramString, INowShortVideoProtoManager.Callback paramCallback, Bundle paramBundle);
  
  public abstract void feedsUnLike(String paramString, INowShortVideoProtoManager.Callback paramCallback, Bundle paramBundle);
  
  public abstract void follow(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean, INowShortVideoProtoManager.Callback paramCallback);
  
  public abstract void getLbsShareInfo(Object paramObject, INowShortVideoProtoManager.Callback paramCallback);
  
  public abstract void getMediaDetailInfo(String paramString, INowShortVideoProtoManager.Callback paramCallback);
  
  public abstract void getShortLabel(long paramLong, String paramString, INowShortVideoProtoManager.Callback paramCallback);
  
  public abstract INowShortVideoProtoManager init(AppInterface paramAppInterface);
  
  public abstract void reportPlay(String paramString, INowShortVideoProtoManager.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager
 * JD-Core Version:    0.7.0.1
 */