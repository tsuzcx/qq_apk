package cooperation.jtcode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardHelper;
import cooperation.plugin.IPluginManager;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class JtcodeIpcServiceManager
{
  private static JtcodeIpcServiceManager jdField_a_of_type_CooperationJtcodeJtcodeIpcServiceManager;
  private ResultReceiver jdField_a_of_type_AndroidOsResultReceiver = new JtcodeIpcServiceManager.1(this, new Handler(Looper.getMainLooper()));
  
  public static JtcodeIpcServiceManager a()
  {
    try
    {
      if (jdField_a_of_type_CooperationJtcodeJtcodeIpcServiceManager == null) {
        jdField_a_of_type_CooperationJtcodeJtcodeIpcServiceManager = new JtcodeIpcServiceManager();
      }
      JtcodeIpcServiceManager localJtcodeIpcServiceManager = jdField_a_of_type_CooperationJtcodeJtcodeIpcServiceManager;
      return localJtcodeIpcServiceManager;
    }
    finally {}
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("JtcodeIpcServiceManager", 2, "handleReceiveResult,resultCode:" + paramInt + ",resultData:" + paramBundle);
      }
      switch (paramInt)
      {
      case 1: 
      default: 
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JtcodeIpcServiceManager", 2, "wlx plugin install failed");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("JtcodeIpcServiceManager", 2, "STATE_INSTALLED.startService");
    }
    if (paramBundle.containsKey("nfcIntent")) {}
    for (paramBundle = (Intent)paramBundle.get("nfcIntent");; paramBundle = new Intent())
    {
      paramBundle.putExtra("result", this.jdField_a_of_type_AndroidOsResultReceiver);
      BuscardHelper.a(BaseApplicationImpl.getApplication().getRuntime(), paramBundle, null, true);
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (IPluginManager)((AppRuntime)localObject1).getManager(26);
    if ((localObject2 != null) && (((IPluginManager)localObject2).isReady()) && (((IPluginManager)localObject2).isPlugininstalled("wlx_jtcode.apk")))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("result", this.jdField_a_of_type_AndroidOsResultReceiver);
      ((Intent)localObject2).putExtra("params", paramJSONObject.toString());
      ((Intent)localObject2).putExtra("guid", HexUtil.a(NetConnInfoCenter.GUID));
      BuscardHelper.a((AppRuntime)localObject1, (Intent)localObject2, null, true);
      return;
    }
    localObject1 = new Intent("com.tencent.mobileqq.action.wlx.service");
    ((Intent)localObject1).setClass(BaseApplication.getContext(), JumpActivity.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("result", this.jdField_a_of_type_AndroidOsResultReceiver);
    ((Intent)localObject1).putExtra("params", paramJSONObject.toString());
    ((Intent)localObject1).putExtra("guid", HexUtil.a(NetConnInfoCenter.GUID));
    BaseApplication.getContext().startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.jtcode.JtcodeIpcServiceManager
 * JD-Core Version:    0.7.0.1
 */