package com.tencent.theme;

import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;

class TextHook$a
  extends AsyncTask<Context, String, Context>
{
  private TextHook$a(TextHook paramTextHook) {}
  
  protected Context a(Context... paramVarArgs)
  {
    try
    {
      long l = SystemClock.uptimeMillis();
      Object localObject = TextHook.a();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!TextHook.isSupportProcess(paramVarArgs[0])) {
          return null;
        }
        try
        {
          if (this.a.mTypefaceMap.get(localObject) != null)
          {
            TextHook.a(this.a, (Typeface)this.a.mTypefaceMap.get(localObject));
            paramVarArgs = paramVarArgs[0];
            return paramVarArgs;
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
          {
            Typeface localTypeface = Typeface.createFromFile(new File((String)localObject));
            this.a.mTypefaceMap.put(localObject, localTypeface);
            TextHook.a(this.a, localTypeface);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("SwitchFontTask load fontFile cost:");
            ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - l);
            h.a("TextHook", 1, ((StringBuilder)localObject).toString());
            paramVarArgs = paramVarArgs[0];
            return paramVarArgs;
          }
          return null;
        }
        finally {}
      }
      return null;
    }
    catch (Exception paramVarArgs) {}
    return null;
  }
  
  protected void a(Context paramContext)
  {
    if (paramContext != null) {
      this.a.update(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.TextHook.a
 * JD-Core Version:    0.7.0.1
 */