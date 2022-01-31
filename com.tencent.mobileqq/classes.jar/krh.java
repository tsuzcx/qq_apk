import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

public class krh
  extends MSFServlet
{
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    bakz.a(arrayOfByte, 0, paramArrayOfByte.length + 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "QqAd.getAd" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtSSOLoadAD", 2, paramFromServiceMsg.isSuccess() + " onReceive with code: " + paramFromServiceMsg.getResultCode());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      Object localObject = new qq_ad_get.QQAdGetRsp();
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        ((qq_ad_get.QQAdGetRsp)localObject).mergeFrom(arrayOfByte);
        paramFromServiceMsg = ynv.a((PBField)localObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg != JSONObject.NULL))
        {
          paramFromServiceMsg = paramFromServiceMsg.toString();
          localObject = new Bundle();
          ((Bundle)localObject).putString("sso_GdtLoadAd_rsp_json", paramFromServiceMsg);
          notifyObserver(paramIntent, 1, true, (Bundle)localObject, kri.class);
          return;
        }
        notifyObserver(paramIntent, 1, false, null, kri.class);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GdtSSOLoadAD", 2, paramFromServiceMsg.getMessage());
        }
        notifyObserver(paramIntent, 1, false, null, kri.class);
        return;
      }
    }
    notifyObserver(paramIntent, 1, false, null, kri.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("GdtLoadAdServletCMD");
    paramPacket.setSSOCommand(str);
    if (QLog.isColorLevel()) {
      QLog.d("GdtSSOLoadAD", 2, "onSend with cmd: " + str);
    }
    paramIntent = paramIntent.getByteArrayExtra("sso_GdtLoadAd_rquest_bytes");
    if (paramIntent != null)
    {
      paramPacket.putSendData(a(paramIntent));
      return;
    }
    QLog.e("GdtSSOLoadAD", 1, "no bytes to send" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     krh
 * JD-Core Version:    0.7.0.1
 */