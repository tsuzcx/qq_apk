package com.tencent.mobileqq.qrscan.activity;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qrscan.QRActionEntity;
import com.tencent.mobileqq.qrscan.QRCodeBusinessObserver;
import com.tencent.mobileqq.qrscan.QRResultHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QRJumpActivity$2
  extends QRCodeBusinessObserver
{
  QRJumpActivity$2(QRJumpActivity paramQRJumpActivity, String paramString1, String paramString2, Activity paramActivity, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.e.isFinishing()) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.i("IQRScanConst_QRJumpActivity", 2, String.format("JumpUrl onReceive suc=%b ", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    String str = null;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("result");
      QLog.i("IQRScanConst_QRJumpActivity", 2, String.format("JumpUrl onReceive result=%s", new Object[] { paramBundle }));
    }
    label147:
    label287:
    label290:
    label296:
    label302:
    try
    {
      localObject = new JSONObject(paramBundle);
      if (((JSONObject)localObject).getInt("r") == 0) {
        localQRActionEntity = new QRActionEntity(((JSONObject)localObject).getString("d"));
      }
    }
    catch (Exception paramBundle)
    {
      Object localObject;
      QRActionEntity localQRActionEntity;
      label205:
      break label296;
    }
    try
    {
      paramBoolean = ((JSONObject)localObject).has("wpa");
      if (!paramBoolean) {
        break label349;
      }
      paramBoolean = "1".equals(((JSONObject)localObject).getString("wpa"));
    }
    catch (Exception paramBundle)
    {
      break label290;
      paramBoolean = false;
      break label147;
      paramInt = 0;
      break label205;
    }
    bool = ((JSONObject)localObject).has("extvalue");
    if (((JSONObject)localObject).has("exttype"))
    {
      paramInt = i;
      if (!"2".equals(((JSONObject)localObject).getString("exttype")))
      {
        if (!"1".equals(((JSONObject)localObject).getString("exttype"))) {
          break label354;
        }
        paramInt = i;
      }
      paramBundle = new Bundle();
      if (paramBoolean) {}
      try
      {
        paramBundle.putBoolean("issupportwpa", paramBoolean);
        if ((paramInt != 0) && (bool))
        {
          str = ((JSONObject)localObject).getString("exttype");
          localObject = ((JSONObject)localObject).getString("extvalue");
          paramBundle.putString("exttype", str);
          paramBundle.putString("extvalue", (String)localObject);
        }
        paramBundle.putString("authKey", this.a);
        paramBundle.putString("authSig", this.b);
      }
      catch (Exception localException)
      {
        break label287;
      }
      paramBundle = str;
      break label302;
      localQRActionEntity = null;
      paramBundle = str;
      if (paramBundle != null) {
        QRResultHandler.a(QRJumpActivity.a(this.e), this.c, localQRActionEntity, this.d, paramBundle);
      }
      this.c.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */