package me.ele.uetool.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import me.ele.uetool.base.Application;
import me.ele.uetool.base.Element;

public class ViewKnife
{
  public static int dip2px(float paramFloat)
  {
    return (int)(Resources.getSystem().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static Drawable getDrawable(@DrawableRes int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21) {
      return Application.getApplicationContext().getResources().getDrawable(paramInt, null);
    }
    return Application.getApplicationContext().getResources().getDrawable(paramInt);
  }
  
  public static String getIdString(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramView.getId();
    if ((i != -1) && (!isViewIdGenerated(i))) {
      switch (0xFF000000 & i)
      {
      }
    }
    for (;;)
    {
      try
      {
        paramView = getResouces().getResourcePackageName(i);
        String str1 = getResouces().getResourceTypeName(i);
        String str2 = getResouces().getResourceEntryName(i);
        localStringBuilder.append(paramView);
        localStringBuilder.append(":");
        localStringBuilder.append(str1);
        localStringBuilder.append("/");
        localStringBuilder.append(str2);
      }
      catch (Resources.NotFoundException paramView)
      {
        paramView.printStackTrace();
        localStringBuilder.append(Integer.toHexString(i));
        continue;
      }
      return localStringBuilder.toString();
      paramView = "app";
      continue;
      paramView = "android";
      continue;
      localStringBuilder.append("NO_ID");
    }
  }
  
  public static int[] getMargin(Element paramElement)
  {
    Rect localRect = paramElement.getRect();
    paramElement = paramElement.getParentElement();
    if (paramElement != null)
    {
      paramElement = paramElement.getRect();
      return new int[] { localRect.left - paramElement.left, localRect.top - paramElement.top };
    }
    return null;
  }
  
  public static Resources getResouces()
  {
    return Application.getApplicationContext().getResources();
  }
  
  private static View getTargetDecorView(Activity paramActivity, View paramView)
  {
    Context localContext2 = paramView.getContext();
    Context localContext1 = localContext2;
    if (localContext2 == paramActivity) {
      return paramView;
    }
    while (((localContext1 instanceof ContextWrapper)) && (!(localContext1 instanceof Activity)))
    {
      localContext2 = ((ContextWrapper)localContext1).getBaseContext();
      if (localContext2 == null) {
        return null;
      }
      localContext1 = localContext2;
      if (localContext2 == paramActivity) {
        return paramView;
      }
    }
    return null;
  }
  
  private static boolean isViewIdGenerated(int paramInt)
  {
    return ((0xFF000000 & paramInt) == 0) && ((0xFFFFFF & paramInt) != 0);
  }
  
  public static int px2dip(float paramFloat)
  {
    return (int)(paramFloat / Resources.getSystem().getDisplayMetrics().density + 0.5F);
  }
  
  public static View tryGetTheFrontView(Activity paramActivity)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = paramActivity.getWindowManager();
        Object localObject3;
        if (Build.VERSION.SDK_INT <= 16)
        {
          localObject2 = Class.forName("android.view.WindowManagerImpl$CompatModeWrapper").getDeclaredField("mWindowManager");
          ((Field)localObject2).setAccessible(true);
          localObject3 = Class.forName("android.view.WindowManagerImpl").getDeclaredField("mViews");
          ((Field)localObject3).setAccessible(true);
          localObject2 = Arrays.asList((View[])((Field)localObject3).get(((Field)localObject2).get(localObject1)));
          i = ((List)localObject2).size() - 1;
          if (i >= 0)
          {
            localObject3 = getTargetDecorView(paramActivity, (View)((List)localObject2).get(i));
            if (localObject3 == null) {
              break label390;
            }
            return localObject3;
          }
        }
        Object localObject2 = Reflect28Util.getDeclaredField(Reflect28Util.forName("android.view.WindowManagerImpl"), "mGlobal");
        ((Field)localObject2).setAccessible(true);
        if (Build.VERSION.SDK_INT <= 23)
        {
          localObject3 = Class.forName("android.view.WindowManagerGlobal").getDeclaredField("mViews");
          ((Field)localObject3).setAccessible(true);
          localObject1 = (List)((Field)localObject3).get(((Field)localObject2).get(localObject1));
          i = ((List)localObject1).size() - 1;
          if (i >= 0)
          {
            localObject2 = getTargetDecorView(paramActivity, (View)((List)localObject1).get(i));
            if (localObject2 == null) {
              break label397;
            }
            return localObject2;
          }
        }
        else
        {
          localObject3 = Reflect28Util.getDeclaredField(Reflect28Util.forName("android.view.WindowManagerGlobal"), "mRoots");
          ((Field)localObject3).setAccessible(true);
          if (Build.VERSION.SDK_INT >= 19)
          {
            localObject1 = (List)((Field)localObject3).get(((Field)localObject2).get(localObject1));
            i = ((List)localObject1).size() - 1;
            if (i >= 0)
            {
              localObject2 = Reflect28Util.forName("android.view.ViewRootImpl");
              Object localObject4 = ((List)localObject1).get(i);
              Field localField = Reflect28Util.getDeclaredField((Class)localObject2, "mWindowAttributes");
              localField.setAccessible(true);
              localObject2 = Reflect28Util.getDeclaredField((Class)localObject2, "mView");
              ((Field)localObject2).setAccessible(true);
              localObject3 = (View)((Field)localObject2).get(localObject4);
              localObject2 = localObject3;
              if (((WindowManager.LayoutParams)localField.get(localObject4)).getTitle().toString().contains(paramActivity.getClass().getName())) {
                break label388;
              }
              localObject2 = localObject3;
              if (getTargetDecorView(paramActivity, (View)localObject3) != null) {
                break label388;
              }
              i -= 1;
              continue;
            }
          }
          else
          {
            localObject1 = Arrays.asList((Object[])((Field)localObject3).get(((Field)localObject2).get(localObject1)));
            continue;
          }
        }
        return localObject2;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        localObject2 = paramActivity.getWindow().peekDecorView();
      }
      label388:
      label390:
      i -= 1;
      continue;
      label397:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.util.ViewKnife
 * JD-Core Version:    0.7.0.1
 */