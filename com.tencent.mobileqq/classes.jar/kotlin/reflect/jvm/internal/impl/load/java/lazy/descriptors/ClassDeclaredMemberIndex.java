package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassDeclaredMemberIndex
  implements DeclaredMemberIndex
{
  private final Map<Name, JavaField> fields;
  @NotNull
  private final JavaClass jClass;
  private final Function1<JavaMember, Boolean> memberFilter;
  private final Function1<JavaMethod, Boolean> methodFilter;
  private final Map<Name, List<JavaMethod>> methods;
  
  public ClassDeclaredMemberIndex(@NotNull JavaClass paramJavaClass, @NotNull Function1<? super JavaMember, Boolean> paramFunction1)
  {
    this.jClass = paramJavaClass;
    this.memberFilter = paramFunction1;
    this.methodFilter = ((Function1)new ClassDeclaredMemberIndex.methodFilter.1(this));
    paramJavaClass = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getMethods()), this.methodFilter);
    Object localObject1 = (Map)new LinkedHashMap();
    Iterator localIterator = paramJavaClass.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Name localName = ((JavaMethod)localObject2).getName();
      paramFunction1 = ((Map)localObject1).get(localName);
      paramJavaClass = paramFunction1;
      if (paramFunction1 == null)
      {
        paramJavaClass = new ArrayList();
        ((Map)localObject1).put(localName, paramJavaClass);
      }
      ((List)paramJavaClass).add(localObject2);
    }
    this.methods = ((Map)localObject1);
    paramFunction1 = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getFields()), this.memberFilter);
    paramJavaClass = (Map)new LinkedHashMap();
    paramFunction1 = paramFunction1.iterator();
    while (paramFunction1.hasNext())
    {
      localObject1 = paramFunction1.next();
      paramJavaClass.put(((JavaField)localObject1).getName(), localObject1);
    }
    this.fields = paramJavaClass;
  }
  
  @Nullable
  public JavaField findFieldByName(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return (JavaField)this.fields.get(paramName);
  }
  
  @NotNull
  public Collection<JavaMethod> findMethodsByName(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    paramName = (List)this.methods.get(paramName);
    if (paramName == null) {
      paramName = CollectionsKt.emptyList();
    }
    return (Collection)paramName;
  }
  
  @NotNull
  public Set<Name> getFieldNames()
  {
    Object localObject = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getFields()), this.memberFilter);
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Sequence)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((JavaField)((Iterator)localObject).next()).getName());
    }
    return (Set)localCollection;
  }
  
  @NotNull
  public Set<Name> getMethodNames()
  {
    Object localObject = SequencesKt.filter(CollectionsKt.asSequence((Iterable)this.jClass.getMethods()), this.methodFilter);
    Collection localCollection = (Collection)new LinkedHashSet();
    localObject = ((Sequence)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((JavaMethod)((Iterator)localObject).next()).getName());
    }
    return (Set)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex
 * JD-Core Version:    0.7.0.1
 */