package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class NativeTextContentConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onReceiveConfig] ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("NativeProteusBidConfigHandler", 1, ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = AladdinParseUtils.a(paramString);
      Object localObject2 = ((Map)localObject1).keySet();
      paramString = new JSONObject();
      paramInt1 = 0;
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str1 = (String)((Iterator)localObject2).next();
        String str2 = (String)((Map)localObject1).get(str1);
        if (!TextUtils.isEmpty(str2))
        {
          paramString.put(str1, str2);
          paramInt1 = 1;
        }
      }
      if (paramInt1 != 0)
      {
        localObject1 = RIJQQAppInterfaceUtil.e();
        if (localObject1 != null)
        {
          RIJShowKanDianTabSp.a((AppRuntime)localObject1, "local_kd_native_main_text_style", paramString.toString());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[onReceiveConfig],content: ");
          ((StringBuilder)localObject1).append(paramString.toString());
          QLog.d("NativeProteusBidConfigHandler", 1, ((StringBuilder)localObject1).toString());
        }
      }
      return true;
    }
    catch (Exception paramString) {}
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      RIJShowKanDianTabSp.a(localAppRuntime, "local_kd_native_main_text_style", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.NativeTextContentConfigHandler
 * JD-Core Version:    0.7.0.1
 */