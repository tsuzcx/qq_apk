package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginInfo;
import java.lang.reflect.Constructor;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyVideoChatProxyActivity
  extends TroopBaseProxyActivity
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (paramBaseApplicationImpl != null)
    {
      if (paramString == null) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyVideoAppInterface", 2, "createAppInterface");
      }
    }
    try
    {
      try
      {
        paramString = Class.forName("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
        paramBaseApplicationImpl = paramString;
      }
      catch (Exception paramBaseApplicationImpl)
      {
        break label112;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      label39:
      break label39;
    }
    paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "nearby_video_chat_plugin.apk");
    paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
    BasicClassTypeUtil.setClassLoader(true, paramString);
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyVideoAppInterface", 2, "createNearbyVideoAppInterface load class fail, return null");
        return null;
      }
    }
    else
    {
      paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppInterface)))
      {
        paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
        label112:
        if (QLog.isColorLevel()) {
          QLog.d("NearbyVideoAppInterface", 2, "createAppInterface exp:", paramBaseApplicationImpl);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyVideoAppInterface", 2, "createAppInterface return null");
      }
      return null;
    }
    return null;
  }
  
  protected static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, AppInterface paramAppInterface, String paramString2, oidb_0x8dd.SelfInfo paramSelfInfo, int paramInt)
  {
    ((IAEResUtil)QRoute.api(IAEResUtil.class)).loadAEBaseSo();
    Object localObject = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    long l1 = 0L;
    long l2;
    if (localObject != null)
    {
      l1 = Double.valueOf(((SosoLbsInfo)localObject).mLocation.mLon02 * 1000000.0D).longValue();
      l2 = Double.valueOf(((SosoLbsInfo)localObject).mLocation.mLat02 * 1000000.0D).longValue();
    }
    else
    {
      l2 = 0L;
    }
    localObject = new IPluginManager.PluginParams(1);
    ((IPluginManager.PluginParams)localObject).b = "nearby_video_chat_plugin.apk";
    ((IPluginManager.PluginParams)localObject).e = PluginInfo.l;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
    ((IPluginManager.PluginParams)localObject).f = paramString1;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = NearbyVideoChatProxyActivity.class;
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = paramDialog;
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("sessionType", 2);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("uinType", 10003);
    paramIntent = ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent;
    int k = 0;
    paramIntent.putExtra("MultiAVType", 0);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("lon", l1);
    ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("lat", l2);
    if (!TextUtils.isEmpty(paramString2)) {
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("nearbyVideoConfig", paramString2);
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramIntent = (QQAppInterface)paramAppInterface;
      if ((paramIntent.isVideoChatting()) && (paramIntent.getAVNotifyCenter().k()))
      {
        QLog.e("NearbyVideoChatProxyActivity", 2, "Fromwhere is SmallScreen");
        ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("Fromwhere", "SmallScreen");
      }
    }
    paramIntent = ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent;
    boolean bool;
    if (paramSelfInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramIntent.putExtra("hasSelfInfo", bool);
    int j;
    int i;
    if (paramSelfInfo != null)
    {
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("selfInfoLevel", paramSelfInfo.uint32_charm_level.get());
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("selfInfoAge", paramSelfInfo.uint32_age.get());
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent.putExtra("selfInfoGender", paramSelfInfo.uint32_gender.get() + 1);
      j = paramSelfInfo.uint32_charm_level.get();
      i = paramSelfInfo.uint32_gender.get() + 1;
      k = paramSelfInfo.uint32_age.get();
    }
    else
    {
      i = 0;
      j = 0;
    }
    ((IPluginManager.PluginParams)localObject).c = paramInt;
    ((IPluginManager.PluginParams)localObject).d = 10000;
    paramIntent = null;
    ((IPluginManager.PluginParams)localObject).g = null;
    if (paramInt == 123987) {
      paramIntent = new NearbyVideoChatProxyActivity.1(paramActivity);
    }
    IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject, paramIntent);
    paramActivity = new StringBuilder();
    paramActivity.append(j);
    paramActivity.append("");
    paramActivity = paramActivity.toString();
    paramIntent = new StringBuilder();
    paramIntent.append(i);
    paramIntent.append("");
    paramIntent = paramIntent.toString();
    paramDialog = new StringBuilder();
    paramDialog.append(k);
    paramDialog.append("");
    ReportController.b(null, "dc00899", "grp_lbs", "", "video_chat", "num_entry", 0, 0, paramActivity, paramIntent, paramDialog.toString(), "");
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, String paramString, oidb_0x8dd.SelfInfo paramSelfInfo, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.nearbyvideochat.ui.AVActivity", paramAppInterface, paramString, paramSelfInfo, paramInt);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "nearby_video_chat_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return NearbyVideoChatProxyActivity.class;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.NearbyVideoChatProxyActivity
 * JD-Core Version:    0.7.0.1
 */