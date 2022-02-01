package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import java.io.File;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public class DetectOnlyState
  extends YtFSMBaseState
{
  private static final String TAG = DetectOnlyState.class.getSimpleName();
  private boolean isLoadResourceOnline = false;
  private int minFaceSize = 80;
  private boolean needBigFaceMode = false;
  private String resourceDownloadPath = "";
  
  public void enterFirst() {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (paramJSONObject.has("resource_download_path")) {
        this.resourceDownloadPath = paramJSONObject.getString("resource_download_path");
      }
      if (paramJSONObject.has("need_big_face_mode")) {
        this.needBigFaceMode = paramJSONObject.getBoolean("need_big_face_mode");
      }
      if (paramJSONObject.has("min_face_size")) {
        this.minFaceSize = paramJSONObject.getInt("min_face_size");
      }
    }
    catch (Exception paramString)
    {
      String str1;
      String str2;
      for (;;)
      {
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
        continue;
        YtLogger.i(TAG, "Use local path:" + paramString);
      }
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "align.rpdm";
      arrayOfString[1] = "align.stb";
      arrayOfString[2] = "align_bin.rpdc";
      arrayOfString[3] = "eye.rpdm";
      arrayOfString[4] = "eye_bin.rpdc";
      if (this.isLoadResourceOnline) {
        break label445;
      }
      int i = 0;
      while (i < arrayOfString.length)
      {
        str1 = arrayOfString[i];
        str2 = paramString + "/" + str1;
        FileUtils.copyAsset(paramJSONObject.getAssets(), "FaceTrackModels/ufa/" + str1, str2);
        i += 1;
      }
      arrayOfString = new String[1];
      arrayOfString[0] = "rotBasis.bin";
      if (this.isLoadResourceOnline) {
        break label542;
      }
      i = 0;
      while (i < arrayOfString.length)
      {
        str1 = arrayOfString[i];
        str2 = paramString + "/" + str1;
        FileUtils.copyAsset(paramJSONObject.getAssets(), "FaceTrackModels/poseest/" + str1, str2);
        i += 1;
      }
      i = YTFaceTrack.GlobalInit(paramString + "/");
      if (i == 0) {
        break label594;
      }
      YtSDKStats.getInstance().reportError(i, "failed to init face trace sdk");
      YtFSM.getInstance().sendFSMEvent(new DetectOnlyState.1(this, i));
      return;
      paramString = YTFaceTrack.getInstance().GetFaceDetectParam();
      YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
      paramString.bigger_face_mode = this.needBigFaceMode;
      paramString.min_face_size = this.minFaceSize;
      YTFaceTrack.getInstance().SetFaceDetectParam(paramString);
      paramString = YTFaceTrack.getInstance().GetFaceTrackParam();
      paramString.need_pose_estimate = false;
      paramString.single_detect_mode = true;
      paramString.detect_interval = -1;
      YTFaceTrack.getInstance().SetFaceTrackParam(paramString);
      YtLogger.i(TAG, "Detect version:" + YTFaceTrack.Version);
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTFaceTrackPro2");
    }
    paramJSONObject = YtFSM.getInstance().getContext().currentAppContext;
    paramString = paramJSONObject.getFilesDir().getAbsolutePath();
    if (this.isLoadResourceOnline)
    {
      paramString = this.resourceDownloadPath;
      YtLogger.i(TAG, "Use online path:" + paramString);
      arrayOfString = new String[4];
      arrayOfString[0] = "net1_18.rpnmodel";
      arrayOfString[1] = "net1_18_bin.rpnproto";
      arrayOfString[2] = "net2_36.rpnmodel";
      arrayOfString[3] = "net2_36_bin.rpnproto";
      if (this.isLoadResourceOnline) {
        break label324;
      }
      i = 0;
      while (i < arrayOfString.length)
      {
        str1 = arrayOfString[i];
        str2 = paramString + "/" + str1;
        FileUtils.copyAsset(paramJSONObject.getAssets(), "FaceTrackModels/detector/" + str1, str2);
        i += 1;
      }
    }
    label324:
    label594:
    return;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
    Object localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    Rect[] arrayOfRect = YTFaceTrack.getInstance().GetFaceRect(YTFaceTrack.getInstance().GetYTImageBitmap((Bitmap)localObject, 1));
    if (arrayOfRect == null)
    {
      YtSDKStats.getInstance().reportError(3145728, "detecet failed");
      YtFSM.getInstance().sendFSMEvent(new DetectOnlyState.2(this));
      return;
    }
    paramArrayOfByte = "[";
    paramInt1 = 0;
    while (paramInt1 < arrayOfRect.length)
    {
      paramInt2 = arrayOfRect[paramInt1].left;
      paramInt3 = arrayOfRect[paramInt1].top;
      int i = arrayOfRect[paramInt1].right;
      int j = arrayOfRect[paramInt1].left;
      int k = arrayOfRect[paramInt1].bottom;
      int m = arrayOfRect[paramInt1].top;
      localObject = paramArrayOfByte + "{\"rect\":{\"x\":" + paramInt2 + ",\"y\":" + paramInt3 + ",\"w\":" + (i - j) + ",\"h\":" + (k - m) + "}}";
      paramArrayOfByte = (byte[])localObject;
      if (paramInt1 < arrayOfRect.length - 1) {
        paramArrayOfByte = (String)localObject + ",";
      }
      paramInt1 += 1;
    }
    paramArrayOfByte = paramArrayOfByte + "]";
    paramArrayOfByte = "{\"errorcode\":0,\"errormsg\":\"OK\",\"face_count\":" + arrayOfRect.length + ",\"face_rects\":" + paramArrayOfByte + "}";
    YtSDKStats.getInstance().reportInfo("errorcode: 0, face_count: " + arrayOfRect.length);
    YtFSM.getInstance().sendFSMEvent(new DetectOnlyState.3(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState
 * JD-Core Version:    0.7.0.1
 */