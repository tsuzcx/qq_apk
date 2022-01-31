import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class osy
  implements BusinessObserver
{
  public osy(AppActivity paramAppActivity, String paramString, QQAppInterface paramQQAppInterface, ScannerParams paramScannerParams, View paramView, QrHandleResultCallBack paramQrHandleResultCallBack) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_MqqAppAppActivity.isResume()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    label193:
    Object localObject4;
    if ((paramBoolean) && (paramBundle != null))
    {
      Object localObject3 = paramBundle.getString("result");
      paramBundle = (Bundle)localObject1;
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject5 = new JSONObject((String)localObject3);
            localObject3 = localObject1;
            paramBundle = (Bundle)localObject1;
            if (((JSONObject)localObject5).getInt("r") != 0) {
              continue;
            }
            paramBundle = (Bundle)localObject1;
            if (!((JSONObject)localObject5).has("d")) {
              continue;
            }
            paramBundle = (Bundle)localObject1;
            localObject3 = new QRActionEntity(((JSONObject)localObject5).getString("d"));
            paramBundle = (Bundle)localObject1;
            if (!((JSONObject)localObject5).has("wpa")) {
              continue;
            }
            paramBundle = (Bundle)localObject1;
            if (!"1".equals(((JSONObject)localObject5).getString("wpa"))) {
              continue;
            }
            paramBoolean = true;
            paramBundle = (Bundle)localObject1;
            bool = ((JSONObject)localObject5).has("extvalue");
            paramBundle = (Bundle)localObject1;
            if (!((JSONObject)localObject5).has("exttype")) {
              continue;
            }
            paramBundle = (Bundle)localObject1;
            if ("2".equals(((JSONObject)localObject5).getString("exttype"))) {
              continue;
            }
            paramBundle = (Bundle)localObject1;
            if (!"1".equals(((JSONObject)localObject5).getString("exttype"))) {
              continue;
            }
          }
          catch (Exception localException1)
          {
            Object localObject5;
            boolean bool;
            Bundle localBundle;
            String str;
            paramInt = 0;
            continue;
          }
          paramBundle = (Bundle)localObject1;
          localBundle = new Bundle();
          if (paramBoolean)
          {
            paramBundle = (Bundle)localObject1;
            localBundle.putBoolean("issupportwpa", paramBoolean);
          }
          if ((paramInt != 0) && (bool))
          {
            paramBundle = (Bundle)localObject1;
            str = ((JSONObject)localObject5).getString("exttype");
            paramBundle = (Bundle)localObject1;
            localObject5 = ((JSONObject)localObject5).getString("extvalue");
            paramBundle = (Bundle)localObject1;
            localBundle.putString("exttype", str);
            paramBundle = (Bundle)localObject1;
            localBundle.putString("extvalue", (String)localObject5);
          }
          paramBundle = (Bundle)localObject1;
          paramInt = QRResultHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, (QRActionEntity)localObject3, this.jdField_a_of_type_JavaLangString, localBundle);
          try
          {
            if (this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b) {
              this.jdField_a_of_type_MqqAppAppActivity.finish();
            }
            ScannerUtils.a(paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e) {
              break;
            }
            this.jdField_a_of_type_MqqAppAppActivity.finish();
            return;
          }
          catch (Exception localException2)
          {
            paramBundle = (Bundle)localObject1;
            localObject1 = localException2;
          }
        }
        QLog.e("ScannerUtils", 1, "handle url error: " + ((Exception)localObject1).getMessage());
        label389:
        localObject1 = DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
        ((QQCustomDialog)localObject1).setTitle(2131429993);
        ((QQCustomDialog)localObject1).setMessage(paramBundle);
        localObject4 = new osz(this);
        ((QQCustomDialog)localObject1).setPositiveButton(2131432999, new ota(this, paramBundle));
        ((QQCustomDialog)localObject1).setNegativeButton(2131432998, (DialogInterface.OnClickListener)localObject4);
        ((QQCustomDialog)localObject1).setOnCancelListener((DialogInterface.OnCancelListener)localObject4);
        ((QQCustomDialog)localObject1).show();
        ScannerUtils.a(paramInt, paramBundle, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
        paramBoolean = false;
        continue;
        paramInt = 0;
        continue;
        paramBundle = (Bundle)localObject1;
        if (((JSONObject)localObject5).has("a_a"))
        {
          paramBundle = (Bundle)localObject1;
          localObject4 = ((JSONObject)localObject5).getString("a_a");
          paramBundle = (Bundle)localObject1;
          localObject5 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, (String)localObject4);
          localObject4 = localObject1;
          if (localObject5 != null)
          {
            paramBundle = (Bundle)localObject1;
            ((JumpAction)localObject5).b();
          }
        }
        else
        {
          localObject4 = localObject1;
          paramBundle = (Bundle)localObject1;
          if (((JSONObject)localObject5).has("url"))
          {
            paramBundle = (Bundle)localObject1;
            paramInt = ((JSONObject)localObject5).getInt("url_level");
            paramBundle = (Bundle)localObject1;
            localObject4 = ((JSONObject)localObject5).getString("url");
            paramBundle = (Bundle)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              break label829;
            }
            if (paramInt != 2) {
              break label822;
            }
            paramBundle = (Bundle)localObject1;
            localObject1 = Uri.parse((String)localObject4).toString();
            break label805;
          }
        }
      }
    }
    label777:
    label805:
    label822:
    label829:
    label832:
    for (;;)
    {
      paramBundle = (Bundle)localObject1;
      localObject4 = new Intent(this.jdField_a_of_type_MqqAppAppActivity, PublicAccountBrowser.class);
      paramBundle = (Bundle)localObject1;
      ((Intent)localObject4).putExtra("key_isReadModeEnabled", true);
      paramBundle = (Bundle)localObject1;
      ((Intent)localObject4).putExtra("fromQrcode", true);
      paramBundle = (Bundle)localObject1;
      ((Intent)localObject4).putExtra("url", (String)localObject1);
      paramBundle = (Bundle)localObject1;
      if (this.jdField_a_of_type_MqqAppAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true)
      {
        paramBundle = (Bundle)localObject1;
        this.jdField_a_of_type_MqqAppAppActivity.startActivity((Intent)localObject4);
        paramBundle = (Bundle)localObject1;
        this.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      for (;;)
      {
        paramBundle = (Bundle)localObject1;
        ScannerUtils.a(0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramBundle = (Bundle)localObject1;
        if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b) {
          break;
        }
        paramBundle = (Bundle)localObject1;
        this.jdField_a_of_type_MqqAppAppActivity.finish();
        return;
        paramBundle = (Bundle)localObject1;
        this.jdField_a_of_type_MqqAppAppActivity.startActivity((Intent)localObject4);
      }
      paramBundle = (Bundle)localObject4;
      paramInt = 0;
      break label389;
      paramBundle = (Bundle)localObject1;
      paramInt = 0;
      break label389;
      paramInt = 1;
      break label193;
      for (;;)
      {
        if (paramInt == 1) {
          break label832;
        }
        localObject4 = localException1;
        if (paramInt != 2) {
          break label777;
        }
        break;
        Object localObject2 = localObject4;
        continue;
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osy
 * JD-Core Version:    0.7.0.1
 */