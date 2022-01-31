package cooperation.qzone;

import amda;
import amdb;
import amdc;
import amdd;
import amde;
import amdf;
import amdg;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginManager;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.plugin.QZonePluginUtils;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class QzoneVerticalVideoDownloadActivity
  extends BaseActivity
  implements PluginManagerHelper.OnPluginManagerLoadedListener, QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler = new amda(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new amdc(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private IQZonePluginManager jdField_a_of_type_CooperationQzonePluginIQZonePluginManager;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new amdd(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private PluginBaseInfo a(PluginRecord paramPluginRecord)
  {
    if (paramPluginRecord == null) {
      return null;
    }
    PluginBaseInfo localPluginBaseInfo = new PluginBaseInfo();
    localPluginBaseInfo.mState = paramPluginRecord.jdField_a_of_type_Int;
    localPluginBaseInfo.mDownloadProgress = paramPluginRecord.jdField_a_of_type_Float;
    localPluginBaseInfo.mVersion = String.valueOf(paramPluginRecord.jdField_c_of_type_JavaLangString);
    localPluginBaseInfo.mID = paramPluginRecord.f;
    return localPluginBaseInfo;
  }
  
  private void a()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {
      return;
    }
    this.jdField_a_of_type_Int = localIntent.getIntExtra("key_mode", 1);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("key_launch_time", System.currentTimeMillis());
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("key_backup_url");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("current_uin");
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("下载超时，请点击重试");
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候...");
      return;
    }
    this.jdField_c_of_type_Int %= 3;
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_c_of_type_Int += 1;
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候.");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候..");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候...");
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "PluginDownloadCanceledOnCloseBtn", 0) == 1) {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.b("qzone_vertical_video_plugin.apk");
    }
    QzoneVideoBeaconReport.a(this.jdField_b_of_type_JavaLangString, "vertical_video_entry", "9", null);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  private void b(PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      d();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
    }
    do
    {
      return;
      switch (paramPluginBaseInfo.mState)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE=" + paramPluginBaseInfo.mState);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_NODOWNLOAD");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_DOWNLOADING");
    }
    a(paramPluginBaseInfo);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_INSTALLING");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_INSTALLED");
    }
    c();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_ERROR");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
  }
  
  private static void b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new amdf(paramString2, paramString3, paramString1, paramInt));
  }
  
  private boolean b()
  {
    if (getAppRuntime() != null) {
      this.jdField_b_of_type_JavaLangString = getAppRuntime().getAccount();
    }
    return true;
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      QLog.w("QzoneVerticalVideoDownloadActivity", 1, "launch has canceled");
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    String str = "";
    if (getAppRuntime() != null) {
      str = getAppRuntime().getAccount();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 2, "launchVerticalVideoLayer, account=" + str);
      }
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      QQToast.a(this, "获取帐号信息失败，请稍候再试", 0).a();
      LpReportInfo_dc01500.reportLaunch("qzone_vertical_video_plugin.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 6, this.jdField_a_of_type_Int + "");
      finish();
      return;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "launchVerticalVideoLayer, getAppRuntime is null");
        str = this.jdField_c_of_type_JavaLangString;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("mode", this.jdField_a_of_type_Int);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("launch_time", System.currentTimeMillis());
    QzoneVerticalVideoPluginProxyActivity.a(this, str, localIntent, -1);
    finish();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "installPlugin");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginInstallTimeout", 60000);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, i);
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_vertical_video_plugin.apk", new amdg(this), this.jdField_a_of_type_Int);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QzoneVerticalVideoDownloadActivity", 1, localRemoteException, new Object[0]);
    }
  }
  
  private void e()
  {
    QLog.d("QzoneVerticalVideoDownloadActivity", 1, "installPluginSilence");
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_vertical_video_plugin.apk", null, this.jdField_a_of_type_Int);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("QzoneVerticalVideoDownloadActivity", 1, "installPluginSilence", localRemoteException);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373650));
    String str = QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalVideoPluginSizeText", "插件约1M");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    ((TextView)findViewById(2131373649)).setText(QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalVideoPluginUpdateTips", "升级插件，体验精彩小视频"));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373651));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363957));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362821));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373648));
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalDownloadProgressBackgroundUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20180412205352_WOHxRvJEI2.png"), null);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new amdb(this));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "initUI", localException);
        continue;
        this.jdField_b_of_type_AndroidWidgetTextView.setText("立即升级");
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候...");
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  public void a(Handler paramHandler, Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        QLog.i("QzoneVerticalVideoDownloadActivity", 1, "MSG_INIT_UI, mIsUIInited=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          a(paramMessage.arg1);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        paramHandler.sendEmptyMessage(1005);
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneVerticalVideoDownloadActivity", 4, "MSG_QUERY_PLUGIN_STATE");
        }
      } while (isFinishing());
      b(a(this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_vertical_video_plugin.apk")));
      return;
      b(paramMessage.arg1);
      return;
      this.jdField_a_of_type_Boolean = false;
      int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
      QLog.w("QzoneVerticalVideoDownloadActivity", 4, "MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=" + this.jdField_b_of_type_Int);
      if (this.jdField_b_of_type_Int < i)
      {
        this.jdField_b_of_type_Int += 1;
        d();
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      a(true, false);
      return;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Boolean = false;
      return;
    } while (!(paramMessage.obj instanceof String));
    paramHandler.removeMessages(1006);
    paramHandler.removeMessages(1005);
    paramHandler.removeMessages(1004);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((String)paramMessage.obj);
  }
  
  protected void a(PluginBaseInfo paramPluginBaseInfo)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 100.0F);
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_DOWNLOADING, progress=" + i);
      }
      if (i <= 0) {
        break label142;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, i, 0).sendToTarget();
      a(false, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
      if (paramPluginBaseInfo.mState == 2)
      {
        if (!QZonePluginUtils.a("com.tencent.mobileqq:qzonelive")) {
          break;
        }
        new Handler().postDelayed(new amde(this, paramPluginBaseInfo), 500L);
      }
      return;
      label142:
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
        a(true, false);
      }
    }
    try
    {
      this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramPluginBaseInfo.mID, null, this.jdField_a_of_type_Int);
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
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = paramIQZonePluginManager;
    paramIQZonePluginManager = this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_vertical_video_plugin.apk");
    if (paramIQZonePluginManager != null)
    {
      if (paramIQZonePluginManager.jdField_a_of_type_Int == 4)
      {
        c();
        return;
      }
      if (paramIQZonePluginManager.jdField_a_of_type_Int == 2) {
        try
        {
          this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a("qzone_vertical_video_plugin.apk", null, this.jdField_a_of_type_Int);
          return;
        }
        catch (RemoteException paramIQZonePluginManager)
        {
          QLog.e("QzoneVerticalVideoDownloadActivity", 1, paramIQZonePluginManager, new Object[0]);
          return;
        }
      }
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, "QZoneVerticalVideo has not installed");
      LpReportInfo_dc01500.reportLaunch("qzone_vertical_video_plugin.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 7, this.jdField_a_of_type_Int + "");
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (HttpUtil.a(this.jdField_a_of_type_JavaLangString)))
      {
        paramIQZonePluginManager = this.jdField_a_of_type_JavaLangString + "&stayin=1";
        QLog.d("QzoneVerticalVideoDownloadActivity", 1, "watch mode, jump to H5, " + paramIQZonePluginManager);
        QZoneHelper.a(this, paramIQZonePluginManager, -1, null, null);
        if (QZonePluginManager.b()) {
          e();
        }
        finish();
        return;
      }
      int i = NetworkState.getNetworkType();
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, "network type = " + i);
      if ((1 == i) || (4 == i) || (2 == i))
      {
        d();
        return;
      }
      paramIQZonePluginManager = Message.obtain();
      paramIQZonePluginManager.what = 1000;
      paramIQZonePluginManager.arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIQZonePluginManager);
      return;
    }
    d();
    ToastUtil.a().a("正在查询插件信息，请稍后重试");
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getAppRuntime();
    if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface)) && ((((QQAppInterface)paramBundle).c()) || (QavCameraUsage.b(BaseApplicationImpl.getContext()))))
    {
      ToastUtil.a().a("正在通话中，请结束通话后再试", 1);
      finish();
      return;
    }
    setContentView(2130971194);
    this.jdField_a_of_type_AndroidViewViewGroup = ((FrameLayout)findViewById(2131373647));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373646);
    if (!b())
    {
      finish();
      return;
    }
    a();
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QzoneVerticalVideoDownloadActivity.LaunchCompletedObserver(this, "QZoneVerticalVideo", "qzone_vertical_video_plugin.apk");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (a())
      {
        PluginManagerHelper.getPluginInterface(this, this);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "", paramBundle);
      }
      QZonePluginMangerHelper.a(this, this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1005);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 1, "unregisterReceiver");
      }
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "", localException);
      }
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = null;
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    QQToast.a(BaseApplicationImpl.getContext(), "不支持手Q下载", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */