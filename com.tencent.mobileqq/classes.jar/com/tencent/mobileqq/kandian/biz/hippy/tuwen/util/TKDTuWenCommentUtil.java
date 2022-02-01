package com.tencent.mobileqq.kandian.biz.hippy.tuwen.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;

public class TKDTuWenCommentUtil
{
  private static final String TAG = "TKDTuWenCommentUtil";
  private static Boolean subUseHippy;
  private static Boolean useHippy;
  
  private static boolean findView(View paramView, Class<?> paramClass, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramBoolean)
      {
        if (paramView.getClass() == paramClass) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
      }
      else {
        paramBoolean = paramClass.isInstance(paramView);
      }
      if (paramBoolean) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isAllZero(@NonNull double... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i] != 0.0D) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isCommentSwitchOn()
  {
    Object localObject = useHippy;
    boolean bool2 = false;
    if (localObject == null)
    {
      if (Aladdin.getConfig(412).getIntegerFromString("tuwen_comment_hippy_switch", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      useHippy = Boolean.valueOf(bool1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("useHippy=");
    ((StringBuilder)localObject).append(useHippy);
    QLog.d("TKDTuWenCommentUtil", 1, ((StringBuilder)localObject).toString());
    localObject = useHippy;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Boolean)localObject).booleanValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isSubCommentSwitchOn()
  {
    Object localObject = subUseHippy;
    boolean bool2 = false;
    if (localObject == null)
    {
      if (Aladdin.getConfig(412).getIntegerFromString("tuwen_sub_comment_hippy_switch", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      subUseHippy = Boolean.valueOf(bool1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("subUseHippy=");
    ((StringBuilder)localObject).append(subUseHippy);
    QLog.d("TKDTuWenCommentUtil", 1, ((StringBuilder)localObject).toString());
    localObject = subUseHippy;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Boolean)localObject).booleanValue())
      {
        bool1 = bool2;
        if (isCommentSwitchOn()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static <T extends View> T rFindView(View paramView, Class<T> paramClass)
  {
    return rFindView(paramView, paramClass, false);
  }
  
  public static <T extends View> T rFindView(View paramView, Class<T> paramClass, boolean paramBoolean)
  {
    if (findView(paramView, paramClass, paramBoolean)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = rFindView(paramView.getChildAt(i), paramClass, paramBoolean);
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil
 * JD-Core Version:    0.7.0.1
 */