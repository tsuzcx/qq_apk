package com.tencent.mobileqq.config.business.avatar;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean;", "()V", "clazz", "Ljava/lang/Class;", "isNeedCompressed", "", "isNeedStoreLargeFile", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/avatar/DynamicAvatarConfBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DynamicAvatarConfProcessor
  extends IQConfigProcessor<DynamicAvatarConfBean>
{
  public static final DynamicAvatarConfProcessor.Companion a = new DynamicAvatarConfProcessor.Companion(null);
  
  @NotNull
  public DynamicAvatarConfBean a(int paramInt)
  {
    return new DynamicAvatarConfBean();
  }
  
  @Nullable
  public DynamicAvatarConfBean a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem != null)
    {
      int i;
      if (paramArrayOfQConfItem.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0)
      {
        String str = paramArrayOfQConfItem[0].b;
        if (QLog.isColorLevel())
        {
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("DynamicAvatar.[onParsed] type=");
          paramArrayOfQConfItem.append(type());
          paramArrayOfQConfItem.append(", content = ");
          paramArrayOfQConfItem.append(str);
          QLog.i("DynamicAvatarConfProcessor", 2, paramArrayOfQConfItem.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          paramArrayOfQConfItem = (DynamicAvatarConfBean.DynamicAvatarConfig)null;
          try
          {
            DynamicAvatarConfBean.DynamicAvatarConfig localDynamicAvatarConfig = (DynamicAvatarConfBean.DynamicAvatarConfig)QStorage.a(str, DynamicAvatarConfBean.DynamicAvatarConfig.class);
            paramArrayOfQConfItem = localDynamicAvatarConfig;
          }
          catch (QStorageInstantiateException localQStorageInstantiateException)
          {
            QLog.e("DynamicAvatarConfProcessor", 1, "readJsonOrXml failed", (Throwable)localQStorageInstantiateException);
          }
          Intrinsics.checkExpressionValueIsNotNull(str, "content");
          return new DynamicAvatarConfBean(str, paramArrayOfQConfItem);
        }
      }
    }
    return null;
  }
  
  public void a(@Nullable DynamicAvatarConfBean paramDynamicAvatarConfBean) {}
  
  @NotNull
  public Class<DynamicAvatarConfBean> clazz()
  {
    return DynamicAvatarConfBean.class;
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
    return 726;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor
 * JD-Core Version:    0.7.0.1
 */