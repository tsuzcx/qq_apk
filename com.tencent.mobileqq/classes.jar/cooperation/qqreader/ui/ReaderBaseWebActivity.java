package cooperation.qqreader.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import bizv;
import bjaa;
import bjae;
import bjat;
import bjbl;
import bjbq;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;

public class ReaderBaseWebActivity
  extends QQBrowserActivity
{
  private static boolean jdField_a_of_type_Boolean;
  private bjae jdField_a_of_type_Bjae;
  
  private void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      bjbq.a(this);
      ChannelIdHelper.initChannelId(getIntent());
      if ((!bjbq.jdField_a_of_type_Boolean) && (!"Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL)))
      {
        bjbl.d("WebLog_QQBrowserActivity", "HardAcc true");
        getWindow().addFlags(16777216);
      }
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        QRDebugEnvUrlUtils.initTestEnv(this);
      }
      bjbq.a(this);
    }
  }
  
  @Nullable
  public bjae a(TouchWebView paramTouchWebView)
  {
    if ((this.jdField_a_of_type_Bjae == null) && (paramTouchWebView != null) && (paramTouchWebView.getPluginEngine() != null))
    {
      paramTouchWebView = paramTouchWebView.getPluginEngine();
      if (paramTouchWebView != null)
      {
        paramTouchWebView = paramTouchWebView.a(207, true);
        if ((paramTouchWebView instanceof bjae)) {
          this.jdField_a_of_type_Bjae = ((bjae)paramTouchWebView);
        }
      }
    }
    return this.jdField_a_of_type_Bjae;
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      bjbl.a("WebLog_QQBrowserActivity", "[putReaderExtra] intent = null");
      return;
    }
    paramIntent.putExtra("fragmentStyle", 4);
    paramIntent.putExtra("tabBarStyle", 2);
    paramIntent.putExtra("titleBarStyle", 3);
    paramIntent.putExtra("hide_more_button", true);
    paramIntent.putExtra("isScreenOrientationPortrait", true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    g();
    a();
    if (!bizv.a())
    {
      paramBundle = new Intent(this, ForceUserUpdateActivity.class);
      paramBundle.putExtra("origin_intent", getIntent());
      paramBundle.putExtra("key_click_leba_start_time", getIntent().getLongExtra("key_click_leba_start_time", 0L));
      startActivity(paramBundle);
      finish();
      return true;
    }
    super.doOnCreate(paramBundle);
    new bjaa(this).a();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a(getIntent());
    bjat.a(this, true);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseWebActivity
 * JD-Core Version:    0.7.0.1
 */