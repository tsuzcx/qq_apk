package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.StringAddition;

public class AuthorityAccountView
  extends BaseAuthorityAccountView
{
  private TextView r;
  private ImageView s;
  private TextView t;
  private AuthorityAccountView.IDeleteLastAccountListener u = null;
  private AuthorityAccountView.IChangeAccountListener v = null;
  
  public AuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    j();
  }
  
  private void j()
  {
    SSOLog.a("AuthorityAccountView", new Object[] { "-->initUI" });
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.k = LayoutInflater.from(this.c).inflate(2131625688, null);
    localLayoutParams.topMargin = DisplayUtil.a(this.c, 37.0F);
    localLayoutParams.bottomMargin = DisplayUtil.a(this.c, 37.0F);
    addView(this.k, localLayoutParams);
    this.s = ((ImageView)this.k.findViewById(2131427452));
    this.t = ((TextView)this.k.findViewById(2131427424));
    this.r = ((TextView)this.k.findViewById(2131427437));
    int i = BaseAIOUtils.b(10.0F, getResources());
    BaseAIOUtils.a(this.r, i, i, i, i);
    this.r.setOnClickListener(new AuthorityAccountView.1(this));
    c();
    if ((this.c instanceof AuthorityActivity)) {
      this.m.setOnClickListener((AuthorityActivity)this.c);
    } else if ((this.c instanceof QuickLoginAuthorityActivity)) {
      this.m.setOnClickListener((QuickLoginAuthorityActivity)this.c);
    }
    k();
  }
  
  private void k()
  {
    ImageView localImageView = (ImageView)this.k.findViewById(2131428883);
    localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new AuthorityAccountView.2(this, localImageView));
  }
  
  public void a()
  {
    this.r.setVisibility(8);
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (!(this.c instanceof AuthorityActivity)) {
      return false;
    }
    ((AuthorityActivity)this.c).a(paramString, paramBoolean);
    return true;
  }
  
  protected boolean b()
  {
    AuthorityAccountView.IDeleteLastAccountListener localIDeleteLastAccountListener = this.u;
    if (localIDeleteLastAccountListener == null) {
      return false;
    }
    localIDeleteLastAccountListener.a();
    return true;
  }
  
  public void setAppInfo(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = StringAddition.a(paramString, 12, true);
      this.t.setText(paramString);
    }
    if (paramBitmap != null)
    {
      paramString = new StringBuilder();
      paramString.append("setAppInfo appIcon=");
      paramString.append(paramBitmap);
      SSOLog.b("AuthorityAccountView", paramString.toString());
      this.s.setImageBitmap(paramBitmap);
    }
  }
  
  public void setAppType(String paramString)
  {
    if (this.k != null)
    {
      TextView localTextView = (TextView)this.k.findViewById(2131427422);
      String str = this.c.getResources().getString(2131892297);
      if ("web".equals(paramString)) {
        str = this.c.getResources().getString(2131892298);
      } else if ("android".equals(paramString)) {
        str = this.c.getResources().getString(2131892297);
      }
      localTextView.setText(str);
      paramString = new StringBuilder();
      paramString.append("setAppType=");
      paramString.append(str);
      SSOLog.b("AuthorityAccountView", paramString.toString());
    }
  }
  
  public void setChangeAccountListener(AuthorityAccountView.IChangeAccountListener paramIChangeAccountListener)
  {
    this.v = paramIChangeAccountListener;
  }
  
  public void setDeleteLastAccountListener(AuthorityAccountView.IDeleteLastAccountListener paramIDeleteLastAccountListener)
  {
    this.u = paramIDeleteLastAccountListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */