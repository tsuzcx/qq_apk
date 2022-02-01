package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.text.ColorNickText;
import mqq.app.AppRuntime;

public class GuildAtTroopMemberSpan
  extends AtTroopMemberSpan
{
  public GuildAtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, int paramInt1, Paint paramPaint, String paramString3, int paramInt2)
  {
    super(paramContext, paramString1, paramString2, paramInt1, paramPaint, paramString3, paramInt2);
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131166230;
    }
    return 2131166186;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, EditText paramEditText, boolean paramBoolean)
  {
    return a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, "", paramEditText, paramBoolean);
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, EditText paramEditText, int paramInt, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    if ((paramAppRuntime != null) && (paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramEditText == null) {
        return null;
      }
      if (paramEditText.getPaint() != null)
      {
        i = paramContext.getResources().getColor(a(paramBoolean));
        paramEditText.getPaint().setColor(i);
      }
      i = paramEditText.getWidth();
      j = paramEditText.getPaddingLeft();
      k = paramEditText.getPaddingRight();
      if (paramBoolean) {
        paramInt = 0;
      }
    }
    try
    {
      paramAppRuntime = new GuildAtTroopMemberSpan(paramContext, paramString2, paramString3, i - j - k, paramEditText.getPaint(), paramString4, paramInt);
    }
    catch (OutOfMemoryError paramAppRuntime)
    {
      label125:
      break label125;
    }
    paramAppRuntime = null;
    if (paramAppRuntime == null) {
      return null;
    }
    paramContext = paramAppRuntime.a;
    paramString1 = new SpannableString(new ColorNickText(paramContext, 16).a());
    paramString1.setSpan(paramAppRuntime, 0, paramContext.length(), 33);
    return paramString1;
    return null;
  }
  
  public static SpannableString a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, EditText paramEditText, boolean paramBoolean)
  {
    return a(paramAppRuntime, paramContext, paramString1, paramString2, paramString3, paramString4, paramEditText, 0, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.GuildAtTroopMemberSpan
 * JD-Core Version:    0.7.0.1
 */