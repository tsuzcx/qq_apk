package com.tencent.mobileqq.qqlive.trtc.video.source.screen;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveScreenCaptureParams;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.trtc.TRTCEngineProxy;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.mobileqq.qqlive.trtc.ipc.ITRTCIPCHandler;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;
import com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource;
import com.tencent.qphone.base.util.QLog;

public class TRTCFakeScreenCaptureSource
  implements ITRTCIPCHandler, ITRTCVideoBaseSource, ITRTCScreenCaptureSource
{
  private IRTCScreenCaptureEventListener a = null;
  
  public TRTCFakeScreenCaptureSource()
  {
    TRTCServerIPCModule.a().a(this);
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    int i;
    if (paramInt >= 5)
    {
      i = paramInt;
      if (paramInt <= 20) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fps except [5, 20]. but ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("TRTCFakeScreenCaptureSource", 1, ((StringBuilder)localObject).toString());
      i = 10;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putParcelable("Key_trtc_source_mute_bitmap", paramBitmap);
    ((Bundle)localObject).putInt("Key_trtc_source_mute_fps", i);
    TRTCServerIPCModule.a("Action_Client_Screen_Set_Mute_Bitmap", (Bundle)localObject, null);
  }
  
  public void a(@NonNull Handler paramHandler) {}
  
  public void a(@NonNull TRTCVideoQualityParams paramTRTCVideoQualityParams)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Key_trtc_screen_params", paramTRTCVideoQualityParams);
    TRTCServerIPCModule.a("Action_Client_Screen_Set_Quality", localBundle, null);
  }
  
  public void a(TRTCVideoQualityParams paramTRTCVideoQualityParams, QQLiveScreenCaptureParams paramQQLiveScreenCaptureParams)
  {
    paramQQLiveScreenCaptureParams = new Bundle();
    if (paramTRTCVideoQualityParams != null) {
      paramQQLiveScreenCaptureParams.putParcelable("Key_trtc_screen_params", paramTRTCVideoQualityParams);
    }
    TRTCServerIPCModule.a("Action_Client_Screen_Start", paramQQLiveScreenCaptureParams, null);
  }
  
  public void a(@NonNull TRTCEngineContext paramTRTCEngineContext) {}
  
  public void a(IRTCScreenCaptureEventListener paramIRTCScreenCaptureEventListener)
  {
    this.a = paramIRTCScreenCaptureEventListener;
  }
  
  public void a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Key_trtc_source_mute", paramBoolean);
    TRTCServerIPCModule.a("Action_Client_Screen_Mute_Video", localBundle, null);
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    Object localObject = null;
    TRTCVideoQualityParams localTRTCVideoQualityParams;
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(TRTCVideoQualityParams.class.getClassLoader());
      localTRTCVideoQualityParams = (TRTCVideoQualityParams)paramBundle.getParcelable("Key_trtc_screen_params");
    }
    else
    {
      localTRTCVideoQualityParams = null;
    }
    TRTCEngineProxy.a().k();
    if ("Action_Client_Screen_Set_Quality".equals(paramString))
    {
      if (localTRTCVideoQualityParams != null) {
        TRTCEngineProxy.a().a(localTRTCVideoQualityParams);
      }
    }
    else if ("Action_Client_Screen_Start".equals(paramString))
    {
      TRTCEngineProxy.a().a(new TRTCFakeScreenCaptureSource.RemoteScreenCaptureEventImpl(this));
      TRTCEngineProxy.a().a(localTRTCVideoQualityParams, null);
    }
    else if ("Action_Client_Screen_Stop".equals(paramString))
    {
      TRTCEngineProxy.a().j();
    }
    boolean bool1 = "Action_Client_Screen_Mute_Video".equals(paramString);
    boolean bool3 = true;
    boolean bool2;
    if (bool1)
    {
      if ((paramBundle != null) && (paramBundle.getBoolean("Key_trtc_source_mute", false))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramString = TRTCEngineProxy.a().c(false);
      bool2 = bool3;
      if (paramString != null)
      {
        paramString.a(bool1);
        return true;
      }
    }
    else if ("Action_Client_Screen_Set_Mute_Bitmap".equals(paramString))
    {
      TRTCEngineProxy.a().p();
      int i;
      if (paramBundle != null)
      {
        paramString = (Bitmap)paramBundle.getParcelable("Key_trtc_source_mute_bitmap");
        i = paramBundle.getInt("Key_trtc_source_mute_fps", 0);
      }
      else
      {
        i = 0;
        paramString = localObject;
      }
      paramBundle = TRTCEngineProxy.a().c(false);
      bool2 = bool3;
      if (paramBundle != null)
      {
        bool2 = bool3;
        if (paramString != null)
        {
          paramBundle.a(paramString, i);
          return true;
        }
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public TRTCVideoQualityParams b()
  {
    return null;
  }
  
  public boolean b(String paramString, Bundle paramBundle)
  {
    Object localObject1 = this.a;
    boolean bool = false;
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = "";
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("Key_TRTC_ErrCode", 0);
      localObject1 = paramBundle.getString("Key_TRTC_ErrMsg", "");
      localObject2 = paramBundle.getBundle("Key_TRTC_Extra");
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = null;
      i = 0;
      paramBundle = (Bundle)localObject2;
    }
    if ("Action_Server_Screen_Callback_On_Error".equals(paramString))
    {
      this.a.a(i, paramBundle, (Bundle)localObject1);
    }
    else if ("Action_Server_Screen_Callback_Start".equals(paramString))
    {
      this.a.a();
    }
    else
    {
      if (!"Action_Server_Screen_Callback_Stop".equals(paramString)) {
        break label136;
      }
      this.a.c(i);
    }
    bool = true;
    label136:
    return bool;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    this.a = null;
    TRTCServerIPCModule.a().b(this);
  }
  
  public void f()
  {
    TRTCServerIPCModule.a("Action_Client_Screen_Stop", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.video.source.screen.TRTCFakeScreenCaptureSource
 * JD-Core Version:    0.7.0.1
 */