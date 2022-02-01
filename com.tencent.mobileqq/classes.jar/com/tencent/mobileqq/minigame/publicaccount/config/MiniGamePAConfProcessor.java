package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/minigame/publicaccount/config/MiniGamePAConfBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePAConfProcessor
  extends IQConfigProcessor<MiniGamePAConfBean>
{
  private static final int CONFIG_ID = 741;
  public static final MiniGamePAConfProcessor.Companion Companion = new MiniGamePAConfProcessor.Companion(null);
  private static final String TAG = "MiniGamePAConfProcessor";
  
  @JvmStatic
  @NotNull
  public static final MiniGamePAConfBean loadConfig()
  {
    return Companion.loadConfig();
  }
  
  @NotNull
  public Class<MiniGamePAConfBean> clazz()
  {
    return MiniGamePAConfBean.class;
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
  public MiniGamePAConfBean migrateOldOrDefaultContent(int paramInt)
  {
    return new MiniGamePAConfBean();
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniGamePAConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  @Nullable
  public MiniGamePAConfBean onParsed(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
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
        break label30;
      }
    }
    int i = 1;
    label30:
    if (i != 0)
    {
      QLog.i("MiniGamePAConfProcessor", 1, "onParsed fail, confFiles is null");
      return null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("miniGame config onParsed = ");
      localStringBuilder.append(paramArrayOfQConfItem[0].b);
      QLog.d("MiniGamePAConfProcessor", 2, localStringBuilder.toString());
    }
    paramArrayOfQConfItem = MiniGamePAConfBean.Companion.convertFromJSONObject(paramArrayOfQConfItem[0].b);
    if (paramArrayOfQConfItem == null) {
      QLog.e("MiniGamePAConfProcessor", 1, "miniGame config onParsed config is null!");
    }
    return paramArrayOfQConfItem;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("MiniGamePAConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onUpdate(@Nullable MiniGamePAConfBean paramMiniGamePAConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(String.valueOf(paramMiniGamePAConfBean));
      QLog.d("MiniGamePAConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 741;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfProcessor
 * JD-Core Version:    0.7.0.1
 */