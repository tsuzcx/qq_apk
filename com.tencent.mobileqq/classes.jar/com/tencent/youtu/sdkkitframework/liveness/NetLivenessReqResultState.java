package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;
import android.util.Base64;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContex;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2.UploadVideoResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV3.UploadVideoResponse;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NetLivenessReqResultState
  extends YtFSMBaseState
{
  private static final String TAG = NetLivenessReqResultState.class.getSimpleName();
  private int actReflectType = 0;
  private String appId;
  private YuvImage bestImage;
  private int finalConfidenceThreshold;
  private boolean needManualTrigger = false;
  private HashMap<String, String> requestOptions = new HashMap();
  private String resultUrl;
  private String secretId;
  private String secretKey;
  private int simiThreshold = 70;
  private String userId;
  
  /* Error */
  private void handleResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 5
    //   3: aload_2
    //   4: ifnull +27 -> 31
    //   7: getstatic 32	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   10: ldc 63
    //   12: invokestatic 69	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   15: invokestatic 75	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   18: new 77	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState$3
    //   21: dup
    //   22: aload_0
    //   23: aload_2
    //   24: invokespecial 80	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState$3:<init>	(Lcom/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState;Ljava/lang/Exception;)V
    //   27: invokevirtual 84	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   30: return
    //   31: new 86	org/json/JSONObject
    //   34: dup
    //   35: aload_1
    //   36: ldc 88
    //   38: invokevirtual 92	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: checkcast 94	java/lang/String
    //   44: invokespecial 97	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: ldc 99
    //   51: invokevirtual 103	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   54: istore 8
    //   56: aload_2
    //   57: ldc 105
    //   59: invokevirtual 103	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   62: ifeq +299 -> 361
    //   65: aload_2
    //   66: ldc 105
    //   68: invokevirtual 109	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   71: istore_3
    //   72: iload 8
    //   74: ifeq +514 -> 588
    //   77: aload_2
    //   78: ldc 99
    //   80: invokevirtual 109	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   83: istore 4
    //   85: iload 4
    //   87: istore 6
    //   89: iload_3
    //   90: istore 5
    //   92: getstatic 32	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   95: new 111	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   102: ldc 114
    //   104: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload_3
    //   108: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc 123
    //   113: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload 4
    //   118: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 69	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   127: iload 4
    //   129: istore 6
    //   131: iload_3
    //   132: istore 5
    //   134: aload_2
    //   135: ldc 128
    //   137: invokevirtual 103	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   140: ifeq +439 -> 579
    //   143: iload 4
    //   145: istore 6
    //   147: iload_3
    //   148: istore 5
    //   150: aload_2
    //   151: ldc 128
    //   153: invokevirtual 109	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   156: istore 7
    //   158: iload 7
    //   160: istore 5
    //   162: iload 5
    //   164: iconst_m1
    //   165: if_icmpeq +408 -> 573
    //   168: iload 5
    //   170: aload_0
    //   171: getfield 40	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:simiThreshold	I
    //   174: if_icmple +203 -> 377
    //   177: ldc 130
    //   179: astore_2
    //   180: iload_3
    //   181: istore 7
    //   183: iload 4
    //   185: istore 6
    //   187: iload 5
    //   189: istore_3
    //   190: new 42	java/util/HashMap
    //   193: dup
    //   194: invokespecial 43	java/util/HashMap:<init>	()V
    //   197: astore 9
    //   199: getstatic 32	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   202: new 111	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   209: ldc 132
    //   211: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 7
    //   216: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc 123
    //   221: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: iload 6
    //   226: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 69	com/tencent/youtu/sdkkitframework/common/YtLogger:d	(Ljava/lang/String;Ljava/lang/Object;)V
    //   235: iload 7
    //   237: ifne +179 -> 416
    //   240: iload 8
    //   242: ifeq +17 -> 259
    //   245: iload 8
    //   247: ifeq +169 -> 416
    //   250: iload 6
    //   252: aload_0
    //   253: getfield 134	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:finalConfidenceThreshold	I
    //   256: if_icmplt +160 -> 416
    //   259: aload 9
    //   261: ldc 136
    //   263: ldc 138
    //   265: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   268: pop
    //   269: aload 9
    //   271: ldc 144
    //   273: ldc 130
    //   275: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: aload 9
    //   281: ldc 146
    //   283: ldc 148
    //   285: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: aload 9
    //   291: ldc 150
    //   293: iconst_0
    //   294: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   300: pop
    //   301: aload 9
    //   303: ldc 158
    //   305: aload_1
    //   306: ldc 88
    //   308: invokevirtual 92	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   311: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   314: pop
    //   315: aload 9
    //   317: ldc 160
    //   319: aload_0
    //   320: getfield 162	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:bestImage	Landroid/graphics/YuvImage;
    //   323: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   326: pop
    //   327: iload_3
    //   328: ifle +24 -> 352
    //   331: aload 9
    //   333: ldc 164
    //   335: aload_2
    //   336: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aload 9
    //   342: ldc 166
    //   344: iload_3
    //   345: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   351: pop
    //   352: invokestatic 75	com/tencent/youtu/sdkkitframework/framework/YtFSM:getInstance	()Lcom/tencent/youtu/sdkkitframework/framework/YtFSM;
    //   355: aload 9
    //   357: invokevirtual 84	com/tencent/youtu/sdkkitframework/framework/YtFSM:sendFSMEvent	(Ljava/util/HashMap;)V
    //   360: return
    //   361: getstatic 32	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   364: ldc 168
    //   366: invokestatic 172	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: iconst_m1
    //   370: istore 4
    //   372: iconst_m1
    //   373: istore_3
    //   374: goto -247 -> 127
    //   377: ldc 174
    //   379: astore_2
    //   380: goto -200 -> 180
    //   383: astore_2
    //   384: iconst_m1
    //   385: istore_3
    //   386: iconst_m1
    //   387: istore 4
    //   389: iconst_0
    //   390: istore 8
    //   392: getstatic 32	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:TAG	Ljava/lang/String;
    //   395: aload_2
    //   396: invokevirtual 177	org/json/JSONException:getLocalizedMessage	()Ljava/lang/String;
    //   399: invokestatic 172	com/tencent/youtu/sdkkitframework/common/YtLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: ldc 174
    //   404: astore_2
    //   405: iload 5
    //   407: istore 6
    //   409: iload 4
    //   411: istore 7
    //   413: goto -223 -> 190
    //   416: iload 8
    //   418: ifeq +85 -> 503
    //   421: iload 6
    //   423: aload_0
    //   424: getfield 134	com/tencent/youtu/sdkkitframework/liveness/NetLivenessReqResultState:finalConfidenceThreshold	I
    //   427: if_icmpge +76 -> 503
    //   430: aload 9
    //   432: ldc 179
    //   434: ldc 180
    //   436: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   439: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   442: pop
    //   443: aload 9
    //   445: ldc 136
    //   447: ldc 138
    //   449: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   452: pop
    //   453: aload 9
    //   455: ldc 144
    //   457: ldc 174
    //   459: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   462: pop
    //   463: aload 9
    //   465: ldc 146
    //   467: ldc 182
    //   469: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   472: pop
    //   473: aload 9
    //   475: ldc 150
    //   477: ldc 183
    //   479: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   485: pop
    //   486: aload 9
    //   488: ldc 158
    //   490: aload_1
    //   491: ldc 88
    //   493: invokevirtual 92	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   496: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: goto -148 -> 352
    //   503: aload 9
    //   505: ldc 179
    //   507: iload 7
    //   509: invokestatic 156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   512: invokevirtual 142	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   515: pop
    //   516: goto -73 -> 443
    //   519: astore_2
    //   520: iconst_m1
    //   521: istore_3
    //   522: iconst_m1
    //   523: istore 4
    //   525: goto -133 -> 392
    //   528: astore_2
    //   529: iconst_m1
    //   530: istore 6
    //   532: iload_3
    //   533: istore 4
    //   535: iload 6
    //   537: istore_3
    //   538: goto -146 -> 392
    //   541: astore_2
    //   542: iconst_m1
    //   543: istore_3
    //   544: iload 5
    //   546: istore 4
    //   548: iload 6
    //   550: istore 5
    //   552: goto -160 -> 392
    //   555: astore_2
    //   556: iload_3
    //   557: istore 6
    //   559: iload 5
    //   561: istore_3
    //   562: iload 4
    //   564: istore 5
    //   566: iload 6
    //   568: istore 4
    //   570: goto -178 -> 392
    //   573: ldc 174
    //   575: astore_2
    //   576: goto -396 -> 180
    //   579: ldc 174
    //   581: astore_2
    //   582: iconst_m1
    //   583: istore 5
    //   585: goto -405 -> 180
    //   588: iconst_m1
    //   589: istore 4
    //   591: goto -506 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	NetLivenessReqResultState
    //   0	594	1	paramHashMap	HashMap<String, String>
    //   0	594	2	paramException	Exception
    //   71	491	3	i	int
    //   83	507	4	j	int
    //   1	583	5	k	int
    //   87	480	6	m	int
    //   156	352	7	n	int
    //   54	363	8	bool	boolean
    //   197	307	9	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   31	56	383	org/json/JSONException
    //   56	72	519	org/json/JSONException
    //   361	369	519	org/json/JSONException
    //   77	85	528	org/json/JSONException
    //   92	127	541	org/json/JSONException
    //   134	143	541	org/json/JSONException
    //   150	158	541	org/json/JSONException
    //   168	177	555	org/json/JSONException
  }
  
  private void onActReflectRequest()
  {
    try
    {
      Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_frame"));
      this.stateData.put("best_frame", this.bestImage);
      Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
      UploadVideoRequesterV3.UploadVideoResponse localUploadVideoResponse = (UploadVideoRequesterV3.UploadVideoResponse)((YtFSMBaseState)localObject1).getStateDataBy("reflect_response_object");
      localObject1 = (ActionReflectReq)((YtFSMBaseState)localObject1).getStateDataBy("reflect_request_object");
      localObject2 = Base64.encode((byte[])((YtFSMBaseState)localObject2).getStateDataBy("frames"), 2);
      WeJson localWeJson = new WeJson();
      NetLivenessReqResultState.Version localVersion = new NetLivenessReqResultState.Version(this);
      localVersion.sdk_version = YtSDKKitFramework.getInstance().version();
      localVersion.ftrack_sdk_version = YTFaceTrack.Version;
      localVersion.faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
      localVersion.freflect_sdk_version = "3.4.7";
      ((ActionReflectReq)localObject1).action_video = new String((byte[])localObject2);
      ((ActionReflectReq)localObject1).client_version = String.format("sdk_version:%s;ftrack_sdk_version:%s;freflect_sdk_version:%s;faction_sdk_version:%s", new Object[] { localVersion.sdk_version, localVersion.ftrack_sdk_version, localVersion.freflect_sdk_version, localVersion.faction_sdk_version });
      YtLogger.d(TAG, "action_video:size:" + ((ActionReflectReq)localObject1).action_video.length());
      YtLogger.d(TAG, "client_version:" + ((ActionReflectReq)localObject1).client_version);
      localObject1 = localWeJson.toJson(localObject1);
      YtFSM.getInstance().sendNetworkRequset(this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.6(this, localUploadVideoResponse));
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "actrefl request failed" + localException.getLocalizedMessage());
      YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.7(this, localException));
    }
  }
  
  private void onActReflectRequest2()
  {
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject1).getStateDataBy("best_frame"));
    this.stateData.put("best_frame", this.bestImage);
    ArrayList localArrayList = (ArrayList)((YtFSMBaseState)localObject1).getStateDataBy("frame_list");
    YtLogger.d(TAG, "action request 2 frame size:" + localArrayList.size());
    Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
    Object localObject4 = (UploadVideoRequesterV3.UploadVideoResponse)((YtFSMBaseState)localObject3).getStateDataBy("reflect_response_object");
    localObject4 = (ActionReflectReq)((YtFSMBaseState)localObject3).getStateDataBy("reflect_request_object");
    localObject3 = new NetLivenessReqResultState.ActionReflectReq2(this);
    localObject1 = Base64.encode((byte[])((YtFSMBaseState)localObject1).getStateDataBy("frames"), 2);
    Object localObject5 = new NetLivenessReqResultState.Version(this);
    ((NetLivenessReqResultState.Version)localObject5).sdk_version = YtSDKKitFramework.getInstance().version();
    ((NetLivenessReqResultState.Version)localObject5).ftrack_sdk_version = YTFaceTrack.Version;
    ((NetLivenessReqResultState.Version)localObject5).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    ((NetLivenessReqResultState.Version)localObject5).freflect_sdk_version = "3.4.7";
    ((ActionReflectReq)localObject4).action_video = new String((byte[])localObject1);
    new WeJson();
    ((ActionReflectReq)localObject4).client_version = String.format("sdk_version:%s;ftrack_sdk_version:%s;freflect_sdk_version:%s;faction_sdk_version:%s", new Object[] { ((NetLivenessReqResultState.Version)localObject5).sdk_version, ((NetLivenessReqResultState.Version)localObject5).ftrack_sdk_version, ((NetLivenessReqResultState.Version)localObject5).freflect_sdk_version, ((NetLivenessReqResultState.Version)localObject5).faction_sdk_version });
    ((ActionReflectReq)localObject4).session_id = "12345";
    ((NetLivenessReqResultState.ActionReflectReq2)localObject3).live_req = ((ActionReflectReq)localObject4);
    ((NetLivenessReqResultState.ActionReflectReq2)localObject3).session_id = UUID.randomUUID().toString();
    try
    {
      localObject4 = new FileInputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/test.mp4"));
      YtLogger.d(TAG, "encode video size:" + ((FileInputStream)localObject4).available());
      if (((FileInputStream)localObject4).available() != 0) {
        localObject1 = new byte[((FileInputStream)localObject4).available()];
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          ((FileInputStream)localObject4).read((byte[])localObject1);
          ((FileInputStream)localObject4).close();
          int i;
          if (localObject1 == null)
          {
            ((NetLivenessReqResultState.ActionReflectReq2)localObject3).video = "";
            YtLogger.d(TAG, "encode video size:" + ((NetLivenessReqResultState.ActionReflectReq2)localObject3).video.length());
            ((NetLivenessReqResultState.ActionReflectReq2)localObject3).images = new ArrayList();
            ((NetLivenessReqResultState.ActionReflectReq2)localObject3).five_points = new ArrayList();
            i = 0;
            if (i < localArrayList.size())
            {
              j = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getWidth();
              k = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getHeight();
              YtLogger.d(TAG, "Eye score " + ((ActionLivenessState.BestFrame)localArrayList.get(i)).eyeScore);
              if (YtFSM.getInstance().getContext().currentRotateState < 5) {
                continue;
              }
              n = j;
              m = k;
              localObject1 = YTFaceTrack.getInstance().RotateYUV(((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getYuvData(), j, k, YtFSM.getInstance().getContext().currentRotateState);
              YtLogger.d(TAG, "Rotated size:" + localObject1.length);
              localObject1 = new YuvImage((byte[])localObject1, 17, m, n, null);
              localObject4 = new ByteArrayOutputStream();
              ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject4);
              localObject5 = ((ByteArrayOutputStream)localObject4).toByteArray();
              localObject1 = Base64.encode((byte[])localObject5, 2);
            }
          }
          else
          {
            try
            {
              localObject4 = BitmapFactory.decodeByteArray((byte[])localObject5, 0, ((ByteArrayOutputStream)localObject4).size());
              localObject5 = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/bestbmp" + i + ".jpg"));
              ((Bitmap)localObject4).compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject5);
              ((OutputStream)localObject5).flush();
              ((OutputStream)localObject5).close();
              ((NetLivenessReqResultState.ActionReflectReq2)localObject3).images.add(new String((byte[])localObject1));
              localObject1 = new NetLivenessReqResultState.FivePoints(this);
              ((NetLivenessReqResultState.FivePoints)localObject1).points = new ArrayList();
              YtLogger.d(TAG, "f5p size:" + ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2);
              j = 0;
              if (j < ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2)
              {
                localObject4 = new NetLivenessReqResultState.Pointf(this);
                ((NetLivenessReqResultState.Pointf)localObject4).x = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p[(j * 2)];
                ((NetLivenessReqResultState.Pointf)localObject4).y = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p[(j * 2 + 1)];
                ((NetLivenessReqResultState.FivePoints)localObject1).points.add(localObject4);
                YtLogger.d(TAG, "f5p[" + j + "] " + ((NetLivenessReqResultState.Pointf)localObject4).x + "," + ((NetLivenessReqResultState.Pointf)localObject4).y);
                j += 1;
                continue;
                ((NetLivenessReqResultState.ActionReflectReq2)localObject3).video = new String(Base64.encode((byte[])localObject1, 2));
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              continue;
              ((NetLivenessReqResultState.ActionReflectReq2)localObject3).five_points.add(localObject1);
              i += 1;
            }
            continue;
          }
          YtLogger.d(TAG, "f5p count" + ((NetLivenessReqResultState.ActionReflectReq2)localObject3).five_points.size());
          localObject1 = new WeJson().toJson(localObject3);
          YtLogger.d(TAG, "upload string size:" + ((String)localObject1).length());
          YtFSM.getInstance().sendNetworkRequset(this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.8(this));
          return;
          localIOException1 = localIOException1;
          localObject2 = null;
          continue;
        }
        catch (IOException localIOException2)
        {
          int j;
          int k;
          continue;
          int n = k;
          int m = j;
          continue;
        }
        Object localObject2 = null;
      }
    }
  }
  
  private void onActionRequest()
  {
    Object localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    if (localObject1 == null) {
      return;
    }
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject1).getStateDataBy("best_frame"));
    Object localObject3 = new ByteArrayOutputStream();
    this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject3);
    byte[] arrayOfByte1 = Base64.encode((byte[])((YtFSMBaseState)localObject1).getStateDataBy("frames"), 2);
    Object localObject4 = (String[])((YtFSMBaseState)localObject1).getStateDataBy("action_seq");
    Object localObject2 = "";
    int i = 0;
    if (i < localObject4.length) {
      switch (Integer.parseInt(localObject4[i]))
      {
      default: 
        localObject1 = localObject2;
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          localObject2 = localObject1;
          if (i != localObject4.length - 1) {
            localObject2 = (String)localObject1 + ",";
          }
          i += 1;
          break;
          localObject1 = (String)localObject2 + "blink";
          continue;
          localObject1 = (String)localObject2 + "mouth";
        }
      }
    }
    for (localObject1 = (String)localObject2 + "node";; localObject1 = localObject2)
    {
      localObject1 = (String)localObject1 + "shake";
      break;
      localObject1 = "";
      localObject4 = this.requestOptions.entrySet().iterator();
      i = 0;
      Map.Entry localEntry;
      if (((Iterator)localObject4).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (((String)localEntry.getKey()).equals("best_image"))
        {
          if (!((String)localEntry.getValue()).equals("true")) {
            break label779;
          }
          byte[] arrayOfByte2 = Base64.encode(((ByteArrayOutputStream)localObject3).toByteArray(), 2);
          localObject1 = String.format("%s, \"%s\":\"%s\"", new Object[] { localObject1, localEntry.getKey(), new String(arrayOfByte2) });
        }
      }
      label779:
      for (;;)
      {
        break;
        if (((String)localEntry.getKey()).equals("session_id"))
        {
          localObject1 = String.format("%s, \"%s\":\"%s\"", new Object[] { localObject1, localEntry.getKey(), localEntry.getValue() });
          i = 1;
        }
        else
        {
          localObject1 = String.format("%s, \"%s\":%s", new Object[] { localObject1, localEntry.getKey(), localEntry.getValue() });
          continue;
          localObject3 = localObject1;
          if (i == 0) {
            localObject3 = String.format("%s, \"%s\":\"%s\"", new Object[] { localObject1, "session_id", UUID.randomUUID().toString() });
          }
          localObject4 = YtFSM.getInstance().getContext().imageToCompare;
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject1 = new ByteArrayOutputStream();
            ((Bitmap)localObject4).compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject1);
            localObject1 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
            YtLogger.d(TAG, "options cmp size:" + localObject1.length);
            localObject1 = String.format("%s, \"compare_image_type\":%d", new Object[] { String.format("%s, \"compare_image\":\"%s\"", new Object[] { localObject3, new String((byte[])localObject1) }), Integer.valueOf(YtFSM.getInstance().getContext().imageToComapreType) });
          }
          YtLogger.d(TAG, "options:" + (String)localObject1);
          localObject1 = String.format("{\"app_id\":\"%s\"%s,\"action_str\":\"%s\",\"action_video\":\"%s\"}", new Object[] { this.appId, localObject1, localObject2, new String(arrayOfByte1) });
          YtFSM.getInstance().sendNetworkRequset(this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.4(this));
          return;
        }
      }
    }
  }
  
  private void onCheckResponseManual()
  {
    if (this.needManualTrigger)
    {
      YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_manual_trigger", null);
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    }
  }
  
  private void onReflectRequest()
  {
    this.bestImage = ((YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).getStateDataBy("last_frame"));
    this.stateData.put("best_frame", this.bestImage);
    Object localObject = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
    UploadVideoRequesterV2.UploadVideoResponse localUploadVideoResponse = (UploadVideoRequesterV2.UploadVideoResponse)((YtFSMBaseState)localObject).getStateDataBy("reflect_response_object");
    localObject = (ReflectLiveReq)((YtFSMBaseState)localObject).getStateDataBy("reflect_request_object");
    localObject = new WeJson().toJson(localObject);
    YtFSM.getInstance().sendNetworkRequset(this.resultUrl, (String)localObject, null, new NetLivenessReqResultState.5(this, localUploadVideoResponse));
  }
  
  private void onSilentRequest()
  {
    this.bestImage = ((YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).getStateDataBy("last_frame"));
    int i = this.bestImage.getWidth();
    int j = this.bestImage.getHeight();
    Object localObject = new ByteArrayOutputStream();
    this.bestImage.compressToJpeg(new Rect(0, 0, i, j), 95, (OutputStream)localObject);
    localObject = Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 2);
    localObject = String.format("{\"app_id\":\"%s\",\"image\":\"%s\"}", new Object[] { this.appId, new String((byte[])localObject) });
    YtFSM.getInstance().sendNetworkRequset(this.resultUrl, (String)localObject, null, new NetLivenessReqResultState.2(this));
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.1(this));
    switch (NetLivenessReqResultState.9.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    default: 
      return;
    case 1: 
      onSilentRequest();
      return;
    case 2: 
      onActionRequest();
      return;
    case 3: 
      onReflectRequest();
      return;
    }
    if (this.actReflectType == 0)
    {
      onActReflectRequest();
      return;
    }
    onActReflectRequest2();
  }
  
  public void enterFirst() {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    for (;;)
    {
      try
      {
        this.appId = paramJSONObject.getString("app_id");
        this.resultUrl = paramJSONObject.getString("result_api_url");
        if (paramJSONObject.has("secret_key")) {
          this.secretKey = paramJSONObject.getString("secret_key");
        }
        if (paramJSONObject.has("secret_id")) {
          this.secretId = paramJSONObject.getString("secret_id");
        }
        if (paramJSONObject.has("user_id")) {
          this.userId = paramJSONObject.getString("user_id");
        }
        if (paramJSONObject.has("similarity_threshold")) {
          this.simiThreshold = paramJSONObject.getInt("similarity_threshold");
        }
        if (paramJSONObject.has("final_liveness_confidence_threshold"))
        {
          this.finalConfidenceThreshold = paramJSONObject.getInt("final_liveness_confidence_threshold");
          if (paramJSONObject.has("manual_trigger")) {
            this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
          }
          if (paramJSONObject.has("request_options"))
          {
            paramString = paramJSONObject.getJSONObject("request_options");
            paramJSONObject = paramString.keys();
            if (paramJSONObject.hasNext())
            {
              String str1 = (String)paramJSONObject.next();
              String str2 = paramString.getString(str1);
              YtLogger.d(TAG, "test:" + str1 + " : " + str2);
              this.requestOptions.put(str1, str2);
              continue;
            }
          }
          return;
        }
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
      }
      this.finalConfidenceThreshold = 85;
    }
  }
  
  public void unload()
  {
    super.unload();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState
 * JD-Core Version:    0.7.0.1
 */