package com.tencent.trackrecordlib.g;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.trackrecordlib.core.RecordManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONObject;

public class i
{
  private static Class<?> a;
  private static String b;
  
  static
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          String str1 = "android.view.WindowManagerGlobal";
          a = Class.forName(str1);
          if (Build.VERSION.SDK_INT >= 17)
          {
            b = "sDefaultWindowManager";
            return;
          }
          if (Build.VERSION.SDK_INT >= 13)
          {
            b = "sWindowManager";
            return;
          }
          b = "mWindowManager";
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      String str2 = "android.view.WindowManagerImpl";
    }
  }
  
  public static String a(View paramView)
  {
    try
    {
      paramView = paramView.getResources().getResourceName(paramView.getId());
      return paramView;
    }
    catch (Throwable paramView)
    {
      label14:
      break label14;
    }
    return "";
  }
  
  public static ArrayList<View> a()
  {
    localObject = b();
    localArrayList = new ArrayList();
    View[] arrayOfView = a((View[])localObject);
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = b((View[])localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    try
    {
      a(localArrayList, (ViewGroup)localObject);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          int i;
          a(localArrayList, (ViewGroup)localObject);
          i += 1;
        }
        return localArrayList;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        break label86;
      }
    }
    if (arrayOfView != null)
    {
      i = 0;
      if (i < arrayOfView.length)
      {
        localObject = arrayOfView[i];
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      int i = 0;
      while (i < paramViewGroup.getChildCount())
      {
        View localView = paramViewGroup.getChildAt(i);
        if (localView != null) {
          paramArrayList.add(localView);
        }
        if ((localView instanceof ViewGroup)) {
          a(paramArrayList, (ViewGroup)localView);
        }
        i += 1;
      }
    }
  }
  
  private static View[] a(View[] paramArrayOfView)
  {
    if (paramArrayOfView != null)
    {
      View[] arrayOfView = new View[paramArrayOfView.length];
      int i = 0;
      int k;
      for (int j = 0;; j = k)
      {
        localObject = arrayOfView;
        if (i >= paramArrayOfView.length) {
          break;
        }
        localObject = paramArrayOfView[i];
        k = j;
        if (!g((View)localObject))
        {
          arrayOfView[j] = localObject;
          k = j + 1;
        }
        i += 1;
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  private static View b(View[] paramArrayOfView)
  {
    if (paramArrayOfView == null) {
      return null;
    }
    View[] arrayOfView = new View[paramArrayOfView.length];
    int i = 0;
    int k;
    for (int j = 0; i < paramArrayOfView.length; j = k)
    {
      View localView = paramArrayOfView[i];
      k = j;
      if (g(localView))
      {
        arrayOfView[j] = localView;
        k = j + 1;
      }
      i += 1;
    }
    return c(arrayOfView);
  }
  
  public static String b(View paramView)
  {
    try
    {
      paramView = paramView.getContentDescription().toString();
      return paramView;
    }
    catch (Throwable paramView)
    {
      label12:
      break label12;
    }
    return "";
  }
  
  private static View[] b()
  {
    try
    {
      Object localObject1 = a.getDeclaredField("mViews");
      Object localObject2 = a.getDeclaredField(b);
      ((Field)localObject1).setAccessible(true);
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      if (Build.VERSION.SDK_INT >= 19) {
        return (View[])((ArrayList)((Field)localObject1).get(localObject2)).toArray(new View[0]);
      }
      localObject1 = (View[])((Field)localObject1).get(localObject2);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  private static View c(View[] paramArrayOfView)
  {
    Object localObject1 = null;
    long l1 = 0L;
    int i = 0;
    while (i < paramArrayOfView.length)
    {
      View localView = paramArrayOfView[i];
      Object localObject2 = localObject1;
      long l2 = l1;
      if (localView != null)
      {
        localObject2 = localObject1;
        l2 = l1;
        if (localView.isShown())
        {
          localObject2 = localObject1;
          l2 = l1;
          if (localView.hasWindowFocus())
          {
            localObject2 = localObject1;
            l2 = l1;
            if (localView.getDrawingTime() > l1)
            {
              l2 = localView.getDrawingTime();
              localObject2 = localView;
            }
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
      l1 = l2;
    }
    return localObject1;
  }
  
  public static String c(View paramView)
  {
    boolean bool = paramView instanceof TextView;
    String str = "";
    if (bool) {}
    try
    {
      str = ((TextView)paramView).getText().toString();
      return str;
    }
    catch (Throwable paramView) {}
    return "";
  }
  
  public static String d(View paramView)
  {
    if (paramView != null) {}
    for (;;)
    {
      try
      {
        localObject = paramView.getParent();
        if (!(localObject instanceof ViewGroup)) {
          continue;
        }
        localObject = (ViewGroup)localObject;
        if (((ViewGroup)localObject).getChildCount() >= 10) {
          break label128;
        }
        i = ((ViewGroup)localObject).indexOfChild(paramView);
        paramView = new JSONObject();
        paramView.put("view_type", localObject.getClass().getName());
        paramView.put("view_tag", a((View)localObject));
        paramView.put("view_text", c((View)localObject));
        paramView.put("view_desc", b((View)localObject));
        paramView.put("index", i);
        paramView = paramView.toString();
        return paramView;
      }
      catch (Throwable paramView)
      {
        continue;
      }
      paramView.printStackTrace();
      return "unknown";
      Object localObject = null;
      continue;
      label128:
      int i = -1;
    }
  }
  
  public static String e(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView.getWidth());
    localStringBuilder.append("×");
    localStringBuilder.append(paramView.getHeight());
    return localStringBuilder.toString();
  }
  
  public static String f(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = paramView.getWidth();
    int k = arrayOfInt[1];
    int m = paramView.getHeight();
    paramView = new StringBuilder();
    paramView.append(arrayOfInt[0]);
    paramView.append(",");
    paramView.append(arrayOfInt[1]);
    paramView.append(",");
    paramView.append(i + j);
    paramView.append(",");
    paramView.append(k + m);
    return paramView.toString();
  }
  
  public static boolean g(View paramView)
  {
    boolean bool = false;
    if (paramView == null) {
      return false;
    }
    paramView = paramView.getClass().getName();
    if ((paramView.equals("com.android.internal.policy.impl.PhoneWindow$DecorView")) || (paramView.equals("com.android.internal.policy.impl.MultiPhoneWindow$MultiPhoneDecorView")) || (paramView.equals("com.android.internal.policy.PhoneWindow$DecorView")) || (paramView.equals("com.android.internal.policy.DecorView"))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean h(View paramView)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    if (paramView == null) {
      return false;
    }
    float f2 = paramView.getHeight();
    View localView = i(paramView);
    paramView.getLocationOnScreen(arrayOfInt1);
    if (localView == null) {
      arrayOfInt2[1] = 0;
    } else {
      localView.getLocationOnScreen(arrayOfInt2);
    }
    float f1 = arrayOfInt1[1];
    f2 /= 2.0F;
    if (f1 + f2 > j(paramView)) {
      return false;
    }
    return arrayOfInt1[1] + f2 >= arrayOfInt2[1];
  }
  
  private static View i(View paramView)
  {
    View localView = paramView;
    if (!(paramView instanceof AbsListView))
    {
      localView = paramView;
      if (!(paramView instanceof ScrollView))
      {
        localView = paramView;
        if ((paramView instanceof WebView)) {}
      }
    }
    try
    {
      paramView = i((View)paramView.getParent());
      return paramView;
    }
    catch (Throwable paramView)
    {
      label40:
      break label40;
    }
    localView = null;
    return localView;
  }
  
  private static float j(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView = i(paramView);
    if (paramView == null) {
      return g.a(RecordManager.getInstance().a);
    }
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] + paramView.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.i
 * JD-Core Version:    0.7.0.1
 */