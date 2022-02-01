package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ResetAllConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] id=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", version=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", content=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ResetAllConfigHandler", 2, ((StringBuilder)localObject).toString());
    Map localMap = AladdinParseUtils.a(paramString);
    Iterator localIterator = localMap.keySet().iterator();
    localObject = "";
    paramString = "";
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = (String)localMap.get(str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str2);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str1);
      QLog.d("ResetAllConfigHandler", 2, localStringBuilder.toString());
      if (TextUtils.equals(str2, "reset_kandian_configuration")) {
        localObject = str1;
      } else if (TextUtils.equals(str2, "reset_version")) {
        paramString = str1;
      }
    }
    if ((TextUtils.equals("1", (CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        paramInt1 = Integer.valueOf(paramString).intValue();
        SharedPreUtils.p(BaseApplicationImpl.getApplication(), paramInt1, RIJQQAppInterfaceUtil.a());
        return true;
      }
      catch (NumberFormatException paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onReceiveConfig] e = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("ResetAllConfigHandler", 1, ((StringBuilder)localObject).toString());
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onWipeConfig] id=");
    localStringBuilder.append(paramInt);
    QLog.d("ResetAllConfigHandler", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.ResetAllConfigHandler
 * JD-Core Version:    0.7.0.1
 */