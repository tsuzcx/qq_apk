package com.tencent.mobileqq.wxapi.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import java.util.concurrent.ConcurrentHashMap;

public class WXShareHelperImpl
  implements IWXShareHelper
{
  private ConcurrentHashMap<IWXShareHelperListener, WXShareHelperImpl.RealShareListener> mListenerMap = new ConcurrentHashMap();
  
  public int ERR_AUTH_DENIED()
  {
    return -4;
  }
  
  public int ERR_OK()
  {
    return 0;
  }
  
  public int ERR_USER_CANCEL()
  {
    return -2;
  }
  
  public int WXSceneFavorite()
  {
    return 2;
  }
  
  public int WXSceneSession()
  {
    return 0;
  }
  
  public int WXSceneSpecifiedContact()
  {
    return 3;
  }
  
  public int WXSceneTimeline()
  {
    return 1;
  }
  
  public void addObserver(IWXShareHelperListener paramIWXShareHelperListener)
  {
    WXShareHelperImpl.RealShareListener localRealShareListener = new WXShareHelperImpl.RealShareListener(paramIWXShareHelperListener);
    WXShareHelper.a().a(localRealShareListener);
    this.mListenerMap.put(paramIWXShareHelperListener, localRealShareListener);
  }
  
  public boolean isWXInstalled()
  {
    return WXShareHelper.a().a();
  }
  
  public boolean isWXsupportApi()
  {
    return WXShareHelper.a().b();
  }
  
  public void removeObserver(IWXShareHelperListener paramIWXShareHelperListener)
  {
    if (this.mListenerMap.get(paramIWXShareHelperListener) != null)
    {
      WXShareHelperImpl.RealShareListener localRealShareListener = (WXShareHelperImpl.RealShareListener)this.mListenerMap.get(paramIWXShareHelperListener);
      WXShareHelper.a().b(localRealShareListener);
      this.mListenerMap.remove(paramIWXShareHelperListener);
    }
  }
  
  public void shareQcircleToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt)
  {
    WXShareHelper.a().d(paramString1, paramString2, paramBitmap, paramString3, paramString4, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.api.impl.WXShareHelperImpl
 * JD-Core Version:    0.7.0.1
 */