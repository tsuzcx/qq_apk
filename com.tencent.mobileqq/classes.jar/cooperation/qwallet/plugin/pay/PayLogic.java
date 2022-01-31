package cooperation.qwallet.plugin.pay;

import actn;
import agxa;
import agxb;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import anqq;
import anqr;
import bbcv;
import bbgg;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TenpayJumpActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

public class PayLogic
{
  private static final String RECEIVER_COM_KEY = "_qwallet_payresult_receiver";
  public static final String RECEIVER_LOGIC_LAYER_KEY = "receiver";
  public static final String TAG = "Q.qwallet.pay.PayLogic";
  static HashSet<String> allowView = new HashSet();
  private static boolean isPaying;
  private static SparseArray<PayLogic> sPayLogics = new SparseArray();
  private QQAppInterface app;
  private Intent intent;
  private Bundle intentData;
  private boolean isFromPCPush;
  protected boolean isLockWithdraw;
  protected boolean isPCPushDesc;
  private BaseActivity mActivity;
  private anqq mEmojiPayReqData;
  public boolean mIsStartReport;
  private String mMidasAid;
  private String mMidasOfferid;
  private String mMidasOrderId;
  PayLogic.OnActivityResult mOnActivityResult = null;
  private String mOpenViewTag;
  private String mPayAppId;
  private String mPayBargainorId;
  private String mPayChannel;
  protected long mPayH5StartTime;
  private String mPayTokenId;
  protected int mPayType = -1;
  public long mReportSeq;
  private int mRequestCode = -1;
  protected ResultReceiver mResultReceiver;
  private int saveResultCode = -1;
  private Intent saveResultData;
  
  static
  {
    allowView.add("resetPsw");
    allowView.add("bindNewCard");
    allowView.add("balance");
    allowView.add("pswManage");
    allowView.add("modifyPsw");
    allowView.add("checkPsw");
    allowView.add("withdraw");
    allowView.add("transferInfor");
    allowView.add("transfer");
    allowView.add("graphb");
    allowView.add("qpay_hb_share");
    allowView.add("sendHb");
    allowView.add("sendHbCallback");
    allowView.add("makeHongbao");
    allowView.add("parseqrcode");
    allowView.add("verifyqrcode");
    allowView.add("findPsw");
    allowView.add("pushMsg");
    allowView.add("transferPush");
    allowView.add("transferqrcode");
    allowView.add("transferInput");
    allowView.add("redgiftDetail");
    allowView.add("redgiftRecord");
    allowView.add("idCardVerify");
    allowView.add("payCode");
    allowView.add("showWearPayAuthor");
    allowView.add("rewardTransferInput");
    allowView.add("hbPackConfirm");
    allowView.add("qpayCert");
    allowView.add("qrcodeHb");
    allowView.add("qrcodeHbCallback");
    allowView.add("payByFriendConfirm");
    allowView.add("goldmsg_open");
    allowView.add("goldmsg_close");
    allowView.add("openEmbelUrl");
  }
  
  public PayLogic(Intent paramIntent, QQAppInterface paramQQAppInterface, PayBridgeActivity paramPayBridgeActivity)
  {
    this.intent = paramIntent;
    this.app = paramQQAppInterface;
    this.mActivity = paramPayBridgeActivity;
    add(this);
  }
  
  private void OnEmojimallPayResult(anqq paramanqq, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    if (paramanqq == null)
    {
      end();
      return;
    }
    Intent localIntent = new Intent();
    paramString = new anqr(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString);
    localIntent.putExtras(paramanqq.a());
    localIntent.putExtras(paramString.a());
    this.mActivity.setResult(-1, localIntent);
    saveNonePCPayResultData(-1, localIntent);
    end();
  }
  
  private static void add(PayLogic paramPayLogic)
  {
    if (paramPayLogic != null) {
      sPayLogics.append(paramPayLogic.getTag(), paramPayLogic);
    }
  }
  
