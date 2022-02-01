package com.tencent.shadow.core.runtime.skin.loader;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Array;

public class SkinResLoader
{
  private static final ColorStateList COLORSTATELIST_NULL;
  private static final int COLOR_NULL = 0;
  private static final int DIMEN_NULL = 0;
  private static final Drawable DRAWABLE_NULL;
  private static final String RES_COLOR = "color";
  private static final String RES_DIMEN = "dimen";
  private static final String RES_DRAWABLE = "drawable";
  private static final String TAG = "SkinResLoader";
  
  public static int getColor(int paramInt, String paramString)
  {
    if (paramInt <= 0)
    {
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getColor invalid resId : ");
      ((StringBuilder)localObject).append(paramInt);
      Log.e(paramString, ((StringBuilder)localObject).toString());
      return 0;
    }
    Resources localResources2 = ContextHolder.getContext().getResources();
    Resources localResources1 = SkinManager.getsInstance().getSkinResource();
    String str = SkinManager.getsInstance().getPackageName();
    try
    {
      i = localResources2.getColor(paramInt);
      if (localResources1 == null) {
        return i;
      }
      localObject = paramString;
      if (paramString != null) {}
    }
    catch (Resources.NotFoundException paramString)
    {
      int i;
      int j;
      label124:
      break label164;
    }
    try
    {
      localObject = localResources2.getResourceEntryName(paramInt);
      j = localResources1.getIdentifier((String)localObject, "color", str);
      if (j <= 0) {
        return i;
      }
      j = localResources1.getColor(j);
      return j;
    }
    catch (Resources.NotFoundException paramString)
    {
      break label124;
    }
    paramString = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getColor skin NotFoundException resId : ");
    ((StringBuilder)localObject).append(paramInt);
    Log.e(paramString, ((StringBuilder)localObject).toString());
    return i;
    label164:
    paramString = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getColor default NotFoundException resId : ");
    ((StringBuilder)localObject).append(paramInt);
    Log.e(paramString, ((StringBuilder)localObject).toString());
    return 0;
  }
  
  public static int getColor(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    ContextHolder.getContext().getResources();
    Resources localResources = SkinManager.getsInstance().getSkinResource();
    String str = SkinManager.getsInstance().getPackageName();
    int i = getColorByName(localResources, paramString, str);
    if (i == 0) {
      return getColorByName(localResources, paramString, str);
    }
    return i;
  }
  
  private static int getColorByName(Resources paramResources, String paramString1, String paramString2)
  {
    if (paramResources == null) {
      return 0;
    }
    try
    {
      int i = paramResources.getIdentifier(paramString1, "color", paramString2);
      if (i <= 0) {
        return 0;
      }
      i = paramResources.getColor(i);
      return i;
    }
    catch (Resources.NotFoundException paramResources)
    {
      label29:
      break label29;
    }
    Log.i(TAG, "getColor skin NotFoundException resId ");
    return 0;
  }
  
  public static ColorStateList getColorStateList(int paramInt, String paramString)
  {
    if (paramInt <= 0)
    {
      paramString = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getColorStateList invalid resId : ");
      ((StringBuilder)localObject1).append(paramInt);
      Log.e(paramString, ((StringBuilder)localObject1).toString());
      return COLORSTATELIST_NULL;
    }
    Resources localResources2 = ContextHolder.getContext().getResources();
    Resources localResources1 = SkinManager.getsInstance().getSkinResource();
    String str = SkinManager.getsInstance().getPackageName();
    try
    {
      localObject2 = localResources2.getColorStateList(paramInt);
      if (localResources1 == null) {
        return localObject2;
      }
      localObject1 = paramString;
      if (paramString != null) {}
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Object localObject2;
      int i;
      label122:
      break label159;
    }
    try
    {
      localObject1 = localResources2.getResourceEntryName(paramInt);
      i = localResources1.getIdentifier((String)localObject1, "color", str);
      if (i <= 0) {
        return localObject2;
      }
      paramString = localResources1.getColorStateList(i);
      return paramString;
    }
    catch (Resources.NotFoundException paramString)
    {
      break label122;
    }
    paramString = TAG;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getColorStateList skin NotFoundException resId : ");
    ((StringBuilder)localObject1).append(paramInt);
    Log.e(paramString, ((StringBuilder)localObject1).toString());
    return localObject2;
    label159:
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getColorStateList try to getColor， default NotFoundException resId : ");
    ((StringBuilder)localObject2).append(paramInt);
    Log.w((String)localObject1, ((StringBuilder)localObject2).toString());
    return makeColorStateList(getColor(paramInt, paramString));
  }
  
