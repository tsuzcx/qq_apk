package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

class ThirdAppProxyImpl$QueryDownloadInfoListener
  implements WadlCmdListener
{
  private String b;
  private AsyncResult c;
  
  public ThirdAppProxyImpl$QueryDownloadInfoListener(ThirdAppProxyImpl paramThirdAppProxyImpl, String paramString, AsyncResult paramAsyncResult)
  {
    this.b = paramString;
    this.c = paramAsyncResult;
  }
  
  public HashSet<String> getFilterCmds()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("13169");
    return localHashSet;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    paramIntent = new StringBuilder();
    paramIntent.append("onCmdRsp ret=");
    paramIntent.append(paramLong);
    paramIntent.append(",cmd=");
    paramIntent.append(paramString);
    paramIntent.append(",dataJson=");
    paramIntent.append(paramJSONObject);
    QLog.i("ThirdAppProxyImpl", 1, paramIntent.toString());
    if ("13169".equals(paramString)) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        localAsyncResult = this.c;
        if (localAsyncResult == null) {
          return;
        }
        paramIntent = null;
        Object localObject = null;
        this.c = null;
        bool2 = false;
        if (paramLong != 0L)
        {
          localAsyncResult.onReceiveResult(false, null);
          return;
        }
        paramString = localObject;
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("v_appd_down_load_info");
          if (paramJSONObject == null) {
            break label194;
          }
          paramString = localObject;
          paramIntent = paramJSONObject.getJSONObject(0);
        }
        catch (Throwable paramIntent)
        {
          QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
          bool1 = bool2;
          if (paramString == null) {
            continue;
          }
          bool1 = true;
          localAsyncResult.onReceiveResult(bool1, paramString);
          return;
        }
        paramString = paramIntent;
        localAsyncResult.onReceiveResult(bool1, paramIntent);
        return;
      }
      catch (Throwable paramIntent)
      {
        AsyncResult localAsyncResult;
        boolean bool2;
        QLog.e("ThirdAppProxyImpl", 1, "exception. ", paramIntent);
      }
      return;
      label194:
      if (paramIntent != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl.QueryDownloadInfoListener
 * JD-Core Version:    0.7.0.1
 */