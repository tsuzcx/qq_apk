package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.lite_now_biz.permission.PermissionCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class NowAppJs$2
  implements PermissionCallback
{
  NowAppJs$2(NowAppJs paramNowAppJs, Map paramMap) {}
  
  public void a(List<String> paramList, int paramInt)
  {
    DialogUtil.a(NowAppJs.access$100(this.b), 230, "", HardCodeUtil.a(2131894145), HardCodeUtil.a(2131887648), HardCodeUtil.a(2131891076), new NowAppJs.2.1(this), new NowAppJs.2.2(this)).show();
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    try
    {
      paramArrayOfString = (String)this.a.get("callback");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("code", "0");
      ((JSONObject)localObject).put("msg", "");
      NowAppJs.access$200(this.b).callJs(paramArrayOfString, new String[] { ((JSONObject)localObject).toString() });
      NowAppJs.access$302(this.b, true);
      this.b.changeMicrophone(this.a);
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPermissionGranted has error: ");
      ((StringBuilder)localObject).append(paramArrayOfString);
      QLog.e("NowAppJs", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs.2
 * JD-Core Version:    0.7.0.1
 */