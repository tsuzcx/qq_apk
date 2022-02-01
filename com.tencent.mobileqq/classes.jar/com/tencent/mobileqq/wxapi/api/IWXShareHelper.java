package com.tencent.mobileqq.wxapi.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;

@QAPI(process={"all"})
public abstract interface IWXShareHelper
  extends QRouteApi
{
  public abstract int ERR_AUTH_DENIED();
  
  public abstract int ERR_OK();
  
  public abstract int ERR_USER_CANCEL();
  
  public abstract int WXSceneFavorite();
  
  public abstract int WXSceneSession();
  
  public abstract int WXSceneSpecifiedContact();
  
  public abstract int WXSceneTimeline();
  
  public abstract void addObserver(IWXShareHelperListener paramIWXShareHelperListener);
  
  public abstract boolean isWXInstalled();
  
  public abstract boolean isWXsupportApi();
  
  public abstract void removeObserver(IWXShareHelperListener paramIWXShareHelperListener);
  
  public abstract void shareQcircleToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4, int paramInt);
  
  public abstract void shareTroopToWXFriend(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4);
  
  public abstract void shareTroopToWXFriendCircle(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, String paramString4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.api.IWXShareHelper
 * JD-Core Version:    0.7.0.1
 */