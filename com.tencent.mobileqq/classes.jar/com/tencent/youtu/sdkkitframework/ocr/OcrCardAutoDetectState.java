package com.tencent.youtu.sdkkitframework.ocr;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.youtu.sdk.ocr.imagerefiner.YtImageRefinerSDK;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class OcrCardAutoDetectState
  extends YtFSMBaseState
{
  private static final long MAX_AUTO_TIMEOUT_MS = 30000L;
  private static final long MIN_AUTO_TIMEOUT_MS = 5000L;
  private static final String TAG = OcrCardAutoDetectState.class.getSimpleName();
  private double areaLowerThreshold = 0.699999988079071D;
  private double areaUpperThreshold = 1.0D;
  private long autoTimeoutMs = 10000L;
  private long beginTime;
  private byte[] bestFrame;
  private double bestScore = -10000000000.0D;
  private int blurCountThreshold = 5;
  private double blurThreshold = 0.300000011920929D;
  private int focusMaxCount = 1000;
  private boolean isLoadResourceOnline = false;
  private boolean isTimeOut;
  private int modeType = 2;
  private float scale = 1.0F;
  int screenHeight;
  int screenWidth;
  private int targetConfigHeight = 780;
  private int targetConfigWidth = 1040;
  private int tooBlurCount = 0;
  private int validCountThreshold = 15;
  
  private Rect getRoiRect(int paramInt1, int paramInt2)
  {
    YtLogger.d(TAG, "screenWidth: " + this.screenWidth + ", screenHeight: " + this.screenHeight);
    YtLogger.d(TAG, "scale " + this.scale);
    YtLogger.d(TAG, "targetConfigWidth: " + this.targetConfigWidth);
    Rect localRect1 = YtSDKKitFramework.getInstance().getPreviewRect();
    Rect localRect2 = YtSDKKitFramework.getInstance().getDetectRect();
    float f = paramInt1 / localRect1.width();
    paramInt1 = (int)(localRect2.left * f);
    int i = (int)(localRect2.top * f);
    int j = (int)(localRect2.right * f);
    int k = (int)(localRect2.bottom * f);
    paramInt2 = (paramInt2 - (int)(localRect1.height() * f)) / 2;
    return new Rect(paramInt1, i + paramInt2, j, paramInt2 + k);
  }
  
  public void enter()
  {
    super.enter();
    this.tooBlurCount = 0;
    YtImageRefinerSDK.getInstance().setTargetPreviewRect(new Rect(66, 66, 468, 340));
    YtImageRefinerSDK.getInstance().setBlurThreshold(this.blurThreshold);
    YtImageRefinerSDK.getInstance().setValidFrameCountThreshold(this.validCountThreshold);
    YtImageRefinerSDK.getInstance().setBlurCountThreshold(this.blurCountThreshold);
    YtImageRefinerSDK.getInstance().setMaxFocusCheckCount(this.focusMaxCount);
    YtImageRefinerSDK.getInstance().setAreaRatioLowerThreshold(this.areaLowerThreshold);
    YtImageRefinerSDK.getInstance().setAreaRatioUpperThreshold(this.areaUpperThreshold);
    this.beginTime = System.currentTimeMillis();
    YtFSM.getInstance().sendFSMEvent(new OcrCardAutoDetectState.2(this));
    if (this.modeType == 0) {
      moveToNextState();
    }
  }
  
  public void enterFirst() {}
  
  public void exit()
  {
    super.exit();
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (!this.isLoadResourceOnline) {
        System.loadLibrary("YTImageRefiner");
      }
      YtLogger.d(TAG, "Load " + YtImageRefinerSDK.version());
      int i = YtImageRefinerSDK.getInstance().init();
      if (i != 0)
      {
        YtLogger.e(TAG, "Failed to init sdk " + i);
        YtFSM.getInstance().sendFSMEvent(new OcrCardAutoDetectState.1(this, i));
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
      }
      paramString = (WindowManager)YtFSM.getInstance().getContext().currentAppContext.getSystemService("window");
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramString.getDefaultDisplay().getMetrics(localDisplayMetrics);
      YtLogger.d(TAG, "wm " + localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels + " dp" + localDisplayMetrics.scaledDensity);
      this.screenHeight = YtFSM.getInstance().getContext().currentAppContext.getResources().getDisplayMetrics().heightPixels;
      this.screenWidth = YtFSM.getInstance().getContext().currentAppContext.getResources().getDisplayMetrics().widthPixels;
    }
    try
    {
      this.modeType = paramJSONObject.getInt("mode_type");
      this.autoTimeoutMs = paramJSONObject.getLong("auto_timeout_ms");
      this.autoTimeoutMs = Math.max(5000L, Math.min(this.autoTimeoutMs, 30000L));
      if (paramJSONObject.has("net_request_timeout_ms")) {
        YtSDKKitFramework.getInstance().setNetworkRequestTimeoutMS(paramJSONObject.getInt("net_request_timeout_ms"));
      }
      if (paramJSONObject.has("blur_threshold")) {
        this.blurThreshold = paramJSONObject.getDouble("blur_threshold");
      }
      if (paramJSONObject.has("blur_count_threshold")) {
        this.blurCountThreshold = paramJSONObject.getInt("blur_count_threshold");
      }
      if (paramJSONObject.has("valid_count_threshold")) {
        this.validCountThreshold = paramJSONObject.getInt("valid_count_threshold");
      }
      if (paramJSONObject.has("focus_max_count")) {
        this.focusMaxCount = paramJSONObject.getInt("focus_max_count");
      }
      if (paramJSONObject.has("target_width")) {
        this.targetConfigWidth = paramJSONObject.getInt("target_width");
      }
      if (paramJSONObject.has("target_height")) {
        this.targetConfigHeight = paramJSONObject.getInt("target_height");
      }
      if (paramJSONObject.has("target_area_lower_ratio")) {
        this.areaLowerThreshold = paramJSONObject.getDouble("target_area_lower_ratio");
      }
      if (paramJSONObject.has("target_area_upper_ratio")) {
        this.areaUpperThreshold = paramJSONObject.getDouble("target_area_upper_ratio");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        YtLogger.e(TAG, "Failed parse json " + paramString.getLocalizedMessage());
      }
    }
    this.isTimeOut = false;
    this.scale = (this.screenWidth / 1920.0F);
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    if (this.modeType == 0)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE));
      return;
    }
    if (this.isTimeOut)
    {
      if (this.modeType == 2)
      {
        YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE));
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("ui_action", "process_finished");
      localHashMap.put("ui_tips", "rst_failed");
      localHashMap.put("process_action", "failed");
      localHashMap.put("error_code", Integer.valueOf(4194304));
      localHashMap.put("message", CommonUtils.makeMessageJson(4194304, "ocr_auto_timeout", ""));
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
      YtFSM.getInstance().sendFSMEvent(localHashMap);
      return;
    }
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_OCR_REQ_RESULT_STATE));
  }
  
  public void unload()
  {
    super.unload();
    int i = YtImageRefinerSDK.getInstance().deInit();
    if (i != 0) {
      YtLogger.e(TAG, " Failed to deinit sdk " + i);
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    double[] arrayOfDouble = new double[1];
    int[] arrayOfInt = new int[8];
    HashMap localHashMap = new HashMap();
    Rect localRect = getRoiRect(paramInt1, paramInt2);
    YtLogger.d(TAG, "roi rect: " + localRect.left + "," + localRect.top + "," + localRect.right + "," + localRect.bottom);
    YtImageRefinerSDK.getInstance().setTargetPreviewRect(localRect);
    if (System.currentTimeMillis() - this.beginTime > this.autoTimeoutMs)
    {
      this.isTimeOut = true;
      moveToNextState();
      return;
    }
    paramInt3 = YtImageRefinerSDK.getInstance().detectFrame(paramArrayOfByte, paramInt1, paramInt2, arrayOfDouble, arrayOfInt);
    YtLogger.d(TAG, "detectFrame ret: " + paramInt3 + " blurScore: " + arrayOfDouble[0]);
    if (((paramInt3 == 0) || (paramInt3 == 20481)) && (this.bestScore < arrayOfDouble[0]))
    {
      this.bestScore = arrayOfDouble[0];
      if (this.bestFrame == null) {
        this.bestFrame = new byte[paramArrayOfByte.length];
      }
      this.bestFrame = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    }
    if ((paramInt3 == 0) && (arrayOfInt[0] != 0))
    {
      YtLogger.d(TAG, "Found proper image with score: " + this.bestScore);
      localHashMap.put("ui_action", "pass");
      localHashMap.put("ui_tips", "ocr_auto_succeed");
      paramArrayOfByte = new YuvImage(this.bestFrame, 17, paramInt1, paramInt2, null);
      this.stateData.put("best_frame", paramArrayOfByte);
      if (!localHashMap.isEmpty()) {
        YtFSM.getInstance().sendFSMEvent(localHashMap);
      }
      moveToNextState();
      return;
    }
    switch (paramInt3)
    {
    default: 
      if ((paramInt3 & 0x2000) == 8192)
      {
        localHashMap.put("ui_action", "process_finished");
        localHashMap.put("ui_tips", "rst_failed");
        localHashMap.put("process_action", "failed");
        localHashMap.put("error_code", Integer.valueOf(paramInt3));
        localHashMap.put("message", CommonUtils.makeMessageJson(paramInt3, "msg_inner_error", "Native error " + paramInt3));
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
      }
      break;
    }
    while (!localHashMap.isEmpty())
    {
      YtFSM.getInstance().sendFSMEvent(localHashMap);
      return;
      localHashMap.put("ui_action", "process_finished");
      localHashMap.put("ui_tips", "rst_failed");
      localHashMap.put("process_action", "failed");
      localHashMap.put("error_code", Integer.valueOf(3145728 + paramInt3));
      localHashMap.put("message", CommonUtils.makeMessageJson(3145728, "msg_param_error", "Param failed with" + paramInt3));
      continue;
      localHashMap.put("ui_tips", "ocr_card_closer");
      localHashMap.put("ui_action", "not_pass");
      continue;
      localHashMap.put("ui_tips", "ocr_card_farer");
      localHashMap.put("ui_action", "not_pass");
      continue;
      localHashMap.put("ui_tips", "ocr_cam_blur");
      localHashMap.put("ui_action", "card_not_found");
      this.tooBlurCount += 1;
      if (this.tooBlurCount > 20)
      {
        localHashMap.put("ui_action", "need_focus");
        this.tooBlurCount = 0;
        continue;
        localHashMap.put("ui_tips", "ocr_no_card");
        localHashMap.put("ui_action", "card_not_found");
        continue;
        localHashMap.put("ui_tips", "ocr_pose_keep");
        localHashMap.put("ui_action", "pass");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.OcrCardAutoDetectState
 * JD-Core Version:    0.7.0.1
 */