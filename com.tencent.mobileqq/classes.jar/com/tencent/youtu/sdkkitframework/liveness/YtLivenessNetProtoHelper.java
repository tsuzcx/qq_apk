package com.tencent.youtu.sdkkitframework.liveness;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class YtLivenessNetProtoHelper
{
  private static final String TAG = YtLivenessNetProtoHelper.class.getSimpleName();
  
  public static String makeActionLiveReq(YtLivenessNetProtoHelper.ActionLiveReqData paramActionLiveReqData)
  {
    YtLivenessNetProtoHelper.ActionLiveReq localActionLiveReq = new YtLivenessNetProtoHelper.ActionLiveReq();
    localActionLiveReq.app_id = paramActionLiveReqData.baseInfo.appId;
    localActionLiveReq.session_id = paramActionLiveReqData.baseInfo.sessionId;
    localActionLiveReq.business_id = paramActionLiveReqData.baseInfo.businessId;
    Object localObject = new YtLivenessNetProtoHelper.Version();
    ((YtLivenessNetProtoHelper.Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((YtLivenessNetProtoHelper.Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((YtLivenessNetProtoHelper.Version)localObject).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    localObject = ((YtLivenessNetProtoHelper.Version)localObject).makeVersion();
    localActionLiveReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramActionLiveReqData.baseInfo.lux, paramActionLiveReqData.colorNum, paramActionLiveReqData.reflectConfig, (String)localObject, paramActionLiveReqData.controlConfig);
    localActionLiveReq.action_str = paramActionLiveReqData.actionStr;
    localActionLiveReq.action_video = paramActionLiveReqData.actionVideo;
    localActionLiveReq.best_image = paramActionLiveReqData.bestImage;
    localActionLiveReq.do_eye_detect = paramActionLiveReqData.needEyeDetect;
    localActionLiveReq.do_mouth_detect = paramActionLiveReqData.needMouthDetect;
    localActionLiveReq.do_live = true;
    paramActionLiveReqData = YtFSM.getInstance().getContext().imageToCompare;
    if (paramActionLiveReqData != null)
    {
      localObject = new ByteArrayOutputStream();
      paramActionLiveReqData.compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject);
      localActionLiveReq.compare_image = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 2));
      localActionLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
    }
    return new WeJson().toJson(localActionLiveReq);
  }
  
  public static String makeActionReflectLiveReq(YtLivenessNetProtoHelper.ActionReflectLiveReqData paramActionReflectLiveReqData)
  {
    YtLivenessNetProtoHelper.ActionReflectLiveReq localActionReflectLiveReq = new YtLivenessNetProtoHelper.ActionReflectLiveReq();
    localActionReflectLiveReq.app_id = paramActionReflectLiveReqData.baseInfo.appId;
    localActionReflectLiveReq.session_id = paramActionReflectLiveReqData.baseInfo.sessionId;
    localActionReflectLiveReq.business_id = paramActionReflectLiveReqData.baseInfo.businessId;
    localActionReflectLiveReq.platform = 2;
    Object localObject = new YtLivenessNetProtoHelper.Version();
    ((YtLivenessNetProtoHelper.Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((YtLivenessNetProtoHelper.Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((YtLivenessNetProtoHelper.Version)localObject).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    ((YtLivenessNetProtoHelper.Version)localObject).freflect_sdk_version = "3.6.2";
    localObject = ((YtLivenessNetProtoHelper.Version)localObject).makeVersion();
    localActionReflectLiveReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramActionReflectLiveReqData.baseInfo.lux, paramActionReflectLiveReqData.colorNum, paramActionReflectLiveReqData.reflectConfig, (String)localObject, paramActionReflectLiveReqData.controlConfig);
    localActionReflectLiveReq.action_video = paramActionReflectLiveReqData.actionVideo;
    localActionReflectLiveReq.color_data = paramActionReflectLiveReqData.colorData;
    localActionReflectLiveReq.action_str = paramActionReflectLiveReqData.actionStr;
    localObject = YtFSM.getInstance().getContext().imageToCompare;
    if (localObject != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 95, localByteArrayOutputStream);
      localActionReflectLiveReq.compare_image = new YtLivenessNetProtoHelper.ImageInfo(localByteArrayOutputStream.toByteArray(), null, null);
      localActionReflectLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
    }
    localActionReflectLiveReq.live_image = paramActionReflectLiveReqData.liveImage;
    localActionReflectLiveReq.mouth_image = paramActionReflectLiveReqData.mouthImage;
    localActionReflectLiveReq.eye_image = paramActionReflectLiveReqData.eyeImage;
    localActionReflectLiveReq.mode = paramActionReflectLiveReqData.mode;
    localActionReflectLiveReq.reflect_data = paramActionReflectLiveReqData.reflectData;
    return new WeJson().toJson(localActionReflectLiveReq);
  }
  
  public static String makeGetLiveTypeReq(YtLivenessNetProtoHelper.GetLiveTypeReqData paramGetLiveTypeReqData)
  {
    YtLivenessNetProtoHelper.GetLiveTypeReq localGetLiveTypeReq = new YtLivenessNetProtoHelper.GetLiveTypeReq();
    localGetLiveTypeReq.app_id = paramGetLiveTypeReqData.baseInfo.appId;
    localGetLiveTypeReq.business_name = paramGetLiveTypeReqData.baseInfo.businessId;
    localGetLiveTypeReq.person_id = paramGetLiveTypeReqData.baseInfo.personId;
    localGetLiveTypeReq.platform = 2;
    localGetLiveTypeReq.session_id = paramGetLiveTypeReqData.baseInfo.sessionId;
    Object localObject = new YtLivenessNetProtoHelper.Version();
    ((YtLivenessNetProtoHelper.Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((YtLivenessNetProtoHelper.Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    if (YtFSM.getInstance().getWorkMode() == YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE) {
      ((YtLivenessNetProtoHelper.Version)localObject).faction_sdk_version = YTPoseDetectJNIInterface.getVersion();
    }
    ((YtLivenessNetProtoHelper.Version)localObject).freflect_sdk_version = "3.6.2";
    localObject = ((YtLivenessNetProtoHelper.Version)localObject).makeVersion();
    localGetLiveTypeReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramGetLiveTypeReqData.baseInfo.lux, paramGetLiveTypeReqData.colorNum, paramGetLiveTypeReqData.reflectConfig, (String)localObject, paramGetLiveTypeReqData.controlConfig);
    return new WeJson().toJson(localGetLiveTypeReq);
  }
  
  public static String makeLipReadReq(YtLivenessNetProtoHelper.LipReadReqData paramLipReadReqData)
  {
    int j = 0;
    YtLivenessNetProtoHelper.PersonLiveReq localPersonLiveReq = new YtLivenessNetProtoHelper.PersonLiveReq();
    localPersonLiveReq.app_id = paramLipReadReqData.baseInfo.appId;
    localPersonLiveReq.business_name = paramLipReadReqData.baseInfo.businessId;
    localPersonLiveReq.person_id = paramLipReadReqData.baseInfo.personId;
    localPersonLiveReq.livedata = new YtLivenessNetProtoHelper.PersonLive();
    localPersonLiveReq.livedata.frames = new ArrayList();
    Object localObject = new YtLivenessNetProtoHelper.FaceFrame();
    ((YtLivenessNetProtoHelper.FaceFrame)localObject).image = paramLipReadReqData.liveImage;
    ((YtLivenessNetProtoHelper.FaceFrame)localObject).x_coordinates = new ArrayList();
    ((YtLivenessNetProtoHelper.FaceFrame)localObject).y_coordinates = new ArrayList();
    int i = 0;
    while (i < 5)
    {
      ((YtLivenessNetProtoHelper.FaceFrame)localObject).x_coordinates.add(Float.valueOf(paramLipReadReqData.liveFivePoint[(i * 2)]));
      ((YtLivenessNetProtoHelper.FaceFrame)localObject).y_coordinates.add(Float.valueOf(paramLipReadReqData.liveFivePoint[(i * 2 + 1)]));
      i += 1;
    }
    localPersonLiveReq.livedata.frames.add(localObject);
    try
    {
      localObject = new JSONObject(paramLipReadReqData.faceExtraInfo);
      YtLivenessNetProtoHelper.FaceFrame localFaceFrame = new YtLivenessNetProtoHelper.FaceFrame();
      localFaceFrame.image = ((JSONObject)localObject).getString("openmouth_img");
      localFaceFrame.x_coordinates = new ArrayList();
      localFaceFrame.y_coordinates = new ArrayList();
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("openmouth_5pts");
      i = 0;
      while (i < 5)
      {
        localFaceFrame.x_coordinates.add(Float.valueOf((float)localJSONArray.optDouble(i * 2)));
        localFaceFrame.y_coordinates.add(Float.valueOf((float)localJSONArray.optDouble(i * 2 + 1)));
        i += 1;
      }
      localPersonLiveReq.livedata.frames.add(localFaceFrame);
      localFaceFrame = new YtLivenessNetProtoHelper.FaceFrame();
      localFaceFrame.image = ((JSONObject)localObject).getString("closeeye_img");
      localFaceFrame.x_coordinates = new ArrayList();
      localFaceFrame.y_coordinates = new ArrayList();
      localObject = ((JSONObject)localObject).getJSONArray("closeeye_5pts");
      i = j;
      while (i < 5)
      {
        localFaceFrame.x_coordinates.add(Float.valueOf((float)((JSONArray)localObject).optDouble(i * 2)));
        localFaceFrame.y_coordinates.add(Float.valueOf((float)((JSONArray)localObject).optDouble(i * 2 + 1)));
        i += 1;
      }
      localPersonLiveReq.livedata.frames.add(localFaceFrame);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        YtLogger.e(TAG, "Failed parse extra face list " + localException.getLocalizedMessage());
      }
    }
    localPersonLiveReq.livedata.validate_data = paramLipReadReqData.validate_data;
    localPersonLiveReq.livedata.voice = paramLipReadReqData.voice;
    localPersonLiveReq.livedata.mouth_move = paramLipReadReqData.mouth_move;
    localPersonLiveReq.livedata.mouth_lip_reading = paramLipReadReqData.mouth_lip_reading;
    localPersonLiveReq.livedata.platform = 2;
    localPersonLiveReq.person_type = paramLipReadReqData.baseInfo.personType;
    localPersonLiveReq.live_type = paramLipReadReqData.baseInfo.liveType;
    localPersonLiveReq.req_type = paramLipReadReqData.baseInfo.reqType;
    return new WeJson().toJson(localPersonLiveReq);
  }
  
  public static String makePersonLiveReq(YtLivenessNetProtoHelper.ReflectLiveReqData paramReflectLiveReqData)
  {
    YtLivenessNetProtoHelper.PersonLiveReq localPersonLiveReq = new YtLivenessNetProtoHelper.PersonLiveReq();
    localPersonLiveReq.app_id = paramReflectLiveReqData.baseInfo.appId;
    localPersonLiveReq.business_name = paramReflectLiveReqData.baseInfo.businessId;
    localPersonLiveReq.person_id = paramReflectLiveReqData.baseInfo.personId;
    localPersonLiveReq.live_type = paramReflectLiveReqData.baseInfo.liveType;
    localPersonLiveReq.req_type = paramReflectLiveReqData.baseInfo.reqType;
    localPersonLiveReq.request_id = paramReflectLiveReqData.baseInfo.sessionId;
    localPersonLiveReq.person_type = paramReflectLiveReqData.baseInfo.personType;
    localPersonLiveReq.livedata = new YtLivenessNetProtoHelper.PersonLive();
    localPersonLiveReq.livedata.reflect_data = paramReflectLiveReqData.reflectData;
    localPersonLiveReq.livedata.color_data = paramReflectLiveReqData.colorData;
    localPersonLiveReq.livedata.platform = 2;
    localPersonLiveReq.livedata.frames = new ArrayList();
    YtLivenessNetProtoHelper.FaceFrame localFaceFrame = new YtLivenessNetProtoHelper.FaceFrame();
    localFaceFrame.image = paramReflectLiveReqData.liveImage;
    localPersonLiveReq.livedata.frames.add(localFaceFrame);
    return new WeJson().toJson(localPersonLiveReq);
  }
  
  public static String makePictureLiveReq(YtLivenessNetProtoHelper.PictureLiveReqData paramPictureLiveReqData)
  {
    YtLivenessNetProtoHelper.PictureLiveDetectReq localPictureLiveDetectReq = new YtLivenessNetProtoHelper.PictureLiveDetectReq();
    localPictureLiveDetectReq.app_id = paramPictureLiveReqData.baseInfo.appId;
    localPictureLiveDetectReq.session_id = paramPictureLiveReqData.baseInfo.sessionId;
    localPictureLiveDetectReq.five_point = paramPictureLiveReqData.imageInfo.five_points;
    localPictureLiveDetectReq.image = paramPictureLiveReqData.imageInfo.image;
    Object localObject = new YtLivenessNetProtoHelper.Version();
    ((YtLivenessNetProtoHelper.Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((YtLivenessNetProtoHelper.Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((YtLivenessNetProtoHelper.Version)localObject).freflect_sdk_version = "3.6.2";
    localObject = ((YtLivenessNetProtoHelper.Version)localObject).makeVersion();
    localPictureLiveDetectReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramPictureLiveReqData.baseInfo.lux, 0, "", (String)localObject, "");
    return new WeJson().toJson(localPictureLiveDetectReq);
  }
  
  public static String makeReflectLiveReq(YtLivenessNetProtoHelper.ReflectLiveReqData paramReflectLiveReqData)
  {
    YtLivenessNetProtoHelper.ReflectLiveReq localReflectLiveReq = new YtLivenessNetProtoHelper.ReflectLiveReq();
    localReflectLiveReq.app_id = paramReflectLiveReqData.baseInfo.appId;
    localReflectLiveReq.session_id = paramReflectLiveReqData.baseInfo.sessionId;
    localReflectLiveReq.business_id = paramReflectLiveReqData.baseInfo.businessId;
    localReflectLiveReq.platform = 2;
    localReflectLiveReq.color_data = paramReflectLiveReqData.colorData;
    localReflectLiveReq.live_image = paramReflectLiveReqData.liveImage;
    localReflectLiveReq.reflect_data = paramReflectLiveReqData.reflectData;
    Object localObject = new YtLivenessNetProtoHelper.Version();
    ((YtLivenessNetProtoHelper.Version)localObject).sdk_version = YtSDKKitFramework.getInstance().version();
    ((YtLivenessNetProtoHelper.Version)localObject).ftrack_sdk_version = YTFaceTrack.Version;
    ((YtLivenessNetProtoHelper.Version)localObject).freflect_sdk_version = "3.6.2";
    localObject = ((YtLivenessNetProtoHelper.Version)localObject).makeVersion();
    localReflectLiveReq.select_data = new YtLivenessNetProtoHelper.LiveStyleRequester.SeleceData(paramReflectLiveReqData.baseInfo.lux, paramReflectLiveReqData.colorNum, paramReflectLiveReqData.config, (String)localObject, "");
    paramReflectLiveReqData = YtFSM.getInstance().getContext().imageToCompare;
    if (paramReflectLiveReqData != null)
    {
      localObject = new ByteArrayOutputStream();
      paramReflectLiveReqData.compress(Bitmap.CompressFormat.JPEG, 95, (OutputStream)localObject);
      localReflectLiveReq.compare_image = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 2));
      localReflectLiveReq.compare_image_type = YtFSM.getInstance().getContext().imageToComapreType;
    }
    return new WeJson().toJson(localReflectLiveReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.YtLivenessNetProtoHelper
 * JD-Core Version:    0.7.0.1
 */