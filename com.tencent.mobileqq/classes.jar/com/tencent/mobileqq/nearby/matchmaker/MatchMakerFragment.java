package com.tencent.mobileqq.nearby.matchmaker;

import anzj;
import avgj;
import aybj;
import aybs;
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
    aybj localaybj;
    do
    {
      return;
      localaybj = a().a();
    } while ((localaybj == null) || (!localaybj.a()));
    localaybj.e();
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
    this.a.a(anzj.a(2131706083)).a(new aybs(this));
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