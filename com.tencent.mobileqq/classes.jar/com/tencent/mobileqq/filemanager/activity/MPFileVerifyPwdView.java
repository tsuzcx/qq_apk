package com.tencent.mobileqq.filemanager.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqdataline.ipc.DatalineRemoteManager;
import java.util.Timer;

public class MPFileVerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  View a = null;
  private Activity b;
  private QQAppInterface c;
  private View d;
  private TextView e;
  private Button f;
  private TextView g;
  private MPFileVerifyPwdView.MPFileVerifyPswEvent h = null;
  private long i;
  private Timer j = new Timer();
  
  public MPFileVerifyPwdView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.b = ((Activity)paramContext);
    this.c = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, MPFileVerifyPwdView.MPFileVerifyPswEvent paramMPFileVerifyPswEvent)
  {
    this.h = paramMPFileVerifyPswEvent;
    this.a = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131627105, null).findViewById(2131449368);
    return this.a;
  }
  
  public void a()
  {
    this.h = null;
    Timer localTimer = this.j;
    if (localTimer != null)
    {
      localTimer.cancel();
      this.j = null;
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    this.d = this.a.findViewById(2131449371);
    this.e = ((TextView)this.a.findViewById(2131440911));
    this.e.setLongClickable(false);
    this.e.addTextChangedListener(new MPFileVerifyPwdView.1(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.e.setTextIsSelectable(false);
      this.e.setCustomSelectionActionModeCallback(new MPFileVerifyPwdView.2(this));
    }
    this.f = ((Button)this.a.findViewById(2131449369));
    this.f.setOnClickListener(this);
    this.g = ((TextView)this.a.findViewById(2131438760));
    this.g.setText(2131891901);
    this.g.setTextColor(Color.parseColor("#00a5e0"));
    this.g.setOnClickListener(new MPFileVerifyPwdView.3(this));
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131892102));
    }
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.b.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public void d()
  {
    this.b.runOnUiThread(new MPFileVerifyPwdView.4(this));
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.e.getText().toString();
    if ((localObject != null) && (!((String)localObject).equals("")))
    {
      this.g.setEnabled(true);
      this.g.setTextColor(Color.parseColor("#00a5e0"));
      if (((String)localObject).length() < 6)
      {
        FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131891921));
      }
      else if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
      {
        FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131892102));
      }
      else
      {
        DataLineHandler localDataLineHandler = (DataLineHandler)this.c.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        localDataLineHandler.a().c((String)localObject);
        this.i = localDataLineHandler.a().a(2);
        localObject = this.h;
        if (localObject != null) {
          ((MPFileVerifyPwdView.MPFileVerifyPswEvent)localObject).a(this.i);
        }
      }
    }
    else
    {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131891920));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView
 * JD-Core Version:    0.7.0.1
 */