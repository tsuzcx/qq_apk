package com.tencent.mobileqq.mini.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/config/FileMaterialConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/mini/config/FileMaterialConfig;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/mini/config/FileMaterialConfig;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialConfigProcessor
  extends IQConfigProcessor<FileMaterialConfig>
{
  private static final int CONFIG_ID = 758;
  public static final FileMaterialConfigProcessor.Companion Companion = new FileMaterialConfigProcessor.Companion(null);
  private static final String TAG = "FileMaterialConfigProcessor";
  
  @NotNull
  public Class<FileMaterialConfig> clazz()
  {
    return FileMaterialConfig.class;
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
  public FileMaterialConfig migrateOldOrDefaultContent(int paramInt)
  {
    return new FileMaterialConfig();
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public FileMaterialConfig onParsed(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    FileMaterialConfig localFileMaterialConfig = new FileMaterialConfig();
    Object localObject2 = null;
    if (paramArrayOfQConfItem != null) {
      paramArrayOfQConfItem = (QConfItem)ArraysKt.firstOrNull(paramArrayOfQConfItem);
    } else {
      paramArrayOfQConfItem = null;
    }
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = (CharSequence)paramArrayOfQConfItem.b;
      int i;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject1 = paramArrayOfQConfItem.b;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "confFile.content");
        localFileMaterialConfig.parse((String)localObject1);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onParsed: cntLength: ");
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem.b;
      localObject1 = localObject2;
      if (paramArrayOfQConfItem != null) {
        localObject1 = Integer.valueOf(paramArrayOfQConfItem.length());
      }
    }
    localStringBuilder.append(localObject1);
    QLog.d("FileMaterialConfigProcessor", 2, localStringBuilder.toString());
    return localFileMaterialConfig;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed: ");
    localStringBuilder.append(paramInt);
    QLog.e("FileMaterialConfigProcessor", 2, localStringBuilder.toString());
  }
  
  public void onUpdate(@Nullable FileMaterialConfig paramFileMaterialConfig)
  {
    QLog.i("FileMaterialConfigProcessor", 2, "onUpdate");
  }
  
  public int type()
  {
    return 758;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.config.FileMaterialConfigProcessor
 * JD-Core Version:    0.7.0.1
 */