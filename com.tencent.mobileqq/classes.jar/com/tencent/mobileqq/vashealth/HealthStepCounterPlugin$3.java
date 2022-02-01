package com.tencent.mobileqq.vashealth;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerRsp;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgentServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class HealthStepCounterPlugin$3
  implements BusinessObserver
{
  HealthStepCounterPlugin$3(HealthStepCounterPlugin paramHealthStepCounterPlugin) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        localObject1 = paramBundle.getString("extra_callbackid");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localJSONObject = new JSONObject();
        l2 = -1L;
        if (paramBoolean)
        {
          byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
          if (arrayOfByte != null)
          {
            localObject2 = new WebSSOAgent.UniSsoServerRsp();
            ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(arrayOfByte);
            l1 = l2;
            if (((WebSSOAgent.UniSsoServerRsp)localObject2).comm.has())
            {
              paramBundle = paramBundle.getString("extra_cmd");
              l1 = l2;
              if (!TextUtils.isEmpty(paramBundle))
              {
                if (((WebSSOAgent.UniSsoServerRsp)localObject2).comm.delayms.has()) {
                  this.a.b.put(paramBundle, Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).comm.delayms.get()));
                }
                if (((WebSSOAgent.UniSsoServerRsp)localObject2).comm.packagesize.has()) {
                  this.a.a.put(paramBundle, Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).comm.packagesize.get()));
                }
                l1 = l2;
                if (((WebSSOAgent.UniSsoServerRsp)localObject2).comm.proctime.has()) {
                  l1 = ((WebSSOAgent.UniSsoServerRsp)localObject2).comm.proctime.get();
                }
              }
            }
            localJSONObject.put("ssoRet", 0);
            if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.has()) {
              localJSONObject.put("businessRet", ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get());
            } else {
              localJSONObject.put("businessRet", 0);
            }
            if (((WebSSOAgent.UniSsoServerRsp)localObject2).errmsg.has()) {
              localJSONObject.put("msg", ((WebSSOAgent.UniSsoServerRsp)localObject2).errmsg.get());
            } else {
              localJSONObject.put("msg", "SSO发送成功");
            }
            l2 = l1;
            if (((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.has())
            {
              localJSONObject.put("data", ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get());
              l2 = l1;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.w("HealthStepCounterPlugin", 2, "uniAgent, onReceive, ret success but no data");
            }
            localJSONObject.put("ssoRet", 255);
            localJSONObject.put("businessRet", 0);
            localJSONObject.put("msg", "SSO返回数据包为空");
          }
        }
        else
        {
          paramInt = paramBundle.getInt("extra_result_code");
          if (paramInt != 1001) {
            break label923;
          }
          localJSONObject.put("ssoRet", 201);
          localJSONObject.put("businessRet", 0);
          localJSONObject.put("msg", HardCodeUtil.a(2131903437));
          continue;
          localJSONObject.put("ssoRet", 255);
          localJSONObject.put("businessRet", 0);
          localJSONObject.put("msg", HardCodeUtil.a(2131903428));
          continue;
          localJSONObject.put("ssoRet", 202);
          localJSONObject.put("businessRet", 0);
          localJSONObject.put("msg", HardCodeUtil.a(2131903433));
        }
        paramBundle = new StringBuilder();
        paramBundle.append("result:");
        paramBundle.append(localJSONObject.toString());
        QLog.i("HealthStepCounterPlugin", 1, paramBundle.toString());
        if (this.a.i.get())
        {
          this.a.i.set(false);
          localObject2 = new JSONObject();
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject1;
        JSONObject localJSONObject;
        long l2;
        Object localObject2;
        long l1;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("uniAgent, onReceive, Exception: ");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.e("HealthStepCounterPlugin", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      try
      {
        paramBoolean = TextUtils.isEmpty(this.a.k);
        localObject1 = "";
        if (paramBoolean) {
          paramBundle = "";
        } else {
          paramBundle = this.a.k;
        }
        ((JSONObject)localObject2).put("msg", paramBundle);
        ((JSONObject)localObject2).put("report_result", localJSONObject.toString());
        if (TextUtils.isEmpty(this.a.m)) {
          paramBundle = (Bundle)localObject1;
        } else {
          paramBundle = this.a.m;
        }
        ((JSONObject)localObject2).put("msf_json", paramBundle);
      }
      catch (Exception paramBundle)
      {
        continue;
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("test result:");
        paramBundle.append(((JSONObject)localObject2).toString());
        QLog.i("HealthStepCounterPlugin", 2, paramBundle.toString());
      }
      if (TextUtils.isEmpty(this.a.j)) {
        break;
      }
      this.a.callJs(this.a.j, new String[] { ((JSONObject)localObject2).toString() });
      return;
      WebSSOAgentServlet.d = System.currentTimeMillis();
      l1 = WebSSOAgentServlet.d;
      l1 = WebSSOAgentServlet.a;
      l1 = WebSSOAgentServlet.b;
      l3 = WebSSOAgentServlet.a;
      l4 = WebSSOAgentServlet.c;
      l5 = WebSSOAgentServlet.b;
      l6 = WebSSOAgentServlet.d;
      l7 = WebSSOAgentServlet.c;
      paramBundle = new JSONObject();
      paramBundle.put("packTime", l1 - l3);
      paramBundle.put("SSONetworkTime", l4 - l5);
      paramBundle.put("unpackTime", l6 - l7);
      paramBundle.put("serverProcessTime", l2);
      localJSONObject.put("speedPoint", paramBundle);
      this.a.callJs((String)localObject1, new String[] { localJSONObject.toString() });
      return;
      label923:
      if (paramInt != 1002) {
        if (paramInt != 1013) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.3
 * JD-Core Version:    0.7.0.1
 */