package com.tencent.mobileqq.config;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DeepCleanConfigProcessor
  extends IQConfigProcessor<DeepCleanConfigProcessor.DeepCleanConfigBean>
{
  public static String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = (DeepCleanConfigProcessor.DeepCleanConfigBean)QConfigManager.a().a(678);
    if (localObject1 != null) {
      if (paramBoolean) {
        localObject1 = DeepCleanConfigProcessor.DeepCleanConfigBean.a((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject1);
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramContext.getString(2131691550);
      }
      return localObject2;
      if (a(paramContext))
      {
        localObject1 = DeepCleanConfigProcessor.DeepCleanConfigBean.b((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject1);
      }
      else
      {
        int i = ((Integer)SharedPreUtils.a(paramContext, "", "key_deep_clean_show_time", Integer.valueOf(0))).intValue();
        a(paramContext, i);
        switch (i)
        {
        default: 
          localObject1 = DeepCleanConfigProcessor.DeepCleanConfigBean.d((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject1);
          break;
        case 0: 
          localObject1 = DeepCleanConfigProcessor.DeepCleanConfigBean.b((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject1);
          break;
        case 1: 
          localObject1 = DeepCleanConfigProcessor.DeepCleanConfigBean.c((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject1);
          continue;
          localObject1 = "";
        }
      }
    }
  }
  
  public static void a()
  {
    SharedPreUtils.a(BaseApplication.getContext(), "", true, "key_deep_clean_user_click", Boolean.valueOf(true));
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    if (paramInt < 2) {
      SharedPreUtils.a(paramContext, "", true, "key_deep_clean_show_time", Integer.valueOf(paramInt + 1));
    }
  }
  
  public static boolean a()
  {
    DeepCleanConfigProcessor.DeepCleanConfigBean localDeepCleanConfigBean = (DeepCleanConfigProcessor.DeepCleanConfigBean)QConfigManager.a().a(678);
    return (localDeepCleanConfigBean != null) && (localDeepCleanConfigBean.a());
  }
  
  private static boolean a(Context paramContext)
  {
    return ((Boolean)SharedPreUtils.a(paramContext, "", "key_deep_clean_user_click", Boolean.valueOf(false))).booleanValue();
  }
  
  @NonNull
  public DeepCleanConfigProcessor.DeepCleanConfigBean a(int paramInt)
  {
    return new DeepCleanConfigProcessor.DeepCleanConfigBean();
  }
  
  @Nullable
  public DeepCleanConfigProcessor.DeepCleanConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeepCleanConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("DeepCleanConfigProcessor", 2, "onParsed, content:" + paramArrayOfQConfItem);
      }
      return DeepCleanConfigProcessor.DeepCleanConfigBean.a(paramArrayOfQConfItem);
    }
    return new DeepCleanConfigProcessor.DeepCleanConfigBean();
  }
  
  public void a(DeepCleanConfigProcessor.DeepCleanConfigBean paramDeepCleanConfigBean)
  {
    SharedPreUtils.a(BaseApplication.getContext(), "", true, "key_deep_clean_show_time", Integer.valueOf(0));
    SharedPreUtils.a(BaseApplication.getContext(), "", true, "key_deep_clean_user_click", Boolean.valueOf(false));
    if (QLog.isColorLevel()) {
      QLog.d("DeepCleanConfigProcessor", 2, "DeepCleanConfigProcessor onUpdate");
    }
  }
  
  public Class<DeepCleanConfigProcessor.DeepCleanConfigBean> clazz()
  {
    return DeepCleanConfigProcessor.DeepCleanConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 678;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.DeepCleanConfigProcessor
 * JD-Core Version:    0.7.0.1
 */