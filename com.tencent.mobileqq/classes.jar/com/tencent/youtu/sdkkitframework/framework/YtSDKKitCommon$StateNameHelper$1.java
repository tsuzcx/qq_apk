package com.tencent.youtu.sdkkitframework.framework;

import java.util.HashMap;

final class YtSDKKitCommon$StateNameHelper$1
  extends HashMap<YtSDKKitCommon.StateNameHelper.StateClassName, String>
{
  YtSDKKitCommon$StateNameHelper$1()
  {
    put(YtSDKKitCommon.StateNameHelper.StateClassName.UNKNOWN_STATE, "com.tencent.youtu.sdkkitframework.liveness.Unknown");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE, "com.tencent.youtu.sdkkitframework.framework.TimeoutState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE, "com.tencent.youtu.sdkkitframework.framework.IdleState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE, "com.tencent.youtu.sdkkitframework.liveness.SilentLivenessState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE, "com.tencent.youtu.sdkkitframework.liveness.ActionLivenessState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE, "com.tencent.youtu.sdkkitframework.liveness.ReflectLivenessState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_AUTO_DETECT_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrCardAutoDetectState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrCardManualDetectState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE, "com.tencent.youtu.sdkkitframework.liveness.NetFetchState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE, "com.tencent.youtu.sdkkitframework.liveness.NetLivenessReqResultState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.NET_OCR_REQ_RESULT_STATE, "com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.LIPREAD_STATE, "com.tencent.youtu.sdkkitframework.liveness.LipReadLivenessState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.DETECTONLY_STATE, "com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState");
    put(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_VIID_STATE, "com.tencent.youtu.sdkkitframework.ocr.OcrVideoIdentState");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.1
 * JD-Core Version:    0.7.0.1
 */