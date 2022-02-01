package com.tencent.theme.font;

import java.lang.reflect.Field;
import java.util.HashSet;

public class MiuiFontHook
  implements IFontHook
{
  private static boolean a = false;
  private static HashSet<String> b;
  
  private HashSet<String> a()
  {
    try
    {
      localField = Class.forName("miui.util.TypefaceUtils$FontsWhiteListHolder").getDeclaredField("mFontsWhiteList");
    }
    catch (Exception localException2)
    {
      Field localField;
      label14:
      label28:
      break label14;
    }
    try
    {
      localField = Class.forName("miui.util.TypefaceUtils").getDeclaredField("mFontsWhiteList");
    }
    catch (Exception localException3)
    {
      break label28;
    }
    localField = null;
    if (localField != null)
    {
      localField.setAccessible(true);
      try
      {
        b = (HashSet)localField.get(null);
        if (b == null)
        {
          b = new HashSet();
          localField.set(null, b);
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    }
    return b;
  }
  
  public boolean hookFont()
  {
    if (a) {
      return false;
    }
    if (b == null) {
      a();
    }
    HashSet localHashSet = b;
    if ((localHashSet != null) && (localHashSet.contains("com.tencent.mobileqq"))) {
      b.remove("com.tencent.mobileqq");
    }
    a = true;
    return a;
  }
  
  public boolean restore()
  {
    if (a) {
      try
      {
        if (b != null) {
          b.add("com.tencent.mobileqq");
        }
        a = false;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return a ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.font.MiuiFontHook
 * JD-Core Version:    0.7.0.1
 */