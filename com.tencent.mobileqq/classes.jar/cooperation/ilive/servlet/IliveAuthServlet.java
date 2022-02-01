package cooperation.ilive.servlet;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.pb.QQALive.GetOpenInfoRsp;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class IliveAuthServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      ((StringBuilder)localObject).append(",success=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      QLog.d("IliveAuthServlet", 2, ((StringBuilder)localObject).toString());
    }
    if (paramIntent != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      localObject = paramFromServiceMsg.getServiceCmd();
      if (localObject == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resp:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" is ");
        if (bool) {
          paramIntent = "";
        } else {
          paramIntent = "not";
        }
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" success");
        QLog.d("IliveAuthServlet", 2, localStringBuilder.toString());
      }
      paramIntent = null;
      if (paramFromServiceMsg.isSuccess())
      {
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        paramIntent = new byte[i];
        PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      }
      if (((String)localObject).equals("qqvalivelogin.GetOpenInfo"))
      {
        localObject = new QQALive.GetOpenInfoRsp();
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramIntent == null)) {}
      }
    }
    try
    {
      ((QQALive.GetOpenInfoRsp)localObject).mergeFrom(paramIntent);
      if ((!TextUtils.isEmpty(((QQALive.GetOpenInfoRsp)localObject).sOpenId.get())) && (!TextUtils.isEmpty(((QQALive.GetOpenInfoRsp)localObject).sAccessToken.get())))
      {
        IliveAuthManager.getInstance().onGetStCallback(true, ((QQALive.GetOpenInfoRsp)localObject).sOpenId.get(), ((QQALive.GetOpenInfoRsp)localObject).sAccessToken.get());
        return;
      }
      IliveAuthManager.getInstance().onGetStCallback(false, "", "");
      return;
    }
    catch (Exception paramIntent)
    {
      label306:
      break label306;
    }
    IliveAuthManager.getInstance().onGetStCallback(false, "", "");
    return;
    IliveAuthManager.getInstance().onGetStCallback(false, "", "");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 10000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend exit cmd=");
      paramIntent.append(str);
      QLog.d("IliveAuthServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.servlet.IliveAuthServlet
 * JD-Core Version:    0.7.0.1
 */