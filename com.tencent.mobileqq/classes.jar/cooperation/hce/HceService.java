package cooperation.hce;

import aitd;
import aiwh;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.RequiresApi;
import bilr;
import bilu;
import bilv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@RequiresApi(api=19)
public class HceService
  extends HostApduService
  implements bilv
{
  private int jdField_a_of_type_Int;
  private PowerManager jdField_a_of_type_AndroidOsPowerManager;
  
  private boolean a()
  {
    if (Build.VERSION.SDK_INT < 20) {
      return this.jdField_a_of_type_AndroidOsPowerManager.isScreenOn();
    }
    return this.jdField_a_of_type_AndroidOsPowerManager.isInteractive();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if ((localRunningAppProcessInfo != null) && (paramString.equals(localRunningAppProcessInfo.processName))) {
            return true;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("IpcModule", 2, "check process -- HceProcess is  dead");
    }
    return false;
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool1 = bool2;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (aitd)((AppRuntime)localObject).getManager(245);
      bool1 = bool2;
      if (localObject != null) {
        if (((aitd)localObject).a("vfcBusCard", 1, new String[] { "switch" }) != 1) {
          break label90;
        }
      }
    }
    label90:
    for (bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IpcModule", 2, "vfcSwitch:" + bool1);
      }
      return bool1;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("IpcModule", 2, "sendCAPDU capdu: " + bilr.a(paramBundle.getByteArray("capdu")) + " vfcFlag: " + bilu.a());
      }
      paramBundle.putString("vfcAccountFlag", bilu.a());
      aiwh.a().a();
      paramBundle = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:hce", 1, "ApduIpcModule", "sendCapdu", paramBundle);
      this.jdField_a_of_type_Int += 1;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.data;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getByteArray("radpdu");
          if (QLog.isColorLevel()) {
            QLog.d("apdu", 2, "收到插件的rapdu: " + bilr.a(paramBundle));
          }
          sendResponseApdu(paramBundle);
        }
      }
      return;
    }
    catch (Throwable paramBundle) {}
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!BaseApplicationImpl.sApplication.isRuntimeReady())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsPowerManager = ((PowerManager)getSystemService("power"));
  }
  
  public void onDeactivated(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apdu", 2, "onDeactivated reson: " + paramInt + " 交互次数: " + this.jdField_a_of_type_Int);
    }
  }
  
  public byte[] processCommandApdu(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("IpcModule", 2, "commandApdu=" + BaseApplicationImpl.sApplication.isRuntimeReady() + ",sInjectResult=" + BaseApplicationImpl.sInjectResult);
        }
        if ((!"Success".equals(BaseApplicationImpl.sInjectResult)) || (!BaseApplicationImpl.sApplication.isRuntimeReady())) {
          return bilr.b;
        }
        localObject = bilu.a();
        if (this.jdField_a_of_type_AndroidOsPowerManager == null) {
          this.jdField_a_of_type_AndroidOsPowerManager = ((PowerManager)getSystemService("power"));
        }
        if ((!b()) || (localObject == null) || (!((bilu)localObject).a()) || (!a()))
        {
          if (QLog.isColorLevel()) {
            QLog.w("IpcModule", 2, "processCommandApdu isRuntimeReady=" + BaseApplicationImpl.sApplication.isRuntimeReady() + ",sInjectResult=" + BaseApplicationImpl.sInjectResult);
          }
          return bilr.b;
        }
        if ((!a(this, "com.tencent.mobileqq:hce")) || ((!((bilu)localObject).a(this)) && (((bilu)localObject).a(paramArrayOfByte))))
        {
          ((bilu)localObject).a = paramArrayOfByte;
          switch (((bilu)localObject).a(paramArrayOfByte))
          {
          }
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        Object localObject;
        paramArrayOfByte.printStackTrace();
        break label340;
        continue;
      }
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putByteArray("capdu", paramArrayOfByte);
      a((Bundle)localObject);
      break label340;
      if (QLog.isColorLevel()) {
        QLog.w("IpcModule", 2, "from last startTime：" + (System.currentTimeMillis() - ((bilu)localObject).a()));
      }
      if (System.currentTimeMillis() - ((bilu)localObject).a() > 5000L)
      {
        ((bilu)localObject).a();
        startActivity(new Intent(this, HcePluginInstallActivity.class));
      }
    }
    label340:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.hce.HceService
 * JD-Core Version:    0.7.0.1
 */