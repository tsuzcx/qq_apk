package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.step.GetQZoneFeeds;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class QzoneContactsFeedManager
  implements Manager
{
  private static int a = -1;
  private static int b = -1;
  private static int c = -1;
  private static int d = -1;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private long h = 0L;
  private String i;
  private QQAppInterface j;
  private ArrayList<Long> k;
  
  public QzoneContactsFeedManager(QQAppInterface paramQQAppInterface)
  {
    this.j = paramQQAppInterface;
  }
  
  private void a(ArrayList<Long> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramInt < paramArrayList.size()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshAllInner(");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(")...");
        QLog.d("QzoneContactsFeedManager", 2, ((StringBuilder)localObject).toString());
      }
      int n = k() + paramInt;
      int m = n;
      if (n >= paramArrayList.size()) {
        m = paramArrayList.size();
      }
      Object localObject = new NewIntent(this.j.getApplication(), QzoneContactsFeedServlet.class);
      paramArrayList = new ArrayList(paramArrayList.subList(paramInt, m));
      QzoneContactsFeedUtils.a((Intent)localObject, QzoneContactsFeedUtils.a(1, Long.valueOf(this.j.getCurrentAccountUin()).longValue(), paramArrayList, 0L, null));
      this.j.startServlet((NewIntent)localObject);
      return;
    }
    g();
  }
  
  @TargetApi(9)
  private void b(long paramLong, String paramString)
  {
    SharedPreferences.Editor localEditor = j().edit();
    localEditor.putLong("last_request_time", paramLong);
    localEditor.putString("last_attach_info", paramString);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  private SharedPreferences j()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(SecurityUtil.a(this.j.getCurrentAccountUin()));
    ((StringBuilder)localObject).append("GetQZoneFeeds");
    localObject = ((StringBuilder)localObject).toString();
    return BaseApplication.getContext().getSharedPreferences((String)localObject, 0);
  }
  
  private static int k()
  {
    if (a < 0) {
      a = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsUinNum", 100);
    }
    return a;
  }
  
  private static int l()
  {
    if (b < 0) {
      b = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsRetryNum", 2);
    }
    return b;
  }
  
  private static int m()
  {
    if (c < 0)
    {
      c = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsMinTimeCell", 900);
      c *= 1000;
    }
    return c;
  }
  
  private static int n()
  {
    if (d < 0)
    {
      d = QzoneConfig.getInstance().getConfig("QZoneSetting", "NewestFeedsMinRefreshTimeCell", 604800);
      d *= 1000;
    }
    return d;
  }
  
  @TargetApi(9)
  public void a()
  {
    if (!GetQZoneFeeds.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneContactsFeedManager", 2, "GetQZoneFeeds 此step尚未执行，此次调用就此返回，等待自动机中GetQZoneFeeds执行此方法");
      }
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new QzoneContactsFeedManager.1(this));
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFriend(");
      localStringBuilder.append(this.e);
      localStringBuilder.append(")...");
      QLog.d("QzoneContactsFeedManager", 2, localStringBuilder.toString());
    }
    if (this.e != 0) {
      return;
    }
    this.e = 3;
    this.f = 0;
    this.k = new ArrayList(1);
    this.k.add(Long.valueOf(paramLong));
    a(this.k, this.f);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAll(");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(")...");
      QLog.d("QzoneContactsFeedManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.e != 0) {
      return;
    }
    this.e = 2;
    this.h = paramLong;
    this.i = paramString;
    Object localObject = new NewIntent(this.j.getApplication(), QzoneContactsFeedServlet.class);
    QzoneContactsFeedUtils.a((Intent)localObject, QzoneContactsFeedUtils.a(2, Long.valueOf(this.j.getCurrentAccountUin()).longValue(), null, paramLong, paramString));
    this.j.startServlet((NewIntent)localObject);
  }
  
  public void a(newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (paramnewest_feeds_rsp == null) {
      return;
    }
    int m = this.e;
    if (m == 3) {
      return;
    }
    if (((m == 1) && (this.f == 0)) || (this.e == 2)) {
      b(paramnewest_feeds_rsp.last_feed_time, paramnewest_feeds_rsp.str_attach);
    }
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAll(");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(")...");
      QLog.d("QzoneContactsFeedManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.e != 0) {
      return;
    }
    this.e = 1;
    int m = 0;
    this.f = 0;
    this.k = QzoneContactsFeedUtils.a(this.j);
    if (QLog.isColorLevel())
    {
      localObject = (FriendsManager)this.j.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ArrayList localArrayList = this.k;
      if (localArrayList != null) {
        m = localArrayList.size();
      }
      QLog.d("QzoneContactsFeedManager", 2, new Object[] { "allFriends.size:", Integer.valueOf(m), ",getAllFreindsCount:", Integer.valueOf(((FriendsManager)localObject).u()) });
    }
    a(this.k, this.f);
  }
  
  public long c()
  {
    return j().getLong("last_request_time", 0L);
  }
  
  public String d()
  {
    return j().getString("last_attach_info", "");
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry(");
      localStringBuilder.append(this.g);
      localStringBuilder.append(")...");
      QLog.d("QzoneContactsFeedManager", 2, localStringBuilder.toString());
    }
    this.g += 1;
    if (this.g >= l())
    {
      this.g = 0;
      if (this.e == 1) {
        b(0L, null);
      }
      f();
      return;
    }
    int m = this.e;
    if ((m != 1) && (m != 3))
    {
      if (m == 2)
      {
        this.e = 0;
        a(this.h, this.i);
        return;
      }
      g();
      return;
    }
    a(this.k, this.f);
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextRequest(");
      localStringBuilder.append(this.f);
      localStringBuilder.append(")...");
      QLog.d("QzoneContactsFeedManager", 2, localStringBuilder.toString());
    }
    int m = this.e;
    if ((m != 1) && (m != 3))
    {
      g();
      return;
    }
    this.f += k();
    a(this.k, this.f);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "close...");
    }
    this.e = 0;
    this.k = null;
    this.f = 0;
    this.g = 0;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "onDestroy...");
    }
    g();
    GetQZoneFeeds.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager
 * JD-Core Version:    0.7.0.1
 */