  public static float getDimenPx(int paramInt)
  {
    if (paramInt <= 0)
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDimenPx invalid resId : ");
      ((StringBuilder)localObject2).append(paramInt);
      Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
      return 0.0F;
    }
    Object localObject1 = ContextHolder.getContext().getResources();
    Object localObject2 = SkinManager.getsInstance().getSkinResource();
    String str = SkinManager.getsInstance().getPackageName();
    try
    {
      i = ((Resources)localObject1).getDimensionPixelSize(paramInt);
      if (localObject2 == null) {
        return i;
      }
    }
    catch (Resources.NotFoundException localNotFoundException1)
    {
      int i;
      int j;
      label113:
      break label154;
    }
    try
    {
      j = ((Resources)localObject2).getIdentifier(((Resources)localObject1).getResourceEntryName(paramInt), "dimen", str);
      if (j <= 0) {
        return i;
      }
      j = ((Resources)localObject2).getDimensionPixelSize(j);
      return j;
    }
    catch (Resources.NotFoundException localNotFoundException2)
    {
      break label113;
    }
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getDimenPx skin NotFoundException resId : ");
    ((StringBuilder)localObject2).append(paramInt);
    Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
    return i;
    label154:
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getDimenPx default NotFoundException resId : ");
    ((StringBuilder)localObject2).append(paramInt);
    Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
    return 0.0F;
  }
  
  public static Drawable getDrawable(int paramInt, String paramString)
  {
    if (paramInt <= 0)
    {
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDrawable invalid resId : ");
      ((StringBuilder)localObject).append(paramInt);
      Log.e(paramString, ((StringBuilder)localObject).toString());
      return DRAWABLE_NULL;
    }
    Resources localResources2 = ContextHolder.getContext().getResources();
    Resources localResources1 = SkinManager.getsInstance().getSkinResource();
    String str = SkinManager.getsInstance().getPackageName();
    try
    {
      localDrawable = localResources2.getDrawable(paramInt);
      if (localResources1 == null) {
        return localDrawable;
      }
      localObject = paramString;
      if (paramString != null) {}
    }
    catch (Resources.NotFoundException paramString)
    {
      Drawable localDrawable;
      int i;
      label138:
      break label175;
    }
    try
    {
      localObject = localResources2.getResourceEntryName(paramInt);
      i = localResources1.getIdentifier((String)localObject, "drawable", str);
      if (i <= 0) {
        return localDrawable;
      }
      if (Build.VERSION.SDK_INT < 22) {
        return localResources1.getDrawable(i);
      }
      paramString = localResources1.getDrawable(i, null);
      return paramString;
    }
    catch (Resources.NotFoundException paramString)
    {
      break label138;
    }
    paramString = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDrawable skin NotFoundException resId : ");
    ((StringBuilder)localObject).append(paramInt);
    Log.i(paramString, ((StringBuilder)localObject).toString());
    return localDrawable;
    label175:
    paramString = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDrawable default NotFoundException resId : ");
    ((StringBuilder)localObject).append(paramInt);
    Log.e(paramString, ((StringBuilder)localObject).toString());
    return DRAWABLE_NULL;
  }
  
  public static Drawable getDrawable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return DRAWABLE_NULL;
    }
    Resources localResources = ContextHolder.getContext().getResources();
    Drawable localDrawable = getDrawableByName(SkinManager.getsInstance().getSkinResource(), paramString, SkinManager.getsInstance().getPackageName());
    if (localDrawable == null) {
      return getDrawableByName(localResources, paramString, ContextHolder.getContext().getPackageName());
    }
    return localDrawable;
  }
  
  private static Drawable getDrawableByName(Resources paramResources, String paramString1, String paramString2)
  {
    if (paramResources == null) {
      return null;
    }
    try
    {
      int i = paramResources.getIdentifier(paramString1, "drawable", paramString2);
      if (i <= 0) {
        return null;
      }
      if (Build.VERSION.SDK_INT < 22) {
        return paramResources.getDrawable(i);
      }
      paramResources = paramResources.getDrawable(i, null);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      label44:
      break label44;
    }
    Log.i(TAG, "getDrawable skin NotFoundException resId ");
    return null;
  }
  
  private static ColorStateList makeColorStateList(int paramInt)
  {
    return new ColorStateList((int[][])Array.newInstance(Integer.TYPE, new int[] { 1, 1 }), new int[] { paramInt });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.skin.loader.SkinResLoader
 * JD-Core Version:    0.7.0.1
 */