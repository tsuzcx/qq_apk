package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.api.ApiUtil;
import com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAudioPlugin
  extends BaseJsPlugin
{
  public static final String API_CLOSE_WEB_AUDIO_CONTEXT = "closeWebAudioContext";
  public static final String API_COPY_FROM_CHANNEL = "audioBufferCopyFromChannel";
  public static final String API_COPY_TO_CHANNEL = "audioBufferCopyToChannel";
  public static final String API_CREATE_AUDIO_CONTEXT = "createWebAudioContext";
  public static final String API_CREATE_BUFFER = "createWebAudioContextBuffer";
  public static final String API_CREATE_BUFFER_SOURCE = "createWebAudioBufferSource";
  public static final String API_CREATE_GAIN = "createWebAudioGain";
  public static final String API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR = "createWebAudioScriptProcessor";
  public static final String API_DECODE_AUDIO_DATA = "decodeWebAudioData";
  public static final String API_GET_BUFFTER_CHANNEL_DATA = "getWebAudioBufferChannelData";
  public static final String API_GET_CURRENT_GAIN = "getWebAudioCurrentGain";
  public static final String API_GET_WEBAUDIO_SAMPLE_RATE = "getWebAudioSampleRate";
  public static final String API_GET_WEB_AUDIO_CURRENT_TIME = "getWebAudioCurrentTime";
  public static final String API_GET_WEB_AUDIO_DESTINATION = "getWebAudioDestination";
  public static final String API_ON_DECODE_AUDIO_DATA_DONE = "onDecodeWebAudioDataDone";
  public static final String API_ON_SOURCE_ENDED = "onWebAudioSourceEnded";
  public static final String API_ON_WEB_AUDIO_SCRIPT_PROCESSOR = "onWebAudioScriptProcessorAudioProcess";
  public static final String API_OPERATE_WEB_AUDIO_CONTEXT = "operateWebAudioContext";
  public static final String API_SET_BUFFER_SOURCE_LOOP = "setWebAudioBufferSourceLoop";
  public static final String API_SET_CURRENT_GAIN = "setWebAudioCurrentGain";
  public static final String API_SET_QUEUE_BUFFER = "audioProcessingEventSetQueueBuffer";
  public static final String API_SET_SOURCE_BUFFER = "setWebAudioSourceBuffer";
  public static final String API_SOURCE_START = "sourceStart";
  public static final String API_SOURCE_STOP = "sourceStop";
  public static final String API_WEB_AUDIO_CONNECT_AUDIO_NODE = "webAudioConnectAudioNode";
  private static final Set<String> S_EVENT_MAP = new WebAudioPlugin.1();
  private static final String TAG = "WebAudioPlugin";
  private ITTEngine mTTEngine = GameLoadManager.g().getGameEngine();
  private AtomicInteger sId = new AtomicInteger();
  
  private boolean getWebAudioSoLoadStatus()
  {
    return true;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    GameLog.getInstance().d("WebAudioPlugin", "handleNativeRequest " + paramString1 + " jsonParams " + paramString2);
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return ApiUtil.wrapCallbackFail(paramString1, null).toString();
    }
    if ("createWebAudioContext".equals(paramString1)) {
      return ApiUtil.wrapCallbackOk(paramString1, WebAudioManager.getInstance().createAudioContext(paramString2)).toString();
    }
    if ("closeWebAudioContext".equals(paramString1)) {
      try
      {
        paramInt = new JSONObject(paramString2).getInt("audioId");
        WebAudioManager.getInstance().closeAudioContext(paramInt);
        paramString1 = ApiUtil.wrapCallbackOk(paramString1, null).toString();
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_CLOSE_WEB_AUDIO_CONTEXT error " + paramString1.getMessage());
      }
    }
    for (;;)
    {
      return "{}";
      if ("operateWebAudioContext".equals(paramString1))
      {
        try
        {
          paramString1 = new JSONObject(paramString2).getString("operationType");
          if (!paramString1.equals("suspend")) {
            break label242;
          }
          WebAudioManager.getInstance().suspendAudioContext(this.mTTEngine);
        }
        catch (Throwable paramString1)
        {
          GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_OPERATE_WEB_AUDIO_CONTEXT error " + paramString1.getMessage());
        }
        continue;
        label242:
        if (paramString1.equals("resume")) {
          WebAudioManager.getInstance().resumeAudioContext(this.mTTEngine);
        }
      }
      else
      {
        int i;
        int j;
        int k;
        if ("createWebAudioContextBuffer".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramInt = paramString2.optInt("numOfChannels", 1);
            i = paramString2.optInt("length");
            j = paramString2.optInt("sampleRate");
            k = paramString2.getInt("audioId");
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, WebAudioManager.getInstance().createBuffer(k, paramInt, i, j)).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramString1.getMessage());
          }
        } else if ("createWebAudioBufferSource".equals(paramString1)) {
          try
          {
            paramInt = new JSONObject(paramString2).getInt("audioId");
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, WebAudioManager.getInstance().createBufferSource(paramInt)).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramString1.getMessage());
          }
        } else if ("setWebAudioSourceBuffer".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramInt = paramString2.getInt("channelId");
            i = paramString2.getInt("bufferId");
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, WebAudioManager.getInstance().setSourceBuffer(paramInt, i)).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramString1.getMessage());
          }
        } else if ("sourceStart".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramInt = paramString2.getInt("audioId");
            i = paramString2.getInt("channelId");
            j = paramString2.optInt("when", 0);
            k = paramString2.optInt("offset", 0);
            int m = paramString2.optInt("duration", -1);
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, WebAudioManager.getInstance().sourceStart(paramJsRuntime, paramInt, i, j, k, m)).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_START error " + paramString1.getMessage());
          }
        } else if ("sourceStop".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramInt = paramString2.getInt("audioId");
            i = paramString2.getInt("channelId");
            j = paramString2.optInt("when", 0);
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, WebAudioManager.getInstance().sourceStop(paramInt, i, j)).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_STOP error " + paramString1.getMessage());
          }
        } else if ("getWebAudioDestination".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject();
            paramString2.put("audioNodeType", 4);
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, paramString2).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + paramString1.getMessage());
          }
        } else if ("createWebAudioGain".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject();
            paramString2.put("audioNodeType", 5);
            paramString2.put("channelId", -1);
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, paramString2).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_CREATE_GAIN error " + paramString1.getMessage());
          }
        } else if ("getWebAudioCurrentGain".equals(paramString1)) {
          try
          {
            paramString1 = new JSONObject(paramString2);
            paramInt = paramString1.getInt("channelId");
            i = paramString1.getInt("audioId");
            paramString1 = WebAudioManager.getInstance().getCurrentGain(i, paramInt) + "";
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + paramString1.getMessage());
          }
        } else if ("setWebAudioBufferSourceLoop".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            boolean bool = paramString2.getBoolean("loop");
            paramInt = paramString2.getInt("channelId");
            i = paramString2.getInt("audioId");
            WebAudioManager.getInstance().setBufferSourceLoop(i, paramInt, bool);
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, null).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + paramString1.getMessage());
          }
        } else if ("getWebAudioCurrentTime".equals(paramString1)) {
          try
          {
            paramInt = new JSONObject(paramString2).getInt("audioId");
            paramString1 = WebAudioManager.getInstance().getAudioContextCurrentTime(paramInt) + "";
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + paramString1.getMessage());
          }
        } else if ("setWebAudioCurrentGain".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramInt = paramString2.getInt("channelId");
            double d = paramString2.getDouble("data");
            i = paramString2.getInt("audioId");
            WebAudioManager.getInstance().setCurrentGain(i, paramInt, d);
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, null).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + paramString1.getMessage());
          }
        } else if ("getWebAudioBufferChannelData".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramInt = paramString2.getInt("bufferId");
            i = paramString2.getInt("channelId");
            paramString2 = WebAudioManager.getInstance().getBufferChannelData(paramInt, i);
            paramJsRuntime = new JSONObject();
            NativeBuffer.packNativeBuffer((byte[])paramString2, NativeBuffer.TYPE_BUFFER_NATIVE, "data", paramJsRuntime, this.mTTEngine.getNativeBufferPool());
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, paramJsRuntime).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + paramString1.getMessage());
          }
        } else if ("decodeWebAudioData".equals(paramString1)) {
          try
          {
            paramString2 = new JSONObject(paramString2);
            paramInt = this.sId.incrementAndGet();
            paramString2 = NativeBuffer.unpackNativeBuffer(paramString2, "data", this.mTTEngine.getNativeBufferPool());
            if (paramString2 != null)
            {
              paramString2 = paramString2.buf;
              if (Build.VERSION.SDK_INT >= 16) {
                WebAudioManager.getInstance().decodeAudioDataAndReturnBufferIdAsync(paramInt, paramString2, paramJsRuntime);
              }
            }
            paramString2 = new JSONObject();
            paramString2.put("decodeId", paramInt);
            paramString1 = ApiUtil.wrapCallbackOk(paramString1, paramString2).toString();
            return paramString1;
          }
          catch (Throwable paramString1)
          {
            GameLog.getInstance().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + paramString1.getMessage());
          }
        } else if (!"audioBufferCopyFromChannel".equals(paramString1)) {
          if ("audioBufferCopyToChannel".equals(paramString1)) {
            try
            {
              paramString2 = new JSONObject(paramString2);
              paramInt = paramString2.getInt("bufferId");
              i = paramString2.optInt("sourceId", -1);
              j = paramString2.getInt("channelId");
              k = paramString2.optInt("startInChannel", 0);
              paramString2 = NativeBuffer.unpackNativeBuffer(paramString2, "data", this.mTTEngine.getNativeBufferPool());
              if (paramString2 == null) {
                continue;
              }
              paramString2 = paramString2.buf;
              if ((paramString2 == null) || (paramString2.length == 0)) {
                continue;
              }
              paramInt = WebAudioManager.getInstance().copyToChannel(paramString2, paramInt, i, j, k);
              paramString2 = new JSONObject();
              paramString2.put("bufferId", paramInt);
              paramString1 = ApiUtil.wrapCallbackOk(paramString1, paramString2).toString();
              return paramString1;
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          } else if ("createWebAudioScriptProcessor".equals(paramString1)) {
            try
            {
              paramString1 = new JSONObject(paramString2);
              paramInt = paramString1.optInt("bufferSize");
              i = paramString1.optInt("inputChannelNum");
              j = paramString1.optInt("outputChannelNum");
              k = paramString1.getInt("audioId");
              WebAudioManager.getInstance().createScriptProcessor(paramJsRuntime, k, paramInt, i, j);
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          } else if ("audioProcessingEventSetQueueBuffer".equals(paramString1)) {
            try
            {
              paramString1 = new JSONObject(paramString2);
              paramInt = paramString1.optInt("channelId", -2);
              i = paramString1.optInt("bufferId");
              WebAudioManager.getInstance().setQueueBuffer(paramInt, i);
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          } else if ("webAudioConnectAudioNode".equals(paramString1)) {
            try
            {
              paramString1 = new JSONObject(paramString2);
              paramInt = paramString1.optInt("oriAudioNodeType", -1);
              paramString1.optInt("channelId", -2);
              paramString1.optInt("audioNodeType");
              i = paramString1.getInt("audioId");
              if (paramInt == WebAudioManager.SCRIPT_PROCESSOR_AUDIO_NODE_TYPE) {
                WebAudioManager.getInstance().startAudioProcess(paramJsRuntime, i);
              }
            }
            catch (JSONException paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.WebAudioPlugin
 * JD-Core Version:    0.7.0.1
 */