package com.tencent.youtu.sdkkitframework.liveness;

import android.content.Context;
import com.tencent.youtu.YTFaceTracker;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import java.io.File;
import org.json.JSONObject;

public class DetectOnlyState
  extends YtFSMBaseState
{
  private static final String TAG = DetectOnlyState.class.getSimpleName();
  private boolean isLoadResourceOnline = false;
  private int minFaceSize = 80;
  private boolean needBigFaceMode = false;
  private String resourceDownloadPath = "";
  private YTFaceTracker tracker;
  
  public void enterFirst() {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    int i = 1;
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
      try
      {
        if (this.isLoadResourceOnline) {
          break label334;
        }
        for (this.tracker = new YTFaceTracker(paramJSONObject.getAssets(), "models/face-tracker-v001", "config.ini");; this.tracker = new YTFaceTracker(paramString, "config.ini"))
        {
          paramString = this.tracker.getParam();
          YtLogger.i(TAG, "big face mode" + this.needBigFaceMode);
          if (!this.needBigFaceMode) {
            break label390;
          }
          paramString.biggerFaceMode = i;
          paramString.minFaceSize = this.minFaceSize;
          paramString.detInterval = -1;
          this.tracker.setParam(paramString);
          YtLogger.i(TAG, "Detect version:" + YTFaceTracker.getVersion());
          return;
          paramString = paramString;
          YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
          break;
          YtLogger.i(TAG, "Use local path:" + paramString);
          break label151;
        }
        i = 0;
      }
      catch (Exception paramString)
      {
        YtLogger.e(TAG, paramString.getLocalizedMessage());
        paramString.printStackTrace();
        YtSDKStats.getInstance().reportError(1, "failed to init face trace sdk");
        YtFSM.getInstance().sendFSMEvent(new DetectOnlyState.1(this));
        return;
      }
    }
    if (!this.isLoadResourceOnline) {
      FileUtils.loadLibrary("YTFaceTracker");
    }
    paramJSONObject = YtFSM.getInstance().getContext().currentAppContext;
    paramString = paramJSONObject.getFilesDir().getAbsolutePath();
    if (this.isLoadResourceOnline)
    {
      paramString = this.resourceDownloadPath;
      YtLogger.i(TAG, "Use online path:" + paramString);
    }
    label151:
    label334:
    for (;;) {}
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.liveness.DetectOnlyState
 * JD-Core Version:    0.7.0.1
 */