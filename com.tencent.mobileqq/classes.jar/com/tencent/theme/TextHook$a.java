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
    long l = SystemClock.uptimeMillis();
    String str = TextHook.a();
    if ((TextUtils.isEmpty(str)) || (!TextHook.isSupportProcess(paramVarArgs[0]))) {
      return null;
    }
    try
    {
      if (this.a.mTypefaceMap.get(str) != null)
      {
        TextHook.a(this.a, (Typeface)this.a.mTypefaceMap.get(str));
        paramVarArgs = paramVarArgs[0];
        return paramVarArgs;
      }
    }
    finally {}
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      Typeface localTypeface = Typeface.createFromFile(new File(str));
      this.a.mTypefaceMap.put(str, localTypeface);
      TextHook.a(this.a, localTypeface);
      i.a("TextHook", 1, "SwitchFontTask load fontFile cost:" + (SystemClock.uptimeMillis() - l));
      paramVarArgs = paramVarArgs[0];
      return paramVarArgs;
    }
    return null;
  }
  
  protected void a(Context paramContext)
  {
    if (paramContext != null) {
      this.a.update(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.TextHook.a
 * JD-Core Version:    0.7.0.1
 */