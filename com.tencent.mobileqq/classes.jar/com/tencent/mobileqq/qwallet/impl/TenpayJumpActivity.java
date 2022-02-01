package com.tencent.mobileqq.qwallet.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="QQ支付-支付中转页", path="/qwallet/tenpay/jump")
public class TenpayJumpActivity
  extends QBaseActivity
{
  private static final int REQUEST_CODE_OPEN_TRANS = 1;
  public static final String TENPAY_SCHEME = "tenpay";
  private String callbackSn;
  private String mAppInfo;
  private String mCodeNick;
  private String mCodeUin;
  private int mComeFrom;
  private Context mContext;
  private String mQqSkey;
  private String mQqSkeyType;
  private String mSource;
  private String mUin;
  private String mUrl;
  private String mUserNick;
  
  private void openTenpayView(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userId", this.mUin);
      localJSONObject.put("viewTag", paramString1);
      localJSONObject.put("comeForm", this.mComeFrom);
      localJSONObject.put("appInfo", this.mAppInfo);
      localJSONObject.put("extra_data", paramString2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 5, "0");
      return;
    }
    catch (Exception paramString1)
    {
      sendCallback(-1, null);
      paramString1.printStackTrace();
      return;
    }
    catch (JSONException paramString1)
    {
      sendCallback(-1, null);
      paramString1.printStackTrace();
    }
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
    paramString5.append(6);
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
    paramString5.append(paramInt2);
    paramString5.append(".");
    if (!TextUtils.isEmpty(this.mAppInfo)) {
      paramString5.append(this.mAppInfo.replace("|", ","));
    }
    paramString5.append("|");
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToPCliOper(QWalletHelperImpl.getAppRuntime(), paramString5.toString());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setProgressBarIndeterminateVisibility(false);
    setRequestedOrientation(1);
    this.mContext = this;
    try
    {
      this.mUin = getCurrentAccountUinFromRuntime();
      this.mUserNick = getCurrentNickname();
      this.mQqSkeyType = "2";
      this.mComeFrom = getIntent().getIntExtra("come_from", 5);
      this.callbackSn = getIntent().getStringExtra("callbackSn");
      this.mAppInfo = getIntent().getStringExtra("app_info");
      paramBundle = new JSONObject(getIntent().getStringExtra("extra_data"));
      this.mUrl = paramBundle.optString("url");
      this.mCodeUin = paramBundle.optString("uin");
      this.mCodeNick = paramBundle.optString("name");
      String str = paramBundle.optString("url");
      int i = str.indexOf("&f=");
      paramBundle = str;
      if (i > 0)
      {
        str = str.substring(i + 3);
        i = str.indexOf('&');
        paramBundle = str;
        if (i > 0) {
          paramBundle = str.substring(0, i);
        }
      }
      if ("wallet".equals(paramBundle)) {
        this.mSource = "1";
      } else if ("apw".equals(paramBundle)) {
        this.mSource = "2";
      }
      paramBundle = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendShowName(this.mCodeUin);
      if ((!TextUtils.isEmpty(paramBundle)) && (!paramBundle.equals(this.mCodeUin))) {
        this.mCodeNick = paramBundle;
      }
      sendVerifyQrcode();
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    addUploadData(this.mUin, 128, "scan.qrcode.loading", "", "", this.mComeFrom, "");
    return true;
  }
  
  public String getCurrentNickname()
  {
    AppRuntime localAppRuntime = QWalletHelperImpl.getAppRuntime();
    if (localAppRuntime == null) {
      return "";
    }
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      return ((BaseQQAppInterface)localAppRuntime).getCurrentNickname();
    }
    return localAppRuntime.getAccount();
  }
  
  public String getTargetString(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    String str2 = "";
    String str1 = str2;
    if (!bool)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString3))
      {
        if (TextUtils.isEmpty(paramString1)) {
          return "";
        }
        int k = paramString1.indexOf(paramString2) + paramString2.length();
        int j = paramString1.indexOf(paramString3, k);
        int i = j;
        if (j == -1) {
          i = paramString1.length();
        }
        str1 = str2;
        if (k != -1)
        {
          str1 = str2;
          if (k < paramString1.length())
          {
            str1 = str2;
            if (i != -1) {
              str1 = paramString1.substring(k, i);
            }
          }
        }
      }
    }
    return str1;
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (paramInt1 == 1)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("callbackSn", this.callbackSn);
      ((Intent)localObject1).putExtra("PayInvokerId", 5);
      if (paramIntent != null) {
        ((Intent)localObject1).putExtra("result", paramIntent.getStringExtra("result"));
      }
      setResult(-1, (Intent)localObject1);
      finish();
      return;
    }
    String str1;
    String str2;
    String str3;
    Object localObject2;
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("result");
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
      if (paramIntent != null)
      {
        paramIntent.optString("retmsg");
        int i = paramIntent.optInt("resultCode", -1);
        paramIntent = paramIntent.optString("data");
        paramInt2 = i;
        if (paramIntent != null)
        {
          paramInt2 = i;
          if (paramIntent.length() > 0) {
            try
            {
              paramIntent = new JSONObject(paramIntent);
              paramInt2 = i;
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              paramInt2 = i;
            }
          }
        }
      }
      paramIntent = null;
      if ((paramInt2 == 0) && (paramIntent != null))
      {
        if (paramInt1 != 5) {
          return;
        }
        paramIntent.optInt("type");
        str1 = paramIntent.optString("trans_uin");
        if (!this.mCodeUin.equals(str1))
        {
          showToast(HardCodeUtil.a(R.string.cU));
          finish();
          return;
        }
        str2 = paramIntent.optString("trans_fee");
        paramIntent.optString("create_time");
        str3 = getTargetString(paramIntent.optString("extend"), "explain=", "&");
        localObject1 = paramIntent.optString("nick_name");
        localObject2 = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).getFriendShowName(this.mCodeUin);
        paramIntent = (Intent)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramIntent = (Intent)localObject1;
          if (!((String)localObject2).equals(this.mCodeUin)) {
            paramIntent = (Intent)localObject2;
          }
        }
        if (!TextUtils.isEmpty(paramIntent))
        {
          localObject1 = paramIntent;
          if (!paramIntent.equals(this.mCodeUin)) {}
        }
        else
        {
          localObject1 = this.mCodeNick;
        }
        paramIntent = new Intent();
        paramIntent.putExtra("come_from", this.mComeFrom);
        localObject2 = new JSONObject();
      }
    }
    try
    {
      try
      {
        ((JSONObject)localObject2).put("targetUin", str1);
        ((JSONObject)localObject2).put("targetNickname", localObject1);
        ((JSONObject)localObject2).put("trans_fee", str2);
        ((JSONObject)localObject2).put("sign", "");
        ((JSONObject)localObject2).put("source", this.mSource);
        ((JSONObject)localObject2).put("desc", URLDecoder.decode(str3, "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    catch (JSONException localJSONException)
    {
      label485:
      break label485;
    }
    paramIntent.putExtra("extra_data", ((JSONObject)localObject2).toString());
    paramIntent.putExtra("app_info", this.mAppInfo);
    paramIntent.putExtra("callbackSn", this.callbackSn);
    paramIntent.putExtra("fromJump", true);
    paramIntent.putExtra("isJumpToH5", false);
    RouteUtils.a(this.mContext, paramIntent, "/qwallet/transaction", 1);
    return;
    sendCallback(-1, null);
    finish();
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
  
  protected void sendVerifyQrcode()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject2 = Uri.parse(this.mUrl);
      Object localObject1 = ((Uri)localObject2).getQueryParameter("dy");
      String str1 = ((Uri)localObject2).getQueryParameter("su");
      String str2 = ((Uri)localObject2).getQueryParameter("u");
      localObject2 = URLDecoder.decode(((Uri)localObject2).getQueryParameter("ac"));
      localJSONObject.put("auth_code", localObject2);
      if ("1".equals(localObject1))
      {
        if (this.mUin.equals(str2))
        {
          showToast(HardCodeUtil.a(R.string.cS));
          finish();
          return;
        }
        if (!this.mUin.equals(str1))
        {
          showToast(HardCodeUtil.a(R.string.cT));
          finish();
          return;
        }
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("*")) {
          localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length());
        }
        localJSONObject.put("tokenId", localObject1);
        localJSONObject.put("dy", "1");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("json", localJSONObject.toString());
        ((Bundle)localObject1).putString("callbackSn", "0");
        PayBridgeActivity.tenpay(this, 9, (Bundle)localObject1);
        QWalletTools.a(QWalletHelperImpl.getAppRuntime(), this.mUin, this.mComeFrom, this.mAppInfo, 1L, 0, "scanTransferLimmitQR", "", "");
        return;
      }
      openTenpayView("verifyqrcode", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void showToast(CharSequence paramCharSequence)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramCharSequence, 0).b(getTitleBarHeight(this.mContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity
 * JD-Core Version:    0.7.0.1
 */