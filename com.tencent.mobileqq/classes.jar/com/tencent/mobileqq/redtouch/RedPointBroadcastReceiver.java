package com.tencent.mobileqq.redtouch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class RedPointBroadcastReceiver
  extends BroadcastReceiver
{
  private QQAppInterface a = null;
  
  private String a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("RedPointBroadcastReceiver getRedInfo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "qqapp = null");
      }
      return null;
    }
    paramString = ((IRedTouchManager)((QQAppInterface)localObject).getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "appinfo = null");
      }
      return null;
    }
    int k = paramString.iNewFlag.get();
    int j = 0;
    paramString = paramString.red_display_info.red_type_info.get();
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.size() >= 2)
      {
        paramString = (BusinessInfoCheckUpdate.RedTypeInfo)paramString.get(1);
        i = j;
        if (paramString != null) {
          i = paramString.red_type.get();
        }
      }
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("iNewFlag", k);
      paramString.put("type", i);
      paramString = paramString.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "jsonexception");
      }
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("path = ");
      localStringBuilder.append(paramString);
      QLog.d("RedPointBroadcastReceiver clearRed", 2, localStringBuilder.toString());
    }
    ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("path = ");
      paramQQAppInterface.append(paramString);
      QLog.d("RedPointBroadcastReceiver reportRedInfo", 2, paramQQAppInterface.toString());
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
    catch (NumberFormatException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      i = 0;
    }
    paramQQAppInterface = new JSONObject();
    try
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "");
      paramString = localIRedTouchManager.getAppInfoByPath(paramString);
      paramQQAppInterface.put("service_type", 0);
      paramQQAppInterface.put("act_id", paramInt);
      paramQQAppInterface.put("obj_id", "");
      paramQQAppInterface.put("pay_amt", 0);
      paramQQAppInterface.put("service_id", i);
      localIRedTouchManager.onReportBusinessRedTouch(paramString, paramQQAppInterface.toString());
      return;
    }
    catch (JSONException paramQQAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("report redinfo error ");
      paramString.append(paramQQAppInterface);
      QLog.e("RedPointBroadcastReceiver", 1, paramString.toString());
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramContext instanceof QQAppInterface)) {
      this.a = ((QQAppInterface)paramContext);
    }
    String str = paramIntent.getAction();
    if ("com.tencent.redpoint.get".equals(str))
    {
      paramIntent.setAction("com.tencent.redpoint.get.resp");
      if (this.a != null)
      {
        paramIntent.putExtra("redPointResp", a(paramIntent.getStringExtra("path")));
        this.a.getApplication().sendBroadcast(paramIntent);
        return;
      }
      paramIntent.putExtra("redPointResp", "");
      paramContext.getApplication().sendBroadcast(paramIntent);
      return;
    }
    if ("com.tencent.redpoint.report".equals(str))
    {
      if (this.a != null)
      {
        paramContext = paramIntent.getStringExtra("path");
        int i = paramIntent.getIntExtra("actId", 1001);
        a(this.a, paramContext, i);
      }
    }
    else if (("com.tencent.redpoint.clear".equals(str)) && (this.a != null))
    {
      paramContext = paramIntent.getStringExtra("path");
      a(this.a, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedPointBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */