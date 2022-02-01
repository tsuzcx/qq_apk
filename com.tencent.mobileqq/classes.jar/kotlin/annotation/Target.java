package kotlin.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/annotation/Target;", "", "allowedTargets", "", "Lkotlin/annotation/AnnotationTarget;", "()[Lkotlin/annotation/AnnotationTarget;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@MustBeDocumented
@Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS})
public @interface Target
{
  AnnotationTarget[] allowedTargets();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.annotation.Target
 * JD-Core Version:    0.7.0.1
 */