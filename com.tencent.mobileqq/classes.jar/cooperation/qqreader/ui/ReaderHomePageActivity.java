package cooperation.qqreader.ui;

import alrv;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import bflv;
import bfme;
import bfmf;
import bfmk;
import bfmy;
import bfmz;
import bfnc;
import bfne;
import bfng;
import bfnl;
import bfnu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.net.QueryUserIdentityTask;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.ArrayList;

public class ReaderHomePageActivity
  extends ReaderBaseWebActivity
{
  private bflv jdField_a_of_type_Bflv;
  private bfng jdField_a_of_type_Bfng;
  public boolean a;
  private alrv jdField_b_of_type_Alrv;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public ReaderHomePageActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
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
    if (paramIntent.hasExtra(bfme.jdField_a_of_type_JavaLangString)) {
      i = paramIntent.getIntExtra(bfme.jdField_a_of_type_JavaLangString, 1);
    }
    do
    {
      do
      {
        return i;
        i = k;
      } while (paramIntent.getBooleanExtra("is_from_qreader_shortcut", false));
      i = k;
    } while (bfnc.d(BaseApplicationImpl.getApplication()));
    if ((bfnl.a(BaseApplicationImpl.getApplication())) && (a(paramIntent))) {
      return 0;
    }
    if (paramIntent.getIntExtra("redtouch_type", -1) == 0) {}
    for (int i = j;; i = 1) {
      return i;
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
      bfne.a("ReaderHomePageActivity", "Color is ex" + paramString1 + "=" + paramString2);
    }
    return paramInt;
  }
  
  private ArrayList<WebViewTabBarData> a(ArrayList<bfmf> paramArrayList, @NonNull Intent paramIntent)
  {
    int j = paramArrayList.size();
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.hasExtra(bfme.jdField_b_of_type_JavaLangString)) {}
    for (paramIntent = "" + "&" + bfme.jdField_b_of_type_JavaLangString + "=" + paramIntent.getStringExtra(bfme.jdField_b_of_type_JavaLangString);; paramIntent = "")
    {
      int i = 0;
      while (i < j)
      {
        bfmf localbfmf = (bfmf)paramArrayList.get(i);
        if (localbfmf.jdField_b_of_type_Int == 0)
        {
          WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
          localWebViewTabBarData.tabIcon = localbfmf.jdField_b_of_type_JavaLangString;
          localWebViewTabBarData.tabName = localbfmf.jdField_a_of_type_JavaLangString;
          localWebViewTabBarData.tag = String.valueOf(localbfmf.jdField_a_of_type_Int);
          localWebViewTabBarData.url = ((String)localbfmf.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
          localArrayList.add(localWebViewTabBarData);
          if (localbfmf.jdField_a_of_type_JavaUtilArrayList.size() == 2)
          {
            this.jdField_b_of_type_JavaLangString = ((String)localbfmf.jdField_a_of_type_JavaUtilArrayList.get(0) + paramIntent);
            this.c = ((String)localbfmf.jdField_a_of_type_JavaUtilArrayList.get(1) + paramIntent);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private void a()
  {
    this.jdField_b_of_type_Alrv = new alrv(this, false, true);
    this.jdField_b_of_type_Alrv.a(this);
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("key_is_from_splash_activity", false)) {
      this.jdField_a_of_type_Bfng.a(paramIntent);
    }
  }
  
  private static boolean a(@NonNull Intent paramIntent)
  {
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if (paramIntent.getIntExtra("redtouch_type", -1) == -1)
    {
      bool1 = true;
      bool3 = b(paramIntent);
      bool4 = QRBridgeUtil.isPluginReady();
      if (new bfmk().a("EVENT_BOOK_SHELF_IS_NOT_EMPTY", null)) {
        break label147;
      }
    }
    label147:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReaderHomePageActivity", 2, "-->noRedTouch:" + bool1 + ",exceed30days:" + bool3 + ",shelfEmpty:" + bool2 + ",has red touch extra:" + paramIntent.hasExtra("redtouch_type") + ",has interval:" + paramIntent.hasExtra("login_interval") + ",isPluginReady=" + bool4);
      }
      if ((!bool1) || (bool3) || (bool2)) {
        break label152;
      }
      return true;
      bool1 = false;
      break;
    }
    label152:
    return false;
  }
  
  private void b()
  {
    QueryUserIdentityTask localQueryUserIdentityTask = new QueryUserIdentityTask();
    localQueryUserIdentityTask.a(new bfmz(this), true);
    localQueryUserIdentityTask.a();
  }
  
  private void b(@NonNull Intent paramIntent)
  {
    this.jdField_a_of_type_Bflv = new bflv(this);
    this.jdField_a_of_type_Bflv.a();
    paramIntent.putExtra("tabConfigData", a(this.jdField_a_of_type_Bflv.a(), paramIntent));
    int i = a(paramIntent);
    bfne.c("ReaderHomePageActivity", "tabIndex =" + i);
    int[] arrayOfInt = this.jdField_a_of_type_Bflv.a();
    StringBuilder localStringBuilder = new StringBuilder().append("itemids is null");
    if (arrayOfInt == null) {}
    for (boolean bool = true;; bool = false)
    {
      bfne.c("ReaderHomePageActivity", bool);
      i = a(i, arrayOfInt);
      paramIntent.putExtra("key_tab_main_tab_pos", i);
      paramIntent.putExtra("tabDefaultIndex", i);
      paramIntent.putExtra("key_subtab", 0);
      paramIntent.putExtra("key_title_bar_left_tab_url", this.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("key_title_bar_right_tab_url", this.c);
      paramIntent.putExtra("key_tab_item_ids", arrayOfInt);
      paramIntent.putExtra("key_report_tab_page_ids", this.jdField_a_of_type_Bflv.b());
      paramIntent.putExtra("key_report_tab_module_ids", this.jdField_a_of_type_Bflv.c());
      paramIntent.putExtra("key_tab_icon_selected_urls", this.jdField_a_of_type_Bflv.a());
      paramIntent.putExtra("key_tab_color", a("tabColor", Color.parseColor("#FDFDFD"), this.jdField_a_of_type_Bflv.a()));
      paramIntent.putExtra("key_tab_name_color", a("tabNameDefaultColor", Color.parseColor("#666666"), this.jdField_a_of_type_Bflv.b()));
      paramIntent.putExtra("key_name_selected_color", a("tabNameSelectedColor", Color.parseColor("#E0AC00"), this.jdField_a_of_type_Bflv.c()));
      return;
    }
  }
  
  private static boolean b(Intent paramIntent)
  {
    return paramIntent.getLongExtra("login_interval", 0L) > 155520000000L;
  }
  
  private void c(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Alrv.a(new bfmy(this, paramString1, paramString2, paramString3));
  }
  
  @Nullable
  public bfnu a()
  {
    bfnu localbfnu = null;
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localbfnu = (bfnu)localWebViewFragment.a;
    }
    return localbfnu;
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
        ((bfnu)localObject).h(i);
      }
    }
    return paramWebViewTabBarData;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Alrv.b()) {
      this.jdField_b_of_type_Alrv.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    return this.jdField_b_of_type_Alrv.c();
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    c(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Alrv.c()) {
      this.jdField_b_of_type_Alrv.f();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    FrameLayout localFrameLayout = a();
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localFrameLayout.setVisibility(i);
      a(paramBoolean);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent2 = getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null) {
      localIntent1 = new Intent();
    }
    localIntent1.putExtra("key_enter_reader_homepage_activity_oncreate_time", System.currentTimeMillis());
    b(localIntent1);
    super.doOnCreate(paramBundle);
    b();
    a();
    bfne.d("cost_time_tag", "ReaderHomePageActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
    this.jdField_a_of_type_Bfng = new bfng(this);
    this.jdField_a_of_type_Bfng.a();
    a(localIntent1);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_Alrv.c();
    this.jdField_a_of_type_Bfng.b();
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    Intent localIntent = getIntent();
    paramIntent = localIntent;
    if (localIntent == null) {
      paramIntent = new Intent();
    }
    paramIntent.putExtra("key_keep_reader_home_activity", true);
    a(paramIntent);
    paramIntent = (ReaderTabBarView)a();
    if (paramIntent != null) {
      paramIntent.setSelectedTab(a(a(getIntent()), this.jdField_a_of_type_Bflv.a()), false);
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
      if (((ReaderHomeTabFragment)localObject).jdField_b_of_type_Boolean)
      {
        localIntent = getIntent();
        if (localIntent != null)
        {
          j = localIntent.getIntExtra("key_tab_id", -1);
          i = j;
          if (j < 0) {
            i = Integer.parseInt(((ReaderHomeTabFragment)localObject).getTag());
          }
          localObject = (bfnu)((ReaderHomeTabFragment)localObject).a;
          if (localObject != null) {
            ((bfnu)localObject).h(i);
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
    bfne.c("ReaderHomePageActivity", "webViewFragment =" + localObject.getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomePageActivity
 * JD-Core Version:    0.7.0.1
 */