package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.request.BookShelfInsertRequest;
import com.tencent.qqmini.sdk.request.BookShelfQueryRequest;
import com.tencent.qqmini.sdk.request.BookShelfUpdateRequest;
import com.tencent.qqmini.sdk.request.DataReportRequest;
import com.tencent.qqmini.sdk.request.ProtoBufRequest;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import org.json.JSONObject;

public class RequestServer
{
  public static final String KEY_ERRMSG = "errMsg";
  public static final String KEY_RETCODE = "retCode";
  public static final String TAG = "RequestServer";
  private static volatile RequestServer sInstance;
  private boolean useHttpDirectly;
  
  public RequestServer()
  {
    if ((QUAUtil.isAlienApp()) || (QUAUtil.isDemoApp())) {}
    for (boolean bool = true;; bool = false)
    {
      this.useHttpDirectly = bool;
      return;
    }
  }
  
  private byte[] encodeRequest(ProtoBufRequest paramProtoBufRequest)
  {
    try
    {
      paramProtoBufRequest = paramProtoBufRequest.encode();
      return paramProtoBufRequest;
    }
    catch (Exception paramProtoBufRequest)
    {
      QMLog.e("RequestServer", "handleRequest Exception", paramProtoBufRequest);
    }
    return null;
  }
  
  public static RequestServer getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new RequestServer();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void handleRequest(ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult)
  {
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = paramProtoBufRequest.encode();
      QMLog.w("RequestServer", "sendData " + paramProtoBufRequest);
      if (this.useHttpDirectly)
      {
        HttpServer.sendData(arrayOfByte, new RequestServer.1(this, paramProtoBufRequest, paramAsyncResult));
        return;
      }
    }
    catch (Exception paramProtoBufRequest)
    {
      do
      {
        QMLog.e("RequestServer", "handleRequest Exception", paramProtoBufRequest);
      } while (paramAsyncResult == null);
      paramProtoBufRequest = new JSONObject();
    }
    try
    {
      paramProtoBufRequest.put("retCode", -1);
      paramProtoBufRequest.put("errMsg", "数据编码错误");
      label89:
      paramAsyncResult.onReceiveResult(false, paramProtoBufRequest);
      return;
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).sendRequestByMsf(arrayOfByte, paramProtoBufRequest.getCmdString(), new RequestServer.2(this, paramProtoBufRequest, paramAsyncResult));
      return;
    }
    catch (Throwable localThrowable)
    {
      break label89;
    }
  }
  
  private void wrapResult(Boolean paramBoolean, int paramInt, String paramString, AsyncResult paramAsyncResult)
  {
    JSONObject localJSONObject;
    if (paramAsyncResult != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("retCode", paramInt);
      localJSONObject.put("errMsg", paramString);
      label32:
      paramAsyncResult.onReceiveResult(paramBoolean.booleanValue(), localJSONObject);
      return;
    }
    catch (Throwable paramString)
    {
      break label32;
    }
  }
  
  public void dataReport(byte[] paramArrayOfByte, AsyncResult paramAsyncResult)
  {
    handleRequest(new DataReportRequest(paramArrayOfByte), paramAsyncResult);
  }
  
  public void insertBookShelf(String paramString1, String paramString2, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new BookShelfInsertRequest(paramString1, paramString2, paramArrayList), paramAsyncResult);
  }
  
  public void queryBookShelf(String paramString, ArrayList<String> paramArrayList, AsyncResult paramAsyncResult)
  {
    handleRequest(new BookShelfQueryRequest(paramString, paramArrayList), paramAsyncResult);
  }
  
  public void updateBookshelfReadtime(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    handleRequest(new BookShelfUpdateRequest(paramString1, paramString2, paramString3), paramAsyncResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.RequestServer
 * JD-Core Version:    0.7.0.1
 */