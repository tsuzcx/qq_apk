package com.tencent.mobileqq.loginwelcome;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class WelcomeConfigProcessor
  extends IQConfigProcessor<LoginWelcomeManager.WelcomeIntervalConfig>
{
  @NonNull
  public LoginWelcomeManager.WelcomeIntervalConfig a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldOrDefaultContent");
    }
    return new LoginWelcomeManager.WelcomeIntervalConfig();
  }
  
  @Nullable
  public LoginWelcomeManager.WelcomeIntervalConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1;
    int j;
    int i;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onParsed :");
      ((StringBuilder)localObject1).append(paramArrayOfQConfItem);
      QLog.d("WelcomeConfigProcessor", 2, ((StringBuilder)localObject1).toString());
      if (paramArrayOfQConfItem != null)
      {
        j = paramArrayOfQConfItem.length;
        i = 0;
        while (i < j)
        {
          localObject1 = paramArrayOfQConfItem[i];
          if (localObject1 != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onParsed item: ");
            ((StringBuilder)localObject2).append(((QConfItem)localObject1).jdField_a_of_type_JavaLangString);
            QLog.d("WelcomeConfigProcessor", 2, ((StringBuilder)localObject2).toString());
          }
          i += 1;
        }
      }
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      j = paramArrayOfQConfItem.length;
      i = 0;
      while (i < j)
      {
        localObject2 = paramArrayOfQConfItem[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(((QConfItem)localObject2).jdField_a_of_type_JavaLangString))) {
          try
          {
            localObject1 = new LoginWelcomeManager.WelcomeIntervalConfig();
            localObject2 = new JSONObject(((QConfItem)localObject2).jdField_a_of_type_JavaLangString);
            if (((JSONObject)localObject2).has("popup_url")) {
              ((LoginWelcomeManager.WelcomeIntervalConfig)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("popup_url");
            }
            if (((JSONObject)localObject2).has("fixed_entrance_url")) {
              ((LoginWelcomeManager.WelcomeIntervalConfig)localObject1).b = ((JSONObject)localObject2).getString("fixed_entrance_url");
            }
            if (((JSONObject)localObject2).has("request_interval")) {
              ((LoginWelcomeManager.WelcomeIntervalConfig)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("request_interval");
            }
            return localObject1;
          }
          catch (Throwable localThrowable)
          {
            QLog.e("WelcomeConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void a(LoginWelcomeManager.WelcomeIntervalConfig paramWelcomeIntervalConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "onUpdate");
    }
    if (paramWelcomeIntervalConfig != null) {
      ((LoginWelcomeManager)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).a(paramWelcomeIntervalConfig);
    }
  }
  
  public Class<LoginWelcomeManager.WelcomeIntervalConfig> clazz()
  {
    return LoginWelcomeManager.WelcomeIntervalConfig.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("WelcomeConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed, code = ");
      localStringBuilder.append(paramInt);
      QLog.d("WelcomeConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 454;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.WelcomeConfigProcessor
 * JD-Core Version:    0.7.0.1
 */