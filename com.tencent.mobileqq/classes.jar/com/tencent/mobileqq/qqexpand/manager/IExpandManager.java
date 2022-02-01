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
  public abstract String A();
  
  public abstract String B();
  
  public abstract boolean C();
  
  public abstract String D();
  
  public abstract boolean E();
  
  public abstract boolean F();
  
  public abstract int G();
  
  public abstract int H();
  
  public abstract String I();
  
  public abstract String J();
  
  public abstract boolean K();
  
  public abstract boolean L();
  
  public abstract void M();
  
  public abstract ArrayList<ExpandBannerConfBean.BannerItem> N();
  
  public abstract void O();
  
  public abstract boolean P();
  
  public abstract int Q();
  
  public abstract void T();
  
  public abstract void U();
  
  public abstract ExtendFriendLocationInfo V();
  
  public abstract void W();
  
  public abstract int X();
  
  public abstract boolean Y();
  
  public abstract boolean Z();
  
  public abstract int a();
  
  public abstract ExpandUserInfo a(String paramString, boolean paramBoolean);
  
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
  
  public abstract boolean aa();
  
  public abstract String ab();
  
  public abstract boolean ac();
  
  public abstract Object ag();
  
  public abstract List<String> b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract String c();
  
  public abstract List<String> c(int paramInt);
  
  public abstract void c(String paramString);
  
  public abstract void d(int paramInt);
  
  public abstract void d(String paramString);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e();
  
  public abstract void e(boolean paramBoolean);
  
  public abstract int f(String paramString);
  
  public abstract String f();
  
  public abstract void h();
  
  public abstract ExtendFriendSearchHistoryManager k();
  
  public abstract ExtendFriendSearchHistoryManager l();
  
  public abstract CacheData m();
  
  public abstract boolean n();
  
  public abstract boolean r();
  
  public abstract int s();
  
  public abstract ExpandConfig t();
  
  public abstract ExpandConfig u();
  
  public abstract String w();
  
  public abstract boolean x();
  
  public abstract String y();
  
  public abstract int z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.IExpandManager
 * JD-Core Version:    0.7.0.1
 */