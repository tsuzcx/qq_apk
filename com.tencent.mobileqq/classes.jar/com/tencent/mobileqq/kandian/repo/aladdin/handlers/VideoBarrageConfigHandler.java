package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJBarrageConfigSp;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/handlers/VideoBarrageConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "p0", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoBarrageConfigHandler
  extends SimpleConfigHandler
{
  public static final VideoBarrageConfigHandler.Companion a = new VideoBarrageConfigHandler.Companion(null);
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    for (;;)
    {
      try
      {
        paramString = AladdinParseUtils.a(paramString);
        paramString = new GsonBuilder().create().toJson(paramString);
        if (paramString == null) {
          break label121;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onReceiveConfig configJson:");
          localStringBuilder.append(paramString);
          QLog.d("VideoBarrageConfigHandler", 2, localStringBuilder.toString());
        }
        RIJBarrageConfigSp.b(paramString);
      }
      catch (UnsupportedEncodingException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[PersonalHomePageConfigHandler]: onReceiveConfig Error in:");
        localStringBuilder.append(paramString);
        QLog.e("VideoBarrageConfigHandler", 2, localStringBuilder.toString());
      }
      return true;
      label121:
      paramString = "";
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJBarrageConfigSp.b("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.VideoBarrageConfigHandler
 * JD-Core Version:    0.7.0.1
 */