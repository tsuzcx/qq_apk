package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClass
  extends ReflectJavaElement
  implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass
{
  private final Class<?> klass;
  
  public ReflectJavaClass(@NotNull Class<?> paramClass)
  {
    this.klass = paramClass;
  }
  
  private final boolean isEnumValuesOrValueOf(Method paramMethod)
  {
    String str = paramMethod.getName();
    if (str != null)
    {
      int i = str.hashCode();
      if (i != -823812830)
      {
        if ((i == 231605032) && (str.equals("valueOf"))) {
          return Arrays.equals(paramMethod.getParameterTypes(), new Class[] { String.class });
        }
      }
      else if (str.equals("values"))
      {
        paramMethod = paramMethod.getParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(paramMethod, "method.parameterTypes");
        if (paramMethod.length == 0) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ReflectJavaClass)) && (Intrinsics.areEqual(this.klass, ((ReflectJavaClass)paramObject).klass));
  }
  
  @Nullable
  public ReflectJavaAnnotation findAnnotation(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, paramFqName);
  }
  
  @NotNull
  public List<ReflectJavaAnnotation> getAnnotations()
  {
    return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
  }
  
  @NotNull
  public List<ReflectJavaConstructor> getConstructors()
  {
    Constructor[] arrayOfConstructor = this.klass.getDeclaredConstructors();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfConstructor, "klass.declaredConstructors");
    return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(arrayOfConstructor), (Function1)ReflectJavaClass.constructors.1.INSTANCE), (Function1)ReflectJavaClass.constructors.2.INSTANCE));
  }
  
  @NotNull
  public Class<?> getElement()
  {
    return this.klass;
  }
  
  @NotNull
  public List<ReflectJavaField> getFields()
  {
    Field[] arrayOfField = this.klass.getDeclaredFields();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfField, "klass.declaredFields");
    return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence(arrayOfField), (Function1)ReflectJavaClass.fields.1.INSTANCE), (Function1)ReflectJavaClass.fields.2.INSTANCE));
  }
  
  @NotNull
  public FqName getFqName()
  {
    FqName localFqName = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "klass.classId.asSingleFqName()");
    return localFqName;
  }
  
  @NotNull
  public List<Name> getInnerClassNames()
  {
    Class[] arrayOfClass = this.klass.getDeclaredClasses();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "klass.declaredClasses");
    return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(ArraysKt.asSequence(arrayOfClass), (Function1)ReflectJavaClass.innerClassNames.1.INSTANCE), (Function1)ReflectJavaClass.innerClassNames.2.INSTANCE));
  }
  
  @Nullable
  public LightClassOriginKind getLightClassOriginKind()
  {
    return null;
  }
  
  @NotNull
  public List<ReflectJavaMethod> getMethods()
  {
    Method[] arrayOfMethod = this.klass.getDeclaredMethods();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfMethod, "klass.declaredMethods");
    return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(arrayOfMethod), (Function1)new ReflectJavaClass.methods.1(this)), (Function1)ReflectJavaClass.methods.2.INSTANCE));
  }
  
  public int getModifiers()
  {
    return this.klass.getModifiers();
  }
  
  @NotNull
  public Name getName()
  {
    Name localName = Name.identifier(this.klass.getSimpleName());
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(klass.simpleName)");
    return localName;
  }
  
  @Nullable
  public ReflectJavaClass getOuterClass()
  {
    Class localClass = this.klass.getDeclaringClass();
    if (localClass != null) {
      return new ReflectJavaClass(localClass);
    }
    return null;
  }
  
  @NotNull
  public Collection<JavaClassifierType> getSupertypes()
  {
    if (Intrinsics.areEqual(this.klass, Object.class)) {
      return (Collection)CollectionsKt.emptyList();
    }
    Object localObject2 = new SpreadBuilder(2);
    Object localObject1 = this.klass.getGenericSuperclass();
    if (localObject1 == null) {
      localObject1 = (Type)Object.class;
    }
    ((SpreadBuilder)localObject2).add(localObject1);
    localObject1 = this.klass.getGenericInterfaces();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "klass.genericInterfaces");
    ((SpreadBuilder)localObject2).addSpread(localObject1);
    localObject2 = (Iterable)CollectionsKt.listOf((Type[])((SpreadBuilder)localObject2).toArray(new Type[((SpreadBuilder)localObject2).size()]));
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new ReflectJavaClassifierType((Type)((Iterator)localObject2).next()));
    }
    return (Collection)localObject1;
  }
  
  @NotNull
  public List<ReflectJavaTypeParameter> getTypeParameters()
  {
    TypeVariable[] arrayOfTypeVariable = this.klass.getTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfTypeVariable, "klass.typeParameters");
    Collection localCollection = (Collection)new ArrayList(arrayOfTypeVariable.length);
    int j = arrayOfTypeVariable.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new ReflectJavaTypeParameter(arrayOfTypeVariable[i]));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
  }
  
  public boolean hasDefaultConstructor()
  {
    return false;
  }
  
  public int hashCode()
  {
    return this.klass.hashCode();
  }
  
  public boolean isAbstract()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
  }
  
  public boolean isAnnotationType()
  {
    return this.klass.isAnnotation();
  }
  
  public boolean isDeprecatedInJavaDoc()
  {
    return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
  }
  
  public boolean isEnum()
  {
    return this.klass.isEnum();
  }
  
  public boolean isFinal()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
  }
  
  public boolean isInterface()
  {
    return this.klass.isInterface();
  }
  
  public boolean isStatic()
  {
    return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.klass);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass
 * JD-Core Version:    0.7.0.1
 */