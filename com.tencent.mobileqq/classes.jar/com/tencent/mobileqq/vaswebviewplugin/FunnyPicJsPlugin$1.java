package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

class FunnyPicJsPlugin$1
  implements BusinessObserver
{
  FunnyPicJsPlugin$1(FunnyPicJsPlugin paramFunnyPicJsPlugin, String paramString1, JSONObject paramJSONObject, int paramInt, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("extra_data");
      if (paramBundle != null)
      {
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramBundle);
        if (((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.has())
        {
          paramBundle = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get()).getJSONArray("rstList");
          if (paramBundle.length() > 0)
          {
            paramBundle = paramBundle.getJSONObject(0);
            localObject2 = paramBundle.optString("appid");
            String str = paramBundle.optString("itemid");
            localObject1 = paramBundle.optString("authRst");
            if (("0".equals(localObject1)) && ("10".equals(localObject2)) && (this.val$pkgStr.equals(str)))
            {
              this.this$0.mReqBundle.clear();
              this.this$0.mReqBundle.putString("jsonContent", this.val$json.toString());
              this.this$0.mReqBundle.putInt("action", this.val$action);
              localObject1 = DataFactory.a("ipc_funnypic_add", this.val$innerCallBackId, this.this$0.mOnRemoteResp.key, this.this$0.mReqBundle);
              FunnyPicJsPlugin.access$001(this.this$0, (Bundle)localObject1, true, true);
              if (!QLog.isColorLevel()) {
                return;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("authRst->");
              ((StringBuilder)localObject1).append(paramBundle);
              QLog.i("FunnyPicJsPlugin", 2, ((StringBuilder)localObject1).toString());
              return;
            }
            paramBundle = new JSONObject();
            paramBundle.put("result", 1);
            paramBundle.put("authRst", localObject1);
            localObject1 = this.this$0;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.val$innerCallBackId);
            ((StringBuilder)localObject2).append("(");
            ((StringBuilder)localObject2).append(paramBundle.toString());
            ((StringBuilder)localObject2).append(");");
            FunnyPicJsPlugin.access$101((FunnyPicJsPlugin)localObject1, ((StringBuilder)localObject2).toString());
            return;
          }
        }
      }
      paramBundle = new JSONObject();
      paramBundle.put("result", 1);
      Object localObject1 = this.this$0;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.val$innerCallBackId);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(paramBundle.toString());
      ((StringBuilder)localObject2).append(");");
      FunnyPicJsPlugin.access$201((FunnyPicJsPlugin)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FunnyPicJsPlugin", 2, paramBundle.getMessage());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */