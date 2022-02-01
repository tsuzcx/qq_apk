package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.request.BookShelfInsertRequest;
import com.tencent.qqmini.sdk.request.BookShelfQueryRequest;
import com.tencent.qqmini.sdk.request.BookShelfUpdateRequest;
import com.tencent.qqmini.sdk.request.DataReportRequest;
import com.tencent.qqmini.sdk.request.GetReactiveFriendListRequest;
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
    boolean bool;
    if ((!QUAUtil.isAlienApp()) && (!QUAUtil.isDemoApp())) {
      bool = false;
    } else {
      bool = true;
    }
    this.useHttpDirectly = bool;
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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new RequestServer();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void handleRequest(ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult)
  {
    try
    {
      byte[] arrayOfByte = paramProtoBufRequest.encode();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendData ");
      localStringBuilder.append(paramProtoBufRequest);
      QMLog.w("RequestServer", localStringBuilder.toString());
      if (this.useHttpDirectly)
      {
        sendDataByHttpServer(paramProtoBufRequest, paramAsyncResult, arrayOfByte);
        return;
      }
      sendRequestByMsf(paramProtoBufRequest, paramAsyncResult, arrayOfByte);
      return;
    }
    catch (Exception paramProtoBufRequest)
    {
      QMLog.e("RequestServer", "handleRequest Exception", paramProtoBufRequest);
      if (paramAsyncResult == null) {
        break label108;
      }
    }
    paramProtoBufRequest = new JSONObject();
    try
    {
      paramProtoBufRequest.put("retCode", -1);
      paramProtoBufRequest.put("errMsg", "数据编码错误");
      label100:
      paramAsyncResult.onReceiveResult(false, paramProtoBufRequest);
      label108:
      return;
    }
    catch (Throwable localThrowable)
    {
      break label100;
    }
  }
  
  private void sendDataByHttpServer(ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult, byte[] paramArrayOfByte)
  {
    HttpServer.sendData(paramArrayOfByte, new RequestServer.2(this, paramProtoBufRequest, paramAsyncResult));
  }
  
  private void sendRequestByMsf(ProtoBufRequest paramProtoBufRequest, AsyncResult paramAsyncResult, byte[] paramArrayOfByte)
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).sendRequestByMsf(paramArrayOfByte, paramProtoBufRequest.getCmdString(), new RequestServer.1(this, paramProtoBufRequest, paramAsyncResult));
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
  
  public void getReactiveFriendList(String paramString, AsyncResult paramAsyncResult)
  {
    handleRequest(new GetReactiveFriendListRequest(paramString), paramAsyncResult);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.RequestServer
 * JD-Core Version:    0.7.0.1
 */