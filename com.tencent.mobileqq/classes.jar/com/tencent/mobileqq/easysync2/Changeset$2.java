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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEasysync2AttribPool.a(Changeset.a(paramMatcher.group(1)));
    if (localObject != null)
    {
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        paramMatcher = (Pair)this.jdField_a_of_type_JavaUtilList.get(i);
        if (((String)paramMatcher.first).equals(((Pair)localObject).first))
        {
          if ((Utils.a((String)((Pair)localObject).second)) && (!this.jdField_a_of_type_Boolean))
          {
            Utils.a(this.jdField_a_of_type_JavaUtilList, i, 1);
          }
          else
          {
            paramMatcher = new Pair(paramMatcher.first, ((Pair)localObject).second);
            this.jdField_a_of_type_JavaUtilList.set(i, paramMatcher);
          }
          j = 1;
          break;
        }
        i += 1;
      }
      if ((j == 0) && ((!Utils.a((String)((Pair)localObject).second)) || (this.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      return "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can't find attribute: ");
    ((StringBuilder)localObject).append(paramMatcher.group(1));
    paramMatcher = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramMatcher;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.2
 * JD-Core Version:    0.7.0.1
 */