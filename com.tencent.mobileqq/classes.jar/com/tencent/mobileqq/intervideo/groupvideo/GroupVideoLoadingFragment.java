package com.tencent.mobileqq.intervideo.groupvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GroupVideoLoadingFragment
  extends PublicBaseFragment
{
  public static boolean a;
  private GVideoLoadingUI b;
  private Context c;
  private IGroupVideoManager d;
  private int e;
  private boolean f;
  private int g;
  private long h;
  private IVPluginDataReporter i;
  private PluginLoadListener j = new GroupVideoLoadingFragment.2(this);
  private Handler k = new GroupVideoLoadingFragment.3(this, Looper.getMainLooper());
  
  private void a()
  {
    if (!NetworkUtil.isNetworkAvailable(this.c))
    {
      this.b.a(HardCodeUtil.a(2131903386), "");
      this.b.c();
      return;
    }
    this.b.a(HardCodeUtil.a(2131903382), HardCodeUtil.a(2131903378));
    GroupVideoManager.a("group_video", new GroupVideoLoadingFragment.1(this));
  }
  
  private void a(boolean paramBoolean)
  {
    this.h = System.currentTimeMillis();
    String str2 = getArguments().getString("roomCode");
    String str3 = getArguments().getString("uin");
    int m = getArguments().getInt("isGroupCode");
    String str4 = getArguments().getString("backType");
    String str1 = getArguments().getString("action");
    String str5 = getArguments().getString("fromId");
    String str6 = getArguments().getString("openType");
    String str7 = getArguments().getString("extra");
    this.f = paramBoolean;
    if (paramBoolean) {
      str1 = "checkVersion";
    }
    this.e = 0;
    this.d.a(this.c, str2, str3, m, str1, str5, str4, str6, str7, this.j);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    Monitor.b("2856633");
    this.i.opType("exitLoadPage").opIn(this.g).opResult((int)(System.currentTimeMillis() - this.h)).report();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((IGroupVideoManager)MobileQQ.sMobileQQ.waitAppRuntime(null).getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER));
    a = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625133, null);
    this.b = new GVideoLoadingUI();
    this.b.a(getBaseActivity(), paramLayoutInflater);
    this.c = getBaseActivity();
    this.i = new IVPluginDataReporter();
    this.i.opDepartment("group_video");
    a();
    Monitor.b("2856632");
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a = false;
    this.d.a(getBaseActivity());
    this.k.removeCallbacksAndMessages(null);
    this.j = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment
 * JD-Core Version:    0.7.0.1
 */