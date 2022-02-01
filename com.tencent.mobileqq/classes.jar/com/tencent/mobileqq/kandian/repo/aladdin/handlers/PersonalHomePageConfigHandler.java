package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJPersonalHomePageConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/handlers/PersonalHomePageConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PersonalHomePageConfigHandler
  extends SimpleConfigHandler
{
  public static final PersonalHomePageConfigHandler.Companion a = new PersonalHomePageConfigHandler.Companion(null);
  
  public PersonalHomePageConfigHandler()
  {
    RIJPersonalHomePageConfigSp.a();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    try
    {
      localObject = AladdinParseUtils.a(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "configs");
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ("personal_page_url".equals(localEntry.getKey()))
        {
          RIJPersonalHomePageConfigSp.a(URLDecoder.decode((String)localEntry.getValue(), "UTF-8"));
          RIJPersonalHomePageConfigSp.a();
        }
      }
      if (QLog.isDebugVersion())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceiveConfig: content=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("PersonalHomePageConfigHandler", 2, ((StringBuilder)localObject).toString());
      }
      Aladdin.getConfig(paramInt1).update(paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[PersonalHomePageConfigHandler]: URLDecoder Error in:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("PersonalHomePageConfigHandler", 2, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJPersonalHomePageConfigSp.a("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.PersonalHomePageConfigHandler
 * JD-Core Version:    0.7.0.1
 */