package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlowControlService;
import com.tencent.mobileqq.qqgamepub.data.QQGameFlowControlConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class QQGameFlowControlServiceImpl
  implements IQQGameFlowControlService
{
  private static final String CMD_RES_FLOW_CONTROL = "/v1/63";
  private static final String JSON_KEY_CAN_REQ_TIME = "canReqTime";
  private static final String JSON_KEY_RES_STATE = "resState";
  private static final String SP_FLOW_CONTROL = "sp_game_res_flow_control";
  private static final String SP_KEY_HOST = "host_";
  public static final String TAG = "QQGamePub_QQGameFlowControlServiceImpl";
  
  public static int getFileLength(String paramString)
  {
    int m = 0;
    int k = 0;
    int i = k;
    int j = m;
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      i = k;
      j = m;
      paramString.setRequestProperty("Accept-Encoding", "identity");
      i = k;
      j = m;
      k = paramString.getContentLength();
      i = k;
      j = k;
      paramString.disconnect();
      return k;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return i;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return j;
  }
  
  public static String getHost(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    Object localObject = paramString;
    if (!URLUtil.e(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramString = new URL((String)localObject).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGamePub_QQGameFlowControlServiceImpl", 1, paramString, new Object[0]);
    }
    return "";
  }
  
  public void checkResFlowControl(String paramString, WadlTrpcListener paramWadlTrpcListener)
  {
    checkResFlowControl(paramString, null, paramWadlTrpcListener);
  }
  
  public void checkResFlowControl(String paramString1, String paramString2, WadlTrpcListener paramWadlTrpcListener)
  {
    ThreadManagerV2.excute(new QQGameFlowControlServiceImpl.1(this, paramString1, paramWadlTrpcListener, paramString2), 128, null, false);
  }
  
  public QQGameFlowControlConfig getFlowControlConfig(String paramString)
  {
    paramString = getHost(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = BaseApplication.getContext().getSharedPreferences("sp_game_res_flow_control", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("host_");
        localStringBuilder.append(paramString);
        paramString = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString);
          localObject = new QQGameFlowControlConfig();
          ((QQGameFlowControlConfig)localObject).a = paramString.optInt("resState");
          ((QQGameFlowControlConfig)localObject).b = paramString.optLong("canReqTime");
          return localObject;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QQGamePub_QQGameFlowControlServiceImpl", 1, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public void saveFlowControlConfig(String paramString, long paramLong1, long paramLong2)
  {
    paramString = getHost(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("resState", paramLong1);
        localJSONObject.put("canReqTime", paramLong2);
        SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("sp_game_res_flow_control", 4).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("host_");
        localStringBuilder.append(paramString);
        localEditor.putString(localStringBuilder.toString(), localJSONObject.toString()).apply();
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QQGamePub_QQGameFlowControlServiceImpl", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameFlowControlServiceImpl
 * JD-Core Version:    0.7.0.1
 */