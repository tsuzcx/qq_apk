package com.tencent.mobileqq.filemanager.fileviewer;

import adji;
import adjj;
import adjk;
import adjl;
import adjm;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.MenuData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IFileBrowser
{
  private static final String jdField_a_of_type_JavaLangString;
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static final String jdField_b_of_type_JavaLangString = new String(jdField_b_of_type_ArrayOfChar);
  private static final char[] jdField_b_of_type_ArrayOfChar;
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new adjk(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  public FileBrowserManager a;
  private ForwardData jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerForwardData;
  IFileViewListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener = new adjl(this);
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
    jdField_b_of_type_ArrayOfChar = new char[] { '‥' };
  }
  
  public FileBrowserActivity()
  {
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
  
  private static List[] a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      HorizontalListViewAdapter.MenuData localMenuData = (HorizontalListViewAdapter.MenuData)paramArrayList.get(i);
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = localMenuData.jdField_a_of_type_JavaLangString;
      localActionSheetItem.jdField_b_of_type_Int = localMenuData.jdField_a_of_type_Int;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.jdField_a_of_type_AndroidViewView$OnClickListener = localMenuData.jdField_a_of_type_AndroidViewView$OnClickListener;
      localActionSheetItem.jdField_b_of_type_JavaLangString = "";
      localArrayList.add(localActionSheetItem);
      i += 1;
    }
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new adji(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
  }
  
  private void e()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(localRelativeLayout, View.class) });
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
      this.jdField_a_of_type_AndroidWidgetTextView.post(new adjj(this, str));
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363400));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a());
  }
  
  private void h()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adjm(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void i()
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
    return (RelativeLayout)findViewById(2131368858);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.b(a(), new ViewGroup.LayoutParams(-1, -1));
    d();
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131368862);
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
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.trim().length() != 0)) {
      localFileViewerParamParser.a(this.jdField_c_of_type_JavaLangString);
    }
    if (!localFileViewerParamParser.a(paramIntent)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager = new FileBrowserManager(this, this, localFileViewerParamParser.a(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(a(), new RelativeLayout.LayoutParams(-1, -1)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a()) {
      setRequestedOrientation(1);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramIntent = (RelativeLayout)findViewById(2131365522);
      paramIntent.setFitsSystemWindows(true);
      paramIntent.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    return true;
  }
  
  public void b()
  {
    ((TextView)findViewById(2131368860)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363493));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839162);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("菜单");
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363262));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363400));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager == null) {
      return;
    }
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a() + "(" + FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a()) + ")");
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a()));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(paramConfiguration);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a())
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
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = FMConfig.a(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (paramBundle != null) {}
    try
    {
      i = Integer.parseInt(paramBundle);
      if (1 == i) {
        setRequestedOrientation(-1);
      }
      paramBundle = getIntent();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("c2c_discussion_recentfile");
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
      Object localObject;
      if ((-1L == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b()) && (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a())))
      {
        localObject = new FileInfo();
        ((FileInfo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
        ((FileInfo)localObject).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.d());
        ((FileInfo)localObject).e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        FMDataCache.a(localArrayList);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b(FileManagerUtil.a((FileInfo)localObject).nSessionId);
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
        setContentViewNoTitle(2130970055);
        b();
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
      f();
      d();
      FileManagerReporter.a("0X8004C01");
      h();
      c();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131365522);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.a(this), 0, 0);
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
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, " FileBrowser doOnDestroy");
    }
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    e();
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.c();
    }
    LocalTbsViewManager.a().a(this);
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a();
      if (isFinishing()) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.c();
      }
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.b();
    }
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363493: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
      return;
    }
    onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */