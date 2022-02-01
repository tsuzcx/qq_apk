package com.tencent.mobileqq.voicechange;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IVoiceChangeManager
  extends QRouteApi
{
  public abstract String getTagIconURL(int paramInt);
  
  public abstract String getVoiceChangeRootDir();
  
  public abstract boolean preCheckData(ArrayList<VoiceChangeData> paramArrayList, JSONObject paramJSONObject, AppRuntime paramAppRuntime);
  
  public abstract boolean queryStateByPath(String paramString, IVoiceChangeHelper.IOnCompressFinish paramIOnCompressFinish);
  
  public abstract void requestToCancel(VoiceChangeBasicParams paramVoiceChangeBasicParams);
  
  public abstract void requestToPause(VoiceChangeBasicParams paramVoiceChangeBasicParams);
  
  public abstract void requestToSend(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener);
  
  public abstract void requestToStart(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener);
  
  public abstract void requestToStart(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener, VoiceChangeModeParams paramVoiceChangeModeParams);
  
  public abstract void voiceChangeEnd(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.IVoiceChangeManager
 * JD-Core Version:    0.7.0.1
 */