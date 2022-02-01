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
import com.tencent.mobileqq.colornote.api.IColorNoteController;
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
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
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
    if (paramObject == null) {
      return;
    }
    int i = 0;
    if (paramVarArgs == null) {}
    try
    {
      Class[] arrayOfClass = new Class[0];
      break label28;
      arrayOfClass = new Class[paramVarArgs.length];
      label28:
      Object[] arrayOfObject;
      if (paramVarArgs == null) {
        arrayOfObject = new Object[0];
      } else {
        arrayOfObject = new Object[paramVarArgs.length];
      }
      if (paramVarArgs != null)
      {
        int j = arrayOfClass.length;
        while (i < j)
        {
          arrayOfClass[i] = paramVarArgs[i].a();
          arrayOfObject[i] = paramVarArgs[i].a();
          i += 1;
        }
      }
      paramString = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      paramString.setAccessible(true);
      paramString.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(this, true, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a());
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new FileBrowserActivity.1(this));
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.d();
    if (!bool) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.disablePostTable();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.enablePostTable();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initColorNoteController: checkShowFileColorNote[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("FileBrowserActivity<FileAssistant>", 2, localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null)
    {
      ((IColorNoteController)localObject).setServiceInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a());
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.d();
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.disablePostTable();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.enablePostTable();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateColorNoteController: checkShowFileColorNote[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileBrowserActivity<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private boolean h()
  {
    int i = this.jdField_b_of_type_Int;
    if ((i != 1) && (i != 2) && (i != 5) && (i != 6) && (i != 3) && (i != 13)) {
      return i == 4;
    }
    return true;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localObject == null) {
      return;
    }
    if (localObject != null)
    {
      localObject = ((FileBrowserManager)localObject).a();
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
      localObject = (ImageView)findViewById(2131368077);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper.a((View)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, QFileUtils.a(this.app, i, this.jdField_b_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.f())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void l()
  {
    if (!h()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      return;
    }
    String str = this.jdField_b_of_type_JavaLangString;
    i = QFileUtils.a(i);
    if (i == -1) {
      return;
    }
    FileBrowserMiniAIOHelper localFileBrowserMiniAIOHelper = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
    if (localFileBrowserMiniAIOHelper != null) {
      localFileBrowserMiniAIOHelper.a();
    }
    MiniChatActivity.a(this, i, str, ContactUtils.a(this.app, str, i));
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
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131366799);
  }
  
  public void a()
  {
    if (isFinishing()) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileBrowserActivity.3(this));
  }
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131361947);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localRelativeLayout.setVisibility(i);
  }
  
  public boolean a()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if ((localIntent.getBooleanExtra("from_qlink", false)) || (getIntent().getBooleanExtra("from_qlink_enter_recent", false))) {
      bool = true;
    }
    return bool;
  }
  
  @TargetApi(14)
  protected boolean a(Intent paramIntent)
  {
    Object localObject = new FileViewerParamParser(this.app);
    String str = this.jdField_a_of_type_JavaLangString;
    if ((str != null) && (str.trim().length() != 0)) {
      ((FileViewerParamParser)localObject).a(this.jdField_a_of_type_JavaLangString);
    }
    if (!((FileViewerParamParser)localObject).a(paramIntent)) {
      return false;
    }
    int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager = new FileBrowserManager(this, this, ((FileViewerParamParser)localObject).a(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("browse file use old fileBrowser, entrance ");
    ((StringBuilder)localObject).append(i);
    QLog.d("fileBrowser", 1, ((StringBuilder)localObject).toString());
    paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
      }
      return false;
    }
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
    FileBrowserManager localFileBrowserManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localFileBrowserManager == null)
    {
      QLog.e("FileBrowserActivity<FileAssistant>", 1, "updateMenu but mFileBrowserManager is null!");
      return;
    }
    localFileBrowserManager.b();
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
    FileBrowserManager localFileBrowserManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localFileBrowserManager != null) {
      localFileBrowserManager.a();
    }
  }
  
  public boolean d()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localIColorNoteController != null) && (!localIColorNoteController.isColorNoteExist()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.canAddColorNote())
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.insertColorNote();
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onCannotAdd();
    }
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FileBrowserAct doOnActivityResult resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("mForwardType=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("forward", 2, ((StringBuilder)localObject).toString());
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
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        startActivity((Intent)localObject);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localObject != null) {
      ((FileBrowserManager)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    FileBrowserManager localFileBrowserManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localFileBrowserManager != null)
    {
      localFileBrowserManager.a(paramConfiguration);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.b())
      {
        setRequestedOrientation(-1);
        this.jdField_a_of_type_Boolean ^= true;
      }
    }
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LiuHaiUtils.enableNotch(this);
    TdsReaderGlobal.a();
    paramBundle = getIntent();
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("file_enter_file_browser_type", 0);
    Object localObject = ((IFMConfig)QRoute.api(IFMConfig.class)).getConfigValue(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (localObject != null) {}
    try
    {
      i = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label77:
      break label77;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
    }
    i = 0;
    if (1 == i) {
      setRequestedOrientation(-1);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("c2c_discussion_recentfile");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("file_browser_extra_params_uin");
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
    if (localObject == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Int = ((ForwardFileInfo)localObject).b();
    if (10004 == this.jdField_a_of_type_Int)
    {
      this.jdField_c_of_type_Boolean = true;
      FileManagerReporter.a("0X8004BB3");
    }
    else
    {
      FileManagerReporter.a("0X8004BC8");
    }
    if (paramBundle.getBooleanExtra("_from_aio_", false)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (paramBundle.getBooleanExtra("key_is_from_lite", false)) {
      this.d = true;
    }
    LiuHaiUtils.a(this);
    setContentViewNoTitle(2131560836);
    e();
    if (!a(paramBundle))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "create FileBrowserView failed");
      }
      finish();
      return false;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
    f();
    k();
    FileManagerReporter.a("0X8004C01");
    m();
    i();
    localObject = getResources().getConfiguration().toString();
    if ((!((String)localObject).contains("hwMultiwindow-magic")) && (!((String)localObject).contains("hw-magic-windows"))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (i == 0))
    {
      localObject = (RelativeLayout)findViewById(2131376810);
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    j();
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.d()) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.addHistoryNote();
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onDestroy();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localObject != null) {
      ((FileBrowserManager)localObject).f();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).d();
    }
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localObject != null) {
      ((FileBrowserManager)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onPause();
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localObject != null) {
      ((FileBrowserManager)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserMiniAIOHelper;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onResume();
    }
    super.doOnResume();
  }
  
  public void e()
  {
    ((TextView)findViewById(2131369261)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840347);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131704603));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131368033));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)findViewById(2131363438));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368051));
  }
  
  public boolean e()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      return localIColorNoteController.isColorNoteExist();
    }
    return false;
  }
  
  public boolean f()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      return localIColorNoteController.shouldDisplayColorNote();
    }
    return false;
  }
  
  public void finish()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null)
    {
      localIColorNoteController.exitAnimation();
      return;
    }
    super.finish();
  }
  
  public void g()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.deleteColorNote();
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
  
  protected boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    FileBrowserManager localFileBrowserManager = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager;
    if (localFileBrowserManager != null) {
      localFileBrowserManager.c();
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131369249: 
      long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
      System.arraycopy(arrayOfLong, 1, arrayOfLong, 0, arrayOfLong.length - 1);
      arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
      arrayOfLong[(arrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      long l = this.jdField_a_of_type_ArrayOfLong[0];
      SystemClock.uptimeMillis();
      break;
    case 2131369216: 
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
      break;
    case 2131369202: 
      onBackEvent();
      break;
    case 2131368033: 
      l();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */