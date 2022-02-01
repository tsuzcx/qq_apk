package com.tencent.mobileqq.jsp;

import NS_MOBILE_EXTRA.mobile_get_urlinfo_rsp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.ProtocolUtils;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class WebShareServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceive, cmd=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("WebShareServlet", 2, ((StringBuilder)localObject2).toString());
    }
    if ("SQQzoneSvc.getUrlInfo".equals(localObject1))
    {
      localObject2 = paramFromServiceMsg.getWupBuffer();
      localObject1 = new Bundle();
      localObject2 = ProtocolUtils.decode((byte[])localObject2, "getUrlInfo");
      if ((paramFromServiceMsg.isSuccess()) && ((localObject2 instanceof mobile_get_urlinfo_rsp)))
      {
        localObject2 = (mobile_get_urlinfo_rsp)localObject2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onReceive, mobile_get_urlinfo_rsp, ret=");
          localStringBuilder.append(((mobile_get_urlinfo_rsp)localObject2).ret);
          localStringBuilder.append(", title=");
          localStringBuilder.append(((mobile_get_urlinfo_rsp)localObject2).title);
          localStringBuilder.append(", summary=");
          localStringBuilder.append(((mobile_get_urlinfo_rsp)localObject2).summary);
          localStringBuilder.append(", images=");
          localStringBuilder.append(((mobile_get_urlinfo_rsp)localObject2).images);
          QLog.d("WebShareServlet", 2, localStringBuilder.toString());
        }
        ((Bundle)localObject1).putInt("extra_ret", ((mobile_get_urlinfo_rsp)localObject2).ret);
        ((Bundle)localObject1).putString("extra_title", ((mobile_get_urlinfo_rsp)localObject2).title);
        ((Bundle)localObject1).putString("extra_summary", ((mobile_get_urlinfo_rsp)localObject2).summary);
        ((Bundle)localObject1).putStringArrayList("extra_images", ((mobile_get_urlinfo_rsp)localObject2).images);
      }
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = paramIntent.getStringExtra("extra_cmd");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend, cmd=");
      localStringBuilder.append((String)localObject);
      QLog.d("WebShareServlet", 2, localStringBuilder.toString());
    }
    if ("SQQzoneSvc.getUrlInfo".equals(localObject))
    {
      paramIntent = paramIntent.getStringExtra("extra_url");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSend, CMD_GET_URL_INFO, url=");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("WebShareServlet", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramIntent))
      {
        paramIntent = new QzoneGetUrlInfoRequest(paramIntent).encode();
        paramPacket.setSSOCommand("SQQzoneSvc.getUrlInfo");
        paramPacket.putSendData(paramIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("WebShareServlet", 2, "onSend, url is null!!!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebShareServlet
 * JD-Core Version:    0.7.0.1
 */