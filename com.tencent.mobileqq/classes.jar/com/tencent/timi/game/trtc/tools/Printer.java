package com.tencent.timi.game.trtc.tools;

import android.text.SpannableStringBuilder;
import com.tencent.timi.game.utils.Logger;

public class Printer
{
  public static void a(String paramString, Object... paramVarArgs)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("");
    int i = 0;
    while (i < paramVarArgs.length)
    {
      if (i > 0) {
        localSpannableStringBuilder.append("_");
      }
      String str;
      if (paramVarArgs[i] != null) {
        str = paramVarArgs[i].toString();
      } else {
        str = "null";
      }
      localSpannableStringBuilder.append(str);
      i += 1;
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(paramString);
    paramVarArgs.append(":");
    paramVarArgs.append(localSpannableStringBuilder.toString());
    Logger.c("TRTCRoom", paramVarArgs.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.Printer
 * JD-Core Version:    0.7.0.1
 */