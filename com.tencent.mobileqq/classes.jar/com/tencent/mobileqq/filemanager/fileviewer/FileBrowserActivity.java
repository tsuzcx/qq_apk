package com.tencent.mobileqq.filemanager.fileviewer;

import aepi;
import alud;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aobw;
import arbp;
import arfk;
import arfl;
import arfm;
import arfn;
import arfo;
import arfp;
import arft;
import arht;
import arhv;
import arhw;
import arhx;
import arrp;
import arrr;
import arsx;
import bdbk;
import bdgc;
import bnle;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, arhw
{
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aobw jdField_a_of_type_Aobw;
  public arfp a;
  private arft jdField_a_of_type_Arft;
  private arhv jdField_a_of_type_Arhv;
  arhx jdField_a_of_type_Arhx = new arfm(this);
  private DynamicAvatarView jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView;
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private long[] jdField_a_of_type_ArrayOfLong = new long[5];
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public FileBrowserActivity()
  {
    this.jdField_a_of_type_Int = 10000;
  }
  
  private void a(Object paramObject, String paramString, arfo... paramVarArgs)
  {
    int i = 0;
    if (paramObject == null) {
      return;
    }
    if (paramVarArgs == null) {}
    try
    {
      Class[] arrayOfClass = new Class[0];
      if (paramVarArgs == null) {}
      for (Object[] arrayOfObject = new Object[0];; arrayOfObject = new Object[paramVarArgs.length])
      {
        if (paramVarArgs == null) {
          break label97;
        }
        int j = arrayOfClass.length;
        while (i < j)
        {
          arrayOfClass[i] = paramVarArgs[i].a();
          arrayOfObject[i] = paramVarArgs[i].a();
          i += 1;
        }
        arrayOfClass = new Class[paramVarArgs.length];
        break;
      }
      label97:
      paramString = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      paramString.setAccessible(true);
      paramString.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aobw = new aobw(this, true, true);
    this.jdField_a_of_type_Aobw.a(this.jdField_a_of_type_Arfp.a());
    this.jdField_a_of_type_Aobw.a(this);
    this.jdField_a_of_type_Aobw.a(new arfk(this));
    boolean bool = this.jdField_a_of_type_Arfp.d();
    if (!bool) {
      this.jdField_a_of_type_Aobw.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Aobw.h();
    }
  }
  
  private boolean g()
  {
    return (this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 5) || (this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 13) || (this.jdField_b_of_type_Int == 4);
  }
  
  private void h()
  {
    boolean bool;
    if (this.jdField_a_of_type_Aobw != null)
    {
      this.jdField_a_of_type_Aobw.a(this.jdField_a_of_type_Arfp.a());
      bool = this.jdField_a_of_type_Arfp.d();
      if (bool) {
        break label77;
      }
      this.jdField_a_of_type_Aobw.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "updateColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      label77:
      this.jdField_a_of_type_Aobw.h();
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new arfl(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
  }
  
  private void j()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new arfo[] { new arfo(localRelativeLayout, View.class) });
  }
  
  private void k()
  {
    Object localObject;
    if (this.jdField_a_of_type_Arfp != null)
    {
      localObject = this.jdField_a_of_type_Arfp.a();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.i("FileBrowserActivity<FileAssistant>", 1, "updateTitleBar,but file name is empty.");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.post(new FileBrowserActivity.4(this, (String)localObject));
    }
    int i = arsx.a(this.jdField_b_of_type_Int);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (i != -1) && (g()) && (this.jdField_a_of_type_Arfp.a()))
    {
      this.jdField_a_of_type_Arft = new arft(this.app, this.jdField_b_of_type_JavaLangString);
      localObject = (ImageView)findViewById(2131367555);
      this.jdField_a_of_type_Arft.a((View)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(bdbk.a(this.app, arsx.a(this.app, i, this.jdField_b_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString));
    }
    while (this.jdField_a_of_type_Arfp.e())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void l()
  {
    if (!g()) {}
    String str;
    int i;
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_Int == 0));
      str = this.jdField_b_of_type_JavaLangString;
      i = arsx.a(this.jdField_b_of_type_Int);
    } while (i == -1);
    if (this.jdField_a_of_type_Arft != null) {
      this.jdField_a_of_type_Arft.a();
    }
    MiniChatActivity.a(this, i, str, bdgc.b(this.app, str, i));
  }
  
  private void m()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new arfn(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public int a()
  {
    return getTitleBarHeight();
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131366321);
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  public ForwardFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new FileBrowserActivity.3(this));
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131361887);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((getIntent().getBooleanExtra("from_qlink", false)) || (getIntent().getBooleanExtra("from_qlink_enter_recent", false))) {
      bool = true;
    }
    return bool;
  }
  
  @TargetApi(14)
  protected boolean a(Intent paramIntent)
  {
    arht localarht = new arht(this.app);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0)) {
      localarht.a(this.jdField_a_of_type_JavaLangString);
    }
    if (!localarht.a(paramIntent)) {}
    do
    {
      return false;
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      if (this.jdField_a_of_type_Arfp == null)
      {
        this.jdField_a_of_type_Arfp = new arfp(this, this, localarht.a(this));
        this.jdField_a_of_type_Arfp.a(this.jdField_a_of_type_Arhx);
      }
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Arfp.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (this.jdField_a_of_type_Arfp.b()) {
      setRequestedOrientation(1);
    }
    return true;
  }
  
  public void b()
  {
    finish();
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    ((TextView)findViewById(2131368682)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368638));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840102);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alud.a(2131704883));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131367516));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)findViewById(2131363115));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367533));
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aobw != null)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_Aobw.c())
      {
        if (!this.jdField_a_of_type_Aobw.b()) {
          break label44;
        }
        this.jdField_a_of_type_Aobw.e();
        bool1 = true;
      }
    }
    return bool1;
    label44:
    this.jdField_a_of_type_Aobw.i();
    return false;
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Aobw != null) {
      return this.jdField_a_of_type_Aobw.c();
    }
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "FileBrowserAct doOnActivityResult resultCode=" + paramInt2 + "mForwardType=" + this.jdField_a_of_type_Int);
    }
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_Arhv == null)
      {
        this.jdField_a_of_type_Arhv = new arhv();
        this.jdField_a_of_type_Arhv.a(getIntent());
      }
      if ((this.jdField_a_of_type_Arhv.a()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = aepi.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
      }
      setResult(4, paramIntent);
      finish();
      return;
    }
    if (paramInt1 == 14002)
    {
      QLog.d("FileBrowserActivity<FileAssistant>", 2, "FileBrowserAct finish for doc mini program ");
      finish();
      return;
    }
    if (this.jdField_a_of_type_Arfp != null) {
      this.jdField_a_of_type_Arfp.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Arfp != null)
    {
      this.jdField_a_of_type_Arfp.a(paramConfiguration);
      if (this.jdField_a_of_type_Arfp.b())
      {
        setRequestedOrientation(-1);
        if (this.jdField_a_of_type_Boolean) {
          break label50;
        }
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.a();
    paramBundle = arbp.a(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (paramBundle != null) {}
    try
    {
      i = Integer.parseInt(paramBundle);
      if (1 == i) {
        setRequestedOrientation(-1);
      }
      paramBundle = getIntent();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("c2c_discussion_recentfile");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("file_browser_extra_params_uin");
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("file_enter_file_browser_type", 0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
      {
        finish();
        return false;
      }
    }
    catch (NumberFormatException paramBundle)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
        }
        int i = 0;
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b();
      if (10004 == this.jdField_a_of_type_Int)
      {
        this.jdField_c_of_type_Boolean = true;
        arrp.a("0X8004BB3");
      }
      for (;;)
      {
        if (paramBundle.getBooleanExtra("_from_aio_", false)) {
          this.jdField_c_of_type_Boolean = true;
        }
        if (paramBundle.getBooleanExtra("key_is_from_lite", false)) {
          this.d = true;
        }
        bnle.a(this);
        setContentViewNoTitle(2131560694);
        c();
        if (a(paramBundle)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 2, "create FileBrowserView failed");
        }
        finish();
        return false;
        arrp.a("0X8004BC8");
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Arfp.a();
      d();
      k();
      arrp.a("0X8004C01");
      m();
      i();
      Object localObject;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131376035);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (!arrr.a())
      {
        localObject = new Intent(this, WebProcessReceiver.class);
        ((Intent)localObject).setAction("action_download_tbs");
        sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      init(paramBundle);
      if (Build.VERSION.SDK_INT <= 11) {
        removeWebViewLayerType();
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    j();
    n();
    if (this.jdField_a_of_type_Aobw != null)
    {
      this.jdField_a_of_type_Aobw.c();
      if (this.jdField_a_of_type_Arfp.d()) {
        this.jdField_a_of_type_Aobw.q();
      }
    }
    if (this.jdField_a_of_type_Arfp != null) {
      this.jdField_a_of_type_Arfp.f();
    }
    if (this.jdField_a_of_type_Arft != null) {
      this.jdField_a_of_type_Arft.d();
    }
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_Arfp != null) {
      this.jdField_a_of_type_Arfp.d();
    }
    if (this.jdField_a_of_type_Arft != null) {
      this.jdField_a_of_type_Arft.c();
    }
    if (this.jdField_a_of_type_Aobw != null) {
      this.jdField_a_of_type_Aobw.b();
    }
  }
  
  public void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (this.jdField_a_of_type_Arfp != null) {
      this.jdField_a_of_type_Arfp.e();
    }
    if (this.jdField_a_of_type_Arft != null) {
      this.jdField_a_of_type_Arft.b();
    }
    if (this.jdField_a_of_type_Aobw != null) {
      this.jdField_a_of_type_Aobw.a();
    }
    super.doOnResume();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Arfp != null) {
      this.jdField_a_of_type_Arfp.b();
    }
    if (this.jdField_a_of_type_Arfp.e())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Aobw != null) {
      return this.jdField_a_of_type_Aobw.a();
    }
    return false;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Arfp != null) {
      this.jdField_a_of_type_Arfp.a();
    }
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Aobw != null)
    {
      this.jdField_a_of_type_Aobw.d();
      return;
    }
    super.finish();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Aobw != null) && (this.jdField_a_of_type_Aobw.c())) {
      this.jdField_a_of_type_Aobw.f();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    if (this.jdField_a_of_type_Arfp != null) {
      this.jdField_a_of_type_Arfp.c();
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Arfp.a();
      return;
      onBackEvent();
      return;
      l();
      return;
      System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 1, this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length - 1);
      this.jdField_a_of_type_ArrayOfLong[(this.jdField_a_of_type_ArrayOfLong.length - 1)] = SystemClock.uptimeMillis();
    } while ((this.jdField_a_of_type_ArrayOfLong[0] < SystemClock.uptimeMillis() - 1500L) || (this.jdField_a_of_type_Arfp == null));
    this.jdField_a_of_type_Arfp.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */