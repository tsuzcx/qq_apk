package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$AnnotationVisitorForMethod
  extends AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1.MemberAnnotationVisitor
  implements KotlinJvmBinaryClass.MethodAnnotationVisitor
{
  public AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$AnnotationVisitorForMethod(MemberSignature paramMemberSignature)
  {
    super(paramMemberSignature, localObject);
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int paramInt, @NotNull ClassId paramClassId, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    MemberSignature localMemberSignature = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), paramInt);
    List localList2 = (List)this.this$0.$memberAnnotations.get(localMemberSignature);
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = (List)new ArrayList();
      ((Map)this.this$0.$memberAnnotations).put(localMemberSignature, localList1);
    }
    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, paramClassId, paramSourceElement, localList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1.AnnotationVisitorForMethod
 * JD-Core Version:    0.7.0.1
 */