  protected static Bundle buyGoods(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str8 = ((JSONObject)localObject).getString("offerId");
        String str9 = ((JSONObject)localObject).getString("userId");
        String str10 = ((JSONObject)localObject).getString("tokenUrl");
        if (((JSONObject)localObject).has("zoneId"))
        {
          str1 = ((JSONObject)localObject).getString("zoneId");
          if (!((JSONObject)localObject).has("numberVisible")) {
            break label818;
          }
          bool = ((JSONObject)localObject).getBoolean("numberVisible");
          if (!((JSONObject)localObject).has("unit")) {
            break label824;
          }
          str2 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("aid")) {
            break label830;
          }
          str3 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("discountId")) {
            break label838;
          }
          str4 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label846;
          }
          str5 = ((JSONObject)localObject).getString("other");
          if (!((JSONObject)localObject).has("payload")) {
            break label854;
          }
          str6 = ((JSONObject)localObject).getString("payload");
          String str7;
          if (((JSONObject)localObject).has("drmInfo"))
          {
            str7 = ((JSONObject)localObject).getString("drmInfo");
            if (((JSONObject)localObject).has("comeForm"))
            {
              i = ((JSONObject)localObject).getInt("comeForm");
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("json=").append(paramString2);
              if (!TextUtils.isEmpty(paramString3)) {
                ((StringBuilder)localObject).append("&url=").append(paramString3);
              }
              VACDReportUtil.a(paramLong2, null, "parseurl", ((StringBuilder)localObject).toString(), 0, null);
              paramString2 = new Bundle();
              paramString2.putString("offerId", str8);
              paramString2.putString("setEnv", "release");
              paramString2.putBoolean("setLogEnable", false);
              paramString2.putBoolean("isShowNum", Boolean.valueOf(bool).booleanValue());
              if ((str2 != null) && (str2.length() > 0)) {
                paramString2.putString("unit", str2);
              }
              paramString2.putString("callbackSn", paramString1);
              paramString1 = "qq_m_qq-2013-android-" + AppSetting.a() + "-" + str3;
              paramString2.putString("userId", str9);
              paramString2.putString("sessionId", "uin");
              paramString2.putString("zoneId", str1);
              paramString2.putString("pf", paramString1);
              paramString2.putString("pfKey", "pfKey");
              paramString2.putString("tokenUrl", str10);
              paramString2.putInt("resId", 0);
              paramString2.putString("discountId", str4);
              paramString2.putString("other", str5);
              paramString2.putString("payload", str6);
              paramString2.putString("drmInfo", str7);
              paramString2.putInt("comeForm", i);
              paramString2.putInt("PayInvokerId", 7);
              paramString2.putInt("payparmas_paytype", paramInt);
              paramString2.putLong("payparmas_h5_start", paramLong1);
              paramString2.putLong("vacreport_key_seq", paramLong2);
              setIPCReceiver(paramResultReceiver, paramString2);
              VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
              if (QLog.isDevelopLevel()) {
                QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
              }
              QWalletPayBridge.launchForeground(paramActivity, paramAppInterface, paramString2);
              localBundle.putInt("retCode", 0);
              localBundle.putString("offerId", str8);
              localBundle.putString("aid", str3);
              localBundle.putString("orderId", str10);
              return localBundle;
            }
          }
          else
          {
            str7 = "";
            continue;
          }
          int i = 1;
          continue;
        }
        String str1 = "1";
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "buyGoods JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'retmsg':'buyGoods JSONException'}");
        paramAppInterface.printStackTrace();
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "buyGoods Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'retmsg':'buyGoods Exception'}");
        return localBundle;
      }
      continue;
      label818:
      boolean bool = true;
      continue;
      label824:
      String str2 = null;
      continue;
      label830:
      String str3 = "";
      continue;
      label838:
      String str4 = "";
      continue;
      label846:
      String str5 = "";
      continue;
      label854:
      String str6 = "";
    }
  }
  
  private boolean checkEmojiPayParam(anqq paramanqq)
  {
    return (paramanqq != null) && (!TextUtils.isEmpty(paramanqq.b)) && (!TextUtils.isEmpty(paramanqq.a)) && (!TextUtils.isEmpty(paramanqq.c)) && (!TextUtils.isEmpty(paramanqq.d)) && (!TextUtils.isEmpty(paramanqq.j));
  }
  
  public static void clearCache()
  {
    if (sPayLogics != null) {
      sPayLogics.clear();
    }
  }
  
  private Dialog createCustomDialog(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(this.mActivity, 2131755791);
    localDialog.setContentView(2131558883);
    TextView localTextView = (TextView)localDialog.findViewById(2131365151);
    if (localTextView != null) {
      localTextView.setText(paramString1);
    }
    paramString1 = (TextView)localDialog.findViewById(2131365147);
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    paramString1 = (TextView)localDialog.findViewById(2131365136);
    if (paramString1 != null) {
      paramString1.setText(17039360);
    }
    paramString1 = (TextView)localDialog.findViewById(2131365142);
    if (paramString1 != null) {
      paramString1.setText(2131717387);
    }
    localDialog.setOnDismissListener(paramOnDismissListener);
    return localDialog;
  }
  
  private void doEmojimallPay(anqq paramanqq)
  {
    this.mEmojiPayReqData = paramanqq;
    this.mMidasOfferid = paramanqq.b;
    this.mMidasAid = getAidFromPf(paramanqq.h);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", paramanqq.b);
    localBundle.putBoolean("isShowNum", false);
    localBundle.putString("userId", paramanqq.c);
    localBundle.putString("userKey", paramanqq.d);
    localBundle.putString("sessionId", paramanqq.e);
    localBundle.putString("sessionType", paramanqq.f);
    localBundle.putString("zoneId", paramanqq.g);
    localBundle.putString("pf", paramanqq.h);
    localBundle.putString("pfKey", paramanqq.i);
    localBundle.putString("tokenUrl", paramanqq.j);
    localBundle.putInt("resId", 2130839382);
    localBundle.putString("discountId", paramanqq.k);
    localBundle.putString("other", paramanqq.l);
    localBundle.putString("payload", paramanqq.m);
    localBundle.putString("drmInfo", paramanqq.n);
    localBundle.putInt("PayInvokerId", 1);
    localBundle.putInt("payparmas_paytype", this.mPayType);
    QWalletPayBridge.launchForeground(this.mActivity, this.app, localBundle);
    putProxyReceiverToBundle(localBundle);
  }
  
  private void doGoldCharge(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("discountId");
    String str5 = paramBundle.getString("other");
    String str6 = paramBundle.getString("payload");
    String str7 = paramBundle.getString("drmInfo");
    String str8 = paramBundle.getString("saveValue");
    boolean bool = paramBundle.getBoolean("isCanChange", true);
    this.mMidasOfferid = str1;
    this.mMidasAid = getAidFromPf(str3);
    paramBundle = new Bundle();
    paramBundle.putString("setEnv", "release");
    paramBundle.putBoolean("setLogEnable", false);
    paramBundle.putString("offerId", str1);
    paramBundle.putString("userId", str2);
    paramBundle.putString("sessionId", "uin");
    paramBundle.putString("zoneId", "1");
    paramBundle.putString("pf", str3);
    paramBundle.putString("pfKey", "pfKey");
    paramBundle.putString("acctType", "common");
    paramBundle.putInt("resId", 2130846046);
    paramBundle.putString("discountId", str4);
    paramBundle.putString("other", str5);
    paramBundle.putString("payload", str6);
    paramBundle.putString("drmInfo", str7);
    paramBundle.putInt("PayInvokerId", 2);
    paramBundle.putInt("payparmas_paytype", this.mPayType);
    if ((str8 != null) && (str8.trim().length() > 0))
    {
      paramBundle.putString("saveValue", str8);
      paramBundle.putBoolean("isCanChange", bool);
    }
    putProxyReceiverToBundle(paramBundle);
    QWalletPayBridge.launchForeground(this.mActivity, this.app, paramBundle);
  }
  
  private void doOpenQQReaderVip(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("offerid");
    String str2 = paramBundle.getString("uin");
    String str3 = paramBundle.getString("pf");
    String str4 = paramBundle.getString("provideUin");
    String str5 = paramBundle.getString("provideType");
    String str6 = paramBundle.getString("discountId");
    String str7 = paramBundle.getString("other");
    String str8 = paramBundle.getString("payload");
    paramBundle = paramBundle.getString("drmInfo");
    this.mMidasOfferid = str1;
    this.mMidasAid = getAidFromPf(str3);
    Bundle localBundle = new Bundle();
    localBundle.putString("setEnv", "release");
    localBundle.putBoolean("setLogEnable", false);
    localBundle.putString("offerId", str1);
    localBundle.putString("userId", str2);
    localBundle.putString("sessionId", "uin");
    localBundle.putString("pf", str3);
    localBundle.putString("pfKey", "pfKey");
    localBundle.putString("serviceCode", "QQYFSC");
    localBundle.putString("serviceName", "腾讯文学包月VIP");
    localBundle.putInt("resId", 2130846046);
    localBundle.putString("saveValue", "3");
    localBundle.putBoolean("isCanChange", true);
    localBundle.putString("remark", "");
    localBundle.putString("provideUin", str4);
    localBundle.putString("provideType", str5);
    localBundle.putString("discountId", str6);
    localBundle.putString("other", str7);
    localBundle.putString("payload", str8);
    localBundle.putString("drmInfo", paramBundle);
    localBundle.putInt("PayInvokerId", 3);
    localBundle.putInt("payparmas_paytype", this.mPayType);
    putProxyReceiverToBundle(localBundle);
    QWalletPayBridge.launchForeground(this.mActivity, this.app, localBundle);
  }
  
  private String generateMidasErrorResult()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("payState", -1);
      ((JSONObject)localObject).put("provideState", -1);
      ((JSONObject)localObject).put("resultMsg", "");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private String generateTenPayErrorResult()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("resultCode", -1);
      ((JSONObject)localObject).put("retmsg", "error");
      ((JSONObject)localObject).put("data", new JSONObject());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String getAidFromPf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('-');
    if (i != -1) {
      return paramString.substring(i + 1);
    }
    return "";
  }
  
  public static PayLogic getLogic(int paramInt)
  {
    return (PayLogic)sPayLogics.get(paramInt);
  }
  
  private static String invokerIdToAction(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    default: 
      return null;
    case 6: 
      return "rechargeGameCurrency";
    case 7: 
      return "buyGoods";
    case 8: 
      return "rechargeQb";
    case 4: 
      return "openService";
    case 9: 
      return "pay-h5";
    case 14: 
      return "monthCardPay";
    }
    return "wechatPaySign";
  }
  
  private static boolean isEnterMidasTestEnv(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.optInt("setMidasEnv", 0) == 1) && (MiniAppUtils.isDebugMiniApp(paramJSONObject.optString("miniAppVertypeStr")));
  }
  
  public static boolean isLockWithdraw(int paramInt, Bundle paramBundle)
  {
    if (1 == paramInt) {
      try
      {
        boolean bool = isLockWithdraw(paramInt, new JSONObject(paramBundle.getString("json")).optJSONObject("extra_data"));
        return bool;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean isLockWithdraw(int paramInt, JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    if (1 == paramInt) {}
    try
    {
      if ((paramJSONObject.has("pskey")) || (paramJSONObject.has("p_skey_forbid")))
      {
        boolean bool2 = paramJSONObject.has("banned_user_buff");
        if (!bool2) {}
      }
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private boolean isLoginParamsValid()
  {
    if ((!this.isLockWithdraw) && (this.intentData.getBoolean("payparmas_from_is_login_state", true))) {}
    for (int i = 1; (i != 0) && ((this.app == null) || (this.app.getCurrentAccountUin() == null)); i = 0) {
      return false;
    }
    return true;
  }
  
  public static boolean isPaying()
  {
    return isPaying;
  }
  
  protected static Bundle launchWeChat(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    localBundle = new Bundle();
    try
    {
      Object localObject = new JSONObject(paramString2);
      String str7 = ((JSONObject)localObject).getString("payType");
      String str8 = ((JSONObject)localObject).getString("appId");
      String str9 = ((JSONObject)localObject).getString("autoJump");
      String str1;
      label92:
      String str2;
      label113:
      String str3;
      label134:
      String str4;
      label155:
      String str5;
      label176:
      String str6;
      if (((JSONObject)localObject).has("wxSignUrl"))
      {
        paramString2 = ((JSONObject)localObject).getString("wxSignUrl");
        if (!((JSONObject)localObject).has("extend")) {
          break label666;
        }
        str1 = ((JSONObject)localObject).getString("extend");
        if (!((JSONObject)localObject).has("bargainorId")) {
          break label672;
        }
        str2 = ((JSONObject)localObject).getString("bargainorId");
        if (!((JSONObject)localObject).has("tokenId")) {
          break label678;
        }
        str3 = ((JSONObject)localObject).getString("tokenId");
        if (!((JSONObject)localObject).has("nonceStr")) {
          break label684;
        }
        str4 = ((JSONObject)localObject).getString("nonceStr");
        if (!((JSONObject)localObject).has("timeStamp")) {
          break label690;
        }
        str5 = ((JSONObject)localObject).getString("timeStamp");
        if (!((JSONObject)localObject).has("packageValue")) {
          break label696;
        }
        str6 = ((JSONObject)localObject).getString("packageValue");
        label197:
        if (!((JSONObject)localObject).has("sign")) {
          break label702;
        }
      }
      label666:
      label672:
      label678:
      label684:
      label690:
      label696:
      label702:
      for (localObject = ((JSONObject)localObject).getString("sign");; localObject = null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("&pt=").append(str7);
        localStringBuilder.append("&ai=").append(str8);
        localStringBuilder.append("&aj=").append(str9);
        localStringBuilder.append("&wsu=").append(paramString2);
        localStringBuilder.append("&ex=").append(str1);
        localStringBuilder.append("&bi=").append(str2);
        localStringBuilder.append("&ti=").append(str3);
        localStringBuilder.append("&ns=").append(str4);
        localStringBuilder.append("&ts=").append(str5);
        localStringBuilder.append("&pv=").append(str6);
        localStringBuilder.append("&sign=").append((String)localObject);
        if (!TextUtils.isEmpty(paramString3)) {
          localStringBuilder.append("&url=").append(paramString3);
        }
        VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
        paramString3 = new Bundle();
        paramString3.putString("payType", str7);
        paramString3.putString("appId", str8);
        paramString3.putString("autoJump", str9);
        paramString3.putString("wxSignUrl", paramString2);
        paramString3.putString("extend", str1);
        paramString3.putString("bargainorId", str2);
        paramString3.putString("tokenId", str3);
        paramString3.putString("nonceStr", str4);
        paramString3.putString("timeStamp", str5);
        paramString3.putString("packageValue", str6);
        paramString3.putString("sign", (String)localObject);
        paramString3.putString("callbackSn", paramString1);
        paramString3.putInt("PayInvokerId", 17);
        paramString3.putInt("payparmas_paytype", paramInt);
        paramString3.putLong("payparmas_h5_start", paramLong1);
        paramString3.putLong("vacreport_key_seq", paramLong2);
        setIPCReceiver(paramResultReceiver, paramString3);
        VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
        if (QLog.isDevelopLevel()) {
          QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
        }
        QWalletPayBridge.launchForeground(paramActivity, paramAppInterface, paramString3);
        localBundle.putInt("retCode", 0);
        return localBundle;
        paramString2 = null;
        break;
        str1 = null;
        break label92;
        str2 = null;
        break label113;
        str3 = null;
        break label134;
        str4 = null;
        break label155;
        str5 = null;
        break label176;
        str6 = null;
        break label197;
      }
      return localBundle;
    }
    catch (JSONException paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay.PayLogic", 2, "launchWeChat JSONException:" + paramAppInterface.getMessage());
      }
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
      localBundle.putInt("retCode", -1);
      localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'launchWeChat JSONException'}");
      return localBundle;
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay.PayLogic", 2, "launchWeChat Exception:" + paramAppInterface.getMessage());
      }
      if (QLog.isDevelopLevel()) {
        paramAppInterface.printStackTrace();
      }
      localBundle.putInt("retCode", -1);
      localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'launchWeChat Exception'}");
    }
  }
  
  public static Bundle newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    Object localObject2 = "";
    Object localObject3 = null;
    int k = -1;
    long l2 = 0L;
    Object localObject4 = "";
    long l1 = 0L;
    Object localObject1 = null;
    if ((paramActivity instanceof BasePluginActivity))
    {
      paramActivity = ((BasePluginActivity)paramActivity).getOutActivity();
      if ((paramActivity instanceof BasePluginActivity)) {
        paramActivity = ((BasePluginActivity)paramActivity).getOutActivity();
      }
    }
    for (;;)
    {
      int j = 1;
      if ((paramAppInterface == null) || (paramActivity == null)) {
        j = 0;
      }
      int i;
      if (paramBundle != null)
      {
        String str1 = paramBundle.getString("payparmas_callback_sn");
        String str2 = paramBundle.getString("payparmas_json");
        int m = paramBundle.getInt("payparmas_paytype", -1);
        long l3 = paramBundle.getLong("payparmas_h5_start", 0L);
        String str3 = paramBundle.getString("payparmas_url_appinfo");
        long l4 = paramBundle.getLong("vacreport_key_seq", 0L);
        String str4 = paramBundle.getString("payparmas_h5_url");
        if ((m == -1) || (TextUtils.isEmpty(str2))) {
          j = 0;
        }
        i = j;
        l1 = l4;
        localObject1 = str4;
        localObject2 = str1;
        localObject3 = str2;
        localObject4 = str3;
        k = m;
        l2 = l3;
        if (paramInt != 6)
        {
          i = j;
          l1 = l4;
          localObject1 = str4;
          localObject2 = str1;
          localObject3 = str2;
          localObject4 = str3;
          k = m;
          l2 = l3;
          if (paramInt != 7)
          {
            i = j;
            l1 = l4;
            localObject1 = str4;
            localObject2 = str1;
            localObject3 = str2;
            localObject4 = str3;
            k = m;
            l2 = l3;
            if (paramInt != 8)
            {
              i = j;
              l1 = l4;
              localObject1 = str4;
              localObject2 = str1;
              localObject3 = str2;
              localObject4 = str3;
              k = m;
              l2 = l3;
              if (paramInt != 4)
              {
                i = j;
                l1 = l4;
                localObject1 = str4;
                localObject2 = str1;
                localObject3 = str2;
                localObject4 = str3;
                k = m;
                l2 = l3;
                if (paramInt != 9)
                {
                  i = j;
                  l1 = l4;
                  localObject1 = str4;
                  localObject2 = str1;
                  localObject3 = str2;
                  localObject4 = str3;
                  k = m;
                  l2 = l3;
                  if (paramInt != 14)
                  {
                    i = j;
                    l1 = l4;
                    localObject1 = str4;
                    localObject2 = str1;
                    localObject3 = str2;
                    localObject4 = str3;
                    k = m;
                    l2 = l3;
                    if (paramInt != 17)
                    {
                      i = 0;
                      l2 = l3;
                      k = m;
                      localObject4 = str3;
                      localObject3 = str2;
                      localObject2 = str1;
                      localObject1 = str4;
                      l1 = l4;
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.pay.PayLogic", 2, "from static method invokerId:" + paramInt + " request=" + localObject3 + ",callbackSn=" + (String)localObject2);
        }
        if (i != 0) {
          break;
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'System error.'}");
        return localBundle;
        i = 0;
      }
      if (l1 == 0L)
      {
        l1 = VACDReportUtil.a(null, "qqwallet", invokerIdToAction(paramInt), "payinvoke", null, 0, null);
        paramBundle.putLong("vacreport_key_seq", l1);
      }
      for (;;)
      {
        if (paramInt == 6) {
          paramAppInterface = rechargeGameCurrency(paramAppInterface, paramActivity, paramResultReceiver, (String)localObject2, localObject3, k, l2, l1, localObject1);
        }
        for (;;)
        {
          return paramAppInterface;
          if (paramInt == 7) {
            paramAppInterface = buyGoods(paramAppInterface, paramActivity, paramResultReceiver, (String)localObject2, localObject3, k, l2, l1, localObject1);
          } else if (paramInt == 8) {
            paramAppInterface = rechargeQb(paramAppInterface, paramActivity, paramResultReceiver, (String)localObject2, localObject3, k, l2, l1, localObject1);
          } else if (paramInt == 4) {
            paramAppInterface = openService(paramAppInterface, paramActivity, paramResultReceiver, (String)localObject2, localObject3, k, l2, l1, localObject1);
          } else if (paramInt == 9) {
            paramAppInterface = pay(paramAppInterface, paramActivity, paramResultReceiver, (String)localObject2, localObject3, (String)localObject4, k, l2, l1, localObject1);
          } else if (paramInt == 14) {
            paramAppInterface = subscribeMonthCardPay(paramAppInterface, paramActivity, paramResultReceiver, (String)localObject2, localObject3, k, l2, l1, localObject1);
          } else if (paramInt == 17) {
            paramAppInterface = launchWeChat(paramAppInterface, paramActivity, paramResultReceiver, (String)localObject2, localObject3, k, l2, l1, localObject1);
          } else {
            paramAppInterface = localBundle;
          }
        }
      }
    }
  }
  
  private void newPay(int paramInt, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("callbackSn");
    String str2 = paramBundle.getString("json");
    String str3 = paramBundle.getString("payparmas_url_appinfo");
    Object localObject;
    if ((this.mReportSeq == 0L) && ((this.mPayType == -1) || (this.mPayType == 5) || (this.mPayType == 2)))
    {
      localObject = convertToReportAction(paramInt);
      if (localObject != null)
      {
        this.mReportSeq = VACDReportUtil.a(null, "qqwallet", (String)localObject, "payinvoke", null, 0, null);
        this.mIsStartReport = true;
      }
    }
    paramBundle = (ResultReceiver)paramBundle.getParcelable("_qwallet_payresult_receiver");
    if (paramBundle == null) {
      paramBundle = new PayLogic.CompactReceiver(ThreadManager.getUIHandlerV2(), this);
    }
    for (;;)
    {
      localObject = this.mActivity;
      if (paramInt == 4) {
        paramBundle = openService(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
      }
      for (;;)
      {
        if (paramBundle != null)
        {
          if (paramBundle.getInt("retCode", -1) == 0) {
            break label399;
          }
          paramBundle = paramBundle.getString("retJson");
          if (paramBundle != null) {
            tenpayResult(str1, paramBundle);
          }
          if (this.mReportSeq != 0L) {
            VACDReportUtil.endReport(this.mReportSeq, "parseurl", null, 668801, paramBundle);
          }
        }
        return;
        if (paramInt == 6)
        {
          paramBundle = rechargeGameCurrency(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
        }
        else if (paramInt == 7)
        {
          paramBundle = buyGoods(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
        }
        else if (paramInt == 8)
        {
          paramBundle = rechargeQb(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
        }
        else if (paramInt == 9)
        {
          paramBundle = pay(this.app, (Activity)localObject, paramBundle, str1, str2, str3, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
        }
        else if (paramInt == 14)
        {
          paramBundle = subscribeMonthCardPay(this.app, (Activity)localObject, paramBundle, str1, str2, this.mPayType, this.mPayH5StartTime, this.mReportSeq, null);
          continue;
          label399:
          if (paramInt == 9)
          {
            this.mPayTokenId = paramBundle.getString("token");
            this.mPayAppId = paramBundle.getString("appid");
            this.mPayChannel = paramBundle.getString("channel");
            this.mPayBargainorId = paramBundle.getString("bargainor");
            return;
          }
          this.mMidasOfferid = paramBundle.getString("offerId");
          this.mMidasAid = paramBundle.getString("aid");
          this.mMidasOrderId = paramBundle.getString("orderId");
        }
        else
        {
          paramBundle = null;
        }
      }
    }
  }
  
  private void onCheckWebankResult(Intent paramIntent)
  {
    this.mActivity.setResult(-1, paramIntent);
    end();
  }
  
  private void onEmojimallPayResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if ((i == 1) && (this.mEmojiPayReqData != null))
    {
      OnEmojimallPayResult(this.mEmojiPayReqData, j, k, m, n, i1, str);
      return;
    }
    OnEmojimallPayResult(this.mEmojiPayReqData, -1, -1, -1, -1, -1, "");
  }
  
  private void onF2FRedpackCheckError()
  {
    Object localObject = this.mActivity;
    localObject = bbcv.a((Context)localObject, 231, null, ((BaseActivity)localObject).getResources().getString(2131692246), ((BaseActivity)localObject).getResources().getString(2131692245), null, null, new PayLogic.1(this));
    ((bbgg)localObject).setCancelable(false);
    ((bbgg)localObject).show();
  }
  
  private void onGoldChargeResult(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt1);
    localBundle.putString("retInnerCode", paramString1);
    localBundle.putInt("realSaveNum", paramInt2);
    localBundle.putInt("payChannel", paramInt3);
    localBundle.putInt("payState", paramInt4);
    localBundle.putInt("provideState", paramInt5);
    localBundle.putString("message", paramString2);
    localIntent.putExtras(localBundle);
    this.mActivity.setResult(paramInt1, localIntent);
    saveNonePCPayResultData(paramInt1, localIntent);
    end();
  }
  
  private void onGoldChargeResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if (i == 1)
    {
      onGoldChargeResult(j, str1, k, m, n, i1, str2);
      return;
    }
    onGoldChargeResult(-1, "", -1, -1, -1, -1, "");
  }
  
  private void onMidasPayResult(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1) != 1) {
      paramIntent.putExtra("result", generateMidasErrorResult());
    }
    tenpayResult(paramIntent.getExtras());
  }
  
  private void onOpenQQReaderVipResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("realSaveNum", -1);
    int m = paramIntent.getIntExtra("payChannel", -1);
    int n = paramIntent.getIntExtra("payState", -1);
    int i1 = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int i2 = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, i2, null);
    }
    if (i == 1)
    {
      onGoldChargeResult(j, str1, k, m, n, i1, str2);
      return;
    }
    onGoldChargeResult(-1, "", -1, -1, -1, -1, "");
  }
  
  private void onOpenQzoneVipCallBack(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("retInnerCode", paramString1);
    localBundle.putString("msg", paramString2);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString1 = new Intent();
    paramString1.putExtras(localBundle);
    this.mActivity.setResult(paramInt1, paramString1);
    saveNonePCPayResultData(paramInt1, paramString1);
    end();
  }
  
  private void onOpenQzoneVipResult(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    int j = paramIntent.getIntExtra("result", -1);
    String str1 = paramIntent.getStringExtra("retInnerCode");
    int k = paramIntent.getIntExtra("payState", -1);
    int m = paramIntent.getIntExtra("provideState", -1);
    String str2 = paramIntent.getStringExtra("message");
    int n = paramIntent.getIntExtra("payRetCode", -1);
    long l = paramIntent.getLongExtra("reportSeq", 0L);
    if ((this.mIsStartReport) && (l > 0L)) {
      VACDReportUtil.endReport(l, "payEnd", null, n, null);
    }
    if (i == 1)
    {
      onOpenQzoneVipCallBack(j, str1, str2, k, m);
      return;
    }
    onOpenQzoneVipCallBack(-1, "", "", -1, -1);
  }
  
  private void onOpenQzoneVipServiceCallBack(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localBundle.putInt("payState", paramInt2);
    localBundle.putInt("provideState", paramInt3);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    this.mActivity.setResult(paramInt1, paramString);
    saveNonePCPayResultData(paramInt1, paramString);
    end();
  }
  
  private void onOpenTenpayViewResult(Intent paramIntent)
  {
    int j = paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1);
    Object localObject1 = paramIntent.getStringExtra("result");
    int k = paramIntent.getIntExtra("viewRetCode", -9);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.PayLogic", 2, "onOpenTenpayViewResult mOpenViewTag=" + this.mOpenViewTag + ",nPayResult=" + j + ",result=" + (String)localObject1 + ",viewRetCode=" + k);
    }
    Intent localIntent;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        JSONObject localJSONObject = new JSONObject((String)localObject1).optJSONObject("retdata");
        if (localJSONObject != null)
        {
          localIntent = new Intent();
          localIntent.putExtra("retdata", localJSONObject.toString());
          i = Integer.valueOf(localJSONObject.optString("exec_code", "-1")).intValue();
          if ((i == 1) || (i == 2) || (i == 3))
          {
            this.mActivity.setResult(-1, localIntent);
            end();
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    if ((k == 0) && (!TextUtils.isEmpty((CharSequence)localObject1)) && ("hbPackConfirm".equalsIgnoreCase(this.mOpenViewTag))) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(new JSONObject((String)localObject1).optString("retmsg"));
        if (localObject1 != null)
        {
          Object localObject2 = new JSONObject(((JSONObject)localObject1).optString("user_msg"));
          if ((localObject2 != null) && (((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")))
          {
            localObject1 = ((JSONObject)localObject2).getString("uin");
            switch (((JSONObject)localObject2).getInt("type"))
            {
            case 0: 
              if (i != -1)
              {
                localObject2 = this.mActivity;
                localIntent = actn.a(new Intent((Context)localObject2, SplashActivity.class), null);
                localIntent.putExtra("uin", (String)localObject1);
                localIntent.putExtra("uintype", i);
                localIntent.putExtra("isBack2Root", true);
                ((BaseActivity)localObject2).startActivity(localIntent);
              }
              break;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        continue;
        paramIntent.putExtra("payRetCode", k);
        paramIntent.putExtra("result", generateTenPayErrorResult());
        tenpayResult(paramIntent.getExtras());
        return;
      }
      if (j == 1)
      {
        paramIntent.putExtra("payRetCode", k);
        tenpayResult(paramIntent.getExtras());
        return;
        i = 0;
        continue;
        i = 3000;
        continue;
        i = 1;
        continue;
        i = 1000;
        continue;
        i = 1004;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  private void onPayResult(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("QWalletPayBridge.PayResult.ExtraKey", 1) == 1)
    {
      tenpayResult(paramIntent.getExtras());
      return;
    }
    paramIntent.putExtra("result", generateTenPayErrorResult());
    tenpayResult(paramIntent.getExtras());
  }
  
  private void onQWalletCrash()
  {
    if (this.intent == null) {
      return;
    }
    BaseActivity localBaseActivity = this.mActivity;
    Object localObject1 = this.intent.getStringExtra("title");
    Object localObject2 = this.intent.getStringExtra("content");
    String str1 = this.intent.getStringExtra("btn");
    String str2 = this.intent.getStringExtra("url");
    bbgg localbbgg = bbcv.a(localBaseActivity, 0);
    localbbgg.setTitle((String)localObject1);
    localbbgg.setMessage((CharSequence)localObject2);
    localbbgg.setCancelable(false);
    localObject2 = new PayLogic.2(this, str2);
    localObject1 = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject1 = localBaseActivity.getResources().getString(2131694793);
    }
    localbbgg.setPositiveButton((String)localObject1, (DialogInterface.OnClickListener)localObject2);
    localbbgg.show();
  }
  
  private void openQzoneVipService(Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("offerId");
      String str2 = paramBundle.getString("userId");
      String str3 = paramBundle.getString("skey");
      String str4 = paramBundle.getString("serviceCode");
      String str5 = paramBundle.getString("serviceName");
      String str6 = paramBundle.getString("channel");
      String str7 = paramBundle.getString("uint");
      String str8 = paramBundle.getString("openMonth");
      boolean bool1 = paramBundle.getBoolean("isCanChange");
      String str9 = paramBundle.getString("provideUin");
      String str10 = paramBundle.getString("provideType");
      String str11 = paramBundle.getString("discountId");
      String str12 = paramBundle.getString("other");
      String str13 = paramBundle.getString("payload");
      boolean bool2 = paramBundle.getBoolean("autoPay", true);
      String str14 = paramBundle.getString("drmInfo");
      Object localObject = paramBundle.getString("aid");
      paramBundle = "qq_m_qq-2013-android-" + AppSetting.a() + "-" + (String)localObject;
      this.mMidasOfferid = str1;
      this.mMidasAid = ((String)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("setEnv", "release");
      ((Bundle)localObject).putBoolean("setLogEnable", true);
      ((Bundle)localObject).putString("offerId", str1);
      if ((str7 != null) && (str7.length() > 0)) {
        ((Bundle)localObject).putString("unit", str7);
      }
      if ((str6 != null) && (str6.length() > 0)) {
        ((Bundle)localObject).putString("payChannel", str6);
      }
      ((Bundle)localObject).putString("userId", str2);
      ((Bundle)localObject).putString("userKey", str3);
      ((Bundle)localObject).putString("sessionId", "uin");
      ((Bundle)localObject).putString("sessionType", "skey");
      ((Bundle)localObject).putString("pf", paramBundle);
      ((Bundle)localObject).putString("pfKey", "pfKey");
      ((Bundle)localObject).putString("serviceCode", str4);
      ((Bundle)localObject).putString("serviceName", str5);
      ((Bundle)localObject).putBoolean("autoPay", bool2);
      ((Bundle)localObject).putInt("resId", 0);
      if ((str8 != null) && (str8.length() > 0))
      {
        ((Bundle)localObject).putString("saveValue", str8);
        ((Bundle)localObject).putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
      }
      ((Bundle)localObject).putString("remark", "");
      ((Bundle)localObject).putString("provideUin", str9);
      ((Bundle)localObject).putString("provideType", str10);
      ((Bundle)localObject).putString("discountId", str11);
      ((Bundle)localObject).putString("other", str12);
      ((Bundle)localObject).putString("payload", str13);
      ((Bundle)localObject).putString("drmInfo", str14);
      ((Bundle)localObject).putInt("PayInvokerId", 4);
      ((Bundle)localObject).putInt("payparmas_paytype", this.mPayType);
      putProxyReceiverToBundle((Bundle)localObject);
      QWalletPayBridge.launchForeground(this.mActivity, this.app, (Bundle)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay.PayLogic", 2, "openService Exception:" + paramBundle.getMessage());
      }
      onOpenQzoneVipServiceCallBack(-5, "openService Exception", -1, -1);
      paramBundle.printStackTrace();
    }
  }
  
  private void openSVip(Bundle paramBundle)
  {
    this.mIsStartReport = true;
    String str1;
    if ((this.mReportSeq == 0L) && ((this.mPayType == -1) || (this.mPayType == 5) || (this.mPayType == 2)))
    {
      str1 = convertToReportAction(this.mRequestCode);
      if (str1 != null)
      {
        this.mReportSeq = VACDReportUtil.a(null, "qqwallet", str1, "payinvoke", null, 0, null);
        this.mIsStartReport = true;
      }
    }
    String str18 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "PayBridgeActivity openSVip request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str18));
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramBundle.getString("json"));
        String str22 = ((JSONObject)localObject).getString("offerId");
        String str19 = ((JSONObject)localObject).getString("userId");
        String str20 = ((JSONObject)localObject).getString("serviceCode");
        String str21 = ((JSONObject)localObject).getString("serviceName");
        if (((JSONObject)localObject).has("channel"))
        {
          str1 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label1400;
          }
          str2 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("openMonth")) {
            break label1406;
          }
          str3 = ((JSONObject)localObject).getString("openMonth");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label1412;
          }
          bool1 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("isAutoPay")) {
            break label1418;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isAutoPay");
          if (!((JSONObject)localObject).has("remark")) {
            break label1424;
          }
          str4 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("aid")) {
            break label1432;
          }
          str5 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("actTitle")) {
            break label1440;
          }
          str6 = ((JSONObject)localObject).getString("actTitle");
          if (!((JSONObject)localObject).has("openType")) {
            break label1448;
          }
          i = ((JSONObject)localObject).getInt("openType");
          if (!((JSONObject)localObject).has("actHint")) {
            break label1453;
          }
          str7 = ((JSONObject)localObject).getString("actHint");
          if (!((JSONObject)localObject).has("actPayTotal")) {
            break label1459;
          }
          str8 = ((JSONObject)localObject).getString("actPayTotal");
          if (!((JSONObject)localObject).has("actPayDiscount")) {
            break label1465;
          }
          str9 = ((JSONObject)localObject).getString("actPayDiscount");
          if (!((JSONObject)localObject).has("actBtnTitle")) {
            break label1471;
          }
          str10 = ((JSONObject)localObject).getString("actBtnTitle");
          if (!((JSONObject)localObject).has("openServicePrice")) {
            break label1477;
          }
          str11 = ((JSONObject)localObject).getString("openServicePrice");
          if (!((JSONObject)localObject).has("upgradeServicePrice")) {
            break label1483;
          }
          str12 = ((JSONObject)localObject).getString("upgradeServicePrice");
          if (!((JSONObject)localObject).has("maxUpgradeMonth")) {
            break label1489;
          }
          j = ((JSONObject)localObject).getInt("maxUpgradeMonth");
          if (!((JSONObject)localObject).has("openTitle")) {
            break label1494;
          }
          str13 = ((JSONObject)localObject).getString("openTitle");
          if (!((JSONObject)localObject).has("upgradeTitle")) {
            break label1502;
          }
          str14 = ((JSONObject)localObject).getString("upgradeTitle");
          if (!((JSONObject)localObject).has("discountId")) {
            break label1510;
          }
          str15 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label1518;
          }
          str16 = ((JSONObject)localObject).getString("other");
          if (!((JSONObject)localObject).has("payload")) {
            break label1526;
          }
          str17 = ((JSONObject)localObject).getString("payload");
          if (((JSONObject)localObject).has("couponId"))
          {
            localObject = ((JSONObject)localObject).getString("couponId");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramBundle.getString("json"));
            paramBundle = paramBundle.getString("payparmas_h5_url");
            if (!TextUtils.isEmpty(paramBundle)) {
              localStringBuilder.append("&url=").append(paramBundle);
            }
            VACDReportUtil.a(this.mReportSeq, null, "parseurl", localStringBuilder.toString(), 0, null);
            this.mMidasOfferid = str22;
            this.mMidasAid = str5;
            paramBundle = new Bundle();
            paramBundle.putString("offerId", str22);
            paramBundle.putString("setEnv", "release");
            paramBundle.putBoolean("setLogEnable", false);
            if ((str2 != null) && (str2.length() > 0)) {
              paramBundle.putString("unit", str2);
            }
            if ((str1 != null) && (str1.length() > 0)) {
              paramBundle.putString("payChannel", str1);
            }
            paramBundle.putString("callbackSn", str18);
            str1 = "qq_m_qq-2013-android-" + AppSetting.a() + "-" + str5;
            paramBundle.putString("userId", str19);
            paramBundle.putString("sessionId", "uin");
            paramBundle.putString("pf", str1);
            paramBundle.putString("pfKey", "pfKey");
            paramBundle.putString("serviceCode", str20);
            paramBundle.putString("serviceName", str21);
            paramBundle.putInt("resId", 0);
            if ((str3 != null) && (str3.length() > 0))
            {
              paramBundle.putString("openMonth", str3);
              paramBundle.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
            }
            paramBundle.putBoolean("isAutoPay", Boolean.valueOf(bool2).booleanValue());
            paramBundle.putString("remark", str4);
            paramBundle.putString("actTitle", str6);
            paramBundle.putInt("openType", i);
            paramBundle.putString("actHint", str7);
            paramBundle.putString("actPayTotal", str8);
            paramBundle.putString("actPayDiscount", str9);
            paramBundle.putString("actBtnTitle", str10);
            paramBundle.putString("openServicePrice", str11);
            paramBundle.putString("upgradeServicePrice", str12);
            paramBundle.putInt("maxUpgradeMonth", j);
            paramBundle.putString("openTitle", str13);
            paramBundle.putString("upgradeTitle", str14);
            paramBundle.putString("discountId", str15);
            paramBundle.putString("other", str16);
            paramBundle.putString("payload", str17);
            paramBundle.putString("couponId", (String)localObject);
            paramBundle.putInt("PayInvokerId", 11);
            paramBundle.putInt("payparmas_paytype", this.mPayType);
            paramBundle.putLong("payparmas_h5_start", this.mPayH5StartTime);
            paramBundle.putLong("vacreport_key_seq", this.mReportSeq);
            VACDReportUtil.a(this.mReportSeq, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            putProxyReceiverToBundle(paramBundle);
            QWalletPayBridge.launchForeground(this.mActivity, this.app, paramBundle);
            return;
          }
          localObject = "";
          continue;
        }
        str1 = null;
      }
      catch (JSONException paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "openSVip JSONException:" + paramBundle.getMessage());
        }
        paramBundle = new Bundle();
        paramBundle.putString("callbackSn", str18);
        paramBundle.putString("result", "{'resultCode':-1,'resultMsg':'openSVip JSONException'}");
        paramBundle.putInt("payRetCode", -1);
        paramBundle.putLong("reportSeq", this.mReportSeq);
        tenpayResult(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "openSVip Exception:" + paramBundle.getMessage());
        }
        paramBundle = new Bundle();
        paramBundle.putString("callbackSn", str18);
        paramBundle.putString("result", "{'resultCode':-1,'resultMsg':'openSVip Exception'}");
        paramBundle.putInt("payRetCode", -1);
        paramBundle.putLong("reportSeq", this.mReportSeq);
        tenpayResult(paramBundle);
        return;
      }
      continue;
      label1400:
      String str2 = null;
      continue;
      label1406:
      String str3 = null;
      continue;
      label1412:
      boolean bool1 = true;
      continue;
      label1418:
      boolean bool2 = true;
      continue;
      label1424:
      String str4 = "";
      continue;
      label1432:
      String str5 = "";
      continue;
      label1440:
      String str6 = "";
      continue;
      label1448:
      int i = 0;
      continue;
      label1453:
      String str7 = null;
      continue;
      label1459:
      String str8 = null;
      continue;
      label1465:
      String str9 = null;
      continue;
      label1471:
      String str10 = null;
      continue;
      label1477:
      String str11 = null;
      continue;
      label1483:
      String str12 = null;
      continue;
      label1489:
      int j = 0;
      continue;
      label1494:
      String str13 = "";
      continue;
      label1502:
      String str14 = "";
      continue;
      label1510:
      String str15 = "";
      continue;
      label1518:
      String str16 = "";
      continue;
      label1526:
      String str17 = "";
    }
  }
  
  protected static Bundle openService(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str15 = ((JSONObject)localObject).getString("offerId");
        String str16 = ((JSONObject)localObject).getString("userId");
        String str17 = ((JSONObject)localObject).getString("serviceCode");
        String str18 = ((JSONObject)localObject).getString("serviceName");
        if (!((JSONObject)localObject).has("channel")) {
          break label1105;
        }
        str1 = ((JSONObject)localObject).getString("channel");
        if (!((JSONObject)localObject).has("unit")) {
          break label1111;
        }
        str2 = ((JSONObject)localObject).getString("unit");
        if (!((JSONObject)localObject).has("openMonth")) {
          break label1117;
        }
        str3 = ((JSONObject)localObject).getString("openMonth");
        if (!((JSONObject)localObject).has("isCanChange")) {
          break label1123;
        }
        bool1 = ((JSONObject)localObject).getBoolean("isCanChange");
        if (!((JSONObject)localObject).has("remark")) {
          break label1129;
        }
        str4 = ((JSONObject)localObject).getString("remark");
        if (!((JSONObject)localObject).has("provideUin")) {
          break label1137;
        }
        str5 = ((JSONObject)localObject).getString("provideUin");
        if (!((JSONObject)localObject).has("provideType")) {
          break label1143;
        }
        str6 = ((JSONObject)localObject).getString("provideType");
        if (!((JSONObject)localObject).has("discountId")) {
          break label1149;
        }
        str7 = ((JSONObject)localObject).getString("discountId");
        if (!((JSONObject)localObject).has("other")) {
          break label1157;
        }
        str8 = ((JSONObject)localObject).getString("other");
        if (!((JSONObject)localObject).has("payload")) {
          break label1165;
        }
        str9 = ((JSONObject)localObject).getString("payload");
        if (!((JSONObject)localObject).has("autoPay")) {
          break label1173;
        }
        bool2 = ((JSONObject)localObject).getBoolean("autoPay");
        if (!((JSONObject)localObject).has("aid")) {
          break label1179;
        }
        str10 = ((JSONObject)localObject).getString("aid");
        if (!((JSONObject)localObject).has("couponId")) {
          break label1187;
        }
        str11 = ((JSONObject)localObject).getString("couponId");
        if ((((JSONObject)localObject).has("ticketName")) && (((JSONObject)localObject).has("ticketValue")))
        {
          str12 = ((JSONObject)localObject).getString("ticketName");
          str13 = ((JSONObject)localObject).getString("ticketValue");
          String str14;
          if (((JSONObject)localObject).has("pf"))
          {
            str14 = ((JSONObject)localObject).getString("pf");
            if (((JSONObject)localObject).has("drmInfo"))
            {
              localObject = ((JSONObject)localObject).getString("drmInfo");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("json=").append(paramString2);
              if (!TextUtils.isEmpty(paramString3)) {
                localStringBuilder.append("&url=").append(paramString3);
              }
              VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
              paramString2 = new Bundle();
              paramString2.putString("offerId", str15);
              paramString2.putString("setEnv", "release");
              paramString2.putBoolean("setLogEnable", false);
              if ((str2 != null) && (str2.length() > 0)) {
                paramString2.putString("unit", str2);
              }
              if ((str1 != null) && (str1.length() > 0)) {
                paramString2.putString("payChannel", str1);
              }
              paramString2.putString("callbackSn", paramString1);
              paramString2.putString("userId", str16);
              if (str13 != null)
              {
                paramString2.putString("sessionType", str12);
                paramString2.putString("userKey", str13);
              }
              paramString2.putString("sessionId", "uin");
              paramString2.putString("pf", str14);
              paramString2.putString("pfKey", "pfKey");
              paramString2.putString("serviceCode", str17);
              paramString2.putString("serviceName", str18);
              paramString2.putInt("resId", 0);
              if ((str3 != null) && (str3.length() > 0))
              {
                paramString2.putString("saveValue", str3);
                paramString2.putBoolean("isCanChange", Boolean.valueOf(bool1).booleanValue());
              }
              paramString2.putString("remark", str4);
              paramString2.putString("provideUin", str5);
              paramString2.putString("provideType", str6);
              paramString2.putString("discountId", str7);
              paramString2.putString("other", str8);
              paramString2.putString("payload", str9);
              paramString2.putBoolean("autoPay", Boolean.valueOf(bool2).booleanValue());
              paramString2.putString("couponId", str11);
              paramString2.putString("drmInfo", (String)localObject);
              paramString2.putInt("PayInvokerId", 4);
              paramString2.putInt("payparmas_paytype", paramInt);
              paramString2.putLong("payparmas_h5_start", paramLong1);
              paramString2.putLong("vacreport_key_seq", paramLong2);
              setIPCReceiver(paramResultReceiver, paramString2);
              VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
              if (QLog.isDevelopLevel()) {
                QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
              }
              QWalletPayBridge.launchForeground(paramActivity, paramAppInterface, paramString2);
              localBundle.putInt("retCode", 0);
              localBundle.putString("offerId", str15);
              localBundle.putString("aid", str10);
              return localBundle;
            }
          }
          else
          {
            str14 = "qq_m_qq-2013-android-" + AppSetting.a() + "-" + str10;
            continue;
          }
          localObject = "";
          continue;
        }
        String str12 = null;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "openService JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'openService JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "openService Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'openService Exception'}");
        return localBundle;
      }
      String str13 = null;
      continue;
      label1105:
      String str1 = null;
      continue;
      label1111:
      String str2 = null;
      continue;
      label1117:
      String str3 = null;
      continue;
      label1123:
      boolean bool1 = true;
      continue;
      label1129:
      String str4 = "";
      continue;
      label1137:
      String str5 = null;
      continue;
      label1143:
      String str6 = null;
      continue;
      label1149:
      String str7 = "";
      continue;
      label1157:
      String str8 = "";
      continue;
      label1165:
      String str9 = "";
      continue;
      label1173:
      boolean bool2 = true;
      continue;
      label1179:
      String str10 = "";
      continue;
      label1187:
      String str11 = "";
    }
  }
  
  private void openTenpayView(Bundle paramBundle)
  {
    int i = 1;
    BaseActivity localBaseActivity = this.mActivity;
    String str2 = paramBundle.getString("callbackSn");
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "PayBridgeActivity openTenpayView request=" + paramBundle.toString() + ",callbackSn=" + String.valueOf(str2));
    }
    JSONObject localJSONObject;
    Object localObject1;
    String str3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramBundle.getString("json"));
        localObject2 = localJSONObject.optString("userId");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("0")) {}
        }
        else
        {
          localObject1 = this.app.c();
        }
        str3 = localJSONObject.getString("viewTag");
        if (QLog.isColorLevel()) {
          QLog.i(str3, 2, "openTenpayView json = " + localJSONObject);
        }
        if ((str3 == null) || (!allowView.contains(str3)))
        {
          if (QLog.isColorLevel()) {
            QLog.e(str3, 2, "openTenpayView viewTag is not allow");
          }
          tenpayResult(str2, "{'resultCode':-1,'retmsg':'openTenpayView param viewTag error'}");
          return;
        }
        if (("transfer".compareTo(str3) != 0) && ("transferInput".compareTo(str3) != 0)) {
          break;
        }
        localObject1 = new Intent(localBaseActivity, TransactionActivity.class);
        ((Intent)localObject1).putExtra("callbackSn", str2);
        ((Intent)localObject1).putExtra("come_from", 1);
        ((Intent)localObject1).putExtra("tag", str3);
        if (localJSONObject.has("appInfo"))
        {
          paramBundle = localJSONObject.getString("appInfo");
          ((Intent)localObject1).putExtra("app_info", paramBundle);
          if (!localJSONObject.has("extra_data")) {
            break label2055;
          }
          paramBundle = localJSONObject.getString("extra_data");
          ((Intent)localObject1).putExtra("extra_data", paramBundle);
          ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "is_H5=true", 0, null));
          localBaseActivity.startActivityForResult((Intent)localObject1, 5);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "openTenpayView Exception", paramBundle);
        }
        tenpayResult(str2, "{'resultCode':-1,'retmsg':'openTenpayView Exception'}");
        paramBundle.printStackTrace();
        return;
      }
      paramBundle = "";
    }
    label701:
    label730:
    label993:
    label1130:
    Object localObject3;
    if ("makeHongbao".compareTo(str3) == 0)
    {
      localObject1 = localJSONObject.optJSONObject("extra_data");
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).optString("hb_from_type", "0");
        if ((!((String)localObject2).equals("0")) && (!((String)localObject2).equals("1")) && (!((String)localObject2).equals("2")) && (!((String)localObject2).equals("100")))
        {
          tenpayResult(str2, "{'resultCode':-1001,'retmsg':'hb_from_type参数错误'}");
          return;
        }
        if (((String)localObject2).equals("0"))
        {
          if (((JSONObject)localObject1).has("hb_from")) {
            ((JSONObject)localObject1).remove("hb_from");
          }
          if (((JSONObject)localObject1).has("makeHb_type")) {
            ((JSONObject)localObject1).remove("makeHb_type");
          }
          if (((JSONObject)localObject1).has("skin_id")) {
            ((JSONObject)localObject1).remove("skin_id");
          }
          if (((JSONObject)localObject1).has("feedsid")) {
            ((JSONObject)localObject1).remove("feedsid");
          }
          if (((JSONObject)localObject1).has("total_amount")) {
            ((JSONObject)localObject1).remove("total_amount");
          }
          if (((JSONObject)localObject1).has("total_num")) {
            ((JSONObject)localObject1).remove("total_num");
          }
          if (((JSONObject)localObject1).has("wishing")) {
            ((JSONObject)localObject1).remove("wishing");
          }
          if (((JSONObject)localObject1).has("biz_params")) {
            ((JSONObject)localObject1).remove("biz_params");
          }
          localObject1 = new Intent(localBaseActivity, SendHbActivity.class);
          ((Intent)localObject1).putExtra("callbackSn", str2);
          ((Intent)localObject1).putExtra("come_from", 2);
          ((Intent)localObject1).putExtra("is_H5", true);
          if (!localJSONObject.has("appInfo")) {
            break label2062;
          }
          paramBundle = localJSONObject.getString("appInfo");
          ((Intent)localObject1).putExtra("app_info", paramBundle);
          if (!localJSONObject.has("extra_data")) {
            break label2069;
          }
          paramBundle = localJSONObject.getString("extra_data");
          ((Intent)localObject1).putExtra("extra_data", paramBundle);
          ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
          localBaseActivity.startActivityForResult((Intent)localObject1, 5);
          return;
        }
        if (((String)localObject2).equals("100"))
        {
          ((JSONObject)localObject1).put("domain", paramBundle.getString("h5_common_redpacket_domain"));
          paramBundle = ((JSONObject)localObject1).optJSONObject("selector");
          if (paramBundle != null)
          {
            i = paramBundle.optInt("type");
            if (i == 0)
            {
              paramBundle = new Intent();
              paramBundle.putExtra("callbackSn", str2);
              paramBundle.putExtra("come_from", 2);
              paramBundle.putExtra("is_H5", true);
              paramBundle.putExtra("extra_data", ((JSONObject)localObject1).toString());
              paramBundle.putExtra("forward_type", 18);
              paramBundle.setClass(localBaseActivity, ForwardRecentActivity.class);
              localBaseActivity.startActivityForResult(paramBundle, 5);
              return;
            }
            if (i == 1)
            {
              localObject1 = new Intent(localBaseActivity, SendHbActivity.class);
              ((Intent)localObject1).putExtra("callbackSn", str2);
              ((Intent)localObject1).putExtra("come_from", 2);
              ((Intent)localObject1).putExtra("is_H5", true);
              if (!localJSONObject.has("appInfo")) {
                break label2076;
              }
              paramBundle = localJSONObject.getString("appInfo");
              label964:
              ((Intent)localObject1).putExtra("app_info", paramBundle);
              if (!localJSONObject.has("extra_data")) {
                break label2083;
              }
              paramBundle = localJSONObject.getString("extra_data");
              ((Intent)localObject1).putExtra("extra_data", paramBundle);
              ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
              localBaseActivity.startActivityForResult((Intent)localObject1, 5);
              return;
            }
            if (i == 2)
            {
              localObject1 = new Intent(localBaseActivity, SendHbActivity.class);
              ((Intent)localObject1).putExtra("callbackSn", str2);
              ((Intent)localObject1).putExtra("come_from", 2);
              ((Intent)localObject1).putExtra("is_H5", true);
              if (!localJSONObject.has("appInfo")) {
                break label2090;
              }
              paramBundle = localJSONObject.getString("appInfo");
              label1101:
              ((Intent)localObject1).putExtra("app_info", paramBundle);
              if (!localJSONObject.has("extra_data")) {
                break label2097;
              }
              paramBundle = localJSONObject.getString("extra_data");
              ((Intent)localObject1).putExtra("extra_data", paramBundle);
              ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
              localBaseActivity.startActivityForResult((Intent)localObject1, 5);
            }
          }
        }
        else if (((JSONObject)localObject1).optJSONObject("extra_info") != null)
        {
          paramBundle = new Intent();
          paramBundle.putExtra("callbackSn", str2);
          paramBundle.putExtra("come_from", 2);
          paramBundle.putExtra("is_H5", true);
          paramBundle.putExtra("extra_data", ((JSONObject)localObject1).toString());
          paramBundle.putExtra("forward_type", 18);
          paramBundle.setClass(localBaseActivity, ForwardRecentActivity.class);
          localBaseActivity.startActivityForResult(paramBundle, 5);
          return;
        }
      }
      localObject1 = new Intent(localBaseActivity, SendHbActivity.class);
      ((Intent)localObject1).putExtra("callbackSn", str2);
      ((Intent)localObject1).putExtra("come_from", 2);
      ((Intent)localObject1).putExtra("is_H5", true);
      if (!localJSONObject.has("appInfo")) {
        break label2104;
      }
      paramBundle = localJSONObject.getString("appInfo");
      label1319:
      ((Intent)localObject1).putExtra("app_info", paramBundle);
      if (!localJSONObject.has("extra_data")) {
        break label2111;
      }
      paramBundle = localJSONObject.getString("extra_data");
      label1348:
      ((Intent)localObject1).putExtra("extra_data", paramBundle);
      ((Intent)localObject1).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "is_H5=true", 0, null));
      localBaseActivity.startActivityForResult((Intent)localObject1, 5);
    }
    else
    {
      if ("parseqrcode".compareTo(str3) == 0)
      {
        localObject1 = new Intent(localBaseActivity, TenpayJumpActivity.class);
        ((Intent)localObject1).putExtra("callbackSn", str2);
        if (!localJSONObject.has("comeForm")) {
          break label2118;
        }
        i = localJSONObject.getInt("comeForm");
        label1443:
        ((Intent)localObject1).putExtra("come_from", i);
        if (!localJSONObject.has("appInfo")) {
          break label2123;
        }
        paramBundle = localJSONObject.getString("appInfo");
        label1472:
        ((Intent)localObject1).putExtra("app_info", paramBundle);
        if (!localJSONObject.has("extra_data")) {
          break label2130;
        }
        paramBundle = localJSONObject.getString("extra_data");
        label1501:
        ((Intent)localObject1).putExtra("extra_data", paramBundle);
        localBaseActivity.startActivityForResult((Intent)localObject1, 5);
        return;
      }
      String str4;
      if ("transferqrcode".compareTo(str3) == 0)
      {
        str4 = this.app.getCurrentNickname();
        localObject2 = localJSONObject.optJSONObject("extra_data");
        localObject3 = localObject2;
        if (localObject2 != null) {}
      }
      try
      {
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("name", str4);
        localJSONObject.put("extra_data", localObject3);
      }
      catch (Exception localException)
      {
        label1587:
        break label1587;
      }
      if ("graphb".compareTo(str3) == 0) {
        this.mIsStartReport = true;
      }
      localObject3 = new Bundle();
      if ((str3.equals("bindNewCard")) && (localJSONObject.has("bargainor_id"))) {
        ((Bundle)localObject3).putString("bargainor_id", localJSONObject.getString("bargainor_id"));
      }
      if (localJSONObject.has("comeForm")) {
        i = localJSONObject.getInt("comeForm");
      }
      ((Bundle)localObject3).putInt("come_from", i);
      if (!localJSONObject.has("appInfo")) {
        break label2137;
      }
      localObject2 = localJSONObject.getString("appInfo");
      label1698:
      ((Bundle)localObject3).putString("app_info", (String)localObject2);
      if (!localJSONObject.has("extra_data")) {
        break label2145;
      }
      localObject2 = localJSONObject.getString("extra_data");
      label1729:
      ((Bundle)localObject3).putString("extra_data", (String)localObject2);
      if (!localJSONObject.has("senderuin")) {
        break label2153;
      }
    }
    label2055:
    label2062:
    label2069:
    label2076:
    label2083:
    label2090:
    label2097:
    label2104:
    label2111:
    label2118:
    label2123:
    label2130:
    label2137:
    String str1;
    label2145:
    label2153:
    for (Object localObject2 = localJSONObject.getString("senderuin");; str1 = "")
    {
      ((Bundle)localObject3).putString("senderuin", (String)localObject2);
      this.mOpenViewTag = str3;
      localObject2 = new Bundle(paramBundle);
      ((Bundle)localObject2).putString("callbackSn", str2);
      ((Bundle)localObject2).putString("tag", str3);
      ((Bundle)localObject2).putString("uin", (String)localObject1);
      if (!TextUtils.isEmpty(this.app.getCurrentAccountUin())) {
        ((Bundle)localObject2).putString("nick_name", this.app.getCurrentNickname());
      }
      ((Bundle)localObject2).putBundle("params", (Bundle)localObject3);
      ((Bundle)localObject2).putInt("PayInvokerId", 5);
      ((Bundle)localObject2).putInt("payparmas_paytype", this.mPayType);
      ((Bundle)localObject2).putBoolean("payparmas_is_lock_withdraw", this.isLockWithdraw);
      localObject1 = paramBundle.getString("json");
      if (this.mReportSeq == 0L)
      {
        this.mReportSeq = VACDReportUtil.a(null, "qqwallet", "view." + str3, "loadPluginStart", (String)localObject1, 0, null);
        this.mIsStartReport = true;
      }
      for (;;)
      {
        ((Bundle)localObject2).putLong("vacreport_key_seq", this.mReportSeq);
        if (QLog.isDevelopLevel()) {
          QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
        }
        paramBundle = paramBundle.getBundle("extra_ext_data");
        if (paramBundle != null) {
          ((Bundle)localObject2).putBundle("extra_ext_data", paramBundle);
        }
        putProxyReceiverToBundle((Bundle)localObject2);
        QWalletPayBridge.launchForeground(localBaseActivity, this.app, (Bundle)localObject2);
        return;
        VACDReportUtil.a(this.mReportSeq, null, "loadPluginStart", (String)localObject1, 0, null);
      }
      paramBundle = "";
      break;
      paramBundle = "";
      break label701;
      paramBundle = "";
      break label730;
      paramBundle = "";
      break label964;
      paramBundle = "";
      break label993;
      paramBundle = "";
      break label1101;
      paramBundle = "";
      break label1130;
      paramBundle = "";
      break label1319;
      paramBundle = "";
      break label1348;
      i = 5;
      break label1443;
      paramBundle = "";
      break label1472;
      paramBundle = "";
      break label1501;
      str1 = "";
      break label1698;
      str1 = "";
      break label1729;
    }
  }
  
  /* Error */
  protected static Bundle pay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, String paramString4)
  {
    // Byte code:
    //   0: new 215	android/os/Bundle
    //   3: dup
    //   4: invokespecial 216	android/os/Bundle:<init>	()V
    //   7: astore 24
    //   9: aload 5
    //   11: astore 16
    //   13: aload 5
    //   15: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifne +13 -> 31
    //   21: aload 5
    //   23: ldc_w 1216
    //   26: invokestatic 1221	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 16
    //   31: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +43 -> 77
    //   37: ldc 14
    //   39: iconst_2
    //   40: new 262	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 1223
    //   50: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 743
    //   61: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_3
    //   65: invokestatic 1029	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 745	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: new 218	org/json/JSONObject
    //   80: dup
    //   81: aload 4
    //   83: invokespecial 221	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   86: astore 25
    //   88: aload_0
    //   89: invokevirtual 1226	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   92: astore 26
    //   94: aload_0
    //   95: invokevirtual 1230	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   98: new 262	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   105: getstatic 1236	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   108: invokevirtual 1237	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   111: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload 26
    //   116: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 1242	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 27
    //   127: aload 25
    //   129: ldc_w 677
    //   132: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 28
    //   137: aload 25
    //   139: ldc_w 256
    //   142: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   145: ifeq +571 -> 716
    //   148: aload 25
    //   150: ldc_w 256
    //   153: invokevirtual 260	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   156: istore 12
    //   158: aload 25
    //   160: ldc_w 1108
    //   163: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   166: ifeq +556 -> 722
    //   169: aload 25
    //   171: ldc_w 1108
    //   174: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 18
    //   179: aload 25
    //   181: ldc_w 1244
    //   184: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   187: ifeq +1044 -> 1231
    //   190: aload 25
    //   192: ldc_w 1244
    //   195: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: astore 5
    //   200: aload 25
    //   202: ldc_w 1246
    //   205: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   208: ifeq +1031 -> 1239
    //   211: aload 25
    //   213: ldc_w 1246
    //   216: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: astore 17
    //   221: aload 18
    //   223: aload 16
    //   225: invokestatic 1251	cooperation/qwallet/plugin/QWalletHelper:getCorrectAppInfo	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   228: astore 29
    //   230: aload 25
    //   232: ldc_w 635
    //   235: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   238: ifeq +1009 -> 1247
    //   241: aload 25
    //   243: ldc_w 635
    //   246: invokevirtual 227	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 16
    //   251: iconst_1
    //   252: iload 6
    //   254: if_icmpne +1001 -> 1255
    //   257: aload 25
    //   259: ldc_w 644
    //   262: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   265: ifne +14 -> 279
    //   268: aload 25
    //   270: ldc_w 646
    //   273: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   276: ifeq +979 -> 1255
    //   279: aload 25
    //   281: ldc_w 648
    //   284: invokevirtual 237	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   287: istore 15
    //   289: iload 15
    //   291: ifeq +964 -> 1255
    //   294: iconst_1
    //   295: istore 15
    //   297: new 262	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   304: astore 18
    //   306: aload 18
    //   308: ldc_w 699
    //   311: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 28
    //   316: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 18
    //   322: ldc_w 1253
    //   325: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload 12
    //   330: invokevirtual 329	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 18
    //   336: ldc_w 689
    //   339: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 29
    //   344: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 18
    //   350: ldc_w 1255
    //   353: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 5
    //   358: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 18
    //   364: ldc_w 1257
    //   367: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 17
    //   372: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 18
    //   378: ldc_w 1259
    //   381: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 25
    //   386: ldc_w 1261
    //   389: invokevirtual 1264	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   392: invokevirtual 1267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 11
    //   398: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifne +17 -> 418
    //   404: aload 18
    //   406: ldc_w 276
    //   409: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 11
    //   414: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: new 218	org/json/JSONObject
    //   421: dup
    //   422: aload 16
    //   424: invokespecial 221	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   427: astore 5
    //   429: aload 5
    //   431: ldc_w 1269
    //   434: invokevirtual 1145	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   437: pop
    //   438: aload 11
    //   440: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   443: ifne +14 -> 457
    //   446: aload 5
    //   448: ldc_w 1269
    //   451: aload 11
    //   453: invokevirtual 1272	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 5
    //   459: invokevirtual 577	org/json/JSONObject:toString	()Ljava/lang/String;
    //   462: astore 23
    //   464: lload 9
    //   466: aload 28
    //   468: ldc_w 278
    //   471: aload 18
    //   473: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: iconst_0
    //   477: aconst_null
    //   478: invokestatic 287	com/tencent/mobileqq/activity/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   481: ldc_w 1078
    //   484: astore 5
    //   486: ldc_w 1078
    //   489: astore 11
    //   491: ldc_w 1078
    //   494: astore 16
    //   496: aload 16
    //   498: astore 20
    //   500: aload 11
    //   502: astore 17
    //   504: aload 5
    //   506: astore 19
    //   508: aload 16
    //   510: astore 22
    //   512: aload 11
    //   514: astore 18
    //   516: aload 5
    //   518: astore 21
    //   520: aload 29
    //   522: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   525: ifne +778 -> 1303
    //   528: aload 16
    //   530: astore 20
    //   532: aload 11
    //   534: astore 17
    //   536: aload 5
    //   538: astore 19
    //   540: aload 29
    //   542: ldc_w 1274
    //   545: invokevirtual 1278	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   548: astore 30
    //   550: iconst_0
    //   551: istore 13
    //   553: aload 16
    //   555: astore 20
    //   557: aload 11
    //   559: astore 17
    //   561: aload 5
    //   563: astore 19
    //   565: aload 16
    //   567: astore 22
    //   569: aload 11
    //   571: astore 18
    //   573: aload 5
    //   575: astore 21
    //   577: iload 13
    //   579: aload 30
    //   581: arraylength
    //   582: if_icmpge +721 -> 1303
    //   585: aload 16
    //   587: astore 20
    //   589: aload 11
    //   591: astore 17
    //   593: aload 5
    //   595: astore 19
    //   597: aload 30
    //   599: iload 13
    //   601: aaload
    //   602: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   605: ifne +611 -> 1216
    //   608: aload 16
    //   610: astore 20
    //   612: aload 11
    //   614: astore 17
    //   616: aload 5
    //   618: astore 19
    //   620: aload 30
    //   622: iload 13
    //   624: aaload
    //   625: bipush 35
    //   627: invokevirtual 1281	java/lang/String:indexOf	(I)I
    //   630: istore 14
    //   632: iload 14
    //   634: iconst_m1
    //   635: if_icmpeq +581 -> 1216
    //   638: aload 16
    //   640: astore 20
    //   642: aload 11
    //   644: astore 17
    //   646: aload 5
    //   648: astore 19
    //   650: aload 30
    //   652: iload 13
    //   654: aaload
    //   655: iload 14
    //   657: iconst_1
    //   658: iadd
    //   659: invokevirtual 592	java/lang/String:substring	(I)Ljava/lang/String;
    //   662: astore 18
    //   664: aload 18
    //   666: astore 17
    //   668: iload 13
    //   670: ifne +591 -> 1261
    //   673: aload 11
    //   675: astore 5
    //   677: aload 17
    //   679: astore 11
    //   681: iload 13
    //   683: iconst_1
    //   684: iadd
    //   685: istore 13
    //   687: aload 11
    //   689: astore 17
    //   691: aload 5
    //   693: astore 11
    //   695: aload 17
    //   697: astore 5
    //   699: goto -146 -> 553
    //   702: astore 16
    //   704: aload 16
    //   706: invokevirtual 1282	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   709: aload 5
    //   711: astore 16
    //   713: goto -682 -> 31
    //   716: iconst_1
    //   717: istore 12
    //   719: goto -561 -> 158
    //   722: ldc_w 397
    //   725: astore 18
    //   727: goto -548 -> 179
    //   730: astore 18
    //   732: aload 18
    //   734: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   737: iconst_0
    //   738: istore 15
    //   740: goto -443 -> 297
    //   743: astore 5
    //   745: new 218	org/json/JSONObject
    //   748: dup
    //   749: invokespecial 561	org/json/JSONObject:<init>	()V
    //   752: astore 5
    //   754: aload 11
    //   756: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   759: ifne +14 -> 773
    //   762: aload 5
    //   764: ldc_w 1269
    //   767: aload 11
    //   769: invokevirtual 1272	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   772: pop
    //   773: aload 5
    //   775: invokevirtual 577	org/json/JSONObject:toString	()Ljava/lang/String;
    //   778: astore 23
    //   780: goto -316 -> 464
    //   783: new 215	android/os/Bundle
    //   786: dup
    //   787: invokespecial 216	android/os/Bundle:<init>	()V
    //   790: astore 16
    //   792: aload 16
    //   794: ldc_w 320
    //   797: aload_3
    //   798: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: aload 16
    //   803: ldc_w 677
    //   806: aload 28
    //   808: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   811: aload 16
    //   813: ldc 229
    //   815: aload 26
    //   817: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: aload 16
    //   822: ldc_w 1284
    //   825: aload 27
    //   827: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 16
    //   832: ldc_w 256
    //   835: iload 12
    //   837: invokevirtual 345	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   840: aload 16
    //   842: ldc_w 1108
    //   845: aload 29
    //   847: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   850: aload 16
    //   852: ldc_w 635
    //   855: aload 23
    //   857: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: aload 16
    //   862: ldc_w 1261
    //   865: aload 25
    //   867: ldc_w 1261
    //   870: invokevirtual 1264	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   873: invokevirtual 301	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   876: aload 16
    //   878: ldc_w 347
    //   881: bipush 9
    //   883: invokevirtual 345	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   886: aload 16
    //   888: ldc_w 349
    //   891: iload 6
    //   893: invokevirtual 345	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   896: aload 16
    //   898: ldc_w 351
    //   901: lload 7
    //   903: invokevirtual 355	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   906: aload 16
    //   908: ldc_w 357
    //   911: lload 9
    //   913: invokevirtual 355	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   916: aload 16
    //   918: ldc_w 1204
    //   921: iload 15
    //   923: invokevirtual 301	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   926: iload 15
    //   928: ifeq +13 -> 941
    //   931: aload 16
    //   933: ldc_w 1286
    //   936: aload 4
    //   938: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: aload_2
    //   942: aload 16
    //   944: invokestatic 361	cooperation/qwallet/plugin/pay/PayLogic:setIPCReceiver	(Landroid/os/ResultReceiver;Landroid/os/Bundle;)V
    //   947: lload 9
    //   949: aconst_null
    //   950: ldc_w 363
    //   953: aconst_null
    //   954: iconst_0
    //   955: aconst_null
    //   956: invokestatic 287	com/tencent/mobileqq/activity/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   959: invokestatic 368	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   962: ifeq +32 -> 994
    //   965: ldc_w 370
    //   968: iconst_4
    //   969: new 262	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   976: ldc_w 372
    //   979: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   985: invokevirtual 381	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   988: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 385	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: aload_1
    //   995: aload_0
    //   996: aload 16
    //   998: invokestatic 391	cooperation/qwallet/plugin/QWalletPayBridge:launchForeground	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Landroid/os/Bundle;)Z
    //   1001: pop
    //   1002: aload 24
    //   1004: ldc_w 393
    //   1007: iconst_0
    //   1008: invokevirtual 345	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1011: aload 24
    //   1013: ldc_w 810
    //   1016: aload 28
    //   1018: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1021: aload 24
    //   1023: ldc_w 814
    //   1026: aload 5
    //   1028: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1031: aload 24
    //   1033: ldc_w 818
    //   1036: aload 17
    //   1038: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1041: aload 24
    //   1043: ldc_w 822
    //   1046: aload 11
    //   1048: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1051: aload 24
    //   1053: areturn
    //   1054: astore 5
    //   1056: aload 20
    //   1058: astore 11
    //   1060: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1063: ifeq +8 -> 1071
    //   1066: aload 5
    //   1068: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   1071: aload 19
    //   1073: astore 5
    //   1075: goto -292 -> 783
    //   1078: astore_0
    //   1079: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1082: ifeq +32 -> 1114
    //   1085: ldc 14
    //   1087: iconst_2
    //   1088: new 262	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   1095: ldc_w 1288
    //   1098: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: aload_0
    //   1102: invokevirtual 405	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1105: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1114: invokestatic 368	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1117: ifeq +7 -> 1124
    //   1120: aload_0
    //   1121: invokevirtual 411	org/json/JSONException:printStackTrace	()V
    //   1124: aload 24
    //   1126: ldc_w 393
    //   1129: iconst_m1
    //   1130: invokevirtual 345	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1133: aload 24
    //   1135: ldc_w 413
    //   1138: ldc_w 1290
    //   1141: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1144: aload 24
    //   1146: areturn
    //   1147: astore_0
    //   1148: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1151: ifeq +32 -> 1183
    //   1154: ldc 14
    //   1156: iconst_2
    //   1157: new 262	java/lang/StringBuilder
    //   1160: dup
    //   1161: invokespecial 263	java/lang/StringBuilder:<init>	()V
    //   1164: ldc_w 1292
    //   1167: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: aload_0
    //   1171: invokevirtual 418	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1174: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1180: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1183: invokestatic 368	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1186: ifeq +7 -> 1193
    //   1189: aload_0
    //   1190: invokevirtual 419	java/lang/Exception:printStackTrace	()V
    //   1193: aload 24
    //   1195: ldc_w 393
    //   1198: iconst_m1
    //   1199: invokevirtual 345	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1202: aload 24
    //   1204: ldc_w 413
    //   1207: ldc_w 1294
    //   1210: invokevirtual 291	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1213: aload 24
    //   1215: areturn
    //   1216: aload 5
    //   1218: astore 17
    //   1220: aload 11
    //   1222: astore 5
    //   1224: aload 17
    //   1226: astore 11
    //   1228: goto -547 -> 681
    //   1231: ldc_w 397
    //   1234: astore 5
    //   1236: goto -1036 -> 200
    //   1239: ldc_w 397
    //   1242: astore 17
    //   1244: goto -1023 -> 221
    //   1247: ldc_w 397
    //   1250: astore 16
    //   1252: goto -1001 -> 251
    //   1255: iconst_0
    //   1256: istore 15
    //   1258: goto -961 -> 297
    //   1261: iload 13
    //   1263: iconst_1
    //   1264: if_icmpne +22 -> 1286
    //   1267: aload 17
    //   1269: astore 16
    //   1271: aload 5
    //   1273: astore 17
    //   1275: aload 11
    //   1277: astore 5
    //   1279: aload 17
    //   1281: astore 11
    //   1283: goto -602 -> 681
    //   1286: iload 13
    //   1288: iconst_2
    //   1289: if_icmpne -73 -> 1216
    //   1292: aload 5
    //   1294: astore 11
    //   1296: aload 17
    //   1298: astore 5
    //   1300: goto -619 -> 681
    //   1303: aload 22
    //   1305: astore 11
    //   1307: aload 21
    //   1309: astore 5
    //   1311: aload 18
    //   1313: astore 17
    //   1315: goto -532 -> 783
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1318	0	paramAppInterface	AppInterface
    //   0	1318	1	paramActivity	Activity
    //   0	1318	2	paramResultReceiver	ResultReceiver
    //   0	1318	3	paramString1	String
    //   0	1318	4	paramString2	String
    //   0	1318	5	paramString3	String
    //   0	1318	6	paramInt	int
    //   0	1318	7	paramLong1	long
    //   0	1318	9	paramLong2	long
    //   0	1318	11	paramString4	String
    //   156	680	12	i	int
    //   551	739	13	j	int
    //   630	29	14	k	int
    //   287	970	15	bool	boolean
    //   11	628	16	str1	String
    //   702	3	16	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   711	559	16	localObject1	Object
    //   219	1095	17	localObject2	Object
    //   177	549	18	localObject3	Object
    //   730	582	18	localException	Exception
    //   506	566	19	str2	String
    //   498	559	20	str3	String
    //   518	790	21	str4	String
    //   510	794	22	str5	String
    //   462	394	23	str6	String
    //   7	1207	24	localBundle	Bundle
    //   86	780	25	localJSONObject	JSONObject
    //   92	724	26	str7	String
    //   125	701	27	str8	String
    //   135	882	28	str9	String
    //   228	618	29	str10	String
    //   548	103	30	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   21	31	702	java/io/UnsupportedEncodingException
    //   257	279	730	java/lang/Exception
    //   279	289	730	java/lang/Exception
    //   418	457	743	java/lang/Exception
    //   457	464	743	java/lang/Exception
    //   520	528	1054	java/lang/Exception
    //   540	550	1054	java/lang/Exception
    //   577	585	1054	java/lang/Exception
    //   597	608	1054	java/lang/Exception
    //   620	632	1054	java/lang/Exception
    //   650	664	1054	java/lang/Exception
    //   77	158	1078	org/json/JSONException
    //   158	179	1078	org/json/JSONException
    //   179	200	1078	org/json/JSONException
    //   200	221	1078	org/json/JSONException
    //   221	251	1078	org/json/JSONException
    //   257	279	1078	org/json/JSONException
    //   279	289	1078	org/json/JSONException
    //   297	418	1078	org/json/JSONException
    //   418	457	1078	org/json/JSONException
    //   457	464	1078	org/json/JSONException
    //   464	481	1078	org/json/JSONException
    //   520	528	1078	org/json/JSONException
    //   540	550	1078	org/json/JSONException
    //   577	585	1078	org/json/JSONException
    //   597	608	1078	org/json/JSONException
    //   620	632	1078	org/json/JSONException
    //   650	664	1078	org/json/JSONException
    //   732	737	1078	org/json/JSONException
    //   745	773	1078	org/json/JSONException
    //   773	780	1078	org/json/JSONException
    //   783	926	1078	org/json/JSONException
    //   931	941	1078	org/json/JSONException
    //   941	994	1078	org/json/JSONException
    //   994	1051	1078	org/json/JSONException
    //   1060	1071	1078	org/json/JSONException
    //   77	158	1147	java/lang/Exception
    //   158	179	1147	java/lang/Exception
    //   179	200	1147	java/lang/Exception
    //   200	221	1147	java/lang/Exception
    //   221	251	1147	java/lang/Exception
    //   297	418	1147	java/lang/Exception
    //   464	481	1147	java/lang/Exception
    //   732	737	1147	java/lang/Exception
    //   745	773	1147	java/lang/Exception
    //   773	780	1147	java/lang/Exception
    //   783	926	1147	java/lang/Exception
    //   931	941	1147	java/lang/Exception
    //   941	994	1147	java/lang/Exception
    //   994	1051	1147	java/lang/Exception
    //   1060	1071	1147	java/lang/Exception
  }
  
  private void putProxyReceiverToBundle(Bundle paramBundle)
  {
    setIPCReceiver(new PayLogic.CompactReceiver(ThreadManager.getUIHandlerV2(), this), paramBundle);
  }
  
  protected static Bundle rechargeGameCurrency(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        String str9 = localJSONObject.getString("offerId");
        String str10 = localJSONObject.getString("userId");
        if (localJSONObject.has("zoneId"))
        {
          str1 = localJSONObject.getString("zoneId");
          if (!localJSONObject.has("acctType")) {
            break label863;
          }
          str2 = localJSONObject.getString("acctType");
          if (!localJSONObject.has("numberVisible")) {
            break label871;
          }
          bool1 = localJSONObject.getBoolean("numberVisible");
          if (!localJSONObject.has("saveValue")) {
            break label877;
          }
          str3 = localJSONObject.getString("saveValue");
          if (!localJSONObject.has("isCanChange")) {
            break label883;
          }
          bool2 = localJSONObject.getBoolean("isCanChange");
          if (!localJSONObject.has("aid")) {
            break label889;
          }
          str4 = localJSONObject.getString("aid");
          if (!localJSONObject.has("discountId")) {
            break label897;
          }
          str5 = localJSONObject.getString("discountId");
          if (!localJSONObject.has("other")) {
            break label905;
          }
          str6 = localJSONObject.getString("other");
          if (!localJSONObject.has("payload")) {
            break label913;
          }
          str7 = localJSONObject.getString("payload");
          if (!localJSONObject.has("drmInfo")) {
            break label921;
          }
          str8 = localJSONObject.getString("drmInfo");
          if (!localJSONObject.has("comeForm")) {
            break label929;
          }
          i = localJSONObject.getInt("comeForm");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("json=").append(paramString2);
          if (!TextUtils.isEmpty(paramString3)) {
            localStringBuilder.append("&url=").append(paramString3);
          }
          VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
          paramString3 = new Bundle();
          paramString3.putString("offerId", str9);
          if (isEnterMidasTestEnv(localJSONObject))
          {
            paramString2 = "test";
            paramString3.putString("setEnv", paramString2);
            paramString3.putBoolean("setLogEnable", true);
            paramString3.putBoolean("isShowNum", Boolean.valueOf(bool1).booleanValue());
            paramString3.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.a() + "-" + str4;
            paramString3.putString("userId", str10);
            paramString3.putString("sessionId", "uin");
            paramString3.putString("zoneId", str1);
            paramString3.putString("pf", paramString1);
            paramString3.putString("pfKey", "pfKey");
            paramString3.putString("acctType", str2);
            paramString3.putString("discountId", str5);
            paramString3.putString("other", str6);
            paramString3.putString("payload", str7);
            paramString3.putString("drmInfo", str8);
            if ((str3 != null) && (str3.length() > 0))
            {
              paramString3.putString("saveValue", str3);
              paramString3.putBoolean("isCanChange", Boolean.valueOf(bool2).booleanValue());
            }
            paramString3.putInt("resId", 0);
            paramString3.putInt("PayInvokerId", 6);
            paramString3.putInt("payparmas_paytype", paramInt);
            paramString3.putLong("payparmas_h5_start", paramLong1);
            paramString3.putLong("vacreport_key_seq", paramLong2);
            paramString3.putInt("comeForm", i);
            setIPCReceiver(paramResultReceiver, paramString3);
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchForeground(paramActivity, paramAppInterface, paramString3);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str9);
            localBundle.putString("aid", str4);
            return localBundle;
          }
          paramString2 = "release";
          continue;
        }
        String str1 = "1";
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "rechargeCurrency JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "rechargeCurrency Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}");
        return localBundle;
      }
      continue;
      label863:
      String str2 = "common";
      continue;
      label871:
      boolean bool1 = true;
      continue;
      label877:
      String str3 = null;
      continue;
      label883:
      boolean bool2 = true;
      continue;
      label889:
      String str4 = "";
      continue;
      label897:
      String str5 = "";
      continue;
      label905:
      String str6 = "";
      continue;
      label913:
      String str7 = "";
      continue;
      label921:
      String str8 = "";
      continue;
      label929:
      int i = 1;
    }
  }
  
  protected static Bundle rechargeQb(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str9 = ((JSONObject)localObject).getString("offerId");
        String str10 = ((JSONObject)localObject).getString("userId");
        if (((JSONObject)localObject).has("channel"))
        {
          str1 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("unit")) {
            break label784;
          }
          str2 = ((JSONObject)localObject).getString("unit");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label790;
          }
          str3 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("aid")) {
            break label796;
          }
          str4 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("provideUin")) {
            break label804;
          }
          str5 = ((JSONObject)localObject).getString("provideUin");
          if (!((JSONObject)localObject).has("provideType")) {
            break label810;
          }
          str6 = ((JSONObject)localObject).getString("provideType");
          if (!((JSONObject)localObject).has("discountId")) {
            break label816;
          }
          str7 = ((JSONObject)localObject).getString("discountId");
          if (!((JSONObject)localObject).has("other")) {
            break label824;
          }
          str8 = ((JSONObject)localObject).getString("other");
          if (((JSONObject)localObject).has("payload"))
          {
            localObject = ((JSONObject)localObject).getString("payload");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramString2);
            if (!TextUtils.isEmpty(paramString3)) {
              localStringBuilder.append("&url=").append(paramString3);
            }
            VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
            paramString2 = new Bundle();
            paramString2.putString("offerId", str9);
            paramString2.putString("setEnv", "release");
            paramString2.putBoolean("setLogEnable", true);
            if ((str2 != null) && (str2.length() > 0)) {
              paramString2.putString("unit", str2);
            }
            if ((str1 != null) && (str1.length() > 0)) {
              paramString2.putString("payChannel", str1);
            }
            paramString2.putString("callbackSn", paramString1);
            paramString1 = "qq_m_qq-2013-android-" + AppSetting.a() + "-" + str4;
            paramString2.putString("userId", str10);
            paramString2.putString("sessionId", "uin");
            paramString2.putString("pf", paramString1);
            paramString2.putString("pfKey", "pfKey");
            paramString2.putString("saveValue", str3);
            paramString2.putString("provideUin", str5);
            paramString2.putString("provideType", str6);
            paramString2.putString("discountId", str7);
            paramString2.putString("other", str8);
            paramString2.putString("payload", (String)localObject);
            paramString2.putInt("PayInvokerId", 8);
            paramString2.putInt("payparmas_paytype", paramInt);
            paramString2.putLong("payparmas_h5_start", paramLong1);
            paramString2.putLong("vacreport_key_seq", paramLong2);
            setIPCReceiver(paramResultReceiver, paramString2);
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchForeground(paramActivity, paramAppInterface, paramString2);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str9);
            localBundle.putString("aid", str4);
            return localBundle;
          }
          localObject = "";
          continue;
        }
        String str1 = null;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "rechargeQb JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "rechargeQb Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}");
        return localBundle;
      }
      continue;
      label784:
      String str2 = null;
      continue;
      label790:
      String str3 = null;
      continue;
      label796:
      String str4 = "";
      continue;
      label804:
      String str5 = null;
      continue;
      label810:
      String str6 = null;
      continue;
      label816:
      String str7 = "";
      continue;
      label824:
      String str8 = "";
    }
  }
  
  private static void remove(PayLogic paramPayLogic)
  {
    if (paramPayLogic != null) {
      sPayLogics.remove(paramPayLogic.getTag());
    }
  }
  
  private void saveNonePCPayResultData(int paramInt, Intent paramIntent)
  {
    if ((!this.isFromPCPush) && (this.saveResultData == null))
    {
      this.saveResultData = paramIntent;
      this.saveResultCode = paramInt;
    }
  }
  
  private void setActivityRef(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity != null) {
      this.mActivity = paramBaseActivity;
    }
  }
  
  public static void setIPCReceiver(ResultReceiver paramResultReceiver, Bundle paramBundle)
  {
    if ((paramResultReceiver != null) && (paramBundle != null))
    {
      Parcel localParcel = Parcel.obtain();
      paramResultReceiver.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
      localParcel.recycle();
      paramBundle.putParcelable("_qwallet_payresult_receiver", paramResultReceiver);
    }
  }
  
  public static void setIsPaying(boolean paramBoolean)
  {
    isPaying = paramBoolean;
  }
  
  protected static Bundle subscribeMonthCardPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString2);
        String str11 = ((JSONObject)localObject).getString("offerId");
        if (((JSONObject)localObject).has("isShowNum"))
        {
          bool1 = ((JSONObject)localObject).getBoolean("isShowNum");
          if (!((JSONObject)localObject).has("unit")) {
            break label1000;
          }
          str1 = ((JSONObject)localObject).getString("unit");
          String str12 = ((JSONObject)localObject).getString("userId");
          String str13 = ((JSONObject)localObject).getString("serviceCode");
          String str14 = ((JSONObject)localObject).getString("serviceName");
          if (!((JSONObject)localObject).has("channel")) {
            break label1006;
          }
          str2 = ((JSONObject)localObject).getString("channel");
          if (!((JSONObject)localObject).has("saveValue")) {
            break label1012;
          }
          str3 = ((JSONObject)localObject).getString("saveValue");
          if (!((JSONObject)localObject).has("isCanChange")) {
            break label1018;
          }
          bool2 = ((JSONObject)localObject).getBoolean("isCanChange");
          if (!((JSONObject)localObject).has("remark")) {
            break label1024;
          }
          str4 = ((JSONObject)localObject).getString("remark");
          if (!((JSONObject)localObject).has("autoPay")) {
            break label1032;
          }
          bool3 = ((JSONObject)localObject).getBoolean("autoPay");
          if (!((JSONObject)localObject).has("aid")) {
            break label1038;
          }
          str5 = ((JSONObject)localObject).getString("aid");
          if (!((JSONObject)localObject).has("productId")) {
            break label1046;
          }
          str6 = ((JSONObject)localObject).getString("productId");
          if (!((JSONObject)localObject).has("couponId")) {
            break label1054;
          }
          str7 = ((JSONObject)localObject).getString("couponId");
          if (!((JSONObject)localObject).has("other")) {
            break label1062;
          }
          str8 = ((JSONObject)localObject).getString("other");
          if (!((JSONObject)localObject).has("payload")) {
            break label1070;
          }
          str9 = ((JSONObject)localObject).getString("payload");
          if (!((JSONObject)localObject).has("drmInfo")) {
            break label1078;
          }
          str10 = ((JSONObject)localObject).getString("drmInfo");
          if (((JSONObject)localObject).has("pf"))
          {
            localObject = ((JSONObject)localObject).getString("pf");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("json=").append(paramString2);
            if (!TextUtils.isEmpty(paramString3)) {
              localStringBuilder.append("&url=").append(paramString3);
            }
            VACDReportUtil.a(paramLong2, null, "parseurl", localStringBuilder.toString(), 0, null);
            paramString2 = new Bundle();
            paramString2.putString("setEnv", "release");
            paramString2.putBoolean("setLogEnable", false);
            paramString2.putString("offerId", str11);
            paramString2.putBoolean("isShowNum", bool1);
            if ((str1 != null) && (str1.length() > 0)) {
              paramString2.putString("unit", str1);
            }
            if ((str2 != null) && (str2.length() > 0)) {
              paramString2.putString("payChannel", str2);
            }
            paramString2.putString("callbackSn", paramString1);
            paramString2.putString("userId", str12);
            paramString2.putString("sessionId", "uin");
            paramString2.putString("pf", (String)localObject);
            paramString2.putString("pfKey", "pfKey");
            if ((str3 != null) && (str3.length() > 0))
            {
              paramString2.putString("saveValue", str3);
              paramString2.putBoolean("isCanChange", Boolean.valueOf(bool2).booleanValue());
            }
            paramString2.putInt("resId", 0);
            paramString2.putString("serviceCode", str13);
            paramString2.putString("serviceName", str14);
            paramString2.putString("remark", str4);
            paramString2.putBoolean("autoPay", Boolean.valueOf(bool3).booleanValue());
            paramString2.putString("productId", str6);
            paramString2.putString("couponId", str7);
            paramString2.putString("other", str8);
            paramString2.putString("payload", str9);
            paramString2.putString("drmInfo", str10);
            paramString2.putInt("PayInvokerId", 14);
            paramString2.putInt("payparmas_paytype", paramInt);
            paramString2.putLong("payparmas_h5_start", paramLong1);
            paramString2.putLong("vacreport_key_seq", paramLong2);
            setIPCReceiver(paramResultReceiver, paramString2);
            VACDReportUtil.a(paramLong2, null, "loadPluginStart", null, 0, null);
            if (QLog.isDevelopLevel()) {
              QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
            }
            QWalletPayBridge.launchForeground(paramActivity, paramAppInterface, paramString2);
            localBundle.putInt("retCode", 0);
            localBundle.putString("offerId", str11);
            localBundle.putString("aid", str5);
            return localBundle;
          }
          localObject = "qq_m_qq-2013-android-" + AppSetting.a() + "-" + str5;
          continue;
        }
        boolean bool1 = true;
      }
      catch (JSONException paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "subscribeMonthCardPay JSONException:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay JSONException'}");
        return localBundle;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "subscribeMonthCardPay Exception:" + paramAppInterface.getMessage());
        }
        if (QLog.isDevelopLevel()) {
          paramAppInterface.printStackTrace();
        }
        localBundle.putInt("retCode", -1);
        localBundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay Exception'}");
        return localBundle;
      }
      continue;
      label1000:
      String str1 = null;
      continue;
      label1006:
      String str2 = null;
      continue;
      label1012:
      String str3 = null;
      continue;
      label1018:
      boolean bool2 = false;
      continue;
      label1024:
      String str4 = "";
      continue;
      label1032:
      boolean bool3 = true;
      continue;
      label1038:
      String str5 = "";
      continue;
      label1046:
      String str6 = "";
      continue;
      label1054:
      String str7 = "";
      continue;
      label1062:
      String str8 = "";
      continue;
      label1070:
      String str9 = "";
      continue;
      label1078:
      String str10 = "";
    }
  }
  
  private void tenpayResult(Bundle paramBundle)
  {
    String str2 = null;
    String str1;
    if (paramBundle != null)
    {
      if (this.mIsStartReport)
      {
        int i = paramBundle.getInt("payRetCode", -1);
        long l = paramBundle.getLong("reportSeq", 0L);
        if ((this.mIsStartReport) && (l > 0L)) {
          VACDReportUtil.endReport(l, "payEnd", null, i, null);
        }
      }
      str1 = paramBundle.getString("callbackSn");
      str2 = paramBundle.getString("result");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay.PayLogic", 2, "get callbackSn = " + str1);
      }
      String str3 = str1;
      if (this.intentData != null)
      {
        str3 = str1;
        if (TextUtils.isEmpty(str1)) {
          str3 = this.intentData.getString("callbackSn");
        }
      }
      if (this.mResultReceiver != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.pay.PayLogic", 2, "receiver back : " + paramBundle);
        }
        this.mResultReceiver.send(0, paramBundle);
      }
      paramBundle = new Intent();
      paramBundle.putExtra("result", str2);
      paramBundle.putExtra("callbackSn", str3);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay.PayLogic", 2, "PayBridgeActivity tenpayResult:callbackSn=" + str3 + ",result=" + str2);
      }
      this.mActivity.setResult(-1, paramBundle);
      saveNonePCPayResultData(-1, paramBundle);
      end();
      return;
      str1 = null;
    }
  }
  
  private void tenpayResult(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackSn", paramString1);
    localBundle.putString("result", paramString2);
    tenpayResult(localBundle);
  }
  
  protected String convertToReportAction(int paramInt)
  {
    if (this.isFromPCPush)
    {
      if (paramInt == 4) {
        return "openService-push";
      }
      if (paramInt == 6) {
        return "rechargeGameCurrency-push";
      }
      if (paramInt == 7) {
        return "buyGoods-push";
      }
      if (paramInt == 8) {
        return "rechargeQb-push";
      }
      if (paramInt == 9) {
        return "pay-push";
      }
      if (paramInt == 14) {
        return "monthCardPay-push";
      }
      if (paramInt == 11) {
        return "openSVip-push";
      }
    }
    else
    {
      if (paramInt == 4) {
        return "openService-nt";
      }
      if (paramInt == 6) {
        return "rechargeGameCurrency-nt";
      }
      if (paramInt == 7) {
        return "buyGoods-nt";
      }
      if (paramInt == 8) {
        return "rechargeQb-nt";
      }
      if (paramInt == 9) {
        return "pay-native";
      }
      if (paramInt == 14) {
        return "monthCardPay-nt";
      }
      if (paramInt == 11) {
        return "openSVip-nt";
      }
    }
    return null;
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "doOnRestoreInstanceState savedInstanceState=" + paramBundle);
    }
    if (paramBundle == null) {
      return;
    }
    this.mPayType = paramBundle.getInt("mPayType", -1);
    this.mPayTokenId = paramBundle.getString("mPayTokenId");
    this.mPayAppId = paramBundle.getString("mPayAppId");
    this.mPayChannel = paramBundle.getString("mPayChannel");
    this.mPayBargainorId = paramBundle.getString("mPayBargainorId");
    this.mMidasOfferid = paramBundle.getString("mMidasOfferid");
    this.mMidasAid = paramBundle.getString("mMidasAid");
    this.mMidasOrderId = paramBundle.getString("mMidasOrderId");
    this.mOpenViewTag = paramBundle.getString("mOpenViewTag");
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "doOnSaveInstanceState outState=" + paramBundle);
    }
    if (paramBundle == null) {
      return;
    }
    paramBundle.putInt("mPayType", this.mPayType);
    paramBundle.putString("mPayTokenId", this.mPayTokenId);
    paramBundle.putString("mPayAppId", this.mPayAppId);
    paramBundle.putString("mPayChannel", this.mPayChannel);
    paramBundle.putString("mPayBargainorId", this.mPayBargainorId);
    paramBundle.putString("mMidasOfferid", this.mMidasOfferid);
    paramBundle.putString("mMidasAid", this.mMidasAid);
    paramBundle.putString("mMidasOrderId", this.mMidasOrderId);
    paramBundle.putString("mOpenViewTag", this.mOpenViewTag);
  }
  
  public void end()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "end()");
    }
    agxa.a();
    int i = agxa.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "finish idlePayCount=" + i);
    }
    Object localObject1 = this.mActivity;
    if ((i <= 0) || (localObject1 == null))
    {
      tryNonPCPay();
      setIsPaying(false);
      onEndFinished();
      return;
    }
    Object localObject2 = new Intent((Context)localObject1, PayBridgeActivity.class);
    ((Intent)localObject2).addFlags(536870912);
    ((BaseActivity)localObject1).startActivity((Intent)localObject2);
    localObject2 = String.format(((BaseActivity)localObject1).getString(2131717388), new Object[] { Integer.valueOf(i) });
    localObject1 = createCustomDialog(((BaseActivity)localObject1).getString(2131699428), (String)localObject2, null);
    ((Dialog)localObject1).setCancelable(false);
    localObject2 = new PayLogic.3(this, (Dialog)localObject1);
    ((Dialog)localObject1).findViewById(2131365142).setOnClickListener((View.OnClickListener)localObject2);
    ((Dialog)localObject1).findViewById(2131365136).setOnClickListener((View.OnClickListener)localObject2);
    ((Dialog)localObject1).setOnDismissListener(new PayLogic.4(this));
    try
    {
      ((Dialog)localObject1).show();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Q.qwallet.pay.PayLogic", 2, localThrowable.getStackTrace());
    }
  }
  
  public void exec()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "exec()");
    }
    Object localObject = this.mActivity;
    if (this.mRequestCode == 12)
    {
      if (GesturePWDUtils.getJumpLock((Context)localObject, this.app.getCurrentAccountUin()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.push", 2, "moveTaskToBack and startUnlockActivity...");
        }
        ((BaseActivity)localObject).startUnlockActivity();
        onEndFinished();
        return;
      }
      if (isPaying)
      {
        onEndFinished();
        return;
      }
      isPaying = true;
      this.isFromPCPush = true;
      this.isPCPushDesc = true;
      startPCPushPay(agxa.a(this.isPCPushDesc));
      return;
    }
    isPaying = true;
    switch (this.mRequestCode)
    {
    default: 
      end();
      return;
    case 1: 
      localObject = anqq.a(this.intentData);
      if ((localObject == null) || (!checkEmojiPayParam((anqq)localObject)))
      {
        OnEmojimallPayResult((anqq)localObject, -1, 0, -1, -1, -1, "param error");
        if (localObject == null) {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.pay.PayLogic", 2, "emojimall pay paramerror: reqData:null");
          }
        }
        for (;;)
        {
          isPaying = false;
          end();
          return;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.pay.PayLogic", 2, "emojimall pay paramerror:userid:" + ((anqq)localObject).c + "userkey:" + ((anqq)localObject).d + "sessionid:" + ((anqq)localObject).e + "sessionType:" + ((anqq)localObject).f + "zoneId:" + ((anqq)localObject).g + "pf:" + ((anqq)localObject).h + "pfKey:" + ((anqq)localObject).i + "tokenUrl:" + ((anqq)localObject).j + "discountId:" + ((anqq)localObject).k + "other:" + ((anqq)localObject).l + "payload:" + ((anqq)localObject).m);
          }
        }
      }
      doEmojimallPay((anqq)localObject);
      return;
    case 2: 
      doGoldCharge(this.intentData);
      return;
    case 3: 
      doOpenQQReaderVip(this.intentData);
      return;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 14: 
      newPay(this.mRequestCode, this.intentData);
      return;
    case 5: 
      openTenpayView(this.intentData);
      return;
    case 10: 
      openQzoneVipService(this.intentData);
      return;
    case 11: 
      openSVip(this.intentData);
      return;
    case 13: 
      Bundle localBundle = new Bundle();
      localBundle.putInt("PayInvokerId", 12);
      putProxyReceiverToBundle(localBundle);
      QWalletPayBridge.launchForeground((Activity)localObject, this.app, localBundle);
      return;
    case 200: 
      onF2FRedpackCheckError();
      return;
    }
    onQWalletCrash();
  }
  
  public int getTag()
  {
    return hashCode();
  }
  
  public boolean init()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayLogic", 2, "init()");
    }
    if ((this.intent == null) || (this.intent.getExtras() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay.PayLogic", 2, "init extras is null");
      }
      return false;
    }
    this.intentData = this.intent.getExtras();
    this.mResultReceiver = ((ResultReceiver)this.intentData.getParcelable("receiver"));
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.pay.PayLogic", 2, "specified receiver = " + this.mResultReceiver);
    }
    this.mRequestCode = this.intentData.getInt("pay_requestcode", -1);
    this.mPayType = this.intentData.getInt("payparmas_paytype", -1);
    this.isLockWithdraw = isLockWithdraw(this.mPayType, this.intentData);
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.pay.PayLogic", 2, "isLockWithdraw = " + this.isLockWithdraw);
    }
    if (!isLoginParamsValid())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay.PayLogic", 2, "PayBridgeActivity.doOnCreate login params error");
      }
      return false;
    }
    QQNotificationManager.getInstance().cancel("Q.qwallet.pay.PayLogic", 238);
    this.isFromPCPush = this.intentData.getBoolean("payparmas_from_pcpush", false);
    this.mPayH5StartTime = this.intentData.getLong("payparmas_h5_start", 0L);
    this.mReportSeq = this.intentData.getLong("vacreport_key_seq", 0L);
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.PayLogic", 1, "PayBridgeActivity onActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (this.mActivity == null)
    {
      this.mOnActivityResult = new PayLogic.OnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (((paramIntent != null) && (paramInt1 == 3001)) || (paramInt2 == -1))
    {
      paramInt1 = i;
      if (paramIntent != null) {
        paramInt1 = paramIntent.getIntExtra("PayInvokerId", -1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay.PayLogic", 2, "" + System.currentTimeMillis() + " nInvokerId = " + paramInt1);
      }
      switch (paramInt1)
      {
      case 13: 
      case 15: 
      case 16: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("Q.qwallet.pay.PayLogic", 2, "QvipPayBridge Unknown InvokerId : " + paramInt1);
        }
        end();
        return;
      case 4: 
      case 6: 
      case 7: 
      case 8: 
      case 11: 
      case 14: 
      case 17: 
        onMidasPayResult(paramIntent);
        return;
      case 1: 
        onEmojimallPayResult(paramIntent);
        return;
      case 2: 
        onGoldChargeResult(paramIntent);
        return;
      case 3: 
        onOpenQQReaderVipResult(paramIntent);
        return;
      case 10: 
        onOpenQzoneVipResult(paramIntent);
        return;
      case 5: 
        onOpenTenpayViewResult(paramIntent);
        return;
      case 9: 
        onPayResult(paramIntent);
        return;
      }
      onCheckWebankResult(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qwallet.pay.PayLogic", 2, "QvipPayBridge Unknown data");
    }
    end();
  }
  
  @Deprecated
  public void onDestroy()
  {
    setIsPaying(false);
    this.mActivity = null;
  }
  
  public void onEndFinished()
  {
    this.mActivity.finish();
    remove(this);
  }
  
  public void startPCPushPay(agxb paramagxb)
  {
    if (paramagxb == null)
    {
      end();
      return;
    }
    paramagxb.c = 1;
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramagxb.a);
    localBundle.putString("callbackSn", "0");
    int i = agxa.a(paramagxb.b);
    switch (i)
    {
    case 10: 
    case 12: 
    case 13: 
    default: 
      end();
      return;
    case 4: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 14: 
      newPay(i, localBundle);
      return;
    case 11: 
      openSVip(localBundle);
      return;
    }
    localBundle = this.intent.getExtras();
    localBundle.putString("json", paramagxb.a);
    localBundle.putString("callbackSn", "0");
    openTenpayView(localBundle);
  }
  
  public boolean tryDoOnActivityResult(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity != null) && (this.mOnActivityResult != null))
    {
      setActivityRef(paramBaseActivity);
      onActivityResult(this.mOnActivityResult.requestCode, this.mOnActivityResult.resultCode, this.mOnActivityResult.data);
      return true;
    }
    return false;
  }
  
  public void tryNonPCPay()
  {
    if ((!this.isFromPCPush) && (this.saveResultData != null)) {
      this.mActivity.setResult(this.saveResultCode, this.saveResultData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.pay.PayLogic
 * JD-Core Version:    0.7.0.1
 */