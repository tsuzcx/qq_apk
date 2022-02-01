package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.StringReplacement;
import com.tencent.mobileqq.easysync2.utils.Utils;
import com.tencent.util.Pair;
import java.util.List;
import java.util.regex.Matcher;

final class Changeset$13
  implements StringReplacement
{
  Changeset$13(AttribPool paramAttribPool, List paramList) {}
  
  public String a(Matcher paramMatcher)
  {
    paramMatcher = this.a.a(Changeset.b(paramMatcher.group(1)));
    int i = 0;
    while (i < this.b.size())
    {
      Pair localPair = (Pair)this.b.get(i);
      if (((String)paramMatcher.first).equals(localPair.first))
      {
        if (((String)paramMatcher.second).compareTo((String)localPair.second) > 0) {
          break;
        }
        Utils.a(this.b, i, 1);
        break;
      }
      i += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.13
 * JD-Core Version:    0.7.0.1
 */