package com.tencent.qqmini.sdk.minigame.plugins;

import android.os.Build.VERSION;
import bglv;
import bgok;
import bgop;
import bgpi;
import bgxq;
import bhaj;
import bhaw;
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
  private bhaw mWebAudioManager;
  private AtomicInteger sId = new AtomicInteger();
  
  public String audioBufferCopyFromChannel(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    return "{}";
  }
  
  public String audioBufferCopyToChannel(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).optInt("sourceId", -1);
      int k = ((JSONObject)localObject).getInt("channelId");
      int m = ((JSONObject)localObject).optInt("startInChannel", 0);
      localObject = bgpi.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((bgpi)localObject).jdField_a_of_type_ArrayOfByte;
        if ((localObject != null) && (localObject.length != 0))
        {
          bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL data.length " + localObject.length);
          i = bhaw.a().a((byte[])localObject, i, j, k, m);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("bufferId", i);
          bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_COPY_TO_CHANNEL newBufferId: " + i);
          parambgok = bgop.a(parambgok.a, (JSONObject)localObject).toString();
          return parambgok;
        }
      }
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
    return "{}";
  }
  
  public String audioProcessingEventSetQueueBuffer(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      parambgok = new JSONObject(parambgok.b);
      int i = parambgok.optInt("channelId", -2);
      int j = parambgok.optInt("bufferId");
      bhaw.a().a(i, j);
      return "{}";
    }
    catch (JSONException parambgok)
    {
      for (;;)
      {
        parambgok.printStackTrace();
      }
    }
  }
  
  public String closeWebAudioContext(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambgok.b).getInt("audioId");
      bhaw.a().a(i);
      parambgok = bgop.a(parambgok.a, null).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_CLOSE_WEB_AUDIO_CONTEXT error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioBufferSource(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambgok.b).getInt("audioId");
      JSONObject localJSONObject = bhaw.a().a(i);
      parambgok = bgop.a(parambgok.a, localJSONObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioContext(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    JSONObject localJSONObject = bhaw.a().a(parambgok.b);
    return bgop.a(parambgok.a, localJSONObject).toString();
  }
  
  public String createWebAudioContextBuffer(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.optInt("numOfChannels", 1);
      int j = localJSONObject.optInt("length");
      int k = localJSONObject.optInt("sampleRate");
      int m = localJSONObject.getInt("audioId");
      localJSONObject = bhaw.a().a(m, i, j, k);
      parambgok = bgop.a(parambgok.a, localJSONObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioGain(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 5);
      localJSONObject.put("channelId", -1);
      parambgok = bgop.a(parambgok.a, localJSONObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_CREATE_GAIN error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String createWebAudioScriptProcessor(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.optInt("bufferSize");
      int j = localJSONObject.optInt("inputChannelNum");
      int k = localJSONObject.optInt("outputChannelNum");
      int m = localJSONObject.getInt("audioId");
      bhaw.a().a(parambgok, m, i, j, k);
      return "{}";
    }
    catch (JSONException parambgok)
    {
      for (;;)
      {
        parambgok.printStackTrace();
      }
    }
  }
  
  public String decodeWebAudioData(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      int i = this.sId.incrementAndGet();
      localObject = bgpi.a(this.mMiniAppContext, (JSONObject)localObject, "data");
      if (localObject != null)
      {
        localObject = ((bgpi)localObject).jdField_a_of_type_ArrayOfByte;
        if (Build.VERSION.SDK_INT >= 16) {
          bhaw.a().a(i, (byte[])localObject, parambgok);
        }
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("decodeId", i);
      parambgok = bgop.a(parambgok.a, (JSONObject)localObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioBufferChannelData(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      Object localObject = new JSONObject(parambgok.b);
      int i = ((JSONObject)localObject).getInt("bufferId");
      int j = ((JSONObject)localObject).getInt("channelId");
      localObject = bhaw.a().a(i, j);
      JSONObject localJSONObject = new JSONObject();
      bgpi.a(this.mMiniAppContext, (byte[])localObject, bgpi.jdField_a_of_type_Int, "data", localJSONObject);
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA data.length " + localObject.length);
      parambgok = bgop.a(parambgok.a, localJSONObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_GET_BUFFTER_CHANNEL_DATA error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentGain(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      parambgok = new JSONObject(parambgok.b);
      int i = parambgok.getInt("channelId");
      int j = parambgok.getInt("audioId");
      parambgok = bhaw.a().a(j, i) + "";
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioCurrentTime(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      int i = new JSONObject(parambgok.b).getInt("audioId");
      parambgok = bhaw.a().a(i) + "";
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String getWebAudioDestination(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioNodeType", 4);
      parambgok = bgop.a(parambgok.a, localJSONObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    if ((this.mMiniAppContext instanceof bgxq)) {
      this.mTTEngine = ((bgxq)this.mMiniAppContext).a();
    }
    bhaw.a().a(this.mTTEngine);
  }
  
  public String operateWebAudioContext(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      parambgok = new JSONObject(parambgok.b).getString("operationType");
      if (parambgok.equals("suspend")) {
        bhaw.a().c(this.mTTEngine);
      }
      for (;;)
      {
        return "{}";
        if (parambgok.equals("resume")) {
          bhaw.a().d(this.mTTEngine);
        }
      }
    }
    catch (Throwable parambgok)
    {
      for (;;)
      {
        bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_OPERATE_WEB_AUDIO_CONTEXT error " + parambgok.getMessage());
      }
    }
  }
  
  public String setWebAudioBufferSourceLoop(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      boolean bool = localJSONObject.getBoolean("loop");
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.getInt("audioId");
      bhaw.a().a(j, i, bool);
      parambgok = bgop.a(parambgok.a, null).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SET_BUFFER_SOURCE_LOOP error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioCurrentGain(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.getInt("channelId");
      double d = localJSONObject.getDouble("data");
      int j = localJSONObject.getInt("audioId");
      bhaw.a().a(j, i, d);
      parambgok = bgop.a(parambgok.a, null).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_GET_CURRENT_GAIN error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String setWebAudioSourceBuffer(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.getInt("channelId");
      int j = localJSONObject.optInt("bufferId", -1);
      int k = localJSONObject.optInt("decodeId", -1);
      if (j != -1)
      {
        localJSONObject = bhaw.a().a(i, j);
        return bgop.a(parambgok.a, localJSONObject).toString();
      }
      if (k != -1)
      {
        localJSONObject = bhaw.a().b(i, k);
        parambgok = bgop.a(parambgok.a, localJSONObject).toString();
        return parambgok;
      }
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SET_SOURCE_BUFFER error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String sourceStart(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      int m = localJSONObject.optInt("offset", 0);
      int n = localJSONObject.optInt("duration", -1);
      localJSONObject = bhaw.a().a(parambgok, i, j, k, m, n);
      parambgok = bgop.a(parambgok.a, localJSONObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_START error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String sourceStop(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.getInt("audioId");
      int j = localJSONObject.getInt("channelId");
      int k = localJSONObject.optInt("when", 0);
      localJSONObject = bhaw.a().a(i, j, k);
      parambgok = bgop.a(parambgok.a, localJSONObject).toString();
      return parambgok;
    }
    catch (Throwable parambgok)
    {
      bhaj.a().e("WebAudioPlugin", "handleNativeRequest API_SOURCE_STOP error " + parambgok.getMessage());
    }
    return "{}";
  }
  
  public String webAudioConnectAudioNode(bgok parambgok)
  {
    if (!this.mTTEngine.getOptionalSoLoadStatus("webAudio")) {
      return bgop.b(parambgok.a, null).toString();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int i = localJSONObject.optInt("oriAudioNodeType", -1);
      localJSONObject.optInt("channelId", -2);
      localJSONObject.optInt("audioNodeType");
      int j = localJSONObject.getInt("audioId");
      if (i == bhaw.jdField_a_of_type_Int) {
        bhaw.a().a(parambgok, j);
      }
      return "{}";
    }
    catch (JSONException parambgok)
    {
      for (;;)
      {
        parambgok.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.WebAudioPlugin
 * JD-Core Version:    0.7.0.1
 */