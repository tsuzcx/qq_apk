package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class Jsr305State$description$2
  extends Lambda
  implements Function0<String[]>
{
  Jsr305State$description$2(Jsr305State paramJsr305State)
  {
    super(0);
  }
  
  @NotNull
  public final String[] invoke()
  {
    Object localObject1 = (List)new ArrayList();
    ((List)localObject1).add(this.this$0.getGlobal().getDescription());
    Object localObject2 = this.this$0.getMigration();
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("under-migration:");
      ((StringBuilder)localObject3).append(((ReportLevel)localObject2).getDescription());
      ((List)localObject1).add(((StringBuilder)localObject3).toString());
    }
    localObject2 = this.this$0.getUser().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('@');
      localStringBuilder.append((String)((Map.Entry)localObject3).getKey());
      localStringBuilder.append(':');
      localStringBuilder.append(((ReportLevel)((Map.Entry)localObject3).getValue()).getDescription());
      ((List)localObject1).add(localStringBuilder.toString());
    }
    localObject1 = ((Collection)localObject1).toArray(new String[0]);
    if (localObject1 != null) {
      return (String[])localObject1;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.Jsr305State.description.2
 * JD-Core Version:    0.7.0.1
 */