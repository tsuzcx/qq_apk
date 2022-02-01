package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.WXTRTCCloud;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class WXLivePusher$4
  extends TRTCCloudListener
{
  WXLivePusher$4(WXLivePusher paramWXLivePusher) {}
  
  private JSONObject getAudioAvailableJSONObject(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString1);
      localJSONObject.put("playurl", paramString2);
      localJSONObject.put("hasaudio", paramBoolean);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      TXCLog.e("WXLivePusher", "build json object failed.", paramString1);
    }
    return null;
  }
  
  private JSONObject getUserEnterJSONObject(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      TXCLog.e("WXLivePusher", "build json object failed.", paramString);
    }
    return null;
  }
  
  private JSONObject getUserExitJSONObject(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      TXCLog.e("WXLivePusher", "build json object failed.", paramString);
    }
    return null;
  }
  
  private JSONObject getVideoAvailableJSONObject(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString1);
      localJSONObject.put("playurl", paramString2);
      localJSONObject.put("streamtype", paramString3);
      localJSONObject.put("hasvideo", paramBoolean);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      TXCLog.e("WXLivePusher", "build json object failed.", paramString1);
    }
    return null;
  }
  
  private void sendEventNotify(int paramInt)
  {
    if (WXLivePusher.access$000(this.this$0) != null)
    {
      ITXLivePushListener localITXLivePushListener = (ITXLivePushListener)WXLivePusher.access$000(this.this$0).get();
      if (localITXLivePushListener != null) {
        localITXLivePushListener.onPushEvent(paramInt, new Bundle());
      }
    }
  }
  
  private void sendEventNotify(int paramInt, String paramString)
  {
    if (WXLivePusher.access$000(this.this$0) != null)
    {
      ITXLivePushListener localITXLivePushListener = (ITXLivePushListener)WXLivePusher.access$000(this.this$0).get();
      if (localITXLivePushListener != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("EVT_MSG", paramString);
        localITXLivePushListener.onPushEvent(paramInt, localBundle);
      }
    }
  }
  
  private void sendEventNotify(int paramInt, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new JSONArray();
      ((JSONArray)localObject).put(paramJSONObject);
      localJSONObject.put("userlist", localObject);
      if (WXLivePusher.access$000(this.this$0) != null)
      {
        paramJSONObject = (ITXLivePushListener)WXLivePusher.access$000(this.this$0).get();
        if (paramJSONObject != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("EVT_MSG", localJSONObject.toString());
          paramJSONObject.onPushEvent(paramInt, (Bundle)localObject);
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      TXCLog.e("WXLivePusher", "send event failed.", paramJSONObject);
    }
  }
  
  public void onEnterRoom(long paramLong)
  {
    super.onEnterRoom(paramLong);
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom result: ");
    localStringBuilder.append(paramLong);
    ((WXLivePusher)localObject).apiOnlineLog(localStringBuilder.toString(), true);
    if (paramLong > 0L)
    {
      WXLivePusher.access$202(this.this$0, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEnterRoom success, time cost[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      sendEventNotify(1018, ((StringBuilder)localObject).toString());
      if (WXLivePusher.access$300(this.this$0))
      {
        if ((!WXLivePusher.access$400(this.this$0)) && (!WXLivePusher.access$500(this.this$0)))
        {
          WXLivePusher.access$600(this.this$0).switchRole(21);
          return;
        }
        WXLivePusher.access$600(this.this$0).switchRole(20);
      }
    }
    else
    {
      WXLivePusher.access$202(this.this$0, false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEnterRoom failed, error code[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      sendEventNotify(1022, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    super.onError(paramInt, paramString, paramBundle);
  }
  
  public void onExitRoom(int paramInt)
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom reason: ");
    localStringBuilder.append(paramInt);
    ((WXLivePusher)localObject).apiOnlineLog(localStringBuilder.toString(), true);
    super.onExitRoom(paramInt);
    WXLivePusher.access$202(this.this$0, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onExitRoom reason[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    sendEventNotify(1019, ((StringBuilder)localObject).toString());
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    WXLivePusher.access$600(this.this$0).notifySEIMessage(paramString, paramArrayOfByte);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    super.onUserEnter(paramString);
    WXLivePusher localWXLivePusher = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemoteUserEnterRoom userId: ");
    localStringBuilder.append(paramString);
    localWXLivePusher.apiOnlineLog(localStringBuilder.toString(), true);
    sendEventNotify(1031, getUserEnterJSONObject(paramString));
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    super.onUserExit(paramString, paramInt);
    WXLivePusher localWXLivePusher = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemoteUserLeaveRoom userId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", reason: ");
    localStringBuilder.append(paramInt);
    localWXLivePusher.apiOnlineLog(localStringBuilder.toString(), true);
    sendEventNotify(1032, getUserExitJSONObject(paramString));
  }
  
  public void onStatistics(TRTCStatistics paramTRTCStatistics)
  {
    WXLivePusher.access$600(this.this$0).notifyStatistics(paramTRTCStatistics);
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserAudioAvailable(paramString, paramBoolean);
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserAudioAvailable userId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", available: ");
    localStringBuilder.append(paramBoolean);
    ((WXLivePusher)localObject).apiOnlineLog(localStringBuilder.toString(), true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("room://cloud.tencent.com/rtc?userid=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&streamtype=main");
    sendEventNotify(1034, getAudioAvailableJSONObject(paramString, ((StringBuilder)localObject).toString(), paramBoolean));
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserSubStreamAvailable(paramString, paramBoolean);
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserSubStreamAvailable userId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", available: ");
    localStringBuilder.append(paramBoolean);
    ((WXLivePusher)localObject).apiOnlineLog(localStringBuilder.toString(), true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("room://cloud.tencent.com/rtc?userid=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&streamtype=aux");
    localObject = ((StringBuilder)localObject).toString();
    if (paramBoolean) {
      sendEventNotify(1033, getVideoAvailableJSONObject(paramString, (String)localObject, "aux", true));
    } else {
      sendEventNotify(1033, getVideoAvailableJSONObject(paramString, (String)localObject, "aux", false));
    }
    WXLivePusher.access$800(this.this$0, paramBoolean, paramString, (String)localObject);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserVideoAvailable(paramString, paramBoolean);
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserVideoAvailable userId: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", available: ");
    localStringBuilder.append(paramBoolean);
    ((WXLivePusher)localObject).apiOnlineLog(localStringBuilder.toString(), true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("room://cloud.tencent.com/rtc?userid=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&streamtype=main");
    localObject = ((StringBuilder)localObject).toString();
    sendEventNotify(1033, getVideoAvailableJSONObject(paramString, (String)localObject, "main", paramBoolean));
    if (paramBoolean)
    {
      WXLivePusher.access$700(this.this$0, true, paramString, (String)localObject);
      return;
    }
    WXLivePusher.access$700(this.this$0, false, paramString, "");
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    if (WXLivePusher.access$900(this.this$0) > 0)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = (TRTCCloudDef.TRTCVolumeInfo)localIterator.next();
        if ((localTRTCVolumeInfo != null) && (localTRTCVolumeInfo.userId != null) && (WXLivePusher.access$1000(this.this$0) != null) && (localTRTCVolumeInfo.userId.equalsIgnoreCase(WXLivePusher.access$1000(this.this$0).userId))) {
          if (WXLivePusher.access$1100(this.this$0) != null) {
            WXLivePusher.access$1100(this.this$0).onAudioVolumeEvaluationNotify(localTRTCVolumeInfo.volume);
          }
        }
      }
    }
    WXLivePusher.access$600(this.this$0).notifyUserVoiceVolume(paramArrayList, paramInt);
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    super.onWarning(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher.4
 * JD-Core Version:    0.7.0.1
 */