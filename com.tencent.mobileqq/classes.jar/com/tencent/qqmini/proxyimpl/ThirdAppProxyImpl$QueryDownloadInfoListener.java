package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import bkja;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

class ThirdAppProxyImpl$QueryDownloadInfoListener
  implements bkja
{
  private String mAppid;
  private AsyncResult mCallback;
  
  public ThirdAppProxyImpl$QueryDownloadInfoListener(ThirdAppProxyImpl paramThirdAppProxyImpl, String paramString, AsyncResult paramAsyncResult)
  {
    this.mAppid = paramString;
    this.mCallback = paramAsyncResult;
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("13169");
    return localHashSet;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    paramIntent = null;
    Object localObject = null;
    QLog.i("ThirdAppProxyImpl", 1, "onCmdRsp ret=" + paramLong + ",cmd=" + paramString + ",dataJson=" + paramJSONObject);
    AsyncResult localAsyncResult;
    if ("13169".equals(paramString))
    {
      try
      {
        localAsyncResult = this.mCallback;
        if (localAsyncResult == null) {
          return;
        }
        this.mCallback = null;
        if (paramLong != 0L)
        {
          localAsyncResult.onReceiveResult(false, null);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
        return;
      }
      paramString = localObject;
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("v_appd_down_load_info");
        if (paramJSONObject == null) {
          break label186;
        }
        paramString = localObject;
        paramIntent = paramJSONObject.getJSONObject(0);
      }
      catch (Throwable paramIntent)
      {
        QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
        if (paramString == null) {
          break label179;
        }
      }
      paramString = paramIntent;
      localAsyncResult.onReceiveResult(bool, paramIntent);
      return;
      boolean bool = true;
      label162:
      localAsyncResult.onReceiveResult(bool, paramString);
      return;
      label179:
      label186:
      do
      {
        bool = false;
        break;
        bool = false;
        break label162;
        return;
      } while (paramIntent == null);
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl.QueryDownloadInfoListener
 * JD-Core Version:    0.7.0.1
 */