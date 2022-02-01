package cooperation.qwallet.open;

import Override;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import bfuc;
import bkwc;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class AppPayActivity
  extends BaseActivity
{
  private boolean a;
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.prePay");
    }
    Object localObject = super.getIntent();
    if ((localObject != null) && (!TextUtils.isEmpty(((Intent)localObject).getAction())) && (((Intent)localObject).getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(((Intent)localObject).getScheme())) && (((Intent)localObject).getScheme().equals("mqqwallet")))
    {
      a(true);
      return;
    }
    if (localObject == null) {}
    String str;
    for (localObject = "intent is null";; localObject = str + " Action:" + ((Intent)localObject).getAction())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.pay", 2, "AppPayActivity.prePay error, params:" + (String)localObject);
      }
      super.finish();
      return;
      str = "Scheme:" + ((Intent)localObject).getScheme();
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "pay-open-app", "payinvoke", null, 0, null);
    Object localObject = new bkwc();
    try
    {
      ((bkwc)localObject).a(paramIntent.getExtras());
      boolean bool = ((bkwc)localObject).a();
      paramIntent = ((bkwc)localObject).toString();
      paramIntent = paramIntent + "&check=" + bool;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOpenPay data:" + paramIntent);
      }
      if (bool)
      {
        VACDReportUtil.a(l, ((bkwc)localObject).i, "parseurl", paramIntent, 0, null);
        paramIntent = new Bundle();
        paramIntent.putInt("extra.key.pay.type", 1);
        paramIntent.putInt("extra.key.pay.from", 2);
        paramIntent.putInt("extra.key.pay.platform", 1);
        paramIntent.putInt("extra.key.app.type", 1);
        paramIntent.putLong("vacreport_key_seq", l);
        paramIntent.putString("appId", ((bkwc)localObject).jdField_a_of_type_JavaLangString);
        paramIntent.putString("callbackSn", ((bkwc)localObject).e);
        paramIntent.putString("nonce", ((bkwc)localObject).j);
        paramIntent.putLong("timeStamp", ((bkwc)localObject).jdField_a_of_type_Long);
        paramIntent.putString("sig", ((bkwc)localObject).m);
        paramIntent.putString("sigType", ((bkwc)localObject).l);
        paramIntent.putString("tokenId", ((bkwc)localObject).i);
        paramIntent.putString("bargainorId", ((bkwc)localObject).k);
        paramIntent.putString("qVersion", DeviceInfoUtil.getQQVersionWithCode(this));
        paramIntent.putString("packageName", ((bkwc)localObject).n);
        paramIntent.putString("callbackScheme", ((bkwc)localObject).f);
        localObject = new Intent(this, OpenPayActivity.class);
        ((Intent)localObject).putExtras(paramIntent);
        ((Intent)localObject).addFlags(67108864);
        super.startActivity((Intent)localObject);
        super.finish();
        return;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
        continue;
        VACDReportUtil.endReport(l, "parseurl", paramIntent, 668801, "params error");
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "pay-app", "payinvoke", null, 0, null);
    Object localObject = new bkwc();
    ((bkwc)localObject).a(paramString);
    boolean bool = ((bkwc)localObject).a();
    paramString = ((bkwc)localObject).toString();
    paramString = paramString + "&check=" + bool;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doBrowserPay data:" + paramString);
    }
    if (bool)
    {
      if (!a(((bkwc)localObject).n))
      {
        VACDReportUtil.endReport(l, "parseurl", paramString, 668801, "app died.");
        super.finish();
        return;
      }
      VACDReportUtil.a(l, ((bkwc)localObject).i, "parseurl", paramString, 0, null);
      paramString = new Bundle();
      paramString.putInt("extra.key.pay.type", 1);
      paramString.putInt("extra.key.pay.from", 2);
      paramString.putInt("extra.key.pay.platform", 1);
      paramString.putInt("extra.key.app.type", 2);
      paramString.putLong("vacreport_key_seq", l);
      paramString.putString("appId", ((bkwc)localObject).jdField_a_of_type_JavaLangString);
      paramString.putString("callbackSn", ((bkwc)localObject).e);
      paramString.putString("nonce", ((bkwc)localObject).j);
      paramString.putLong("timeStamp", ((bkwc)localObject).jdField_a_of_type_Long);
      paramString.putString("sig", ((bkwc)localObject).m);
      paramString.putString("sigType", ((bkwc)localObject).l);
      paramString.putString("tokenId", ((bkwc)localObject).i);
      paramString.putString("bargainorId", ((bkwc)localObject).k);
      paramString.putString("qVersion", DeviceInfoUtil.getQQVersionWithCode(this));
      paramString.putString("packageName", ((bkwc)localObject).n);
      paramString.putString("callbackScheme", ((bkwc)localObject).f);
      localObject = new Intent(this, OpenPayActivity.class);
      ((Intent)localObject).putExtras(paramString);
      ((Intent)localObject).addFlags(67108864);
      super.startActivity((Intent)localObject);
    }
    for (;;)
    {
      super.finish();
      return;
      VACDReportUtil.endReport(l, "parseurl", paramString, 668801, "params error");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject3 = super.getIntent();
    if (localObject3 == null) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doPay intent == null");
      }
    }
    String str;
    do
    {
      Object localObject1;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doPay");
        }
        if ((!paramBoolean) || (this.app.isLogin())) {
          break;
        }
        localObject1 = new Intent(this, LoginActivity.class);
        ((Intent)localObject1).putExtra("isActionSend", true);
        ((Intent)localObject1).putExtras((Intent)localObject3);
        super.startActivityForResult((Intent)localObject1, 21);
      } while (!QLog.isColorLevel());
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doPay login");
      return;
      try
      {
        localObject1 = ((Intent)localObject3).getDataString();
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).length() <= 9))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qwallet.pay", 2, "AppPayActivity.doPay url error:" + (String)localObject1);
          }
          super.finish();
          return;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          str = null;
        }
        if ("mqqwallet://open_pay/".compareTo(str) == 0)
        {
          a((Intent)localObject3);
          return;
        }
        if ("mqqwallet://pubacc_pay/".compareTo(str) == 0)
        {
          super.finish();
          return;
        }
        int i = str.indexOf("mqqwallet://");
        if (i != -1)
        {
          localObject3 = str.substring(i + "mqqwallet://".length());
          try
          {
            localObject3 = new String(bfuc.decode((String)localObject3, 0));
            localObject2 = localObject3;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
          if (localObject2 != null)
          {
            a(localObject2);
            return;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.qwallet.pay", 2, "AppPayActivity.doPay url not THIRD_APP:" + str);
  }
  
  protected boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    do
    {
      Object localObject2;
      do
      {
        return false;
        localObject1 = null;
        if (getCallingActivity() != null) {
          localObject1 = getCallingActivity().getPackageName();
        }
        localObject2 = localObject1;
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
      } while (localObject1 == null);
      Object localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
      j = 1;
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
    } while (j == 0);
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOnActivityResult PAY_LOGIN_REQUEST");
    }
    a(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    try
    {
      super.doOnCreate(paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOnCreate");
      }
    }
    catch (Exception paramBundle)
    {
      label143:
      while (!QLog.isColorLevel()) {}
      QLog.e("qqBaseActivity", 2, "doOnCreate|exp:" + paramBundle.getMessage());
      return false;
    }
    try
    {
      if ((mAppForground) || (!this.mCanLock) || (this.app == null) || (this.app.getCurrentAccountUin() == null) || (!GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin()))) {
        break label184;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay", 2, "" + System.currentTimeMillis() + " AppPayActivity.doOnCreate getJumpLock");
      }
      this.a = true;
    }
    catch (Throwable paramBundle)
    {
      label184:
      if (!QLog.isColorLevel()) {
        break label143;
      }
      QLog.e("qqBaseActivity", 2, "doOnCreate|exp:" + paramBundle.getMessage());
    }
    return false;
    a();
    return false;
    return false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.a) && (Math.abs(mShowGesture - SystemClock.uptimeMillis()) >= 1000L))
    {
      this.a = false;
      a();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qwallet.open.AppPayActivity
 * JD-Core Version:    0.7.0.1
 */