package com.tencent.mobileqq.search;

import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class FunctionModuleConfigManager$1
  implements Comparator<GroupBaseNetSearchModelItem>
{
  FunctionModuleConfigManager$1(FunctionModuleConfigManager paramFunctionModuleConfigManager) {}
  
  public int a(GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem1, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem2)
  {
    int i = paramGroupBaseNetSearchModelItem2.a[2] - paramGroupBaseNetSearchModelItem1.a[2];
    if (i != 0) {
      return i;
    }
    i = paramGroupBaseNetSearchModelItem1.a[0] - paramGroupBaseNetSearchModelItem2.a[0];
    if (i != 0) {
      return i;
    }
    paramGroupBaseNetSearchModelItem1 = paramGroupBaseNetSearchModelItem1.c.substring(paramGroupBaseNetSearchModelItem1.a[0] + paramGroupBaseNetSearchModelItem1.a[1]);
    paramGroupBaseNetSearchModelItem2 = paramGroupBaseNetSearchModelItem2.c.substring(paramGroupBaseNetSearchModelItem2.a[0] + paramGroupBaseNetSearchModelItem2.a[1]);
    return ChnToSpell.a(paramGroupBaseNetSearchModelItem1, 2).compareTo(ChnToSpell.a(paramGroupBaseNetSearchModelItem2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.FunctionModuleConfigManager.1
 * JD-Core Version:    0.7.0.1
 */