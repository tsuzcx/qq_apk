package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import bdgk;
import bdgl;
import beft;
import bhtd;
import bjae;
import bjal;
import bjar;
import bjbh;
import bjbj;
import bjbl;
import bjbo;
import bjbp;
import bjbq;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.view.ReaderTabBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class ReaderHomeTabFragment
  extends ReaderBaseFragment
  implements Handler.Callback
{
  private long jdField_a_of_type_Long = -1L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private long jdField_b_of_type_Long = -1L;
  private Handler jdField_b_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
  
  public static WebViewFragment a(Intent paramIntent)
  {
    ReaderHomeTabFragment localReaderHomeTabFragment = new ReaderHomeTabFragment();
    Bundle localBundle = new Bundle();
    paramIntent.putExtra("titleBarStyle", 3);
    localBundle.putParcelable("intent", paramIntent);
    localReaderHomeTabFragment.setArguments(localBundle);
    return localReaderHomeTabFragment;
  }
  
  private ReaderTabBarView a()
  {
    return (ReaderTabBarView)((QQBrowserActivity)getActivity()).a();
  }
  
  private void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(getActivity());
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1996488704);
        this.jdField_a_of_type_AndroidViewView.setId(2131371169);
        paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.getInt("tab") - 1;
      int j = paramJSONObject.getInt("type");
      paramJSONObject = paramJSONObject.getString("content");
      Object localObject = a();
      ((ReaderTabBarView)localObject).setTextMsg(i, paramJSONObject, ((ReaderTabBarView)localObject).a(i) + 1, true);
      localObject = getActivity();
      bjbo.a(bdgk.a((Context)localObject).a, bjbq.a((Activity)localObject), "69", "335", "", "2", "", "", "");
      bjbp.a((Context)localObject, i, j);
      bjbp.a((Context)localObject, i, paramJSONObject);
      bjbp.a((Context)localObject, i, true);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReaderHomeTabFragment", 2, "-->json error:" + paramJSONObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReaderHomeTabFragment", 2, "-->error:" + paramJSONObject.toString());
    }
  }
  
  private boolean h()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_key_is_from_force_activity", false);
    }
    return bool;
  }
  
  private boolean i()
  {
    return ChannelIdHelper.isFromLeba();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bjbh(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(bjal.c);
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private boolean j()
  {
    return ChannelIdHelper.isFromKandian();
  }
  
  private void k()
  {
    bjae localbjae = ((ReaderBaseWebActivity)getActivity()).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    if (localbjae != null) {
      localbjae.b();
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    long l4 = System.currentTimeMillis();
    String str = bdgk.a(getActivity()).a;
    long l2 = 0L;
    paramString = "click_leba_start_time=" + a().getLongExtra("key_click_leba_start_time", 0L) + ", enter_qr_bridge_activity_oncreate=" + a().getLongExtra("key_enter_qr_bridge_activity_oncreate_time", 0L) + ", qr_bridge_activity_start_activity_time=" + a().getLongExtra("key_qr_bridge_activity_start_activity_time", 0L) + ", enter_reader_homepage_activity_oncreate_time=" + a().getLongExtra("key_enter_reader_homepage_activity_oncreate_time", 0L) + ", onPageStartedTime=" + this.jdField_b_of_type_Long + ", onPageFinishedTime=" + l4 + ", onPageStartToFinishTime=" + (l4 - this.jdField_b_of_type_Long);
    long l1 = l2;
    if (getActivity().getIntent().hasExtra("isHomePageFristLaunch"))
    {
      l1 = l2;
      if (this.jdField_a_of_type_Long > 0L)
      {
        l1 = l4 - this.jdField_a_of_type_Long;
        bjbo.a(str, "8", "", 0, 0.0F, 0, l1, paramString);
      }
    }
    long l3 = 0L;
    l2 = l3;
    paramWebView = paramString;
    if (i())
    {
      l2 = l3;
      paramWebView = paramString;
      if (!h())
      {
        l2 = l3;
        paramWebView = paramString;
        if (!getActivity().getIntent().hasExtra("isHomePageFristLaunch"))
        {
          getActivity().getIntent().putExtra("isHomePageFristLaunch", false);
          long l5 = getActivity().getIntent().getLongExtra("key_click_leba_start_time", 0L);
          l2 = l3;
          paramWebView = paramString;
          if (l5 > 0L)
          {
            paramWebView = paramString + ",\\n clickDynamicStartTime=" + l5;
            l2 = l4 - l5;
            boolean bool = bjbj.a(getActivity());
            bjbl.e("ReaderHomeTabFragment", "isFristEnterHomePageFromLeba =" + bool);
            if (!bool) {
              break label450;
            }
            bjbj.a(getActivity(), false);
            bjbo.a(str, "7", "", 0, 0.0F, 0, l2, paramWebView);
          }
        }
      }
    }
    for (;;)
    {
      bjbl.e("ReaderHomeTabFragment", "onPageFinished ,fristSwitchTabPageTime=" + l1 + ", homePageFristLaunchTime=" + l2 + ",repoertExtraInfo=" + paramWebView);
      return;
      label450:
      bjbo.a(str, "9", "", 0, 0.0F, 0, l2, paramWebView);
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  protected boolean a(Message paramMessage)
  {
    boolean bool = super.a(paramMessage);
    if (!bool) {}
    switch (paramMessage.what)
    {
    default: 
      return bool;
    }
    b((JSONObject)paramMessage.obj);
    return true;
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    paramBundle = (ReaderHomePageActivity)getActivity();
    ReaderTabBarView localReaderTabBarView = a();
    if (!paramBundle.b())
    {
      if ((localReaderTabBarView != null) && (localReaderTabBarView.getParent() != null))
      {
        boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        a((ViewGroup)localReaderTabBarView.getParent(), bool);
        paramBundle.a(true);
      }
    }
    else {
      return i;
    }
    bjbl.a("ReaderHomeTabFragment", "tabBarView  is null or  tabBarView.getParent() is null");
    return i;
  }
  
  public void e()
  {
    a(this.jdField_b_of_type_AndroidOsHandler);
    super.e();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setMask(false);
  }
  
  protected boolean g()
  {
    if (j()) {
      return false;
    }
    return super.g();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetImageView) {
      k();
    }
    Activity localActivity;
    do
    {
      return;
      if (paramView != this.jdField_a_of_type_Beft.jdField_a_of_type_AndroidWidgetTextView) {
        break;
      }
      localActivity = a();
    } while ((!(localActivity instanceof ReaderHomePageActivity)) || (((ReaderHomePageActivity)localActivity).a()));
    super.onClick(paramView);
    return;
    super.onClick(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
    j();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bjbl.e("ReaderHomeTabFragment", "onCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onResume()
  {
    super.onResume();
    ReaderTabBarView localReaderTabBarView = a();
    if ((localReaderTabBarView != null) && (localReaderTabBarView.b())) {
      bjar.a().a("EVENT_PRE_FETCH_GAME_AD_DATA_AND_GET_READ_RECORD", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomeTabFragment
 * JD-Core Version:    0.7.0.1
 */