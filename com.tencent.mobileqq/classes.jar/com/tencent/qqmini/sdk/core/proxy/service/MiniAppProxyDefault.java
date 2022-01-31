package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.ResultReceiver;
import android.util.Log;
import bhif;
import bhij;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IChoosePhotoListner;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.IDrawableLoadedCallBack;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MoreItem;
import java.util.ArrayList;
import java.util.List;

public class MiniAppProxyDefault
  extends MiniAppProxy
{
  private static final String TAG = "MiniAppProxyDefault";
  
  public boolean addShortcut(Context paramContext, MiniAppInfo paramMiniAppInfo, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean chooseLocation(Context paramContext, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public boolean downloadApp(Context paramContext, MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return false;
  }
  
  public boolean enterQRCode(Context paramContext, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public String getAccount()
  {
    return "10000";
  }
  
  public String getAppId()
  {
    return "";
  }
  
  public String getAppName()
  {
    return "sdk";
  }
  
  public String getAppVersion()
  {
    return "8.0.5";
  }
  
  public Drawable getDrawable(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    return null;
  }
  
  public String getImei()
  {
    return "123";
  }
  
  public boolean getLocation(Context paramContext, String paramString, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    return false;
  }
  
  public byte[] getLoginSig()
  {
    return new byte[0];
  }
  
  public int getLoginType()
  {
    return 0;
  }
  
  public bhij getMoreItemSelectedListener()
  {
    return new DefaultMoreItemSelectedListener();
  }
  
  public ArrayList<MoreItem> getMoreItems(bhif parambhif)
  {
    parambhif.a("QQ", 2130840838).b("QQ空间", 2130840839).c("微信好友", 2130840840).d("微信朋友圈", 2130840841).e("关于", 2130840804).f("举报", 2130840837).g("调试", 2130840804).h("性能", 2130840804);
    return parambhif.a();
  }
  
  public String getNickName()
  {
    return null;
  }
  
  public String getPayOpenId()
  {
    return "123";
  }
  
  public String getPayOpenKey()
  {
    return "ABC";
  }
  
  public String getPlatformId()
  {
    return "16";
  }
  
  public String getPlatformQUA()
  {
    return "";
  }
  
  public String getSoPath()
  {
    return null;
  }
  
  public int getTbsVersion()
  {
    return 1;
  }
  
  public boolean isDebugVersion()
  {
    return false;
  }
  
  public void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default: 
      if (paramThrowable == null)
      {
        Log.v(paramString1, paramString2);
        return;
      }
      break;
    case 2: 
      if (paramThrowable == null)
      {
        Log.d(paramString1, paramString2);
        return;
      }
      Log.d(paramString1, paramString2, paramThrowable);
      return;
    case 3: 
      if (paramThrowable == null)
      {
        Log.i(paramString1, paramString2);
        return;
      }
      Log.i(paramString1, paramString2, paramThrowable);
      return;
    case 4: 
      if (paramThrowable == null)
      {
        Log.w(paramString1, paramString2);
        return;
      }
      Log.w(paramString1, paramString2, paramThrowable);
      return;
    case 5: 
      if (paramThrowable == null)
      {
        Log.e(paramString1, paramString2);
        return;
      }
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    }
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public void muteAudioFocus(Context paramContext, boolean paramBoolean) {}
  
  public void notifyMiniAppInfo(int paramInt, MiniAppInfo paramMiniAppInfo) {}
  
  public boolean onCapsuleButtonCloseClick(IMiniRuntime paramIMiniRuntime)
  {
    return false;
  }
  
  public boolean onCapsuleButtonMoreClick(IMiniRuntime paramIMiniRuntime)
  {
    QMLog.d("MiniAppProxyDefault", "onCapsuleButtonMoreClick");
    return true;
  }
  
  public boolean openChoosePhotoActivity(Context paramContext, int paramInt, MiniAppProxy.IChoosePhotoListner paramIChoosePhotoListner)
  {
    return false;
  }
  
  public boolean openImagePreview(Context paramContext, int paramInt, List<String> paramList)
  {
    return false;
  }
  
  public boolean openLocation(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
  
  public boolean openSchema(Context paramContext, String paramString, ResultReceiver paramResultReceiver)
  {
    return false;
  }
  
  public void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener)
  {
    FakeServer.sendData(paramArrayOfByte, paramSenderListener);
  }
  
  public void setDrawableCallback(Drawable paramDrawable, MiniAppProxy.IDrawableLoadedCallBack paramIDrawableLoadedCallBack) {}
  
  public boolean startBrowserActivity(Context paramContext, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.MiniAppProxyDefault
 * JD-Core Version:    0.7.0.1
 */