package com.tencent.mobileqq.util.privacy;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$Config;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$Config;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "Config", "QQCommon_release"}, k=1, mv={1, 1, 16})
public final class PackageInstallWhiteListConfigProcessor
  extends IQConfigProcessor<PackageInstallWhiteListConfigProcessor.Config>
{
  public static final PackageInstallWhiteListConfigProcessor.Companion a = new PackageInstallWhiteListConfigProcessor.Companion(null);
  
  @NotNull
  public PackageInstallWhiteListConfigProcessor.Config a(int paramInt)
  {
    return new PackageInstallWhiteListConfigProcessor.Config();
  }
  
  @NotNull
  public PackageInstallWhiteListConfigProcessor.Config a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    QLog.d("PackageInstallWhiteListConfigProcessor", 1, "onParsed");
    PackageInstallWhiteListConfigProcessor.Config localConfig = new PackageInstallWhiteListConfigProcessor.Config();
    if (paramArrayOfQConfItem != null)
    {
      int i;
      if (paramArrayOfQConfItem.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((0x1 ^ i) != 0)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfQConfItem, "confFiles[0].content");
        localConfig.a(paramArrayOfQConfItem);
      }
    }
    return localConfig;
  }
  
  public void a(@Nullable PackageInstallWhiteListConfigProcessor.Config paramConfig) {}
  
  @NotNull
  public Class<PackageInstallWhiteListConfigProcessor.Config> clazz()
  {
    return PackageInstallWhiteListConfigProcessor.Config.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 776;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.PackageInstallWhiteListConfigProcessor
 * JD-Core Version:    0.7.0.1
 */