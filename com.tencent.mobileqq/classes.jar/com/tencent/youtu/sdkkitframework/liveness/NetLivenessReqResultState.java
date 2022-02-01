package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Environment;
import android.util.Base64;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ActionReflectReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.YTImageInfo;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.LiveStyleAndroidData;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NetLivenessReqResultState
  extends YtFSMBaseState
{
  private static final String TAG = NetLivenessReqResultState.class.getSimpleName();
  private int actRefUXMode = 0;
  private int actReflectType = 0;
  private String appId;
  private int backendProtoType = 0;
  private YuvImage bestImage;
  private int changePointNum = 2;
  private String controlConfig = "";
  private String extraConfig = "";
  private int finalConfidenceThreshold;
  private boolean needManualTrigger = false;
  boolean needVideoData = true;
  private HashMap<String, String> requestOptions = new HashMap();
  private String resultUrl;
  private String secretId;
  private String secretKey;
  private int simiThreshold = 70;
  private String userId;
  
  private void handleResponseEvent(HashMap<String, String> paramHashMap, Exception paramException)
  {
    k = -1;
    if (paramException != null)
    {
      YtLogger.i(TAG, "failed: error");
      YtSDKStats.getInstance().reportError(2097153, paramException.getMessage());
      localObject = paramException.getMessage();
      paramException = (Exception)localObject;
      if (paramHashMap != null)
      {
        paramException = (Exception)localObject;
        if (paramHashMap.containsKey("response")) {
          paramException = (String)paramHashMap.get("response");
        }
      }
      YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.3(this, paramException));
      return;
    }
    localObject = "rst_failed";
    try
    {
      paramException = new JSONObject((String)paramHashMap.get("response"));
      bool = paramException.has("score");
    }
    catch (JSONException paramException)
    {
      for (;;)
      {
        try
        {
          label139:
          j = paramException.getInt("score");
          m = j;
          k = i;
        }
        catch (JSONException paramException)
        {
          boolean bool;
          int n;
          m = -1;
          j = i;
          i = m;
          continue;
        }
        try
        {
          YtLogger.i(TAG, "errorcode: " + i + " score " + j);
          m = j;
          k = i;
          if (!paramException.has("similarity_float")) {
            break label724;
          }
          m = j;
          k = i;
          n = paramException.getInt("similarity_float");
          k = n;
          if (k == -1) {
            break label718;
          }
        }
        catch (JSONException paramException)
        {
          i = -1;
          j = k;
          k = m;
          continue;
          paramException = "rst_failed";
          continue;
          paramException = "rst_failed";
          k = -1;
          continue;
        }
        try
        {
          if (k > this.simiThreshold)
          {
            paramException = "rst_succeed";
            n = i;
            m = j;
            i = k;
            localObject = new HashMap();
            YtLogger.i(TAG, "errorcode: " + n + " score " + m);
            if ((n != 0) || ((bool) && (m < this.finalConfidenceThreshold))) {
              continue;
            }
            ((HashMap)localObject).put("ui_action", "process_finished");
            ((HashMap)localObject).put("ui_tips", "rst_succeed");
            ((HashMap)localObject).put("process_action", "succeed");
            ((HashMap)localObject).put("error_code", Integer.valueOf(0));
            ((HashMap)localObject).put("message", CommonUtils.makeMessageJson(0, "rst_succeed", (String)paramHashMap.get("response")));
            ((HashMap)localObject).put("extra_message", this.bestImage);
            if (i > 0)
            {
              ((HashMap)localObject).put("cmp_message", paramException);
              ((HashMap)localObject).put("cmp_score", Integer.valueOf(i));
            }
            YtSDKStats.getInstance().reportInfo("errorCode " + n);
            YtFSM.getInstance().sendFSMEvent((HashMap)localObject);
            return;
            if (paramException.has("error_code"))
            {
              i = paramException.getInt("error_code");
              continue;
            }
            if (!paramException.has("errorcode")) {
              break label739;
            }
            i = paramException.getInt("errorcode");
            continue;
            YtLogger.e(TAG, "response not right");
            j = -1;
            i = -1;
            continue;
          }
          paramException = "rst_failed";
          continue;
          paramException = paramException;
          i = -1;
          j = -1;
          bool = false;
        }
        catch (JSONException paramException)
        {
          m = i;
          i = k;
          k = j;
          j = m;
          continue;
        }
        YtLogger.e(TAG, paramException.getLocalizedMessage());
        paramException = (Exception)localObject;
        m = k;
        n = j;
        continue;
        if ((bool) && (m < this.finalConfidenceThreshold)) {
          ((HashMap)localObject).put("error_reason_code", Integer.valueOf(4194305));
        }
        for (;;)
        {
          ((HashMap)localObject).put("ui_action", "process_finished");
          ((HashMap)localObject).put("ui_tips", "rst_failed");
          ((HashMap)localObject).put("process_action", "failed");
          ((HashMap)localObject).put("error_code", Integer.valueOf(4194304));
          ((HashMap)localObject).put("message", CommonUtils.makeMessageJson(n, "rst_failed", (String)paramHashMap.get("response")));
          break;
          ((HashMap)localObject).put("error_reason_code", Integer.valueOf(n));
        }
      }
    }
    try
    {
      if ((!paramException.has("errorcode")) && (!paramException.has("error_code"))) {
        break label496;
      }
      if (this.backendProtoType != 0) {
        break label458;
      }
      i = paramException.getInt("errorcode");
    }
    catch (JSONException paramException)
    {
      i = -1;
      j = -1;
      break label527;
      j = -1;
      break label152;
      i = -1;
      break label139;
    }
    if (!bool) {}
  }
  
  private String makeActionStr(String[] paramArrayOfString)
  {
    Object localObject1 = "";
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      switch (Integer.parseInt(paramArrayOfString[i]))
      {
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (i != paramArrayOfString.length - 1) {
          localObject2 = (String)localObject1 + ",";
        }
        i += 1;
        localObject1 = localObject2;
        break;
        localObject1 = (String)localObject1 + "blink";
        continue;
        localObject1 = (String)localObject1 + "mouth";
        continue;
        localObject1 = (String)localObject1 + "node";
        continue;
        localObject1 = (String)localObject1 + "shake";
        continue;
        localObject1 = (String)localObject1 + "silence";
      }
    }
    return localObject1;
  }
  
  private void onActReflectRequest()
  {
    try
    {
      Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
      Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
      this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_frame"));
      this.stateData.put("best_frame", this.bestImage);
      Object localObject1 = (ActionReflectReq)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE)).getStateDataBy("reflect_request_object");
      byte[] arrayOfByte = Base64.encode((byte[])((YtFSMBaseState)localObject2).getStateDataBy("frames"), 2);
      String str = (String)((YtFSMBaseState)localObject3).getStateDataBy("control_config");
      if (str != null) {
        this.controlConfig = str;
      }
      str = (String)((YtFSMBaseState)localObject3).getStateDataBy("extra_config");
      if (str != null)
      {
        this.extraConfig = str;
        YtLogger.d(TAG, "extraconfig:" + this.extraConfig);
      }
      localObject3 = (String)((YtFSMBaseState)localObject3).getStateDataBy("cp_num");
      if (localObject3 != null)
      {
        this.changePointNum = Integer.parseInt((String)localObject3);
        YtLogger.d(TAG, "cpnum:" + this.changePointNum);
      }
      parseControlConfig();
      localObject2 = makeActionStr((String[])((YtFSMBaseState)localObject2).getStateDataBy("action_seq"));
      localObject3 = new YtLivenessNetProtoHelper.ActionReflectLiveReqData();
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).baseInfo.sessionId = UUID.randomUUID().toString();
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).baseInfo.appId = this.appId;
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).baseInfo.businessId = "";
      ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).colorData = ((ActionReflectReq)localObject1).color_data;
      if ((this.needVideoData) || (this.actRefUXMode != 1)) {}
      for (((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).actionVideo = new String(arrayOfByte);; ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).actionVideo = "")
      {
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).actionStr = ((String)localObject2);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).eyeImage = new YtLivenessNetProtoHelper.ImageInfo(((ActionReflectReq)localObject1).eye_image.image, ((ActionReflectReq)localObject1).eye_image.five_points, ((ActionReflectReq)localObject1).eye_image.checksum);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).mouthImage = new YtLivenessNetProtoHelper.ImageInfo(((ActionReflectReq)localObject1).mouth_image.image, ((ActionReflectReq)localObject1).mouth_image.five_points, ((ActionReflectReq)localObject1).mouth_image.checksum);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).liveImage = new YtLivenessNetProtoHelper.ImageInfo(((ActionReflectReq)localObject1).live_image.image, ((ActionReflectReq)localObject1).live_image.five_points, ((ActionReflectReq)localObject1).live_image.checksum);
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).reflectData = ((ActionReflectReq)localObject1).reflect_data;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).baseInfo.lux = ((ActionReflectReq)localObject1).select_data.android_data.lux;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).reflectConfig = this.extraConfig;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).controlConfig = this.controlConfig;
        ((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3).colorNum = this.changePointNum;
        localObject1 = YtLivenessNetProtoHelper.makeActionReflectLiveReq((YtLivenessNetProtoHelper.ActionReflectLiveReqData)localObject3);
        YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.8(this));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "actrefl request failed" + localException.getLocalizedMessage());
      YtSDKStats.getInstance().reportInfo("actrefl request failed: " + localException.getLocalizedMessage());
      YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.9(this, localException));
    }
  }
  
  private void onActReflectRequest2()
  {
    Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("best_frame"));
    this.stateData.put("best_frame", this.bestImage);
    ArrayList localArrayList = (ArrayList)((YtFSMBaseState)localObject3).getStateDataBy("frame_list");
    YtLogger.d(TAG, "action request 2 frame size:" + localArrayList.size());
    Object localObject1 = (ActionReflectReq)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE)).getStateDataBy("reflect_request_object");
    NetLivenessReqResultState.ActionReflectReq2 localActionReflectReq2 = new NetLivenessReqResultState.ActionReflectReq2(this);
    localObject3 = Base64.encode((byte[])((YtFSMBaseState)localObject3).getStateDataBy("frames"), 2);
    Object localObject4 = new NetLivenessReqResultState.Version(this);
    ((NetLivenessReqResultState.Version)localObject4).sdk_version = YtSDKKitFramework.getInstance().version();
    ((NetLivenessReqResultState.Version)localObject4).ftrack_sdk_version = YTFaceTrack.Version;
    ((NetLivenessReqResultState.Version)localObject4).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    ((NetLivenessReqResultState.Version)localObject4).freflect_sdk_version = "3.6.2";
    ((ActionReflectReq)localObject1).action_video = new String((byte[])localObject3);
    new WeJson();
    ((ActionReflectReq)localObject1).client_version = String.format("sdk_version:%s;ftrack_sdk_version:%s;freflect_sdk_version:%s;faction_sdk_version:%s", new Object[] { ((NetLivenessReqResultState.Version)localObject4).sdk_version, ((NetLivenessReqResultState.Version)localObject4).ftrack_sdk_version, ((NetLivenessReqResultState.Version)localObject4).freflect_sdk_version, ((NetLivenessReqResultState.Version)localObject4).faction_sdk_version });
    ((ActionReflectReq)localObject1).session_id = "12345";
    localActionReflectReq2.live_req = ((ActionReflectReq)localObject1);
    localActionReflectReq2.session_id = UUID.randomUUID().toString();
    try
    {
      localObject3 = new FileInputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/test.mp4"));
      YtLogger.d(TAG, "encode video size:" + ((FileInputStream)localObject3).available());
      if (((FileInputStream)localObject3).available() != 0) {
        localObject1 = new byte[((FileInputStream)localObject3).available()];
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          ((FileInputStream)localObject3).read((byte[])localObject1);
          ((FileInputStream)localObject3).close();
          int i;
          if (localObject1 == null)
          {
            localActionReflectReq2.video = "";
            YtLogger.d(TAG, "encode video size:" + localActionReflectReq2.video.length());
            localActionReflectReq2.images = new ArrayList();
            localActionReflectReq2.five_points = new ArrayList();
            i = 0;
            if (i < localArrayList.size())
            {
              j = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getWidth();
              k = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getHeight();
              YtLogger.d(TAG, "Eye score " + ((ActionLivenessState.BestFrame)localArrayList.get(i)).eyeScore);
              if (YtFSM.getInstance().getContext().currentRotateState < 5) {
                continue;
              }
              localObject1 = ((ActionLivenessState.BestFrame)localArrayList.get(i)).frame.getYuvData();
              YtLogger.d(TAG, "Rotated size:" + localObject1.length);
              localObject1 = new YuvImage((byte[])localObject1, 17, k, j, null);
              localObject3 = new ByteArrayOutputStream();
              ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, ((YuvImage)localObject1).getWidth(), ((YuvImage)localObject1).getHeight()), 95, (OutputStream)localObject3);
              localObject4 = ((ByteArrayOutputStream)localObject3).toByteArray();
              localObject1 = Base64.encode((byte[])localObject4, 2);
            }
          }
          else
          {
            try
            {
              localObject3 = BitmapFactory.decodeByteArray((byte[])localObject4, 0, ((ByteArrayOutputStream)localObject3).size());
              localObject4 = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getPath() + "/bestbmp" + i + ".jpg"));
              ((Bitmap)localObject3).compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject4);
              ((OutputStream)localObject4).flush();
              ((OutputStream)localObject4).close();
              localActionReflectReq2.images.add(new String((byte[])localObject1));
              localObject1 = new NetLivenessReqResultState.FivePoints(this);
              ((NetLivenessReqResultState.FivePoints)localObject1).points = new ArrayList();
              YtLogger.d(TAG, "f5p size:" + ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2);
              j = 0;
              if (j < ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p.length / 2)
              {
                localObject3 = new NetLivenessReqResultState.Pointf(this);
                ((NetLivenessReqResultState.Pointf)localObject3).x = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p[(j * 2)];
                ((NetLivenessReqResultState.Pointf)localObject3).y = ((ActionLivenessState.BestFrame)localArrayList.get(i)).f5p[(j * 2 + 1)];
                ((NetLivenessReqResultState.FivePoints)localObject1).points.add(localObject3);
                YtLogger.d(TAG, "f5p[" + j + "] " + ((NetLivenessReqResultState.Pointf)localObject3).x + "," + ((NetLivenessReqResultState.Pointf)localObject3).y);
                j += 1;
                continue;
                localActionReflectReq2.video = new String(Base64.encode((byte[])localObject1, 2));
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              continue;
              localActionReflectReq2.five_points.add(localObject1);
              i += 1;
            }
            continue;
          }
          YtLogger.d(TAG, "f5p count" + localActionReflectReq2.five_points.size());
          localObject1 = new WeJson().toJson(localActionReflectReq2);
          YtLogger.d(TAG, "upload string size:" + ((String)localObject1).length());
          YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.10(this));
          return;
          localIOException1 = localIOException1;
          localObject2 = null;
          continue;
        }
        catch (IOException localIOException2)
        {
          continue;
          int m = k;
          int k = j;
          int j = m;
          continue;
        }
        Object localObject2 = null;
      }
    }
  }
  
  private void onActionRequest()
  {
    Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
    if (localObject2 == null)
    {
      YtSDKStats.getInstance().reportInfo("action request action state is null");
      YtLogger.e(TAG, "action request action state is null");
      return;
    }
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_frame"));
    Object localObject1 = new ByteArrayOutputStream();
    this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
    byte[] arrayOfByte = Base64.encode((byte[])((YtFSMBaseState)localObject2).getStateDataBy("frames"), 2);
    localObject2 = makeActionStr((String[])((YtFSMBaseState)localObject2).getStateDataBy("action_seq"));
    parseControlConfig();
    YtLivenessNetProtoHelper.ActionLiveReqData localActionLiveReqData = new YtLivenessNetProtoHelper.ActionLiveReqData();
    localActionLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    localActionLiveReqData.baseInfo.appId = this.appId;
    localActionLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
    localActionLiveReqData.bestImage = new String(Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2));
    localActionLiveReqData.actionStr = ((String)localObject2);
    if (this.needVideoData) {}
    for (localActionLiveReqData.actionVideo = new String(arrayOfByte);; localActionLiveReqData.actionVideo = "")
    {
      localActionLiveReqData.needEyeDetect = true;
      localActionLiveReqData.needMouthDetect = true;
      localActionLiveReqData.reflectConfig = this.extraConfig;
      localActionLiveReqData.controlConfig = this.controlConfig;
      localActionLiveReqData.colorNum = this.changePointNum;
      localObject1 = YtLivenessNetProtoHelper.makeActionLiveReq(localActionLiveReqData);
      YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.6(this));
      return;
    }
  }
  
  private void onCheckResponseManual()
  {
    if (this.needManualTrigger) {}
    try
    {
      YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).handleStateAction("reset_manual_trigger", null);
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
      return;
    }
    catch (Exception localException)
    {
      String str = "on Check response manual failed " + localException.getLocalizedMessage();
      YtLogger.e(TAG, str);
      YtSDKStats.getInstance().reportInfo(str);
    }
  }
  
  private void onLipReadRequest()
  {
    int j = 0;
    for (;;)
    {
      try
      {
        Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
        Object localObject3 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE));
        if (localObject3 == null)
        {
          YtSDKStats.getInstance().reportInfo("lipread request action state is null");
          YtLogger.e(TAG, "lipread request action state is null");
          return;
        }
        this.bestImage = ((YuvImage)((YtFSMBaseState)localObject3).getStateDataBy("last_frame"));
        Object localObject1 = new ByteArrayOutputStream();
        this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
        Object localObject4 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
        Arrays.toString((String[])((YtFSMBaseState)localObject3).getStateDataBy("action_seq"));
        YtLivenessNetProtoHelper.LipReadReqData localLipReadReqData = new YtLivenessNetProtoHelper.LipReadReqData();
        localLipReadReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
        localLipReadReqData.baseInfo.appId = this.appId;
        localLipReadReqData.baseInfo.sessionId = UUID.randomUUID().toString();
        YtLivenessNetProtoHelper.NetBaseInfoData localNetBaseInfoData = localLipReadReqData.baseInfo;
        if (this.requestOptions.containsKey("business_id"))
        {
          localObject1 = (String)this.requestOptions.get("business_id");
          localNetBaseInfoData.businessId = ((String)localObject1);
          localNetBaseInfoData = localLipReadReqData.baseInfo;
          if (!this.requestOptions.containsKey("person_id")) {
            break label821;
          }
          localObject1 = (String)this.requestOptions.get("person_id");
          localNetBaseInfoData.personId = ((String)localObject1);
          localNetBaseInfoData = localLipReadReqData.baseInfo;
          if (!this.requestOptions.containsKey("person_type")) {
            break label829;
          }
          localObject1 = (String)this.requestOptions.get("person_type");
          localNetBaseInfoData.personType = ((String)localObject1);
          localNetBaseInfoData = localLipReadReqData.baseInfo;
          if (!this.requestOptions.containsKey("req_type")) {
            break label837;
          }
          localObject1 = (String)this.requestOptions.get("req_type");
          localNetBaseInfoData.reqType = ((String)localObject1);
          localObject1 = localLipReadReqData.baseInfo;
          if (!this.requestOptions.containsKey("live_type")) {
            break label845;
          }
          i = Integer.parseInt((String)this.requestOptions.get("live_type"));
          ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject1).liveType = i;
          localLipReadReqData.liveImage = new String((byte[])localObject4);
          localLipReadReqData.liveFivePoint = ((float[])((YtFSMBaseState)localObject3).getStateDataBy("last_frame_landmark"));
          localLipReadReqData.faceExtraInfo = ((String)((YtFSMBaseState)localObject3).getStateDataBy("face_extra_list"));
          localObject4 = (String[])((YtFSMBaseState)localObject3).getStateDataBy("action_seq");
          localObject1 = "";
          int k = localObject4.length;
          i = j;
          if (i < k)
          {
            localNetBaseInfoData = localObject4[i];
            localObject1 = (String)localObject1 + localNetBaseInfoData;
            i += 1;
            continue;
          }
          YtLogger.d(TAG, "action_seq: " + (String)localObject1);
          localLipReadReqData.validate_data = ((String)localObject1);
          localLipReadReqData.voice = new String(Base64.encode((byte[])((YtFSMBaseState)localObject3).getStateDataBy("audio_data"), 2));
          localLipReadReqData.mouth_lip_reading = ((String)((YtFSMBaseState)localObject3).getStateDataBy("lipreading_feature"));
          localLipReadReqData.mouth_move = ((String)((YtFSMBaseState)localObject3).getStateDataBy("feature"));
          localObject1 = (YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_image");
          localObject2 = (float[])((YtFSMBaseState)localObject2).getStateDataBy("best_shape");
          localObject3 = new ByteArrayOutputStream();
          ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject3);
          localLipReadReqData.bestImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject3).toByteArray(), (float[])localObject2, null);
          localObject1 = YtLivenessNetProtoHelper.makeLipReadReq(localLipReadReqData);
          YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.4(this));
          return;
        }
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "lipread request failed" + localException.getLocalizedMessage());
        YtSDKStats.getInstance().reportInfo("lipreading request failed: " + localException.getLocalizedMessage());
        YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.5(this, localException));
        return;
      }
      String str = "wx_default";
      continue;
      label821:
      str = "wx_default0";
      continue;
      label829:
      str = "youtu";
      continue;
      label837:
      str = "live";
      continue;
      label845:
      int i = 0;
    }
  }
  
  private void onReflectRequest()
  {
    CommonUtils.benchMarkBegin("reflect_request_s1");
    Object localObject2 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
    this.bestImage = ((YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("last_frame"));
    Object localObject1 = new ByteArrayOutputStream();
    this.bestImage.compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject1);
    Object localObject3 = Base64.encode(((ByteArrayOutputStream)localObject1).toByteArray(), 2);
    this.stateData.put("best_frame", this.bestImage);
    Object localObject4 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
    localObject1 = YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
    localObject4 = (ReflectLiveReq)((YtFSMBaseState)localObject4).getStateDataBy("reflect_request_object");
    Object localObject5 = (String)((YtFSMBaseState)localObject1).getStateDataBy("extra_config");
    if (localObject5 != null) {
      this.extraConfig = ((String)localObject5);
    }
    localObject1 = (String)((YtFSMBaseState)localObject1).getStateDataBy("cp_num");
    if (localObject1 != null) {
      this.changePointNum = Integer.parseInt((String)localObject1);
    }
    ((ReflectLiveReq)localObject4).session_id = UUID.randomUUID().toString();
    localObject5 = new YtLivenessNetProtoHelper.ReflectLiveReqData();
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo.appId = this.appId;
    ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo.sessionId = UUID.randomUUID().toString();
    YtLivenessNetProtoHelper.NetBaseInfoData localNetBaseInfoData = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
    label318:
    label358:
    int i;
    if (this.requestOptions.containsKey("business_id"))
    {
      localObject1 = (String)this.requestOptions.get("business_id");
      localNetBaseInfoData.businessId = ((String)localObject1);
      localNetBaseInfoData = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
      if (!this.requestOptions.containsKey("person_id")) {
        break label667;
      }
      localObject1 = (String)this.requestOptions.get("person_id");
      localNetBaseInfoData.personId = ((String)localObject1);
      localNetBaseInfoData = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
      if (!this.requestOptions.containsKey("person_type")) {
        break label672;
      }
      localObject1 = (String)this.requestOptions.get("person_type");
      localNetBaseInfoData.personType = ((String)localObject1);
      localNetBaseInfoData = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
      if (!this.requestOptions.containsKey("req_type")) {
        break label677;
      }
      localObject1 = (String)this.requestOptions.get("req_type");
      label398:
      localNetBaseInfoData.reqType = ((String)localObject1);
      localObject1 = ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).baseInfo;
      if (!this.requestOptions.containsKey("live_type")) {
        break label682;
      }
      i = Integer.parseInt((String)this.requestOptions.get("live_type"));
      label440:
      ((YtLivenessNetProtoHelper.NetBaseInfoData)localObject1).liveType = i;
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).colorData = ((ReflectLiveReq)localObject4).color_data;
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).liveImage = new String((byte[])localObject3);
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).reflectData = ((ReflectLiveReq)localObject4).reflect_data;
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).config = this.extraConfig;
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).colorNum = this.changePointNum;
      if (this.backendProtoType != 2) {
        break label687;
      }
      localObject1 = (YuvImage)((YtFSMBaseState)localObject2).getStateDataBy("best_image");
      localObject2 = (float[])((YtFSMBaseState)localObject2).getStateDataBy("best_shape");
      localObject3 = new ByteArrayOutputStream();
      ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, this.bestImage.getWidth(), this.bestImage.getHeight()), 95, (OutputStream)localObject3);
      ((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5).bestImage = new YtLivenessNetProtoHelper.ImageInfo(((ByteArrayOutputStream)localObject3).toByteArray(), (float[])localObject2, null);
    }
    label667:
    label672:
    label677:
    label682:
    label687:
    for (localObject1 = YtLivenessNetProtoHelper.makePersonLiveReq((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5);; localObject1 = YtLivenessNetProtoHelper.makeReflectLiveReq((YtLivenessNetProtoHelper.ReflectLiveReqData)localObject5))
    {
      YtLogger.d(TAG, "begin request...uploadsize " + ((String)localObject1).length());
      CommonUtils.benchMarkEnd("reflect_request_s1");
      CommonUtils.benchMarkBegin("reflect_request_s2");
      YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, null, new NetLivenessReqResultState.7(this));
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label318;
      localObject1 = null;
      break label358;
      localObject1 = null;
      break label398;
      i = 0;
      break label440;
    }
  }
  
  private void onSilentRequest()
  {
    this.bestImage = ((YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE)).getStateDataBy("last_frame"));
    int i = this.bestImage.getWidth();
    int j = this.bestImage.getHeight();
    Object localObject = new ByteArrayOutputStream();
    this.bestImage.compressToJpeg(new Rect(0, 0, i, j), 95, (OutputStream)localObject);
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    YtLivenessNetProtoHelper.PictureLiveReqData localPictureLiveReqData = new YtLivenessNetProtoHelper.PictureLiveReqData();
    localPictureLiveReqData.baseInfo = new YtLivenessNetProtoHelper.NetBaseInfoData();
    localPictureLiveReqData.baseInfo.sessionId = UUID.randomUUID().toString();
    localPictureLiveReqData.baseInfo.appId = this.appId;
    localPictureLiveReqData.imageInfo = new YtLivenessNetProtoHelper.ImageInfo((byte[])localObject, null, null);
    localObject = YtLivenessNetProtoHelper.makePictureLiveReq(localPictureLiveReqData);
    YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject, null, new NetLivenessReqResultState.2(this));
  }
  
  private void parseControlConfig()
  {
    if (!this.controlConfig.isEmpty())
    {
      String[] arrayOfString1 = this.controlConfig.split("&");
      if (arrayOfString1.length > 0)
      {
        int j = arrayOfString1.length;
        int i = 0;
        while (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          if (arrayOfString2.length > 1)
          {
            if ((arrayOfString2[0].equals("need_action_video")) && (arrayOfString2[1].equals("false"))) {
              this.needVideoData = false;
            }
            if (arrayOfString2[0].equals("actref_ux_mode")) {
              this.actRefUXMode = Integer.parseInt(arrayOfString2[1]);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetLivenessReqResultState.1(this));
    switch (NetLivenessReqResultState.11.$SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode[YtFSM.getInstance().getWorkMode().ordinal()])
    {
    default: 
      return;
    case 1: 
    case 2: 
      onActionRequest();
      return;
    case 3: 
      onReflectRequest();
      return;
    case 4: 
      if (this.actReflectType == 0)
      {
        onActReflectRequest();
        return;
      }
      onActReflectRequest2();
      return;
    }
    onLipReadRequest();
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
        if (this.resultUrl == null)
        {
          YtSDKStats.getInstance().reportError(3145728, "yt_param_error");
          YtLogger.e(TAG, "parse url failed");
          return;
        }
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
          if (!paramJSONObject.has("extra_config")) {
            break label352;
          }
          this.extraConfig = paramJSONObject.getString("extra_config");
          if (paramJSONObject.has("control_config")) {
            this.controlConfig = paramJSONObject.getString("control_config");
          }
          if (paramJSONObject.has("change_point_num")) {
            this.changePointNum = paramJSONObject.getInt("change_point_num");
          }
          if (paramJSONObject.has("manual_trigger")) {
            this.needManualTrigger = paramJSONObject.getBoolean("manual_trigger");
          }
          if (!paramJSONObject.has("request_options")) {
            break;
          }
          paramString = paramJSONObject.getJSONObject("request_options");
          Iterator localIterator = paramString.keys();
          if (!localIterator.hasNext()) {
            break;
          }
          String str1 = (String)localIterator.next();
          String str2 = paramString.getString(str1);
          this.requestOptions.put(str1, str2);
          continue;
        }
        this.finalConfidenceThreshold = 85;
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        return;
      }
      continue;
      label352:
      this.extraConfig = " version 2";
    }
    if (paramJSONObject.has("backend_proto_type")) {
      this.backendProtoType = paramJSONObject.getInt("backend_proto_type");
    }
  }
  
  public void unload()
  {
    super.unload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState
 * JD-Core Version:    0.7.0.1
 */