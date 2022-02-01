package dov.com.qq.im.ae.qipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class AECameraGetInfoClient
  extends QIPCModule
{
  private static boolean a = false;
  
  public AECameraGetInfoClient(String paramString)
  {
    super(paramString);
  }
  
  public static AECameraGetInfoClient a()
  {
    return AECameraGetInfoClient.Holder.a;
  }
  
  public static void a()
  {
    if (!a)
    {
      QIPCClientHelper.getInstance().getClient().registerModule(a());
      a = true;
    }
  }
  
  public static void b()
  {
    if (a)
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
      a = false;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_get_send_to_info".equals(paramString)) {
      AEBaseDataReporter.a().a(Long.valueOf(paramBundle.getLong("key_receiver_type")));
    }
    for (;;)
    {
      return null;
      if ("action_get_cancle_send_info".equals(paramString)) {
        AEBaseDataReporter.a().Y();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.qipc.AECameraGetInfoClient
 * JD-Core Version:    0.7.0.1
 */