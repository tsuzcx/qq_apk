package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJHomePageConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HomePageConfigHandler
  extends SimpleConfigHandler
{
  public static String a = "HomePageConfigHandler";
  
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
    paramString = AladdinParseUtils.a(paramString);
    localObject1 = paramString.keySet();
    try
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        String str = (String)paramString.get(localObject2);
        if (TextUtils.equals((CharSequence)localObject2, "rij_person_info_page_use_viola")) {
          RIJHomePageConfigSp.a(Integer.parseInt(str));
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJHomePageConfigSp.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.HomePageConfigHandler
 * JD-Core Version:    0.7.0.1
 */