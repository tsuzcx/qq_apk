package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioRecordingParams;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.WXTRTCCloud;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

public class WXLivePusher
  extends TXLivePusher
{
  private static final String RTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
  private static final String RTC_ADDRESS2 = "room://rtc.tencent.com";
  private static final String RTMP_PROXY_ADDRESS = "room://cloud.tencent.com";
  private static final String TAG = "WXLivePusher";
  private int mAppScene = 0;
  private int mAudioVolumeEvaluationInterval = 0;
  private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener = null;
  private boolean mAutoRecvAudio = true;
  private boolean mAutoRecvVideo = true;
  private WeakReference<TXLivePusher.OnBGMNotify> mBGMNotify = null;
  private boolean mEnterRoom = false;
  private boolean mIsRtmpProxy = false;
  private boolean mIsTRTC = false;
  private HashMap<String, String> mMapMainStream = new HashMap();
  private HashMap<String, String> mMapSubStream = new HashMap();
  private boolean mNeedCheckRole = false;
  private WXLivePushConfig mPushConfig = new WXLivePushConfig();
  private WeakReference<ITXLivePushListener> mPushListener = null;
  private boolean mStartAudio = false;
  private boolean mStartPreview = false;
  private WXTRTCCloud mTRTCCloud = null;
  private TRTCCloudListener mTRTCCloudListener = new WXLivePusher.4(this);
  private TRTCCloudDef.TRTCParams mTRTCParams = null;
  private TXCloudVideoView mVideoView = null;
  
  public WXLivePusher(Context paramContext)
  {
    super(paramContext);
    this.mTRTCCloud = WXTRTCCloud.sharedInstance(paramContext);
    this.mTRTCCloud.setListener(this.mTRTCCloudListener);
  }
  
  private void checkSwitchAnchor()
  {
    if ((this.mIsTRTC) && (this.mNeedCheckRole) && (this.mEnterRoom) && ((this.mStartPreview) || (this.mStartAudio))) {
      this.mTRTCCloud.switchRole(20);
    }
  }
  
  private void checkSwitchAudience()
  {
    if ((this.mIsTRTC) && (this.mNeedCheckRole) && (this.mEnterRoom) && (!this.mStartPreview) && (!this.mStartAudio)) {
      this.mTRTCCloud.switchRole(21);
    }
  }
  
  private void clearMainStream()
  {
    try
    {
      this.mMapMainStream.clear();
      return;
    }
    finally {}
  }
  
  private void clearSubStream()
  {
    try
    {
      this.mMapSubStream.clear();
      return;
    }
    finally {}
  }
  
  private int internalStartDumpAudioData(String paramString)
  {
    TXCAudioEngine.getInstance().setAudioDumpingListener(new WXLivePusher.1(this));
    return TXCAudioEngine.getInstance().startLocalAudioDumping(48000, 16, paramString);
  }
  
  private void internalStopDumpAudioData()
  {
    TXCAudioEngine.getInstance().stopLocalAudioDumping();
  }
  
  private boolean isRtmpProxyUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.startsWith("room://cloud.tencent.com/rtc"))
    {
      if (paramString.startsWith("room://rtc.tencent.com")) {
        return false;
      }
      return paramString.startsWith("room://cloud.tencent.com");
    }
    return false;
  }
  
  private boolean isTRTCPusherUrl(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.startsWith("room://cloud.tencent.com/rtc")) || (paramString.startsWith("room://rtc.tencent.com"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  /* Error */
  private void notifyFullUserList()
  {
    // Byte code:
    //   0: new 202	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 203	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: new 205	org/json/JSONArray
    //   11: dup
    //   12: invokespecial 206	org/json/JSONArray:<init>	()V
    //   15: astore_2
    //   16: aload_1
    //   17: ldc 208
    //   19: aload_2
    //   20: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   23: pop
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 94	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   30: invokevirtual 216	java/util/HashMap:keySet	()Ljava/util/Set;
    //   33: invokeinterface 222 1 0
    //   38: astore_3
    //   39: aload_3
    //   40: invokeinterface 228 1 0
    //   45: ifeq +60 -> 105
    //   48: aload_3
    //   49: invokeinterface 232 1 0
    //   54: checkcast 193	java/lang/String
    //   57: astore 4
    //   59: new 202	org/json/JSONObject
    //   62: dup
    //   63: invokespecial 203	org/json/JSONObject:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: ldc 234
    //   72: aload 4
    //   74: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   77: pop
    //   78: aload 5
    //   80: ldc 236
    //   82: aload_0
    //   83: getfield 94	com/tencent/rtmp/WXLivePusher:mMapMainStream	Ljava/util/HashMap;
    //   86: aload 4
    //   88: invokevirtual 240	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload_2
    //   96: aload 5
    //   98: invokevirtual 243	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   101: pop
    //   102: goto -63 -> 39
    //   105: aload_0
    //   106: monitorexit
    //   107: new 205	org/json/JSONArray
    //   110: dup
    //   111: invokespecial 206	org/json/JSONArray:<init>	()V
    //   114: astore_2
    //   115: aload_1
    //   116: ldc 245
    //   118: aload_2
    //   119: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload_0
    //   124: monitorenter
    //   125: aload_0
    //   126: getfield 96	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   129: invokevirtual 216	java/util/HashMap:keySet	()Ljava/util/Set;
    //   132: invokeinterface 222 1 0
    //   137: astore_3
    //   138: aload_3
    //   139: invokeinterface 228 1 0
    //   144: ifeq +60 -> 204
    //   147: aload_3
    //   148: invokeinterface 232 1 0
    //   153: checkcast 193	java/lang/String
    //   156: astore 4
    //   158: new 202	org/json/JSONObject
    //   161: dup
    //   162: invokespecial 203	org/json/JSONObject:<init>	()V
    //   165: astore 5
    //   167: aload 5
    //   169: ldc 234
    //   171: aload 4
    //   173: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: pop
    //   177: aload 5
    //   179: ldc 236
    //   181: aload_0
    //   182: getfield 96	com/tencent/rtmp/WXLivePusher:mMapSubStream	Ljava/util/HashMap;
    //   185: aload 4
    //   187: invokevirtual 240	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   190: invokevirtual 212	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload_2
    //   195: aload 5
    //   197: invokevirtual 243	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   200: pop
    //   201: goto -63 -> 138
    //   204: aload_0
    //   205: monitorexit
    //   206: aload_0
    //   207: getfield 78	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   210: ifnull +68 -> 278
    //   213: aload_0
    //   214: getfield 78	com/tencent/rtmp/WXLivePusher:mPushListener	Ljava/lang/ref/WeakReference;
    //   217: invokevirtual 249	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   220: checkcast 251	com/tencent/rtmp/ITXLivePushListener
    //   223: astore_2
    //   224: aload_2
    //   225: ifnull +53 -> 278
    //   228: new 253	android/os/Bundle
    //   231: dup
    //   232: invokespecial 254	android/os/Bundle:<init>	()V
    //   235: astore_3
    //   236: aload_3
    //   237: ldc_w 256
    //   240: aload_1
    //   241: invokevirtual 260	org/json/JSONObject:toString	()Ljava/lang/String;
    //   244: invokevirtual 264	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_2
    //   248: sipush 1020
    //   251: aload_3
    //   252: invokeinterface 268 3 0
    //   257: return
    //   258: astore_1
    //   259: aload_0
    //   260: monitorexit
    //   261: aload_1
    //   262: athrow
    //   263: astore_1
    //   264: aload_0
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: ldc 17
    //   271: ldc_w 270
    //   274: aload_1
    //   275: invokestatic 276	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	WXLivePusher
    //   7	234	1	localJSONObject1	JSONObject
    //   258	4	1	localObject1	Object
    //   263	4	1	localObject2	Object
    //   268	7	1	localException	Exception
    //   15	233	2	localObject3	Object
    //   38	214	3	localObject4	Object
    //   57	129	4	str	String
    //   66	130	5	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   125	138	258	finally
    //   138	201	258	finally
    //   204	206	258	finally
    //   259	261	258	finally
    //   26	39	263	finally
    //   39	102	263	finally
    //   105	107	263	finally
    //   264	266	263	finally
    //   0	26	268	java/lang/Exception
    //   107	125	268	java/lang/Exception
    //   206	224	268	java/lang/Exception
    //   228	257	268	java/lang/Exception
    //   261	263	268	java/lang/Exception
    //   266	268	268	java/lang/Exception
  }
  
  private void notifyMainStreamChange(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {}
    try
    {
      this.mMapMainStream.put(paramString1, paramString2);
      break label28;
      this.mMapMainStream.remove(paramString1);
      label28:
      notifyFullUserList();
      return;
    }
    finally {}
  }
  
  private void notifySubStreamChange(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {}
    try
    {
      this.mMapSubStream.put(paramString1, paramString2);
      break label28;
      this.mMapSubStream.remove(paramString1);
      label28:
      notifyFullUserList();
      return;
    }
    finally {}
  }
  
  private boolean parseTRTCParams(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i3 = 0;
    if (bool) {
      return false;
    }
    Object localObject6;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    int k;
    int j;
    int i;
    try
    {
      String[] arrayOfString = paramString.split("[?&]");
      int i4 = arrayOfString.length;
      localObject6 = "";
      localObject5 = localObject6;
      localObject4 = localObject5;
      localObject3 = localObject4;
      localObject2 = localObject3;
      localObject1 = localObject2;
      int i1 = 0;
      k = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        i2 = k;
        m = j;
        localObject9 = localObject6;
        localObject11 = localObject5;
        localObject10 = localObject4;
        localObject8 = localObject3;
        localObject7 = localObject2;
        paramString = (String)localObject1;
        n = i;
        if (i1 >= i4) {
          break label1940;
        }
        paramString = arrayOfString[i1];
        m = k;
        n = j;
        localObject7 = localObject6;
        localObject8 = localObject5;
        localObject9 = localObject4;
        localObject10 = localObject3;
        localObject11 = localObject2;
        Object localObject12 = localObject1;
        i2 = i;
        try
        {
          if (paramString.indexOf("=") != -1)
          {
            paramString = paramString.split("[=]");
            m = k;
            n = j;
            localObject7 = localObject6;
            localObject8 = localObject5;
            localObject9 = localObject4;
            localObject10 = localObject3;
            localObject11 = localObject2;
            localObject12 = localObject1;
            i2 = i;
            if (paramString.length == 2)
            {
              CharSequence localCharSequence = paramString[0];
              paramString = paramString[1];
              m = k;
              n = j;
              localObject7 = localObject6;
              localObject8 = localObject5;
              localObject9 = localObject4;
              localObject10 = localObject3;
              localObject11 = localObject2;
              localObject12 = localObject1;
              i2 = i;
              if (!TextUtils.isEmpty(localCharSequence))
              {
                m = k;
                n = j;
                localObject7 = localObject6;
                localObject8 = localObject5;
                localObject9 = localObject4;
                localObject10 = localObject3;
                localObject11 = localObject2;
                localObject12 = localObject1;
                i2 = i;
                if (!TextUtils.isEmpty(paramString)) {
                  if (localCharSequence.equalsIgnoreCase("sdkappid"))
                  {
                    m = Integer.parseInt(paramString);
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                  }
                  else if (localCharSequence.equalsIgnoreCase("roomid"))
                  {
                    n = Long.valueOf(paramString).intValue();
                    m = k;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                  }
                  else if (localCharSequence.equalsIgnoreCase("userid"))
                  {
                    m = k;
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = paramString;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                  }
                  else if (localCharSequence.equalsIgnoreCase("usersig"))
                  {
                    m = k;
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = paramString;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                  }
                  else if (localCharSequence.equalsIgnoreCase("cloudenv"))
                  {
                    if (paramString.equalsIgnoreCase("pro"))
                    {
                      paramString = this.mTRTCCloud;
                      WXTRTCCloud.setNetEnv(0);
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (paramString.equalsIgnoreCase("dev"))
                    {
                      paramString = this.mTRTCCloud;
                      WXTRTCCloud.setNetEnv(1);
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (paramString.equalsIgnoreCase("uat"))
                    {
                      paramString = this.mTRTCCloud;
                      WXTRTCCloud.setNetEnv(2);
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else
                    {
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                      if (paramString.equalsIgnoreCase("ccc"))
                      {
                        paramString = this.mTRTCCloud;
                        WXTRTCCloud.setNetEnv(3);
                        m = k;
                        n = j;
                        localObject7 = localObject6;
                        localObject8 = localObject5;
                        localObject9 = localObject4;
                        localObject10 = localObject3;
                        localObject11 = localObject2;
                        localObject12 = localObject1;
                        i2 = i;
                      }
                    }
                  }
                  else if (localCharSequence.equalsIgnoreCase("encsmall"))
                  {
                    localObject7 = new TRTCCloudDef.TRTCVideoEncParam();
                    ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoResolution = 100;
                    ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoFps = 15;
                    ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoBitrate = 100;
                    ((TRTCCloudDef.TRTCVideoEncParam)localObject7).videoResolutionMode = 1;
                    if (Integer.parseInt(paramString) == 1)
                    {
                      this.mTRTCCloud.enableEncSmallVideoStream(true, (TRTCCloudDef.TRTCVideoEncParam)localObject7);
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else
                    {
                      this.mTRTCCloud.enableEncSmallVideoStream(false, (TRTCCloudDef.TRTCVideoEncParam)localObject7);
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                  }
                  else if (localCharSequence.equalsIgnoreCase("enableblackstream"))
                  {
                    m = k;
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                    if (Integer.parseInt(paramString) == 1)
                    {
                      this.mTRTCCloud.enableBlackStream(true);
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                  }
                  else if (localCharSequence.equalsIgnoreCase("appscene"))
                  {
                    if (paramString.equalsIgnoreCase("live"))
                    {
                      this.mAppScene = 1;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (paramString.equalsIgnoreCase("videocall"))
                    {
                      this.mAppScene = 0;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (paramString.equalsIgnoreCase("audiocall"))
                    {
                      this.mAppScene = 2;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (paramString.equalsIgnoreCase("voicechatroom"))
                    {
                      this.mAppScene = 3;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else
                    {
                      this.mAppScene = 0;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                  }
                  else if (localCharSequence.equalsIgnoreCase("recvmode"))
                  {
                    m = Integer.parseInt(paramString);
                    if (m == 1)
                    {
                      this.mAutoRecvAudio = true;
                      this.mAutoRecvVideo = true;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (m == 2)
                    {
                      this.mAutoRecvAudio = true;
                      this.mAutoRecvVideo = false;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (m == 3)
                    {
                      this.mAutoRecvAudio = false;
                      this.mAutoRecvVideo = true;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else if (m == 4)
                    {
                      this.mAutoRecvAudio = false;
                      this.mAutoRecvVideo = false;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                    else
                    {
                      this.mAutoRecvAudio = true;
                      this.mAutoRecvVideo = true;
                      m = k;
                      n = j;
                      localObject7 = localObject6;
                      localObject8 = localObject5;
                      localObject9 = localObject4;
                      localObject10 = localObject3;
                      localObject11 = localObject2;
                      localObject12 = localObject1;
                      i2 = i;
                    }
                  }
                  else if (localCharSequence.equalsIgnoreCase("streamid"))
                  {
                    m = k;
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = paramString;
                    localObject12 = localObject1;
                    i2 = i;
                  }
                  else if (localCharSequence.equalsIgnoreCase("userdefinerecordid"))
                  {
                    m = k;
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = paramString;
                    i2 = i;
                  }
                  else if (localCharSequence.equalsIgnoreCase("strroomid"))
                  {
                    m = k;
                    n = j;
                    localObject7 = paramString;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                  }
                  else if (localCharSequence.equalsIgnoreCase("privatemapkey"))
                  {
                    m = k;
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = paramString;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                  }
                  else
                  {
                    m = k;
                    n = j;
                    localObject7 = localObject6;
                    localObject8 = localObject5;
                    localObject9 = localObject4;
                    localObject10 = localObject3;
                    localObject11 = localObject2;
                    localObject12 = localObject1;
                    i2 = i;
                    if (localCharSequence.equalsIgnoreCase("pureaudiomode"))
                    {
                      i2 = Integer.parseInt(paramString);
                      localObject12 = localObject1;
                      localObject11 = localObject2;
                      localObject10 = localObject3;
                      localObject9 = localObject4;
                      localObject8 = localObject5;
                      localObject7 = localObject6;
                      n = j;
                      m = k;
                    }
                  }
                }
              }
            }
          }
          i1 += 1;
          k = m;
          j = n;
          localObject6 = localObject7;
          localObject5 = localObject8;
          localObject4 = localObject9;
          localObject3 = localObject10;
          localObject2 = localObject11;
          localObject1 = localObject12;
          i = i2;
        }
        catch (Exception paramString) {}
      }
      TXCLog.e("WXLivePusher", "parse trtc params failed.", paramString);
    }
    catch (Exception paramString)
    {
      localObject6 = "";
      localObject5 = localObject6;
      localObject4 = localObject5;
      localObject3 = localObject4;
      localObject2 = localObject3;
      localObject1 = localObject2;
      k = 0;
      j = 0;
      i = 0;
    }
    int n = i;
    paramString = (String)localObject1;
    Object localObject7 = localObject2;
    Object localObject8 = localObject3;
    Object localObject10 = localObject4;
    Object localObject11 = localObject5;
    Object localObject9 = localObject6;
    int m = j;
    int i2 = k;
    label1940:
    if ((i2 != 0) && ((m != 0) || (!TextUtils.isEmpty((CharSequence)localObject9))) && (!TextUtils.isEmpty((CharSequence)localObject11)))
    {
      if (TextUtils.isEmpty((CharSequence)localObject10)) {
        return false;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject9)) && (m == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      localObject1 = this.mTRTCParams;
      ((TRTCCloudDef.TRTCParams)localObject1).sdkAppId = i2;
      if (i != 0) {
        m = -1;
      }
      ((TRTCCloudDef.TRTCParams)localObject1).roomId = m;
      localObject1 = this.mTRTCParams;
      ((TRTCCloudDef.TRTCParams)localObject1).userId = ((String)localObject11);
      ((TRTCCloudDef.TRTCParams)localObject1).userSig = ((String)localObject10);
      ((TRTCCloudDef.TRTCParams)localObject1).privateMapKey = ((String)localObject8);
      j = this.mAppScene;
      if ((j != 1) && (j != 3)) {
        this.mNeedCheckRole = false;
      } else {
        this.mNeedCheckRole = true;
      }
      if ((localObject7 != null) && (((String)localObject7).length() > 0)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((paramString != null) && (paramString.length() > 0)) {
        k = 1;
      } else {
        k = 0;
      }
      if (n != 1)
      {
        m = i3;
        if (n != 2) {}
      }
      else
      {
        m = 1;
      }
      if ((j == 0) && (k == 0) && (i == 0) && (m == 0)) {
        this.mTRTCParams.businessInfo = "";
      } else {
        try
        {
          localObject1 = new JSONObject();
          if ((j != 0) || (k != 0))
          {
            localObject2 = new JSONObject();
            if (j != 0) {
              ((JSONObject)localObject2).put("userdefine_streamid_main", localObject7);
            }
            if (k != 0) {
              ((JSONObject)localObject2).put("userdefine_record_id", paramString);
            }
            if (m != 0) {
              ((JSONObject)localObject2).put("pure_audio_push_mod", n);
            }
            ((JSONObject)localObject1).put("Str_uc_params", localObject2);
          }
          if (i != 0) {
            ((JSONObject)localObject1).put("strGroupId", localObject9);
          }
          this.mTRTCParams.businessInfo = ((JSONObject)localObject1).toString();
        }
        catch (Exception paramString)
        {
          TXCLog.e("WXLivePusher", "build json object failed.", paramString);
        }
      }
      return true;
    }
    return false;
  }
  
  private void updateConfig(boolean paramBoolean, WXLivePushConfig paramWXLivePushConfig)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateConfig force: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", config: ");
    ((StringBuilder)localObject).append(paramWXLivePushConfig.toString());
    ((StringBuilder)localObject).append(", isTRTC: ");
    ((StringBuilder)localObject).append(this.mIsTRTC);
    localObject = ((StringBuilder)localObject).toString();
    int k = 1;
    apiOnlineLog((String)localObject, true);
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject;
        if ((paramWXLivePushConfig.mVideoEncodeWidth != this.mPushConfig.mVideoEncodeWidth) || (paramWXLivePushConfig.mVideoEncodeHeight != this.mPushConfig.mVideoEncodeHeight) || (paramWXLivePushConfig.mMaxVideoBitrate != this.mPushConfig.mMaxVideoBitrate) || (paramWXLivePushConfig.mHomeOrientation != this.mPushConfig.mHomeOrientation))
        {
          localObject = new JSONObject();
          i = paramWXLivePushConfig.mVideoEncodeWidth;
          i = paramWXLivePushConfig.mVideoEncodeHeight;
          int j;
          if ((paramWXLivePushConfig.mHomeOrientation != 0) && (paramWXLivePushConfig.mHomeOrientation != 2))
          {
            if (paramWXLivePushConfig.mVideoEncodeWidth > paramWXLivePushConfig.mVideoEncodeHeight) {
              i = paramWXLivePushConfig.mVideoEncodeHeight;
            } else {
              i = paramWXLivePushConfig.mVideoEncodeWidth;
            }
            int m;
            if (paramWXLivePushConfig.mVideoEncodeWidth > paramWXLivePushConfig.mVideoEncodeHeight)
            {
              m = paramWXLivePushConfig.mVideoEncodeWidth;
              j = i;
              i = m;
            }
            else
            {
              m = paramWXLivePushConfig.mVideoEncodeHeight;
              j = i;
              i = m;
            }
          }
          else
          {
            if (paramWXLivePushConfig.mVideoEncodeWidth > paramWXLivePushConfig.mVideoEncodeHeight) {
              j = paramWXLivePushConfig.mVideoEncodeWidth;
            } else {
              j = paramWXLivePushConfig.mVideoEncodeHeight;
            }
            if (paramWXLivePushConfig.mVideoEncodeWidth > paramWXLivePushConfig.mVideoEncodeHeight) {
              i = paramWXLivePushConfig.mVideoEncodeHeight;
            } else {
              i = paramWXLivePushConfig.mVideoEncodeWidth;
            }
          }
          ((JSONObject)localObject).put("codecType", 1);
          ((JSONObject)localObject).put("streamType", 0);
          ((JSONObject)localObject).put("videoWidth", j);
          ((JSONObject)localObject).put("videoHeight", i);
          ((JSONObject)localObject).put("videoBitrate", paramWXLivePushConfig.mMaxVideoBitrate);
          ((JSONObject)localObject).put("videoFps", 15);
          localJSONObject = new JSONObject();
          localJSONObject.put("api", "setVideoEncodeParamEx");
          localJSONObject.put("params", localObject);
          this.mTRTCCloud.callExperimentalAPI(localJSONObject.toString());
        }
        if ((paramBoolean) || (paramWXLivePushConfig.mLocalVideoMirrorType != this.mPushConfig.mLocalVideoMirrorType))
        {
          i = paramWXLivePushConfig.mLocalVideoMirrorType;
          if (i == 0) {
            break label860;
          }
          if (i == 1) {
            break label870;
          }
          if (i == 2) {
            break label865;
          }
          break label860;
          this.mTRTCCloud.setLocalViewMirror(i);
        }
        if ((paramBoolean) || (paramWXLivePushConfig.mAudioSample != this.mPushConfig.mAudioSample))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("sampleRate", paramWXLivePushConfig.mAudioSample);
          localJSONObject = new JSONObject();
          localJSONObject.put("api", "setAudioSampleRate");
          localJSONObject.put("params", localObject);
          this.mTRTCCloud.callExperimentalAPI(localJSONObject.toString());
        }
        if ((paramBoolean) || (paramWXLivePushConfig.mEnableAgc != this.mPushConfig.mEnableAgc))
        {
          localObject = new JSONObject();
          if (!paramWXLivePushConfig.mEnableAgc) {
            break label875;
          }
          i = 1;
          ((JSONObject)localObject).put("enable", i);
          localJSONObject = new JSONObject();
          localJSONObject.put("api", "enableAudioAGC");
          localJSONObject.put("params", localObject);
          this.mTRTCCloud.callExperimentalAPI(localJSONObject.toString());
        }
        if ((paramBoolean) || (paramWXLivePushConfig.mEnableAns != this.mPushConfig.mEnableAns))
        {
          localObject = new JSONObject();
          if (!paramWXLivePushConfig.mEnableAns) {
            break label880;
          }
          i = 1;
          ((JSONObject)localObject).put("enable", i);
          localJSONObject = new JSONObject();
          localJSONObject.put("api", "enableAudioANS");
          localJSONObject.put("params", localObject);
          this.mTRTCCloud.callExperimentalAPI(localJSONObject.toString());
        }
        if ((paramBoolean) || (paramWXLivePushConfig.mVolumeType != this.mPushConfig.mVolumeType))
        {
          if (paramWXLivePushConfig.mVolumeType == 1)
          {
            i = k;
          }
          else
          {
            if (paramWXLivePushConfig.mVolumeType != 2) {
              break label885;
            }
            i = 2;
          }
          this.mTRTCCloud.setSystemVolumeType(i);
        }
        if ((paramBoolean) || (paramWXLivePushConfig.mTouchFocus != this.mPushConfig.mTouchFocus) || (paramWXLivePushConfig.mEnableZoom != this.mPushConfig.mEnableZoom)) {
          this.mTRTCCloud.setConfig(paramWXLivePushConfig.mTouchFocus, paramWXLivePushConfig.mEnableZoom);
        }
        if ((paramBoolean) || (paramWXLivePushConfig.mEnableAudioPreview != this.mPushConfig.mEnableAudioPreview))
        {
          this.mTRTCCloud.enableAudioEarMonitoring(paramWXLivePushConfig.mEnableAudioPreview);
          return;
        }
      }
      catch (Exception paramWXLivePushConfig)
      {
        TXCLog.e("WXLivePusher", "update config failed.", paramWXLivePushConfig);
      }
      return;
      label860:
      int i = 0;
      continue;
      label865:
      i = 2;
      continue;
      label870:
      i = 1;
      continue;
      label875:
      i = 0;
      continue;
      label880:
      i = 0;
      continue;
      label885:
      i = 0;
    }
  }
  
  public void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("[API] WXLivePusher(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString = paramString.toString();
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(str);
      Monitor.a(1, localStringBuilder.toString(), "", 0, "");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    TXCLog.i("WXLivePusher", localStringBuilder.toString());
  }
  
  public void enableAudioVolumeEvaluation(int paramInt)
  {
    if (!this.mIsTRTC) {
      super.enableAudioVolumeEvaluation(paramInt);
    }
    this.mAudioVolumeEvaluationInterval = paramInt;
  }
  
  public int getMaxZoom()
  {
    if (this.mIsTRTC) {
      return this.mTRTCCloud.getMaxZoom();
    }
    return super.getMaxZoom();
  }
  
  public boolean isPushing()
  {
    if (this.mIsTRTC) {
      return this.mEnterRoom;
    }
    return super.isPushing();
  }
  
  public boolean pauseBGM()
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.pauseBGM();
    } else {
      super.pauseBGM();
    }
    return true;
  }
  
  public void pausePusher()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pausePusher isTRTC: ");
    localStringBuilder.append(this.mIsTRTC);
    apiOnlineLog(localStringBuilder.toString(), true);
    if (this.mIsTRTC)
    {
      if ((this.mStartPreview) && ((this.mPushConfig.mPauseFlag & 0x1) == 1)) {
        this.mTRTCCloud.pausePusher();
      }
      if ((this.mStartAudio) && ((this.mPushConfig.mPauseFlag & 0x2) == 2)) {
        this.mTRTCCloud.muteLocalAudio(true);
      }
    }
    else
    {
      super.pausePusher();
    }
  }
  
  public boolean playBGM(String paramString)
  {
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.playBGM(paramString, new WXLivePusher.3(this));
      return true;
    }
    return super.playBGM(paramString);
  }
  
  public void resetParams()
  {
    this.mAppScene = 0;
    this.mIsTRTC = false;
    this.mStartPreview = false;
    this.mStartAudio = false;
    this.mEnterRoom = false;
    this.mNeedCheckRole = false;
    this.mAutoRecvAudio = true;
    this.mAutoRecvVideo = true;
    clearMainStream();
    clearSubStream();
  }
  
  public boolean resumeBGM()
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.resumeBGM();
    } else {
      super.resumeBGM();
    }
    return true;
  }
  
  public void resumePusher()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumePusher isTRTC: ");
    localStringBuilder.append(this.mIsTRTC);
    apiOnlineLog(localStringBuilder.toString(), true);
    if (this.mIsTRTC)
    {
      if ((this.mStartPreview) && ((this.mPushConfig.mPauseFlag & 0x1) == 1)) {
        this.mTRTCCloud.resumePusher();
      }
      if ((this.mStartAudio) && ((this.mPushConfig.mPauseFlag & 0x2) == 2)) {
        this.mTRTCCloud.muteLocalAudio(false);
      }
    }
    else
    {
      super.resumePusher();
    }
  }
  
  public boolean sendMessageEx(byte[] paramArrayOfByte)
  {
    if (this.mIsTRTC) {
      return this.mTRTCCloud.sendSEIMsg(paramArrayOfByte, 1);
    }
    return super.sendMessageEx(paramArrayOfByte);
  }
  
  public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    if (!this.mIsTRTC) {
      super.setAudioVolumeEvaluationListener(paramITXAudioVolumeEvaluationListener);
    }
    this.mAudioVolumeEvaluationListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNofify(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    super.setBGMNofify(paramOnBGMNotify);
    this.mBGMNotify = new WeakReference(paramOnBGMNotify);
  }
  
  public boolean setBGMVolume(float paramFloat)
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.setBGMVolume(Math.round(paramFloat * 100.0F));
    } else {
      super.setBGMVolume(paramFloat);
    }
    return true;
  }
  
  public boolean setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBeautyFilter(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mTRTCCloud.setBeautyStyle(paramInt1, paramInt2, paramInt3, paramInt4);
    return true;
  }
  
  public void setConfig(WXLivePushConfig paramWXLivePushConfig)
  {
    super.setConfig(paramWXLivePushConfig);
    if (this.mIsTRTC)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setConfig config: ");
      ((StringBuilder)localObject).append(paramWXLivePushConfig);
      if (((StringBuilder)localObject).toString() != null) {
        localObject = paramWXLivePushConfig.toString();
      } else {
        localObject = "";
      }
      apiOnlineLog((String)localObject, true);
      if (this.mEnterRoom) {
        updateConfig(false, paramWXLivePushConfig);
      }
    }
    this.mPushConfig = paramWXLivePushConfig.clone();
  }
  
  public void setFilter(Bitmap paramBitmap)
  {
    super.setFilter(paramBitmap);
    this.mTRTCCloud.setFilter(paramBitmap);
  }
  
  public void setFocusPosition(float paramFloat1, float paramFloat2)
  {
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.setFocusPosition(paramFloat1, paramFloat2);
      return;
    }
    super.setFocusPosition(paramFloat1, paramFloat2);
  }
  
  public boolean setMicVolume(float paramFloat)
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.setMicVolumeOnMixing(Math.round(paramFloat * 100.0F));
    } else {
      super.setMicVolume(paramFloat);
    }
    return true;
  }
  
  public boolean setMirror(boolean paramBoolean)
  {
    super.setMirror(paramBoolean);
    this.mTRTCCloud.setVideoEncoderMirror(paramBoolean);
    return true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMute mute: ");
    localStringBuilder.append(paramBoolean);
    apiOnlineLog(localStringBuilder.toString(), true);
    super.setMute(paramBoolean);
    this.mTRTCCloud.muteLocalAudio(paramBoolean);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    super.setPushListener(paramITXLivePushListener);
    this.mTRTCCloud.setPushListener(paramITXLivePushListener);
    this.mPushListener = new WeakReference(paramITXLivePushListener);
  }
  
  public void setPusherUrl(String paramString)
  {
    this.mIsTRTC = isTRTCPusherUrl(paramString);
  }
  
  public void setReverb(int paramInt)
  {
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.setReverbType(paramInt);
      return;
    }
    super.setReverb(paramInt);
  }
  
  public void setSurface(Surface paramSurface)
  {
    super.setSurface(paramSurface);
    this.mTRTCCloud.setLocalSurface(paramSurface);
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    super.setSurfaceSize(paramInt1, paramInt2);
    this.mTRTCCloud.setLocalSurfaceSize(paramInt1, paramInt2);
  }
  
  public boolean setZoom(int paramInt)
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.setZoom(paramInt);
    } else {
      super.setZoom(paramInt);
    }
    return true;
  }
  
  public void showDebugLog(boolean paramBoolean)
  {
    Object localObject = this.mVideoView;
    if (localObject != null) {
      ((TXCloudVideoView)localObject).showLog(paramBoolean);
    }
    localObject = this.mTRTCCloud;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 0;
    }
    ((WXTRTCCloud)localObject).showDebugView(i);
  }
  
  public void snapshot(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.snapshotVideo(null, 0, new WXLivePusher.2(this, paramITXSnapshotListener));
      return;
    }
    super.snapshot(paramITXSnapshotListener);
  }
  
  public void startAudioRecord()
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.startLocalAudio();
    }
    this.mStartAudio = true;
    checkSwitchAnchor();
  }
  
  public void startCameraPreview(TXCloudVideoView paramTXCloudVideoView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCameraPreview view: ");
    localStringBuilder.append(paramTXCloudVideoView);
    apiOnlineLog(localStringBuilder.toString(), true);
    if (this.mIsTRTC) {
      this.mTRTCCloud.startLocalPreview(this.mPushConfig.mFrontCamera, paramTXCloudVideoView);
    } else {
      super.startCameraPreview(paramTXCloudVideoView);
    }
    this.mVideoView = paramTXCloudVideoView;
    this.mStartPreview = true;
    checkSwitchAnchor();
  }
  
  public int startDumpAudioData(String paramString)
  {
    if (this.mIsTRTC)
    {
      TRTCCloudDef.TRTCAudioRecordingParams localTRTCAudioRecordingParams = new TRTCCloudDef.TRTCAudioRecordingParams();
      localTRTCAudioRecordingParams.filePath = paramString;
      return this.mTRTCCloud.startAudioRecording(localTRTCAudioRecordingParams);
    }
    return internalStartDumpAudioData(paramString);
  }
  
  public int startPusher(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    this.mIsRtmpProxy = isRtmpProxyUrl(paramString);
    boolean bool = isTRTCPusherUrl(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPusher url: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", isTRTC: ");
    localStringBuilder.append(this.mIsTRTC);
    apiOnlineLog(localStringBuilder.toString(), true);
    if (!bool)
    {
      this.mIsTRTC = bool;
      return super.startPusher(paramString);
    }
    if (!parseTRTCParams(paramString))
    {
      TXCLog.e("WXLivePusher", "parse pusherUrl failed!!!");
      return -1;
    }
    if ((!this.mIsTRTC) && (bool == true))
    {
      if (this.mStartPreview)
      {
        super.stopCameraPreview(true);
        this.mTRTCCloud.startLocalPreview(true, this.mVideoView);
      }
      if (this.mStartAudio) {
        this.mTRTCCloud.startLocalAudio();
      }
    }
    if (this.mNeedCheckRole)
    {
      if ((!this.mStartPreview) && (!this.mStartAudio)) {
        this.mTRTCParams.role = 21;
      } else {
        this.mTRTCParams.role = 20;
      }
    }
    else {
      this.mTRTCParams.role = 20;
    }
    this.mIsTRTC = bool;
    updateConfig(true, this.mPushConfig);
    this.mTRTCCloud.setDefaultStreamRecvMode(this.mAutoRecvAudio, this.mAutoRecvVideo);
    this.mTRTCCloud.enableAudioVolumeEvaluation(300);
    this.mTRTCCloud.enterRoom(this.mTRTCParams, this.mAppScene);
    return 0;
  }
  
  public void stopAudioRecord()
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.stopLocalAudio();
    }
    this.mStartAudio = false;
    checkSwitchAudience();
  }
  
  public boolean stopBGM()
  {
    if (this.mIsTRTC) {
      this.mTRTCCloud.stopBGM();
    } else {
      super.stopBGM();
    }
    return true;
  }
  
  public void stopCameraPreview(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopCameraPreview isNeedClearLastImg: ");
    localStringBuilder.append(paramBoolean);
    apiOnlineLog(localStringBuilder.toString(), true);
    if (this.mIsTRTC) {
      this.mTRTCCloud.stopLocalPreview();
    } else {
      super.stopCameraPreview(true);
    }
    this.mStartPreview = false;
    checkSwitchAudience();
  }
  
  public void stopDumpAudioData()
  {
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.stopAudioRecording();
      return;
    }
    internalStopDumpAudioData();
  }
  
  public void stopPusher()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopPusher isTRTC: ");
    localStringBuilder.append(this.mIsTRTC);
    apiOnlineLog(localStringBuilder.toString(), true);
    if (this.mIsTRTC)
    {
      this.mTRTCCloud.exitRoom();
      this.mTRTCCloud.setLocalViewMirror(0);
    }
    else
    {
      internalStopDumpAudioData();
      super.stopPusher();
    }
    resetParams();
  }
  
  public void switchCamera()
  {
    if (this.mIsTRTC)
    {
      WXLivePushConfig localWXLivePushConfig = this.mPushConfig;
      localWXLivePushConfig.mFrontCamera ^= true;
      this.mTRTCCloud.switchCamera();
      return;
    }
    super.switchCamera();
  }
  
  public boolean turnOnFlashLight(boolean paramBoolean)
  {
    if (this.mIsTRTC) {
      return this.mTRTCCloud.enableTorch(paramBoolean);
    }
    return super.turnOnFlashLight(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher
 * JD-Core Version:    0.7.0.1
 */