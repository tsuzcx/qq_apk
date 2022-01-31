package com.tencent.youtu.sdkkitframework.ocr;

import android.graphics.YuvImage;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class OcrCardManualDetectState
  extends YtFSMBaseState
{
  private static final String TAG = OcrCardManualDetectState.class.getSimpleName();
  private int modeType = 2;
  
  public void enter()
  {
    super.enter();
    HashMap localHashMap = new HashMap();
    localHashMap.put("ui_tips", "ocr_switch_to_manual");
    localHashMap.put("ui_action", "ocr_start_manual_mode");
    YtFSM.getInstance().sendFSMEvent(localHashMap);
  }
  
  public void enterFirst() {}
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      this.modeType = paramJSONObject.getInt("mode_type");
      return;
    }
    catch (JSONException paramString)
    {
      YtLogger.e(TAG, "Failed parse json " + paramString.getLocalizedMessage());
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_OCR_REQ_RESULT_STATE));
  }
  
  public void unload()
  {
    super.unload();
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    if (paramArrayOfByte.length > 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ui_action", "pass");
      localHashMap.put("ui_tips", "ocr_manual_succeed");
      paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
      this.stateData.put("best_frame", paramArrayOfByte);
      if (!localHashMap.isEmpty()) {
        YtFSM.getInstance().sendFSMEvent(localHashMap);
      }
      moveToNextState();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.OcrCardManualDetectState
 * JD-Core Version:    0.7.0.1
 */