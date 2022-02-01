package cooperation.qwallet.open;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.openpay.PayApi;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class AppPayActivity
  extends QBaseActivity
{
  private boolean a = false;
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(" AppPayActivity.prePay");
      QLog.i("Q.qwallet.pay", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = super.getIntent();
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Intent)localObject1).getAction())) && (((Intent)localObject1).getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(((Intent)localObject1).getScheme())) && (((Intent)localObject1).getScheme().equals("mqqwallet")))
    {
      a(true);
      return;
    }
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "intent is null";
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Scheme:");
      ((StringBuilder)localObject2).append(((Intent)localObject1).getScheme());
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" Action:");
      localStringBuilder.append(((Intent)localObject1).getAction());
      localObject1 = localStringBuilder.toString();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AppPayActivity.prePay error, params:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("Q.qwallet.pay", 2, ((StringBuilder)localObject2).toString());
    }
    super.finish();
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "pay-open-app", "payinvoke", null, 0, null);
    Object localObject = new PayApi();
    try
    {
      ((PayApi)localObject).a(paramIntent.getExtras());
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
    boolean bool = ((PayApi)localObject).a();
    paramIntent = ((PayApi)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIntent);
    localStringBuilder.append("&check=");
    localStringBuilder.append(bool);
    paramIntent = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(" AppPayActivity.doOpenPay data:");
      localStringBuilder.append(paramIntent);
      QLog.i("Q.qwallet.pay", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      VACDReportUtil.a(l, ((PayApi)localObject).i, "parseurl", paramIntent, 0, null);
      paramIntent = new Bundle();
      paramIntent.putInt("extra.key.pay.type", 1);
      paramIntent.putInt("extra.key.pay.from", 2);
      paramIntent.putInt("extra.key.pay.platform", 1);
      paramIntent.putInt("extra.key.app.type", 1);
      paramIntent.putLong("vacreport_key_seq", l);
      paramIntent.putString("appId", ((PayApi)localObject).jdField_a_of_type_JavaLangString);
      paramIntent.putString("callbackSn", ((PayApi)localObject).e);
      paramIntent.putString("nonce", ((PayApi)localObject).j);
      paramIntent.putLong("timeStamp", ((PayApi)localObject).jdField_a_of_type_Long);
      paramIntent.putString("sig", ((PayApi)localObject).m);
      paramIntent.putString("sigType", ((PayApi)localObject).l);
      paramIntent.putString("tokenId", ((PayApi)localObject).i);
      paramIntent.putString("bargainorId", ((PayApi)localObject).k);
      paramIntent.putString("qVersion", DeviceInfoUtil.a(this));
      paramIntent.putString("packageName", ((PayApi)localObject).n);
      paramIntent.putString("callbackScheme", ((PayApi)localObject).f);
      localObject = new Intent(this, OpenPayActivity.class);
      ((Intent)localObject).putExtras(paramIntent);
      ((Intent)localObject).addFlags(67108864);
      super.startActivity((Intent)localObject);
    }
    else
    {
      VACDReportUtil.endReport(l, "parseurl", paramIntent, 668801, "params error");
    }
    super.finish();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "pay-app", "payinvoke", null, 0, null);
    Object localObject = new PayApi();
    ((PayApi)localObject).a(paramString);
    boolean bool = ((PayApi)localObject).a();
    paramString = ((PayApi)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&check=");
    localStringBuilder.append(bool);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(" AppPayActivity.doBrowserPay data:");
      localStringBuilder.append(paramString);
      QLog.i("Q.qwallet.pay", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      if (!a(((PayApi)localObject).n))
      {
        VACDReportUtil.endReport(l, "parseurl", paramString, 668801, "app died.");
        super.finish();
        return;
      }
      VACDReportUtil.a(l, ((PayApi)localObject).i, "parseurl", paramString, 0, null);
      paramString = new Bundle();
      paramString.putInt("extra.key.pay.type", 1);
      paramString.putInt("extra.key.pay.from", 2);
      paramString.putInt("extra.key.pay.platform", 1);
      paramString.putInt("extra.key.app.type", 2);
      paramString.putLong("vacreport_key_seq", l);
      paramString.putString("appId", ((PayApi)localObject).jdField_a_of_type_JavaLangString);
      paramString.putString("callbackSn", ((PayApi)localObject).e);
      paramString.putString("nonce", ((PayApi)localObject).j);
      paramString.putLong("timeStamp", ((PayApi)localObject).jdField_a_of_type_Long);
      paramString.putString("sig", ((PayApi)localObject).m);
      paramString.putString("sigType", ((PayApi)localObject).l);
      paramString.putString("tokenId", ((PayApi)localObject).i);
      paramString.putString("bargainorId", ((PayApi)localObject).k);
      paramString.putString("qVersion", DeviceInfoUtil.a(this));
      paramString.putString("packageName", ((PayApi)localObject).n);
      paramString.putString("callbackScheme", ((PayApi)localObject).f);
      localObject = new Intent(this, OpenPayActivity.class);
      ((Intent)localObject).putExtras(paramString);
      ((Intent)localObject).addFlags(67108864);
      super.startActivity((Intent)localObject);
    }
    else
    {
      VACDReportUtil.endReport(l, "parseurl", paramString, 668801, "params error");
    }
    super.finish();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject3 = super.getIntent();
    Object localObject1;
    if (localObject3 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        ((StringBuilder)localObject1).append(" AppPayActivity.doPay intent == null");
        QLog.i("Q.qwallet.pay", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(" AppPayActivity.doPay");
      QLog.i("Q.qwallet.pay", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramBoolean) && (!getAppRuntime().isLogin()))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("isActionSend", true);
      ((Intent)localObject1).putExtras((Intent)localObject3);
      RouteUtils.a(this, (Intent)localObject1, "/base/login", 21);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        ((StringBuilder)localObject1).append(" AppPayActivity.doPay login");
        QLog.i("Q.qwallet.pay", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject2 = null;
    CharSequence localCharSequence;
    try
    {
      localObject1 = ((Intent)localObject3).getDataString();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      localCharSequence = null;
    }
    if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.length() > 9))
    {
      if ("mqqwallet://open_pay/".compareTo(localCharSequence) == 0)
      {
        a((Intent)localObject3);
        return;
      }
      if ("mqqwallet://pubacc_pay/".compareTo(localCharSequence) == 0)
      {
        super.finish();
        return;
      }
      int i = localCharSequence.indexOf("mqqwallet://");
      if (i != -1)
      {
        localObject3 = localCharSequence.substring(i + 12);
        try
        {
          localObject3 = new String(Base64Util.decode((String)localObject3, 0));
          localObject2 = localObject3;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        if (localObject2 != null)
        {
          a((String)localObject2);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AppPayActivity.doPay url not THIRD_APP:");
        ((StringBuilder)localObject2).append(localCharSequence);
        QLog.e("Q.qwallet.pay", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("AppPayActivity.doPay url error:");
      ((StringBuilder)localObject2).append(localCharSequence);
      QLog.e("Q.qwallet.pay", 2, ((StringBuilder)localObject2).toString());
    }
    super.finish();
  }
  
  protected boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = null;
    if (getCallingActivity() != null) {
      localObject1 = getCallingActivity().getPackageName();
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (getCallingPackage() != null) {
        localObject2 = getCallingPackage();
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      return ((String)localObject2).equals(paramString);
    }
    localObject1 = (ActivityManager)getSystemService("activity");
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
    int j = 1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      int i = j;
      if (j != 0)
      {
        i = j;
        if (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null)
        {
          i = j;
          if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.indexOf("com.tencent.mobileqq") != 0) {
            i = 0;
          }
        }
      }
      j = i;
      if (((ActivityManager.RunningAppProcessInfo)localObject2).pkgList != null)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= ((ActivityManager.RunningAppProcessInfo)localObject2).pkgList.length) {
            break;
          }
          if (paramString.equals(localObject2.pkgList[k])) {
            return true;
          }
          k += 1;
        }
      }
    }
    return j != 0;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("");
        paramIntent.append(System.currentTimeMillis());
        paramIntent.append(" AppPayActivity.doOnActivityResult PAY_LOGIN_REQUEST");
        QLog.i("Q.qwallet.pay", 2, paramIntent.toString());
      }
      a(false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    try
    {
      super.doOnCreate(paramBundle);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("");
        paramBundle.append(System.currentTimeMillis());
        paramBundle.append(" AppPayActivity.doOnCreate");
        QLog.i("Q.qwallet.pay", 2, paramBundle.toString());
      }
      StringBuilder localStringBuilder;
      try
      {
        paramBundle = (IQWalletTemp)QRoute.api(IQWalletTemp.class);
        if ((!mAppForground) && (this.mCanLock) && (getAppRuntime().getCurrentAccountUin() != null) && (paramBundle.GesturePWDUtils$getJumpLock(this, getAppRuntime().getCurrentAccountUin())))
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("");
            paramBundle.append(System.currentTimeMillis());
            paramBundle.append(" AppPayActivity.doOnCreate getJumpLock");
            QLog.i("Q.qwallet.pay", 2, paramBundle.toString());
          }
          this.a = true;
          return false;
        }
        a();
        return false;
      }
      catch (Throwable paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doOnCreate|exp:");
          localStringBuilder.append(paramBundle.getMessage());
          QLog.e("qqBaseActivity", 2, localStringBuilder.toString());
        }
        return false;
      }
      return false;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnCreate|exp:");
        localStringBuilder.append(paramBundle.getMessage());
        QLog.e("qqBaseActivity", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.a) && (Math.abs(mShowGesture - SystemClock.uptimeMillis()) >= 1000L))
    {
      this.a = false;
      a();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.open.AppPayActivity
 * JD-Core Version:    0.7.0.1
 */