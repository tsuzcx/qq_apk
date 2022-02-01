package com.tencent.mobileqq.javahook;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.util.Utils;
import java.lang.reflect.Field;

class ChildAccessibilitySortHooker$MyHookMethodCallback
  implements HookMethodCallback
{
  @TargetApi(14)
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable != null)
    {
      if (!(paramMethodHookParam.throwable instanceof IllegalArgumentException)) {
        return;
      }
      AccessibilityNodeInfo localAccessibilityNodeInfo = (AccessibilityNodeInfo)paramMethodHookParam.args[0];
      if (localAccessibilityNodeInfo == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(" -- className=");
      localStringBuilder.append(paramMethodHookParam.thisObject.getClass().getName());
      View localView = (View)paramMethodHookParam.thisObject;
      Context localContext = localView.getContext();
      Object localObject1 = localContext;
      if ("android.view.ContextThemeWrapper".equals(localContext.getClass().getName()))
      {
        try
        {
          localObject1 = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mBase");
          ((Field)localObject1).setAccessible(true);
          Object localObject3 = ((Field)localObject1).get(localView.getContext());
          localObject1 = localContext;
          if (localObject3 == null) {
            break label196;
          }
          localObject1 = localContext;
          if (!(localObject3 instanceof Context)) {
            break label196;
          }
          localObject1 = (Context)localObject3;
        }
        catch (IllegalAccessException localIllegalAccessException) {}catch (IllegalArgumentException localIllegalArgumentException)
        {
          break label172;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          break label181;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          break label190;
        }
        Utils.a(localClassNotFoundException);
        localObject2 = localContext;
        break label196;
        label172:
        Utils.a((Throwable)localObject2);
        localObject2 = localContext;
        break label196;
        label181:
        Utils.a((Throwable)localObject2);
        localObject2 = localContext;
        break label196;
        label190:
        Utils.a((Throwable)localObject2);
        localObject2 = localContext;
      }
      label196:
      localStringBuilder.append(", context=");
      localStringBuilder.append(localObject2.getClass().getName());
      Object localObject2 = localView.getRootView();
      if (localObject2 != null)
      {
        localStringBuilder.append(", rootView=");
        localStringBuilder.append(localObject2.getClass().getName());
      }
      localStringBuilder.append(", view ID=");
      localStringBuilder.append(localView.getId());
      if (Build.VERSION.SDK_INT >= 14)
      {
        localStringBuilder.append(" -- AccessibilityNodeInfo: className=");
        localStringBuilder.append(localAccessibilityNodeInfo.getClassName());
        localStringBuilder.append(", contentDescription=");
        localStringBuilder.append(localAccessibilityNodeInfo.getContentDescription());
        localStringBuilder.append(", text=");
        localStringBuilder.append(localAccessibilityNodeInfo.getText());
        if (Build.VERSION.SDK_INT >= 18)
        {
          localStringBuilder.append(", viewIdResourceName=");
          localStringBuilder.append(localAccessibilityNodeInfo.getViewIdResourceName());
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramMethodHookParam.throwable.getMessage());
      ((StringBuilder)localObject2).append(localStringBuilder.toString());
      paramMethodHookParam.throwable = new RuntimeException(((StringBuilder)localObject2).toString(), paramMethodHookParam.throwable);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.ChildAccessibilitySortHooker.MyHookMethodCallback
 * JD-Core Version:    0.7.0.1
 */