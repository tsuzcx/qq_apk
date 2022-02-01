package com.tencent.mobileqq.search;

import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class FunctionModuleConfigManager$2
  implements Comparator<GroupBaseNetSearchModelItem>
{
  FunctionModuleConfigManager$2(FunctionModuleConfigManager paramFunctionModuleConfigManager) {}
  
  public int a(GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem1, GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem2)
  {
    paramGroupBaseNetSearchModelItem1 = paramGroupBaseNetSearchModelItem1.c;
    paramGroupBaseNetSearchModelItem2 = paramGroupBaseNetSearchModelItem2.c;
    return ChnToSpell.b(paramGroupBaseNetSearchModelItem1, 2).compareTo(ChnToSpell.b(paramGroupBaseNetSearchModelItem2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.FunctionModuleConfigManager.2
 * JD-Core Version:    0.7.0.1
 */