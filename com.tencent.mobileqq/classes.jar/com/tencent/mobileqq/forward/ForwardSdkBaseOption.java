package com.tencent.mobileqq.forward;

import adtk;
import adtl;
import adtm;
import adtn;
import adto;
import adtp;
import adtq;
import adtt;
import adtu;
import adtv;
import adty;
import adtz;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
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
import com.tencent.mobileqq.activity.aio.MessageShareActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public abstract class ForwardSdkBaseOption
  extends ForwardBaseOption
  implements ReportDef
{
  public static final Object a;
  adty jdField_a_of_type_Adty = new adty(this);
  public adtz a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new adtk(this);
  public Handler a;
  public AbsShareMsg a;
  public GetAppInfoProto.GetAppinfoResponse a;
  private HandlerPlus jdField_a_of_type_CooperationQqfavUtilHandlerPlus = new HandlerPlus(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  protected BusinessObserver a;
  public int b;
  public long b;
  @SuppressLint({"HandlerLeak"})
  private Handler b;
  protected ShareResultDialog b;
  public int c;
  public long c;
  public String f;
  protected String g;
  protected boolean g;
  protected String h = "";
  public boolean h;
  public String i;
  public boolean i;
  public boolean j;
  public boolean k;
  public volatile boolean l = false;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public ForwardSdkBaseOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_a_of_type_MqqObserverBusinessObserver = new adtq(this);
    this.jdField_b_of_type_AndroidOsHandler = new adtt(this);
  }
  
  private void A()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "changeRemoteUrl|url=" + str);
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    ThreadManager.post(new adtp(this, str), 8, null, true);
  }
  
  private void B()
  {
    try
    {
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    Object localObject2;
    int m;
    Object localObject3;
    label157:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "realSendStructMsg, mForwardSubType = " + this.jdField_b_of_type_Int);
      }
      t();
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("forward_type", -1) != 2) {
        break;
      }
      localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      m = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      AbsShareMsg.sendSdkShareMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (AbsShareMsg)localObject1, (String)localObject2, m, (String)localObject3);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sha_share2qq", 1, "", "", String.valueOf(this.jdField_b_of_type_Long));
      if (this.jdField_b_of_type_Int != 5) {
        break label568;
      }
      localObject1 = "connect_sharepic";
      Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("uin"), (String)localObject1, "send", this.jdField_b_of_type_Long, e(), String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype")));
      a(0, "", "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "83");
      ((Bundle)localObject1).putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
      ((Bundle)localObject1).putString("intext_2", "" + ReportDef.RepUtil.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
      ((Bundle)localObject1).putString("intext_3", "0");
      ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    } while ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty((CharSequence)localObject1)));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "55");
    int n;
    if ((this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse != null) && (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL.has()))
    {
      localObject2 = this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL.get();
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        m = 0;
        for (;;)
        {
          n = m;
          if (!((Iterator)localObject2).hasNext()) {
            break label625;
          }
          localObject3 = (GetAppInfoProto.MsgIconsurl)((Iterator)localObject2).next();
          if ("16".equals(((GetAppInfoProto.MsgIconsurl)localObject3).size.get()))
          {
            m |= 0x1;
            continue;
            localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, MessageShareActivity.class);
            localObject2 = new Bundle(this.jdField_a_of_type_AndroidOsBundle);
            if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
              ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(null);
            }
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            ((Intent)localObject1).setFlags(67108864);
            this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
            break;
            label568:
            localObject1 = "connect_share2qq";
            break label157;
          }
          if (!"64".equals(((GetAppInfoProto.MsgIconsurl)localObject3).size.get())) {
            break label599;
          }
          m |= 0x2;
        }
        label599:
        if (!"100".equals(((GetAppInfoProto.MsgIconsurl)localObject3).size.get())) {
          break label698;
        }
        m |= 0x4;
      }
    }
    label698:
    for (;;)
    {
      break;
      n = 0;
      label625:
      ((Bundle)localObject1).putString("intext_1", "" + n);
      ((Bundle)localObject1).putString("app_id", "" + this.jdField_b_of_type_Long);
      ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
    }
  }
  
  public static final void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    long l1 = 0L;
    if ((paramActivity == null) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = paramIntent.getBundleExtra("share_data");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramIntent.getExtras();
      }
      paramIntent = "shareToQzone";
      if (localObject1 != null)
      {
        localObject2 = ((Bundle)localObject1).getString("share_action");
        paramIntent = (Intent)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramIntent = "shareToQzone";
        }
      }
      if (localObject1 != null) {
        l1 = ((Bundle)localObject1).getLong("req_share_id", 0L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + l1 + " action=" + "shareToQzone");
      }
      localObject2 = new Intent();
      if (paramBoolean)
      {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l1), paramIntent })));
        if (localObject1 == null) {}
      }
      try
      {
        ((Intent)localObject2).setPackage(((Bundle)localObject1).getString("pkg_name"));
        try
        {
          paramActivity.startActivity((Intent)localObject2);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity, new Object[0]);
        return;
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(l1), paramIntent })));
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          ((Intent)localObject2).setPackage(null);
        }
      }
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramLong + " action=" + paramString);
      }
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), paramString })));
        if (paramActivity.getIntent() != null)
        {
          String str = paramActivity.getIntent().getStringExtra("pkg_name");
          paramString = str;
          if (!TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        paramString = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
        return;
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString })));
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
  }
  
  public static final void a(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "sdk_share:sdk callback=" + paramBoolean + " appid=" + paramLong + " action=" + paramString1);
      }
      Intent localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
        if (paramActivity.getIntent() != null)
        {
          paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
          paramString1 = paramString2;
          if (!TextUtils.isEmpty(paramString2)) {}
        }
      }
      try
      {
        paramString1 = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString1);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, paramActivity.getMessage());
        return;
        localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(paramLong), paramString1 })));
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
  }
  
  private boolean m()
  {
    if ((!this.jdField_c_of_type_Boolean) || (!this.l) || (this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null)) {
      return false;
    }
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      str = Share.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.iconsURL, 100);
      this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", str);
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.updateCover(str);
        this.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendEmptyMessage(2);
      }
      QLog.i("ForwardSdkBaseOption", 1, "checkAndUseAppIcon|use app icon:" + str);
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "18");
      if (TextUtils.isEmpty(str)) {}
      for (str = "1";; str = "0")
      {
        ((Bundle)localObject).putString("intext_1", str);
        ReportCenter.a().a((Bundle)localObject, "" + this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
        return true;
      }
    }
    return false;
  }
  
  private void z()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("desc");
    String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    if ((TextUtils.isEmpty(str5)) && (TextUtils.isEmpty(str4))) {
      this.jdField_c_of_type_Int |= 0x1;
    }
    if (TextUtils.isEmpty(str3)) {
      this.jdField_c_of_type_Int |= 0x2;
    }
    if (TextUtils.isEmpty(str2)) {
      this.jdField_c_of_type_Int |= 0x4;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "54");
    localBundle.putString("app_id", "" + this.jdField_b_of_type_Long);
    localBundle.putString("stringext_1", str1);
    localBundle.putString("intext_2", "" + this.jdField_c_of_type_Int);
    ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "checkAndRich|lack=" + this.jdField_c_of_type_Int);
    }
    if (this.jdField_c_of_type_Int <= 0)
    {
      A();
      return;
    }
    ThreadManager.post(new adto(this, str1, str2, str3, str5, str4), 5, null, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    t();
    if ((paramInt2 == e.intValue()) && (paramInt1 == 0)) {
      this.i = true;
    }
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog == null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog = new ShareResultDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(new adtl(this));
    }
    for (;;)
    {
      String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131433712);
      Object localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("app_name"))) {
        localObject = str + this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      }
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a((String)localObject, c());
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131429905);
      localObject = this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog;
      boolean bool;
      if (paramInt1 == 0)
      {
        bool = true;
        label181:
        ((ShareResultDialog)localObject).a(bool);
        if (paramInt1 != 0) {
          break label227;
        }
        B();
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(null, null);
      }
      try
      {
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.show();
        return;
        this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
        continue;
        bool = false;
        break label181;
        label227:
        if (paramInt1 == 1002) {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!upload image fail---------------------------------");
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.b(this.jdField_a_of_type_AndroidAppActivity.getString(2131433363), c());
          break;
          if (paramInt1 == 1003) {
            this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.a(2131430160);
          } else if (paramInt1 == 1004)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!skey not ready fail---------------------------------");
            }
          }
          else if ((paramInt1 == 1005) && (QLog.isColorLevel())) {
            QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!vkey not ready fail---------------------------------");
          }
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "resultDlg.show() failed");
      }
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
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      super.a(paramInt, paramBundle);
    } while (paramBundle == null);
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "81");
    localBundle.putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
    localBundle.putString("intext_2", "" + ReportDef.RepUtil.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity))
    {
      t();
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public boolean a()
  {
    super.a();
    this.h = "";
    this.jdField_g_of_type_Boolean = "login".equals(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("jfrom"));
    l3 = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pkg_name"))) && (!"1103584836".equals(String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id"))))) {
      this.jdField_a_of_type_AndroidOsBundle.putLong("req_share_id", 65520L);
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    this.f = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("open_id");
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("share_uin");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
    localObject5 = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
    localObject4 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("image_url_remote");
    l1 = 0L;
    try
    {
      l2 = Long.parseLong(this.jdField_a_of_type_AndroidOsBundle.getString("chSrc"));
      l1 = l2;
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Object localObject1;
          label394:
          OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(this.jdField_b_of_type_Long), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
          return false;
          localException1 = localException1;
          QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "Format error.");
          continue;
          localObject2 = null;
        }
        if (l3 <= 0L) {
          break label795;
        }
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        this.j = true;
        long l2 = System.currentTimeMillis() / 1000L;
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label762;
        }
        localObject2 = "";
        if (!QLog.isColorLevel()) {
          break label717;
        }
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "-->sdk_share, getting appinfo in construct. sign: " + (String)localObject2);
        a(2131434147);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        Share.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), l3, (String)localObject2, l1, l2, this.jdField_a_of_type_MqqObserverBusinessObserver);
        for (;;)
        {
          return true;
          localObject2 = AgentActivity.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, l2 + "");
          break;
          if ((this instanceof ForwardSdkShareOption))
          {
            localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
            localObject4 = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230).setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131435605)).setMessage(2131435606).setPositiveButton(2131430153, new adtn(this));
            localObject5 = new StringBuilder().append(this.jdField_a_of_type_AndroidAppActivity.getString(2131433712));
            localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = "";
            }
            localObject2 = ((QQCustomDialog)localObject4).setNegativeButton((String)localObject2, new adtm(this));
            ((Dialog)localObject2).setCancelable(false);
            ((Dialog)localObject2).show();
          }
        }
      }
      catch (Exception localException2)
      {
        break label611;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "preloadData|subType=" + this.jdField_b_of_type_Int + ",targetUrl=" + (String)localObject5 + ",remoteImg=" + (String)localObject3 + ",localImg=" + (String)localObject4);
    }
    localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = localObject3;
        if (!HttpUtil.a((String)localObject3)) {
          localObject1 = localObject3;
        }
      }
    }
    try
    {
      if (!((String)localObject3).startsWith("//")) {
        break label627;
      }
      localObject1 = localObject3;
      localObject5 = new URL((String)localObject5).getProtocol();
      localObject1 = localObject3;
      localObject3 = (String)localObject5 + ":" + (String)localObject3;
      localObject1 = localObject3;
      this.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)localObject3);
      localObject1 = localObject3;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Object localObject2;
      break label394;
    }
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "repair invalid img url=" + localObject1);
    localObject3 = new Bundle();
    ((Bundle)localObject3).putString("report_type", "102");
    ((Bundle)localObject3).putString("act_type", "80");
    ((Bundle)localObject3).putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
    ((Bundle)localObject3).putString("intext_3", "0");
    ReportCenter.a().a((Bundle)localObject3, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (this.jdField_c_of_type_Boolean) {
      z();
    }
    if ((this.jdField_b_of_type_Int == 5) && (TextUtils.isEmpty((CharSequence)localObject4)) && (TextUtils.isEmpty(localObject1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "-->preloadData--is image share type, but imageUrl and remoteImageUrl are both empty");
      }
      a(-1, "请选择图片", "分享的图片不存在");
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null) {
      return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  protected void k()
  {
    if (this.i) {
      a(this.jdField_a_of_type_AndroidAppActivity, true, "shareToQQ", this.jdField_b_of_type_Long);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(1);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "back call");
      }
      return;
      a(this.jdField_a_of_type_AndroidAppActivity, false, "shareToQQ", this.jdField_b_of_type_Long);
    }
  }
  
  protected void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "send call");
    }
    y();
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "82");
    localBundle.putString("intext_1", "" + ReportDef.RepUtil.a(this.jdField_b_of_type_Int));
    localBundle.putString("intext_2", "" + ReportDef.RepUtil.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"), this.jdField_a_of_type_AndroidOsBundle.getString("uin")));
    localBundle.putString("intext_3", "0");
    ReportCenter.a().a(localBundle, "", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public void s()
  {
    super.s();
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
  }
  
  protected void w()
  {
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
    Object localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("desc");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (((String)localObject2).endsWith("...")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("..."));
      }
    }
    localObject2 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject3;
      if (((String)localObject3).endsWith("...")) {
        localObject2 = ((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("..."));
      }
    }
    localObject3 = localObject1;
    if (SubString.a((String)localObject1, "UTF-8") > 80) {
      localObject3 = SubString.a((String)localObject1, 80, "UTF-8", null);
    }
    localObject1 = localObject2;
    if (SubString.a((String)localObject2, "UTF-8") > 130) {
      localObject1 = SubString.a((String)localObject2, 130, "UTF-8", null);
    }
    if ((localObject3 != null) && (!((String)localObject3).endsWith("...")) && (!((String)localObject3).equals(this.jdField_a_of_type_AndroidOsBundle.getString("title")))) {}
    for (localObject2 = (String)localObject3 + "...";; localObject2 = localObject3)
    {
      if ((localObject1 != null) && (!((String)localObject1).endsWith("...")) && (!((String)localObject1).equals(this.jdField_a_of_type_AndroidOsBundle.getString("desc")))) {
        localObject1 = (String)localObject1 + "...";
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("title", (String)localObject2);
        this.jdField_a_of_type_AndroidOsBundle.putString("desc", (String)localObject1);
        return;
      }
    }
  }
  
  public final void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "-->getQQAccountSKey--send g_t_n_p, account = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.ssoGetTicketNoPasswd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4096, this.jdField_a_of_type_Adty);
  }
  
  void y()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "asyncUploadImageAndSendToBuddy mForwardSubType=" + this.jdField_b_of_type_Int);
    }
    if (this.h != null) {
      this.jdField_a_of_type_AndroidOsBundle.putString("share_comment_message", this.h);
    }
    if (this.jdField_b_of_type_Int != 5)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("detail_url");
      if (!CGILoader.a((String)localObject))
      {
        C();
        return;
      }
      a(2131430159);
      ThreadManager.post(new adtu(this, (String)localObject), 8, null, false);
      return;
    }
    a(2131430159);
    Object localObject = new adtv(this);
    if (QLog.isDevelopLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 4, "ThreadManager.post asyncUploadImageAndSendToBuddy");
    }
    ThreadManager.post((Runnable)localObject, 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption
 * JD-Core Version:    0.7.0.1
 */