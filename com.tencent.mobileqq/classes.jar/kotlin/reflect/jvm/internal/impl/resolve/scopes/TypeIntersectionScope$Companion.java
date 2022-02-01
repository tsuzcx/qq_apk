package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class TypeIntersectionScope$Companion
{
  @JvmStatic
  @NotNull
  public final MemberScope create(@NotNull String paramString, @NotNull Collection<? extends KotlinType> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Intrinsics.checkParameterIsNotNull(paramCollection, "types");
    Object localObject = (Iterable)paramCollection;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((KotlinType)((Iterator)localObject).next()).getMemberScope());
    }
    paramString = new ChainedMemberScope(paramString, (List)localCollection);
    if (paramCollection.size() <= 1) {
      return (MemberScope)paramString;
    }
    return (MemberScope)new TypeIntersectionScope(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.Companion
 * JD-Core Version:    0.7.0.1
 */