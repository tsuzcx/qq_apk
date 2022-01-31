import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost;
import java.util.ArrayList;
import java.util.Arrays;

public class puz
  implements Handler.Callback
{
  public puz(SmartDeviceProxyMgr paramSmartDeviceProxyMgr) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    boolean bool1 = false;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.a.b();
      return true;
      try
      {
        paramMessage = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        boolean bool2 = SmartDevicePluginLoader.a().a(paramMessage);
        boolean bool3 = NetworkUtil.h(BaseApplicationImpl.getContext());
        boolean bool4 = DeviceInfoUtil.e();
        if (FileUtils.a() <= 1.048576E+008F) {
          bool1 = true;
        }
        SmartDeviceProxyMgr.a(this.a, "SmartDeviceProxyMgr check plugin: isInstalled " + bool2 + " isWifiConnected " + bool3 + " lowPhone = " + bool4 + " lowMemory = " + bool1);
        if ((bool2) || (!bool3) || (bool4) || (bool1)) {
          continue;
        }
        SmartDevicePluginLoader.a().a();
        return true;
      }
      catch (Exception paramMessage)
      {
        return true;
      }
      try
      {
        if (SmartDeviceProxyMgr.a(this.a) != null)
        {
          paramMessage = new Bundle();
          paramMessage.putString("notify_cmd", "getServerDeviceList");
          paramMessage = SmartDeviceProxyMgr.a(this.a).a(paramMessage);
          if (paramMessage != null)
          {
            paramMessage = paramMessage.getParcelableArray("devicelist");
            if (paramMessage != null)
            {
              DeviceInfo[] arrayOfDeviceInfo = new DeviceInfo[paramMessage.length];
              while (i < paramMessage.length)
              {
                arrayOfDeviceInfo[i] = ((DeviceInfo)paramMessage[i]);
                i += 1;
              }
              SmartDeviceProxyMgr.a(this.a, arrayOfDeviceInfo);
              if (arrayOfDeviceInfo != null)
              {
                this.a.a(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramMessage) {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     puz
 * JD-Core Version:    0.7.0.1
 */