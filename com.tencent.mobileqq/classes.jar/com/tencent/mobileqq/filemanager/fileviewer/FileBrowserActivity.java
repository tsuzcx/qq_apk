package com.tencent.mobileqq.filemanager.fileviewer;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IFileBrowser
{
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DynamicAvatarView jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView;
  private ColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  protected FileBrowserManager a;
  private FileBrowserMiniAIOHelper jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
  private ForwardData jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData = null;
  IFileViewListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = new FileBrowserActivity.5(this);
  protected IFileViewReport a;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private long[] jdField_a_of_type_ArrayOfLong = new long[5];
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  
  public FileBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewReport = null;
    this.jdField_a_of_type_Int = 10000;
  }
  
  private void a(Object paramObject, String paramString, FileBrowserActivity.TypedObject... paramVarArgs)
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
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = new ColorNoteController(this, true, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a());
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new FileBrowserActivity.1(this));
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.d();
    if (!bool) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.h();
    }
  }
  
  private void h()
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a());
      bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.d();
      if (bool) {
        break label77;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "updateColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      label77:
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.h();
    }
  }
  
  private boolean h()
  {
    return (this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 5) || (this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 13) || (this.jdField_b_of_type_Int == 4);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new FileBrowserActivity.2(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
  }
  
  private void j()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(localRelativeLayout, View.class) });
  }
  
  private void k()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.i("FileBrowserActivity<FileAssistant>", 1, "updateTitleBar,but file name is empty.");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.post(new FileBrowserActivity.4(this, (String)localObject));
    }
    int i = QFileUtils.a(this.jdField_b_of_type_Int);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (i != -1) && (h()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper = new FileBrowserMiniAIOHelper(this.app, this.jdField_b_of_type_JavaLangString);
      localObject = (ImageView)findViewById(2131368325);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper.a((View)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, QFileUtils.a(this.app, i, this.jdField_b_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.f())
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
    if (!h()) {}
    String str;
    int i;
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_Int == 0));
      str = this.jdField_b_of_type_JavaLangString;
      i = QFileUtils.a(this.jdField_b_of_type_Int);
    } while (i == -1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper.a();
    }
    MiniChatActivity.a(this, i, str, ContactUtils.b(this.app, str, i));
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
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new FileBrowserActivity.6(this);
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
    return (RelativeLayout)findViewById(2131366937);
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
    if (isFinishing()) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileBrowserActivity.3(this));
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131361941);
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
    FileViewerParamParser localFileViewerParamParser = new FileViewerParamParser(this.app);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0)) {
      localFileViewerParamParser.a(this.jdField_a_of_type_JavaLangString);
    }
    if (!localFileViewerParamParser.a(paramIntent)) {}
    do
    {
      return false;
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager = new FileBrowserManager(this, this, localFileViewerParamParser.a(this));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
      }
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.b()) {
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
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager == null)
    {
      QLog.e("FileBrowserActivity<FileAssistant>", 1, "updateMenu but mFileBrowserManager is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.b();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.f())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b()) {
          break label44;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.e();
        bool1 = true;
      }
    }
    return bool1;
    label44:
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.i();
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "FileBrowserAct doOnActivityResult resultCode=" + paramInt2 + "mForwardType=" + this.jdField_a_of_type_Int);
    }
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData = new ForwardData();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a(getIntent());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData.a()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(paramConfiguration);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.b())
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
    LiuHaiUtils.enableNotch(this);
    TdsReaderGlobal.a();
    paramBundle = getIntent();
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("file_enter_file_browser_type", 0);
    String str = ((IFMConfig)QRoute.api(IFMConfig.class)).getConfigValue(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (str != null) {}
    Object localObject;
    try
    {
      i = Integer.parseInt(str);
      if (1 == i) {
        setRequestedOrientation(-1);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("c2c_discussion_recentfile");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("file_browser_extra_params_uin");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
      {
        finish();
        return false;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
        }
        i = 0;
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b();
      if (10004 == this.jdField_a_of_type_Int)
      {
        this.jdField_c_of_type_Boolean = true;
        FileManagerReporter.a("0X8004BB3");
      }
      for (;;)
      {
        if (paramBundle.getBooleanExtra("_from_aio_", false)) {
          this.jdField_c_of_type_Boolean = true;
        }
        if (paramBundle.getBooleanExtra("key_is_from_lite", false)) {
          this.d = true;
        }
        LiuHaiUtils.a(this);
        setContentViewNoTitle(2131560961);
        e();
        if (a(paramBundle)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 2, "create FileBrowserView failed");
        }
        finish();
        return false;
        FileManagerReporter.a("0X8004BC8");
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
      f();
      k();
      FileManagerReporter.a("0X8004C01");
      m();
      i();
      localObject = getResources().getConfiguration().toString();
      if (((String)localObject).contains("hwMultiwindow-magic")) {
        break label335;
      }
    }
    if (((String)localObject).contains("hw-magic-windows")) {}
    label335:
    for (int i = 1;; i = 0)
    {
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (i == 0))
      {
        localObject = (RelativeLayout)findViewById(2131377357);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (!FileManagerUtil.a())
      {
        localObject = new Intent(this, WebProcessReceiver.class);
        ((Intent)localObject).setAction("action_download_tbs");
        sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      init(paramBundle);
      if (Build.VERSION.SDK_INT <= 11) {
        removeWebViewLayerType();
      }
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    j();
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.d()) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.p();
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper.d();
    }
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b();
    }
  }
  
  public void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
    }
    super.doOnResume();
  }
  
  public void e()
  {
    ((TextView)findViewById(2131369546)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369501));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840478);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704516));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131368281));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)findViewById(2131363511));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368299));
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
    }
    return false;
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a();
    }
    return false;
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.d();
      return;
    }
    super.finish();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c())) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.f();
    }
  }
  
  public boolean g()
  {
    return this.d;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.c();
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
      continue;
      onBackEvent();
      continue;
      l();
      continue;
      System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 1, this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length - 1);
      this.jdField_a_of_type_ArrayOfLong[(this.jdField_a_of_type_ArrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ArrayOfLong[0] >= SystemClock.uptimeMillis() - 1500L) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.g();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */