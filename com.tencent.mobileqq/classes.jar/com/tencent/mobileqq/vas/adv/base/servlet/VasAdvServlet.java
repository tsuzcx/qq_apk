package com.tencent.mobileqq.vas.adv.base.servlet;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvCallback;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/servlet/VasAdvServlet;", "Lmqq/app/MSFServlet;", "()V", "onReceive", "", "intent", "Landroid/content/Intent;", "fromServiceMsg", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSend", "packet", "Lmqq/app/Packet;", "Companion", "SSOCallback", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvServlet
  extends MSFServlet
{
  public static final VasAdvServlet.Companion a = new VasAdvServlet.Companion(null);
  private static final Map<String, VasAdvCallback> b = (Map)new LinkedHashMap();
  
  public void onReceive(@Nullable Intent paramIntent, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null))
    {
      String str = paramIntent.getStringExtra("cmd");
      paramIntent = paramIntent.getStringExtra("req_uuid");
      if ((!TextUtils.isEmpty((CharSequence)str)) && (!TextUtils.isEmpty((CharSequence)paramIntent)))
      {
        Object localObject = (VasAdvCallback)b.remove(paramIntent);
        if (!paramFromServiceMsg.isSuccess())
        {
          if (localObject != null) {
            ((VasAdvCallback)localObject).a("from service msg failed", null);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("request failed, cmd:");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", uuid:");
          ((StringBuilder)localObject).append(paramIntent);
          ((StringBuilder)localObject).append(", serviceMsg:");
          ((StringBuilder)localObject).append(paramFromServiceMsg.getShortStringForLog());
          QLog.d("VasAdvServlet", 1, ((StringBuilder)localObject).toString());
          return;
        }
        try
        {
          int i = paramFromServiceMsg.getWupBuffer().length - 4;
          paramIntent = new byte[i];
          PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
          if (localObject != null)
          {
            ((VasAdvCallback)localObject).a(paramIntent);
            return;
          }
        }
        catch (Exception paramIntent)
        {
          if (localObject != null) {
            ((VasAdvCallback)localObject).a("error when parse response", (Throwable)paramIntent);
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("onReceive error: ");
          paramFromServiceMsg.append(paramIntent);
          QLog.e("VasAdvServlet", 1, paramFromServiceMsg.toString());
        }
        return;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("invalid cmd ");
      paramFromServiceMsg.append(str);
      paramFromServiceMsg.append(" or uuid ");
      paramFromServiceMsg.append(paramIntent);
      paramFromServiceMsg.append(", discard rsp");
      QLog.d("VasAdvServlet", 1, paramFromServiceMsg.toString());
      return;
    }
    QLog.d("VasAdvServlet", 1, "onReceive intent or fromServiceMsg is null");
  }
  
  public void onSend(@Nullable Intent paramIntent, @Nullable Packet paramPacket)
  {
    byte[] arrayOfByte = null;
    String str;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("cmd");
    } else {
      str = null;
    }
    if (paramIntent != null) {
      arrayOfByte = paramIntent.getByteArrayExtra("data");
    }
    long l = 10000L;
    if (paramIntent != null) {
      l = paramIntent.getLongExtra("timeout", 10000L);
    }
    if (paramPacket != null)
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      paramPacket.putSendData(arrayOfByte);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onSend cmd: ");
        paramIntent.append(str);
        QLog.d("VasAdvServlet", 0, paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.servlet.VasAdvServlet
 * JD-Core Version:    0.7.0.1
 */