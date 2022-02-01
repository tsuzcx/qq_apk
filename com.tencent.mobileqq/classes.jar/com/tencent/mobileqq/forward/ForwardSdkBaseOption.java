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
  protected static final Object ap = new Object();
  public long a;
  protected String ad;
  protected String ae;
  protected boolean af;
  protected Handler ag;
  protected boolean ah = false;
  protected String ai = "";
  protected ShareResultDialog aj;
  protected boolean ak = false;
  protected ForwardSdkBaseOption.PreStructViewHolder al;
  protected AbsShareMsg am;
  protected long an = 0L;
  protected boolean ao;
  protected AppInfo aq;
  public int ar;
  protected boolean as = false;
  protected String at = null;
  protected OpensdkBusinessObserver au = new ForwardSdkBaseOption.3(this);
  ForwardSdkBaseOption.MySSOAccountObserver av = new ForwardSdkBaseOption.MySSOAccountObserver(this);
  private Handler.Callback aw = new ForwardSdkBaseOption.1(this);
  private HandlerPlus ax = new HandlerPlus(Looper.getMainLooper(), this.aw);
  @SuppressLint({"HandlerLeak"})
  private Handler ay = new ForwardSdkBaseOption.6(this);
  
  public ForwardSdkBaseOption(Intent paramIntent)
  {
    super(paramIntent);
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
    ReportCenter.a().a(localBundle, "", this.q.getCurrentAccountUin(), false, paramBoolean);
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
      long l = 0L;
      if (localObject1 != null) {
        l = ((Bundle)localObject1).getLong("req_share_id", 0L);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sdk_share:sdk callback=");
        ((StringBuilder)localObject2).append(paramBoolean);
        ((StringBuilder)localObject2).append(" appid=");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" action=");
        ((StringBuilder)localObject2).append("shareToQzone");
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Intent();
      if (paramBoolean) {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(l), paramIntent })));
      } else {
        ((Intent)localObject2).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", new Object[] { Long.valueOf(l), paramIntent })));
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
      label249:
      break label249;
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
      label178:
      break label178;
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
      label213:
      break label213;
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
  
  private void a(String paramString)
  {
    if (this.F) {
      ForwardStatisticsReporter.a(paramString);
    }
  }
  
  private void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.F) {
      ForwardStatisticsReporter.a(paramString, paramBundle, paramBoolean);
    }
  }
  
  private void aE()
  {
    String str1 = this.aq.d();
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    this.t.putString("struct_share_key_source_name", str1);
    String str2 = this.t.getString("app_name");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(", pkgName=");
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "oldAppName=", str2, ", mAppInfo.appName=", localStringBuilder.toString(), this.aq.e() });
    if ((TextUtils.isEmpty(str2)) || (str2.equals(this.aq.e()))) {
      this.t.putString("app_name", this.aq.d());
    }
  }
  
  private void aF()
  {
    try
    {
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", this.q.getCurrentAccountUin(), String.valueOf(this.a), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void R()
  {
    if (this.ak) {
      a(this.s, true, "shareToQQ", this.a);
    } else {
      a(this.s, false, "shareToQQ", this.a);
    }
    this.s.setResult(1);
    this.s.finish();
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "back call");
    }
  }
  
  protected void S()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardSdkBaseOption", 2, "send call");
    }
    aA();
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "82");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReportDef.RepUtil.a(this.ar));
    localBundle.putString("intext_1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReportDef.RepUtil.a(this.t.getInt("uintype"), this.t.getString("uin")));
    localBundle.putString("intext_2", localStringBuilder.toString());
    localBundle.putString("intext_3", "0");
    ReportCenter.a().a(localBundle, "", this.q.getCurrentAccountUin(), false, this.F);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((this.A != null) && (this.A.isShowing())) {
      this.A.dismiss();
    }
    ae();
    int i = f.intValue();
    boolean bool = true;
    if ((paramInt2 == i) && (paramInt1 == 0)) {
      this.ak = true;
    }
    if (this.B == null)
    {
      this.B = new ShareResultDialog(this.s);
      this.B.a(new ForwardSdkBaseOption.10(this));
    }
    else
    {
      this.B.dismiss();
    }
    String str = this.s.getString(2131887625);
    Object localObject = str;
    if (!TextUtils.isEmpty(this.t.getString("app_name")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.t.getString("app_name"));
      localObject = ((StringBuilder)localObject).toString();
    }
    this.B.a((String)localObject, Q());
    this.B.a(2131889090);
    localObject = this.B;
    if (paramInt1 != 0) {
      bool = false;
    }
    ((ShareResultDialog)localObject).a(bool);
    if (paramInt1 == 0)
    {
      aF();
      this.B.b(null, null);
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
        this.B.a(2131889093);
      } else if (paramInt1 == 1004)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!skey not ready fail---------------------------------");
        }
      }
      else if ((paramInt1 == 1005) && (QLog.isColorLevel())) {
        QLog.d("ForwardOption.ForwardSdkBaseOption", 2, "!!!vkey not ready fail---------------------------------");
      }
      this.B.b(this.s.getString(2131915706), Q());
    }
    try
    {
      this.B.show();
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
      this.t.putInt("key_forward_ability_type", paramInt);
    }
    if (paramBundle != null) {
      this.t.putAll(paramBundle);
    }
    if (this.s.isFinishing()) {
      return;
    }
    if (!au())
    {
      super.a(paramInt, paramBundle);
      if (paramInt == h.intValue()) {
        this.A.setEditLint("");
      }
    }
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "81");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(this.ar));
      localBundle.putString("intext_1", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ReportDef.RepUtil.a(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
      localBundle.putString("intext_2", localStringBuilder.toString());
      localBundle.putString("intext_3", "0");
      ReportCenter.a().a(localBundle, "", this.q.getCurrentAccountUin(), false, this.F);
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    this.s.setResult(-1, localIntent);
    if ((this.s instanceof SplashActivity))
    {
      ae();
      return;
    }
    if (!K()) {
      this.s.finish();
    }
  }
  
  protected void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new Bundle();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("report_type", "102");
    ((Bundle)localObject2).putString("act_type", "52");
    ((Bundle)localObject2).putString("intext_3", "0");
    ((Bundle)localObject2).putString("stringext_1", paramString1);
    ReportCenter.a().a((Bundle)localObject2, "", paramString2, false, this.F);
    ForwardStatisticsReporter.a("batch_url_exchange");
    paramHashMap = HttpUtil.batchUrlExchange(BaseApplication.getContext(), paramString2, this.at, 1, paramHashMap, (Bundle)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("param_ret_code", Integer.toString(((Bundle)localObject1).getInt("retcode", -1)));
    ForwardStatisticsReporter.a("batch_url_exchange", paramString2, (HashMap)localObject2, ((Bundle)localObject1).getBoolean("isSuccess"));
    l = System.currentTimeMillis() - l;
    int i;
    if ((paramHashMap != null) && (paramHashMap.size() > 0) && (((String)paramHashMap.get(paramHashMap.keySet().iterator().next())).contains("url.cn"))) {
      i = 0;
    } else {
      i = 1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("batchUrlExchange for IMAGE_SHARE, isFailed = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", cost = ");
      ((StringBuilder)localObject2).append(l);
      localObject2 = ((StringBuilder)localObject2).toString();
      if ((i != 1) && (l <= 3000L)) {
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
    localStringBuilder.append(i);
    ((Bundle)localObject2).putString("intext_1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(((Bundle)localObject1).getInt("retcode", 0));
    ((Bundle)localObject2).putString("intext_2", localStringBuilder.toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l);
    ((Bundle)localObject2).putString("intext_5", ((StringBuilder)localObject1).toString());
    if (i == 1) {
      ((Bundle)localObject2).putString("stringext_1", paramString1);
    }
    ReportCenter.a().a((Bundle)localObject2, "", paramString2, false, this.F);
    if (paramHashMap != null)
    {
      if (paramHashMap.containsKey("imageUrl"))
      {
        this.t.putString("image_url_remote", (String)paramHashMap.get("imageUrl"));
        this.t.remove("image_url");
      }
      if (paramHashMap.containsKey("audioUrl")) {
        this.t.putString("audio_url", (String)paramHashMap.get("audioUrl"));
      }
      if (paramHashMap.containsKey("targetUrl")) {
        this.t.putString("detail_url", (String)paramHashMap.get("targetUrl"));
      }
      if (paramHashMap.containsKey("sourceUrl")) {
        this.t.putString("struct_share_key_source_url", (String)paramHashMap.get("sourceUrl"));
      }
      if (paramHashMap.containsKey("sourceIcon")) {
        this.t.putString("struct_share_key_source_icon", (String)paramHashMap.get("sourceIcon"));
      }
    }
    this.s.runOnUiThread(new ForwardSdkBaseOption.9(this));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive show forbidden dialog");
    String str = this.t.getString("app_name");
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.s, 230);
    localQQCustomDialog.setTitle(this.s.getString(2131916549));
    if (paramBoolean)
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.s.getString(2131916552);
      }
      localQQCustomDialog.setMessageWithUrl((String)localObject);
    }
    else
    {
      localQQCustomDialog.setMessage(2131916552);
    }
    Object localObject = localQQCustomDialog.setPositiveButton(2131916400, new ForwardSdkBaseOption.5(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.s.getString(2131887625));
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    localStringBuilder.append(paramString);
    ((QQCustomDialog)localObject).setNegativeButton(localStringBuilder.toString(), new ForwardSdkBaseOption.4(this));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if ((this.ar == 5) && (TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "-->preloadData--is image share type, but imageUrl and remoteImageUrl are both empty");
      }
      a(-1, HardCodeUtil.a(2131902793), HardCodeUtil.a(2131902805));
    }
    try
    {
      OpenSdkStatic.a().a(1, "SHARE_CHECK_AGENT", this.q.getCurrentAccountUin(), String.valueOf(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享的图片不存在");
      label90:
      return false;
      return true;
    }
    catch (Exception paramString1)
    {
      break label90;
    }
  }
  
  void aA()
  {
    if ((this.A != null) && (this.A.isShowing())) {
      this.A.dismiss();
    }
    if ((this.B != null) && (this.B.isShowing())) {
      this.B.dismiss();
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("asyncUploadImageAndSendToBuddy mForwardSubType=");
      ((StringBuilder)localObject).append(this.ar);
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, ((StringBuilder)localObject).toString());
    }
    if (this.ai != null) {
      this.t.putString("share_comment_message", this.ai);
    }
    if (this.ar != 5)
    {
      localObject = this.t.getString("detail_url");
      if (!CGILoader.a((String)localObject))
      {
        aD();
        return;
      }
      a(2131889098);
      ThreadManager.post(new ForwardSdkBaseOption.7(this, (String)localObject), 8, null, false);
      return;
    }
    a(2131889098);
    b("ForwardOption.ForwardSdkBaseOption", "ThreadManager.post asyncUploadImageAndSendToBuddy");
    ThreadManager.post(aB(), 8, null, false);
  }
  
  protected Runnable aB()
  {
    return new ForwardSdkBaseOption.8(this);
  }
  
  protected void aC() {}
  
  void aD()
  {
    if (this.s.isFinishing())
    {
      QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "realSendStructMsg mActivity.isFinishing()");
      aC();
      return;
    }
    int i = 0;
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "realSendStructMsg, mForwardSubType = ", Integer.valueOf(this.ar) });
    ae();
    if (this.r.getIntExtra("forward_type", -1) == 2)
    {
      localObject1 = StructMsgFactory.a(this.t);
      ((AbsStructMsg)localObject1).forwardID = this.t.getInt("KEY_MSG_FORWARD_ID", 0);
      if (K())
      {
        localObject2 = this.t.getParcelableArrayList("forward_multi_target").iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject2).next();
          AbsShareMsg.sendSdkShareMessage(this.q, (AbsShareMsg)localObject1, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).getUinType(), ((ResultRecord)localObject3).groupUin);
        }
      }
      localObject2 = this.t.getString("uin");
      j = this.t.getInt("uintype");
      localObject3 = this.t.getString("troop_uin");
      AbsShareMsg.sendSdkShareMessage(this.q, (AbsShareMsg)localObject1, (String)localObject2, j, (String)localObject3);
    }
    else
    {
      localObject1 = new Intent(this.s, MessageShareActivity.class);
      localObject2 = new Bundle(this.t);
      if ((this.s instanceof IphoneTitleBarActivity)) {
        ((IphoneTitleBarActivity)this.s).setTitle(null);
      }
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ((Intent)localObject1).setFlags(67108864);
      this.s.startActivity((Intent)localObject1);
    }
    Object localObject2 = this.t.getString("uin");
    int j = this.t.getInt("uintype");
    this.t.getString("troop_uin");
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(this.q, "sha_share2qq", 1, "", "", String.valueOf(this.a));
    if (this.ar == 5) {
      localObject1 = "connect_sharepic";
    } else {
      localObject1 = "connect_share2qq";
    }
    Util.a(this.q, (String)localObject2, (String)localObject1, "send", this.a, ay(), String.valueOf(j));
    a(0, "", "");
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "83");
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(ReportDef.RepUtil.a(this.ar));
    ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(ReportDef.RepUtil.a(j, (String)localObject2));
    ((Bundle)localObject1).putString("intext_2", ((StringBuilder)localObject3).toString());
    ((Bundle)localObject1).putString("intext_3", "0");
    ReportCenter.a().a((Bundle)localObject1, "", this.q.getCurrentAccountUin(), false, this.F);
    localObject1 = this.t.getString("detail_url");
    if ((this.F) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "55");
      localObject2 = this.aq;
      if (localObject2 != null) {
        i = ((AppInfo)localObject2).g();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i);
      ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.a);
      ((Bundle)localObject1).putString("app_id", ((StringBuilder)localObject2).toString());
      ReportCenter.a().a((Bundle)localObject1, "", this.q.getCurrentAccountUin(), false, this.F);
    }
  }
  
  public void ad()
  {
    super.ad();
    if ((this.B != null) && (this.B.isShowing())) {
      this.B.dismiss();
    }
    Object localObject = this.aj;
    if ((localObject != null) && (((ShareResultDialog)localObject).isShowing())) {
      this.aj.dismiss();
    }
    localObject = this.ag;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.ay;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(0);
      this.ay = null;
    }
  }
  
  protected boolean au()
  {
    String str = this.t.getString("image_url");
    int i = this.t.getInt("req_type");
    boolean bool2 = false;
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "QQShare find local image shareType:", Integer.valueOf(i) });
    boolean bool1 = bool2;
    if (i == 5)
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
            boolean bool3 = ForwardUtils.a(this.I);
            Object localObject = this.I.getExternalFilesDir(null);
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
                  if (this.s != null)
                  {
                    bool1 = bool2;
                    if (!this.s.isFinishing())
                    {
                      localObject = new ForwardSdkBaseOption.2(this);
                      DialogUtil.a(this.s, 233, HardCodeUtil.a(2131917233), HardCodeUtil.a(2131916551), -1, 2131916550, (DialogInterface.OnClickListener)localObject, null).show();
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
  
  protected void av()
  {
    if (this.aq.a())
    {
      if (!TextUtils.isEmpty(this.aq.b())) {
        this.t.putString("struct_share_key_source_icon", this.aq.b());
      }
      Object localObject = this.aq.f();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.t.putString("struct_share_key_source_icon_big", (String)localObject);
      }
      if ((!TextUtils.isEmpty(this.aq.c())) && (this.a != Long.parseLong("1103584836"))) {
        this.t.putString("struct_share_key_source_url", this.aq.c());
      }
      aE();
      if (!TextUtils.isEmpty(this.aq.e())) {
        this.t.putString("struct_share_key_source_a_action_data", this.aq.e());
      }
      localObject = this.am;
      if (localObject != null)
      {
        ((AbsShareMsg)localObject).mSourceIcon = this.t.getString("struct_share_key_source_icon");
        this.am.mSourceName = this.t.getString("struct_share_key_source_name");
        if (TextUtils.isEmpty(this.am.mSourceName)) {
          this.am.mSourceName = this.t.getString("app_name");
        }
      }
      this.t.putByte("struct_share_key_app_info_status", (byte)1);
      p();
    }
  }
  
  protected void aw()
  {
    Object localObject3 = this.t.getString("title");
    Object localObject2 = this.t.getString("desc");
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
        if (!((String)localObject2).equals(this.t.getString("title")))
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
        if (!((String)localObject1).equals(this.t.getString("desc")))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("...");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    this.t.putString("title", (String)localObject3);
    this.t.putString("desc", (String)localObject2);
  }
  
  protected final void ax()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, new Object[] { "-->getQQAccountSKey--send g_t_n_p, account = ", this.q.getAccount() });
    }
    if (this.F)
    {
      String str = ((TicketManager)this.q.getManager(2)).getSkey(this.q.getCurrentAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        this.at = str;
        this.as = true;
        QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->getQQAccountSKey--use TicketManager cache, account = ", AuthorityUtil.a(this.q.getAccount()) });
        return;
      }
    }
    a("KEY_SSO_GET_TICKET_NO_PASSWD");
    this.q.ssoGetTicketNoPasswd(this.q.getCurrentAccountUin(), 4096, this.av);
  }
  
  public int ay()
  {
    AbsShareMsg localAbsShareMsg = this.am;
    if (localAbsShareMsg != null) {
      return localAbsShareMsg.mMsgServiceID;
    }
    return 0;
  }
  
  protected boolean az()
  {
    return true;
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    if (this.F) {
      ForwardStatisticsReporter.a(paramString, paramBoolean);
    }
  }
  
  public boolean e()
  {
    super.e();
    Object localObject2 = "";
    this.ai = "";
    this.af = "login".equals(this.r.getStringExtra("jfrom"));
    long l1 = this.t.getLong("req_share_id");
    if ((TextUtils.isEmpty(this.r.getStringExtra("pkg_name"))) && (!"1103584836".equals(String.valueOf(this.t.getLong("req_share_id")))) && (!"101735437".equals(String.valueOf(this.t.getLong("req_share_id"))))) {
      this.t.putLong("req_share_id", 65520L);
    }
    this.a = this.t.getLong("req_share_id");
    this.ad = this.r.getStringExtra("open_id");
    this.ae = this.r.getStringExtra("share_uin");
    this.ar = this.r.getIntExtra("req_type", 2147483647);
    String str3 = this.t.getString("detail_url");
    String str2 = this.t.getString("image_url");
    String str1 = this.t.getString("image_url_remote");
    long l2 = ForwardUtils.a(this.t.getString("chSrc"));
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "preloadData subType=", Integer.valueOf(this.ar), ",targetUrl=", str3, ",remoteImg=", str1, ",localImg=", str2 });
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
        this.t.putString("image_url_remote", str1);
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
    a(this.ar, this.F);
    if (!a(str2, (String)localObject1)) {
      return false;
    }
    if (o())
    {
      b("KEY_STAGE_1_TOTAL", true);
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "-->preloadData-- null != mAppInfo");
      return true;
    }
    if ((l1 > 0L) && (!"101735437".equals(String.valueOf(l1))))
    {
      this.an = System.currentTimeMillis();
      this.ao = true;
      l3 = System.currentTimeMillis() / 1000L;
      str1 = this.t.getString("pkg_name");
      if (TextUtils.isEmpty(str1))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = this.I;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append("");
        localObject1 = AuthorityUtil.a((Context)localObject1, str1, ((StringBuilder)localObject2).toString());
      }
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "-->sdk_share, getting appinfo in construct. sign: ", localObject1 });
      if (!(this instanceof ForwardSdkShareOption))
      {
        a(2131915900);
        this.aa.setCancelable(false);
      }
      l4 = ForwardShareByServerHelper.d();
      a("KEY_GET_APP_INFO");
      Share.a(this.q, this.I, this.q.getCurrentAccountUin(), l1, (String)localObject1, l2, l3, this.au, str1, l4, true);
      return true;
    }
    if ((this instanceof ForwardSdkShareOption)) {
      a("", false);
    }
    return true;
  }
  
  protected boolean o()
  {
    return ((ForwardSdkStatusManager)this.q.getManager(QQManagerFactory.SDK_SHARE)).a().a();
  }
  
  protected boolean p()
  {
    if (this.F)
    {
      if (this.aq == null) {
        return false;
      }
      Object localObject1 = this.t.getString("image_url");
      Object localObject2 = this.t.getString("image_url_remote");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = this.aq.f();
        this.t.putString("image_url_remote", (String)localObject1);
        localObject2 = this.am;
        if (localObject2 != null)
        {
          ((AbsShareMsg)localObject2).updateCover((String)localObject1);
          this.ax.sendEmptyMessage(2);
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
        localStringBuilder.append(this.G);
        ((ReportCenter)localObject1).a((Bundle)localObject2, localStringBuilder.toString(), this.q.getCurrentUin(), false, this.F);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption
 * JD-Core Version:    0.7.0.1
 */