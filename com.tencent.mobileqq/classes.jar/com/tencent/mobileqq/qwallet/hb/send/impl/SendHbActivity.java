package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.aio.impl.QWalletRedPkgUtils;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.ConfigLogic;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.SendHbLogic;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectMemberUtils;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="QQ钱包-发红包界面", path="/qwallet/redpacket/sendhb")
public class SendHbActivity
  extends QBaseActivity
  implements View.OnClickListener
{
  private static final int BROADCAST_VIDEO_TYPE = 999;
  private static final int ERR_IDIOM_RECOMMEND = 66249000;
  private static final int ERR_NOT_REGISTER = 66238025;
  private static final String RECEIVER_ACTION = "com.qwallet.report";
  private static final int REPORT_CODE_CANCEL = -1;
  private static final int REPORT_CODE_OK = 0;
  private static final String TAG = "SendHbActivity";
  private static final String TAG_Hb_CALLBACK = "sendHbCallback";
  private static final String TAG_QRCODE_Hb_CALLBACK = "qrcodeHbCallback";
  private static final int TYPE_LOGIC_FROM_AIO = 0;
  private static final int TYPE_LOGIC_FROM_SELECTOR = 1;
  private static final int TYPE_LOGIC_WRAP_AND_SHARE = 2;
  private String callbackSn;
  private QWalletPayProgressDialog dialog;
  private BaseHbFragment fragment = null;
  private HbSkinLogic hbSkinLogic;
  List<Integer> hb_callbacks = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(32768), Integer.valueOf(16384), Integer.valueOf(128), Integer.valueOf(256), Integer.valueOf(512), Integer.valueOf(2048) }));
  private String hb_from_type;
  Intent intent = new Intent();
  private boolean isActivityPause = false;
  private boolean isConfirm;
  private String mAppInfo;
  private int mComeFrom;
  private ConfigLogic mConfigLogic;
  private String mCount = "";
  public String mGroupCount;
  public String mGroupId;
  private BroadcastReceiver mHbReceiver = new SendHbActivity.1(this);
  private Intent mIntent;
  private boolean mIsBackKeyPressed = false;
  private boolean mIsTheme;
  private boolean mIs_H5;
  private String mListId;
  private int mLogicType = 0;
  private JSONObject mPaySuccessObj;
  private BroadcastReceiver mReceiver = new SendHbActivity.6(this);
  private String mRecvNick;
  private String mRecvType;
  private String mRecvTypeUpload;
  private String mRecvUin;
  public long mReportSeq;
  private View mSendLayout;
  public String mThemeType;
  private String mTotalAmount = "";
  private String mUin;
  private ImageView mViewShadow = null;
  private Map<String, String> mapParams;
  public int nChannel;
  private int nConfirm = -1;
  private int reportCode = 0;
  private View rootView;
  private ImageButton send_close;
  private View stateBar;
  
  private void addFragment()
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.fragment != null)
    {
      ((FrameLayout)findViewById(R.id.A)).setVisibility(0);
      localFragmentTransaction.add(R.id.A, this.fragment);
      localFragmentTransaction.commit();
    }
  }
  
  private Bundle buildParamsBundle()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.mapParams.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.mapParams.get(str));
    }
    localBundle.putString("channel", String.valueOf(this.nChannel));
    return localBundle;
  }
  
  private Map<String, String> conbineExtraParams(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("extra_data = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("SendHbActivity", 2, ((StringBuilder)localObject).toString());
    paramString = QWalletTools.h(paramString);
    localObject = (String)paramString.remove("extra_info");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString.putAll(QWalletTools.h((String)localObject));
    }
    paramString.put("send_name", this.mRecvNick);
    paramString.put("send_uin", this.mUin);
    return paramString;
  }
  
  public static ResultRecord constructAResultRecord(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    return localResultRecord;
  }
  
  private void finishIfHiddenMakeView()
  {
    if (QWalletTools.a(this.mapParams, "makeHb_type", "0").equals("1")) {
      finish();
    }
  }
  
  private void initCustomHb()
  {
    if ("1".equals(QWalletTools.a(this.mapParams, "makeHb_type", "0")))
    {
      this.rootView.setVisibility(8);
      this.mTotalAmount = ((String)this.mapParams.get("total_amount"));
      this.mCount = ((String)this.mapParams.get("total_num"));
      if (this.hb_from_type.equals("100"))
      {
        localObject = getMapPacketExtra();
        ((Map)localObject).put("type", "1");
        new SendHbLogic(this).a((Map)localObject);
        return;
      }
      new SendHbLogic(this).a();
      return;
    }
    if ((this.mIs_H5) && ("h5".equals(this.mapParams.get("invoke_from"))) && (this.nChannel == 2048))
    {
      new SendHbLogic(this).a("", this.mUin);
      finish();
      return;
    }
    if (!this.mIsTheme)
    {
      int j = this.nChannel;
      if (j != 64)
      {
        if ((j != 128) && (j != 256)) {
          if (j != 16384)
          {
            if (j != 32768)
            {
              if (j != 1000004)
              {
                int i = 3;
                if (j == 4096)
                {
                  if (("1".equals(this.mRecvType)) || ("7".equals(this.mRecvType)) || ("6".equals(this.mRecvType)))
                  {
                    i = 2;
                    break label346;
                  }
                }
                else {
                  if (!HbInfo.a.contains(this.mRecvType)) {
                    break label319;
                  }
                }
                i = 1;
                break label346;
                label319:
                j = this.nChannel;
                if ((j != 2048) && (j != 512)) {
                  i = 0;
                }
                label346:
                localObject = getString(R.string.F);
                if (this.nChannel == 512) {
                  localObject = getString(R.string.V);
                }
                boolean bool = getIntent().getBooleanExtra("isFromPanel", false);
                Bundle localBundle = buildParamsBundle();
                localBundle.putBoolean("isFromPanel", bool);
                localBundle.putInt("tabMask", i);
                localBundle.putString("hbTitle", (String)localObject);
                this.fragment = new SendHbMainFragment();
                this.fragment.setArguments(localBundle);
                break label486;
              }
              initBirthdayFragment();
              break label486;
            }
          }
          else
          {
            this.fragment = new ThemeHbFragment();
            this.fragment.setArguments(buildParamsBundle());
            break label486;
          }
        }
        initQzoneFragment();
        break label486;
      }
    }
    initThemeFragment();
    label486:
    Object localObject = this.fragment;
    if ((!(localObject instanceof SendHbMainFragment)) && (!(localObject instanceof BirthdayHbFragment))) {
      new ImmersionBar(this, -1308622848, this.stateBar);
    }
    addFragment();
  }
  
  private void initData()
  {
    this.mUin = getAppRuntime().getCurrentAccountUin();
    this.mRecvNick = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface().getCurrentNickname();
    this.mIsTheme = this.mIntent.getBooleanExtra("theme", false);
    this.hbSkinLogic = new HbSkinLogic(this);
    this.mConfigLogic = new ConfigLogic();
    this.mReportSeq = this.mIntent.getLongExtra("vacreport_key_seq", 0L);
    this.mIs_H5 = this.mIntent.getBooleanExtra("is_H5", false);
    this.mComeFrom = this.mIntent.getIntExtra("come_from", 1);
    this.callbackSn = this.mIntent.getStringExtra("callbackSn");
    this.mAppInfo = this.mIntent.getStringExtra("app_info");
    Object localObject = this.mIntent.getStringExtra("extra_data");
    this.mapParams = conbineExtraParams((String)localObject);
    initReportFromOncreate((String)localObject);
    initLogicType((String)localObject);
    this.hb_from_type = QWalletTools.a(this.mapParams, "hb_from_type", "0");
    this.mRecvUin = ((String)this.mapParams.get("recv_uin"));
    this.mRecvType = ((String)this.mapParams.get("recv_type"));
    this.mRecvTypeUpload = this.mRecvType;
    this.nChannel = QwUtils.a(this.mapParams.get("channel"), 1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mChannel = ");
    ((StringBuilder)localObject).append(this.nChannel);
    QLog.i("SendHbActivity", 2, ((StringBuilder)localObject).toString());
    if (!this.mIsTheme)
    {
      this.mThemeType = ((String)this.mapParams.get("theme_type"));
      try
      {
        if ((!TextUtils.isEmpty(this.mThemeType)) && (Integer.valueOf(this.mThemeType).intValue() > 1)) {
          this.mIsTheme = true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (TextUtils.isEmpty(this.mThemeType)) {
      this.mThemeType = this.mIntent.getStringExtra("theme_type");
    }
    if ((this.mapParams.containsKey("guild_id")) && (this.mapParams.containsKey("tinyid")))
    {
      if (QWalletRedPkgUtils.a(this.mRecvType)) {
        this.mRecvNick = QWalletRedPkgUtils.a(getAppRuntime(), (String)this.mapParams.get("guild_id"), (String)this.mapParams.get("tinyid"));
      }
    }
    else
    {
      if (5 == this.nChannel) {
        this.nChannel = 16;
      }
      if (6 == this.nChannel) {
        this.nChannel = 32;
      }
      int i = this.nChannel;
      if ((5 == i) || (16 == i) || (128 == i) || (256 == i))
      {
        this.mRecvNick = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getDateNickName(this.mUin);
        if (TextUtils.isEmpty(this.mRecvNick)) {
          this.mRecvNick = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface().getCurrentNickname();
        }
      }
    }
  }
  
  private void initLogicType(String paramString)
  {
    if (paramString.contains("recv_uin"))
    {
      if (paramString.contains("hb_from"))
      {
        this.mLogicType = 1;
        return;
      }
      this.mLogicType = 0;
      return;
    }
    this.mLogicType = 2;
  }
  
  private void initReportFromOncreate(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("isH5=");
    localStringBuilder.append(this.mIs_H5);
    localStringBuilder.append("&comeFrom=");
    localStringBuilder.append(this.mComeFrom);
    localStringBuilder.append("&callbackSn=");
    localStringBuilder.append(this.callbackSn);
    localStringBuilder.append("&appInfo=");
    localStringBuilder.append(this.mAppInfo);
    localStringBuilder.append("&extra=");
    localStringBuilder.append(paramString);
    long l = this.mReportSeq;
    if (l == 0L)
    {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "hbinvoke", localStringBuilder.toString(), 0, null);
      return;
    }
    VACDReportUtil.a(l, null, "hbinvoke", localStringBuilder.toString(), 0, null);
  }
  
  private void initThemeFragment()
  {
    boolean bool1 = TextUtils.isEmpty(this.mThemeType);
    boolean bool2 = true;
    Object localObject2;
    if (bool1)
    {
      localObject2 = this.mIntent.getStringExtra("theme_config");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    Object localObject1;
    for (String str = "hb_theme_";; localObject1 = "")
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (!((JSONObject)localObject2).has("hb_theme_id")) {
          continue;
        }
        this.mThemeType = ((JSONObject)localObject2).optString(String.format("%sid", new Object[] { str }));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (TextUtils.isEmpty(this.mThemeType))
      {
        QLog.i("SendHbActivity", 2, "params error, no theme id...");
        QQToast.makeText(this, "params error, no theme id...", 0).show();
        finish();
        return;
      }
      localObject1 = buildParamsBundle();
      ((Bundle)localObject1).putString("theme_type", this.mThemeType);
      if (64 == this.nChannel)
      {
        this.mIsTheme = true;
        this.mGroupId = this.mIntent.getStringExtra("group_id");
        this.mGroupCount = this.mIntent.getStringExtra("group_member_number");
      }
      this.fragment = new ThemeHbFragment();
      ((Bundle)localObject1).putString("group_count", this.mGroupCount);
      bool1 = bool2;
      if (!"2".equals(this.mRecvType)) {
        if ("3".equals(this.mRecvType)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      ((Bundle)localObject1).putBoolean("isGroupThemeHb", bool1);
      this.fragment.setArguments((Bundle)localObject1);
      return;
    }
  }
  
  private void initView()
  {
    this.stateBar = findViewById(R.id.ck);
    this.rootView = findViewById(R.id.bX);
    this.mSendLayout = findViewById(R.id.cf);
    this.send_close = ((ImageButton)findViewById(R.id.cc));
    this.send_close.setOnClickListener(this);
    ((Button)findViewById(R.id.cd)).setOnClickListener(this);
  }
  
  private String mul(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      label42:
      break label42;
    }
    return "0";
  }
  
  private void pay(String paramString)
  {
    Object localObject = this.fragment;
    if ((localObject != null) && ((localObject instanceof FragmentInterface))) {
      ((FragmentInterface)localObject).a();
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("tokenId", paramString);
      ((JSONObject)localObject).put("comeForm", this.mComeFrom);
      ((JSONObject)localObject).put("h5_success", true);
      ((JSONObject)localObject).put("appInfo", this.mAppInfo);
      paramString = new Bundle();
      paramString.putString("json", ((JSONObject)localObject).toString());
      paramString.putString("callbackSn", "0");
      paramString.putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 9, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void preMConnect()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (TicketManager)getAppRuntime().getManager(2);
    if (localObject != null) {
      localObject = ((TicketManager)localObject).getSkey(this.mUin);
    } else {
      localObject = "";
    }
    localBundle.putString("uin", this.mUin);
    localBundle.putString("skey", (String)localObject);
    localBundle.putString("skey_type", "2");
    localBundle.putInt("PayInvokerId", 21);
    QWalletPayBridge.launchBackground(MobileQQ.sMobileQQ, localBundle);
  }
  
  private void registBroadcast()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      getApplicationContext().registerReceiver(this.mReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void registerHbBroadCast()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qwallet.report");
    registerReceiver(this.mHbReceiver, localIntentFilter);
  }
  
  private void setNightMaskVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.mViewShadow;
    int i = 0;
    if (localImageView == null)
    {
      this.mViewShadow = new ImageView(this);
      this.mViewShadow.setImageDrawable(new ColorDrawable(Color.parseColor("#77000000")));
      this.mViewShadow.setPadding(0, 0, 0, 0);
      this.mViewShadow.setScaleType(ImageView.ScaleType.FIT_XY);
      ((FrameLayout)getWindow().getDecorView()).addView(this.mViewShadow, new ViewGroup.LayoutParams(-1, -1));
    }
    localImageView = this.mViewShadow;
    if (!paramBoolean) {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  private void showShareUI()
  {
    this.rootView.setVisibility(0);
    this.mSendLayout.setVisibility(0);
    View localView = this.stateBar;
    if (localView != null) {
      localView.setBackgroundColor(-1308622848);
    }
    addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.show", "", "");
  }
  
  private String yuan2Fen(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(mul(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public void addCommonHbUploadData(String paramString1, String paramString2, int paramInt)
  {
    addUploadData(this.mUin, getProcessType(), paramString1, paramString2, "");
  }
  
  public void addHbUploadData(String paramString)
  {
    addUploadData(this.mUin, getProcessType(), paramString, "", "");
  }
  
  public void addQZoneHbUploadData(int paramInt1, String paramString, int paramInt2)
  {
    addUploadData(this.mUin, paramInt1, paramString, "", "");
  }
  
  public void addUploadData(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    QWalletTools.a(getAppRuntime(), paramString1, this.mComeFrom, this.mAppInfo, this.mReportSeq, paramInt, paramString2, paramString3, paramString4);
  }
  
  public void callForwardPage(String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    if ("2".equals(paramString)) {
      localIntent.putExtra("param_only_discussion_member", true);
    } else if ("3".equals(paramString)) {
      localIntent.putExtra("param_only_troop_member", true);
    }
    localIntent.putExtra("param_title", getString(R.string.y));
    localIntent.putExtra("param_min", 0);
    localIntent.putExtra("param_done_button_wording", getString(R.string.dv));
    localIntent.putExtra("param_done_button_highlight_wording", getString(R.string.dw));
    localIntent.putExtra("param_max", 5);
    localIntent.putExtra("param_entrance", 25);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        new ResultRecord().uin = str;
        paramString.add(SelectMemberUtils.a(str, "", 0, this.mUin));
      }
      localIntent.putExtra("param_selected_records_for_create_discussion", paramString);
    }
    localIntent.putExtra("group_uin", this.mRecvUin);
    paramString = getAppRuntime().getCurrentAccountUin();
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new ArrayList();
      paramArrayList.add(paramString);
      localIntent.putExtra("param_uins_hide", paramArrayList);
    }
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, localIntent, 1024);
  }
  
  public void cancelCallBack()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", -1);
      label17:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.callbackSn);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", localJSONObject.toString());
      setResult(0, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public void doOnBackPressed()
  {
    QLog.i("SendHbActivity", 2, "SendHbActivity doOnBackPressed...");
    setResult(0, new Intent());
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.mIntent = localIntent;
    localIntent.putExtra("fling_action_key", 0);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    try
    {
      registerHbBroadCast();
      setProgressBarIndeterminateVisibility(false);
      setRequestedOrientation(1);
      setContentView(R.layout.g);
      initData();
      initView();
      initCustomHb();
      registBroadcast();
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).preloadQWallet(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface());
      if (QWalletHelperImpl.isNeedPreConnect(this, this.mUin, "type_mqq_and_myun")) {
        preMConnect();
      }
      return true;
    }
    catch (OutOfMemoryError paramBundle) {}
    return false;
  }
  
  protected void doOnDestroy()
  {
    this.hbSkinLogic.a();
    try
    {
      if (this.mReceiver != null) {
        unregisterReceiver(this.mReceiver);
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      unregisterReceiver(this.mHbReceiver);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    long l = this.mReportSeq;
    if (l != 0L) {
      VACDReportUtil.endReport(l, "hongbao.wrap.destroy", null, this.reportCode, null);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.isActivityPause = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.isActivityPause = false;
    addUploadData(this.mUin, getProcessType(), "hongbao.wrap.show", "", "");
    setNightMaskVisible("1103".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.hbSkinLogic.b();
  }
  
  public ConfigLogic getConfigLogic()
  {
    return this.mConfigLogic;
  }
  
  public int getForwardItem()
  {
    String str = QWalletTools.a(QWalletTools.h((String)this.mapParams.get("selector")), "friend_type", "1");
    if (str.equals("1")) {
      return 1;
    }
    if (str.equals("2")) {
      return 16;
    }
    if (str.equals("3")) {
      return 256;
    }
    if (str.equals("1|2")) {
      return 17;
    }
    if (str.equals("1|3")) {
      return 257;
    }
    if (str.equals("2|3")) {
      return 272;
    }
    if (str.equals("1|2|3")) {
      return 273;
    }
    return 0;
  }
  
  public HbSkinLogic getHbSkinLogic()
  {
    return this.hbSkinLogic;
  }
  
  public Map<String, String> getMapPacketExtra()
  {
    HashMap localHashMap = new HashMap(this.mapParams);
    localHashMap.put("name", this.mRecvNick);
    if (2048 != this.nChannel) {
      localHashMap.put("recv_type", this.mRecvTypeUpload);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.hb_from_type);
    localStringBuilder.append("");
    localHashMap.put("hb_from_type", localStringBuilder.toString());
    return localHashMap;
  }
  
  public Map<String, String> getMapPacketJson()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("userId", this.mUin);
    localHashMap.put("viewTag", "sendHb");
    localHashMap.put("comeForm", "2");
    localHashMap.put("appInfo", this.mAppInfo);
    return localHashMap;
  }
  
  protected int getProcessType()
  {
    int i;
    if (this.mIs_H5) {
      i = 131;
    } else if (TextUtils.isEmpty(this.mRecvType))
    {
      if (HbInfo.b.contains(this.mRecvType)) {
        i = 133;
      } else {
        i = 132;
      }
    }
    else {
      i = 499;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getProcessType: processFlag:");
      localStringBuilder.append(i);
      QLog.i("SendHbActivity", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public int getTitleBarHeight(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getDimensionPixelSize(R.dimen.b);
      float f = paramContext.getResources().getDisplayMetrics().density;
      return i - (int)(f * 5.0F);
    }
    catch (Exception paramContext)
    {
      label31:
      break label31;
    }
    return 0;
  }
  
  public void initBirthdayFragment()
  {
    this.fragment = new BirthdayHbFragment();
    Bundle localBundle = buildParamsBundle();
    this.fragment.setArguments(localBundle);
  }
  
  public void initQzoneFragment()
  {
    this.fragment = new QzoneHbFragment();
    Bundle localBundle = buildParamsBundle();
    this.fragment.setArguments(localBundle);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = paramInt2;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onActivityResult requestCode = ");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" resultCode = ");
    ((StringBuilder)localObject1).append(i);
    QLog.i("SendHbActivity", 2, ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("data = ");
    ((StringBuilder)localObject1).append(paramIntent);
    QLog.i("SendHbActivity", 2, ((StringBuilder)localObject1).toString());
    localObject1 = this.fragment;
    if (localObject1 != null) {
      ((BaseHbFragment)localObject1).onActivityResult(paramInt1, i, paramIntent);
    }
    this.isActivityPause = false;
    String str1;
    Object localObject2;
    if ((paramIntent != null) && (i == -1))
    {
      str1 = paramIntent.getStringExtra("result");
      if ((str1 != null) && (str1.length() > 0)) {
        try
        {
          localObject1 = new JSONObject(str1);
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      } else {
        localObject1 = null;
      }
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult resultData = ");
      paramIntent.append(localObject1);
      QLog.i("SendHbActivity", 2, paramIntent.toString());
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optString("retmsg");
        paramInt2 = ((JSONObject)localObject1).optInt("resultCode", -1);
        this.reportCode = paramInt2;
        paramIntent = ((JSONObject)localObject1).optString("data");
        if ((paramIntent != null) && (paramIntent.length() > 0)) {
          try
          {
            paramIntent = new JSONObject(paramIntent);
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
          }
        } else {
          paramIntent = null;
        }
        if (this.reportCode != 0)
        {
          String str2 = this.mUin;
          i = getProcessType();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(";");
          localStringBuilder.append(paramInt2);
          addUploadData(str2, i, localStringBuilder.toString(), "", "");
        }
      }
      else
      {
        paramIntent = null;
        localObject2 = paramIntent;
        paramInt2 = i;
      }
    }
    try
    {
      this.dialog.dismiss();
      label370:
      if ((paramInt2 == 0) && (paramIntent != null))
      {
        if (paramInt1 != 5)
        {
          if (paramInt1 != 9) {
            return;
          }
          if (paramIntent.optInt("wx_pay_success", -1) == 0)
          {
            if (this.mLogicType != 2)
            {
              finish();
              return;
            }
            this.mListId = paramIntent.optString("send_listid");
            showShareUI();
            return;
          }
          localObject1 = paramIntent.optString("callback_url");
          localObject2 = new StringBuffer();
          ((StringBuffer)localObject2).append("number#");
          ((StringBuffer)localObject2).append(this.mCount);
          ((StringBuffer)localObject2).append(",type#");
          if ((!"1".equals(this.mRecvType)) && (!"7".equals(this.mRecvType)) && (!"4".equals(this.mRecvType)) && (!"5".equals(this.mRecvType)))
          {
            if ("2".equals(this.mRecvType)) {
              ((StringBuffer)localObject2).append("crowd");
            } else {
              ((StringBuffer)localObject2).append("group");
            }
          }
          else {
            ((StringBuffer)localObject2).append("person");
          }
          ((StringBuffer)localObject2).append(",channel#");
          ((StringBuffer)localObject2).append(this.nChannel);
          ((StringBuffer)localObject2).append(",money#");
          ((StringBuffer)localObject2).append(this.mTotalAmount);
          addUploadData(this.mUin, getProcessType(), "hongbao.wrap.success", ((StringBuffer)localObject2).toString(), null);
          if (localObject1 == null) {
            return;
          }
          if ((!TextUtils.isEmpty(this.mRecvUin)) && (this.nConfirm != 1) && (!this.hb_callbacks.contains(Integer.valueOf(this.nChannel))))
          {
            if (this.nChannel == 16384)
            {
              onFaceHbResult(paramIntent);
              return;
            }
            onCommonHbResult(paramIntent);
            return;
          }
          localObject1 = paramIntent.optString("sp_data");
          if (2048 == this.nChannel) {
            sendConfirmRequest("qrcodeHbCallback", (String)localObject1);
          } else {
            sendConfirmRequest("sendHbCallback", (String)localObject1);
          }
          this.mPaySuccessObj = paramIntent;
          return;
        }
        if (this.isConfirm)
        {
          this.isConfirm = false;
          this.nConfirm = -1;
          paramInt1 = paramIntent.optInt("state");
          if ((1 != paramInt1) && (2 != paramInt1))
          {
            paramInt1 = this.nChannel;
            if ((256 != paramInt1) && (128 != paramInt1) && (paramInt1 != 32768))
            {
              if (512 == paramInt1)
              {
                onVisitHbResult(paramIntent);
                return;
              }
              showToast(getString(R.string.K));
              return;
            }
            onRewardHbResult(paramIntent);
            return;
          }
          if (TextUtils.isEmpty(this.mRecvUin))
          {
            showShareUI();
            this.mListId = paramIntent.optString("send_listid");
            return;
          }
          paramInt1 = this.nChannel;
          if ((256 != paramInt1) && (128 != paramInt1) && (512 != paramInt1) && (2048 != paramInt1))
          {
            localObject2 = this.mPaySuccessObj;
            if (localObject2 != null) {
              paramIntent = (Intent)localObject2;
            }
            if (this.nChannel == 16384)
            {
              onFaceHbResult((JSONObject)localObject1);
              return;
            }
            onCommonHbResult(paramIntent);
            return;
          }
          if (2048 == this.nChannel) {
            onQrcodeHbResult(paramIntent);
          }
        }
        else
        {
          paramInt1 = this.nChannel;
          if ((64 != paramInt1) && (paramInt1 != 64))
          {
            this.nConfirm = paramIntent.optInt("is_confirm");
            pay(paramIntent.optString("token_id"));
            return;
          }
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).putOpt("token_id", paramIntent.optString("token_id"));
            ((JSONObject)localObject1).putOpt("total_amount", this.mTotalAmount);
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
          }
          setResult(-1, onGroupHbBack(paramInt2, "", ((JSONObject)localObject1).toString()));
          finish();
        }
      }
      else
      {
        if (paramInt2 > 0)
        {
          if (this.isConfirm)
          {
            paramInt1 = this.nChannel;
            if ((256 != paramInt1) && (128 != paramInt1))
            {
              if (!TextUtils.isEmpty(this.mRecvUin))
              {
                paramIntent = this.mPaySuccessObj;
                if (paramIntent != null) {
                  onCommonHbResult(paramIntent);
                }
              }
            }
            else
            {
              paramIntent = new Intent();
              paramIntent.putExtra("retmsg", str1);
              setResult(-1, paramIntent);
              finish();
            }
          }
          paramIntent = getString(R.string.O);
          if (paramInt2 == 66238025) {
            DialogUtil.a(this, 230, null, (CharSequence)localObject2, null, getString(R.string.S), new SendHbActivity.2(this), null).show();
          } else if ((paramInt2 == 66249000) && (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            if (!isFinishing()) {
              DialogUtil.a(this, 230, null, (CharSequence)localObject2, null, getString(R.string.B), new SendHbActivity.3(this), null).show();
            }
          }
          else if (localObject2 != null) {
            showToast((CharSequence)localObject2);
          } else {
            showToast(paramIntent);
          }
          finishIfHiddenMakeView();
          return;
        }
        if (paramInt2 < -10)
        {
          paramIntent = new StringBuilder();
          paramIntent.append(HardCodeUtil.a(R.string.cH));
          paramIntent.append(paramInt2);
          showToast(paramIntent.toString());
          finishIfHiddenMakeView();
          return;
        }
        paramIntent = new Intent();
        paramIntent.putExtra("PayInvokerId", 5);
        paramIntent.putExtra("result", str1);
        setResult(-1, paramIntent);
        finishIfHiddenMakeView();
        return;
        finishIfHiddenMakeView();
      }
      return;
    }
    catch (Exception localException)
    {
      break label370;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.cd)
    {
      addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.send", "", "");
      sendPackedHb();
      return;
    }
    if (i == R.id.cc)
    {
      paramView = new StringBuilder();
      paramView.append(getString(R.string.Q));
      paramView.append(getString(R.string.x));
      String str = paramView.toString();
      paramView = getString(R.string.N);
      if (this.mIsTheme)
      {
        str = getString(R.string.Q);
        paramView = getString(R.string.A);
      }
      showDialog(str, paramView, getString(R.string.R));
      if (this.mIsBackKeyPressed)
      {
        addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.keyback", "", "");
        return;
      }
      addUploadData(this.mUin, getProcessType(), "hongbao.wrapped.close", "", "");
    }
  }
  
  /* Error */
  protected void onCommonHbResult(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 260	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 1334
    //   12: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 1158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: ldc 29
    //   24: iconst_2
    //   25: aload_2
    //   26: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_1
    //   33: ifnonnull +4 -> 37
    //   36: return
    //   37: new 1190	java/lang/StringBuffer
    //   40: dup
    //   41: aload_1
    //   42: ldc_w 1188
    //   45: invokevirtual 654	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 1339	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokespecial 1340	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_1
    //   56: ldc_w 1227
    //   59: invokevirtual 654	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_3
    //   64: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +17 -> 84
    //   70: aload_2
    //   71: ldc_w 1342
    //   74: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload_2
    //   79: aload_3
    //   80: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   83: pop
    //   84: aload_1
    //   85: ldc_w 1344
    //   88: invokevirtual 654	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_3
    //   92: aload_3
    //   93: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifne +17 -> 113
    //   99: aload_2
    //   100: ldc_w 1346
    //   103: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: pop
    //   107: aload_2
    //   108: aload_3
    //   109: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   112: pop
    //   113: aload_1
    //   114: ldc_w 1348
    //   117: invokevirtual 654	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore_3
    //   121: aload_3
    //   122: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifne +17 -> 142
    //   128: aload_2
    //   129: ldc_w 1350
    //   132: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   135: pop
    //   136: aload_2
    //   137: aload_3
    //   138: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   141: pop
    //   142: aload_1
    //   143: ldc_w 1352
    //   146: invokevirtual 654	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore_1
    //   150: aload_1
    //   151: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +17 -> 171
    //   157: aload_2
    //   158: ldc_w 1354
    //   161: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   164: pop
    //   165: aload_2
    //   166: aload_1
    //   167: invokevirtual 1196	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   170: pop
    //   171: new 636	org/json/JSONObject
    //   174: dup
    //   175: invokespecial 739	org/json/JSONObject:<init>	()V
    //   178: astore_1
    //   179: new 636	org/json/JSONObject
    //   182: dup
    //   183: invokespecial 739	org/json/JSONObject:<init>	()V
    //   186: astore_3
    //   187: aload_3
    //   188: ldc_w 1188
    //   191: aload_2
    //   192: invokevirtual 1218	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   195: invokevirtual 744	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload_1
    //   200: ldc_w 980
    //   203: iconst_0
    //   204: invokevirtual 749	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_1
    //   209: ldc_w 1166
    //   212: ldc_w 1356
    //   215: invokevirtual 744	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   218: pop
    //   219: aload_1
    //   220: ldc_w 1171
    //   223: aload_3
    //   224: invokevirtual 744	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   227: pop
    //   228: new 260	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   235: astore_2
    //   236: aload_2
    //   237: ldc_w 1358
    //   240: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_2
    //   245: aload_1
    //   246: invokevirtual 1158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 29
    //   252: iconst_2
    //   253: aload_2
    //   254: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 277	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: new 155	android/content/Intent
    //   263: dup
    //   264: invokespecial 156	android/content/Intent:<init>	()V
    //   267: astore_2
    //   268: aload_2
    //   269: ldc_w 524
    //   272: aload_0
    //   273: getfield 530	com/tencent/mobileqq/qwallet/hb/send/impl/SendHbActivity:callbackSn	Ljava/lang/String;
    //   276: invokevirtual 931	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   279: pop
    //   280: aload_2
    //   281: ldc_w 787
    //   284: iconst_5
    //   285: invokevirtual 936	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   288: pop
    //   289: aload_2
    //   290: ldc_w 982
    //   293: aload_1
    //   294: invokevirtual 759	org/json/JSONObject:toString	()Ljava/lang/String;
    //   297: invokevirtual 931	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   300: pop
    //   301: aload_0
    //   302: iconst_m1
    //   303: aload_2
    //   304: invokevirtual 986	com/tencent/mobileqq/qwallet/hb/send/impl/SendHbActivity:setResult	(ILandroid/content/Intent;)V
    //   307: aload_0
    //   308: invokevirtual 344	com/tencent/mobileqq/qwallet/hb/send/impl/SendHbActivity:finish	()V
    //   311: return
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   317: return
    //   318: astore_2
    //   319: goto -91 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	SendHbActivity
    //   0	322	1	paramJSONObject	JSONObject
    //   7	297	2	localObject1	Object
    //   318	1	2	localException	Exception
    //   62	162	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   37	84	312	java/lang/Exception
    //   84	113	312	java/lang/Exception
    //   113	142	312	java/lang/Exception
    //   142	171	312	java/lang/Exception
    //   171	179	312	java/lang/Exception
    //   228	311	312	java/lang/Exception
    //   179	228	318	java/lang/Exception
  }
  
  public void onFaceHbPacket(String paramString)
  {
    this.mTotalAmount = paramString;
    try
    {
      Object localObject = getMapPacketExtra();
      ((Map)localObject).put("total_num", QWalletTools.a(this.mapParams, "total_num", "1"));
      ((Map)localObject).put("total_amount", yuan2Fen(paramString));
      ((Map)localObject).put("channel", String.valueOf(this.nChannel));
      ((Map)localObject).put("recv_uin", this.mRecvUin);
      ((Map)localObject).put("bus_type", this.mapParams.get("bus_type"));
      ((Map)localObject).put("recv_type", "1");
      ((Map)localObject).put("type", "1");
      paramString = getMapPacketJson();
      paramString.put("extra_data", new JSONObject((Map)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", new JSONObject(paramString).toString());
      ((Bundle)localObject).putString("callbackSn", "0");
      ((Bundle)localObject).putLong("vacreport_key_seq", this.mReportSeq);
      PayBridgeActivity.tenpay(this, 5, (Bundle)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void onFaceHbResult(JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFaceHbResult bundle_data = ");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.i("SendHbActivity", 2, ((StringBuilder)localObject).toString());
    localObject = paramJSONObject.optJSONObject("data");
    if (localObject != null) {
      paramJSONObject = (JSONObject)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFaceHbResult final data = ");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.i("SendHbActivity", 2, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).putExtra("callbackSn", this.callbackSn);
    ((Intent)localObject).putExtra("PayInvokerId", 5);
    JSONObject localJSONObject = new JSONObject();
    int i;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      i = paramJSONObject.optInt("retcode", -1);
      try
      {
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ((Intent)localObject).putExtra("result", localStringBuilder.toString());
        ((Intent)localObject).putExtra("retmsg", paramJSONObject.optString("retmsg"));
        localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
      }
      catch (Exception paramJSONObject) {}
      paramJSONObject.printStackTrace();
    }
    catch (Exception paramJSONObject)
    {
      i = -1;
    }
    if (i == 0) {
      addUploadData(this.mUin, getProcessType(), "bqredpacket.pay.expose", "", "");
    }
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("onFaceHbResult back jdata = ");
    paramJSONObject.append(localJSONObject);
    QLog.i("SendHbActivity", 2, paramJSONObject.toString());
    ((Intent)localObject).putExtra("data", localJSONObject.toString());
    setResult(-1, (Intent)localObject);
    finish();
  }
  
  public Intent onGroupHbBack(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramInt == 0) {
      localIntent.putExtra("data", paramString2);
    } else {
      localIntent.putExtra("retmsg", paramString1);
    }
    localIntent.putExtra("result", paramInt);
    return localIntent;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendHbActivity onKeyDown keyCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" event = ");
    localStringBuilder.append(paramKeyEvent);
    QLog.i("SendHbActivity", 2, localStringBuilder.toString());
    if (paramInt == 4)
    {
      this.mIsBackKeyPressed = true;
      paramKeyEvent = this.fragment;
      if (paramKeyEvent != null)
      {
        if ((paramKeyEvent instanceof SendHbMainFragment)) {
          ((SendHbMainFragment)paramKeyEvent).c();
        }
        addHbUploadData("theme.pack.keyback");
        cancelCallBack();
        this.reportCode = -1;
        finish();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onQrcodeHbResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("userId", this.mUin);
      ((JSONObject)localObject).put("viewTag", "qrcodeHb");
      ((JSONObject)localObject).put("comeForm", 2);
      JSONObject localJSONObject = new JSONObject();
      String str = parseQrcodeHb(paramJSONObject);
      boolean bool = TextUtils.isEmpty(str);
      if (!bool) {
        localJSONObject.putOpt("qrData", str);
      }
      localJSONObject.putOpt("comeFrom", Integer.valueOf(this.mComeFrom));
      saveQrToken(paramJSONObject.optString("qr_token"));
      ((JSONObject)localObject).put("extra_data", localJSONObject.toString());
      paramJSONObject = new Bundle();
      paramJSONObject.putString("json", ((JSONObject)localObject).toString());
      paramJSONObject.putString("callbackSn", "0");
      paramJSONObject.putLong("vacreport_key_seq", this.mReportSeq);
      localObject = QWalletTools.a(this.mapParams, "from_plugin", "");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        PayBridgeActivity.tenpay(this, 5, paramJSONObject);
      }
      else if ("1".equals(localObject))
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtra("qrData", str);
        setResult(-1, paramJSONObject);
      }
      finish();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void onRewardHbResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("retmsg", paramJSONObject.toString());
    setResult(-1, localIntent);
    finish();
  }
  
  protected void onVisitHbResult(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("send_name", this.mRecvNick);
      localJSONObject.putOpt("send_uin", this.mUin);
      localJSONObject.putOpt("send_listid", paramJSONObject.optString("send_listid"));
      localJSONObject.putOpt("amount", paramJSONObject.optString("amount"));
      localJSONObject.putOpt("feedsid", this.mapParams.get("feedsid"));
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(this.nChannel);
      paramJSONObject.append("");
      localJSONObject.putOpt("channel", paramJSONObject.toString());
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.putOpt("resultCode", Integer.valueOf(0));
      paramJSONObject.putOpt("retmsg", "");
      paramJSONObject.putOpt("data", localJSONObject.toString());
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localIntent.putExtra("result", paramJSONObject.toString());
    localIntent.putExtra("callbackSn", this.callbackSn);
    localIntent.putExtra("PayInvokerId", 5);
    setResult(-1, localIntent);
    finish();
  }
  
  public String parseQrcodeHb(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wishing", paramJSONObject.optString("wishing"));
      localJSONObject.put("total_num", paramJSONObject.optString("total_num"));
      localJSONObject.put("recv_num", paramJSONObject.optString("recv_num"));
      localJSONObject.put("qr_data", paramJSONObject.optString("qr_data"));
      localJSONObject.put("send_listid", paramJSONObject.optString("send_listid"));
      paramJSONObject = new JSONArray();
      paramJSONObject.put(localJSONObject);
      paramJSONObject = paramJSONObject.toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void saveQrToken(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QWalletHelperImpl.saveQRTokenConfig(this, paramString, this.mUin);
  }
  
  protected void sendConfirmRequest(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendConfirmRequest viewtag = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" sp_data = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("SendHbActivity", 2, ((StringBuilder)localObject).toString());
    int i = 1;
    this.isConfirm = true;
    this.dialog = new QWalletPayProgressDialog(this);
    this.dialog.show();
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("sp_data", paramString2);
        int j = this.nChannel;
        if (32768 == j)
        {
          if (!this.mRecvType.equals("1")) {
            break label242;
          }
          ((JSONObject)localObject).put("channel", i);
        }
        else
        {
          ((JSONObject)localObject).put("channel", String.valueOf(this.nChannel));
        }
        paramString2 = new JSONObject();
        paramString2.put("userId", this.mUin);
        paramString2.put("viewTag", paramString1);
        paramString2.put("comeForm", 2);
        paramString2.put("appInfo", this.mAppInfo);
        paramString2.put("extra_data", ((JSONObject)localObject).toString());
        PayBridgeActivity.tenpay(this, paramString2.toString(), 5, "0");
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      label242:
      i = 1024;
    }
  }
  
  public void sendPackedHb()
  {
    this.intent.putExtra("hb_id", this.mListId);
    this.intent.putExtra("send_uin", this.mUin);
    this.intent.putExtra("hb_type", "1");
    this.intent.putExtra("forward_text", getString(R.string.U));
    HashMap localHashMap = QWalletTools.h((String)this.mapParams.get("selector"));
    int i = QWalletTools.a(localHashMap, "type", 0);
    if (this.mIsTheme)
    {
      this.intent.putExtra("item", 1);
    }
    else if ((this.hb_from_type.equals("100")) && (i == 1))
    {
      this.intent.putExtra("item", getForwardItem());
      this.intent.putExtra("title", QWalletTools.a(localHashMap, "title", HardCodeUtil.a(R.string.cI)));
    }
    this.intent.putExtra("forward_type", 17);
    this.intent.putExtra("invoke_from", "qwallet");
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).SendHbActivity$startForwardActivity(this, this.intent);
  }
  
  public void showCommonHbToast(CharSequence paramCharSequence)
  {
    showToast(paramCharSequence);
  }
  
  public void showDialog(String paramString1, String paramString2, String paramString3)
  {
    DialogUtil.a(this, 230, null, paramString1, paramString2, paramString3, new SendHbActivity.4(this), new SendHbActivity.5(this)).show();
  }
  
  public void showQzoneHbToast(CharSequence paramCharSequence)
  {
    showToast(paramCharSequence);
  }
  
  public void showThemeHbToast(CharSequence paramCharSequence)
  {
    showToast(paramCharSequence);
  }
  
  public void showToast(CharSequence paramCharSequence)
  {
    if ((!this.isActivityPause) && (!isFinishing())) {
      QQToast.makeText(this, paramCharSequence, 0).show(getTitleBarHeight(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity
 * JD-Core Version:    0.7.0.1
 */