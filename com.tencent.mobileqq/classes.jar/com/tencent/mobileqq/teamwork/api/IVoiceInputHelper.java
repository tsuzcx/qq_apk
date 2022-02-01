package com.tencent.mobileqq.teamwork.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVoiceInputHelper
  extends QRouteApi
{
  public static final String APP_ID = "wxcd8072f67d2d78d4";
  public static final long DELAY_AUDIO_PERMISSION_UNCERTAIN = 10000L;
  public static final int ERROR_AUDIO_PERMISSION_DENIED = 1830001;
  public static final int ERROR_AUDIO_PERMISSION_UNCERTAIN = 1830002;
  public static final String METHOD_RECORD_CHECK_PERMISSION = "recordCheckPermission";
  public static final String METHOD_VOICE_INPUT_SETUP = "voiceInputSetup";
  public static final String METHOD_VOICE_INPUT_START = "voiceInputStart";
  public static final String METHOD_VOICE_INPUT_STOP = "voiceInputStop";
  public static final int MSG_AUDIO_PERMISSION_UNCERTAIN = 1;
  public static final int REQUEST_CODE_AUDIO_PERMISSION = 1818;
  
  public abstract boolean checkPermission(String paramString);
  
  public abstract void destroy();
  
  public abstract boolean isInitialized();
  
  public abstract void preInit(AppInterface paramAppInterface);
  
  public abstract boolean setup();
  
  public abstract boolean start(String paramString);
  
  public abstract boolean stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IVoiceInputHelper
 * JD-Core Version:    0.7.0.1
 */