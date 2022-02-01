package cooperation.qqreader.ui;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import aqnr;
import bmef;
import bmfa;
import bmfd;
import bmfo;
import bmfp;
import bmfu;
import bmgg;
import bmgh;
import bmgk;
import bmgm;
import bmgq;
import bmgr;
import bmgx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.host.filemanager.ReaderFileInfo;
import cooperation.qqreader.net.QueryUserIdentityTask;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class ReaderHomePageActivity
  extends ReaderBaseWebActivity
{
  private bmfa jdField_a_of_type_Bmfa;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private aqnr jdField_b_of_type_Aqnr;
  private String jdField_b_of_type_JavaLangString;
  
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
    if (paramIntent.hasExtra(bmfo.jdField_a_of_type_JavaLangString)) {
      i = paramIntent.getIntExtra(bmfo.jdField_a_of_type_JavaLangString, 1);
    }
    for (;;)
    {
      return i;
      i = k;
      if (!paramIntent.getBooleanExtra("is_from_qreader_shortcut", false))
      {
        i = k;
        if (!bmgk.e(BaseApplicationImpl.getApplication()))
        {
          boolean bool1 = bmgq.a(BaseApplicationImpl.getApplication());
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
      bmgm.a("ReaderHomePageActivity", "Color is ex" + paramString1 + "=" + paramString2);
    }
    return paramInt;
  }
  
  private ArrayList<WebViewTabBarData> a(ArrayList<bmfp> paramArrayList, @NonNull Intent paramIntent)
  {
    int j = paramArrayList.size();
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.hasExtra(bmfo.jdField_b_of_type_JavaLangString)) {}
    for (paramIntent = "" + "&" + bmfo.jdField_b_of_type_JavaLangString + "=" + paramIntent.getStringExtra(bmfo.jdField_b_of_type_JavaLangString);; paramIntent = "")
    {
      int i = 0;
      while (i < j)
      {
        bmfp localbmfp = (bmfp)paramArrayList.get(i);
        if (localbmfp.jdField_b_of_type_Int == 0)
        {
          WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
          localWebViewTabBarData.tabIcon = localbmfp.jdField_b_of_type_JavaLangString;
          localWebViewTabBarData.tabName = localbmfp.jdField_a_of_type_JavaLangString;
          localWebViewTabBarData.tag = String.valueOf(localbmfp.jdField_a_of_type_Int);
          localWebViewTabBarData.url = ((String)localbmfp.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
          localArrayList.add(localWebViewTabBarData);
          if (localbmfp.jdField_a_of_type_JavaUtilArrayList.size() == 2)
          {
            this.jdField_a_of_type_JavaLangString = ((String)localbmfp.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
            this.jdField_b_of_type_JavaLangString = ((String)localbmfp.jdField_a_of_type_JavaUtilArrayList.get(1) + paramIntent);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private void a()
  {
    this.jdField_b_of_type_Aqnr = new aqnr(this, false, true);
    this.jdField_b_of_type_Aqnr.a(this);
  }
  
  private static boolean a(@NonNull Intent paramIntent)
  {
    boolean bool1 = b(paramIntent);
    boolean bool2 = bmef.a().a();
    int i = paramIntent.getIntExtra("redtouch_type", -1);
    boolean bool3 = bmgk.b(BaseApplicationImpl.getApplication());
    if (QLog.isColorLevel()) {
      QLog.e("ReaderHomePageActivity", 2, "-->isPluginReady:" + bool2 + ",exceed30days:" + bool1 + ",isShelf:" + bool3 + ",has red touch extra:" + paramIntent.hasExtra("redtouch_type") + ",has interval:" + paramIntent.hasExtra("login_interval") + ",isPluginReady=" + bool2);
    }
    return ((i != -1) && (i != 0)) || (bool1) || (!bool3);
  }
  
  private void b()
  {
    QueryUserIdentityTask localQueryUserIdentityTask = new QueryUserIdentityTask();
    localQueryUserIdentityTask.a(new bmgh(this), true);
    localQueryUserIdentityTask.a();
  }
  
  private void b(@NonNull Intent paramIntent)
  {
    this.jdField_a_of_type_Bmfa = new bmfa(this);
    this.jdField_a_of_type_Bmfa.a();
    paramIntent.putExtra("tabConfigData", a(this.jdField_a_of_type_Bmfa.a(), paramIntent));
    int i = a(paramIntent);
    bmgm.d("ReaderHomePageActivity", "tabIndex =" + i);
    int[] arrayOfInt = this.jdField_a_of_type_Bmfa.a();
    StringBuilder localStringBuilder = new StringBuilder().append("itemids is null");
    if (arrayOfInt == null) {}
    for (boolean bool = true;; bool = false)
    {
      bmgm.d("ReaderHomePageActivity", bool);
      i = a(i, arrayOfInt);
      paramIntent.putExtra("key_tab_main_tab_pos", i);
      paramIntent.putExtra("tabDefaultIndex", i);
      paramIntent.putExtra("key_subtab", 0);
      paramIntent.putExtra("key_title_bar_left_tab_url", this.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("key_title_bar_right_tab_url", this.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("key_tab_color", a("tabColor", bmfa.jdField_a_of_type_Int, this.jdField_a_of_type_Bmfa.a()));
      paramIntent.putExtra("key_tab_name_color", a("tabNameDefaultColor", bmfa.jdField_b_of_type_Int, this.jdField_a_of_type_Bmfa.b()));
      paramIntent.putExtra("key_name_selected_color", a("tabNameSelectedColor", bmfa.c, this.jdField_a_of_type_Bmfa.c()));
      return;
    }
  }
  
  private static boolean b(Intent paramIntent)
  {
    return paramIntent.getLongExtra("login_interval", 0L) > 155520000000L;
  }
  
  private void c(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Aqnr.a(new bmgg(this, paramString1, paramString2, paramString3));
  }
  
  public bmfa a()
  {
    return this.jdField_a_of_type_Bmfa;
  }
  
  @Nullable
  public bmgx a()
  {
    bmgx localbmgx = null;
    WebViewFragment localWebViewFragment = a();
    if (localWebViewFragment != null) {
      localbmgx = (bmgx)localWebViewFragment.mSwiftTitleUI;
    }
    return localbmgx;
  }
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    paramWebViewTabBarData = super.a(paramWebViewTabBarData);
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
        ((bmgx)localObject).a(i);
      }
    }
    return paramWebViewTabBarData;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Aqnr.b()) {
      this.jdField_b_of_type_Aqnr.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    long l1 = bmgk.a(BaseApplicationImpl.getApplication());
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Date(l1);
    Object localObject2 = new Date(l2);
    if ((a() != null) && (((ReaderTabBarView)a()).b()) && (bmgr.a((Date)localObject1, (Date)localObject2)) && (AppNetConnInfo.isNetSupport()) && (bmfu.a().a("START_WEBVIEW_ACTIVITY_CONDITION", null)))
    {
      localObject2 = (String)bmfd.a.get("qqreaderBookStoreGamepop");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "https://cdn.vip.qq.com/club/client/read/6/rel/gameAd_index.html";
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("from", 2);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      bmef.a().a(this, (Intent)localObject2, "com.qqreader.pureader.WebViewActivity");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    return this.jdField_b_of_type_Aqnr.c();
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Aqnr.c()) {
      this.jdField_b_of_type_Aqnr.f();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    if ((a() instanceof ReaderTabBarView)) {
      return ((ReaderTabBarView)a()).a();
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
    bmfu.a().a("EVENT_IMPORT_LOCAL_BOOK", paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent2 = getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      bmgm.a("ReaderHomePageActivity", "[ReaderHomePageActivity] intent is null! ");
      localIntent1 = new Intent();
    }
    localIntent1.putExtra("key_enter_reader_homepage_activity_oncreate_time", System.currentTimeMillis());
    b(localIntent1);
    super.doOnCreate(paramBundle);
    b();
    a();
    bmgm.c("cost_time_tag", "ReaderHomePageActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_Aqnr.c();
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
    paramIntent = (ReaderTabBarView)a();
    if (paramIntent != null) {
      paramIntent.setSelectedTab(a(a(getIntent()), this.jdField_a_of_type_Bmfa.a()), false);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Object localObject = (ReaderTabBarView)a();
    if (localObject != null) {
      ((ReaderTabBarView)localObject).c();
    }
    localObject = a();
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
          localObject = (bmgx)((ReaderHomeTabFragment)localObject).mSwiftTitleUI;
          if (localObject != null) {
            ((bmgx)localObject).a(i);
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
    bmgm.d("ReaderHomePageActivity", "webViewFragment =" + localObject.getClass().getName());
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    BaseApplicationImpl localBaseApplicationImpl;
    if (a() != null)
    {
      bool = bmfu.a().a("EVENT_BOOK_SHELF_IS_NOT_EMPTY", null);
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if ((!((ReaderTabBarView)a()).a()) || (!bool)) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      bmgk.c(localBaseApplicationImpl, bool);
      return;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomePageActivity
 * JD-Core Version:    0.7.0.1
 */