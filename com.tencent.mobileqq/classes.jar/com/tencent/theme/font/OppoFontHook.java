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
    if (this.c != null) {}
    try
    {
      this.b = ((Typeface[])this.c.get(null));
      Object localObject = Typeface.class.getDeclaredField("sDefaults");
      ((Field)localObject).setAccessible(true);
      localObject = (Typeface[])((Field)localObject).get(null);
      this.c.set(null, localObject);
      label82:
      a = true;
      return a;
    }
    catch (Exception localException)
    {
      break label82;
    }
  }
  
  public boolean restore()
  {
    if ((!a) || (this.b == null) || (this.c == null)) {}
    for (;;)
    {
      return false;
      try
      {
        this.c.set(null, this.b);
        a = false;
        label38:
        if (a) {
          continue;
        }
        return true;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label38;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.font.OppoFontHook
 * JD-Core Version:    0.7.0.1
 */