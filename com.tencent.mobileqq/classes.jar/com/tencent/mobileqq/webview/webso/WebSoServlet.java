package com.tencent.mobileqq.webview.webso;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import wns_proxy.HttpReq;

public class WebSoServlet
  extends MSFServlet
{
  private long jdField_a_of_type_Long = 0L;
  private ToServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg;
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2)
  {
    return a(paramIntent, paramLong, paramString1, paramHttpReq, paramString2, 60000, 100, WebSoService.class);
  }
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2, int paramInt1, int paramInt2, Class<? extends BusinessObserver> paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("hostUin", paramLong);
    localIntent.putExtra("key_req", paramHttpReq);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("key_time_out", paramInt1);
    localIntent.putExtra("key_request_code", paramInt2);
    localIntent.putExtra("key_receive_class", paramClass);
    return localIntent;
  }
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2, int paramInt1, int paramInt2, String paramString3, Class<? extends BusinessObserver> paramClass)
  {
    paramIntent = a(paramIntent, paramLong, paramString1, paramHttpReq, paramString2, paramInt1, paramInt2, paramClass);
    paramIntent.putExtra("key_uni_key", paramString3);
    return paramIntent;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Bundle paramBundle, String paramString)
  {
    if (paramFromServiceMsg != null)
    {
      paramString = paramFromServiceMsg.getAttribute("_tag_socket");
      paramFromServiceMsg = new String[2];
      if (paramString != null)
      {
        paramString = paramString.toString().split(":");
        paramFromServiceMsg = paramString;
        if (paramString != null)
        {
          paramFromServiceMsg = paramString;
          if (paramString.length > 1)
          {
            paramBundle.putString("key_server_ip", paramString[0]);
            paramBundle.putString("key_server_port", paramString[1]);
            paramFromServiceMsg = paramString;
          }
        }
      }
      paramBundle.putString("key_user_ip", "");
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.length > 0)) {
        paramBundle.putString("key_dns_result", paramFromServiceMsg[0]);
      }
      paramBundle.putInt("key_time_cost", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
  
  private static boolean a()
  {
    return 1 == QzoneConfig.getInstance().getConfig("QZoneSetting", "enableWnsCgiOptimization", 1);
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    if ((paramClass == WebSoCgiService.class) && (a()))
    {
      paramIntent = new WebSoServlet.ReceiveRunnable(paramInt, paramBoolean, paramBundle);
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").getHandler().post(paramIntent);
      return;
    }
    super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null)
    {
      QLog.e("WebSoServlet", 2, "onReceive, request is null");
      return;
    }
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("url");
    localBundle.putString("url", str);
    if (paramFromServiceMsg != null)
    {
      localBundle.putInt("rsp_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("rsp_message", paramFromServiceMsg.getBusinessFailMsg());
    }
    int j = paramIntent.getIntExtra("key_request_code", 100);
    Class localClass = (Class)paramIntent.getSerializableExtra("key_receive_class");
    if (localClass == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive url: ");
    localStringBuilder.append(str);
    localStringBuilder.append(", code: ");
    int i;
    if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    } else {
      i = -1;
    }
    localStringBuilder.append(i);
    QLog.d("WebSoServlet", 2, localStringBuilder.toString());
    localBundle.putString("key_uni_key", paramIntent.getStringExtra("key_uni_key"));
    a(paramFromServiceMsg, localBundle, str);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = paramFromServiceMsg.getWupBuffer();
      paramFromServiceMsg = WebSoUtils.h(WebSoUtils.e(str));
      if (TextUtils.isEmpty(paramFromServiceMsg))
      {
        QLog.w("WebSoServlet", 1, "uniKey is EMPTY OR NULL !!!");
        return;
      }
      localBundle.putInt("rsp_code", 0);
      paramIntent = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).websoOnResponse(paramIntent, paramFromServiceMsg);
      if (paramIntent != null)
      {
        localBundle.putSerializable("rsp_data", paramIntent);
        notifyObserver(null, j, true, localBundle, localClass);
        return;
      }
      QLog.d("WebSoServlet", 2, "inform WebSoServlet isSuccess false");
      notifyObserver(null, j, false, localBundle, localClass);
      return;
    }
    QLog.d("WebSoServlet", 2, "inform WebSoServlet resultcode fail.");
    notifyObserver(null, j, false, localBundle, localClass);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("hostUin", 0L);
    Object localObject = (HttpReq)paramIntent.getSerializableExtra("key_req");
    String str2 = paramIntent.getStringExtra("refer");
    String str1 = paramIntent.getStringExtra("url");
    int i = paramIntent.getIntExtra("key_time_out", 60000);
    localObject = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).websoEncode(WebSoUtils.e(str1), l, (HttpReq)localObject, str2);
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    if (i <= 0) {
      l = 60000L;
    } else {
      l = i;
    }
    paramPacket.setTimeout(l);
    paramPacket.setSSOCommand(WebSoUtils.f(str1));
    paramPacket.putSendData(paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("send req url: ");
      paramIntent.append(str1);
      QLog.d("WebSoServlet", 2, paramIntent.toString());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoServlet
 * JD-Core Version:    0.7.0.1
 */