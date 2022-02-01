package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.dialog.SlideBottomDialog;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.settings.OpensdkFeatureSwitcher;

public class OpenAuthorityAccountView
  extends BaseAuthorityAccountView
{
  private View r;
  private OpenCardContainer.AccountEventListener s = null;
  private SlideBottomDialog t;
  private boolean u = OpensdkFeatureSwitcher.a(this.e);
  
  public OpenAuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    SSOLog.a("OpenAuthorityAccountView", new Object[] { "-->initUI" });
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.k = LayoutInflater.from(this.c).inflate(2131625690, null);
    addView(this.k, localLayoutParams);
    c();
    this.m.setOnClickListener(new OpenAuthorityAccountView.1(this));
    this.r = findViewById(2131445532);
  }
  
  private void j()
  {
    this.t = new SlideBottomDialog(getContext());
    this.t.a(this.l);
    int i = getResources().getDimensionPixelSize(2131298163);
    int j = getResources().getDimensionPixelSize(2131298165);
    int k = getResources().getDimensionPixelSize(2131298164);
    this.t.a((i + j * 2) * 6 + k);
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if ((this.c instanceof PublicFragmentActivityForOpenSDK))
    {
      OpenCardContainer.AccountEventListener localAccountEventListener = this.s;
      if (localAccountEventListener != null)
      {
        localAccountEventListener.a(paramString, paramBoolean);
        return true;
      }
    }
    return false;
  }
  
  protected boolean b()
  {
    if ((this.c != null) && ((this.c instanceof PublicFragmentActivityForOpenSDK)))
    {
      OpenCardContainer.AccountEventListener localAccountEventListener = this.s;
      if (localAccountEventListener != null) {
        localAccountEventListener.a();
      }
      return true;
    }
    return false;
  }
  
  public void e()
  {
    if (!this.q)
    {
      i();
      this.q = true;
    }
    if (this.u)
    {
      if (this.t == null) {
        j();
      }
      if (!this.t.isShowing()) {
        this.t.a();
      }
    }
    else
    {
      super.e();
    }
  }
  
  public void f()
  {
    if (this.u)
    {
      SlideBottomDialog localSlideBottomDialog = this.t;
      if ((localSlideBottomDialog != null) && (localSlideBottomDialog.isShowing()))
      {
        this.t.b();
        return;
      }
    }
    super.f();
  }
  
  protected int getAccountListContainerLayoutId()
  {
    if (this.u) {
      return 2131625705;
    }
    return super.getAccountListContainerLayoutId();
  }
  
  protected int getAccountListItemLayoutId()
  {
    if (this.u) {
      return 2131625687;
    }
    return super.getAccountListItemLayoutId();
  }
  
  public void setAccountEventListener(OpenCardContainer.AccountEventListener paramAccountEventListener)
  {
    this.s = paramAccountEventListener;
  }
  
  public void setMainAccountSelect(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMainAccountSelect select=");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    SSOLog.a("OpenAuthorityAccountView", new Object[] { localObject });
    localObject = this.r;
    if (!paramBoolean) {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */