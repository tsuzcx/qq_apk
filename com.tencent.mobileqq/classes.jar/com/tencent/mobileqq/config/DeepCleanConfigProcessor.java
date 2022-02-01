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
    Object localObject = (DeepCleanConfigProcessor.DeepCleanConfigBean)QConfigManager.b().b(678);
    String str = "";
    if (localObject != null) {
      if (paramBoolean)
      {
        str = DeepCleanConfigProcessor.DeepCleanConfigBean.a((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject);
      }
      else if (a(paramContext))
      {
        str = DeepCleanConfigProcessor.DeepCleanConfigBean.b((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject);
      }
      else
      {
        int i = ((Integer)SharedPreUtils.a(paramContext, "", "key_deep_clean_show_time", Integer.valueOf(0))).intValue();
        a(paramContext, i);
        if (i != 0)
        {
          if (i != 1) {
            str = DeepCleanConfigProcessor.DeepCleanConfigBean.d((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject);
          } else {
            str = DeepCleanConfigProcessor.DeepCleanConfigBean.c((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject);
          }
        }
        else {
          str = DeepCleanConfigProcessor.DeepCleanConfigBean.b((DeepCleanConfigProcessor.DeepCleanConfigBean)localObject);
        }
      }
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = paramContext.getString(2131888429);
    }
    return localObject;
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    if (paramInt < 2) {
      SharedPreUtils.a(paramContext, "", true, "key_deep_clean_show_time", Integer.valueOf(paramInt + 1));
    }
  }
  
  public static boolean a()
  {
    DeepCleanConfigProcessor.DeepCleanConfigBean localDeepCleanConfigBean = (DeepCleanConfigProcessor.DeepCleanConfigBean)QConfigManager.b().b(678);
    return (localDeepCleanConfigBean != null) && (localDeepCleanConfigBean.a());
  }
  
  private static boolean a(Context paramContext)
  {
    return ((Boolean)SharedPreUtils.a(paramContext, "", "key_deep_clean_user_click", Boolean.valueOf(false))).booleanValue();
  }
  
  public static void b()
  {
    SharedPreUtils.a(BaseApplication.getContext(), "", true, "key_deep_clean_user_click", Boolean.valueOf(true));
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
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("DeepCleanConfigProcessor", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.DeepCleanConfigProcessor
 * JD-Core Version:    0.7.0.1
 */