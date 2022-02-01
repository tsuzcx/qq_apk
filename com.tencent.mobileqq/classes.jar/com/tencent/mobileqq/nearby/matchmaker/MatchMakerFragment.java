package com.tencent.mobileqq.nearby.matchmaker;

import android.graphics.Bitmap;
import android.os.Bundle;
import anvx;
import auyp;
import axns;
import axut;
import axvc;
import aymp;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class MatchMakerFragment
  extends CommonTabFragment
{
  private long a;
  private long b;
  private boolean d;
  
  private void g()
  {
    if (a() == null) {}
    axut localaxut;
    do
    {
      return;
      localaxut = a().a();
    } while ((localaxut == null) || (!localaxut.a()));
    localaxut.e();
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.d = true;
    if (b()) {
      g();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MatchMakerFragment", 2, "onPageFinished: isVisible=" + isVisible());
    }
    if (!"about:blank".equals(paramString))
    {
      new aymp().b("nearby_hongniang").c("page_load_end").a(System.currentTimeMillis() - this.b).d(String.valueOf(isDetached())).a(a().getCurrentAccountUin()).a();
      this.b = System.currentTimeMillis();
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    QLog.d("MatchMakerFragment", 2, "onPageStarted: url=" + paramString);
    this.b = System.currentTimeMillis();
    if (!"about:blank".equals(paramString)) {
      new aymp().b("nearby_hongniang").c("page_load_start").g(String.valueOf(this.b - this.jdField_a_of_type_Long)).a(a().getCurrentAccountUin()).a();
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Auyp.a(anvx.a(2131706665)).a(new axvc(this));
    this.jdField_a_of_type_Auyp.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("MatchMakerFragment", 2, "onPageStarted: onCreate");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    new aymp().b("nearby_hongniang").c("tab_page_create").a(a().getCurrentAccountUin()).a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    new aymp().b("nearby_hongniang").c("tab_page_destroy").a(a().getCurrentAccountUin()).g(String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long)).d(String.valueOf(this.d)).e(String.valueOf(System.currentTimeMillis() - this.b)).f(String.valueOf(axns.a())).a();
  }
  
  public void onPause()
  {
    super.onPause();
    if (b()) {
      g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment
 * JD-Core Version:    0.7.0.1
 */