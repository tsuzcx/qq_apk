package com.tencent.theme.font;

import android.graphics.Typeface;
import java.lang.reflect.Field;

public class OppoFontHook
  implements IFontHook
{
  private static boolean a;
  private Typeface[] b;
  private Field c;
  
  private Field a()
  {
    Object localObject = null;
    try
    {
      Field localField = Class.forName("oppo.content.res.OppoFontUtils").getDeclaredField("sCurrentTypefaces");
      localObject = localField;
      localField.setAccessible(true);
      return localField;
    }
    catch (Exception localException) {}
    return localObject;
  }
  
  public boolean hookFont()
  {
    if (a) {
      return false;
    }
    if (this.c == null) {
      this.c = a();
    }
    Object localObject = this.c;
    if (localObject != null) {}
    try
    {
      this.b = ((Typeface[])((Field)localObject).get(null));
      localObject = Typeface.class.getDeclaredField("sDefaults");
      ((Field)localObject).setAccessible(true);
      localObject = (Typeface[])((Field)localObject).get(null);
      this.c.set(null, localObject);
      label81:
      a = true;
      return a;
    }
    catch (Exception localException)
    {
      break label81;
    }
  }
  
  public boolean restore()
  {
    Typeface[] arrayOfTypeface;
    Field localField;
    if (a)
    {
      arrayOfTypeface = this.b;
      if (arrayOfTypeface != null)
      {
        localField = this.c;
        if (localField == null) {
          return false;
        }
      }
    }
    try
    {
      localField.set(null, arrayOfTypeface);
      a = false;
      label36:
      return a ^ true;
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.font.OppoFontHook
 * JD-Core Version:    0.7.0.1
 */