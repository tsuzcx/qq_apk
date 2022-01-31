import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class phn
  implements BusinessObserver
{
  public phn(SSOWebviewPlugin paramSSOWebviewPlugin, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2;
    for (;;)
    {
      long l1;
      try
      {
        Object localObject1 = paramBundle.getString("extra_callbackid");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject2 = new JSONObject();
        long l2 = -1L;
        if (!paramBoolean) {
          break label1251;
        }
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        if (arrayOfByte == null) {
          break label1202;
        }
        Object localObject3 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom(arrayOfByte);
        l1 = l2;
        if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.has())
        {
          paramBundle = paramBundle.getString("extra_cmd");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, cmd=" + paramBundle);
          }
          l1 = l2;
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.delayms.has())
            {
              l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject3).comm.delayms.get()).longValue();
              if (l1 != 0L) {
                break label1155;
              }
              this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.e.put(paramBundle, Integer.valueOf(2147483647));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, delay=" + l1 + ", cmd:" + paramBundle);
              }
            }
            if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.packagesize.has())
            {
              l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject3).comm.packagesize.get()).longValue();
              this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.b.put(paramBundle, Long.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, pkgSize=" + l1);
              }
            }
            l1 = l2;
            if (((WebSSOAgent.UniSsoServerRsp)localObject3).comm.proctime.has())
            {
              l2 = ((WebSSOAgent.UniSsoServerRsp)localObject3).comm.proctime.get();
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, svrCostTime=" + l2);
                l1 = l2;
              }
            }
          }
        }
        ((JSONObject)localObject2).put("ssoRet", 0);
        if (!((WebSSOAgent.UniSsoServerRsp)localObject3).ret.has()) {
          break label1176;
        }
        l2 = ((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get();
        ((JSONObject)localObject2).put("businessRet", l2);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, biz ret code=" + l2);
        }
        if (!((WebSSOAgent.UniSsoServerRsp)localObject3).errmsg.has()) {
          break label1188;
        }
        paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject3).errmsg.get();
        ((JSONObject)localObject2).put("msg", paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, errmsg=" + paramBundle);
        }
        l2 = l1;
        if (((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.has())
        {
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.get();
          ((JSONObject)localObject2).put("data", paramBundle);
          l2 = l1;
          if (QLog.isColorLevel())
          {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, rspData=" + paramBundle);
            l2 = l1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, callback Json string=" + ((JSONObject)localObject2).toString());
        }
        WebSSOAgentServlet.d = System.currentTimeMillis();
        l1 = WebSSOAgentServlet.d - WebSSOAgentServlet.a;
        long l3 = WebSSOAgentServlet.b - WebSSOAgentServlet.a;
        long l4 = WebSSOAgentServlet.c - WebSSOAgentServlet.b;
        long l5 = WebSSOAgentServlet.d - WebSSOAgentServlet.c;
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, total=" + l1 + ",pre=" + l3 + ",msf=" + l4 + ",after=" + l5);
        }
        paramBundle = new JSONObject();
        paramBundle.put("packTime", l3);
        paramBundle.put("SSONetworkTime", l4);
        paramBundle.put("unpackTime", l5);
        paramBundle.put("serverProcessTime", l2);
        ((JSONObject)localObject2).put("speedPoint", paramBundle);
        this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.callJs((String)localObject1, new String[] { ((JSONObject)localObject2).toString() });
        try
        {
          long l6 = ((JSONObject)localObject2).optLong("ssoRet", 0L);
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_FailCode", String.valueOf(l6));
          ((HashMap)localObject2).put("totalTime", l1 + "");
          ((HashMap)localObject2).put("packTime", l3 + "");
          ((HashMap)localObject2).put("SSONetworkTime", l4 + "");
          ((HashMap)localObject2).put("unpackTime", l5 + "");
          ((HashMap)localObject2).put("serverProcessTime", l2 + "");
          ((HashMap)localObject2).put("cmd", this.jdField_a_of_type_JavaLangString);
          localObject3 = this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.mRuntime.a().getCurrentAccountUin();
          localObject1 = "ssoWebView";
          paramBundle = (Bundle)localObject1;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramBundle = (Bundle)localObject1;
            if (this.jdField_a_of_type_JavaLangString.startsWith("apollo")) {
              paramBundle = "apolloSSOWebView";
            }
          }
          localObject1 = StatisticCollector.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.mRuntime.a());
          if (0L != l6) {
            break;
          }
          paramBoolean = true;
          label1068:
          ((StatisticCollector)localObject1).a((String)localObject3, paramBundle, paramBoolean, l1, 0L, (HashMap)localObject2, "", false);
          return;
        }
        catch (Throwable paramBundle)
        {
          if (!QLog.isColorLevel()) {
            break label1405;
          }
        }
        QLog.e("SSOWebviewPlugin", 2, "report ssoWebView:  " + paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break label1405;
        }
      }
      QLog.e("SSOWebviewPlugin", 2, "uniAgent, onReceive, Exception: " + paramBundle);
      return;
      label1155:
      this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.e.put(paramBundle, Integer.valueOf((int)l1));
      continue;
      label1176:
      ((JSONObject)localObject2).put("businessRet", 0);
      continue;
      label1188:
      ((JSONObject)localObject2).put("msg", "SSO发送成功");
      continue;
      label1202:
      if (QLog.isColorLevel()) {
        QLog.w("SSOWebviewPlugin", 2, "uniAgent, onReceive, ret success but no data");
      }
      ((JSONObject)localObject2).put("ssoRet", 255);
      ((JSONObject)localObject2).put("businessRet", 0);
      ((JSONObject)localObject2).put("msg", "SSO返回数据包为空");
      continue;
      label1251:
      paramInt = paramBundle.getInt("extra_result_code");
      if (QLog.isColorLevel()) {
        QLog.d("SSOWebviewPlugin", 2, "uniAgent, msfResultCode=" + paramInt);
      }
      if (paramInt != 1001) {
        break label1406;
      }
      ((JSONObject)localObject2).put("ssoRet", 201);
      ((JSONObject)localObject2).put("businessRet", 0);
      ((JSONObject)localObject2).put("msg", "MSF返回:发送失败");
    }
    for (;;)
    {
      label1332:
      ((JSONObject)localObject2).put("ssoRet", 202);
      ((JSONObject)localObject2).put("businessRet", 0);
      ((JSONObject)localObject2).put("msg", "MSF返回:超时");
      break;
      label1405:
      label1406:
      do
      {
        ((JSONObject)localObject2).put("ssoRet", 255);
        ((JSONObject)localObject2).put("businessRet", 0);
        ((JSONObject)localObject2).put("msg", "未知错误");
        break;
        paramBoolean = false;
        break label1068;
        return;
        if (paramInt == 1002) {
          break label1332;
        }
      } while (paramInt != 1013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phn
 * JD-Core Version:    0.7.0.1
 */