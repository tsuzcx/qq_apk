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
    paramMatcher = this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a(Changeset.a(paramMatcher.group(1)));
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!((String)paramMatcher.first).equals(localPair.first)) {
          break label95;
        }
        if (((String)paramMatcher.second).compareTo((String)localPair.second) <= 0) {
          Utils.a(this.jdField_a_of_type_JavaUtilList, i, 1);
        }
      }
      return "";
      label95:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.13
 * JD-Core Version:    0.7.0.1
 */