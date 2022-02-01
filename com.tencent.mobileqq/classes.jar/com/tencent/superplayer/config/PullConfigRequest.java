package com.tencent.superplayer.config;

import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.HttpResponse;
import com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.ITVKHttpCallback;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoConfig;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoHttpProcessor;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class PullConfigRequest
{
  private static int CURRENT_HOST_URL_RETRY_MAX_COUNT = TVKVideoInfoConfig.getInstance().getCgiRetryTime();
  private static final String PROTOCOL_CHARSET = "utf-8";
  private static String REQUEST_URL;
  private static String TAG = "PullConfigRequest";
  private PullConfigRequest.PullConfigCallback mCallback;
  private int mCurrentHostUrlRetryCount = 0;
  private ITVKHttpProcessor.ITVKHttpCallback mPullConfigCb = new PullConfigRequest.1(this);
  private String mRequestRootGroupName;
  
  static
  {
    REQUEST_URL = "https://cgi.kandian.qq.com/trpc.tkdqq.kd_rainbow_proxy.ConfigService/PullConfigReq";
  }
  
  private void callbackOnFailureOrRetry(Exception paramException)
  {
    if (this.mCurrentHostUrlRetryCount > CURRENT_HOST_URL_RETRY_MAX_COUNT) {
      return;
    }
    this.mCurrentHostUrlRetryCount += 1;
    executeRequest();
  }
  
  private void executeRequest()
  {
    executeRequest(this.mRequestRootGroupName, this.mCallback);
  }
  
  private Map<String, String> generateHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Content-Type", "application/json");
    return localHashMap;
  }
  
  private Map<String, String> generateParam()
  {
    return new HashMap();
  }
  
  private JSONArray getClientInfo()
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("client_identified_name", "qmei");
    localJSONObject.put("client_identified_value", BeaconAdapter.getQIMEI());
    localJSONArray.put(localJSONObject);
    return localJSONArray;
  }
  
  private byte[] getRequestRawData()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("app_id", "07d79ecd-33f9-4b90-80cb-e12359816b34");
      localJSONObject.put("group", this.mRequestRootGroupName);
      localJSONObject.put("version", SuperPlayerSDKMgr.getSDKVersion());
      ((JSONObject)localObject).put("pull_item", localJSONObject);
      ((JSONObject)localObject).put("client_infos", getClientInfo());
      localObject = ((JSONObject)localObject).toString().getBytes("utf-8");
      return localObject;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "getRequestRawData error", localException);
    }
    return new byte[0];
  }
  
  private void handleHttpCallbackOnSuccess(ITVKHttpProcessor.HttpResponse paramHttpResponse)
  {
    TVKLogUtil.i(TAG, "pullConfigRequest onSuccess.");
    for (;;)
    {
      try
      {
        if ((paramHttpResponse.mHeaders.containsKey("Content-Encoding")) && (((List)paramHttpResponse.mHeaders.get("Content-Encoding")).contains("gzip")))
        {
          paramHttpResponse = TVKUtils.gzipDeCompress(paramHttpResponse.mData);
          if (paramHttpResponse != null)
          {
            paramHttpResponse = new String(paramHttpResponse, "UTF-8");
            LogUtil.i(TAG, "handleHttpCallbackOnSuccess response:" + paramHttpResponse);
            if (this.mCallback == null) {
              break;
            }
            this.mCallback.onConfigPulled(paramHttpResponse);
          }
        }
        else
        {
          paramHttpResponse = new String(paramHttpResponse.mData, "UTF-8");
          continue;
        }
        paramHttpResponse = "";
      }
      catch (Exception paramHttpResponse)
      {
        TVKLogUtil.e(TAG, paramHttpResponse);
        callbackOnFailureOrRetry(paramHttpResponse);
        return;
      }
    }
  }
  
  public void executeRequest(String paramString, PullConfigRequest.PullConfigCallback paramPullConfigCallback)
  {
    this.mRequestRootGroupName = paramString;
    this.mCallback = paramPullConfigCallback;
    TVKVideoInfoHttpProcessor.getInstance().addToRequestQueue(this.mCurrentHostUrlRetryCount, REQUEST_URL, generateParam(), generateHeaders(), getRequestRawData(), this.mPullConfigCb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.config.PullConfigRequest
 * JD-Core Version:    0.7.0.1
 */