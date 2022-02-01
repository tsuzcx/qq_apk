package com.tencent.mobileqq.nearby.matchmaker;

import amtj;
import attp;
import awor;
import awpa;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class MatchMakerFragment
  extends CommonTabFragment
{
  private void g()
  {
    if (a() == null) {}
    awor localawor;
    do
    {
      return;
      localawor = a().a();
    } while ((localawor == null) || (!localawor.a()));
    localawor.e();
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    if (b()) {
      g();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MatchMakerFragment", 2, "onPageFinished: isVisible=" + isVisible());
    }
  }
  
  protected void f()
  {
    this.a.a(amtj.a(2131706313)).a(new awpa(this));
    this.a.a();
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