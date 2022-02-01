package com.tencent.mobileqq.forward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;

public abstract class ForwardSdkBaseOption
  extends ForwardBaseOption
  implements ReportDef
{
  protected static final Object a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ForwardSdkBaseOption.1(this);
  protected Handler a;
  protected AppInfo a;
  ForwardSdkBaseOption.MySSOAccountObserver jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$MySSOAccountObserver = new ForwardSdkBaseOption.MySSOAccountObserver(this);
  protected ForwardSdkBaseOption.PreStructViewHolder a;
  protected AbsShareMsg a;
  protected OpensdkBusinessObserver a;
  private HandlerPlus jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  public long b;
  @SuppressLint({"HandlerLeak"})
  private Handler b;
  protected ShareResultDialog b;
  protected long c;
  public int e;
  protected String h;
  protected String i;
  protected String j;
  protected boolean j;
  protected String k;
  protected boolean k;
  protected boolean l = false;
  protected boolean m;
  protected boolean n = false;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public ForwardSdkBaseOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_k_of_type_Boolean = false;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_c_of_type_Long = 0L;
    this.jdField_k_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentOpenAppcommonOpensdkBusinessObserver = new ForwardSdkBaseOption.3(this);
    this.jdField_b_of_type_AndroidOsHandler = new ForwardSdkBaseOption.6(this);
  }
  
  private void N()
  {
    try
    {
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "80");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReportDef.RepUtil.a(paramInt));
    localBundle.putString("intext_1", localStringBuilder.toString());
    localBundle.putString("intext_3", "0");
    ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, paramBoolean);
  }
  
  public static final void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if (paramActivity != null)
    {
      if (paramIntent == null) {
        return;
      }
      localObject2 = paramIntent.getBundleExtra("share_data");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramIntent.getExtras();
      }
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getString("share_action");
        paramIntent = (Intent)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
      else
      {
        paramIntent = "shareToQzone";
      }
      long l1 = 0L;
      if (localObject1 != null) {
        l1 = ((Bundle)localObject1).getLong("req_share_id", 0L);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sdk_share:sdk callback=");
        ((StringBuilder)localObject2).append(paramBoolean);
        ((StringBuilder)localObject2).append(" appid=");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(" action=");
        ((StringBuilder)localObject2).append("shareToQzone");
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Intent();
      if (paramBoolean) {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l1), paramIntent })));
      } else {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(l1), paramIntent })));
      }
      QZoneHelper.addSource((Intent)localObject2);
      if (localObject1 == null) {}
    }
    try
    {
      ((Intent)localObject2).setPackage(((Bundle)localObject1).getString("pkg_name"));
    }
    catch (Exception paramIntent)
    {
      label250:
      break label250;
    }
    ((Intent)localObject2).setPackage(null);
    try
    {
      paramActivity.startActivity((Intent)localObject2);
      return;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity, new Object[0]);
      }
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "sdk_share:sdk callback=", Boolean.valueOf(paramBoolean), " appid=", Long.valueOf(paramLong), " action=", paramString });
    }
    Intent localIntent = new Intent();
    if (paramBoolean) {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), paramString })));
    } else {
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString })));
    }
    if (paramActivity.getIntent() != null)
    {
      String str = paramActivity.getIntent().getStringExtra("pkg_name");
      paramString = str;
      if (!TextUtils.isEmpty(str)) {}
    }
    try
    {
      paramString = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
    }
    catch (Exception paramString)
    {
      label179:
      break label179;
    }
    paramString = null;
    localIntent.setPackage(paramString);
    try
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
      }
      return;
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sdk_share:sdk callback=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" appid=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" action=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    if (paramBoolean) {
      ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
    } else {
      ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString1 })));
    }
    if (paramActivity.getIntent() != null)
    {
      paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {}
    }
    try
    {
      paramString1 = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
    }
    catch (Exception paramString1)
    {
      label214:
      break label214;
    }
    paramString1 = null;
    ((Intent)localObject).setPackage(paramString1);
    try
    {
      paramActivity.startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
      }
      return;
    }
  }
  
  private void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      ForwardStatisticsReporter.a(paramString, paramBundle, paramBoolean);
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_c_of_type_Boolean) {
      ForwardStatisticsReporter.a(paramString);
    }
  }
  
  protected void I()
  {
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("desc");
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = localObject3;
      if (((String)localObject3).endsWith("...")) {
        localObject1 = ((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("..."));
      }
    }
    localObject3 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = localObject2;
      if (((String)localObject2).endsWith("...")) {
        localObject3 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("..."));
      }
    }
    localObject2 = localObject1;
    if (SubString.a((String)localObject1, "UTF-8") > 80) {
      localObject2 = SubString.a((String)localObject1, 80, "UTF-8", null);
    }
    localObject1 = localObject3;
    if (SubString.a((String)localObject3, "UTF-8") > 130) {
      localObject1 = SubString.a((String)localObject3, 130, "UTF-8", null);
    }
    localObject3 = localObject2;
    if (localObject2 != null)
    {
      localObject3 = localObject2;
      if (!((String)localObject2).endsWith("..."))
      {
        localObject3 = localObject2;
        if (!((String)localObject2).equals(this.jdField_a_of_type_AndroidOsBundle.getString("title")))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("...");
          localObject3 = ((StringBuilder)localObject3).toString();
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith("..."))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).equals(this.jdField_a_of_type_AndroidOsBundle.getString("desc")))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("...");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("title", (String)localObject3);
    this.jdField_a_of_type_AndroidOsBundle.putString("desc", (String)localObject2);
  }
  
  protected final void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "-->getQQAccountSKey--send g_t_n_p, account = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
    }
    if (this.jdField_c_of_type_Boolean)
    {
      String str = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_k_of_type_JavaLangString = str;
        this.n = true;
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->getQQAccountSKey--use TicketManager cache, account = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() });
        return;
      }
    }
    d("KEY_SSO_GET_TICKET_NO_PASSWD");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4096, this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption$MySSOAccountObserver);
  }
  
  void K()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("asyncUploadImageAndSendToBuddy mForwardSubType=");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_j_of_type_JavaLangString != null) {
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", this.jdField_j_of_type_JavaLangString);
    }
    if (this.jdField_e_of_type_Int != 5)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      if (!CGILoader.a((String)localObject))
      {
        M();
        return;
      }
      a(2131692117);
      ThreadManager.post(new ForwardSdkBaseOption.7(this, (String)localObject), 8, null, false);
      return;
    }
    a(2131692117);
    a("ForwardOption.ForwardSdkBaseOption", "ThreadManager.post asyncUploadImageAndSendToBuddy");
    ThreadManager.post(a(), 8, null, false);
  }
  
  protected void L() {}
  
  void M()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "realSendStructMsg mActivity.isFinishing()");
      L();
      return;
    }
    int i1 = 0;
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "realSendStructMsg, mForwardSubType = ", Integer.valueOf(this.jdField_e_of_type_Int) });
    A();
    if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1) == 2)
    {
      localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
      ((AbsStructMsg)localObject1).forwardID = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID", 0);
      if (j())
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getParcelableArrayList("forward_multi_target").iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject2).next();
          AbsShareMsg.sendSdkShareMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AbsShareMsg)localObject1, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
        }
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      i2 = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      AbsShareMsg.sendSdkShareMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AbsShareMsg)localObject1, (String)localObject2, i2, (String)localObject3);
    }
    else
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, MessageShareActivity.class);
      localObject2 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
      }
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).setFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i2 = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_share2qq", 1, "", "", String.valueOf(this.jdField_b_of_type_Long));
    if (this.jdField_e_of_type_Int == 5) {
      localObject1 = "connect_sharepic";
    } else {
      localObject1 = "connect_share2qq";
    }
    Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, (String)localObject1, "send", this.jdField_b_of_type_Long, f(), String.valueOf(i2));
    a(0, "", "");
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "83");
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(ReportDef.RepUtil.a(this.jdField_e_of_type_Int));
    ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(ReportDef.RepUtil.a(i2, (String)localObject2));
    ((Bundle)localObject1).putString("intext_2", ((StringBuilder)localObject3).toString());
    ((Bundle)localObject1).putString("intext_3", "0");
    ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, this.jdField_c_of_type_Boolean);
    localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    if ((this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "55");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo;
      if (localObject2 != null) {
        i1 = ((AppInfo)localObject2).a();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i1);
      ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
      ((Bundle)localObject1).putString("app_id", ((StringBuilder)localObject2).toString());
      ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, this.jdField_c_of_type_Boolean);
    }
  }
  
  protected Runnable a()
  {
    return new ForwardSdkBaseOption.8(this);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    A();
    int i1 = jdField_e_of_type_JavaLangInteger.intValue();
    boolean bool = true;
    if ((paramInt2 == i1) && (paramInt1 == 0)) {
      this.l = true;
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog == null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(new ForwardSdkBaseOption.10(this));
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690706);
    Object localObject = str;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"));
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a((String)localObject, c());
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131692109);
    localObject = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
    if (paramInt1 != 0) {
      bool = false;
    }
    ((ShareResultDialog)localObject).a(bool);
    if (paramInt1 == 0)
    {
      N();
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(null, null);
    }
    else
    {
      if (paramInt1 == 1002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!upload image fail---------------------------------");
        }
      }
      else if (paramInt1 == 1003) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131692112);
      } else if (paramInt1 == 1004)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!skey not ready fail---------------------------------");
        }
      }
      else if ((paramInt1 == 1005) && (QLog.isColorLevel())) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!vkey not ready fail---------------------------------");
      }
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131718224), c());
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.show();
      return;
    }
    catch (Exception localException)
    {
      label358:
      break label358;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "resultDlg.show() failed");
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt >= 0) {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null) {
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    }
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (!v())
    {
      super.a(paramInt, paramBundle);
      if (paramInt == g.intValue()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setEditLint("");
      }
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "81");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(this.jdField_e_of_type_Int));
      localBundle.putString("intext_1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
      localBundle.putString("intext_2", localStringBuilder.toString());
      localBundle.putString("intext_3", "0");
      ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, this.jdField_c_of_type_Boolean);
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
    {
      A();
      return;
    }
    if (!j()) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  protected void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new Bundle();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("report_type", "102");
    ((Bundle)localObject2).putString("act_type", "52");
    ((Bundle)localObject2).putString("intext_3", "0");
    ((Bundle)localObject2).putString("stringext_1", paramString1);
    ReportCenter.a().a((Bundle)localObject2, "", paramString2, false, this.jdField_c_of_type_Boolean);
    ForwardStatisticsReporter.a("batch_url_exchange");
    paramHashMap = HttpUtil.batchUrlExchange(BaseApplication.getContext(), paramString2, this.jdField_k_of_type_JavaLangString, 1, paramHashMap, (Bundle)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("param_ret_code", Integer.toString(((Bundle)localObject1).getInt("retcode", -1)));
    ForwardStatisticsReporter.a("batch_url_exchange", paramString2, (HashMap)localObject2, ((Bundle)localObject1).getBoolean("isSuccess"));
    l1 = System.currentTimeMillis() - l1;
    int i1;
    if ((paramHashMap != null) && (paramHashMap.size() > 0) && (((String)paramHashMap.get(paramHashMap.keySet().iterator().next())).contains("url.cn"))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("batchUrlExchange for IMAGE_SHARE, isFailed = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", cost = ");
      ((StringBuilder)localObject2).append(l1);
      localObject2 = ((StringBuilder)localObject2).toString();
      if ((i1 != 1) && (l1 <= 3000L)) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject2);
      } else {
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject2);
      }
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("report_type", "102");
    ((Bundle)localObject2).putString("act_type", "12");
    ((Bundle)localObject2).putString("intext_3", "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i1);
    ((Bundle)localObject2).putString("intext_1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((Bundle)localObject1).getInt("retcode", 0));
    ((Bundle)localObject2).putString("intext_2", localStringBuilder.toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l1);
    ((Bundle)localObject2).putString("intext_5", ((StringBuilder)localObject1).toString());
    if (i1 == 1) {
      ((Bundle)localObject2).putString("stringext_1", paramString1);
    }
    ReportCenter.a().a((Bundle)localObject2, "", paramString2, false, this.jdField_c_of_type_Boolean);
    if (paramHashMap != null)
    {
      if (paramHashMap.containsKey("imageUrl"))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)paramHashMap.get("imageUrl"));
        this.jdField_a_of_type_AndroidOsBundle.remove("image_url");
      }
      if (paramHashMap.containsKey("audioUrl")) {
        this.jdField_a_of_type_AndroidOsBundle.putString("audio_url", (String)paramHashMap.get("audioUrl"));
      }
      if (paramHashMap.containsKey("targetUrl")) {
        this.jdField_a_of_type_AndroidOsBundle.putString("detail_url", (String)paramHashMap.get("targetUrl"));
      }
      if (paramHashMap.containsKey("sourceUrl")) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", (String)paramHashMap.get("sourceUrl"));
      }
      if (paramHashMap.containsKey("sourceIcon")) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", (String)paramHashMap.get("sourceIcon"));
      }
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardSdkBaseOption.9(this));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive show forbidden dialog");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131719014));
    if (paramBoolean)
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719017);
      }
      localQQCustomDialog.setMessageWithUrl((String)localObject);
    }
    else
    {
      localQQCustomDialog.setMessage(2131719017);
    }
    Object localObject = localQQCustomDialog.setPositiveButton(2131718867, new ForwardSdkBaseOption.5(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_AndroidAppActivity.getString(2131690706));
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    localStringBuilder.append(paramString);
    ((QQCustomDialog)localObject).setNegativeButton(localStringBuilder.toString(), new ForwardSdkBaseOption.4(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  public boolean a()
  {
    super.a();
    Object localObject2 = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_j_of_type_Boolean = "login".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("jfrom"));
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name"))) && (!"1103584836".equals(String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id")))) && (!"101735437".equals(String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id"))))) {
      this.jdField_a_of_type_AndroidOsBundle.putLong("req_share_id", 65520L);
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    this.h = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("open_id");
    this.i = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("share_uin");
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    long l2 = ForwardUtils.a(this.jdField_a_of_type_AndroidOsBundle.getString("chSrc"));
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "preloadData subType=", Integer.valueOf(this.jdField_e_of_type_Int), ",targetUrl=", str3, ",remoteImg=", str1, ",localImg=", str2 });
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str3))
    {
      localObject1 = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject1 = str1;
        if (!HttpUtil.isValidUrl(str1)) {
          localObject1 = str1;
        }
      }
    }
    try
    {
      if (str1.startsWith("//"))
      {
        localObject1 = str1;
        str3 = new URL(str3).getProtocol();
        localObject1 = str1;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = str1;
        localStringBuilder.append(str3);
        localObject1 = str1;
        localStringBuilder.append(":");
        localObject1 = str1;
        localStringBuilder.append(str1);
        localObject1 = str1;
        str1 = localStringBuilder.toString();
        localObject1 = str1;
        this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", str1);
        localObject1 = str1;
      }
      else
      {
        localObject1 = null;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label441:
      long l3;
      long l4;
      break label441;
    }
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "repair invalid img url=", localObject1 });
    a(this.jdField_e_of_type_Int, this.jdField_c_of_type_Boolean);
    if (!a(str2, (String)localObject1)) {
      return false;
    }
    if (d())
    {
      b("KEY_STAGE_1_TOTAL", true);
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "-->preloadData-- null != mAppInfo");
      return true;
    }
    if ((l1 > 0L) && (!"101735437".equals(String.valueOf(l1))))
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.m = true;
      l3 = System.currentTimeMillis() / 1000L;
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
      if (TextUtils.isEmpty(str1))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append("");
        localObject1 = AuthorityUtil.a((Context)localObject1, str1, ((StringBuilder)localObject2).toString());
      }
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->sdk_share, getting appinfo in construct. sign: ", localObject1 });
      if (!(this instanceof ForwardSdkShareOption))
      {
        a(2131718408);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      }
      l4 = ForwardShareByServerHelper.a();
      d("KEY_GET_APP_INFO");
      Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), l1, (String)localObject1, l2, l3, this.jdField_a_of_type_ComTencentOpenAppcommonOpensdkBusinessObserver, str1, l4, true);
      return true;
    }
    if ((this instanceof ForwardSdkShareOption)) {
      a("", false);
    }
    return true;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if ((this.jdField_e_of_type_Int == 5) && (TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "-->preloadData--is image share type, but imageUrl and remoteImageUrl are both empty");
      }
      a(-1, HardCodeUtil.a(2131704901), HardCodeUtil.a(2131704913));
    }
    try
    {
      OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
      label90:
      return false;
      return true;
    }
    catch (Exception paramString1)
    {
      break label90;
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      ForwardStatisticsReporter.a(paramString, paramBoolean);
    }
  }
  
  protected boolean d()
  {
    return ((ForwardSdkStatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SDK_SHARE)).a().a();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.a())
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.a())) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.a());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.e();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon_big", (String)localObject);
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.b())) && (this.jdField_b_of_type_Long != Long.parseLong("1103584836"))) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_url", this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.b());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.c())) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_name", this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.c());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.d())) {
        this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_a_action_data", this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.d());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
      if (localObject != null)
      {
        ((AbsShareMsg)localObject).mSourceIcon = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_icon");
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.jdField_a_of_type_AndroidOsBundle.getString("struct_share_key_source_name");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName)) {
          this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mSourceName = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
        }
      }
      this.jdField_a_of_type_AndroidOsBundle.putByte("struct_share_key_app_info_status", (byte)1);
      u();
    }
  }
  
  public int f()
  {
    AbsShareMsg localAbsShareMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if (localAbsShareMsg != null) {
      return localAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  protected void p()
  {
    if (this.l) {
      a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", this.jdField_b_of_type_Long);
    } else {
      a(this.jdField_a_of_type_AndroidAppActivity, false, "shareToQQ", this.jdField_b_of_type_Long);
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "back call");
    }
  }
  
  protected void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "send call");
    }
    K();
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "82");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReportDef.RepUtil.a(this.jdField_e_of_type_Int));
    localBundle.putString("intext_1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReportDef.RepUtil.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
    localBundle.putString("intext_2", localStringBuilder.toString());
    localBundle.putString("intext_3", "0");
    ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, this.jdField_c_of_type_Boolean);
  }
  
  protected boolean u()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo == null) {
        return false;
      }
      Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqForwardAppInfo.e();
        this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
        if (localObject2 != null)
        {
          ((AbsShareMsg)localObject2).updateCover((String)localObject1);
          this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(2);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkAndUseAppIcon|use app icon:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ForwardSdkBaseOption", 1, ((StringBuilder)localObject2).toString());
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("report_type", "102");
        ((Bundle)localObject2).putString("act_type", "18");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        ((Bundle)localObject2).putString("intext_1", (String)localObject1);
        localObject1 = ReportCenter.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        ((ReportCenter)localObject1).a((Bundle)localObject2, localStringBuilder.toString(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false, this.jdField_c_of_type_Boolean);
        return true;
      }
    }
    return false;
  }
  
  protected boolean v()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("req_type");
    boolean bool2 = false;
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "QQShare find local image shareType:", Integer.valueOf(i1) });
    boolean bool1 = bool2;
    if (i1 == 5)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (!str.startsWith("http://"))
        {
          bool1 = bool2;
          if (!str.startsWith("https://"))
          {
            boolean bool3 = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext);
            Object localObject = this.jdField_a_of_type_AndroidContentContext.getExternalFilesDir(null);
            if (localObject != null) {
              localObject = ((File)localObject).getAbsolutePath();
            } else {
              localObject = "";
            }
            QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "QQShare find local image hasSDPermission:", Boolean.valueOf(bool3), ", localImageUrl:", str, ",appSpecificPath=", localObject });
            bool1 = bool2;
            if (!bool3)
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                bool1 = bool2;
                if (!str.contains((CharSequence)localObject))
                {
                  bool1 = bool2;
                  if (this.jdField_a_of_type_AndroidAppActivity != null)
                  {
                    bool1 = bool2;
                    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
                    {
                      localObject = new ForwardSdkBaseOption.2(this);
                      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 233, HardCodeUtil.a(2131719632), HardCodeUtil.a(2131719016), -1, 2131719015, (DialogInterface.OnClickListener)localObject, null).show();
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean w()
  {
    return true;
  }
  
  public void z()
  {
    super.z();
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    Object localObject = this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog;
    if ((localObject != null) && (((ShareResultDialog)localObject).isShowing())) {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_b_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption
 * JD-Core Version:    0.7.0.1
 */