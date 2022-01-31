package cooperation.qzone;

import amzi;
import amzj;
import amzm;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.plugin.QZoneRemotePluginHandler;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.video.QzoneVideoBeaconReport;

public class QZoneLiveVideoDownLoadActivtyV2
  extends QZoneLiveVideoBaseDownLoadActivty
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public IQZonePluginManager a;
  
  private PluginBaseInfo a(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return null;
    }
    PluginBaseInfo localPluginBaseInfo = new PluginBaseInfo();
    localPluginBaseInfo.mState = paramPluginRecord.jdField_a_of_type_Int;
    localPluginBaseInfo.mDownloadProgress = paramPluginRecord.jdField_a_of_type_Float;
    localPluginBaseInfo.mVersion = String.valueOf(paramPluginRecord.c);
    localPluginBaseInfo.mID = paramPluginRecord.f;
    return localPluginBaseInfo;
  }
  
  protected PluginBaseInfo a(String paramString)
  {
    return a(this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramString));
  }
  
  protected void a(PluginBaseInfo paramPluginBaseInfo)
  {
    super.a(paramPluginBaseInfo);
    if (paramPluginBaseInfo.mState == 2)
    {
      if (QZonePluginUtils.a("com.tencent.mobileqq:qzonelive"))
      {
        RemoteHandleManager.a().a("cmd.killLiveVideo", new Bundle(), false);
        new Handler().postDelayed(new amzi(this, paramPluginBaseInfo), 500L);
      }
    }
    else {
      return;
    }
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramPluginBaseInfo.mID, null, this.c);
      return;
    }
    catch (RemoteException paramPluginBaseInfo)
    {
      paramPluginBaseInfo.printStackTrace();
    }
  }
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null)
    {
      QZonePluginMangerHelper.a(this, this);
      return;
    }
    QQAppInterface localQQAppInterface2 = (QQAppInterface)getAppRuntime();
    QQAppInterface localQQAppInterface1 = localQQAppInterface2;
    if (localQQAppInterface2 == null)
    {
      QLog.i("QZoneLiveVideoDownLoadActivtyV2", 1, "onQzonePluginClientReady: getAppRuntime return null.");
      localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (localQQAppInterface1 != null) {
      QZoneRemotePluginHandler.a().a(localQQAppInterface1);
    }
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = paramIQZonePluginManager;
    paramIQZonePluginManager = this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk");
    if (paramIQZonePluginManager != null)
    {
      if (paramIQZonePluginManager.jdField_a_of_type_Int == 4)
      {
        f();
        return;
      }
      if (paramIQZonePluginManager.jdField_a_of_type_Int == 2) {
        try
        {
          this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk", null, this.c);
          return;
        }
        catch (RemoteException paramIQZonePluginManager)
        {
          QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, paramIQZonePluginManager, new Object[0]);
          return;
        }
      }
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "QZoneLiveVideo has not installed");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 7, this.c + "");
      if ((3 == this.c) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (HttpUtil.a(this.jdField_a_of_type_JavaLangString)))
      {
        paramIQZonePluginManager = this.jdField_a_of_type_JavaLangString + "&stayin=1";
        QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "watch mode, jump to H5, " + paramIQZonePluginManager);
        QZoneHelper.a(this, paramIQZonePluginManager, -1, null, null);
        if (QZonePluginManager.b()) {
          c();
        }
        a();
        return;
      }
      if (1 == this.c) {
        LpReportInfo_dc00321.report(8, 128, 3, false, false, null);
      }
      int i = NetworkState.getNetworkType();
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "network type = " + i);
      if ((1 == i) || (4 == i) || (2 == i))
      {
        b();
        return;
      }
      paramIQZonePluginManager = Message.obtain();
      paramIQZonePluginManager.what = 1000;
      paramIQZonePluginManager.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIQZonePluginManager);
      return;
    }
    b();
    ToastUtil.a().a("正在查询插件信息，请稍后重试");
    a();
  }
  
  protected boolean a(PluginBaseInfo paramPluginBaseInfo)
  {
    boolean bool = super.a(paramPluginBaseInfo);
    if (!bool)
    {
      b();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
    }
    return bool;
  }
  
  protected void b()
  {
    super.b();
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk", new amzm(this), this.c);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
    }
  }
  
  protected void c()
  {
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "installPluginSilence");
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_live_video_plugin_hack.apk", null, 3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, "installPluginSilence", localRemoteException);
    }
  }
  
  protected void d()
  {
    super.d();
    if (QzoneConfig.getInstance().getConfig("LiveSetting", "PluginDownloadCanceledOnCloseBtn", 0) == 1) {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.b("qzone_live_video_plugin_hack.apk");
    }
    QzoneVideoBeaconReport.a(this.b, "live_video_entry", "9", null);
  }
  
  public void e()
  {
    super.e();
    if ((this.c != 1) && (!QZonePluginUtils.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager != null)) {}
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(null, 3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
    }
  }
  
  protected void g()
  {
    if ((this.c == 1) && (!QZonePluginUtils.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager != null)) {
      try
      {
        this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(new amzj(this), 1);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
        return;
      }
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("QZoneLiveVideoDownLoadActivtyV2", 4, "oncreate");
    if (!a()) {
      return;
    }
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QZoneLiveVideoBaseDownLoadActivty.LaunchCompletedObserver(this, "QZoneLiveVideo", "qzone_live_video_plugin_hack.apk");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      QZonePluginMangerHelper.a(this, this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoDownLoadActivtyV2", 1, "", paramBundle);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2
 * JD-Core Version:    0.7.0.1
 */