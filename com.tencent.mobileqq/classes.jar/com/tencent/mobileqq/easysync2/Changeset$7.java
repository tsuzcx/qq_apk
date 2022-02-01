package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.StringReplacement;
import java.util.regex.Matcher;

final class Changeset$7
  implements StringReplacement
{
  Changeset$7(AttribPool paramAttribPool1, AttribPool paramAttribPool2) {}
  
  public String a(Matcher paramMatcher)
  {
    int i = Changeset.a(paramMatcher.group(1));
    paramMatcher = this.a.a(i);
    if (paramMatcher == null) {
      return "";
    }
    i = this.b.a(paramMatcher);
    return '*' + Changeset.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.7
 * JD-Core Version:    0.7.0.1
 */