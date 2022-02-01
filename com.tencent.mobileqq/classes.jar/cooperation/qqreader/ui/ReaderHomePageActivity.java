package cooperation.qqreader.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.QRPluginManagerClient;
import cooperation.qqreader.helper.ReaderTabConfigDataHelper;
import cooperation.qqreader.helper.ReaderUrlConfigDataHelper;
import cooperation.qqreader.host.filemanager.ReaderFileInfo;
import cooperation.qqreader.model.Constant;
import cooperation.qqreader.model.TabItemData;
import cooperation.qqreader.net.QueryUserIdentityTask;
import cooperation.qqreader.proxy.ReaderInterfacePlugin;
import cooperation.qqreader.utils.Config.UserConfig;
import cooperation.qqreader.utils.Log;
import cooperation.qqreader.utils.SharedPrefrenceForQQ;
import cooperation.qqreader.utils.Utility;
import cooperation.qqreader.view.ReaderTabBarView;
import cooperation.qqreader.view.ReaderTitleBarView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class ReaderHomePageActivity
  extends ReaderBaseWebActivity
{
  private ColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  private ReaderTabConfigDataHelper jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  private static int a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int i = 0;
      if (i < paramArrayOfInt.length) {
        if (paramInt != paramArrayOfInt[i]) {}
      }
      for (;;)
      {
        if (i > paramArrayOfInt.length)
        {
          return 0;
          i += 1;
          break;
        }
        return i;
        i = paramInt;
      }
    }
    return paramInt;
  }
  
  private static int a(@NonNull Intent paramIntent)
  {
    int j = 0;
    int k = 1;
    int i;
    if (paramIntent.hasExtra(Constant.jdField_a_of_type_JavaLangString)) {
      i = paramIntent.getIntExtra(Constant.jdField_a_of_type_JavaLangString, 1);
    }
    for (;;)
    {
      return i;
      i = k;
      if (!paramIntent.getBooleanExtra("is_from_qreader_shortcut", false))
      {
        i = k;
        if (!Config.UserConfig.e(BaseApplicationImpl.getApplication()))
        {
          boolean bool1 = SharedPrefrenceForQQ.a(BaseApplicationImpl.getApplication());
          boolean bool2 = a(paramIntent);
          if (bool1)
          {
            i = k;
            if (bool2) {}
          }
          else
          {
            if (bool1) {
              return 0;
            }
            i = j;
            if (paramIntent.getIntExtra("redtouch_type", -1) != 0) {
              i = 1;
            }
          }
        }
      }
    }
  }
  
  private static int a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      int i = Color.parseColor(paramString2);
      return i;
    }
    catch (Exception localException)
    {
      Log.a("ReaderHomePageActivity", "Color is ex" + paramString1 + "=" + paramString2);
    }
    return paramInt;
  }
  
  private ArrayList<WebViewTabBarData> a(ArrayList<TabItemData> paramArrayList, @NonNull Intent paramIntent)
  {
    int j = paramArrayList.size();
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.hasExtra(Constant.jdField_b_of_type_JavaLangString)) {}
    for (paramIntent = "" + "&" + Constant.jdField_b_of_type_JavaLangString + "=" + paramIntent.getStringExtra(Constant.jdField_b_of_type_JavaLangString);; paramIntent = "")
    {
      int i = 0;
      while (i < j)
      {
        TabItemData localTabItemData = (TabItemData)paramArrayList.get(i);
        if (localTabItemData.jdField_b_of_type_Int == 0)
        {
          WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
          localWebViewTabBarData.tabIcon = localTabItemData.jdField_b_of_type_JavaLangString;
          localWebViewTabBarData.tabName = localTabItemData.jdField_a_of_type_JavaLangString;
          localWebViewTabBarData.tag = String.valueOf(localTabItemData.jdField_a_of_type_Int);
          localWebViewTabBarData.url = ((String)localTabItemData.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
          localArrayList.add(localWebViewTabBarData);
          if (localTabItemData.jdField_a_of_type_JavaUtilArrayList.size() == 2)
          {
            this.jdField_a_of_type_JavaLangString = ((String)localTabItemData.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
            this.jdField_b_of_type_JavaLangString = ((String)localTabItemData.jdField_a_of_type_JavaUtilArrayList.get(1) + paramIntent);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = new ColorNoteController(this, false, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this);
  }
  
  private static boolean a(@NonNull Intent paramIntent)
  {
    boolean bool1 = b(paramIntent);
    boolean bool2 = QRPluginManagerClient.a().a();
    int i = paramIntent.getIntExtra("redtouch_type", -1);
    boolean bool3 = Config.UserConfig.b(BaseApplicationImpl.getApplication());
    if (QLog.isColorLevel()) {
      QLog.e("ReaderHomePageActivity", 2, "-->isPluginReady:" + bool2 + ",exceed30days:" + bool1 + ",isShelf:" + bool3 + ",has red touch extra:" + paramIntent.hasExtra("redtouch_type") + ",has interval:" + paramIntent.hasExtra("login_interval") + ",isPluginReady=" + bool2);
    }
    return ((i != -1) && (i != 0)) || (bool1) || (!bool3);
  }
  
  private void b()
  {
    QueryUserIdentityTask localQueryUserIdentityTask = new QueryUserIdentityTask();
    localQueryUserIdentityTask.a(new ReaderHomePageActivity.2(this), true);
    localQueryUserIdentityTask.a();
  }
  
  private void b(@NonNull Intent paramIntent)
  {
    this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper = new ReaderTabConfigDataHelper(this);
    this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper.a();
    paramIntent.putExtra("tabConfigData", a(this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper.a(), paramIntent));
    int i = a(paramIntent);
    Log.d("ReaderHomePageActivity", "tabIndex =" + i);
    int[] arrayOfInt = this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper.a();
    StringBuilder localStringBuilder = new StringBuilder().append("itemids is null");
    if (arrayOfInt == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("ReaderHomePageActivity", bool);
      i = a(i, arrayOfInt);
      paramIntent.putExtra("key_tab_main_tab_pos", i);
      paramIntent.putExtra("tabDefaultIndex", i);
      paramIntent.putExtra("key_subtab", 0);
      paramIntent.putExtra("key_title_bar_left_tab_url", this.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("key_title_bar_right_tab_url", this.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("key_tab_color", a("tabColor", ReaderTabConfigDataHelper.jdField_a_of_type_Int, this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper.a()));
      paramIntent.putExtra("key_tab_name_color", a("tabNameDefaultColor", ReaderTabConfigDataHelper.jdField_b_of_type_Int, this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper.b()));
      paramIntent.putExtra("key_name_selected_color", a("tabNameSelectedColor", ReaderTabConfigDataHelper.c, this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper.c()));
      return;
    }
  }
  
  private static boolean b(Intent paramIntent)
  {
    return paramIntent.getLongExtra("login_interval", 0L) > 155520000000L;
  }
  
  private void c(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(new ReaderHomePageActivity.1(this, paramString1, paramString2, paramString3));
  }
  
  public ReaderTabConfigDataHelper a()
  {
    return this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper;
  }
  
  @Nullable
  public ReaderTitleBarView a()
  {
    ReaderTitleBarView localReaderTitleBarView = null;
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localReaderTitleBarView = (ReaderTitleBarView)localWebViewFragment.mSwiftTitleUI;
    }
    return localReaderTitleBarView;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.b()) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    long l1 = Config.UserConfig.a(BaseApplicationImpl.getApplication());
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Date(l1);
    Object localObject2 = new Date(l2);
    if ((getTabBarView() != null) && (((ReaderTabBarView)getTabBarView()).b()) && (Utility.a((Date)localObject1, (Date)localObject2)) && (AppNetConnInfo.isNetSupport()) && (ReaderInterfacePlugin.a().a("START_WEBVIEW_ACTIVITY_CONDITION", null)))
    {
      localObject2 = (String)ReaderUrlConfigDataHelper.a.get("qqreaderBookStoreGamepop");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "https://cdn.vip.qq.com/club/client/read/6/rel/gameAd_index.html";
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("from", 2);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      QRPluginManagerClient.a().a(this, (Intent)localObject2, "com.qqreader.pureader.WebViewActivity");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c()) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.f();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    if ((getTabBarView() instanceof ReaderTabBarView)) {
      return ((ReaderTabBarView)getTabBarView()).a();
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {
        break label29;
      }
    }
    label29:
    do
    {
      return;
      localObject = paramIntent.getParcelableArrayList("reslut_select_file_info_list");
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new ReaderFileInfo((FileInfo)((Iterator)localObject).next()));
    }
    paramIntent.remove("reslut_select_file_info_list");
    paramIntent.putParcelableArrayList("key_reader_file_for_bundle", localArrayList);
    ReaderInterfacePlugin.a().a("EVENT_IMPORT_LOCAL_BOOK", paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent2 = getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      Log.a("ReaderHomePageActivity", "[ReaderHomePageActivity] intent is null! ");
      localIntent1 = new Intent();
    }
    localIntent1.putExtra("key_enter_reader_homepage_activity_oncreate_time", System.currentTimeMillis());
    b(localIntent1);
    super.doOnCreate(paramBundle);
    b();
    a();
    Log.c("cost_time_tag", "ReaderHomePageActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    if (a()) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    a(paramIntent);
    if (paramIntent != null)
    {
      paramIntent.putExtra("key_subtab", 0);
      paramIntent.putExtra("key_title_bar_left_tab_url", this.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("key_title_bar_right_tab_url", this.jdField_b_of_type_JavaLangString);
    }
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    paramIntent = (ReaderTabBarView)getTabBarView();
    if (paramIntent != null) {
      paramIntent.setSelectedTab(a(a(getIntent()), this.jdField_a_of_type_CooperationQqreaderHelperReaderTabConfigDataHelper.a()), false);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Object localObject = (ReaderTabBarView)getTabBarView();
    if (localObject != null) {
      ((ReaderTabBarView)localObject).c();
    }
    localObject = getCurrentWebViewFragment();
    if ((localObject instanceof ReaderHomeTabFragment))
    {
      localObject = (ReaderHomeTabFragment)localObject;
      if (((ReaderHomeTabFragment)localObject).b)
      {
        localIntent = getIntent();
        if (localIntent != null)
        {
          j = localIntent.getIntExtra("key_tab_id", -1);
          i = j;
          if (j < 0) {
            i = Integer.parseInt(((ReaderHomeTabFragment)localObject).getTag());
          }
          localObject = (ReaderTitleBarView)((ReaderHomeTabFragment)localObject).mSwiftTitleUI;
          if (localObject != null) {
            ((ReaderTitleBarView)localObject).h(i);
          }
        }
      }
    }
    while (localObject == null)
    {
      Intent localIntent;
      int j;
      int i;
      return;
    }
    Log.d("ReaderHomePageActivity", "webViewFragment =" + localObject.getClass().getName());
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    BaseApplicationImpl localBaseApplicationImpl;
    if (getTabBarView() != null)
    {
      bool = ReaderInterfacePlugin.a().a("EVENT_BOOK_SHELF_IS_NOT_EMPTY", null);
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if ((!((ReaderTabBarView)getTabBarView()).a()) || (!bool)) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      Config.UserConfig.c(localBaseApplicationImpl, bool);
      return;
    }
  }
  
  public WebViewFragment getFragmentByTabBarData(WebViewTabBarData paramWebViewTabBarData)
  {
    paramWebViewTabBarData = super.getFragmentByTabBarData(paramWebViewTabBarData);
    Object localObject = paramWebViewTabBarData.getIntent();
    if (localObject != null)
    {
      int j = ((Intent)localObject).getIntExtra("key_tab_id", -1);
      int i = j;
      if (j < 0) {
        i = Integer.parseInt(paramWebViewTabBarData.getTag());
      }
      localObject = a();
      if (localObject != null) {
        ((ReaderTitleBarView)localObject).h(i);
      }
    }
    return paramWebViewTabBarData;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomePageActivity
 * JD-Core Version:    0.7.0.1
 */