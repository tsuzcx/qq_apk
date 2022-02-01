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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length != 0) {
        break label134;
      }
      i = 1;
      if (i != 0) {
        break label139;
      }
    }
    label134:
    label139:
    for (int i = 1;; i = 0)
    {
      localObject1 = localObject2;
      String str;
      if (i != 0)
      {
        str = paramArrayOfQConfItem[0].a;
        if (QLog.isColorLevel()) {
          QLog.i("DynamicAvatarConfProcessor", 2, "DynamicAvatar.[onParsed] type=" + type() + ", content = " + str);
        }
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)str)) {
          paramArrayOfQConfItem = (DynamicAvatarConfBean.DynamicAvatarConfig)null;
        }
      }
      try
      {
        localObject1 = (DynamicAvatarConfBean.DynamicAvatarConfig)QStorage.a(str, DynamicAvatarConfBean.DynamicAvatarConfig.class);
        paramArrayOfQConfItem = (QConfItem[])localObject1;
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.e("DynamicAvatarConfProcessor", 1, "readJsonOrXml failed", (Throwable)localQStorageInstantiateException);
        }
      }
      Intrinsics.checkExpressionValueIsNotNull(str, "content");
      localObject1 = new DynamicAvatarConfBean(str, paramArrayOfQConfItem);
      return localObject1;
      i = 0;
      break;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor
 * JD-Core Version:    0.7.0.1
 */