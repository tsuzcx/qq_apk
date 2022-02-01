package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/handlers/ViolaVideoFeedsConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaVideoFeedsConfigHandler
  extends SimpleConfigHandler
{
  public static final ViolaVideoFeedsConfigHandler.Companion a = new ViolaVideoFeedsConfigHandler.Companion(null);
  
  @JvmStatic
  @NotNull
  public static final String a()
  {
    return a.a();
  }
  
  @JvmStatic
  public static final boolean a()
  {
    return a.a();
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    return a.a(paramInt);
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    try
    {
      paramString = AladdinParseUtils.a(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "configs");
      paramString = paramString.entrySet().iterator();
      Object localObject;
      while (paramString.hasNext())
      {
        localObject = (Map.Entry)paramString.next();
        if ("from_source".equals(((Map.Entry)localObject).getKey())) {
          RIJSPUtils.a("viola_video_feeds_config", ((Map.Entry)localObject).getValue());
        } else if ("videofeeds_version".equals(((Map.Entry)localObject).getKey())) {
          RIJSPUtils.a("viola_video_feeds_version", ((Map.Entry)localObject).getValue());
        } else if ("ingore_native".equals(((Map.Entry)localObject).getKey())) {
          RIJSPUtils.a("viola_video_ingore_native", ((Map.Entry)localObject).getValue());
        }
      }
      return true;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ViolaVideoFeedsConfigHandler]: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("ViolaVideoFeedsConfigHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJSPUtils.a("viola_video_feeds_config", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaVideoFeedsConfigHandler
 * JD-Core Version:    0.7.0.1
 */