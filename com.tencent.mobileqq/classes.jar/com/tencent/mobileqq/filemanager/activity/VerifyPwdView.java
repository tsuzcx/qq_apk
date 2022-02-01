package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class VerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  View a = null;
  private BaseFileAssistantActivity b;
  private AppRuntime c;
  private View d;
  private TextView e;
  private Button f;
  private ProgressBar g;
  private VerifyPwdView.VerifyPswEvent h = null;
  private ImageView i;
  private FMObserver j = new VerifyPwdView.1(this);
  
  public VerifyPwdView(Context paramContext)
  {
    super(paramContext);
    this.b = ((BaseFileAssistantActivity)paramContext);
    this.c = this.b.p;
  }
  
  private void c()
  {
    this.d.setVisibility(8);
    this.g.setVisibility(0);
  }
  
  private void d()
  {
    this.d.setVisibility(0);
    this.g.setVisibility(8);
  }
  
  private void e()
  {
    this.g.setVisibility(8);
  }
  
  private void f()
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((VerifyPwdView.VerifyPswEvent)localObject).a();
    }
    localObject = (InputMethodManager)this.b.getSystemService("input_method");
    if (((InputMethodManager)localObject).isActive()) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public View a(ViewGroup paramViewGroup, VerifyPwdView.VerifyPswEvent paramVerifyPswEvent)
  {
    this.h = paramVerifyPswEvent;
    this.a = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131627103, null).findViewById(2131449368);
    return this.a;
  }
  
  public void a()
  {
    if (this.j != null)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.j);
      this.h = null;
    }
  }
  
  public void b()
  {
    Object localObject = this.a.findViewById(2131445569);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.d = this.a.findViewById(2131449371);
    this.g = ((ProgressBar)this.a.findViewById(2131444560));
    this.e = ((TextView)this.a.findViewById(2131440911));
    this.f = ((Button)this.a.findViewById(2131449369));
    this.f.setOnClickListener(this);
    this.i = ((ImageView)this.a.findViewById(2131450119));
    if (ThemeUtil.isNowThemeIsNight(this.c, false, null)) {
      this.i.setImageResource(2130845764);
    } else {
      this.i.setImageResource(2130845763);
    }
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.j);
    localObject = (IQQFileEngine)((BaseQQAppInterface)this.c).getRuntimeService(IQQFileEngine.class);
    if (((IQQFileEngine)localObject).hasQueriedVerifyPassword() == true)
    {
      ((IQQFileEngine)localObject).queryNeedVerifyPwd();
      return;
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      c();
      ((IQQFileEngine)localObject).queryNeedVerifyPwd();
      return;
    }
    FMToastUtil.a(2131896111);
  }
  
  public void onClick(View paramView)
  {
    String str = this.e.getText().toString();
    if ((str != null) && (!str.equals(""))) {
      ((IQQFileEngine)((BaseQQAppInterface)this.c).getRuntimeService(IQQFileEngine.class)).verifyPwd(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdView
 * JD-Core Version:    0.7.0.1
 */