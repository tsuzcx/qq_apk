package cooperation.qzone;

import ajyc;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Build.VERSION;
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
import bbev;
import bcpw;
import bctn;
import bgyk;
import bgyl;
import bgym;
import bgyn;
import bhpz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public abstract class QZoneLiveVideoBaseDownLoadActivty
  extends BaseActivity
{
  protected int a;
  protected long a;
  protected BroadcastReceiver a;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bgym(this);
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
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new bgyn(this);
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
  protected boolean e;
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
  private String m;
  
  public QZoneLiveVideoBaseDownLoadActivty()
  {
    this.jdField_a_of_type_AndroidOsHandler = new bgyk(this);
  }
  
  private boolean b()
  {
    return Build.VERSION.SDK_INT > 20;
  }
  
  protected abstract PluginBaseInfo a(String paramString);
  
  protected abstract String a();
  
  public void a()
  {
    finish();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371781));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131365355));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363451));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363501));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374237));
    Boolean localBoolean = Boolean.valueOf(false);
    if (getIntent() != null) {
      localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
    }
    if (localBoolean.booleanValue())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (paramInt != 0) {
        break label230;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131711940));
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable("http://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_live_video_download_bg.png", null);
          if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
          this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new bgyl(this));
        }
        catch (Exception localException)
        {
          QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "initUI", localException);
        }
      }
      break;
      label230:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131711947));
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
        if (QLog.isColorLevel()) {
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "MSG_INIT_UI, mIsUIInited=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          a(paramMessage.arg1);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        }
        paramHandler.sendEmptyMessage(1005);
        return;
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "MSG_QUERY_PLUGIN_STATE");
      } while (isFinishing());
      paramHandler = a(a());
      a(a(), paramHandler);
      return;
      b(paramMessage.arg1);
      return;
      this.jdField_b_of_type_Boolean = false;
      int n = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int < n)
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
      n = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadSoTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "MSG_DOWNLOAD_SO_ERROR, retryDownloadSoNum=" + n);
      if (this.jdField_b_of_type_Int < n)
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
      int n = (int)(paramPluginBaseInfo.mDownloadProgress * 100.0F);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING, progress=" + n);
      }
      if (n <= 0) {
        break label102;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1006);
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, n, 0).sendToTarget();
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
    if (!a(paramPluginBaseInfo)) {
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "handlePluginInfo, STATE=" + paramPluginBaseInfo.mState);
      return;
    case 0: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_NODOWNLOAD");
    case 1: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING");
    case 2: 
      a(paramPluginBaseInfo);
      return;
    case 3: 
    case 5: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, state=" + paramPluginBaseInfo.mState);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
    case 4: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLED");
      e();
      return;
    }
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_ERROR");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131711939));
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131711950));
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131711932));
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131711941));
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131711944));
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
      Toast.makeText(getApplicationContext(), ajyc.a(2131711943), 1).show();
      bhpz.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", 0.0D, 3, "0");
      finish();
      return false;
    }
    this.jdField_c_of_type_Int = localIntent.getIntExtra("mode", 0);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("launch_time", System.currentTimeMillis());
    if ((3 != this.jdField_c_of_type_Int) && (1 != this.jdField_c_of_type_Int))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "mode invalid, mMode=" + this.jdField_c_of_type_Int);
      Toast.makeText(getApplicationContext(), ajyc.a(2131711945) + this.jdField_c_of_type_Int, 1).show();
      bhpz.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 3, this.jdField_c_of_type_Int + "");
      finish();
      return false;
    }
    if (!bbev.g(getApplicationContext()))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onCreate, no network available");
      bcpw.a(this, ajyc.a(2131711949), 0).a();
      if (this.jdField_c_of_type_Int == 1) {
        bhpz.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "2", null);
      }
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 4, this.jdField_c_of_type_Int + "");
      finish();
      return false;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && (((QQAppInterface)localAppRuntime).c()))
    {
      bcpw.a(this, ajyc.a(2131711953), 0).a();
      if (this.jdField_c_of_type_Int == 1) {
        bhpz.a(this.jdField_b_of_type_JavaLangString, "live_video_entry", "7", null);
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
    this.m = localIntent.getStringExtra("invitefriend_opuin");
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
    int n = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginInstallTimeout", 60000);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, n);
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
    String str1 = "";
    if (getAppRuntime() != null) {
      str1 = getAppRuntime().getAccount();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "launchLiveVideo, account=" + str1);
      }
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      bcpw.a(this, ajyc.a(2131711933), 0).a();
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D, 6, this.jdField_c_of_type_Int + "");
      a();
      return;
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launchLiveVideo, getAppRuntime is null");
        str1 = this.jdField_i_of_type_JavaLangString;
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
    localIntent.putExtra("invitefriend_opuin", this.m);
    String str3 = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
    String str2 = str3;
    if (getIntent() != null)
    {
      Boolean localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
      localIntent.putExtra("isEcLive", localBoolean);
      str2 = str3;
      if (localBoolean.booleanValue())
      {
        if (!b()) {
          break label708;
        }
        localIntent.putExtra("ec_uin", getIntent().getStringExtra("ec_uin"));
        localIntent.putExtra("ec_room_type", getIntent().getIntExtra("ec_room_type", 0));
        localIntent.putExtra("ec_room_id", getIntent().getStringExtra("ec_room_id"));
        localIntent.putExtra("ec_room_owner_id", getIntent().getStringExtra("ec_room_owner_id"));
        localIntent.putExtra("ec_room_from_type", getIntent().getIntExtra("ec_room_from_type", 0));
        localIntent.putExtra("ec_room_part_flags", getIntent().getIntExtra("ec_room_part_flags", 0));
        localIntent.putExtra("ec_room_create_name", getIntent().getStringExtra("ec_room_create_name"));
        localIntent.putExtra("ec_room_init_type", getIntent().getIntExtra("ec_room_init_type", 1));
        localIntent.putExtra("ec_room_is_owner", getIntent().getBooleanExtra("ec_room_is_owner", false));
        localIntent.putExtra("ec_title", getIntent().getStringExtra("ec_title"));
        localIntent.putExtra("ec_content", getIntent().getStringExtra("ec_content"));
      }
    }
    for (str2 = "com.qzone.adapter.livevideo.ECLiveVideoActivity";; str2 = str3)
    {
      QzoneLiveVideoPluginProxyActivity.a(this, str1, localIntent, -1, str2);
      bctn.a(BaseApplicationImpl.getContext(), false, 5);
      return;
      label708:
      bcpw.a(this, ajyc.a(2131711931), 0).a();
      a();
    }
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.mDrawStatus = false;
    }
    setContentView(2131561960);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365363));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379348);
  }
  
  public void onDestroy()
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