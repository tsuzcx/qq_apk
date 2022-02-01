package com.tencent.mobileqq.guild.api.impl;

import android.text.Editable;
import com.tencent.mobileqq.guild.api.IGuildTextUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuildTextUtilImpl
  implements IGuildTextUtil
{
  public CharSequence filterTailSpace(Editable paramEditable)
  {
    Matcher localMatcher = Pattern.compile("[\\n ]+$").matcher(paramEditable);
    Object localObject = paramEditable;
    if (localMatcher.find()) {
      localObject = paramEditable.subSequence(0, localMatcher.start());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildTextUtilImpl
 * JD-Core Version:    0.7.0.1
 */