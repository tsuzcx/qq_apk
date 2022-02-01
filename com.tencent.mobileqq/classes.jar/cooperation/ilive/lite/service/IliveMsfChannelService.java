package cooperation.ilive.lite.service;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginType;
import com.tencent.falco.utils.HexUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.MsfChannelService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class IliveMsfChannelService
  extends MsfChannelService
{
  private SharedPreferences a = BaseApplicationImpl.getContext().getSharedPreferences("Live_Login", 4);
  
  private LoginInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.uid = paramString.optLong("uid");
      localLoginInfo.tinyid = paramString.optLong("tinyId");
      localLoginInfo.a2 = HexUtil.hexStr2Bytes(paramString.optString("a2"));
      localLoginInfo.openId = paramString.optString("openId");
      localLoginInfo.access_token = paramString.optString("accessToken");
      localLoginInfo.loginType = LoginType.QQ;
      return localLoginInfo;
    }
    catch (Throwable paramString)
    {
      QLog.e("IliveMsfChannelService", 1, "parseJsonFromData error ", paramString);
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_login_data_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    return localStringBuilder.toString();
  }
  
  private String b(LoginInfo paramLoginInfo)
  {
    if (paramLoginInfo == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uid", paramLoginInfo.uid);
      localJSONObject.put("tinyId", paramLoginInfo.tinyid);
      localJSONObject.put("a2", HexUtil.bytesToHexString(paramLoginInfo.a2));
      localJSONObject.put("openId", paramLoginInfo.openId);
      localJSONObject.put("accessToken", paramLoginInfo.access_token);
      localJSONObject.put("businessUid", paramLoginInfo.businessUid);
    }
    catch (Throwable paramLoginInfo)
    {
      QLog.e("IliveMsfChannelService", 1, "getJsonFromLoginInfo error ", paramLoginInfo);
      paramLoginInfo.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  protected LoginInfo a()
  {
    String str = this.a.getString(b(), "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSaveLoginInfo json = ");
      localStringBuilder.append(str);
      QLog.i("IliveMsfChannelService", 2, localStringBuilder.toString());
    }
    return a(str);
  }
  
  protected void a(LoginInfo paramLoginInfo)
  {
    ThreadManager.executeOnFileThread(new IliveMsfChannelService.1(this, paramLoginInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveMsfChannelService
 * JD-Core Version:    0.7.0.1
 */