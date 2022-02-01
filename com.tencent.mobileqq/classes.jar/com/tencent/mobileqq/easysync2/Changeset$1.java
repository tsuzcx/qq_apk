package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.StringReplacement;
import java.util.List;
import java.util.regex.Matcher;

final class Changeset$1
  implements StringReplacement
{
  Changeset$1(List paramList, AttribPool paramAttribPool) {}
  
  public String a(Matcher paramMatcher)
  {
    this.a.add(this.b.a(Changeset.b(paramMatcher.group(1))));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.1
 * JD-Core Version:    0.7.0.1
 */