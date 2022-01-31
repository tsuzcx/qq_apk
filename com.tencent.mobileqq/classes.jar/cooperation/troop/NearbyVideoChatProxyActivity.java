package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import anfd;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Constructor;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyVideoChatProxyActivity
  extends TroopBaseProxyActivity
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyVideoAppInterface", 2, "createAppInterface");
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "nearby_video_chat_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label92;
      }
      QLog.d("NearbyVideoAppInterface", 2, "createAppInterface exp:", paramBaseApplicationImpl);
      label92:
      if (!QLog.isColorLevel()) {
        break label106;
      }
      QLog.d("NearbyVideoAppInterface", 2, "createAppInterface return null");
      label106:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyVideoAppInterface", 2, "createNearbyVideoAppInterface load class fail, return null");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  protected static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, AppInterface paramAppInterface, String paramString2, oidb_0x8dd.SelfInfo paramSelfInfo, int paramInt)
  {
    PtvFilterSoLoad.a(VideoEnvironment.a(), false);
    Object localObject = SosoInterface.b();
    long l2 = 0L;
    long l1 = 0L;
    if (localObject != null)
    {
      l2 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.b * 1000000.0D).longValue();
      l1 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.a * 1000000.0D).longValue();
    }
    localObject = new IPluginManager.PluginParams(1);
    ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "nearby_video_chat_plugin.apk";
    ((IPluginManager.PluginParams)localObject).d = "附近的人随机视频聊";
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
    ((IPluginManager.PluginParams)localObject).e = paramString1;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = NearbyVideoChatProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramString1;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = paramDialog;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("sessionType", 2);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("uinType", 10003);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("MultiAVType", 0);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("lon", l2);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("lat", l1);
    if (!TextUtils.isEmpty(paramString2)) {
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("nearbyVideoConfig", paramString2);
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramIntent = (QQAppInterface)paramAppInterface;
      if ((paramIntent.c()) && (paramIntent.a().j()))
      {
        QLog.e("NearbyVideoChatProxyActivity", 2, "Fromwhere is SmallScreen");
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("Fromwhere", "SmallScreen");
      }
    }
    paramIntent = ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent;
    boolean bool;
    int i;
    int j;
    int k;
    if (paramSelfInfo != null)
    {
      bool = true;
      paramIntent.putExtra("hasSelfInfo", bool);
      if (paramSelfInfo == null) {
        break label561;
      }
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("selfInfoLevel", paramSelfInfo.uint32_charm_level.get());
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("selfInfoAge", paramSelfInfo.uint32_age.get());
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("selfInfoGender", paramSelfInfo.uint32_gender.get() + 1);
      i = paramSelfInfo.uint32_charm_level.get();
      j = paramSelfInfo.uint32_gender.get();
      k = paramSelfInfo.uint32_age.get();
      j += 1;
    }
    for (;;)
    {
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
      ((IPluginManager.PluginParams)localObject).c = 10000;
      ((IPluginManager.PluginParams)localObject).f = null;
      paramIntent = null;
      if (paramInt == 123987) {
        paramIntent = new anfd(paramActivity);
      }
      IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject, paramIntent);
      ReportController.b(null, "dc00899", "grp_lbs", "", "video_chat", "num_entry", 0, 0, i + "", j + "", k + "", "");
      return;
      bool = false;
      break;
      label561:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, String paramString, oidb_0x8dd.SelfInfo paramSelfInfo, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.nearbyvideochat.ui.AVActivity", paramAppInterface, paramString, paramSelfInfo, paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    if ((paramAppRuntime == null) || (paramServiceConnection == null)) {
      return;
    }
    try
    {
      paramAppRuntime.getApplication().unbindService(paramServiceConnection);
      return;
    }
    catch (IllegalArgumentException paramAppRuntime)
    {
      QLog.d("NearbyVideoChatProxyActivity", 2, "unbindService error" + paramAppRuntime.getMessage());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Class paramClass, ServiceConnection paramServiceConnection, String paramString)
  {
    if ((paramAppRuntime == null) || (paramServiceConnection == null)) {
      return;
    }
    paramClass = new Intent(paramAppRuntime.getApplication(), paramClass);
    paramClass.putExtra("useSkinEngine", 1);
    paramClass.putExtra("userQqResources", 2);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    localPluginParams.jdField_b_of_type_JavaLangString = "nearby_video_chat_plugin.apk";
    localPluginParams.d = "附近的人随机视频聊";
    localPluginParams.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localPluginParams.e = paramString;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = paramClass;
    localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    IPluginManager.b(paramAppRuntime.getApplication(), localPluginParams);
  }
  
  public String getPluginID()
  {
    return "nearby_video_chat_plugin.apk";
  }
  
  public Class getProxyActivity(String paramString)
  {
    return NearbyVideoChatProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.NearbyVideoChatProxyActivity
 * JD-Core Version:    0.7.0.1
 */