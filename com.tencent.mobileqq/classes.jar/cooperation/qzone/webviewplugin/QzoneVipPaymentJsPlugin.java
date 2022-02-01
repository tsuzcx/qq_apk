package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.vip.manager.MonitorManager;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class QzoneVipPaymentJsPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String KEY_DISCOUNTID = "discountId";
  public static final String KEY_OTHER = "other";
  public static final String KEY_PRELOAD_QZONE = "preloadQzone";
  public static final String KEY_PROVIDETYPE = "provideType";
  public static final String KEY_PROVIDEUIN = "provideUin";
  public static final String KEY_QZONE_VIP_OPEN_BACK_NEED_CHECK_VIPINFO = "key_qzone_vip_open_back_need_check_vipinfo";
  public static final String NAMESPACE = "Qzone";
  private static final String NORMAL_VIP = "1";
  public static final int OPEN_WHAT_SET_NAVI_DECO = 7;
  private static final byte RESULT_CODE_OPEN_VIP = 16;
  public static final String SET_ACTIVITY_NAME = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
  public static final String SET_NAVI_DECO = "SetNaviDeco";
  private static final String SUPER_VIP = "2";
  private static final String TAG = "QzoneVipPaymentJsPlugin";
  private String payCallback = null;
  
  private String createPF(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_m_qq");
    localStringBuilder.append("-");
    localStringBuilder.append("2013");
    localStringBuilder.append("-");
    localStringBuilder.append(paramString1.replaceAll("-", "_"));
    localStringBuilder.append("-");
    localStringBuilder.append("2013");
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2.replaceAll("-", "_"));
    return localStringBuilder.toString();
  }
  
  private int generateRequestCode(int paramInt)
  {
    WebUiBaseInterface localWebUiBaseInterface = this.parentPlugin.mRuntime.a(this.parentPlugin.mRuntime.d());
    int i = paramInt;
    if ((localWebUiBaseInterface instanceof WebViewPluginContainer)) {
      i = ((WebViewPluginContainer)localWebUiBaseInterface).switchRequestCode(this.parentPlugin, (byte)paramInt);
    }
    return i;
  }
  
  private void gotoVipPayment(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    Object localObject1 = this.parentPlugin.mRuntime.d();
    if (localObject1 != null)
    {
      if (((Activity)localObject1).isFinishing()) {
        return;
      }
      AppInterface localAppInterface = this.parentPlugin.mRuntime.b();
      if (localAppInterface == null) {
        return;
      }
      Intent localIntent = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
      String str1 = VipUtils.a(paramString4);
      Object localObject2 = ((Activity)localObject1).getString(2131915166);
      String str2 = ((Activity)localObject1).getString(2131915167);
      if ("1".equals(paramString3))
      {
        paramString3 = ((Activity)localObject1).getString(2131915166);
        localObject1 = "xxjzgw";
        paramString4 = "1450000153";
      }
      else if ("2".equals(paramString3))
      {
        paramString3 = ((Activity)localObject1).getString(2131914784);
        localObject1 = "XXJZGHH";
        paramString4 = "1450001557";
      }
      else
      {
        localObject1 = "";
        paramString4 = (String)localObject1;
        paramString3 = (String)localObject2;
      }
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("offerId", paramString4);
        paramString4 = (TicketManager)localAppInterface.getManager(2);
        String str3 = localAppInterface.getAccount();
        ((JSONObject)localObject2).put("userId", str3);
        ((JSONObject)localObject2).put("skey", paramString4.getSkey(str3));
        ((JSONObject)localObject2).put("serviceCode", localObject1);
        ((JSONObject)localObject2).put("serviceName", paramString3);
        ((JSONObject)localObject2).put("channel", "");
        ((JSONObject)localObject2).put("uint", str2);
        ((JSONObject)localObject2).put("openMonth", paramString2);
        ((JSONObject)localObject2).put("isCanChange", false);
        ((JSONObject)localObject2).put("autoPay", paramBoolean);
        ((JSONObject)localObject2).put("aid", str1);
        ((JSONObject)localObject2).put("pf", createPF(QUA.getQUA3(), str1));
        if ((!paramString1.equals(localAppInterface.getCurrentAccountUin())) && (!paramString1.equals("0")))
        {
          ((JSONObject)localObject2).put("provideUin", paramString1);
          ((JSONObject)localObject2).put("provideType", "uin");
        }
        ((JSONObject)localObject2).put("discountId", "");
        ((JSONObject)localObject2).put("other", "");
        paramString1 = new Bundle();
        paramString1.putInt("pay_requestcode", 4);
        paramString1.putString("json", ((JSONObject)localObject2).toString());
        localIntent.putExtras(paramString1);
        this.parentPlugin.startActivityForResult(localIntent, (byte)16);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private void onPay(Activity paramActivity, int paramInt1, String paramString, int paramInt2, int paramInt3, Intent paramIntent)
  {
    if (paramInt1 != -5)
    {
      if (paramInt1 != 0)
      {
        if (paramInt1 != 2)
        {
          paramString = paramIntent;
          if (paramIntent == null) {
            paramString = new Intent();
          }
          paramString.putExtra("key_qzone_vip_open_back_need_check_vipinfo", false);
          paramActivity.setResult(0, paramString);
          paramActivity.finish();
          return;
        }
        paramActivity.setResult(0, paramIntent);
      }
    }
    else {
      paramActivity.finish();
    }
  }
  
  private void onPayClose()
  {
    Activity localActivity = this.parentPlugin.mRuntime.d();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      localActivity.finish();
    }
  }
  
  private void payVipDirectly(String paramString1, String paramString2)
  {
    Object localObject = this.parentPlugin.mRuntime.d();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      try
      {
        localObject = new JSONObject(paramString1);
        gotoVipPayment(((JSONObject)localObject).optString("openUin"), ((JSONObject)localObject).optString("openMonth"), ((JSONObject)localObject).optString("openVipType"), ((JSONObject)localObject).getBoolean("isAuto"), ((JSONObject)localObject).optString("aid"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      MonitorManager localMonitorManager = MonitorManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("js 回调 native 支付");
      localStringBuilder.append(paramString1);
      localMonitorManager.a(1, 2, "native 支付", localStringBuilder.toString());
      this.payCallback = paramString2;
      if (this.parentPlugin.mRuntime.b() == null) {
        return;
      }
      paramString1 = this.parentPlugin.mRuntime.b().getAccount();
      paramString2 = new QZoneClickReport.ReportInfo();
      paramString2.setActionType("328");
      paramString2.setToUin(Long.parseLong(paramString1));
      paramString2.setSubactionType("10");
      paramString2.setReserves("1");
      QZoneClickReport.startReportImediately(paramString1, paramString2);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934595L) && (paramMap != null))
    {
      ((Integer)paramMap.get("errorCode")).intValue();
      if (QLog.isColorLevel()) {
        QLog.e("QzoneVipPaymentJsPlugin", 2, "VasWebReport:EVENT_LOAD_ERROR");
      }
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2.equals("Qzone")) && (this.parentPlugin != null))
    {
      if (this.parentPlugin.mRuntime == null) {
        return false;
      }
      if ((paramString3.equals("payVipDirectly")) && (paramVarArgs != null) && (paramVarArgs.length >= 1)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          payVipDirectly(paramVarArgs[0], paramJsBridgeListener.optString("callback"));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ((!paramString3.equals("closePayDialog")) && (!paramString3.equals("closeFloatingWebView")))
      {
        if (paramString3.equals("SetNaviDeco"))
        {
          if (paramVarArgs != null)
          {
            if (TextUtils.isEmpty(paramVarArgs[0])) {
              return true;
            }
            paramJsBridgeListener = new Intent();
            QzonePluginProxyActivity.setActivityNameToIntent(paramJsBridgeListener, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
            paramJsBridgeListener.putExtra("open_what", 7);
            paramJsBridgeListener.putExtra("navi_deco", paramVarArgs[0]);
            if ((this.parentPlugin.mRuntime != null) && (this.parentPlugin.mRuntime.d() != null) && (this.parentPlugin.mRuntime.b() != null)) {
              QzonePluginProxyActivity.launchPluingActivityForResult(this.parentPlugin.mRuntime.d(), this.parentPlugin.mRuntime.b().getAccount(), paramJsBridgeListener, generateRequestCode(9));
            }
          }
          return true;
        }
        if ("preloadQzone".equals(paramString3))
        {
          ThreadManagerV2.executeOnSubThread(new QzoneVipPaymentJsPlugin.1(this));
          return true;
        }
        return false;
      }
      onPayClose();
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((this.parentPlugin != null) && (this.parentPlugin.mRuntime != null))
    {
      Activity localActivity = this.parentPlugin.mRuntime.d();
      if (localActivity != null)
      {
        if (localActivity.isFinishing()) {
          return;
        }
        if (paramByte == 16)
        {
          Object localObject2 = "";
          Object localObject1 = localObject2;
          if (paramIntent != null)
          {
            Object localObject3 = paramIntent.getExtras();
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localActivity.setResult(paramInt, paramIntent);
              localObject1 = ((Bundle)localObject3).getString("result");
              try
              {
                localObject2 = new JSONObject((String)localObject1);
                paramInt = ((JSONObject)localObject2).getInt("resultCode");
                localObject3 = ((JSONObject)localObject2).getString("resultMsg");
                int i = ((JSONObject)localObject2).getInt("payState");
                int j = ((JSONObject)localObject2).getInt("provideState");
                if (!TextUtils.isEmpty(this.payCallback)) {
                  this.parentPlugin.callJs(this.payCallback, new String[] { localObject1 });
                }
                onPay(localActivity, paramInt, (String)localObject3, i, j, paramIntent);
                paramInt = 0;
              }
              catch (Exception paramIntent)
              {
                paramIntent.printStackTrace();
              }
            }
          }
          paramInt = 1;
          paramIntent = MonitorManager.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" 回调黄钻结果通知js ");
          ((StringBuilder)localObject2).append((String)localObject1);
          paramIntent.a(1, 3, "米大师支付结果回调", ((StringBuilder)localObject2).toString());
          if (paramInt != 0)
          {
            paramIntent = new Intent();
            paramIntent.putExtra("key_qzone_vip_open_back_need_check_vipinfo", false);
            localActivity.setResult(0, paramIntent);
            localActivity.finish();
          }
        }
      }
      return;
    }
    QLog.e("QzoneVipPaymentJsPlugin", 1, new Object[] { "parentPlugin.mRuntime null, requestCode:", Byte.valueOf(paramByte), " resultCode", Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin
 * JD-Core Version:    0.7.0.1
 */