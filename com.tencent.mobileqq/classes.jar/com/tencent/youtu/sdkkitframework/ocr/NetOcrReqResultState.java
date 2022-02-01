package com.tencent.youtu.sdkkitframework.ocr;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Base64;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class NetOcrReqResultState
  extends YtFSMBaseState
{
  private static final String TAG = NetOcrReqResultState.class.getSimpleName();
  private HashMap<String, Object> _requestOptions = null;
  private String appId;
  private int jpegQuality;
  private String ocrtype;
  private String resultUrl;
  private String secretId;
  private String secretKey;
  private String userId;
  
  private void onRequestOcrResult()
  {
    Object localObject2 = (YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_AUTO_DETECT_STATE)).getStateDataBy("best_frame");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE)).getStateDataBy("best_frame");
    }
    if (localObject1 == null)
    {
      YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.3(this));
      return;
    }
    int i = ((YuvImage)localObject1).getWidth();
    int j = ((YuvImage)localObject1).getHeight();
    localObject2 = new ByteArrayOutputStream();
    ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, i, j), this.jpegQuality, (OutputStream)localObject2);
    byte[] arrayOfByte = Base64.encode(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
    localObject1 = "";
    label163:
    Map.Entry localEntry;
    if (this._requestOptions.size() > 0) {
      if (this.ocrtype != "idcard")
      {
        localObject1 = ",\"options\":{";
        localObject2 = this._requestOptions.entrySet().iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label307;
        }
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if (!(localEntry.getValue() instanceof String)) {
          break label270;
        }
        localObject1 = String.format("%s\"%s\":\"%s\"", new Object[] { localObject1, localEntry.getKey(), localEntry.getValue() });
        label232:
        i += 1;
        if (i >= this._requestOptions.size()) {
          break label505;
        }
        localObject1 = String.format("%s,", new Object[] { localObject1 });
      }
    }
    label270:
    label307:
    label505:
    for (;;)
    {
      break label163;
      localObject1 = ",";
      break;
      localObject1 = String.format("%s\"%s\":%s", new Object[] { localObject1, localEntry.getKey(), localEntry.getValue() });
      break label232;
      localObject2 = localObject1;
      if (this.ocrtype != "idcard") {
        localObject2 = String.format("%s}", new Object[] { localObject1 });
      }
      localObject1 = String.format("%s,", new Object[] { localObject2 });
      localObject1 = String.format("{\"app_id\":\"%s\"%s\"image\":\"%s\"}", new Object[] { this.appId, localObject1, new String(arrayOfByte) });
      YtLogger.d(TAG, "request:" + (String)localObject1);
      try
      {
        localObject2 = CommonUtils.getYoutuOpenAppSign(this.appId, this.secretId, this.secretKey, this.userId);
        YtFSM.getInstance().sendNetworkRequest("net_reporting", this.resultUrl, (String)localObject1, new NetOcrReqResultState.5(this, (String)localObject2), new NetOcrReqResultState.6(this));
        return;
      }
      catch (Exception localException)
      {
        YtLogger.e(TAG, "Failed to compose sign " + localException.getLocalizedMessage());
        YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.4(this, localException));
        return;
      }
    }
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.2(this));
    onRequestOcrResult();
  }
  
  public void enterFirst() {}
  
  public void exit()
  {
    super.exit();
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    for (;;)
    {
      try
      {
        paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "app_id", true);
        this.appId = paramString;
        if (paramString == null) {
          return;
        }
        paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "secret_key", true);
        this.secretKey = paramString;
        if (paramString == null) {
          break;
        }
        paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "secret_id", true);
        this.secretId = paramString;
        if (paramString == null) {
          break;
        }
        paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "user_id", true);
        this.userId = paramString;
        if (paramString == null) {
          break;
        }
        if (paramJSONObject.has("jpeg_quality"))
        {
          this.jpegQuality = paramJSONObject.getInt("jpeg_quality");
          this.jpegQuality = Math.min(Math.max(this.jpegQuality, 50), 99);
          this.ocrtype = paramJSONObject.getString("ocrtype");
          this.resultUrl = paramJSONObject.getJSONObject(this.ocrtype).getString("result_api_url");
          this._requestOptions = new HashMap();
          if (!paramJSONObject.getJSONObject(this.ocrtype).has("request_options")) {
            break;
          }
          paramString = paramJSONObject.getJSONObject(this.ocrtype).getJSONObject("request_options");
          paramJSONObject = paramString.keys();
          if (!paramJSONObject.hasNext()) {
            break;
          }
          String str = (String)paramJSONObject.next();
          Object localObject = paramString.get(str);
          this._requestOptions.put(str, localObject);
          continue;
        }
        this.jpegQuality = 80;
      }
      catch (JSONException paramString)
      {
        YtLogger.e(TAG, paramString.getMessage());
        YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.1(this, paramString));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState
 * JD-Core Version:    0.7.0.1
 */