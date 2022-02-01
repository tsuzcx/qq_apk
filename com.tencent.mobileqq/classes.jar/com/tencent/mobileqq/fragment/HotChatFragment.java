package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.IHotChatFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class HotChatFragment
  extends NearbyBaseFragment
  implements Handler.Callback, IHotChatFragment
{
  public NearbyActivity a;
  public HotChatFragment.HotChatWebView b;
  public RefreshView c;
  public View d;
  ArrayList<Rect> e = new ArrayList();
  boolean f = false;
  View.OnClickListener g;
  BroadcastReceiver h = new HotChatFragment.1(this);
  BroadcastReceiver i = new HotChatFragment.2(this);
  
  public HotChatFragment()
  {
    this.ah = 2;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatFragment", new Object[] { "HotChatFragment" });
    }
  }
  
  private void d()
  {
    if (this.g != null) {
      this.aj.a(getString(2131897044)).a(this.g);
    } else {
      this.aj.a("").a(null);
    }
    this.aj.a();
  }
  
  void a(Activity paramActivity, INearbyAppInterface paramINearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("HotChatFragment", "createWebView", new Object[] { this.b, paramActivity, paramINearbyAppInterface });
      }
      if ((this.a == null) && ((paramActivity instanceof NearbyActivity))) {
        this.a = ((NearbyActivity)paramActivity);
      }
      if ((this.b == null) && (paramActivity != null) && (paramINearbyAppInterface != null))
      {
        this.b = new HotChatFragment.HotChatWebView(this, paramActivity.getBaseContext(), paramActivity, (AppInterface)paramINearbyAppInterface);
        if (!WebAccelerateHelper.isWebViewCache)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("url", SharedPreUtils.ah(paramActivity, this.k.getCurrentAccountUin()));
          WebAccelerateHelper.getInstance().preGetKey(localIntent, (AppRuntime)paramINearbyAppInterface);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
    if ((this.ai) && (this.al)) {
      d();
    }
  }
  
  void c()
  {
    if (!this.n)
    {
      if (this.am == null) {
        return;
      }
      long l = 0L;
      if (this.a != null) {
        l = System.currentTimeMillis();
      }
      this.n = true;
      if (!this.b.b)
      {
        this.l.removeMessages(2);
        this.b.a();
      }
      Object localObject = this.c;
      if (localObject != null)
      {
        ((RefreshView)localObject).setDelayBeforeScrollBack(800L);
        this.b.mWebview.setOnOverScrollHandler(this.c);
        this.c.addView(this.b.mWebview, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (this.b.c)
      {
        localObject = this.d;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      try
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.refresh_hot_chat_list");
        this.ag.registerReceiver(this.h, (IntentFilter)localObject);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.get_banner_rect");
        this.ag.registerReceiver(this.i, (IntentFilter)localObject);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      NearbyActivity localNearbyActivity = this.a;
      if (localNearbyActivity != null)
      {
        localNearbyActivity.mInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.a.mInitTime) });
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      c();
    }
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    a(paramActivity, this.k);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    NearbyActivity localNearbyActivity = this.a;
    if ((localNearbyActivity != null) && (localNearbyActivity.mOnCreateMilliTimeStamp == 0L))
    {
      this.a.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.a.mOnCreateMilliTimeStamp) });
      }
    }
    super.onCreate(paramBundle);
    paramBundle = this.b;
    if (paramBundle != null) {
      paramBundle.a(this.ag.getIntent());
    }
    paramBundle = this.a;
    if ((paramBundle != null) && (paramBundle.onCreateTime == 0L))
    {
      this.a.onCreateTime = (System.currentTimeMillis() - this.a.mOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.a.onCreateTime) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l;
    if (this.a != null) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatFragment", new Object[] { "onCreateView", Long.valueOf(l) });
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.am == null)
    {
      this.am = paramLayoutInflater.inflate(2131625499, null);
      this.c = ((RefreshView)this.am.findViewById(2131450066));
      this.d = this.am.findViewById(2131435158);
    }
    this.aj.b(getString(2131892066)).a(false);
    d();
    if ((this.m) && (!this.n)) {
      c();
    }
    paramLayoutInflater = this.a;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.mViewInflateTime == 0L))
    {
      this.a.mViewInflateTime = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.a.mViewInflateTime) });
      }
    }
    if (!this.f)
    {
      paramLayoutInflater = new Rect();
      paramLayoutInflater.top = 0;
      paramLayoutInflater.bottom = ((int)(this.ag.getResources().getDisplayMetrics().density * 315.0F));
      this.e.add(paramLayoutInflater);
    }
    return this.am;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.n) {
      return;
    }
    try
    {
      this.ag.unregisterReceiver(this.h);
      this.ag.unregisterReceiver(this.i);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.b.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.n) {
      return;
    }
    this.b.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.n) {
      return;
    }
    this.b.b();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
      QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131903521), 0).show(getBaseActivity().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment
 * JD-Core Version:    0.7.0.1
 */