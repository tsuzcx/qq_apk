package com.tencent.mobileqq.richstatus;

import alzl;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import atgv;
import awgf;
import awgg;
import ayea;
import ayeb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import nrt;
import nrz;

public class StatusJsHandler
  extends atgv
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  public AccountDetail a;
  public String a;
  public WeakReference<BaseActivity> a;
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new ayea(this);
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  WeakReference<WebView> jdField_b_of_type_JavaLangRefWeakReference;
  private BusinessObserver jdField_b_of_type_MqqObserverBusinessObserver = new ayeb(this);
  boolean jdField_b_of_type_Boolean = false;
  public String c;
  
  public StatusJsHandler(BaseActivity paramBaseActivity, WebView paramWebView, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramBaseActivity, nrz.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.3.5,3,4555");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
      paramBaseActivity.app.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception paramBaseActivity)
    {
      a(this.c, "false");
    }
  }
  
  private void b(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "follow");
    }
    NewIntent localNewIntent = new NewIntent(paramBaseActivity, nrz.class);
    localNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    try
    {
      localFollowRequest.uin.set((int)Long.parseLong(paramString));
      localFollowRequest.ext.set("0");
      localNewIntent.putExtra("data", localFollowRequest.toByteArray());
      localNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      paramBaseActivity.app.startServlet(localNewIntent);
      nrt.a(paramBaseActivity.app, paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, "follow exit");
      }
      return;
    }
    catch (Exception paramBaseActivity)
    {
      a(this.c, "false");
    }
  }
  
  public void a(int paramInt)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    QQToast.a(localBaseActivity, paramInt, 0).b(localBaseActivity.getTitleBarHeight());
  }
  
  public void a(BaseActivity paramBaseActivity, AccountDetail paramAccountDetail)
  {
    awgf localawgf = paramBaseActivity.app.getEntityManagerFactory().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!localawgf.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        localawgf.a(AccountDetail.class);
      }
    }
    for (;;)
    {
      localawgf.a();
      paramBaseActivity = (alzl)paramBaseActivity.app.getManager(56);
      if (paramBaseActivity != null) {
        paramBaseActivity.a(paramAccountDetail);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      localawgf.a(paramAccountDetail);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    WebView localWebView = (WebView)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((paramString1 == null) || (localBaseActivity == null) || (localBaseActivity.isFinishing()) || (localWebView == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new StatusJsHandler.2(this, paramString1, paramString2, localWebView));
  }
  
  public void followAccount(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseActivity == null) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.c = paramString2;
    paramString2 = localBaseActivity.app.getEntityManagerFactory().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
    paramString2.a();
    if (localAccountDetail != null)
    {
      b(localBaseActivity, paramString1);
      return;
    }
    a(localBaseActivity, paramString1);
  }
  
  public void getLocation(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseActivity == null) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = paramString;
    ThreadManager.post(new StatusJsHandler.1(this, (LocationManager)localBaseActivity.getSystemService("location")), 5, null, false);
  }
  
  public boolean hasFollowAccount(String paramString)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return false;
    }
    localObject = (alzl)((BaseActivity)localObject).app.getManager(56);
    return (localObject != null) && (((alzl)localObject).b(paramString) != null);
  }
  
  public void setData(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler
 * JD-Core Version:    0.7.0.1
 */