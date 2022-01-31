package com.tencent.qqmini.sdk.minigame.plugins;

import android.os.Build.VERSION;
import behq;
import bekr;
import bekx;
import bell;
import beuy;
import bexk;
import bexw;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
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
  private static final String TAG = "WebAudioPlugin";
  private ITTEngine mTTEngine;
  private AtomicInteger sId = new AtomicInteger();
  
  public String audioBufferCopyFromChannel(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    return "{}";
  }
  
  public String audioBufferCopyToChannel(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).optInt("sourceId", -1);
      int k = ((JSONObject)localObject).getInt("channelId");
      int m = ((JSONObject)localObject).optInt("startInChannel", 0);
      localObject = bell.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((bell)localObject).jdField_a_of_type_ArrayOfByte;
        if ((localObject != null) && (localObject.length != 0))
        {
          bexk.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL data.length " + localObject.length);
          i = bexw.a().a((byte[])localObject, i, j, k, m);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("bufferId", i);
          bexk.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL newBufferId: " + i);
          parambekr = bekx.a(parambekr.a, (JSONObject)localObject).toString();
          return parambekr;
        }
      }
    }
    catch (JSONException parambekr)
    {
      parambekr.printStackTrace();
    }
    return "{}";
  }
  
  public String audioProcessingEventSetQueueBuffer(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      parambekr = new JSONObject(parambekr.b);
      int i = parambekr.optInt("channelId", -2);
      int j = parambekr.optInt("bufferId");
      bexw.a().a(i, j);
      return "{}";
    }
    catch (JSONException parambekr)
    {
      for (;;)
      {
        parambekr.printStackTrace();
      }
    }
  }
  
  public String closeWebAudioContext(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    bexw.a().a();
    return bekx.a(parambekr.a, null).toString();
  }
  
  public String createWebAudioBufferSource(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambekr.b).getInt("audioId");
      JSONObject localJSONObject = bexw.a().a(i);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioContext(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    JSONObject localJSONObject = bexw.a().a(parambekr.b);
    return bekx.a(parambekr.a, localJSONObject).toString();
  }
  
  public String createWebAudioContextBuffer(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      int i = localJSONObject.optInt("numOfChannels", 1);
      int j = localJSONObject.optInt("length");
      int k = localJSONObject.optInt("sampleRate");
      localJSONObject = bexw.a().a(i, j, k);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioGain(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 5);
      localJSONObject.put("channelId", -1);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_CREATE_GAIN error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioScriptProcessor(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      int i = localJSONObject.optInt("bufferSize");
      int j = localJSONObject.optInt("inputChannelNum");
      int k = localJSONObject.optInt("outputChannelNum");
      bexw.a().a(parambekr, i, j, k);
      return "{}";
    }
    catch (JSONException parambekr)
    {
      for (;;)
      {
        parambekr.printStackTrace();
      }
    }
  }
  
  public String decodeWebAudioData(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      int i = this.sId.incrementAndGet();
      localObject = bell.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((bell)localObject).jdField_a_of_type_ArrayOfByte;
        if (Build.VERSION.SDK_INT >= 16) {
          bexw.a().a(i, (byte[])localObject, parambekr);
        }
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("decodeId", i);
      parambekr = bekx.a(parambekr.a, (JSONObject)localObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioBufferChannelData(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambekr.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).getInt("channelId");
      localObject = bexw.a().a(i, j);
      JSONObject localJSONObject = new JSONObject();
      bell.a(this.mMiniAppContext, (byte[])localObject, bell.jdField_a_of_type_Int, "data", localJSONObject);
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA data.length " + localObject.length);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentGain(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambekr.b).getInt("channelId");
      parambekr = bexw.a().a(i) + "";
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentTime(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambekr.b).getInt("audioId");
      parambekr = bexw.a().a(i) + "";
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioDestination(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 4);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public void onCreate(behq parambehq)
  {
    super.onCreate(parambehq);
    if ((this.mMiniAppContext instanceof beuy)) {
      this.mTTEngine = ((beuy)this.mMiniAppContext).a();
    }
  }
  
  public String operateWebAudioContext(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      parambekr = new JSONObject(parambekr.b).getString("operationType");
      if (parambekr.equals("suspend")) {
        bexw.a().b();
      }
      for (;;)
      {
        return "{}";
        if (parambekr.equals("resume")) {
          bexw.a().c();
        }
      }
    }
    catch (Throwable parambekr)
    {
      for (;;)
      {
        bexk.a().e("WebAudioPlugin", "handleNativeRequest API_OPERATE_WEB_AUDIO_CONTEXT error " + parambekr.getMessage());
      }
    }
  }
  
  public String setWebAudioBufferSourceLoop(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      boolean bool = localJSONObject.getBoolean("loop");
      int i = localJSONObject.getInt("channelId");
      bexw.a().a(i, bool);
      parambekr = bekx.a(parambekr.a, null).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioCurrentGain(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      int i = localJSONObject.getInt("channelId");
      double d = localJSONObject.getDouble("data");
      bexw.a().a(i, d);
      parambekr = bekx.a(parambekr.a, null).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioSourceBuffer(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.getInt("bufferId");
      localJSONObject = bexw.a().a(i, j);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String sourceStart(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      int m = localJSONObject.optInt("offset", 0);
      int n = localJSONObject.optInt("duration", -1);
      localJSONObject = bexw.a().a(parambekr, i, j, k, m, n);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_START error " + parambekr.getMessage());
    }
    return "{}";
  }
  
  public String sourceStop(bekr parambekr)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bekx.b(parambekr.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      localJSONObject = bexw.a().b(i, j, k);
      parambekr = bekx.a(parambekr.a, localJSONObject).toString();
      return parambekr;
    }
    catch (Throwable parambekr)
    {
      bexk.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_STOP error " + parambekr.getMessage());
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.WebAudioPlugin
 * JD-Core Version:    0.7.0.1
 */