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
        if (Build.VERSION.SDK_INT < 17) {
          break label58;
        }
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
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      b = "mWindowManager";
      return;
      label58:
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
    catch (Throwable paramView) {}
    return "";
  }
  
  public static ArrayList<View> a()
  {
    Object localObject = b();
    ArrayList localArrayList = new ArrayList();
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
      label49:
      int i;
      if (arrayOfView != null) {
        i = 0;
      }
      for (;;)
      {
        if (i < arrayOfView.length)
        {
          localObject = arrayOfView[i];
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        try
        {
          a(localArrayList, (ViewGroup)localObject);
          label83:
          i += 1;
          continue;
          return localArrayList;
        }
        catch (Throwable localThrowable1)
        {
          break label83;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      break label49;
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
    int i = 0;
    if (paramArrayOfView != null)
    {
      View[] arrayOfView = new View[paramArrayOfView.length];
      int k;
      for (int j = 0; i < paramArrayOfView.length; j = k)
      {
        View localView = paramArrayOfView[i];
        k = j;
        if (!g(localView))
        {
          arrayOfView[j] = localView;
          k = j + 1;
        }
        i += 1;
      }
      return arrayOfView;
    }
    return null;
  }
  
  private static View b(View[] paramArrayOfView)
  {
    int i = 0;
    if (paramArrayOfView == null) {
      return null;
    }
    View[] arrayOfView = new View[paramArrayOfView.length];
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
    catch (Throwable paramView) {}
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
    int i = 0;
    Object localObject = null;
    long l = 0L;
    if (i < paramArrayOfView.length)
    {
      View localView = paramArrayOfView[i];
      if ((localView == null) || (!localView.isShown()) || (!localView.hasWindowFocus()) || (localView.getDrawingTime() <= l)) {
        break label69;
      }
      l = localView.getDrawingTime();
      localObject = localView;
    }
    label69:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public static String c(View paramView)
  {
    String str = "";
    if ((paramView instanceof TextView)) {}
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
    int i = -1;
    if (paramView != null) {}
    for (;;)
    {
      try
      {
        localObject = paramView.getParent();
        if (!(localObject instanceof ViewGroup)) {
          break label121;
        }
        localObject = (ViewGroup)localObject;
        if (((ViewGroup)localObject).getChildCount() < 10) {
          i = ((ViewGroup)localObject).indexOfChild(paramView);
        }
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
        Object localObject;
        paramView.printStackTrace();
        return "unknown";
      }
      localObject = null;
      continue;
      label121:
      paramView = "unknown";
    }
  }
  
  public static String e(View paramView)
  {
    return paramView.getWidth() + "×" + paramView.getHeight();
  }
  
  public static String f(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = paramView.getWidth();
    int k = arrayOfInt[1];
    int m = paramView.getHeight();
    return arrayOfInt[0] + "," + arrayOfInt[1] + "," + (i + j) + "," + (k + m);
  }
  
  public static boolean g(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return false;
      paramView = paramView.getClass().getName();
    } while ((!paramView.equals("com.android.internal.policy.impl.PhoneWindow$DecorView")) && (!paramView.equals("com.android.internal.policy.impl.MultiPhoneWindow$MultiPhoneDecorView")) && (!paramView.equals("com.android.internal.policy.PhoneWindow$DecorView")) && (!paramView.equals("com.android.internal.policy.DecorView")));
    return true;
  }
  
  public static boolean h(View paramView)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    if (paramView == null) {}
    for (;;)
    {
      return false;
      float f = paramView.getHeight();
      View localView = i(paramView);
      paramView.getLocationOnScreen(arrayOfInt1);
      if (localView == null) {
        arrayOfInt2[1] = 0;
      }
      while ((arrayOfInt1[1] + f / 2.0F <= j(paramView)) && (arrayOfInt1[1] + f / 2.0F >= arrayOfInt2[1]))
      {
        return true;
        localView.getLocationOnScreen(arrayOfInt2);
      }
    }
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
      localView = i((View)paramView.getParent());
      return localView;
    }
    catch (Throwable paramView) {}
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.i
 * JD-Core Version:    0.7.0.1
 */