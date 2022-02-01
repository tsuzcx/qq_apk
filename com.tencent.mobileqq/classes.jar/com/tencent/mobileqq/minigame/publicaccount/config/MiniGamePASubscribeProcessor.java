package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePASubscribeProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePASubscribeConfBean;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePASubscribeConfBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePASubscribeProcessor
  extends IQConfigProcessor<MiniGamePASubscribeConfBean>
{
  private static final int CONFIG_ID = 762;
  public static final MiniGamePASubscribeProcessor.Companion Companion = new MiniGamePASubscribeProcessor.Companion(null);
  private static final String TAG = "MiniGamePASubscribeProcessor";
  
  @JvmStatic
  @NotNull
  public static final MiniGamePASubscribeConfBean loadConfig()
  {
    return Companion.loadConfig();
  }
  
  @NotNull
  public Class<MiniGamePASubscribeConfBean> clazz()
  {
    return MiniGamePASubscribeConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NotNull
  public MiniGamePASubscribeConfBean migrateOldOrDefaultContent(int paramInt)
  {
    return new MiniGamePASubscribeConfBean(false);
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniGamePASubscribeProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  @Nullable
  public MiniGamePASubscribeConfBean onParsed(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool = true;
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        i = 0;
        break label32;
      }
    }
    int i = 1;
    label32:
    if (i != 0)
    {
      QLog.i("MiniGamePASubscribeProcessor", 1, "onParsed fail, confFiles is null");
      return null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("miniGame config onParsed = ");
      localStringBuilder.append(paramArrayOfQConfItem[0].b);
      QLog.d("MiniGamePASubscribeProcessor", 2, localStringBuilder.toString());
    }
    if (new JSONObject(paramArrayOfQConfItem[0].b).optInt("minigame_pa_subscribe", 0) != 1) {
      bool = false;
    }
    return new MiniGamePASubscribeConfBean(bool);
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("MiniGamePASubscribeProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onUpdate(@Nullable MiniGamePASubscribeConfBean paramMiniGamePASubscribeConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(String.valueOf(paramMiniGamePASubscribeConfBean));
      QLog.d("MiniGamePASubscribeProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 762;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePASubscribeProcessor
 * JD-Core Version:    0.7.0.1
 */