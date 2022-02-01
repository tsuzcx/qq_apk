package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;

public class BaseNewFriendView
  extends FrameLayout
{
  public BaseNewFriendView.INewFriendContext a;
  protected AppInterface b;
  protected Intent c;
  private boolean d;
  private boolean e = false;
  
  public BaseNewFriendView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a()
  {
    this.e = false;
    if (!g()) {
      this.a.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getForwardSelectionRequest() == paramInt1) && (paramInt2 != 0))
    {
      this.a.getActivity().setResult(paramInt2, paramIntent);
      h();
    }
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    this.c = paramIntent;
    this.a = paramINewFriendContext;
    this.b = ((AppInterface)this.a.b());
  }
  
  public void b()
  {
    this.d = false;
    if (this.e)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    a();
    this.d = true;
  }
  
  public void f() {}
  
  protected final boolean g()
  {
    return this.d;
  }
  
  protected void h()
  {
    this.d = true;
    this.a.getActivity().finish();
  }
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView
 * JD-Core Version:    0.7.0.1
 */