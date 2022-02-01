package com.tencent.mobileqq.qqexpand.manager;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.feed.CacheData;
import com.tencent.mobileqq.qqexpand.bean.match.ExtendFriendLocationInfo;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandUserInfo;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.config.IConfigCallback;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean.BannerItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface IExpandManager
{
  public abstract int a();
  
  public abstract int a(String paramString);
  
  public abstract CacheData a();
  
  public abstract ExtendFriendLocationInfo a();
  
  public abstract ExpandUserInfo a(String paramString, boolean paramBoolean);
  
  public abstract ExpandConfig a();
  
  public abstract ExtendFriendSearchHistoryManager a();
  
  public abstract Object a();
  
  public abstract String a();
  
  public abstract ArrayList<ExpandBannerConfBean.BannerItem> a();
  
  public abstract List<String> a(int paramInt);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(CacheData paramCacheData);
  
  public abstract void a(ExpandUserInfo paramExpandUserInfo);
  
  public abstract void a(IConfigCallback paramIConfigCallback);
  
  public abstract void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, Bundle paramBundle);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
  
  public abstract boolean a(Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean a(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean a(ExpandConfig paramExpandConfig);
  
  public abstract int b();
  
  public abstract ExpandConfig b();
  
  public abstract ExtendFriendSearchHistoryManager b();
  
  public abstract String b();
  
  public abstract List<String> b(int paramInt);
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void c(String paramString);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract String d();
  
  public abstract void d();
  
  public abstract void d(String paramString);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract boolean d();
  
  public abstract int e();
  
  public abstract String e();
  
  public abstract void e();
  
  public abstract boolean e();
  
  public abstract int f();
  
  public abstract String f();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public abstract int g();
  
  public abstract String g();
  
  public abstract void g();
  
  public abstract boolean g();
  
  public abstract int h();
  
  public abstract String h();
  
  public abstract boolean h();
  
  public abstract String i();
  
  public abstract boolean i();
  
  public abstract String j();
  
  public abstract boolean j();
  
  public abstract String k();
  
  public abstract boolean l();
  
  public abstract boolean m();
  
  public abstract boolean n();
  
  public abstract boolean o();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.IExpandManager
 * JD-Core Version:    0.7.0.1
 */