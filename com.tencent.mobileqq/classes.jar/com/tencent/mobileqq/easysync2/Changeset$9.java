package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.StringReplacement;
import java.util.regex.Matcher;

final class Changeset$9
  implements StringReplacement
{
  public String a(Matcher paramMatcher)
  {
    Object localObject = this.a.a(Changeset.b(paramMatcher.group(1)));
    if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
      return paramMatcher.group();
    }
    if ((localObject instanceof Integer))
    {
      paramMatcher = new StringBuilder();
      paramMatcher.append('*');
      paramMatcher.append(Changeset.a(((Integer)localObject).intValue()));
      return paramMatcher.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.9
 * JD-Core Version:    0.7.0.1
 */