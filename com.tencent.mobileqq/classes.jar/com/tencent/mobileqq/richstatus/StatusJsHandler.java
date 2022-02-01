package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.jsbridge.JsBridge.JsHandler;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class StatusJsHandler
  extends JsBridge.JsHandler
{
  WeakReference<BaseActivity> a;
  WeakReference<WebView> b;
  public String c;
  IPublicAccountDetail d = null;
  boolean e = false;
  boolean f = false;
  String g;
  String h;
  private Handler i;
  private BusinessObserver j = new StatusJsHandler.3(this);
  private BusinessObserver k = new StatusJsHandler.4(this);
  
  public StatusJsHandler(BaseActivity paramBaseActivity, WebView paramWebView, String paramString)
  {
    this.a = new WeakReference(paramBaseActivity);
    this.b = new WeakReference(paramWebView);
    this.c = paramString;
  }
  
  private void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramBaseActivity, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.8.17,3,5770");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(this.j);
      paramBaseActivity.app.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception paramBaseActivity)
    {
      label138:
      break label138;
    }
    a(this.h, "false");
  }
  
  private void b(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "follow");
    }
    NewIntent localNewIntent = new NewIntent(paramBaseActivity, ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    try
    {
      localFollowRequest.uin.set((int)Long.parseLong(paramString));
      localFollowRequest.ext.set("0");
      localNewIntent.putExtra("data", localFollowRequest.toByteArray());
      localNewIntent.setObserver(this.k);
      paramBaseActivity.app.startServlet(localNewIntent);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(paramBaseActivity.app, paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, "follow exit");
      }
      return;
    }
    catch (Exception paramBaseActivity)
    {
      label139:
      break label139;
    }
    a(this.h, "false");
  }
  
  void a(int paramInt)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.get();
    if (localBaseActivity != null)
    {
      if (localBaseActivity.isFinishing()) {
        return;
      }
      QQToast.makeText(localBaseActivity, paramInt, 0).show(localBaseActivity.getTitleBarHeight());
    }
  }
  
  void a(BaseActivity paramBaseActivity, IPublicAccountDetail paramIPublicAccountDetail)
  {
    EntityManager localEntityManager = paramBaseActivity.app.getEntityManagerFactory().createEntityManager();
    IPublicAccountDetail localIPublicAccountDetail = this.d;
    if ((localIPublicAccountDetail != null) && (localIPublicAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, paramIPublicAccountDetail.getName());
      }
      this.d.clone(paramIPublicAccountDetail);
      if (!localEntityManager.update(this.d.getEntity())) {
        localEntityManager.drop(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class));
      }
    }
    else
    {
      this.d = paramIPublicAccountDetail;
      localEntityManager.persist(paramIPublicAccountDetail.getEntity());
    }
    localEntityManager.close();
    paramBaseActivity = (IPublicAccountDataManager)paramBaseActivity.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (paramBaseActivity != null) {
      paramBaseActivity.saveAccountDetailInfoCache(paramIPublicAccountDetail);
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.get();
    WebView localWebView = (WebView)this.b.get();
    if ((paramString1 != null) && (localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (localWebView == null) {
        return;
      }
      if (this.i == null) {
        this.i = new Handler(Looper.getMainLooper());
      }
      this.i.post(new StatusJsHandler.2(this, paramString1, paramString2, localWebView));
    }
  }
  
  public void followAccount(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.get();
    if (localBaseActivity == null) {
      return;
    }
    if (this.e) {
      return;
    }
    this.e = true;
    this.h = paramString2;
    paramString2 = localBaseActivity.app.getEntityManagerFactory().createEntityManager();
    IPublicAccountDetail localIPublicAccountDetail = (IPublicAccountDetail)paramString2.find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), paramString1);
    paramString2.close();
    if (localIPublicAccountDetail != null)
    {
      b(localBaseActivity, paramString1);
      return;
    }
    a(localBaseActivity, paramString1);
  }
  
  public void getLocation(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.get();
    if (localBaseActivity == null) {
      return;
    }
    if (this.f) {
      return;
    }
    this.f = true;
    this.g = paramString;
    paramString = (LocationManager)localBaseActivity.getSystemService("location");
    if (paramString == null) {
      return;
    }
    ThreadManager.post(new StatusJsHandler.1(this, paramString), 5, null, false);
  }
  
  public boolean hasFollowAccount(String paramString)
  {
    Object localObject = (BaseActivity)this.a.get();
    if (localObject == null) {
      return false;
    }
    localObject = (IPublicAccountDataManager)((BaseActivity)localObject).app.getRuntimeService(IPublicAccountDataManager.class, "all");
    return (localObject != null) && ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(paramString) != null);
  }
  
  public void setData(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.a.get();
    if (localBaseActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("k_data_text", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("k_data_id", Long.valueOf(paramString2));
    }
    localBaseActivity.setResult(-1, localIntent);
    localBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler
 * JD-Core Version:    0.7.0.1
 */