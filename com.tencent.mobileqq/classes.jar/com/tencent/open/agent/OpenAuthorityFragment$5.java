package com.tencent.open.agent;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.qqconnect.wtlogin.Login;

class OpenAuthorityFragment$5
  implements OpenCardContainer.AccountEventListener
{
  OpenAuthorityFragment$5(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a()
  {
    Intent localIntent = new Intent(this.a.getActivity(), Login.class);
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("is_first_login", true);
    localIntent.putExtra("appid", OpenAuthorityFragment.a(this.a));
    localIntent.putExtra("param_qr_code_url", this.a.getActivity().getIntent().getStringExtra("param_qr_code_url"));
    OpenAuthorityFragment.a(this.a, null);
    this.a.getActivity().startActivityForResult(localIntent, 1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.a(paramString, paramBoolean);
  }
  
  public void b()
  {
    this.a.c(OpenAuthorityFragment.b(this.a));
    if (OpenAuthorityFragment.a(this.a) != null) {
      OpenAuthorityFragment.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.5
 * JD-Core Version:    0.7.0.1
 */