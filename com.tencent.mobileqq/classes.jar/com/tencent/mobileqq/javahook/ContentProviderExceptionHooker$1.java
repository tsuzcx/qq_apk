package com.tencent.mobileqq.javahook;

import android.content.pm.PackageItemInfo;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.util.Utils;
import java.lang.reflect.Field;

final class ContentProviderExceptionHooker$1
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {
      return;
    }
    try
    {
      Object localObject = paramMethodHookParam.args[0].getClass().getDeclaredField("holder").get(paramMethodHookParam.args[0]);
      if (localObject == null) {
        return;
      }
      localObject = localObject.getClass().getDeclaredField("info").get(localObject);
      if (localObject == null) {
        return;
      }
      localObject = (String)PackageItemInfo.class.getDeclaredField("name").get(localObject);
      if (localObject == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMethodHookParam.throwable.getMessage());
      localStringBuilder.append(" -- ContentProvider : ");
      localStringBuilder.append((String)localObject);
      paramMethodHookParam.throwable = new RuntimeException(localStringBuilder.toString(), paramMethodHookParam.throwable);
      return;
    }
    catch (IllegalAccessException paramMethodHookParam)
    {
      Utils.a(paramMethodHookParam);
      return;
    }
    catch (IllegalArgumentException paramMethodHookParam)
    {
      Utils.a(paramMethodHookParam);
      return;
    }
    catch (NoSuchFieldException paramMethodHookParam)
    {
      Utils.a(paramMethodHookParam);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ContentProviderExceptionHooker.1
 * JD-Core Version:    0.7.0.1
 */