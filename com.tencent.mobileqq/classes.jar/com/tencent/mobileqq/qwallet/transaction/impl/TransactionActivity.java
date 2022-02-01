package com.tencent.mobileqq.qwallet.transaction.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qwallet.temp.FriendListObserverTemp;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.IQwTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qqpay.ui.R.style;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.widget.impl.YellowTipsLayout;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="QQ钱包-转账界面", path="/qwallet/transaction")
public class TransactionActivity
  extends QBaseActivity
  implements View.OnClickListener
{
  public static final String PREF_NAME_TRANSFER = "transfer";
  public static final String PREF_NAME_TRANSFER_KEY = "is_need_dialog_";
  private static final String TAG = "TransactionActivity";
  private static final String TRANSFER_URL = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment";
  private String callbackSn;
  private ImageView del;
  FriendListObserverTemp fob = new TransactionActivity.11(this);
  private boolean isActivityPause = false;
  private EditText mAmoutTxt;
  private String mAppInfo;
  private boolean mAvoidInput = false;
  private TextView mBackBtn;
  private int mComeFrom;
  private Button mConfirmBtn;
  private Context mContext;
  private String mDesc;
  private boolean mFromJump;
  private String mGroupType;
  private String mGroupUin;
  private String mHistransSign;
  private View mInputScroll;
  private boolean mIsBackKeyPressed;
  private boolean mIsJumpToH5 = false;
  private boolean mIsStranger = false;
  private ImageView mLogo;
  private EditText mMemo;
  private int mMinTransferStrangerFee;
  private String mMinTransferStrangerMsg;
  private EditText mPayAmountEdit;
  private View mPayLayout;
  private TextView mPayMemoEdit;
  private String mPayeeNick;
  private String mPayeeUin;
  private long mReportSeq;
  private TextView mRightView;
  private View mRootScroll;
  private String mSource;
  private Intent mStartCalculatorIntent;
  private String mTag;
  protected TextWatcher mTextWatcher = new TransactionActivity.1(this);
  private String mTransFee;
  private int mTransMaxFee;
  private String mTransQuotaMsg;
  private View mTransferLayout;
  private TextView mTransferTips;
  private String mUin;
  private Button mUinBtn;
  protected TextWatcher mUinTextWatcher = new TransactionActivity.2(this);
  private EditText mUinTxt;
  private String mUserNick;
  private TextView mUserNickTxt;
  private int maxWidthNick = 140;
  private View middle_line;
  private long mlastInvalidatetime = 0L;
  private String na_from_h5_data;
  private LinearLayout root;
  private TextView titleTV;
  private ImageView transfer_unit;
  private TextView transfer_unit_text;
  
  private boolean checkWithdrawCount(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.indexOf('.') == 0) {
      return false;
    }
    if ((paramString.indexOf('.') > 0) && (paramString.indexOf('.') < paramString.length() - 3)) {
      return false;
    }
    try
    {
      double d = Double.valueOf(paramString).doubleValue();
      if (d <= 0.0D) {
        return false;
      }
      if (this.mIsStranger)
      {
        int i = this.mMinTransferStrangerFee;
        if (i > d * 100.0D) {
          return false;
        }
      }
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String div(String paramString1, String paramString2, int paramInt)
  {
    if (paramInt < 0) {
      return "0";
    }
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "0";
  }
  
  private BaseQQAppInterface getApp()
  {
    Object localObject = getAppRuntime();
    if ((localObject instanceof BaseQQAppInterface)) {
      localObject = (BaseQQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApp, ");
      localStringBuilder.append(localObject);
      QLog.i("TransactionActivity", 4, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private String getTransFeeUint(float paramFloat)
  {
    if ((paramFloat >= 1000.0F) && (paramFloat <= 9999.0F)) {
      return HardCodeUtil.a(R.string.db);
    }
    if ((paramFloat >= 10000.0F) && (paramFloat <= 99999.0F)) {
      return HardCodeUtil.a(R.string.df);
    }
    if ((paramFloat >= 100000.0F) && (paramFloat <= 999999.0F)) {
      return HardCodeUtil.a(R.string.de);
    }
    if ((paramFloat >= 1000000.0F) && (paramFloat <= 9999999.0F)) {
      return HardCodeUtil.a(R.string.dc);
    }
    if ((paramFloat >= 10000000.0F) && (paramFloat < 1.0E+008F)) {
      return HardCodeUtil.a(R.string.da);
    }
    return "";
  }
  
  private void initUI(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!ImmersiveUtils.setStatusTextColor(true, getWindow())) && (Build.VERSION.SDK_INT >= 21)) {
        getWindow().setStatusBarColor(637534208);
      }
      this.root.setBackgroundColor(Color.parseColor("#f8f8f8"));
      this.titleTV.setTextColor(-16777216);
      this.mRightView.setVisibility(0);
      this.mRootScroll.setVisibility(0);
      this.mInputScroll.setVisibility(8);
      this.mBackBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.f, 0, 0, 0);
      return;
    }
    if ((!ImmersiveUtils.setStatusTextColor(false, getWindow())) && (Build.VERSION.SDK_INT >= 21)) {
      getWindow().setStatusBarColor(0);
    }
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { getResources().getColor(R.color.e), getResources().getColor(R.color.d) });
    if (Build.VERSION.SDK_INT <= 15) {
      this.root.setBackgroundDrawable(localGradientDrawable);
    } else {
      this.root.setBackground(localGradientDrawable);
    }
    this.titleTV.setTextColor(-1);
    this.mRightView.setVisibility(8);
    this.mRootScroll.setVisibility(8);
    this.mInputScroll.setVisibility(0);
    this.mBackBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ao, 0, 0, 0);
  }
  
  private void initYellowTips()
  {
    JSONObject localJSONObject = YellowTipsLayout.a(getApplicationContext(), this.mUin);
    YellowTipsLayout localYellowTipsLayout = (YellowTipsLayout)findViewById(R.id.aS);
    if ((localYellowTipsLayout != null) && (localYellowTipsLayout.a(localJSONObject, "transfer_ad"))) {
      this.mRootScroll.setPadding(0, 0, 0, 0);
    }
  }
  
  private void preMConnect()
  {
    Bundle localBundle = new Bundle();
    Object localObject = (TicketManager)getApp().getManager(2);
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
  
  private void sendPush(String paramString)
  {
    if (!this.mFromJump) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("TargetUin", this.mPayeeUin);
      localJSONObject.put("PayeeNick", this.mUserNick);
      localJSONObject.put("pay_status", paramString);
      paramString = new JSONObject();
      paramString.put("userId", this.mUin);
      paramString.put("viewTag", "transferPush");
      paramString.put("comeForm", this.mComeFrom);
      paramString.put("appInfo", this.mAppInfo);
      paramString.put("extra_data", localJSONObject.toString());
      tenpay(this, paramString.toString(), 5, "0");
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
  
  private void tenpay(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if (paramActivity != null)
    {
      if (paramString1 == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("json", paramString1);
      localBundle.putString("callbackSn", paramString2);
      paramString1 = new Intent();
      paramString1.putExtras(localBundle);
      paramString1.putExtra("pay_requestcode", paramInt);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("tenpay startActivity and request=");
        paramString2.append(localBundle.toString());
        paramString2.append(",requestCode=");
        paramString2.append(paramInt);
        QLog.i("TransactionActivity", 2, paramString2.toString());
      }
      RouteUtils.a(paramActivity, paramString1, "/base/payBridge", paramInt);
    }
  }
  
  private void updateTransferTips()
  {
    if (this.mIsStranger)
    {
      String str;
      if (TextUtils.isEmpty(this.mMinTransferStrangerMsg)) {
        str = "向陌生人转账最低1.00元！";
      } else {
        str = this.mMinTransferStrangerMsg;
      }
      ThreadManager.getUIHandler().post(new TransactionActivity.4(this, str));
      return;
    }
    ThreadManager.getUIHandler().post(new TransactionActivity.5(this));
  }
  
  private String yuan2Fen(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new BigDecimal(paramString);
      BigDecimal localBigDecimal = new BigDecimal("100");
      paramString = new DecimalFormat("#").format(paramString.multiply(localBigDecimal).doubleValue());
      return paramString;
    }
    catch (Exception paramString)
    {
      label53:
      break label53;
    }
    return "";
  }
  
  public void addUploadData(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    paramString5 = new StringBuilder();
    paramString5.append("Tenpay_mqq");
    paramString5.append("|");
    paramString5.append(paramString1);
    paramString5.append("||");
    paramString5.append(paramInt1);
    paramString5.append("|");
    paramString5.append(paramString2);
    paramString5.append("|0|1|0|android.");
    try
    {
      paramString5.append(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
    paramString5.append("|");
    paramString5.append(CommonUtil.a());
    paramString5.append("|");
    if ((!TextUtils.isEmpty(paramString3)) || (!TextUtils.isEmpty(paramString4)))
    {
      paramString5.append(paramString3);
      paramString5.append(".");
      paramString5.append(paramString4);
    }
    paramString5.append("|");
    paramString5.append(this.mComeFrom);
    paramString5.append(".");
    if (!TextUtils.isEmpty(this.mAppInfo)) {
      paramString5.append(this.mAppInfo.replace("|", ","));
    }
    paramString5.append("|");
    long l = this.mReportSeq;
    paramString1 = new StringBuilder();
    paramString1.append("op_type=");
    paramString1.append(paramInt1);
    VACDReportUtil.a(l, null, paramString2, paramString1.toString(), 0, "");
    paramString1 = getApp();
    if (paramString1 != null) {
      StatisticCollector.getInstance(MobileQQ.context).reportToPCliOper(paramString1, paramString5.toString());
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onActivityResult doOnActivityResult: ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", resultCode: ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", intent: ");
      ((StringBuilder)localObject1).append(paramIntent);
      QLog.i("TransactionActivity", 2, ((StringBuilder)localObject1).toString());
    }
    this.isActivityPause = false;
    Object localObject2;
    int i;
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("result");
      localObject2 = null;
      if ((paramIntent != null) && (paramIntent.length() > 0)) {
        try
        {
          localObject1 = new JSONObject(paramIntent);
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
      } else {
        localObject1 = null;
      }
      paramIntent = (Intent)localObject2;
      i = paramInt2;
      if (localObject1 != null) {
        try
        {
          i = ((JSONObject)localObject1).optInt("resultCode", -1);
          paramInt2 = i;
          paramIntent = new JSONObject(((JSONObject)localObject1).optString("retmsg"));
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          i = paramInt2;
          paramIntent = (Intent)localObject2;
        }
      }
      if ((i == 0) && (paramIntent != null))
      {
        if (paramInt1 != 5) {
          return;
        }
        if (getApp() != null)
        {
          localObject1 = getSharedPreferences("transfer", 0).edit();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("is_need_dialog_");
          ((StringBuilder)localObject2).append(getApp().getCurrentAccountUin());
          ((StringBuilder)localObject2).append(this.mPayeeUin);
          ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), false).commit();
        }
        localObject1 = paramIntent.optString("callback_url");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject1 = new StringBuffer(Uri.decode((String)localObject1));
        localObject2 = paramIntent.optString("sp_data");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuffer)localObject1).append("&sp_data=");
          ((StringBuffer)localObject1).append((String)localObject2);
        }
        localObject2 = paramIntent.optString("transaction_id");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuffer)localObject1).append("&transaction_id=");
          ((StringBuffer)localObject1).append((String)localObject2);
        }
        localObject2 = paramIntent.optString("total_fee");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuffer)localObject1).append("&total_fee=");
          ((StringBuffer)localObject1).append((String)localObject2);
        }
        localObject2 = paramIntent.optString("pay_time");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuffer)localObject1).append("&pay_time=");
          ((StringBuffer)localObject1).append((String)localObject2);
        }
        localObject2 = new JSONObject();
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("callback_url", ((StringBuffer)localObject1).toString());
      localJSONObject.put("exec_code", paramIntent.optString("exec_code"));
      localJSONObject.put("uin", this.mPayeeUin);
      localJSONObject.put("url", ((StringBuffer)localObject1).toString());
      ((JSONObject)localObject2).put("resultCode", 0);
      ((JSONObject)localObject2).put("retmsg", "SUCCESS");
      if (this.mComeFrom == 5) {
        ((JSONObject)localObject2).put("retdata", localJSONObject);
      } else {
        ((JSONObject)localObject2).put("data", localJSONObject);
      }
    }
    catch (Exception paramIntent)
    {
      label586:
      break label586;
    }
    if (this.mIsJumpToH5) {
      QwUtils.a(this, ((StringBuffer)localObject1).toString());
    }
    paramIntent = new Intent();
    paramIntent.putExtra("callbackSn", this.callbackSn);
    paramIntent.putExtra("PayInvokerId", 5);
    paramIntent.putExtra("result", ((JSONObject)localObject2).toString());
    setResult(-1, paramIntent);
    finish();
    return;
    if (i > 0)
    {
      localObject1 = ((JSONObject)localObject1).optString("retmsg");
      paramIntent = (Intent)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramIntent = getString(R.string.O);
      }
      QQToast.a(this.mContext, paramIntent, 0).a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.mReportSeq = getIntent().getLongExtra("vacreport_key_seq", 0L);
    long l = this.mReportSeq;
    if (l == 0L) {
      this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "transfer", "transinvoke", null, 0, null);
    } else {
      VACDReportUtil.a(l, null, "transinvoke", null, 0, null);
    }
    this.mContext = this;
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QBaseActivity$addObserver(this, this.fob);
    try
    {
      paramBundle = getApp();
      if (paramBundle != null)
      {
        this.mUin = paramBundle.getCurrentAccountUin();
        this.mUserNick = paramBundle.getCurrentNickname();
      }
      this.mComeFrom = getIntent().getIntExtra("come_from", 1);
      this.mIsJumpToH5 = getIntent().getBooleanExtra("isJumpToH5", false);
      this.callbackSn = getIntent().getStringExtra("callbackSn");
      this.mAppInfo = getIntent().getStringExtra("app_info");
      this.mFromJump = getIntent().getBooleanExtra("fromJump", false);
      this.mTag = getIntent().getStringExtra("tag");
      this.mAvoidInput = getIntent().getBooleanExtra("avoidInput", false);
      paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
      this.mPayeeUin = paramBundle.optString("targetUin");
      this.mPayeeNick = paramBundle.optString("targetNickname");
      this.mTransFee = paramBundle.optString("trans_fee");
      this.mDesc = paramBundle.optString("desc");
      this.mHistransSign = paramBundle.optString("sign");
      this.mSource = paramBundle.optString("source");
      this.mGroupType = paramBundle.optString("group_type");
      this.mGroupUin = paramBundle.optString("group_uin");
      this.na_from_h5_data = paramBundle.optString("na_from_h5_data");
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    initView();
    sendPush("1");
    ThreadManager.getFileThreadHandler().post(new TransactionActivity.3(this));
    if (QWalletHelperImpl.isNeedPreConnect(this.mContext, this.mUin, "type_mqq_and_myun")) {
      preMConnect();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QBaseActivity$removeObserver(this, this.fob);
    super.doOnDestroy();
    long l = this.mReportSeq;
    if (l != 0L) {
      VACDReportUtil.endReport(l, "transfer.qqid.destroy", null, 0, null);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.isActivityPause = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    try
    {
      getWindow().setSoftInputMode(16);
      this.isActivityPause = false;
      if (this.mInputScroll.getVisibility() == 0)
      {
        addUploadData(this.mUin, 128, "transfer.qqid.show", "", "", this.mComeFrom, "");
        return;
      }
      addUploadData(this.mUin, 128, "transfer.amount.show", "", "", this.mComeFrom, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
  
  @TargetApi(14)
  protected void initView()
  {
    try
    {
      setContentView(R.layout.w);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
    this.root = ((LinearLayout)findViewById(R.id.bL));
    this.mPayLayout = findViewById(R.id.bj);
    this.mTransferLayout = findViewById(R.id.bo);
    this.mRootScroll = findViewById(R.id.bN);
    this.mInputScroll = findViewById(R.id.g);
    initYellowTips();
    this.mBackBtn = ((TextView)findViewById(R.id.at));
    this.mBackBtn.setVisibility(0);
    this.mBackBtn.setOnClickListener(this);
    this.titleTV = ((TextView)findViewById(R.id.aw));
    this.transfer_unit = ((ImageView)findViewById(R.id.ct));
    this.middle_line = findViewById(R.id.aR);
    this.transfer_unit_text = ((TextView)findViewById(R.id.cu));
    this.mAmoutTxt = ((EditText)findViewById(R.id.b));
    this.mPayAmountEdit = ((EditText)findViewById(R.id.aX));
    this.mUinTxt = ((EditText)findViewById(R.id.cg));
    this.mUinTxt.addTextChangedListener(this.mUinTextWatcher);
    this.mAmoutTxt.addTextChangedListener(this.mTextWatcher);
    Object localObject1 = this.mAmoutTxt;
    ((EditText)localObject1).addTextChangedListener(new MoneyWatcher((EditText)localObject1));
    this.mPayAmountEdit.addTextChangedListener(this.mTextWatcher);
    this.mMemo = ((EditText)findViewById(R.id.aP));
    this.mPayMemoEdit = ((TextView)findViewById(R.id.aY));
    this.mMemo.setOnEditorActionListener(new TransactionActivity.6(this));
    this.mConfirmBtn = ((Button)findViewById(R.id.cq));
    this.mConfirmBtn.setOnClickListener(this);
    this.mConfirmBtn.setEnabled(false);
    this.mUinBtn = ((Button)findViewById(R.id.cf));
    this.mUinBtn.setOnClickListener(this);
    this.mUinBtn.setEnabled(false);
    this.mUinBtn.setClickable(false);
    this.mLogo = ((ImageView)findViewById(R.id.ci));
    this.mUserNickTxt = ((TextView)findViewById(R.id.ch));
    localObject1 = this.mContext;
    localObject1 = QWalletTools.a((Context)localObject1, this.mPayeeNick, DisplayUtil.a((Context)localObject1, this.maxWidthNick), this.mUserNickTxt.getPaint());
    Object localObject2 = this.mUserNickTxt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("(");
    localStringBuilder.append(this.mPayeeUin);
    localStringBuilder.append(")");
    ((TextView)localObject2).setText(localStringBuilder.toString());
    this.del = ((ImageView)findViewById(R.id.cr));
    this.del.setOnClickListener(this);
    this.mRightView = ((TextView)findViewById(R.id.av));
    this.mRightView.setVisibility(0);
    this.mRightView.setText(HardCodeUtil.a(R.string.dd));
    this.mRightView.setOnClickListener(this);
    if ("transferInput".equals(this.mTag))
    {
      initUI(false);
      this.titleTV.setText(R.string.T);
      getWindow().setWindowAnimations(R.style.a);
      this.mUinTxt.requestFocus();
      if (!TextUtils.isEmpty(this.mPayeeUin))
      {
        this.mUinTxt.setText(this.mPayeeUin);
        this.mUinTxt.setSelection(this.mPayeeUin.length());
      }
      this.mSource = "3";
      this.mComeFrom = 2;
      if ((this.mAvoidInput) && (!TextUtils.isEmpty(this.mPayeeUin))) {
        this.mUinBtn.performClick();
      } else {
        new Handler().postDelayed(new TransactionActivity.7(this), 100L);
      }
    }
    else
    {
      initUI(true);
      localObject1 = (IFriendDataService)getApp().getRuntimeService(IFriendDataService.class, "");
      if ((((IFriendDataService)localObject1).getFriend(this.mPayeeUin, true, true) != null) && (((IFriendDataService)localObject1).isFriend(this.mPayeeUin)))
      {
        localObject1 = getString(R.string.W);
      }
      else
      {
        localObject1 = getString(R.string.Y);
        this.mIsStranger = true;
      }
      int i = this.mComeFrom;
      if (i == 2)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(getString(R.string.aa));
        localObject2 = ((StringBuilder)localObject2).toString();
        this.mConfirmBtn.setText(getString(R.string.ab));
      }
      else
      {
        localObject2 = localObject1;
        if (i == 5)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(getString(R.string.Z));
          localObject2 = ((StringBuilder)localObject2).toString();
          this.mConfirmBtn.setText(getString(R.string.ad));
        }
      }
      if (!TextUtils.isEmpty(this.mTransFee))
      {
        if (!TextUtils.isEmpty(this.mDesc)) {
          this.mPayMemoEdit.setText(this.mDesc);
        }
        if (!TextUtils.isEmpty(this.mTransFee))
        {
          this.mTransFee = div(this.mTransFee, "100", 2);
          this.mPayAmountEdit.setText(this.mTransFee);
        }
        this.root.setBackgroundColor(Color.parseColor("#ffffff"));
        this.mPayLayout.setVisibility(0);
        this.mTransferLayout.setVisibility(8);
        this.mConfirmBtn.setEnabled(true);
      }
      else
      {
        this.root.setBackgroundColor(Color.parseColor("#f8f8f8"));
        this.mAmoutTxt.requestFocus();
        this.mTransferLayout.setVisibility(0);
        this.mPayLayout.setVisibility(8);
        new Handler().postDelayed(new TransactionActivity.8(this), 100L);
      }
      this.titleTV.setText((CharSequence)localObject2);
      localObject1 = FaceDrawable.getFaceDrawable(getApp(), 1, this.mPayeeUin);
      this.mLogo.setImageDrawable((Drawable)localObject1);
    }
    this.mTransferTips = ((TextView)findViewById(R.id.cs));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.at)
    {
      if (("transferInput".equals(this.mTag)) && (this.mRootScroll.getVisibility() == 0) && (!this.mAvoidInput))
      {
        if (this.mIsBackKeyPressed) {
          addUploadData(this.mUin, 128, "transfer.qqid.keyback", "", "", this.mComeFrom, "");
        } else {
          addUploadData(this.mUin, 128, "transfer.qqid.back", "", "", this.mComeFrom, "");
        }
        this.mUinTxt.requestFocus();
        initUI(false);
        this.mPayeeNick = null;
        this.mLogo.setImageDrawable(null);
        this.mUserNickTxt.setText("");
        this.titleTV.setText(R.string.X);
        return;
      }
      if (this.mIsBackKeyPressed) {
        addUploadData(this.mUin, 128, "transfer.amout.keyback", "", "", this.mComeFrom, "");
      } else {
        addUploadData(this.mUin, 128, "transfer.amount.back", "", "", this.mComeFrom, "");
      }
      sendPush("2");
      sendCallback(-1, null);
      paramView = this.mContext;
      if (paramView != null) {
        ((InputMethodManager)paramView.getSystemService("input_method")).hideSoftInputFromWindow(this.mMemo.getWindowToken(), 0);
      }
      finish();
      return;
    }
    if (i == R.id.av)
    {
      i = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment".indexOf(':');
      if (i == -1) {
        return;
      }
      paramView = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment".substring(0, i);
      if (TextUtils.isEmpty(paramView)) {
        return;
      }
      paramView = paramView.toLowerCase();
      if ((paramView.compareTo("http") == 0) || (paramView.compareTo("https") == 0))
      {
        paramView = new Intent();
        paramView.putExtra("url", "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment");
        paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
        RouteUtils.a(this, paramView, "/base/browser", -1);
      }
    }
    else
    {
      Object localObject;
      if (i == R.id.cq)
      {
        long l = System.currentTimeMillis();
        if (this.mlastInvalidatetime + 1000L < l)
        {
          paramView = getSharedPreferences("transfer", 0);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("is_need_dialog_");
          ((StringBuilder)localObject).append(this.mUin);
          ((StringBuilder)localObject).append(this.mPayeeUin);
          if (paramView.getBoolean(((StringBuilder)localObject).toString(), true))
          {
            DialogUtil.a(this.mContext, 233, null, getString(R.string.ac), R.string.c, R.string.du, new TransactionActivity.9(this), new TransactionActivity.10(this)).show();
          }
          else
          {
            addUploadData(this.mUin, 128, "transfer.amount.go", "", "", this.mComeFrom, "");
            sendTransferRequest();
          }
          this.mlastInvalidatetime = l;
        }
      }
      else
      {
        if (i == R.id.cf)
        {
          BaseQQAppInterface localBaseQQAppInterface = getApp();
          this.mPayeeUin = this.mUinTxt.getText().toString();
          initUI(true);
          this.mAmoutTxt.requestFocus();
          this.mPayeeNick = ((IQwTemp)QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(localBaseQQAppInterface, this.mPayeeUin, true);
          paramView = this.mContext;
          paramView = QWalletTools.a(paramView, this.mPayeeNick, DisplayUtil.a(paramView, this.maxWidthNick), this.mUserNickTxt.getPaint());
          localObject = this.mUserNickTxt;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramView);
          localStringBuilder.append("(");
          localStringBuilder.append(this.mPayeeUin);
          localStringBuilder.append(")");
          ((TextView)localObject).setText(localStringBuilder.toString());
          paramView = FaceDrawable.getFaceDrawable(localBaseQQAppInterface, 1, this.mPayeeUin);
          this.mLogo.setImageDrawable(paramView);
          addUploadData(this.mUin, 128, "transfer.qqid.next", "", "", this.mComeFrom, "");
          paramView = new StringBuilder();
          paramView.append(getString(R.string.Y));
          paramView.append(getString(R.string.aa));
          localObject = paramView.toString();
          paramView = (View)localObject;
          if ("transferInput".equals(this.mTag))
          {
            paramView = (View)localObject;
            if (localBaseQQAppInterface != null)
            {
              paramView = (IFriendDataService)localBaseQQAppInterface.getRuntimeService(IFriendDataService.class, "");
              if ((paramView.getFriend(this.mPayeeUin, true, true) != null) && (paramView.isFriend(this.mPayeeUin)))
              {
                paramView = new StringBuilder();
                paramView.append(getString(R.string.W));
                paramView.append(getString(R.string.aa));
                paramView = paramView.toString();
                this.mIsStranger = false;
              }
              else
              {
                this.mIsStranger = true;
                paramView = (View)localObject;
              }
            }
          }
          this.titleTV.setText(paramView);
          updateTransferTips();
          this.mAmoutTxt.setText("");
          return;
        }
        if (i == R.id.cr)
        {
          this.mAmoutTxt.setText("");
          this.middle_line.setVisibility(0);
          this.transfer_unit.setVisibility(8);
          this.transfer_unit_text.setVisibility(8);
        }
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.mIsBackKeyPressed = true;
      this.mBackBtn.performClick();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void sendCallback(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      new Bundle();
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("resultCode", paramInt);
      label29:
      Intent localIntent = new Intent();
      localIntent.putExtra("callbackSn", this.callbackSn);
      localIntent.putExtra("PayInvokerId", 5);
      localIntent.putExtra("result", paramBundle.toString());
      setResult(-1, localIntent);
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  protected void sendTransferRequest()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("PayeeUin", this.mPayeeUin);
      localJSONObject1.put("PayeeNick", this.mPayeeNick);
      boolean bool = TextUtils.isEmpty(this.mTransFee);
      if (!bool)
      {
        localJSONObject1.put("Amout", yuan2Fen(this.mTransFee));
        localJSONObject1.put("Memo", this.mDesc);
      }
      else
      {
        localJSONObject1.put("Amout", yuan2Fen(this.mAmoutTxt.getText().toString()));
        localJSONObject1.put("Memo", this.mMemo.getText().toString());
      }
      localJSONObject1.put("ComeFrom", this.mComeFrom);
      localJSONObject1.put("HistransSign", this.mHistransSign);
      localJSONObject1.put("source", this.mSource);
      localJSONObject1.put("group_type", this.mGroupType);
      localJSONObject1.put("group_uin", this.mGroupUin);
      localJSONObject1.put("na_from_h5_data", this.na_from_h5_data);
      localJSONObject1.put("h5_success", true);
      JSONObject localJSONObject2 = new JSONObject();
      if ("transferInput".equals(this.mTag))
      {
        localJSONObject2.put("getpayee_type", 1);
        localJSONObject2.put("payee_uin", this.mPayeeUin);
        localJSONObject2.put("payee_nick", this.mPayeeNick);
      }
      localJSONObject2.put("fromPage", "AioTransfer");
      localJSONObject1.put("transPay_data", localJSONObject2.toString());
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("userId", this.mUin);
      localJSONObject2.put("viewTag", "transferInfor");
      localJSONObject2.put("comeForm", this.mComeFrom);
      localJSONObject2.put("appInfo", this.mAppInfo);
      localJSONObject2.put("extra_data", localJSONObject1.toString());
      tenpay(this, localJSONObject2.toString(), 5, "0");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void showToast(CharSequence paramCharSequence)
  {
    if ((!this.isActivityPause) && (!isFinishing())) {
      QQToast.a(this, paramCharSequence, 0).b(getTitleBarHeight(this.mContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity
 * JD-Core Version:    0.7.0.1
 */