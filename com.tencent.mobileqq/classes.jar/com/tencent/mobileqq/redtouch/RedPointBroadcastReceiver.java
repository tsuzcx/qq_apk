package com.tencent.mobileqq.redtouch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import axho;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class RedPointBroadcastReceiver
  extends BroadcastReceiver
{
  private QQAppInterface a;
  
  private String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "path = " + paramString);
    }
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "qqapp = null");
      }
      return null;
    }
    paramString = ((axho)this.a.getManager(36)).a(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPointBroadcastReceiver getRedInfo", 2, "appinfo = null");
      }
      return null;
    }
    int j = paramString.iNewFlag.get();
    paramString = paramString.red_display_info.red_type_info.get();
    if ((paramString != null) && (paramString.size() >= 2))
    {
      paramString = (BusinessInfoCheckUpdate.RedTypeInfo)paramString.get(1);
      if (paramString == null) {}
    }
    for (int i = paramString.red_type.get();; i = 0)
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("iNewFlag", j);
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
        return null;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointBroadcastReceiver clearRed", 2, "path = " + paramString);
    }
    ((axho)paramQQAppInterface.getManager(36)).b(paramString);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedPointBroadcastReceiver reportRedInfo", 2, "path = " + paramString);
    }
    try
    {
      if (paramString.contains("\\.")) {}
      for (i = Integer.parseInt(paramString.split("\\.")[0]);; i = Integer.parseInt(paramString))
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          paramString = ((axho)paramQQAppInterface.getManager(36)).a(paramString);
          localJSONObject.put("service_type", 0);
          localJSONObject.put("act_id", paramInt);
          localJSONObject.put("obj_id", "");
          localJSONObject.put("pay_amt", 0);
          localJSONObject.put("service_id", i);
          ((axho)paramQQAppInterface.getManager(36)).c(paramString, localJSONObject.toString());
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        int i = 0;
      }
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
      }
    }
    do
    {
      do
      {
        return;
        paramIntent.putExtra("redPointResp", "");
        paramContext.getApplication().sendBroadcast(paramIntent);
        return;
        if (!"com.tencent.redpoint.report".equals(str)) {
          break;
        }
      } while (this.a == null);
      paramContext = paramIntent.getStringExtra("path");
      int i = paramIntent.getIntExtra("act_id", 1001);
      a(this.a, paramContext, i);
      return;
    } while ((!"com.tencent.redpoint.clear".equals(str)) || (this.a == null));
    paramContext = paramIntent.getStringExtra("path");
    a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedPointBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */