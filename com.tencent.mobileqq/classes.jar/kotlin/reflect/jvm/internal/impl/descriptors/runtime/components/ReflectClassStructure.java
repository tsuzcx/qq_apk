package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

final class ReflectClassStructure
{
  public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();
  
  private final ClassLiteralValue classLiteralValue(@NotNull Class<?> paramClass)
  {
    int i = 0;
    while (paramClass.isArray())
    {
      i += 1;
      paramClass = paramClass.getComponentType();
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "currentClass.componentType");
    }
    if (paramClass.isPrimitive())
    {
      if (Intrinsics.areEqual(paramClass, Void.TYPE))
      {
        paramClass = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.unit.toSafe());
        Intrinsics.checkExpressionValueIsNotNull(paramClass, "ClassId.topLevel(KotlinB…s.FQ_NAMES.unit.toSafe())");
        return new ClassLiteralValue(paramClass, i);
      }
      paramClass = JvmPrimitiveType.get(paramClass.getName());
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "JvmPrimitiveType.get(currentClass.name)");
      paramClass = paramClass.getPrimitiveType();
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "JvmPrimitiveType.get(cur…Class.name).primitiveType");
      if (i > 0)
      {
        paramClass = ClassId.topLevel(paramClass.getArrayTypeFqName());
        Intrinsics.checkExpressionValueIsNotNull(paramClass, "ClassId.topLevel(primitiveType.arrayTypeFqName)");
        return new ClassLiteralValue(paramClass, i - 1);
      }
      paramClass = ClassId.topLevel(paramClass.getTypeFqName());
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "ClassId.topLevel(primitiveType.typeFqName)");
      return new ClassLiteralValue(paramClass, i);
    }
    paramClass = ReflectClassUtilKt.getClassId(paramClass);
    Object localObject = JavaToKotlinClassMap.INSTANCE;
    FqName localFqName = paramClass.asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "javaClassId.asSingleFqName()");
    localObject = ((JavaToKotlinClassMap)localObject).mapJavaToKotlin(localFqName);
    if (localObject != null) {
      paramClass = (Class<?>)localObject;
    }
    return new ClassLiteralValue(paramClass, i);
  }
  
  private final void loadConstructorAnnotations(Class<?> paramClass, KotlinJvmBinaryClass.MemberVisitor paramMemberVisitor)
  {
    paramClass = paramClass.getDeclaredConstructors();
    int i = paramClass.length;
    int k = 0;
    while (k < i)
    {
      Object localObject4 = paramClass[k];
      Object localObject1 = Name.special("<init>");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Name.special(\"<init>\")");
      Object localObject2 = SignatureSerializer.INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "constructor");
      localObject2 = paramMemberVisitor.visitMethod((Name)localObject1, ((SignatureSerializer)localObject2).constructorDesc(localObject4));
      if (localObject2 != null)
      {
        localObject1 = localObject4.getDeclaredAnnotations();
        int m = localObject1.length;
        int j = 0;
        while (j < m)
        {
          localObject3 = localObject1[j];
          localObject5 = (KotlinJvmBinaryClass.AnnotationVisitor)localObject2;
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "annotation");
          processAnnotation((KotlinJvmBinaryClass.AnnotationVisitor)localObject5, (Annotation)localObject3);
          j += 1;
        }
        Object localObject3 = localObject4.getParameterAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "parameterAnnotations");
        Object localObject5 = (Object[])localObject3;
        if (localObject5.length == 0) {
          m = 1;
        } else {
          m = 0;
        }
        localObject1 = paramClass;
        j = i;
        if ((m ^ 0x1) != 0)
        {
          int n = localObject4.getParameterTypes().length - localObject5.length;
          int i1 = localObject3.length;
          m = 0;
          for (;;)
          {
            localObject1 = paramClass;
            j = i;
            if (m >= i1) {
              break;
            }
            localObject1 = localObject3[m];
            int i2 = localObject1.length;
            j = 0;
            while (j < i2)
            {
              localObject4 = localObject1[j];
              localObject5 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(localObject4));
              Object localObject6 = ReflectClassUtilKt.getClassId((Class)localObject5);
              Intrinsics.checkExpressionValueIsNotNull(localObject4, "annotation");
              localObject6 = ((KotlinJvmBinaryClass.MethodAnnotationVisitor)localObject2).visitParameterAnnotation(m + n, (ClassId)localObject6, (SourceElement)new ReflectAnnotationSource(localObject4));
              if (localObject6 != null) {
                INSTANCE.processAnnotationArguments((KotlinJvmBinaryClass.AnnotationArgumentVisitor)localObject6, localObject4, (Class)localObject5);
              }
              j += 1;
            }
            m += 1;
          }
        }
        paramClass = (Class<?>)localObject1;
        i = j;
        ((KotlinJvmBinaryClass.MethodAnnotationVisitor)localObject2).visitEnd();
      }
      k += 1;
    }
  }
  
  private final void loadFieldAnnotations(Class<?> paramClass, KotlinJvmBinaryClass.MemberVisitor paramMemberVisitor)
  {
    paramClass = paramClass.getDeclaredFields();
    int k = paramClass.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramClass[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "field");
      Object localObject1 = Name.identifier(((Field)localObject2).getName());
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Name.identifier(field.name)");
      localObject1 = paramMemberVisitor.visitField((Name)localObject1, SignatureSerializer.INSTANCE.fieldDesc((Field)localObject2), null);
      if (localObject1 != null)
      {
        localObject2 = ((Field)localObject2).getDeclaredAnnotations();
        int m = localObject2.length;
        int j = 0;
        while (j < m)
        {
          Object localObject3 = localObject2[j];
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "annotation");
          processAnnotation((KotlinJvmBinaryClass.AnnotationVisitor)localObject1, localObject3);
          j += 1;
        }
        ((KotlinJvmBinaryClass.AnnotationVisitor)localObject1).visitEnd();
      }
      i += 1;
    }
  }
  
  private final void loadMethodAnnotations(Class<?> paramClass, KotlinJvmBinaryClass.MemberVisitor paramMemberVisitor)
  {
    paramClass = paramClass.getDeclaredMethods();
    int m = paramClass.length;
    int i = 0;
    while (i < m)
    {
      Object localObject2 = paramClass[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "method");
      Object localObject1 = Name.identifier(((Method)localObject2).getName());
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Name.identifier(method.name)");
      localObject1 = paramMemberVisitor.visitMethod((Name)localObject1, SignatureSerializer.INSTANCE.methodDesc((Method)localObject2));
      if (localObject1 != null)
      {
        Annotation[] arrayOfAnnotation = ((Method)localObject2).getDeclaredAnnotations();
        int k = arrayOfAnnotation.length;
        int j = 0;
        Annotation localAnnotation;
        Object localObject3;
        while (j < k)
        {
          localAnnotation = arrayOfAnnotation[j];
          localObject3 = (KotlinJvmBinaryClass.AnnotationVisitor)localObject1;
          Intrinsics.checkExpressionValueIsNotNull(localAnnotation, "annotation");
          processAnnotation((KotlinJvmBinaryClass.AnnotationVisitor)localObject3, localAnnotation);
          j += 1;
        }
        localObject2 = ((Method)localObject2).getParameterAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "method.parameterAnnotations");
        int n = localObject2.length;
        j = 0;
        while (j < n)
        {
          arrayOfAnnotation = localObject2[j];
          int i1 = arrayOfAnnotation.length;
          k = 0;
          while (k < i1)
          {
            localAnnotation = arrayOfAnnotation[k];
            localObject3 = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(localAnnotation));
            Object localObject4 = ReflectClassUtilKt.getClassId((Class)localObject3);
            Intrinsics.checkExpressionValueIsNotNull(localAnnotation, "annotation");
            localObject4 = ((KotlinJvmBinaryClass.MethodAnnotationVisitor)localObject1).visitParameterAnnotation(j, (ClassId)localObject4, (SourceElement)new ReflectAnnotationSource(localAnnotation));
            if (localObject4 != null) {
              INSTANCE.processAnnotationArguments((KotlinJvmBinaryClass.AnnotationArgumentVisitor)localObject4, localAnnotation, (Class)localObject3);
            }
            k += 1;
          }
          j += 1;
        }
        ((KotlinJvmBinaryClass.MethodAnnotationVisitor)localObject1).visitEnd();
      }
      i += 1;
    }
  }
  
  private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor paramAnnotationVisitor, Annotation paramAnnotation)
  {
    Class localClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(paramAnnotation));
    paramAnnotationVisitor = paramAnnotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(localClass), (SourceElement)new ReflectAnnotationSource(paramAnnotation));
    if (paramAnnotationVisitor != null) {
      INSTANCE.processAnnotationArguments(paramAnnotationVisitor, paramAnnotation, localClass);
    }
  }
  
  private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor paramAnnotationArgumentVisitor, Name paramName, Object paramObject)
  {
    Object localObject = paramObject.getClass();
    if (Intrinsics.areEqual(localObject, Class.class))
    {
      if (paramObject != null)
      {
        paramAnnotationArgumentVisitor.visitClassLiteral(paramName, classLiteralValue((Class)paramObject));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
    }
    if (ReflectKotlinClassKt.access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p().contains(localObject))
    {
      paramAnnotationArgumentVisitor.visit(paramName, paramObject);
      return;
    }
    if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass((Class)localObject))
    {
      if (!((Class)localObject).isEnum()) {
        localObject = ((Class)localObject).getEnclosingClass();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
      localObject = ReflectClassUtilKt.getClassId((Class)localObject);
      if (paramObject != null)
      {
        paramObject = Name.identifier(((Enum)paramObject).name());
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "Name.identifier((value as Enum<*>).name)");
        paramAnnotationArgumentVisitor.visitEnum(paramName, (ClassId)localObject, paramObject);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
    }
    if (Annotation.class.isAssignableFrom((Class)localObject))
    {
      localObject = ((Class)localObject).getInterfaces();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "clazz.interfaces");
      localObject = (Class)ArraysKt.single((Object[])localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "annotationClass");
      paramAnnotationArgumentVisitor = paramAnnotationArgumentVisitor.visitAnnotation(paramName, ReflectClassUtilKt.getClassId((Class)localObject));
      if (paramAnnotationArgumentVisitor != null)
      {
        if (paramObject != null)
        {
          processAnnotationArguments(paramAnnotationArgumentVisitor, (Annotation)paramObject, (Class)localObject);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Annotation");
      }
      return;
    }
    if (((Class)localObject).isArray())
    {
      paramAnnotationArgumentVisitor = paramAnnotationArgumentVisitor.visitArray(paramName);
      if (paramAnnotationArgumentVisitor != null)
      {
        paramName = ((Class)localObject).getComponentType();
        Intrinsics.checkExpressionValueIsNotNull(paramName, "componentType");
        boolean bool = paramName.isEnum();
        int j = 0;
        int k = 0;
        int i = 0;
        if (bool)
        {
          paramName = ReflectClassUtilKt.getClassId(paramName);
          if (paramObject != null)
          {
            paramObject = (Object[])paramObject;
            j = paramObject.length;
            for (;;)
            {
              if (i >= j) {
                break label523;
              }
              localObject = paramObject[i];
              if (localObject == null) {
                break;
              }
              localObject = Name.identifier(((Enum)localObject).name());
              Intrinsics.checkExpressionValueIsNotNull(localObject, "Name.identifier((element as Enum<*>).name)");
              paramAnnotationArgumentVisitor.visitEnum(paramName, (Name)localObject);
              i += 1;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
        }
        if (Intrinsics.areEqual(paramName, Class.class))
        {
          if (paramObject != null)
          {
            paramName = (Object[])paramObject;
            k = paramName.length;
            i = j;
            for (;;)
            {
              if (i >= k) {
                break label523;
              }
              paramObject = paramName[i];
              if (paramObject == null) {
                break;
              }
              paramAnnotationArgumentVisitor.visitClassLiteral(classLiteralValue((Class)paramObject));
              i += 1;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
        }
        if (paramObject != null)
        {
          paramName = (Object[])paramObject;
          j = paramName.length;
          i = k;
          while (i < j)
          {
            paramAnnotationArgumentVisitor.visit(paramName[i]);
            i += 1;
          }
          label523:
          paramAnnotationArgumentVisitor.visitEnd();
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
      }
      return;
    }
    paramAnnotationArgumentVisitor = new StringBuilder();
    paramAnnotationArgumentVisitor.append("Unsupported annotation argument value (");
    paramAnnotationArgumentVisitor.append(localObject);
    paramAnnotationArgumentVisitor.append("): ");
    paramAnnotationArgumentVisitor.append(paramObject);
    paramAnnotationArgumentVisitor = (Throwable)new UnsupportedOperationException(paramAnnotationArgumentVisitor.toString());
    for (;;)
    {
      throw paramAnnotationArgumentVisitor;
    }
  }
  
  private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor paramAnnotationArgumentVisitor, Annotation paramAnnotation, Class<?> paramClass)
  {
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramClass[i];
      try
      {
        Object localObject1 = ((Method)localObject2).invoke(paramAnnotation, new Object[0]);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "method");
        localObject2 = Name.identifier(((Method)localObject2).getName());
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "Name.identifier(method.name)");
        processAnnotationArgumentValue(paramAnnotationArgumentVisitor, (Name)localObject2, localObject1);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label79:
        break label79;
      }
      i += 1;
    }
    paramAnnotationArgumentVisitor.visitEnd();
  }
  
  public final void loadClassAnnotations(@NotNull Class<?> paramClass, @NotNull KotlinJvmBinaryClass.AnnotationVisitor paramAnnotationVisitor)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    Intrinsics.checkParameterIsNotNull(paramAnnotationVisitor, "visitor");
    paramClass = paramClass.getDeclaredAnnotations();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject, "annotation");
      processAnnotation(paramAnnotationVisitor, localObject);
      i += 1;
    }
    paramAnnotationVisitor.visitEnd();
  }
  
  public final void visitMembers(@NotNull Class<?> paramClass, @NotNull KotlinJvmBinaryClass.MemberVisitor paramMemberVisitor)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    Intrinsics.checkParameterIsNotNull(paramMemberVisitor, "memberVisitor");
    loadMethodAnnotations(paramClass, paramMemberVisitor);
    loadConstructorAnnotations(paramClass, paramMemberVisitor);
    loadFieldAnnotations(paramClass, paramMemberVisitor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectClassStructure
 * JD-Core Version:    0.7.0.1
 */