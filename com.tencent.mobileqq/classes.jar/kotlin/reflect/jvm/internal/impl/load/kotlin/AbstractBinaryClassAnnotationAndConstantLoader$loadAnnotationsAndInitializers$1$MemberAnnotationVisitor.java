package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$MemberAnnotationVisitor
  implements KotlinJvmBinaryClass.AnnotationVisitor
{
  private final ArrayList<A> result;
  @NotNull
  private final MemberSignature signature;
  
  public AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$MemberAnnotationVisitor(MemberSignature paramMemberSignature)
  {
    this.signature = localObject;
    this.result = new ArrayList();
  }
  
  @NotNull
  protected final MemberSignature getSignature()
  {
    return this.signature;
  }
  
  @Nullable
  public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId paramClassId, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, paramClassId, paramSourceElement, (List)this.result);
  }
  
  public void visitEnd()
  {
    if ((((Collection)this.result).isEmpty() ^ true)) {
      ((Map)this.this$0.$memberAnnotations).put(this.signature, this.result);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1.MemberAnnotationVisitor
 * JD-Core Version:    0.7.0.1
 */