package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GetRedPointInfoReq
  extends BaseReq
{
  public String d = "";
  public String e = "";
  public int f = 1001;
  
  private RedAppInfo a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("path = ");
      localStringBuilder.append(paramString);
      QLog.d("GetRedPointInfoReq getRedPointInfo", 2, localStringBuilder.toString());
    }
    if ("7720.772004".equals(paramString)) {
      paramString = MatchChatMsgUtil.a(paramQQAppInterface, paramString);
    } else {
      paramString = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(paramString);
    }
    return RedTouchUtils.a(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("path = ");
      localStringBuilder.append(paramString);
      QLog.d("GetRedPointInfoReq clearRed", 2, localStringBuilder.toString());
    }
    ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("path = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("actId == ");
      localStringBuilder.append(paramInt);
      QLog.d("GetRedPointInfoReq reportRedInfo", 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      return;
    }
    int i;
    try
    {
      if (paramString.contains("\\.")) {
        i = Integer.parseInt(paramString.split("\\.")[0]);
      } else {
        i = Integer.parseInt(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      i = 0;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramQQAppInterface = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
      paramString = paramQQAppInterface.getAppInfoByPath(paramString);
      localJSONObject.put("service_type", 0);
      localJSONObject.put("actId", paramInt);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localJSONObject.put("service_id", i);
      paramQQAppInterface.onReportBusinessRedTouch(paramString, localJSONObject.toString());
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("path", this.d);
    paramBundle.putInt("act_id", this.f);
    paramBundle.putString("reportPath", this.e);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("cmd");
    if ("getRedInfo".equals(localObject))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cmd = ");
        localStringBuilder.append((String)localObject);
        QLog.d("GetRedPointInfoReq onReceive", 2, localStringBuilder.toString());
      }
      paramQQAppInterface = a(this.d, paramQQAppInterface);
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("redInfoResp", paramQQAppInterface);
      paramBundle.putBundle("keyResponse", (Bundle)localObject);
      super.c(paramBundle);
      return;
    }
    if ("reportRedInfo".equals(localObject))
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("cmd = ");
        paramBundle.append((String)localObject);
        QLog.d("GetRedPointInfoReq onReceive", 2, paramBundle.toString());
      }
      a(paramQQAppInterface, this.d, this.f);
      return;
    }
    if ("clearRedInfo".equals(localObject))
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("cmd = ");
        paramBundle.append((String)localObject);
        QLog.d("GetRedPointInfoReq onReceive", 2, paramBundle.toString());
      }
      a(paramQQAppInterface, this.d);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.d = paramBundle.getString("path");
    this.f = paramBundle.getInt("act_id");
    this.e = paramBundle.getString("reportPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.GetRedPointInfoReq
 * JD-Core Version:    0.7.0.1
 */