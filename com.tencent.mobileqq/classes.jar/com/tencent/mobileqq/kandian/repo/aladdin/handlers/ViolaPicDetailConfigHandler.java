package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaPicDetailConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ViolaPicDetailConfigHandler
  extends SimpleConfigHandler
{
  public static String a = "ViolaPicDetailConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onReceiveConfig] id=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", version=");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", content=");
    ((StringBuilder)localObject2).append(paramString);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    localObject1 = AladdinParseUtils.a(paramString);
    localObject2 = ((Map)localObject1).keySet();
    try
    {
      localObject2 = ((Set)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        String str = (String)((Map)localObject1).get(localObject3);
        if (TextUtils.equals((CharSequence)localObject3, "viola_pic_detail_switch")) {
          RIJViolaPicDetailConfigSp.a(Integer.parseInt(str));
        }
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[onReceiveConfig] id=");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append(", version=");
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append(", content=");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(" , error= ");
      ((StringBuilder)localObject3).append(localThrowable.getMessage());
      QLog.e((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJViolaPicDetailConfigSp.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaPicDetailConfigHandler
 * JD-Core Version:    0.7.0.1
 */