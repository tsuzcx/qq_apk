package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;

final class DFS$1
  extends DFS.AbstractNodeHandler<N, Boolean>
{
  DFS$1(Function1 paramFunction1, boolean[] paramArrayOfBoolean) {}
  
  public boolean beforeChildren(N paramN)
  {
    if (((Boolean)this.val$predicate.invoke(paramN)).booleanValue()) {
      this.val$result[0] = true;
    }
    return this.val$result[0] ^ 0x1;
  }
  
  public Boolean result()
  {
    return Boolean.valueOf(this.val$result[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.DFS.1
 * JD-Core Version:    0.7.0.1
 */