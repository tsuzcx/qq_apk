package com.tencent.mobileqq.easysync2;

import com.tencent.mobileqq.easysync2.utils.StringReplacement;
import com.tencent.mobileqq.easysync2.utils.Utils;
import com.tencent.util.Pair;
import java.util.List;
import java.util.regex.Matcher;

final class Changeset$2
  implements StringReplacement
{
  Changeset$2(AttribPool paramAttribPool, List paramList, boolean paramBoolean) {}
  
  public String a(Matcher paramMatcher)
  {
    int k = 0;
    Pair localPair = this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a(Changeset.a(paramMatcher.group(1)));
    if (localPair == null) {
      throw new IllegalArgumentException("can't find attribute: " + paramMatcher.group(1));
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramMatcher = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if (!((String)paramMatcher.first).equals(localPair.first)) {
          break label211;
        }
        if ((Utils.a((String)localPair.second)) && (!this.jdField_a_of_type_Boolean)) {
          break label198;
        }
        paramMatcher = new Pair(paramMatcher.first, localPair.second);
        this.jdField_a_of_type_JavaUtilList.set(i, paramMatcher);
      }
      for (;;)
      {
        j = 1;
        if ((j == 0) && ((!Utils.a((String)localPair.second)) || (this.jdField_a_of_type_Boolean))) {
          this.jdField_a_of_type_JavaUtilList.add(localPair);
        }
        return "";
        label198:
        Utils.a(this.jdField_a_of_type_JavaUtilList, i, 1);
      }
      label211:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.2
 * JD-Core Version:    0.7.0.1
 */