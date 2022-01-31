package cooperation.qqreader.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import bflt;
import bfly;
import bfmb;
import bfmm;
import bfne;
import bfnm;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;

public class ReaderBaseWebActivity
  extends QQBrowserActivity
{
  public static String a;
  private static boolean jdField_a_of_type_Boolean;
  private bfmb jdField_a_of_type_Bfmb;
  
  static
  {
    jdField_a_of_type_JavaLangString = "-1";
  }
  
  private void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      bfnm.a(this);
      if ("-1".equals(jdField_a_of_type_JavaLangString))
      {
        Bundle localBundle = getIntent().getExtras();
        if (localBundle != null) {
          jdField_a_of_type_JavaLangString = localBundle.getString("ChannelID");
        }
      }
      if ((!bfnm.jdField_a_of_type_Boolean) && (!"Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL)))
      {
        bfne.c("WebLog_QQBrowserActivity", "HardAcc true");
        getWindow().addFlags(16777216);
      }
      if (QRDebugEnvUrlUtils.isDebugEnv()) {
        QRDebugEnvUrlUtils.initTestEnv(this);
      }
      bfnm.a(this);
    }
  }
  
  @Nullable
  public bfmb a(TouchWebView paramTouchWebView)
  {
    if ((this.jdField_a_of_type_Bfmb == null) && (paramTouchWebView != null) && (paramTouchWebView.getPluginEngine() != null))
    {
      paramTouchWebView = paramTouchWebView.getPluginEngine();
      if (paramTouchWebView != null)
      {
        paramTouchWebView = paramTouchWebView.a(207, true);
        if ((paramTouchWebView instanceof bfmb)) {
          this.jdField_a_of_type_Bfmb = ((bfmb)paramTouchWebView);
        }
      }
    }
    return this.jdField_a_of_type_Bfmb;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    a();
    if (!bflt.a())
    {
      paramBundle = new Intent(this, ForceUserUpdateActivity.class);
      paramBundle.putExtra("origin_intent", getIntent());
      paramBundle.putExtra("key_click_leba_start_time", getIntent().getLongExtra("key_click_leba_start_time", 0L));
      startActivity(paramBundle);
      finish();
      return true;
    }
    super.doOnCreate(paramBundle);
    new bfly(this).a();
    return true;
  }
  
  public void e() {}
  
  public void onCreate(Bundle paramBundle)
  {
    bfmm.a(this, true);
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseWebActivity
 * JD-Core Version:    0.7.0.1
 */