package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaSusAutoPlayConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ViolaSusAutoPlayConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[onReceiveConfig] ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("ViolaSusAutoPlayConfigHandler", 1, ((StringBuilder)localObject1).toString());
    try
    {
      paramString = AladdinParseUtils.a(paramString);
      localObject1 = paramString.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = (String)paramString.get(str);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[onReceiveConfig] key=");
          localStringBuilder.append(str);
          localStringBuilder.append(", value=");
          localStringBuilder.append((String)localObject2);
          QLog.d("ViolaSusAutoPlayConfigHandler", 2, localStringBuilder.toString());
          if (TextUtils.equals(str, "autoplay_disable")) {
            RIJViolaSusAutoPlayConfigSp.a(Integer.parseInt((String)localObject2));
          }
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("key: ");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(" of value is null");
          QLog.d("ViolaSusAutoPlayConfigHandler", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("error in parse video_feeds_Type config: ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.d("ViolaSusAutoPlayConfigHandler", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJViolaSusAutoPlayConfigSp.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaSusAutoPlayConfigHandler
 * JD-Core Version:    0.7.0.1
 */