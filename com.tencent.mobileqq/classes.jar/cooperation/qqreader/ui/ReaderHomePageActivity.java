package cooperation.qqreader.ui;

import amgn;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import bgtw;
import bgur;
import bguu;
import bgvf;
import bgvg;
import bgvl;
import bgvz;
import bgwa;
import bgwd;
import bgwf;
import bgwj;
import bgwk;
import bgws;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
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
  private bgur jdField_a_of_type_Bgur;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private amgn jdField_b_of_type_Amgn;
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
    if (paramIntent.hasExtra(bgvf.jdField_a_of_type_JavaLangString)) {
      i = paramIntent.getIntExtra(bgvf.jdField_a_of_type_JavaLangString, 1);
    }
    for (;;)
    {
      return i;
      i = k;
      if (!paramIntent.getBooleanExtra("is_from_qreader_shortcut", false))
      {
        i = k;
        if (!bgwd.e(BaseApplicationImpl.getApplication()))
        {
          boolean bool1 = bgwj.a(BaseApplicationImpl.getApplication());
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
      bgwf.a("ReaderHomePageActivity", "Color is ex" + paramString1 + "=" + paramString2);
    }
    return paramInt;
  }
  
  private ArrayList<WebViewTabBarData> a(ArrayList<bgvg> paramArrayList, @NonNull Intent paramIntent)
  {
    int j = paramArrayList.size();
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.hasExtra(bgvf.jdField_b_of_type_JavaLangString)) {}
    for (paramIntent = "" + "&" + bgvf.jdField_b_of_type_JavaLangString + "=" + paramIntent.getStringExtra(bgvf.jdField_b_of_type_JavaLangString);; paramIntent = "")
    {
      int i = 0;
      while (i < j)
      {
        bgvg localbgvg = (bgvg)paramArrayList.get(i);
        if (localbgvg.jdField_b_of_type_Int == 0)
        {
          WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
          localWebViewTabBarData.tabIcon = localbgvg.jdField_b_of_type_JavaLangString;
          localWebViewTabBarData.tabName = localbgvg.jdField_a_of_type_JavaLangString;
          localWebViewTabBarData.tag = String.valueOf(localbgvg.jdField_a_of_type_Int);
          localWebViewTabBarData.url = ((String)localbgvg.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
          localArrayList.add(localWebViewTabBarData);
          if (localbgvg.jdField_a_of_type_JavaUtilArrayList.size() == 2)
          {
            this.jdField_a_of_type_JavaLangString = ((String)localbgvg.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
            this.jdField_b_of_type_JavaLangString = ((String)localbgvg.jdField_a_of_type_JavaUtilArrayList.get(1) + paramIntent);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private void a()
  {
    this.jdField_b_of_type_Amgn = new amgn(this, false, true);
    this.jdField_b_of_type_Amgn.a(this);
  }
  
  private static boolean a(@NonNull Intent paramIntent)
  {
    boolean bool1 = b(paramIntent);
    boolean bool2 = bgtw.a().a();
    int i = paramIntent.getIntExtra("redtouch_type", -1);
    boolean bool3 = bgwd.b(BaseApplicationImpl.getApplication());
    if (QLog.isColorLevel()) {
      QLog.e("ReaderHomePageActivity", 2, "-->isPluginReady:" + bool2 + ",exceed30days:" + bool1 + ",isShelf:" + bool3 + ",has red touch extra:" + paramIntent.hasExtra("redtouch_type") + ",has interval:" + paramIntent.hasExtra("login_interval") + ",isPluginReady=" + bool2);
    }
    return ((i != -1) && (i != 0)) || (bool1) || (!bool3);
  }
  
  private void b()
  {
    QueryUserIdentityTask localQueryUserIdentityTask = new QueryUserIdentityTask();
    localQueryUserIdentityTask.a(new bgwa(this), true);
    localQueryUserIdentityTask.a();
  }
  
  private void b(@NonNull Intent paramIntent)
  {
    this.jdField_a_of_type_Bgur = new bgur(this);
    this.jdField_a_of_type_Bgur.a();
    paramIntent.putExtra("tabConfigData", a(this.jdField_a_of_type_Bgur.a(), paramIntent));
    int i = a(paramIntent);
    bgwf.d("ReaderHomePageActivity", "tabIndex =" + i);
    int[] arrayOfInt = this.jdField_a_of_type_Bgur.a();
    StringBuilder localStringBuilder = new StringBuilder().append("itemids is null");
    if (arrayOfInt == null) {}
    for (boolean bool = true;; bool = false)
    {
      bgwf.d("ReaderHomePageActivity", bool);
      i = a(i, arrayOfInt);
      paramIntent.putExtra("key_tab_main_tab_pos", i);
      paramIntent.putExtra("tabDefaultIndex", i);
      paramIntent.putExtra("key_subtab", 0);
      paramIntent.putExtra("key_title_bar_left_tab_url", this.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("key_title_bar_right_tab_url", this.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("key_tab_color", a("tabColor", bgur.jdField_a_of_type_Int, this.jdField_a_of_type_Bgur.a()));
      paramIntent.putExtra("key_tab_name_color", a("tabNameDefaultColor", bgur.jdField_b_of_type_Int, this.jdField_a_of_type_Bgur.b()));
      paramIntent.putExtra("key_name_selected_color", a("tabNameSelectedColor", bgur.c, this.jdField_a_of_type_Bgur.c()));
      return;
    }
  }
  
  private static boolean b(Intent paramIntent)
  {
    return paramIntent.getLongExtra("login_interval", 0L) > 155520000000L;
  }
  
  private void c(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Amgn.a(new bgvz(this, paramString1, paramString2, paramString3));
  }
  
  public bgur a()
  {
    return this.jdField_a_of_type_Bgur;
  }
  
  @Nullable
  public bgws a()
  {
    bgws localbgws = null;
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localbgws = (bgws)localWebViewFragment.a;
    }
    return localbgws;
  }
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    paramWebViewTabBarData = super.a(paramWebViewTabBarData);
    Object localObject = paramWebViewTabBarData.a();
    if (localObject != null)
    {
      int j = ((Intent)localObject).getIntExtra("key_tab_id", -1);
      int i = j;
      if (j < 0) {
        i = Integer.parseInt(paramWebViewTabBarData.getTag());
      }
      localObject = a();
      if (localObject != null) {
        ((bgws)localObject).h(i);
      }
    }
    return paramWebViewTabBarData;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Amgn.b()) {
      this.jdField_b_of_type_Amgn.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    long l1 = bgwd.a(BaseApplicationImpl.getApplication());
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Date(l1);
    Object localObject2 = new Date(l2);
    if ((a() != null) && (((ReaderTabBarView)a()).b()) && (bgwk.a((Date)localObject1, (Date)localObject2)) && (AppNetConnInfo.isNetSupport()) && (bgvl.a().a("START_WEBVIEW_ACTIVITY_CONDITION", null)))
    {
      localObject2 = (String)bguu.a.get("qqreaderBookStoreGamepop");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "https://cdn.vip.qq.com/club/client/read/6/rel/gameAd_index.html";
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("from", 2);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      bgtw.a().a(this, (Intent)localObject2, "com.qqreader.pureader.WebViewActivity");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    return this.jdField_b_of_type_Amgn.c();
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Amgn.c()) {
      this.jdField_b_of_type_Amgn.f();
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
    bgvl.a().a("EVENT_IMPORT_LOCAL_BOOK", paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent2 = getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      bgwf.a("ReaderHomePageActivity", "[ReaderHomePageActivity] intent is null! ");
      localIntent1 = new Intent();
    }
    localIntent1.putExtra("key_enter_reader_homepage_activity_oncreate_time", System.currentTimeMillis());
    b(localIntent1);
    super.doOnCreate(paramBundle);
    b();
    a();
    bgwf.c("cost_time_tag", "ReaderHomePageActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_Amgn.c();
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
      paramIntent.setSelectedTab(a(a(getIntent()), this.jdField_a_of_type_Bgur.a()), false);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Object localObject = (ReaderTabBarView)a();
    if (localObject != null) {
      ((ReaderTabBarView)localObject).c();
    }
    localObject = b();
    if ((localObject instanceof ReaderHomeTabFragment))
    {
      localObject = (ReaderHomeTabFragment)localObject;
      if (((ReaderHomeTabFragment)localObject).b)
      {
        Intent localIntent = getIntent();
        if (localIntent != null)
        {
          int j = localIntent.getIntExtra("key_tab_id", -1);
          int i = j;
          if (j < 0) {
            i = Integer.parseInt(((ReaderHomeTabFragment)localObject).getTag());
          }
          localObject = (bgws)((ReaderHomeTabFragment)localObject).a;
          if (localObject != null) {
            ((bgws)localObject).h(i);
          }
        }
      }
    }
    for (;;)
    {
      bgvl.a().a("EVENT_PRE_FETCH_GAME_AD_DATA_AND_GET_READ_RECORD", null);
      return;
      if (localObject != null) {
        bgwf.d("ReaderHomePageActivity", "webViewFragment =" + localObject.getClass().getName());
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    BaseApplicationImpl localBaseApplicationImpl;
    if (a() != null)
    {
      bool = bgvl.a().a("EVENT_BOOK_SHELF_IS_NOT_EMPTY", null);
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if ((!((ReaderTabBarView)a()).a()) || (!bool)) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      bgwd.c(localBaseApplicationImpl, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomePageActivity
 * JD-Core Version:    0.7.0.1
 */