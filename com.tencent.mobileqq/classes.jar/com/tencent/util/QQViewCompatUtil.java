package com.tencent.util;

import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;

public class QQViewCompatUtil
{
  public static Object a(View paramView)
  {
    return ReflectionUtil.a(paramView, "android.view.View", "mParent", null);
  }
  
  public static void a(View paramView, TypedArray paramTypedArray)
  {
    ReflectionUtil.a(paramView, "android.view.View", "initializeScrollbars", new Class[] { TypedArray.class }, new Object[] { paramTypedArray });
  }
  
  public static void a(ViewGroup paramViewGroup, int paramInt)
  {
    ReflectionUtil.a(paramViewGroup, "android.view.ViewGroup", "offsetChildrenTopAndBottom", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static boolean a(View paramView)
  {
    return ((Boolean)ReflectionUtil.a(paramView, "android.view.View", "includeForAccessibility", null, null)).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.QQViewCompatUtil
 * JD-Core Version:    0.7.0.1
 */