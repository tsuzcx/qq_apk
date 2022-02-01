package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import org.jetbrains.annotations.NotNull;

final class LazyJavaPackageFragment$partToFacade$2
  extends Lambda
  implements Function0<HashMap<JvmClassName, JvmClassName>>
{
  LazyJavaPackageFragment$partToFacade$2(LazyJavaPackageFragment paramLazyJavaPackageFragment)
  {
    super(0);
  }
  
  @NotNull
  public final HashMap<JvmClassName, JvmClassName> invoke()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.this$0.getBinaryClasses$descriptors_jvm().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (KotlinJvmBinaryClass)((Map.Entry)localObject2).getValue();
      localObject1 = JvmClassName.byInternalName((String)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "JvmClassName.byInternalName(partInternalName)");
      Object localObject3 = ((KotlinJvmBinaryClass)localObject2).getClassHeader();
      localObject2 = ((KotlinClassHeader)localObject3).getKind();
      int i = LazyJavaPackageFragment.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()];
      if (i != 1)
      {
        if (i == 2) {
          ((Map)localHashMap).put(localObject1, localObject1);
        }
      }
      else
      {
        localObject2 = (Map)localHashMap;
        localObject3 = ((KotlinClassHeader)localObject3).getMultifileClassName();
        if (localObject3 != null)
        {
          localObject3 = JvmClassName.byInternalName((String)localObject3);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "JvmClassName.byInternalN…: continue@kotlinClasses)");
          ((Map)localObject2).put(localObject1, localObject3);
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.partToFacade.2
 * JD-Core Version:    0.7.0.1
 */