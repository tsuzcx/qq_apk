package cooperation.qzone;

import Override;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import anzj;
import bjuh;
import bmtd;
import bmtr;
import bmts;
import bndl;
import bnez;
import bnfc;
import bnfe;
import bnfk;
import bnfm;
import bngf;
import bnlv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.util.NetworkState;
import nnr;

public class QZoneLiveVideoDownLoadActivtyV2
  extends QZoneLiveVideoBaseDownLoadActivty
  implements bnfe
{
  bndl a;
  
  private PluginBaseInfo a(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return null;
    }
    PluginBaseInfo localPluginBaseInfo = new PluginBaseInfo();
    localPluginBaseInfo.mState = paramPluginRecord.state;
    localPluginBaseInfo.mDownloadProgress = paramPluginRecord.progress;
    localPluginBaseInfo.mVersion = String.valueOf(paramPluginRecord.ver);
    localPluginBaseInfo.mID = paramPluginRecord.id;
    return localPluginBaseInfo;
  }
  
  protected PluginBaseInfo a(String paramString)
  {
    return a(this.jdField_a_of_type_Bndl.a(paramString));
  }
  
  protected String a()
  {
    return "qzone_live_video_plugin_hack.apk";
  }
  
  public void a(bndl parambndl)
  {
    if (parambndl == null)
    {
      bnfc.a(this, this);
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
      bnfm.a().a(localQQAppInterface1);
    }
    this.jdField_a_of_type_Bndl = parambndl;
    parambndl = this.jdField_a_of_type_Bndl.a("qzone_live_video_plugin_hack.apk");
    if (parambndl != null)
    {
      if (parambndl.state == 4)
      {
        f();
        return;
      }
      if (parambndl.state == 2) {
        try
        {
          this.jdField_a_of_type_Bndl.a("qzone_live_video_plugin_hack.apk", null, this.c);
          return;
        }
        catch (RemoteException parambndl)
        {
          QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, parambndl, new Object[0]);
          return;
        }
      }
      QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "QZoneLiveVideo has not installed");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 7, this.c + "");
      if ((3 == this.c) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (nnr.a(this.jdField_a_of_type_JavaLangString)))
      {
        parambndl = this.jdField_a_of_type_JavaLangString + "&stayin=1";
        QLog.d("QZoneLiveVideoDownLoadActivtyV2", 1, "watch mode, jump to H5, " + parambndl);
        bmtd.a(this, parambndl, -1, null, null);
        if (bnez.b()) {
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
      if ((1 == i) || (4 == i) || (5 == i) || (3 == i))
      {
        b();
        return;
      }
      parambndl = Message.obtain();
      parambndl.what = 1000;
      parambndl.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(parambndl);
      return;
    }
    b();
    bjuh.a().a(anzj.a(2131710825));
    a();
  }
  
  protected void a(PluginBaseInfo paramPluginBaseInfo)
  {
    super.a(paramPluginBaseInfo);
    if (paramPluginBaseInfo.mState == 2)
    {
      if (bnfk.a("com.tencent.mobileqq:qzonelive"))
      {
        bngf.a().a("cmd.killLiveVideo", new Bundle(), false);
        new Handler().postDelayed(new QZoneLiveVideoDownLoadActivtyV2.1(this, paramPluginBaseInfo), 500L);
      }
    }
    else {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bndl.a(paramPluginBaseInfo.mID, null, this.c);
      return;
    }
    catch (RemoteException paramPluginBaseInfo)
    {
      paramPluginBaseInfo.printStackTrace();
    }
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
      this.jdField_a_of_type_Bndl.a("qzone_live_video_plugin_hack.apk", new bmts(this), this.c);
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
      this.jdField_a_of_type_Bndl.a("qzone_live_video_plugin_hack.apk", null, 3);
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
      this.jdField_a_of_type_Bndl.b("qzone_live_video_plugin_hack.apk");
    }
    bnlv.a(this.b, "live_video_entry", "9", null);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  protected void e()
  {
    super.e();
    if ((this.c != 1) && (!bnfk.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Bndl != null)) {}
    try
    {
      this.jdField_a_of_type_Bndl.a(null, 3);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localRemoteException, new Object[0]);
    }
  }
  
  protected void g()
  {
    if ((this.c == 1) && (!bnfk.a(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Bndl != null)) {
      try
      {
        this.jdField_a_of_type_Bndl.a(new bmtr(this), 1);
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
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
      bnfc.a(this, this);
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
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bndl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2
 * JD-Core Version:    0.7.0.1
 */