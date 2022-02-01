package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WormholeConfigHandler
  extends SimpleConfigHandler
{
  private static void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update wormhole value: ");
    localStringBuilder.append(paramInt);
    QLog.d("WormholeConfigHandler", 0, localStringBuilder.toString());
    RIJSPUtils.a("wormhole_open", Integer.valueOf(paramInt));
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (((Integer)RIJSPUtils.a("wormhole_open", Integer.valueOf(0))).intValue() == 1) {
      bool = true;
    }
    return bool;
  }
  
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
    QLog.d("WormholeConfigHandler", 0, ((StringBuilder)localObject).toString());
    try
    {
      paramString = AladdinParseUtils.a(paramString);
      localObject = paramString.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)paramString.get(str1);
        if (TextUtils.equals(str1, "open")) {
          a(Integer.parseInt(str2));
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parse wormhole error: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.d("WormholeConfigHandler", 0, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.WormholeConfigHandler
 * JD-Core Version:    0.7.0.1
 */