package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="QQ钱包-面对面红包引导界面", path="/qwallet/redpacket/QrcodeHbGuider")
public class QrcodeHbGuiderActivity
  extends QBaseActivity
  implements View.OnClickListener
{
  private String mAppInfo;
  private TextView mBackView;
  private int mComeFrom = 2;
  private TextView mConfirmView;
  public boolean mIsEndReport = true;
  private String mOptType;
  private long mReportSeq = 0L;
  private Button mSendBtn;
  private TextView mTitleText;
  private String mUin;
  
  private void init()
  {
    new ImmersionBar(this, -468046, findViewById(R.id.ck));
    initView();
    initParams();
    initListener();
  }
  
  private void initListener()
  {
    this.mSendBtn.setOnClickListener(this);
    this.mBackView.setOnClickListener(this);
    this.mConfirmView.setOnClickListener(this);
  }
  
  private void initParams()
  {
    this.mUin = getAppRuntime().getCurrentUin();
    this.mAppInfo = getIntent().getStringExtra("app_info");
    this.mReportSeq = getIntent().getLongExtra("vacreport_key_seq", 0L);
    long l = this.mReportSeq;
    if (l == 0L) {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "GuiderAct.create", "", 0, null);
    } else {
      VACDReportUtil.a(l, null, "GuiderAct.create", null, 0, null);
    }
    String str = getIntent().getStringExtra("from_plugin");
    this.mOptType = str;
    if ((!TextUtils.isEmpty(str)) && ("131".equals(str))) {
      this.mComeFrom = 1;
    }
    if (TextUtils.isEmpty(str))
    {
      go2QrcodeHbPage(QWalletHelperImpl.readQRTokenConfig(this, this.mUin), "");
      this.mIsEndReport = false;
      finish();
    }
  }
  
  private void initView()
  {
    this.mSendBtn = ((Button)findViewById(R.id.bu));
    this.mTitleText = ((TextView)findViewById(R.id.aE));
    this.mTitleText.setText(HardCodeUtil.a(R.string.bU));
    this.mBackView = ((TextView)findViewById(R.id.aB));
    this.mConfirmView = ((TextView)findViewById(R.id.aD));
    this.mConfirmView.setText(HardCodeUtil.a(R.string.bT));
  }
  
  public void addUploadData(String paramString)
  {
    String str = this.mUin;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Tenpay_mqq");
    localStringBuilder1.append("|");
    localStringBuilder1.append(str);
    localStringBuilder1.append("||");
    localStringBuilder1.append(this.mOptType);
    localStringBuilder1.append("|");
    localStringBuilder1.append(paramString);
    localStringBuilder1.append("|0|1|0|android.");
    try
    {
      localStringBuilder1.append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    localStringBuilder1.append("|");
    localStringBuilder1.append(CommonUtil.b());
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.mComeFrom);
    localStringBuilder1.append(".");
    if (!TextUtils.isEmpty(this.mAppInfo)) {
      localStringBuilder1.append(this.mAppInfo.replace("|", ","));
    }
    localStringBuilder1.append("|");
    long l = this.mReportSeq;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("op_type=");
    localStringBuilder2.append(this.mOptType);
    VACDReportUtil.a(l, null, paramString, localStringBuilder2.toString(), 0, "");
    StatisticCollector.getInstance(MobileQQ.getContext()).reportToPCliOper(getAppRuntime(), localStringBuilder1.toString());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(R.layout.f);
    init();
    addUploadData("face2face.index.show");
    return true;
  }
  
  public void finish()
  {
    if (this.mIsEndReport)
    {
      long l = this.mReportSeq;
      if (l != 0L) {
        VACDReportUtil.endReport(l, "GuiderAct.finish", null, 0, null);
      }
    }
    super.finish();
  }
  
  public void go2HbList()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.mUin);
      localJSONObject.put("viewTag", "redgiftRecord");
      localJSONObject.put("comeForm", 2);
      localJSONObject.put("extra_data", new JSONObject().toString());
      Bundle localBundle = new Bundle();
      localBundle.putString("json", localJSONObject.toString());
      localBundle.putString("callbackSn", "0");
      localBundle.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 5, localBundle);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void go2QrcodeHbPage(String paramString1, String paramString2)
  {
    paramString2 = new JSONObject();
    if (TextUtils.isEmpty(this.mUin)) {
      return;
    }
    try
    {
      paramString2.put("userId", this.mUin);
      paramString2.put("viewTag", "qrcodeHb");
      paramString2.put("comeForm", 2);
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.putOpt("qrToken", paramString1);
      }
      paramString2.put("extra_data", localJSONObject.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", paramString2.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void go2SendHb()
  {
    long l = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", null, 0, null);
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", "2048");
      localJSONObject.put("recv_uin", this.mUin);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localIntent.putExtra("extra_data", localJSONObject.toString());
    localIntent.putExtra("come_from", 2);
    localIntent.putExtra("app_info", this.mAppInfo);
    localIntent.addFlags(536870912);
    localIntent.putExtra("vacreport_key_seq", l);
    RouteUtils.a(this, localIntent, "/qwallet/redpacket/sendhb");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.bu)
    {
      go2SendHb();
      addUploadData("face2face.index.go");
      finish();
      return;
    }
    if (i == R.id.aB)
    {
      addUploadData("face2face.index.back");
      finish();
      return;
    }
    if (i == R.id.aD) {
      go2HbList();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      addUploadData("face2face.index.keyback");
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.QrcodeHbGuiderActivity
 * JD-Core Version:    0.7.0.1
 */