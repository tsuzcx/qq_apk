package kotlin.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/annotation/Retention;", "", "value", "Lkotlin/annotation/AnnotationRetention;", "()Lkotlin/annotation/AnnotationRetention;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@Target(allowedTargets={AnnotationTarget.ANNOTATION_CLASS})
public @interface Retention
{
  AnnotationRetention value() default AnnotationRetention.RUNTIME;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.annotation.Retention
 * JD-Core Version:    0.7.0.1
 */