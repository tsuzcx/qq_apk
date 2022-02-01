package com.tencent.mobileqq.dpc;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.dpc.api.impl.DPCAccountServiceImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class DeviceProfileManager$2
  implements Runnable
{
  DeviceProfileManager$2(DeviceProfileManager paramDeviceProfileManager, ConfigurationService.RespGetConfig paramRespGetConfig, String paramString) {}
  
  public void run()
  {
    ConfigurationService.Config localConfig = (ConfigurationService.Config)this.val$respGetConfig.config_list.get(0);
    Object localObject1 = localConfig.content_list;
    QLog.i("DeviceProfileManager", 1, "onDPCResponse is called, version=" + localConfig.version.get());
    if (localObject1 != null) {}
    boolean bool1;
    int i;
    SharedPreferences.Editor localEditor2;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor3;
    HashMap localHashMap;
    label268:
    Object localObject8;
    DeviceProfileManager.DPCXmlHandler.DPCXMLParseInfo localDPCXMLParseInfo;
    Object localObject7;
    SharedPreferences.Editor localEditor1;
    Object localObject6;
    label471:
    boolean bool2;
    for (;;)
    {
      try
      {
        if (((PBRepeatField)localObject1).size() != 0)
        {
          bool1 = TextUtils.isEmpty(this.val$uin);
          if (!bool1) {}
        }
        else
        {
          return;
        }
        ??? = new HashMap();
        i = 0;
        if (i < ((PBRepeatField)localObject1).size())
        {
          if (this.this$0.parseDPCXML((String)((PBRepeatField)localObject1).get(i), (HashMap)???)) {
            break label849;
          }
          QLog.e("DeviceProfileManager", 1, "onDPCResponse parseDPCXML error, so return");
          break label849;
        }
        Iterator localIterator = ((HashMap)???).entrySet().iterator();
        localEditor2 = ReflectedMethods.a(MobileQQ.sMobileQQ.getApplicationContext(), "dpcConfig").edit();
        localSharedPreferences = ReflectedMethods.a(MobileQQ.sMobileQQ.getApplicationContext(), "dpcConfig_account");
        localEditor3 = localSharedPreferences.edit();
        localObject1 = null;
        localObject7 = DeviceProfileManager.sAccountDpcService.mFeatureDefaultAccountMap;
      }
      catch (Exception localException) {}finally
      {
        QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + false);
        DeviceProfileManager.access$400(this.this$0, false);
      }
      bool1 = true;
      ??? = DeviceProfileManager.sAccountDpcService.buildAccountDpcName((String)localObject8);
      localEditor1 = localEditor3;
      localObject6 = localObject3;
      DeviceProfileManager.access$100(this.this$0, QLog.isColorLevel(), 1, new Object[] { localObject8, localDPCXMLParseInfo.toString(), Boolean.valueOf(bool1) });
      if (localObject6 != null)
      {
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject6).get(???);
        bool1 = false;
        localObject8 = localDPCConfigInfo;
        if (localDPCConfigInfo == null)
        {
          bool1 = true;
          localObject7 = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject7).get(???);
          if ((localObject7 != null) && (((DeviceProfileManager.DPCConfigInfo)localObject7).clone() != null)) {
            localObject8 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject7).clone();
          }
        }
        else
        {
          DeviceProfileManager.access$100(this.this$0, QLog.isColorLevel(), 3, new Object[] { ???, localObject8, Boolean.valueOf(bool1) });
          bool2 = DeviceProfileManager.buildDPCConfigValue((DeviceProfileManager.DPCConfigInfo)localObject8, localDPCXMLParseInfo.value.toString().trim());
          if (!bool1) {
            break label856;
          }
          ((HashMap)localObject6).put(???, localObject8);
          break label856;
        }
      }
    }
    for (;;)
    {
      label637:
      localEditor1.putString((String)???, localDPCXMLParseInfo.value);
      label849:
      label856:
      do
      {
        DeviceProfileManager.access$100(this.this$0, QLog.isColorLevel(), 4, new Object[] { ???, localObject8, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        break label268;
        localObject7 = DeviceProfileManager.access$200(this.this$0);
        bool1 = false;
        localObject6 = localHashMap;
        localEditor1 = localEditor2;
        ??? = localObject8;
        break label471;
        synchronized (this.this$0)
        {
          DeviceProfileManager.access$002(this.this$0, localHashMap);
          if ((DeviceProfileManager.sAccountDpcService != null) && (DeviceProfileManager.sAccountDpcService.mApp != null) && (this.val$uin != null) && (this.val$uin.equals(DeviceProfileManager.sAccountDpcService.mApp.getAccount()))) {
            DeviceProfileManager.sAccountDpcService.mFeatureAccountMapLV2 = localObject3;
          }
          bool1 = DeviceProfileManager.access$300(this.this$0, localConfig, localEditor2, localSharedPreferences, localEditor3);
          QLog.i("DeviceProfileManager", 1, "onDPCResponse finally， hasChanged=" + bool1);
          DeviceProfileManager.access$400(this.this$0, bool1);
          return;
        }
        i += 1;
        break;
        if (bool1) {
          break label637;
        }
      } while (!bool2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.DeviceProfileManager.2
 * JD-Core Version:    0.7.0.1
 */