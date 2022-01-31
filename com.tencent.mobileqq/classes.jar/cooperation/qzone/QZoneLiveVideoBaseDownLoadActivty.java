package cooperation.qzone;

import amrt;
import amru;
import amrv;
import amrw;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public abstract class QZoneLiveVideoBaseDownLoadActivty
  extends BaseActivity
{
  protected int a;
  protected long a;
  protected BroadcastReceiver a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new amrv(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  protected String a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public volatile boolean a;
  protected int b;
  private long jdField_b_of_type_Long;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new amrw(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  public boolean b;
  public int c;
  private String c;
  protected boolean c;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  protected boolean d;
  private String e;
  public boolean e;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean;
  private String j;
  private String k;
  private String l;
  
  public QZoneLiveVideoBaseDownLoadActivty()
  {
    this.jdField_a_of_type_AndroidOsHandler = new amrt(this);
  }
  
  protected abstract PluginBaseInfo a(String paramString);
  
  protected String a()
  {
    return "qzone_live_video_plugin_hack.apk";
  }
  
  public void a()
  {
    finish();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373831));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373832));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363981));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362839));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373829));
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable("http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_live_video_download_bg.png", null);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new amru(this));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "initUI", localException);
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
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 4, "MSG_INIT_UI, mIsUIInited=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          a(paramMessage.arg1);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        paramHandler.sendEmptyMessage(1005);
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 4, "MSG_QUERY_PLUGIN_STATE");
        }
      } while (isFinishing());
      paramHandler = a(a());
      a(a(), paramHandler);
      return;
      b(paramMessage.arg1);
      return;
      this.jdField_b_of_type_Boolean = false;
      int m = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 4, "MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int < m)
      {
        this.jdField_a_of_type_Int += 1;
        b();
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      a(true, false);
      return;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      return;
      this.jdField_d_of_type_Boolean = false;
      m = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadSoTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 4, "MSG_DOWNLOAD_SO_ERROR, retryDownloadSoNum=" + m);
      if (this.jdField_b_of_type_Int < m)
      {
        this.jdField_b_of_type_Int += 1;
        g();
        return;
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
      a(true, true);
      return;
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
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
      int m = (int)(paramPluginBaseInfo.mDownloadProgress * 100.0F);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING, progress=" + m);
      }
      if (m <= 0) {
        break label102;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, m, 0).sendToTarget();
      a(false, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
      label102:
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
        a(true, false);
      }
    }
  }
  
  public void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (!a(paramPluginBaseInfo)) {}
    do
    {
      return;
      switch (paramPluginBaseInfo.mState)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE=" + paramPluginBaseInfo.mState);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_NODOWNLOAD");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING");
    }
    a(paramPluginBaseInfo);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLING");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLED");
    }
    f();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_ERROR");
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
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
    this.jdField_d_of_type_Int %= 3;
    switch (this.jdField_d_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_d_of_type_Int += 1;
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候.");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候..");
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("升级中，请稍候...");
    }
  }
  
  public boolean a()
  {
    if (getAppRuntime() != null) {
      this.jdField_b_of_type_JavaLangString = getAppRuntime().getAccount();
    }
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "intent is null");
      Toast.makeText(getApplicationContext(), "参数错误，无法启动", 1).show();
      QzoneVideoBeaconReport.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", 0.0D, 3, "0");
      finish();
      return false;
    }
    this.jdField_c_of_type_Int = localIntent.getIntExtra("mode", 0);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("launch_time", System.currentTimeMillis());
    if ((3 != this.jdField_c_of_type_Int) && (1 != this.jdField_c_of_type_Int))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "mode invalid, mMode=" + this.jdField_c_of_type_Int);
      Toast.makeText(getApplicationContext(), "参数错误，无法启动, mode=" + this.jdField_c_of_type_Int, 1).show();
      QzoneVideoBeaconReport.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 3, this.jdField_c_of_type_Int + "");
      finish();
      return false;
    }
    if (!NetworkUtil.g(getApplicationContext()))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onCreate, no network available");
      QQToast.a(this, "网络无连接，请检查你的网络连接", 0).a();
      if (this.jdField_c_of_type_Int == 1) {
        QzoneVideoBeaconReport.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "2", null);
      }
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 4, this.jdField_c_of_type_Int + "");
      finish();
      return false;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && (((QQAppInterface)localAppRuntime).c()))
    {
      QQToast.a(this, "正在通话中，请结束通话后再试", 0).a();
      if (this.jdField_c_of_type_Int == 1) {
        QzoneVideoBeaconReport.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "7", null);
      }
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 2, this.jdField_c_of_type_Int + ",1");
      finish();
      return false;
    }
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("backup");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("room_id");
    this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("current_uin");
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "mRoomId=" + this.jdField_c_of_type_JavaLangString + ", mBackUrl=" + this.jdField_a_of_type_JavaLangString + ", mCurrentUin=" + this.jdField_i_of_type_JavaLangString);
    this.jdField_b_of_type_Long = localIntent.getLongExtra("host_uin", 0L);
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("video_play_source");
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("feeds_type");
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("shuo_id");
    this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("repost_uin");
    this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("video_play_scene");
    this.j = localIntent.getStringExtra("entranceReferId");
    this.k = localIntent.getStringExtra("realFrom");
    this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("stopLive", false);
    this.jdField_g_of_type_Boolean = localIntent.getBooleanExtra("enterScreenRecord", false);
    this.jdField_h_of_type_Boolean = localIntent.getBooleanExtra("isFromGame", false);
    this.jdField_i_of_type_Boolean = localIntent.getBooleanExtra("isVertical", true);
    this.l = localIntent.getStringExtra("gamePackgeName");
    return true;
  }
  
  protected boolean a(PluginBaseInfo paramPluginBaseInfo)
  {
    return paramPluginBaseInfo != null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "installPlugin");
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    int m = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginInstallTimeout", 60000);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, m);
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  protected abstract void c();
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launch has canceled");
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
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "launchLiveVideo, account=" + str);
      }
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      QQToast.a(this, "获取帐号信息失败，请稍候再试", 0).a();
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 6, this.jdField_c_of_type_Int + "");
      a();
      return;
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launchLiveVideo, getAppRuntime is null");
        str = this.jdField_i_of_type_JavaLangString;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("room_id", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("mode", this.jdField_c_of_type_Int);
    localIntent.putExtra("video_play_source", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("feeds_type", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("shuo_id", this.jdField_f_of_type_JavaLangString);
    localIntent.putExtra("repost_uin", this.jdField_g_of_type_JavaLangString);
    localIntent.putExtra("video_play_scene", this.jdField_h_of_type_JavaLangString);
    localIntent.putExtra("entranceReferId", this.j);
    localIntent.putExtra("launch_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("realFrom", this.k);
    localIntent.putExtra("stopLive", this.jdField_f_of_type_Boolean);
    localIntent.putExtra("enterScreenRecord", this.jdField_g_of_type_Boolean);
    localIntent.putExtra("isFromGame", this.jdField_h_of_type_Boolean);
    localIntent.putExtra("isVertical", this.jdField_i_of_type_Boolean);
    localIntent.putExtra("gamePackgeName", this.l);
    QzoneLiveVideoPluginProxyActivity.a(this, str, localIntent, -1);
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      g();
      return;
    }
    e();
  }
  
  protected void g() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.mDrawStatus = false;
    }
    setContentView(2130971242);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131373828));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373827);
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
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "unregisterReceiver");
      }
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "", localException);
      }
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt) {
      this.jdField_a_of_type_Boolean = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty
 * JD-Core Version:    0.7.0.1
 */