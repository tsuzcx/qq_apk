package dov.com.qq.im.capture.view.share;

import anac;
import anad;
import anae;
import anaf;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterComboSharePlugin
  extends WebViewPlugin
  implements AdapterView.OnItemClickListener
{
  public int a;
  public Client.onRemoteRespObserver a;
  private ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  public String a;
  public String b;
  
  public FilterComboSharePlugin()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new anac(this);
    this.mPluginNameSpace = "FilterComboShare";
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "shareMsgToSina start!");
    }
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
      if (QLog.isColorLevel()) {
        QLog.d("FilterComboShare", 2, "shareMsgToSina installSinaWeibo:true");
      }
      ThreadManager.executeOnSubThread(new anad(this, paramString, (ApplicationInfo)localObject));
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        QRUtils.a(0, 2131439289);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "shareMsgToSina end!");
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("k_f_id", paramString);
    localBundle.putString("k_ms", "notifyResult");
    localBundle.putBoolean("k_r", paramBoolean);
    paramString = DataFactory.a("ipc_f_c_s", null, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, localBundle);
    WebIPCOperator.a().a(paramString);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.mRuntime.a(), this.mRuntime.a().getResources().getDimensionPixelSize(2131558448));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Bundle localBundle = new Bundle();
    localBundle.putString("k_f_id", paramString);
    localBundle.putInt("k_s_t", paramInt);
    localBundle.putString("k_ms", "getSharePic");
    localBundle = DataFactory.a("ipc_f_c_s", null, this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver.key, localBundle);
    WebIPCOperator.a().a(localBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FilterComboShare", 2, "requestSharePic" + paramString + " " + paramInt);
    }
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().postDelayed(new anaf(this), 250L);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 12)
    {
      a(paramString);
      return;
    }
    if (paramInt == 9) {}
    for (paramInt = 0;; paramInt = 1)
    {
      a(paramString, paramInt);
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString);
      localObject = localBitmap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FilterComboShare", 1, "share2Wechat err", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FilterComboShare", 2, "realShare " + paramString + " b: " + localObject + " type: " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.jdField_b_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new anae(this, paramInt);
    }
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    WXShareHelper.a().a(paramString, localObject, paramInt, true, this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterComboShare", 2, "onresp " + paramBoolean + " type" + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("result", paramBoolean);
      callJs("respShareResult", new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = this.mRuntime.a().getIntent().getStringExtra("k_f_id");
    if (paramString3.equals("showShareSheet")) {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.mRuntime.a());
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(BaseApplicationImpl.getApplication().getString(2131433083));
        paramJsBridgeListener = new ArrayList();
        paramString1 = new ShareActionSheetBuilder.ActionSheetItem();
        paramString1.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430109);
        paramString1.jdField_b_of_type_Int = 2130838336;
        paramString1.c = 9;
        paramString1.jdField_b_of_type_JavaLangString = "";
        paramJsBridgeListener.add(paramString1);
        paramString1 = new ShareActionSheetBuilder.ActionSheetItem();
        paramString1.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430110);
        paramString1.jdField_b_of_type_Int = 2130838330;
        paramString1.c = 10;
        paramString1.jdField_b_of_type_JavaLangString = "";
        paramJsBridgeListener.add(paramString1);
        paramString1 = new ShareActionSheetBuilder.ActionSheetItem();
        paramString1.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getString(2131430115);
        paramString1.jdField_a_of_type_Boolean = true;
        paramString1.jdField_b_of_type_Int = 2130838335;
        paramString1.c = 12;
        paramString1.jdField_b_of_type_JavaLangString = "";
        paramJsBridgeListener.add(paramString1);
        paramJsBridgeListener = (List[])new ArrayList[] { paramJsBridgeListener };
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(paramJsBridgeListener);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
      }
    }
    while (!"closeSharePage".equals(paramString3)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("FilterComboShare", 2, "actionSheet.show exception=" + paramJsBridgeListener);
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilterComboShare", 2, "closeSharePage");
    }
    this.mRuntime.a().finish();
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("FilterComboShare", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    paramView = this.mRuntime.a().getIntent().getStringExtra("k_f_id");
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
    int j = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.c;
    this.jdField_a_of_type_Int = j;
    if ((j == 10) || (j == 9)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131439288;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        QRUtils.a(0, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131435303;
        }
      }
      else
      {
        if (j == 10) {}
        for (paramInt = i;; paramInt = 0)
        {
          b(paramView, paramInt);
          return;
          if (j != 12) {
            break;
          }
          b(paramView, j);
          return;
        }
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.share.FilterComboSharePlugin
 * JD-Core Version:    0.7.0.1
 */